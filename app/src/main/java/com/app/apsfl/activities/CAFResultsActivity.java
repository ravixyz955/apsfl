package com.app.apsfl.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.app.apsfl.R;
import com.app.apsfl.adapters.CAFResultAdapter;
import com.app.apsfl.application.BaseApplication;
import com.app.apsfl.fragments.CustomerAddressFragment;
import com.app.apsfl.httpClient.RequestHandler;
import com.app.apsfl.interfaces.ListSelectionInterface;
import com.app.apsfl.interfaces.ResponseHandler;
import com.app.apsfl.interfaces.UserActionInterface;
import com.app.apsfl.models.CAFResultModel;
import com.app.apsfl.models.CustomerAddressModel;
import com.app.apsfl.models.CustomerInfoModel;
import com.app.apsfl.models.EnterpriseCustomer;
import com.app.apsfl.models.FormSpinnerModel;
import com.app.apsfl.models.OfflineEditCafModel;
import com.app.apsfl.models.OfflineFormModel;
import com.app.apsfl.models.POPModel;
import com.app.apsfl.models.SICpeInfoModel;
import com.app.apsfl.models.SICustomerInfoModel;
import com.app.apsfl.models.SIOfflineFormModel;
import com.app.apsfl.utils.Constants;
import com.app.apsfl.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

import io.realm.Realm;
import io.realm.RealmResults;

public class CAFResultsActivity extends AppCompatActivity
        implements ResponseHandler, ListSelectionInterface, UserActionInterface {

    public static ArrayList<CAFResultModel> cafResultList;
    private final String TAG = "CAFResultsActivity";
    SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();
    Realm realm;
    private Toolbar mToolbar;
    private RecyclerView cafResultRecyclerView;
    private CAFResultAdapter cafResultAdapter;
    private String lmotype;
    private Button saveToofflineid;
    private int status;
    private boolean isContainsEditCafs = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_caf_results);
        initViews();
        setupToolBar();
        setupRecyclerView();
    }

    private void initViews() {
        realm = Realm.getDefaultInstance();
        mToolbar = (Toolbar) findViewById(R.id.toolBar);
        saveToofflineid = (Button) findViewById(R.id.saveToofflineid);
        cafResultRecyclerView = (RecyclerView) findViewById(R.id.cafResultsRecyclerView);
        if (getIntent() != null && getIntent().hasExtra("status")) {
            status = getIntent().getIntExtra("status", 0);
            Log.d("status", status + "");
            //noinspection unchecked
            //cafResultList = getIntent().getParcelableArrayListExtra("cafResults");
        }
        cafResultAdapter = new CAFResultAdapter(this, cafResultList);
        lmotype = sharedPreferences.getString(Constants.TENANT_TYPE, "");

        for (CAFResultModel model : cafResultList) {
            if (model.getEditCafStatus() != null && model.getEditCafStatus().equalsIgnoreCase("88")) {
                //Log.d("model.getEditCafStatus", model.getEditCafStatus());
                isContainsEditCafs = true;
            }
        }
        Log.d("model.getEditCafStatus", isContainsEditCafs + "");
        Log.d("status", status + "");
        if (isContainsEditCafs) {
            saveToofflineid.setVisibility(View.VISIBLE);
        } else {
            saveToofflineid.setVisibility(View.GONE);
        }

    }

    private void setupToolBar() {
        setSupportActionBar(mToolbar);
        ActionBar mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setupRecyclerView() {
        cafResultRecyclerView.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        cafResultRecyclerView.setAdapter(cafResultAdapter);
    }

    public void saveToOffline(View v) {
        final int resultSize = cafResultList.size();

        if (resultSize != 0) {

            for (int i = 0; i < resultSize; i++) {
                CAFResultModel cafResultModel = cafResultList.get(i);
                SIOfflineFormModel siOfflineFormModel = realm.where(SIOfflineFormModel.class).equalTo("apsflTrackId", cafResultModel.getApsflTrackID()).findFirst();
                if (siOfflineFormModel == null && cafResultModel.getEditCafStatus() != null && cafResultModel.getEditCafStatus().equalsIgnoreCase("88")) {
                    realm.beginTransaction();
                    try {
                        OfflineEditCafModel offlineEditCafModel = new OfflineEditCafModel();
                        offlineEditCafModel.setApsflTrackId(cafResultModel.getApsflTrackID());
                        offlineEditCafModel.setCafNo(cafResultModel.getCafNumber());
                        offlineEditCafModel.setCpeplace(cafResultModel.getCpeplace());
                        offlineEditCafModel.setOrganizationName(cafResultModel.getCustomerFirstName());
                        //offlineEditCafModel.setfName(cafResultModel.getCustomerFirstName());
                        offlineEditCafModel.setContactPersonName(cafResultModel.getContactPersonName());
                        offlineEditCafModel.setContactPersonMobileNo(cafResultModel.getContactPersonMobileNo());
                        offlineEditCafModel.setInstAddress1(cafResultModel.getAddress1());
                        offlineEditCafModel.setInstDistId(cafResultModel.getDistrictID());
                        offlineEditCafModel.setInstMandalId(cafResultModel.getMandalID());
                        offlineEditCafModel.setPackageNames(cafResultModel.getPackages());
                        offlineEditCafModel.setPopDistId(cafResultModel.getDistrictID());
                        offlineEditCafModel.setPopMandalId(cafResultModel.getMandalID());
                        offlineEditCafModel.setCoreServiceCodes(cafResultModel.getCoreSrvcCode());
                        offlineEditCafModel.setEntCustomerCode(cafResultModel.getAadhaarNumber());
                        offlineEditCafModel.setEntCustType(cafResultModel.getCustTypelov());
                        offlineEditCafModel.setCustId(cafResultModel.getCustID());
                        offlineEditCafModel.setBillCycle(cafResultModel.getBillCycle());
                        offlineEditCafModel.setIptvPackages(cafResultModel.getIptvPackages());

                        realm.copyToRealmOrUpdate(offlineEditCafModel);
                        realm.commitTransaction();
                    } catch (Exception e) {
                        Log.e(TAG, "Exception in save Search results" + e);
                        realm.cancelTransaction();
                    }
                }
            }
            Utils.showUserConfirmationDialog(this, null,
                    "CAF's Will be saved to Saved Offline CAFs", Constants.SAVE_IN_OFFLINE_CAFS);


        }

    }

    private void startPackageSelection() {
        Constants.isFromCAFResults = true;
        startActivity(new Intent(this, NewCAFActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        Constants.cafNumber = "";
        Constants.formTime = null;
        if (Constants.map != null && !Constants.map.isEmpty()) {
            Constants.map.clear();
        }
        super.onBackPressed();
    }

    private boolean isEnterprise(CAFResultModel resultModel) {
        boolean isValid = true;
        if (resultModel.isIndividualCustomer()) {
            isValid = true;
        } else {
            Realm realm = Realm.getDefaultInstance();
            EnterpriseCustomer enterpriseCustomer = realm.where(EnterpriseCustomer.class)
                    .equalTo("customerID", resultModel.getCustID()).findFirst();
            Log.d(TAG, "enterpriseCustomer customerID " + resultModel.getCustID());
            if (enterpriseCustomer != null) {
                RealmResults<EnterpriseCustomer> customerList = realm.where(EnterpriseCustomer.class).findAll();
                realm.beginTransaction();
                for (EnterpriseCustomer customer : customerList) {
                    if (customer.isCustomerChecked()) {
                        customer.setCustomerChecked(false);
                        break;
                    }
                }
                enterpriseCustomer.setCustomerChecked(true);
                isValid = true;
                realm.copyToRealmOrUpdate(enterpriseCustomer);
                realm.commitTransaction();
                realm.close();
            } else {
                Utils.showDialog(this, "No Data Found", "No data was found for the selected CAF", null);
                isValid = false;
            }
        }
        return isValid;
    }

    @Override
    public void onItemClicked(int viewType, int position) {
        final CAFResultModel resultModel = cafResultList.get(position);

        switch (resultModel.getStatus()) {
            case "PENDING FOR SELECT PACKAGES":
                if (lmotype.equals("SI") || isEnterprise(resultModel)) {
                    if (Constants.map != null && !Constants.map.isEmpty()) {
                        Constants.map.clear();
                    }
                    Constants.customerID = resultModel.getCustID();
                    if (resultModel.isIndividualCustomer()) {
                        Constants.cafType = 1;
                    } else {
                        Constants.cafType = 2;
                        if (!lmotype.equals("SI")) {
                            setEnterpriseCustomer();
                        }

                    }
                    Constants.pinCode = resultModel.getPinCode();
                    Constants.oltSerialNumber = resultModel.getOltSerialNumber();
                    Constants.oltPortNumber = resultModel.getOltPortNumber();
                    Constants.cafNumber = resultModel.getCafNumber();
                    Constants.billCycle = resultModel.getBillCycle() == null ? "MONTHLY"
                            : resultModel.getBillCycle();

                    Constants.formTime = System.currentTimeMillis();

                    Realm realm = Realm.getDefaultInstance();
                    try {
                        Log.d(TAG, "popID " + resultModel.getPopID());
                        CustomerInfoModel customerInfoModel = new CustomerInfoModel();
                        realm.beginTransaction();
                        customerInfoModel.setFormTime(Constants.formTime);
                        customerInfoModel.setCustomerAadhaarNumber(resultModel.getAadhaarNumber());
                        customerInfoModel.setCustomerFirstName(resultModel.getCustomerFirstName());
                        customerInfoModel.setCustomerLastName(resultModel.getCustomerLastName());
                        //customerInfoModel.setAllPackagesSILMO(resultModel.getAllPackages());
                        realm.copyToRealmOrUpdate(customerInfoModel);
                        realm.commitTransaction();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        realm.cancelTransaction();
                        realm.close();
                    }
                    switch (lmotype) {
                        case "LMO":
                            POPModel popModel = realm.where(POPModel.class).equalTo("popID", resultModel.getPopID()).findFirst();
                            if (popModel != null) {
                                realm.beginTransaction();
                                CustomerAddressModel model = new CustomerAddressModel();
                                model.setFormTime(Constants.formTime);
                                Log.d(TAG, "formTime " + Constants.formTime);
                                Log.d(TAG, "popName " + popModel.getPopName());
                                model.setPopID(resultModel.getPopID());
                                model.setCustomerAadhaarNumber(resultModel.getAadhaarNumber());
                                model.setPopName(popModel.getPopName());

                                realm.copyToRealmOrUpdate(model);
                                realm.commitTransaction();

                                realm.beginTransaction();
                                popModel.setPOPChecked(true);
                                realm.copyToRealmOrUpdate(popModel);
                                realm.commitTransaction();
                                realm.close();
                            }
                            break;
                        case "SI":
                            realm.beginTransaction();
                            CustomerAddressModel model = new CustomerAddressModel();
                            model.setFormTime(Constants.formTime);
                            model.setPopID(resultModel.getPopID());
                            model.setEntCustomerCode(resultModel.getCustID());
                            model.setEntCustType(resultModel.getCustTypelov());
                            model.setAddress1(resultModel.getAddress1());
                            model.setAddress2(resultModel.getAddress2());
                            model.setSIPhno(resultModel.getContactPersonMobileNo());
                            Log.d(TAG, "select pkg resultmodel " + resultModel.getPopName());
                            model.setPopName(resultModel.getPopName());
                            model.setApsflUniqueId(resultModel.getApsflTrackID());
                            model.setCpeplace(resultModel.getCpeplace());
                            realm.copyToRealmOrUpdate(model);
                            realm.commitTransaction();
                            realm.close();
                            break;

                    }

                    switch (Constants.billCycle) {
                        case "MONTHLY":
                            Constants.billFrequencyValue = 1;
                            break;
                        case "QUARTERLY":
                            Constants.billFrequencyValue = 3;
                            break;
                        case "HALFYEARLY":
                            Constants.billFrequencyValue = 6;
                            break;
                        case "YEARLY":
                            Constants.billFrequencyValue = 12;
                            break;
                    }
                    Constants.districtID = resultModel.getDistrictID();
                    Constants.villageID = resultModel.getVillageID();
                    Constants.mandalID = resultModel.getMandalID();
                    // Constants.isCAFInEditSILMO = false;
                    switch (viewType) {
                        case Constants.SELECT_PACKAGES:
                            //Load pop model if si lmo
                            if (lmotype.equals("SI")) {
                                Utils.showProgress(this, "Loading data....");
                                new RequestHandler().getSILMOMasterData2(this, null, resultModel.getPopID(), resultModel.getDistrictID(), resultModel.getMandalID(), resultModel.getVillageID(), Constants.GET_SILMOMASTERDATA);

                            } else {
                                Constants.isFromCAFResults = true;
                                startActivity(new Intent(this, NewCAFActivity.class));
                            }
                            // getCAFDetails(Constants.cafNumber);

                            break;

                        case Constants.PENDING_CAF_EDIT:
                            getCAFDetails(Constants.cafNumber, resultModel.getEditCafStatus());
                            break;

                    }
                }
                break;
            case "PENDING FOR CAF EDIT":
                //Fo siLMO
                switch (viewType) {
                    case Constants.PENDING_CAF_EDIT:

                        Constants.apsflTrackId = resultModel.getApsflTrackID();
                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                SICustomerInfoModel siCustomerInfoModel = realm.where(SICustomerInfoModel.class).equalTo("apsflTrackId", Constants.apsflTrackId).findFirst();
                                if (siCustomerInfoModel == null) {
                                    siCustomerInfoModel = realm.createObject(SICustomerInfoModel.class, resultModel.getApsflTrackID());
                                }
                                //siCustomerInfoModel.setApsflTrackId(offlineEditCafModel.getApsflTrackId());
                                siCustomerInfoModel.setCafNo(resultModel.getCafNumber());
                                siCustomerInfoModel.setOrganizationName(resultModel.getCustomerFirstName());
                                siCustomerInfoModel.setNameOfContactPersonName(resultModel.getContactPersonName());
                                siCustomerInfoModel.setNumberOfContactPerson(resultModel.getContactPersonMobileNo());
                                siCustomerInfoModel.setSelectedInstDistId(resultModel.getDistrictID());
                                siCustomerInfoModel.setInstAddress(resultModel.getAddress1());
                                siCustomerInfoModel.setCpeDeviceLocation(resultModel.getCpeplace());
                                siCustomerInfoModel.setSelectedInstMandalId(resultModel.getMandalID());
                                siCustomerInfoModel.setSelectedInstVillage("Select Installation Village");
                                //to send Json
                                siCustomerInfoModel.setEntCustomerCode(resultModel.getAadhaarNumber());
                                siCustomerInfoModel.setEntCustType(resultModel.getCustTypelov());
                                siCustomerInfoModel.setCustId(resultModel.getCustID());
                                siCustomerInfoModel.setBillCycle(resultModel.getBillCycle());
                                siCustomerInfoModel.setCoreSrvcCode(resultModel.getCoreSrvcCode());

                            }
                        });

                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                SICpeInfoModel cpeInfoModel = realm.where(SICpeInfoModel.class).equalTo("apsflTrackId", Constants.apsflTrackId).findFirst();
                                if (cpeInfoModel == null) {
                                    cpeInfoModel = realm.createObject(SICpeInfoModel.class, resultModel.getApsflTrackID());
                                }
                                // cpeInfoModel.setApsflTrackId(offlineEditCafModel.getApsflTrackId());
                                cpeInfoModel.setPackageDetails(resultModel.getPackages());
                                cpeInfoModel.setPopDistId(resultModel.getDistrictID());
                                cpeInfoModel.setPopMandalId(resultModel.getMandalID());
                                cpeInfoModel.setSelectedPop("Select to load POP");
                                cpeInfoModel.setOltIdPosition(0);
                                cpeInfoModel.setOltPortIdPosition(0);
                                cpeInfoModel.setOnuModelPosition(0);
                                cpeInfoModel.setIptvPosition(0);
                                cpeInfoModel.setVpnPosition(0);
                                cpeInfoModel.setIptvPackages(resultModel.getIptvPackages());

                            }
                        });
                        startActivity(new Intent(this, SICustomerInformation.class));

                        break;

                }
                break;
        }
    }

    private void storeCAFDetails(JSONObject data) {
        Realm realm = Realm.getDefaultInstance();
        try {
            CustomerInfoModel customerInfoModel = new CustomerInfoModel();
            realm.beginTransaction();
            customerInfoModel.setFormTime(Constants.formTime);
            customerInfoModel.setCustomerAadhaarNumber(data.getString("aadharno").equals("null") ? "" : data.getString("aadharno"));
            customerInfoModel.setCustomerFirstName(data.getString("fname").equals("null") ? "" : data.getString("fname"));
            customerInfoModel.setCustomerMiddleName(data.getString("mname").equals("null") ? "" : data.getString("mname"));
            customerInfoModel.setCustomerLastName(data.getString("lname").equals("null") ? "" : data.getString("lname"));
            customerInfoModel.setCustomerFatherName(data.getString("fhname").equals("null") ? "" : data.getString("fhname"));
            customerInfoModel.setCustomerDOB(data.getString("actualdob").equals("null") ? "" : data.getString("actualdob"));
            customerInfoModel.setCustomerGender(data.getString("gender").equals("M") ? 0 : 1);
            switch (lmotype) {

                case "LMO":
                    customerInfoModel.setCustomerEmail(data.getString("email1").equals("null") ? "" : data.getString("email1"));
                    customerInfoModel.setContactPersonName(data.getString("pocName").equals("null") ? "" : data.getString("pocName"));
                    break;
                case "SI":
                    customerInfoModel.setCustomerEmail(data.getString("contactPersonEmail").equals("null") ? "" : data.getString("contactPersonEmail"));
                    customerInfoModel.setContactPersonName(data.getString("contactPersonName").equals("null") ? "" : data.getString("contactPersonName"));
                    break;
            }
            customerInfoModel.setCustomerTitle(Arrays.asList(realm.where(FormSpinnerModel.class).findAll().get(0)
                    .getCustomerTitles().split(","))
                    .indexOf(data.getString("titlelov")));
            customerInfoModel.setBillFrequencyPosition(Arrays.asList(realm.where(FormSpinnerModel.class).findAll().get(0)
                    .getBillFrequencies().split(","))
                    .indexOf(data.getString("billfreqLov")));
            customerInfoModel.setBillCyclePosition(0);
            customerInfoModel.setSegmentPosition(0);
            customerInfoModel.setChannelPosition(0);
            customerInfoModel.setCustomerPAN("");
            customerInfoModel.setCustomerTAN("");
            customerInfoModel.setAllPackagesSILMO(Constants.Allpackages);
            customerInfoModel.setCafStatus(data.getString("cafStatus").equals("null") ? "" : data.getString("cafStatus"));
            customerInfoModel.setStatus("noedit");
            CustomerAddressModel customerAddressModel = realm.where(CustomerAddressModel.class).equalTo("formTime", Constants.formTime).findFirst();
            /*if (Constants.isCAFInEditSILMO) {
                customerAddressModel = new CustomerAddressModel();
                customerAddressModel.setFormTime(Constants.formTime);

            } else {
                customerAddressModel = realm.where(CustomerAddressModel.class).equalTo("formTime", Constants.formTime).findFirst();
            }*/
            customerAddressModel.setAddress1(data.getString("inst_addr1").equals("null") ? "" : data.getString("inst_addr1"));
            customerAddressModel.setAddress2(data.getString("inst_addr2").equals("null") ? "" : data.getString("inst_addr2"));
            customerAddressModel.setLocality(data.getString("inst_locality").equals("null") ? "" : data.getString("inst_locality"));
            customerAddressModel.setVillageID(data.getString("inst_city_village").equals("null") ? "" : data.getString("inst_city_village"));
            customerAddressModel.setMandalID(data.getString("inst_mandal").equals("null") ? "" : data.getString("inst_mandal"));
            customerAddressModel.setDistrictID(data.getString("inst_district").equals("null") ? "" : data.getString("inst_district"));
            customerAddressModel.setPinCode(data.getString("inst_pin").equals("null") ? "" : data.getString("inst_pin"));
            customerAddressModel.setMobile(data.getString("pocMob1").equals("null") ? "" : data.getString("pocMob1"));
            customerAddressModel.setMobile1(data.getString("pocMob2").equals("null") ? "" : data.getString("pocMob2"));
            customerAddressModel.setStdCode(data.getString("stdCode").equals("null") ? "" : data.getString("stdCode"));
            customerAddressModel.setLandLine(data.getString("landLine1").equals("null") ? "" : data.getString("landLine1"));
            customerAddressModel.setLatitude(data.getString("lattitude").equals("null") ? "" : data.getString("lattitude"));
            customerAddressModel.setLongitude(data.getString("longitude").equals("null") ? "" : data.getString("longitude"));
            customerAddressModel.setLocation(data.getString("cpeplace").equals("null") ? "" : data.getString("cpeplace"));
            customerAddressModel.setPopID(data.getString("popSubStnCode").equals("null") ? "" : data.getString("popSubStnCode"));
            customerAddressModel.setApsflUniqueId(data.getString("apsflUniqueId").equals("null") ? "" : data.getString("apsflUniqueId"));
            customerAddressModel.setStatus(data.getString("status"));
            switch (lmotype) {

                case "LMO":
                    customerAddressModel.setVillageName(data.getString("inst_city_villageName").equals("null") ? CustomerAddressFragment.NO_VILLAGE_SELECTED : data.getString("inst_city_villageName"));
                    customerAddressModel.setMandalName(data.getString("inst_mandalName").equals("null") ? CustomerAddressFragment.NO_MANDAL_SELECTED : data.getString("inst_mandalName"));
                    customerAddressModel.setDistrictName(data.getString("inst_districtName").equals("null") ? CustomerAddressFragment.NO_DISTRICT_SELECTED : data.getString("inst_districtName"));
                    customerAddressModel.setPopName(data.getString("popName").equals("null") ? CustomerAddressFragment.NO_POP_SELECTED : data.getString("popName"));
                    customerAddressModel.setPopID(data.getString("popSubStnCode").equals("null") ? CustomerAddressFragment.NO_POP_SELECTED : data.getString("popSubStnCode"));

                    break;
                case "SI":
                    customerAddressModel.setVillageName(data.getString("inst_city_villageName").equals("null") ? CustomerAddressFragment.NO_VILLAGE_SELECTED : data.getString("inst_city_villageName"));
                    customerAddressModel.setMandalName(data.getString("inst_mandalName").equals("null") ? "Click to select mandal" : data.getString("inst_mandalName"));
                    customerAddressModel.setDistrictName(data.getString("inst_districtName").equals("null") ? CustomerAddressFragment.NO_DISTRICT_SELECTED : data.getString("inst_districtName"));
                    customerAddressModel.setPopName(data.getString("popName").equals("null") ? CustomerAddressFragment.NO_POP_SELECTED : data.getString("popName"));
                    customerAddressModel.setPopmandal(data.getString("popMandalName").equals("null") ? "Click to select POP Mandal" : data.getString("popMandalName"));
                    customerAddressModel.setPopDistrict(data.getString("popDistrictName").equals("null") ? CustomerAddressFragment.NO_POP_SELECTED : data.getString("popDistrictName"));
                    customerAddressModel.setPopID(data.getString("popSubStnCode").equals("null") ? CustomerAddressFragment.NO_POP_SELECTED : data.getString("popSubStnCode"));
                    customerAddressModel.setPopMandalId(data.getString("popMandal").equals("null") ? "Click to select POP mandal" : data.getString("popMandal"));
                    customerAddressModel.setPopDistrictId(data.getString("popDistrict").equals("null") ? CustomerAddressFragment.NO_POP_SELECTED : data.getString("popDistrict"));
                    customerAddressModel.setSIName(data.getString("contactPersonName").equals("null") ? "" : data.getString("contactPersonName"));
                    customerAddressModel.setSIPhno(data.getString("contactPersonMobileNo").equals("null") ? "" : data.getString("contactPersonMobileNo"));
                    customerAddressModel.setSIEmail(data.getString("contactPersonEmail").equals("null") ? "" : data.getString("contactPersonEmail"));
                    customerAddressModel.setMobile(data.getString("contactPersonMobileNo").equals("null") ? "" : data.getString("contactPersonMobileNo"));
                    break;


            }
          /*  VillageModel model = realm.where(VillageModel.class)
                    .equalTo("villageSerialNumber", data.getString("inst_city_village"))
                    .equalTo("mandalSerialNumber", data.getString("inst_mandal")).equalTo("districtSerialNumber", data.getString("inst_district")).findFirst();
            if (model != null) {
                customerAddressModel.setVillageName(model.getVillageName());
                customerAddressModel.setMandalName(model.getMandalName());
                customerAddressModel.setDistrictName(model.getDistrictName());
            } else {
                if (lmotype.equals("SI")) {
                    customerAddressModel.setPopName(CustomerAddressFragment.NO_POP_SELECTED);
                    customerAddressModel.setPopmandal("Click to select POP Mandal");
                    customerAddressModel.setVillageName(CustomerAddressFragment.NO_VILLAGE_SELECTED);
                    customerAddressModel.setMandalName(CustomerAddressFragment.NO_MANDAL_SELECTED);
                    customerAddressModel.setDistrictName(CustomerAddressFragment.NO_DISTRICT_SELECTED);
                    customerAddressModel.setPopMandalId("Click to select POP mandal");
                    //customerAddressModel.setPopDistrict();
                }
            }*/

            //Todo
            //  customerAddressModel.setRegion(data.getString("region").equals("null") ? "" : data.getString("region"));
            // customerAddressModel.setPackages(data.getString("prodCode"));

            //realm.copyToRealmOrUpdate(customerInfoModel);
            realm.copyToRealmOrUpdate(customerInfoModel);
            realm.copyToRealmOrUpdate(customerAddressModel);
            realm.commitTransaction();
            realm.close();
            /*if (isSelectPackagesClicked) {
                startPackageSelection();
            } else {
                Constants.isCAFInEditMode = true;
                startActivity(new Intent(this, NewCAFActivity.class));
            }*/
            Constants.isCAFInEditMode = true;
            startActivity(new Intent(this, NewCAFActivity.class));
        } catch (JSONException ex) {
            ex.printStackTrace();
            realm.cancelTransaction();
            realm.close();
            Log.d("Exception in", "storeCAFDetails");
        }
    }

    private void setEnterpriseCustomer() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<EnterpriseCustomer> customerList = realm.where(EnterpriseCustomer.class).findAll();
        realm.beginTransaction();
        for (EnterpriseCustomer customer : customerList) {
            if (customer.isCustomerChecked()) {
                customer.setCustomerChecked(false);
                break;
            }
        }
        EnterpriseCustomer enterpriseCustomer = realm.where(EnterpriseCustomer.class)
                .equalTo("customerID", Constants.customerID).findFirst();
        if (enterpriseCustomer != null) {
            enterpriseCustomer.setCustomerChecked(true);
        }
        realm.copyToRealmOrUpdate(enterpriseCustomer);
        realm.commitTransaction();

    }

    private void getCAFDetails(String cafNumber, String editCafStatus) {
        if (Utils.isNetworkAvailable(this)) {
            Utils.showProgress(this, getString(R.string.processing_request));
            new RequestHandler().getCAFDetails(this, cafNumber, editCafStatus, Constants.GET_CAF_DETAILS);
        } else {
            Utils.showNoNetworkDialog(this);
        }
    }

    private void initializeOfflineModel() {

        //Creating new offline model
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        OfflineFormModel offlineFormModel = new OfflineFormModel();
        offlineFormModel.setFormTime(Constants.formTime);
        offlineFormModel.setCafType(Constants.cafType);
        offlineFormModel.setFormCAFData("");
        offlineFormModel.setFormPaymentData("");
        offlineFormModel.setFormUploaded(false);
        offlineFormModel.setIsPaymentDataAvailable(false);
        offlineFormModel.setCpeSerialNoUsed(false);
        offlineFormModel.setCafStatus("0");
        //creating otp
        int otp = (int) (Math.random() * 9000) + 1000;
        Log.d("OTP", "\t" + otp);
        offlineFormModel.setCafOTPNumber(String.valueOf(otp));
        realm.copyToRealmOrUpdate(offlineFormModel);
        realm.commitTransaction();
        realm.close();
    }

    @Override
    public void responseHandler(Object response, int requestType) {
        switch (requestType) {
            case Constants.GET_CAF_DETAILS:
                Utils.cancelProgress();
                if (response != null) {
                    JSONObject responseData = (JSONObject) response;
                    storeCAFDetails(responseData);
                } else {
                    Utils.showDialog(this, getString(R.string.request_failure_title),
                            getString(R.string.request_failure_message), null);
                }
                break;
            case Constants.GET_SILMOMASTERDATA:
                Utils.cancelProgress();
                Log.d(TAG, "IN GET_SILMOMASTERDATA");
                initializeOfflineModel();
                Constants.isFromCAFResults = true;
                startActivity(new Intent(this, SendOTPActivity.class));
                // startPackageSelection();
                break;
            case Constants.GET_SILMOPOPDATA:
                Utils.cancelProgress();
                //Todo
                // new RequestHandler().getRegion("","",resultModel.getPopID(),"");
                break;
        }
    }

    @Override
    public void onDialogConfirmed(int actionType) {
        switch (actionType) {
            case Constants.SAVE_IN_OFFLINE_CAFS:
                finish();
                //startActivity(new Intent(this,MainActivity.class));
                break;
        }
    }
}
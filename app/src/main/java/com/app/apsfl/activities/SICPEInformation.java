package com.app.apsfl.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.app.apsfl.R;
import com.app.apsfl.adapters.CPEModelSpinnerAdapter;
import com.app.apsfl.adapters.CustomSpinnerAdapter;
import com.app.apsfl.adapters.DistrictSpinnerAdapter;
import com.app.apsfl.adapters.OLTIDSpinnerAdapter;
import com.app.apsfl.adapters.OLTPortSpinnerAdapter;
import com.app.apsfl.adapters.VpnSpinnerAdapter;
import com.app.apsfl.application.BaseApplication;
import com.app.apsfl.interfaces.UserActionInterface;
import com.app.apsfl.models.CPEDataModel;
import com.app.apsfl.models.DistrictModel;
import com.app.apsfl.models.IptvDataModel;
import com.app.apsfl.models.IptvSIDataModel;
import com.app.apsfl.models.OfflineEditCafModel;
import com.app.apsfl.models.OltPortDetails;
import com.app.apsfl.models.POPOLTModel;
import com.app.apsfl.models.SICpeInfoModel;
import com.app.apsfl.models.SICustomerInfoModel;
import com.app.apsfl.models.SIOfflineFormModel;
import com.app.apsfl.models.VillageModel;
import com.app.apsfl.models.VpnServiceModel;
import com.app.apsfl.utils.Constants;
import com.app.apsfl.utils.FormValidations;
import com.app.apsfl.utils.Utils;

import org.json.JSONArray;
import org.json.JSONObject;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;
import io.realm.Sort;

public class SICPEInformation extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener, UserActionInterface {
    private Toolbar mToolbar;
    private TextView popMandal, selectedPOPName;
    private Spinner popDistrictSpinner, oltIDSpinner, oltPortIDSpinner, vpnServiceSpinner, telephonicConnCount;// onuModelSpinner,
    private EditText packages, formONUSerialNO;
    private Realm realm;
    private RealmList<DistrictModel> districtPopSpinnerItems;
    private String popDistId = "", popMandalId = "", popId = "";
    private LinearLayout previousScreenLayout, nextScreenLayout, formVpnLayout,
            ipTvLayout, formSTBLayout, stbWrapper, formtelephonicLayout;
    private RealmList<POPOLTModel> oltIDSpinnerItems;
    private RealmList<OltPortDetails> oltPortSpinnerItems;
    private RealmList<VpnServiceModel> vpnSpinnerItems;
    private OLTIDSpinnerAdapter oltIdSpinneradapter;
    private OLTPortSpinnerAdapter oltPortSpinnerAdapter;
    private RealmList<CPEDataModel> onuModelSpinnerItems, stbModelSpinnerItems;
    private Button addIptv, removeIptv;
    private JSONArray iptvBoxList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sicpeinformation);
        initViews();
        setupToolBar();
        setSpinnerData();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                registerListeners();
            }
        }, 500);
        setData();
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
        saveFormData();
        super.onBackPressed();

    }

    private void initViews() {
        realm = Realm.getDefaultInstance();
        mToolbar = (Toolbar) findViewById(R.id.toolBar);
        popMandal = (TextView) findViewById(R.id.popMandal);
        selectedPOPName = (TextView) findViewById(R.id.selectedPOPName);

        popDistrictSpinner = (Spinner) findViewById(R.id.popDistrictSpinner);
        oltIDSpinner = (Spinner) findViewById(R.id.oltIDSpinner);
        oltPortIDSpinner = (Spinner) findViewById(R.id.oltPortIDSpinner);
        //onuModelSpinner = (Spinner) findViewById(R.id.cpeModelSpinner);
        // iptvModelSpinner = (Spinner) findViewById(R.id.cpeSTBModelSpinner);
        vpnServiceSpinner = (Spinner) findViewById(R.id.vpnServiceSpinner);

        packages = (EditText) findViewById(R.id.packages);
        formONUSerialNO = (EditText) findViewById(R.id.formONUSerialNO);
        //formIPTVSerialNoEditText = (EditText) findViewById(R.id.formIPTVSerialNoEditText);
        districtPopSpinnerItems = new RealmList<>();
        oltIDSpinnerItems = new RealmList<>();
        oltPortSpinnerItems = new RealmList<>();
        onuModelSpinnerItems = new RealmList<>();
        stbModelSpinnerItems = new RealmList<>();
        vpnSpinnerItems = new RealmList<>();

        LinearLayout screenLayout = (LinearLayout) findViewById(R.id.previousNextLayout);
        previousScreenLayout = (LinearLayout) screenLayout.findViewById(R.id.previousScreenLayout);
        nextScreenLayout = (LinearLayout) screenLayout.findViewById(R.id.nextScreenLayout);
        TextView previousScreenName = (TextView) previousScreenLayout.findViewById(R.id.previousScreenName);
        TextView nextScreenName = (TextView) nextScreenLayout.findViewById(R.id.nextScreenName);
        TextView nextScreenHeader = (TextView) nextScreenLayout.findViewById(R.id.nextScreenHeader);
        previousScreenName.setText("Customer Info");
        nextScreenHeader.setText("Submit CAF");

        addIptv = (Button) findViewById(R.id.add_iptv);
        removeIptv = (Button) findViewById(R.id.remove_iptv);

        //ipTvLayout = (LinearLayout) findViewById(R.id.ipTvLayout);
        formVpnLayout = (LinearLayout) findViewById(R.id.formVpnLayout);
        formtelephonicLayout = (LinearLayout) findViewById(R.id.formtelephonicLayout);
        telephonicConnCount = (Spinner) findViewById(R.id.telephonicConnCount);
        formSTBLayout = (LinearLayout) findViewById(R.id.formSTBLayout);
        stbWrapper = (LinearLayout) findViewById(R.id.stbWrapper);
        //formSTBLayout.setVisibility(View.GONE);

        checkForIpTvAndVpnVisibility();
    }

    private void setupToolBar() {
        setSupportActionBar(mToolbar);
        ActionBar mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setSpinnerData() {

        Realm realm = Realm.getDefaultInstance();
        districtPopSpinnerItems.clear();
        DistrictModel districtModel = new DistrictModel();
        districtModel.setDistrictID("");
        districtModel.setDistrictName("--Select--");
        districtPopSpinnerItems.add(districtModel);
        districtPopSpinnerItems.addAll(realm.where(DistrictModel.class).findAll());
        DistrictSpinnerAdapter districtSpinnerAdapter = new DistrictSpinnerAdapter(this, districtPopSpinnerItems);
        popDistrictSpinner.setAdapter(districtSpinnerAdapter);


       /* oltIDSpinnerItems = new RealmList<>();
        POPOLTModel popOltModel = new POPOLTModel();
        popOltModel.setPopOLTID("-1");
        popOltModel.setPopID("");
        popOltModel.setPopName("");
        popOltModel.setPopOLTSerialNumber("");
        popOltModel.setPopLabelNumber("--Select--");
        oltIDSpinnerItems.add(popOltModel);
        oltIdSpinneradapter = new OLTIDSpinnerAdapter(this, oltIDSpinnerItems);
        oltIDSpinner.setAdapter(oltIdSpinneradapter);
*/

       /* OltPortDetails oltPortDataModel = new OltPortDetails();
        oltPortDataModel.setPortNo("--Select--");
        oltPortDataModel.setPopIdPortNo("-1");
        oltPortDataModel.setPopId("");
        oltPortSpinnerItems.clear();
        oltPortSpinnerItems.add(oltPortDataModel);
        OLTPortSpinnerAdapter oltPortSpinnerAdapter = new OLTPortSpinnerAdapter(this, oltPortSpinnerItems);
        oltPortIDSpinner.setAdapter(oltPortSpinnerAdapter);*/


        onuModelSpinnerItems.clear();
        CPEDataModel onuDataModel = new CPEDataModel();
        onuDataModel.setCpeProfileID(-1);
        onuDataModel.setCpeModelName("--Select--");
        onuDataModel.setCpeProfileName(null);
        onuDataModel.setCpeModelDetails(null);
        onuDataModel.setCpePurchaseCost(null);
        onuDataModel.setCpeRentalCost(null);
        onuDataModel.setCpeInstallationCost(null);
        onuModelSpinnerItems.add(onuDataModel);
        onuModelSpinnerItems.addAll(realm.where(CPEDataModel.class).equalTo("cpeLovType", "ONU").findAll());
        CPEModelSpinnerAdapter onuModelSpinnerAdapter = new CPEModelSpinnerAdapter(this, onuModelSpinnerItems);
       // onuModelSpinner.setAdapter(onuModelSpinnerAdapter);

       /* stbModelSpinnerItems.clear();
        CPEDataModel stbDataModel = new CPEDataModel();
        stbDataModel.setCpeProfileID(-1);
        stbDataModel.setCpeModelName("--Select--");
        stbDataModel.setCpeProfileName(null);
        stbDataModel.setCpeModelDetails(null);
        stbDataModel.setCpePurchaseCost(null);
        stbDataModel.setCpeRentalCost(null);
        stbDataModel.setCpeInstallationCost(null);
        stbModelSpinnerItems.add(stbDataModel);
        stbModelSpinnerItems.addAll(realm.where(CPEDataModel.class).equalTo("cpeLovType", "IPTV/Android Box").findAll());
        CPEModelSpinnerAdapter stbModelSpinnerAdapter = new CPEModelSpinnerAdapter(this, stbModelSpinnerItems);
        iptvModelSpinner.setAdapter(stbModelSpinnerAdapter);*/
    }

    private void setStbSpinner(Spinner spinner) {
        Realm realm = Realm.getDefaultInstance();
        switch (spinner.getId()) {
            case R.id.cpeSTBModelSpinner:
                stbModelSpinnerItems.clear();
                CPEDataModel stbDataModel = new CPEDataModel();
                stbDataModel.setCpeProfileID(-1);
                stbDataModel.setCpeModelName("--Select--");
                stbDataModel.setCpeProfileName(null);
                stbDataModel.setCpeModelDetails(null);
                stbDataModel.setCpePurchaseCost(null);
                stbDataModel.setCpeRentalCost(null);
                stbDataModel.setCpeInstallationCost(null);
                stbModelSpinnerItems.add(stbDataModel);
                stbModelSpinnerItems.addAll(realm.where(CPEDataModel.class).equalTo("cpeLovType", "IPTV/Android Box").findAll());
                CPEModelSpinnerAdapter stbModelSpinnerAdapter = new CPEModelSpinnerAdapter(this, stbModelSpinnerItems);
                spinner.setAdapter(stbModelSpinnerAdapter);
                break;

        }

    }

    private void registerListeners() {
        nextScreenLayout.setOnClickListener(this);
        previousScreenLayout.setOnClickListener(this);
        addIptv.setOnClickListener(this);
        removeIptv.setOnClickListener(this);
        popMandal.setOnClickListener(this);
        selectedPOPName.setOnClickListener(this);
        popDistrictSpinner.setOnItemSelectedListener(this);
        oltIDSpinner.setOnItemSelectedListener(this);
        oltPortIDSpinner.setOnItemSelectedListener(this);
       // onuModelSpinner.setOnItemSelectedListener(this);
        //iptvModelSpinner.setOnItemSelectedListener(this);
        vpnServiceSpinner.setOnItemSelectedListener(this);
        telephonicConnCount.setOnItemSelectedListener(this);
    }

    private void checkForIpTvAndVpnVisibility() {
        SICustomerInfoModel siCustomerInfoModel = realm.where(SICustomerInfoModel.class).equalTo("apsflTrackId", Constants.apsflTrackId).findFirst();
        String coreServices = siCustomerInfoModel.getCoreSrvcCode();
        if (coreServices.contains("IPTV")) {
            formSTBLayout.setVisibility(View.VISIBLE);
            int iptvLayoutSize=realm.where(IptvSIDataModel.class).equalTo("apsflTrackId", Constants.apsflTrackId).findAll().size();
          if(iptvLayoutSize == 0){
              constructIptvLayout();
          }
        } else {
            formSTBLayout.setVisibility(View.GONE);
        }
        if (coreServices.contains("VPN")) {
            formVpnLayout.setVisibility(View.VISIBLE);
        } else {
            formVpnLayout.setVisibility(View.GONE);

        }
        if (coreServices.contains("VOIP")) {
            formtelephonicLayout.setVisibility(View.VISIBLE);
        } else {
            formtelephonicLayout.setVisibility(View.GONE);

        }
    }

    private void setData() {
        SICpeInfoModel cpeInfoModel = realm.where(SICpeInfoModel.class).equalTo("apsflTrackId", Constants.apsflTrackId).findFirst();
        if (cpeInfoModel != null) {
            popDistId = cpeInfoModel.getPopDistId();
            popMandalId = cpeInfoModel.getPopMandalId();
            popId = cpeInfoModel.getPopId();
            // popDistrictSpinner.setSelection();
            loadOltIDData(cpeInfoModel.getOltIdPosition());
            loadOltPortIDData(cpeInfoModel.getOltIdPosition(), cpeInfoModel.getOltPortIdPosition());
            loadVpnData(cpeInfoModel.getOltIdPosition(), cpeInfoModel.getVpnPosition());
            loadTelephoneConne(cpeInfoModel.getTeleConnCountPosition());
            //oltIDSpinner.setSelection(cpeInfoModel.getOltIdPosition());
            //oltPortIDSpinner.setSelection(cpeInfoModel.getOltPortIdPosition());
            //onuModelSpinner.setSelection(cpeInfoModel.getOnuModelPosition());
            //iptvModelSpinner.setSelection(cpeInfoModel.getIptvPosition());
            // vpnServiceSpinner.setSelection(cpeInfoModel.getVpnPosition());

            //popMandal.setText(cpeInfoModel.getSelectedPopMandal());
            //selectedPOPName.setText(cpeInfoModel.getSelectedPop());

            packages.setText(cpeInfoModel.getPackageDetails());
            formONUSerialNO.setText(cpeInfoModel.getOnuSerialNumber());
            //formIPTVSerialNoEditText.setText(cpeInfoModel.getIptvSerialNumber());

            DistrictModel districtModel = realm.where(DistrictModel.class).equalTo("districtID", popDistId).findFirst();
            if (districtModel != null) {
                popDistrictSpinner.setSelection(districtPopSpinnerItems.indexOf(districtModel));
            }
            VillageModel villageModel = realm.where(VillageModel.class).equalTo("districtSerialNumber", popDistId).equalTo("mandalSerialNumber", popMandalId).findFirst();
            if (villageModel != null) {
                popMandal.setText(villageModel.getMandalName());
            }
            selectedPOPName.setText(cpeInfoModel.getSelectedPop());
            setStbData(cpeInfoModel);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.popMandal:
                Intent intent = new Intent(this, SelectMandalActivity.class);
                intent.putExtra("districtID", popDistId);
                startActivityForResult(intent, 1001);
                break;
            case R.id.selectedPOPName:
                Intent intent1 = new Intent(this, SelectSIPOPActivity.class);
                intent1.putExtra("districtID", popDistId);
                intent1.putExtra("mandalID", popMandalId);
                startActivityForResult(intent1, 1002);
                break;
            case R.id.nextScreenLayout:
                if (validateFormFields()) {
                    saveFormData();
                    createOTP();
                    Realm realm = Realm.getDefaultInstance();
                    realm.beginTransaction();
                    OfflineEditCafModel offlineEditCafModel = realm.where(OfflineEditCafModel.class).equalTo("apsflTrackId", Constants.apsflTrackId).findFirst();
                    if (offlineEditCafModel != null) {
                        offlineEditCafModel.deleteFromRealm();
                    }
                    realm.commitTransaction();
                    realm.close();
                    SIOfflineFormModel offlineFormModel = realm.where(SIOfflineFormModel.class)
                            .equalTo("apsflTrackId", Constants.apsflTrackId).findFirst();
                    if (offlineFormModel.getNetworkAvailble().equals(true)) {
                        startActivity(new Intent(this, SendOTPActivity.class));
                        //submitCAFForm(getCAFFormDataAsJSON());
                    } else {
                        updateStatusMessage("Unable to Send OTP");
                        Utils.showDialog(this,
                                "Unable to Send OTP",
                                " Please try submitting CAF when internet is available from Resubmit CAFs", Constants.PAYMENT_FAILURE);

                    }

                }

                break;
            case R.id.previousScreenLayout:
                //saveFormData();
                onBackPressed();
                break;

            case R.id.add_iptv:
                constructIptvLayout();
                break;
            case R.id.remove_iptv:
                //Size start from "0" and index start from -1
                final int childSize = stbWrapper.getChildCount();
                if (childSize > 1) {
                    //removing view
                    stbWrapper.removeViewAt(childSize - 1);
                    //removing realm object
                    Realm realm = Realm.getDefaultInstance();
                    final SICpeInfoModel cpeInfoModel = realm.where(SICpeInfoModel.class).equalTo("apsflTrackId", Constants.apsflTrackId).findFirst();
                    final IptvSIDataModel iptvDataModel = realm.where(IptvSIDataModel.class)
                            .equalTo("iptvposition", childSize - 1).equalTo("apsflTrackId", Constants.apsflTrackId)
                            .findFirst();
                    if (cpeInfoModel != null && cpeInfoModel.getSelectedIptvList().size() > 0) {
                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                cpeInfoModel.getSelectedIptvList().remove(iptvDataModel);
                                if (iptvDataModel != null) {
                                    realm.where(IptvSIDataModel.class)
                                            .equalTo("iptvposition", childSize - 1).equalTo("apsflTrackId", Constants.apsflTrackId)
                                            .findFirst().deleteFromRealm();
                                }
                            }
                        });
                    }
                }

                break;
        }
    }

    private void setStbData(SICpeInfoModel cpeInfoModel) {

        //Set Iptv data

        RealmList<IptvSIDataModel> stbList = cpeInfoModel.getSelectedIptvList();
        Log.d("setStbData", stbList.size() + "");
        for (IptvSIDataModel iptvDataModel : stbList) {
            //final Spinner cpeSTBSpinner;
            //final TextView iptvPackage, iptvPackageHeader;
            final EditText formIPTVSerialNumber;
            final LinearLayout formIPTVLayout;

            int stbChildSize = stbList.indexOf(iptvDataModel);
            LayoutInflater layoutInflater = LayoutInflater.from(this);
            LinearLayout iptvLayout = (LinearLayout) layoutInflater.inflate(R.layout.layout_iptv_si, null);
            //cpeSTBSpinner = (Spinner) iptvLayout.findViewById(R.id.cpeSTBModelSpinner);
           // setStbSpinner(cpeSTBSpinner);
            formIPTVLayout = (LinearLayout) iptvLayout.findViewById(R.id.formIPTVLayout);
            formIPTVSerialNumber = (EditText) iptvLayout.findViewById(R.id.formIPTVSerialNoEditText);

            //cpeSTBSpinner.setTag(stbChildSize);
            formIPTVLayout.setTag(stbChildSize);
            formIPTVSerialNumber.setTag(stbChildSize);


           // cpeSTBSpinner.setSelection(iptvDataModel.getStbModelPosition());

            formIPTVSerialNumber.setText(iptvDataModel.getIpTVSerialNumber());
            // iptvPackage.setText(iptvDataModel.getIptvPkg());

           /* cpeSTBSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    CPEDataModel cpeDataModel;
                    if (position > 0) {
                        cpeDataModel = stbModelSpinnerItems.get(position);
                        if (cpeDataModel.getCpeProfileID() != -1) {

                        }
                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });*/

            stbWrapper.addView(iptvLayout);
        }

    }

    private void constructIptvLayout() {

       // final Spinner cpeSTBSpinner, cpeSTBPurchaseSpinner;
        final EditText formIPTVPrice, formIPTVInstallments, formIPTVSerialNumber, formIPTVMacAddress;
        final LinearLayout formIPTVLayout, formIfSTBLeaseLayout;

        int stbChildSize = stbWrapper.getChildCount() + 1;
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        LinearLayout iptvLayout = (LinearLayout) layoutInflater.inflate(R.layout.layout_iptv_si, null);
       // cpeSTBSpinner = (Spinner) iptvLayout.findViewById(R.id.cpeSTBModelSpinner);
       // setStbSpinner(cpeSTBSpinner);

        formIPTVLayout = (LinearLayout) iptvLayout.findViewById(R.id.formIPTVLayout);

        formIPTVSerialNumber = (EditText) iptvLayout.findViewById(R.id.formIPTVSerialNoEditText);


        //cpeSTBSpinner.setTag(stbChildSize);
        formIPTVLayout.setTag(stbChildSize);
        formIPTVSerialNumber.setTag(stbChildSize);

       /* cpeSTBSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CPEDataModel cpeDataModel;
                if (position > 0) {
                    cpeDataModel = stbModelSpinnerItems.get(position);
                    if (cpeDataModel.getCpeProfileID() != -1) {

                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
*/

        stbWrapper.addView(iptvLayout);


    }

    private void createOTP() {

        SIOfflineFormModel offlineFormModel = realm.where(SIOfflineFormModel.class)
                .equalTo("apsflTrackId", Constants.apsflTrackId).findFirst();
        realm.beginTransaction();
        int otp = (int) (Math.random() * 9000) + 1000;
        Log.d("OTP", "\t" + otp);
        offlineFormModel.setCafOTPNumber(String.valueOf(otp));
        if (Utils.isNetworkAvailable(this)) {
            offlineFormModel.setNetworkAvailble(true);
        } else {
            offlineFormModel.setNetworkAvailble(false);
        }
        offlineFormModel.setFormUploaded(false);
        realm.copyToRealmOrUpdate(offlineFormModel);
        realm.commitTransaction();

    }

    private void saveFormData() {
        SICpeInfoModel cpeInfoModel = realm.where(SICpeInfoModel.class).equalTo("apsflTrackId", Constants.apsflTrackId).findFirst();
        try {
            realm.beginTransaction();
            cpeInfoModel.setPopDistId(popDistId);
            cpeInfoModel.setPopMandalId(popMandalId);
            cpeInfoModel.setSelectedPopMandal(popMandal.getText().toString());
            cpeInfoModel.setPopId(popId);
            cpeInfoModel.setSelectedPop(selectedPOPName.getText().toString());
            cpeInfoModel.setOltIdPosition(oltIDSpinner.getSelectedItemPosition());
            cpeInfoModel.setOltPortIdPosition(oltPortIDSpinner.getSelectedItemPosition());
           // cpeInfoModel.setOnuModelPosition(onuModelSpinner.getSelectedItemPosition());
            cpeInfoModel.setOnuSerialNumber(formONUSerialNO.getText().toString());
            //cpeInfoModel.setIptvPosition(iptvModelSpinner.getSelectedItemPosition());
            // cpeInfoModel.setIptvSerialNumber(formIPTVSerialNoEditText.getText().toString());
            cpeInfoModel.setVpnPosition(vpnServiceSpinner.getSelectedItemPosition());
            cpeInfoModel.setTeleConnCountPosition(telephonicConnCount.getSelectedItemPosition());

            //Saving Iptv data
            iptvBoxList = new JSONArray();
            JSONObject iptvBox;
            int ipTvChaildCount = stbWrapper.getChildCount();
            if (ipTvChaildCount != 0) {
                for (int i = 0; i < ipTvChaildCount; i++) {
                    Log.d("stbWrapper ChildCount", stbWrapper.getChildCount() + "");
                    Log.d("stbWrapper i", i + "");
                    LinearLayout iptvLayout = (LinearLayout) stbWrapper.getChildAt(i);
                    Log.d("iptvLayout ChildCount", iptvLayout.getChildCount() + "");
                    Log.d("iptvLayout", iptvLayout.getTag().toString());
                    IptvSIDataModel iptvDataModel = realm.where(IptvSIDataModel.class)
                            .equalTo("iptvposition", i).equalTo("apsflTrackId", Constants.apsflTrackId)
                            .findFirst();
                    if (iptvDataModel == null) {
                        iptvDataModel = new IptvSIDataModel();
                        iptvDataModel.setIptvpositionApsflTrackId(i + " " + Constants.apsflTrackId);
                        iptvDataModel.setIptvposition(i);
                        iptvDataModel.setApsflTrackId(Constants.apsflTrackId);
                    }
                   /* View stbModelSpinnerView = iptvLayout.getChildAt(1);
                    Spinner stbModelSpinner = (Spinner) stbModelSpinnerView;
                    //Object tag = stbModelSpinner.getTag();
                    int position = stbModelSpinner.getSelectedItemPosition();
                    iptvDataModel.setStbModelPosition(stbModelSpinner.getSelectedItemPosition());
                    if (stbModelSpinner.getSelectedItemPosition() > 0) {
                        // iptvDataModel.setSelectedSTBDataModel(stbModelSpinnerItems.get(stbModelSpinner.getSelectedItemPosition()));
                        iptvDataModel.setIptvBoxModel(stbModelSpinnerItems.get(stbModelSpinner.getSelectedItemPosition()).getCpeModelName());
                    }
                    String stdmodelValue = String.valueOf(stbModelSpinnerItems.get(stbModelSpinner.getSelectedItemPosition()).getCpeProfileID());
*/
                    View formIPTVSerialNoEditTextView = iptvLayout.getChildAt(1);
                    EditText formIPTVSerialNoEditText = (EditText) formIPTVSerialNoEditTextView;
                    iptvDataModel.setIpTVSerialNumber(formIPTVSerialNoEditText.getText().toString());
                    realm.copyToRealmOrUpdate(iptvDataModel);
                    // stbList.add(iptvDataModel);
                    iptvBox = new JSONObject();
                    // formData.put("stbSrlNo", "");//formIPTVSerialNumber.getText().toString()
                    /*if (stdmodelValue.equals("-1")) {
                        iptvBox.put("stbModel", "NA");
                    } else {
                        iptvBox.put("stbModel", stdmodelValue);
                    }*/
                    iptvBox.put("stbSerialNo", formIPTVSerialNoEditText.getText().toString());
                    iptvBox.put("stbLease", "Y");
                    iptvBox.put("stbInstallmentCount", JSONObject.NULL);
                    iptvBox.put("stbPrice","");
                    iptvBox.put("iptvSrvcCodes", cpeInfoModel.getIptvPackages());
                    iptvBoxList.put(iptvBox);

                }
            }

            RealmList<IptvSIDataModel> stbList = new RealmList<>();
            RealmResults<IptvSIDataModel> iptvDataModels = realm.where(IptvSIDataModel.class).equalTo("apsflTrackId", Constants.apsflTrackId).findAll();
            Log.d("SICPEINFO", iptvDataModels.toString());
            stbList.clear();
            stbList.addAll(iptvDataModels);
            Log.d("stbSavedata", stbList.size() + "");
            Log.d("stblist", stbList.toString());

            cpeInfoModel.setSelectedIptvList(stbList);

            realm.copyToRealmOrUpdate(cpeInfoModel);
            //saving offLine

            SIOfflineFormModel offlineFormModel = realm.where(SIOfflineFormModel.class)
                    .equalTo("apsflTrackId", Constants.apsflTrackId).findFirst();
            JSONObject formData = null;
            JSONObject customerCAFVO = null;
            if (offlineFormModel == null) {
                offlineFormModel = new SIOfflineFormModel();
                offlineFormModel.setApsflTrackId(Constants.apsflTrackId);
                formData = new JSONObject();
                customerCAFVO = new JSONObject();
            } else {
                //Todo
                //for status
                formData = new JSONObject(offlineFormModel.getFormPaymentData());
                customerCAFVO = new JSONObject(formData.getJSONObject("customerCafVO").toString());
            }
            SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();
            formData.put("cpeSrlNo", formONUSerialNO.getText().toString());
            // formData.put("stbSrlNo", formIPTVSerialNoEditText.getText().toString());


            customerCAFVO.put("cpeId", formONUSerialNO.getText().toString());
            customerCAFVO.put("custType", "ENTERPRISE");
            //customerCAFVO.put("stbSerialNo", formIPTVSerialNoEditText.getText().toString());
            customerCAFVO.put("oltId", oltIDSpinner.getSelectedItemPosition() > 0 ? oltIDSpinnerItems.get(oltIDSpinner.getSelectedItemPosition()).getPopOLTSerialNumber() : "");
            customerCAFVO.put("oltPortId", oltPortIDSpinner.getSelectedItemPosition() > 0 ? oltPortSpinnerItems.get(oltPortIDSpinner.getSelectedItemPosition()).getPortNo() : "");
           // customerCAFVO.put("cpeModal", String.valueOf(onuModelSpinnerItems.get(onuModelSpinner.getSelectedItemPosition()).getCpeProfileID()));
            /*String stdmodelValue = "";
            if (ipTvLayout.getVisibility() == View.GONE) {
                stdmodelValue = "NA";
            } else {
                stdmodelValue = String.valueOf(stbModelSpinnerItems.get(iptvModelSpinner.getSelectedItemPosition()).getCpeProfileID());
            }
            Log.d("stb model", stdmodelValue);
            customerCAFVO.put("stbModel", stdmodelValue);*/

            //customerCAFVO.put("cpePrice", formONUPrice.getText().toString());
            //Todo
            ///need review//dec 17
           /*customerCAFVO.put("cpeDevice", JSONObject.NULL);
           customerCAFVO.put("stbDevice", JSONObject.NULL);
           customerCAFVO.put("stbLease", JSONObject.NULL);
           customerCAFVO.put("cpeLease", "Y" );*/
            customerCAFVO.put("installmentCount", JSONObject.NULL);
            // customerCAFVO.put("cableCharge", formCPECableChargeEditText.getText().toString());
            customerCAFVO.put("cableCharge", "0");
            //customerCAFVO.put("stbPrice", "");
           ///////////////////////////
            //customerCAFVO.put("coreSrvcCode", coreServiceCodes);
            customerCAFVO.put("vpnService", vpnServiceSpinner.getSelectedItemPosition() > 0 ?
                    vpnSpinnerItems.get(vpnServiceSpinner.getSelectedItemPosition()).getVpnsrvcName() : "");
            customerCAFVO.put("noOfTPConn", telephonicConnCount.getSelectedItemPosition() > 0 ?
                    telephonicConnCount.getSelectedItem() : "");

            sharedPreferences = BaseApplication.getSharedPreferences();
            customerCAFVO.put("tenantType", sharedPreferences.getString(Constants.TENANT_TYPE, ""));
            customerCAFVO.put("lmoCode", sharedPreferences.getString(Constants.LMO_CODE, ""));
            customerCAFVO.put("loginId", sharedPreferences.getString(Constants.USER_NAME, ""));
            customerCAFVO.put("ipAddress", Utils.getIPAddress(this));
            customerCAFVO.put("cpeLease", "Y");
            ///////////////////customerCAFVO.put("stbLease", "Y");
            customerCAFVO.put("flag", "NoCafFeatures");//if no feature codes
            customerCAFVO.put("status", "89");
            //Todo
            customerCAFVO.put("cafStatus", "89");

            SICustomerInfoModel siCustomerInfoModel = realm.where(SICustomerInfoModel.class).equalTo("apsflTrackId", Constants.apsflTrackId).findFirst();

            customerCAFVO.put("entCustomerCode", siCustomerInfoModel.getCustId());
            //formData.put("custCode", enterpriseCustomer.getPaymentCustomerId());
            customerCAFVO.put("entCustType", siCustomerInfoModel.getEntCustType());
            customerCAFVO.put("cafNo", siCustomerInfoModel.getCafNo());
            customerCAFVO.put("custId", siCustomerInfoModel.getCustId());
            customerCAFVO.put("billCycle", siCustomerInfoModel.getBillCycle());
            customerCAFVO.put("district", siCustomerInfoModel.getSelectedInstDistId());
            customerCAFVO.put("mandal", siCustomerInfoModel.getSelectedInstMandalId());
            customerCAFVO.put("city", siCustomerInfoModel.getInstVillageId());
            customerCAFVO.put("popDistrict", popDistId);
            customerCAFVO.put("popMandal", popMandalId);
            customerCAFVO.put("aadharNumber", siCustomerInfoModel.getEntCustomerCode());
            customerCAFVO.put("popId", popId);
            //customerCAFVO.put("cafStatus", offlineFormModel.getCafStatus());
            customerCAFVO.put("coreSrvcCode", siCustomerInfoModel.getCoreSrvcCode());
            // customerCAFVO.put("vpnService", "");
            customerCAFVO.put("iptvBoxList", iptvBoxList);
            customerCAFVO.put("version", Constants.version);
            formData.put("custId", siCustomerInfoModel.getCustId());
            formData.put("cafNo", siCustomerInfoModel.getCafNo());
            formData.put("aadharNumber", siCustomerInfoModel.getEntCustomerCode());
            formData.put("customerName", siCustomerInfoModel.getOrganizationName());
            formData.put("district", siCustomerInfoModel.getSelectedInstDistId());
            formData.put("feasibility", "Y");
            formData.put("ipAddress", Utils.getIPAddress(this));
            formData.put("lmoCode", sharedPreferences.getString(Constants.LMO_CODE, ""));
            formData.put("loginId", sharedPreferences.getString(Constants.USER_NAME, ""));
            formData.put("mandal", siCustomerInfoModel.getSelectedInstMandalId());
            // formData.put("oltPortNo", oltPortIDSpinner.getSelectedItemPosition() > 0 ? oltPortSpinnerItems.get(oltPortIDSpinner.getSelectedItemPosition()).getPortNo() : "");
            formData.put("payment", JSONObject.NULL);
            formData.put("village", siCustomerInfoModel.getInstVillageId());


            formData.put("customerCafVO", customerCAFVO);
            formData.put("tenantType", sharedPreferences.getString(Constants.TENANT_TYPE, ""));
            offlineFormModel.setFormPaymentData(formData.toString());
            offlineFormModel.setCafNumber(siCustomerInfoModel.getCafNo());
            realm.copyToRealmOrUpdate(offlineFormModel);
            realm.commitTransaction();
        } catch (Exception ex) {
            realm.cancelTransaction();
            ex.printStackTrace();
            Log.d("Exception in -> ", "saveFormData()");
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.popDistrictSpinner:
                if (position > 0) {
                    DistrictModel districtModel = districtPopSpinnerItems.get(position);
                    popDistId = districtModel.getDistrictID();

                    popMandal.setText("Click to select mandal");
                    selectedPOPName.setText("Select to load POP");
                }
                break;
            case R.id.oltIDSpinner:
                if (position > 0) {
                    loadOltPortIDData(position, 0);
                    loadVpnData(position, 0);
                   /* String oltSerialNo = oltIDSpinnerItems.get(position).getPopOLTSerialNumber();
                    OltPortDetails oltPortDataModel = new OltPortDetails();
                    oltPortDataModel.setPortNo("--Select--");
                    oltPortDataModel.setPopIdPortNo("-1");
                    oltPortDataModel.setPopId("");
                    oltPortSpinnerItems.clear();
                    oltPortSpinnerItems.add(oltPortDataModel);
                    oltPortSpinnerItems.addAll(realm.where(OltPortDetails.class).equalTo("popId", oltSerialNo).findAll());
                    oltPortSpinnerAdapter = new OLTPortSpinnerAdapter(this, oltPortSpinnerItems);
                    oltPortIDSpinner.setAdapter(oltPortSpinnerAdapter);*/

                    /*///For vpn
                    String oltPopSubstnuid = oltIDSpinnerItems.get(position).getPopID().toString();
                    VpnServiceModel vpnServiceModel = new VpnServiceModel();
                    vpnServiceModel.setVpnsrvcName("--Select--");
                    vpnServiceModel.setSubstnUid("");
                    vpnServiceModel.setOltSerialNo("");

                    vpnSpinnerItems.clear();
                    vpnSpinnerItems.add(vpnServiceModel);
                    vpnSpinnerItems.addAll(realm.where(VpnServiceModel.class).equalTo("substnUid", oltPopSubstnuid).equalTo("oltSerialNo", oltSerialNo).findAllSorted("vpnsrvcName", Sort.ASCENDING));

                    VpnSpinnerAdapter vpnSpinnerAdapter = new VpnSpinnerAdapter(this, vpnSpinnerItems);
                    vpnServiceSpinner.setAdapter(vpnSpinnerAdapter);
                    //vpnServiceSpinner.setSelection(VpnValuePosition);*/


                }
                break;
            case R.id.oltPortIDSpinner:

                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {

                case 1001:
                    if (data.getStringExtra("mandalName").equals("")) {
                        popMandal.setText("Click to select mandal");
                    } else {
                        popMandal.setText(data.getStringExtra("mandalName"));
                        popMandalId = data.getStringExtra("mandalSerialno");
                    }
                    selectedPOPName.setText("Select to load POP");

                    /*mandalID = data.getStringExtra("mandalSerialNumber");
                    districtID = data.getStringExtra("districtSerialNumber");
*/
                    break;
                case 1002:
                    if (data.getStringExtra("selectedPOPName").equals("")) {
                        selectedPOPName.setText("Select to load POP");
                    } else {
                        selectedPOPName.setText(data.getStringExtra("selectedPOPName"));
                        popId = data.getStringExtra("selectedPOPID");
                        loadOltIDData(0);
                    }

                   /* POPOLTModel popOltModel = new POPOLTModel();
                    popOltModel.setPopOLTID("-1");
                    popOltModel.setPopID("");
                    popOltModel.setPopName("");
                    popOltModel.setPopOLTSerialNumber("");
                    popOltModel.setPopLabelNumber("--Select--");
                    oltIDSpinnerItems.clear();
                    oltIDSpinnerItems.add(popOltModel);
                    oltIDSpinnerItems.addAll(realm.where(POPOLTModel.class).equalTo("popID", popId).findAll());
                    oltIdSpinneradapter = new OLTIDSpinnerAdapter(this, oltIDSpinnerItems);
                    oltIDSpinner.setAdapter(oltIdSpinneradapter);*/
                    //oltIdSpinneradapter.notifyDataSetChanged();
                    break;

            }
        }
    }

    private void loadOltIDData(int position) {
        POPOLTModel popOltModel = new POPOLTModel();
        popOltModel.setPopOLTID("-1");
        popOltModel.setPopID("");
        popOltModel.setPopName("");
        popOltModel.setPopOLTSerialNumber("");
        popOltModel.setPopLabelNumber("--Select--");
        oltIDSpinnerItems.clear();
        oltIDSpinnerItems.add(popOltModel);
        oltIDSpinnerItems.addAll(realm.where(POPOLTModel.class).equalTo("popID", popId).findAll());
        oltIdSpinneradapter = new OLTIDSpinnerAdapter(this, oltIDSpinnerItems);
        oltIDSpinner.setAdapter(oltIdSpinneradapter);
        oltIDSpinner.setSelection(position);
        /*oltIDSpinnerItems = new RealmList<>();
        POPOLTModel popOltModel = new POPOLTModel();
        popOltModel.setPopOLTID("-1");
        popOltModel.setPopID("");
        popOltModel.setPopName("");
        popOltModel.setPopOLTSerialNumber("");
        popOltModel.setPopLabelNumber("--Select--");
        oltIDSpinnerItems.add(popOltModel);
        Realm realm = Realm.getDefaultInstance();
        *//*  popID = realm.where(POPModel.class).equalTo("popName", popName).findFirst().getPopID();*//*
        //Log.d(TAG, "POP ID " + popID);
        oltIDSpinnerItems.addAll(realm.where(POPOLTModel.class).equalTo("popID", popId).findAll());
        OLTIDSpinnerAdapter adapter = new OLTIDSpinnerAdapter(this, oltIDSpinnerItems);
        oltIDSpinner.setAdapter(adapter);
        oltIDSpinner.setSelection(position);
        oltIDSpinner.setVisibility(View.VISIBLE);
        //Constants.oltSerialNumber = oltIDSpinnerItems.get(position).getPopOLTSerialNumber();*/
    }

    private void loadOltPortIDData(int oltIdPosition, int oltportIdPosition) {
        if (oltIdPosition > 0) {
            // Realm realm = Realm.getDefaultInstance();
            String oltPopID = oltIDSpinnerItems.get(oltIdPosition).getPopOLTSerialNumber();
            OltPortDetails oltPortDataModel = new OltPortDetails();
            oltPortDataModel.setPortNo("--Select--");
            oltPortDataModel.setPopIdPortNo("-1");
            oltPortDataModel.setPopId("");
            oltPortSpinnerItems.clear();
            oltPortSpinnerItems.add(oltPortDataModel);
            oltPortSpinnerItems.addAll(realm.where(OltPortDetails.class).equalTo("popId", oltPopID).findAll());
            OLTPortSpinnerAdapter oltPortSpinnerAdapter = new OLTPortSpinnerAdapter(this, oltPortSpinnerItems);
            oltPortIDSpinner.setAdapter(oltPortSpinnerAdapter);
            oltPortIDSpinner.setSelection(oltportIdPosition);
            //Constants.oltPortNumber = oltPortSpinnerItems.get(oltportIdPosition).getPortNo();

        }
    }

    private void loadVpnData(int oltIdPosition, int VpnValuePosition) {

        if (oltIdPosition > 0) {
            //Realm realm = Realm.getDefaultInstance();
            String oltSerialNo = oltIDSpinnerItems.get(oltIdPosition).getPopOLTSerialNumber().toString();
            String oltPopSubstnuid = oltIDSpinnerItems.get(oltIdPosition).getPopID().toString();
            VpnServiceModel vpnServiceModel = new VpnServiceModel();
            vpnServiceModel.setVpnsrvcName("--Select--");
            vpnServiceModel.setSubstnUid("");
            vpnServiceModel.setOltSerialNo("");

            vpnSpinnerItems.clear();
            vpnSpinnerItems.add(vpnServiceModel);
            vpnSpinnerItems.addAll(realm.where(VpnServiceModel.class).equalTo("substnUid", oltPopSubstnuid).equalTo("oltSerialNo", oltSerialNo).findAllSorted("vpnsrvcName", Sort.ASCENDING));

            VpnSpinnerAdapter vpnSpinnerAdapter = new VpnSpinnerAdapter(this, vpnSpinnerItems);
            vpnServiceSpinner.setAdapter(vpnSpinnerAdapter);
            vpnServiceSpinner.setSelection(VpnValuePosition);

        }
    }

    private void loadTelephoneConne(int position) {
        String[] telphoneConnSpinnerItems = getResources().getStringArray(R.array.tele_conn_count_spinner_items);
        CustomSpinnerAdapter telphoneConnAdapter = new CustomSpinnerAdapter(this, telphoneConnSpinnerItems);
        telephonicConnCount.setAdapter(telphoneConnAdapter);
        telephonicConnCount.setSelection(position);

    }

    private boolean validateFormFields() {
        boolean isValid = false;
        if (popDistrictSpinner.getSelectedItemPosition() > 0) {
            if (!popMandal.getText().toString().equals("Click to select mandal")) {
                if (!selectedPOPName.getText().toString().equals("Select to load POP")) {
                    if (FormValidations.isFormSpinnerItemSelected(oltIDSpinner, FormValidations.SPINNER.OLT_ID))
                        if (FormValidations.isFormSpinnerItemSelected(oltPortIDSpinner, FormValidations.SPINNER.OLT_PORT_ID))
                           // if (FormValidations.isFormSpinnerItemSelected(onuModelSpinner, FormValidations.SPINNER.ONU_MODEL))
                                if (FormValidations.isFormEditTextValid(formONUSerialNO, FormValidations.FORM_FIELDS.ONU_ID))
                                    if (formtelephonicLayout.getVisibility() == View.GONE ||FormValidations.isFormSpinnerItemSelected(telephonicConnCount, FormValidations.SPINNER.TELEPHONICCONN_COUNT))
                                    if (formSTBLayout.getVisibility() == View.VISIBLE) {
                                        if (validateIptvLayout())
                                            isValid = true;

                                    } else {
                                        if (formSTBLayout.getVisibility() == View.VISIBLE) {
                                            if (FormValidations.isFormSpinnerItemSelected(vpnServiceSpinner, FormValidations.SPINNER.VPNSERVICE))
                                                isValid = true;
                                        } else {
                                            isValid = true;
                                        }
                                    }

                    return isValid;
                } else {
                    isValid = false;
                    Utils.showDialog(this,
                            getString(R.string.invalid_pop_name_title),
                            getString(R.string.invalid_pop_name_message), null);
                }
            } else {
                isValid = false;

                Utils.showDialog(this,
                        getString(R.string.invalid_mandal_title),
                        getString(R.string.invalid_mandal_message), null);
            }
        } else {
            isValid = false;
            Utils.showDialog(this,
                    getString(R.string.invalid_district_title),
                    getString(R.string.invalid_district_message), null);
        }
        return isValid;
    }

    @Override
    public void onDialogConfirmed(int actionType) {
        switch (actionType) {

            case Constants.PAYMENT_FAILURE:
                startActivity(new Intent(this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                break;

        }
    }

    private boolean validateIptvLayout() {
        boolean isValid = false, isSerialNoused = false;
        //need to handle if no iptv layout//Todo
        int ipTvChaildCount = stbWrapper.getChildCount();
        if (ipTvChaildCount != 0) {
            for (int i = 0; i < ipTvChaildCount; i++) {
                LinearLayout iptvLayout = (LinearLayout) stbWrapper.getChildAt(i);
              /*  View stbModelSpinnerView = iptvLayout.getChildAt(1);
                Spinner stbModelSpinner = (Spinner) stbModelSpinnerView;
*/
                View formIPTVSerialNoEditTextView = iptvLayout.getChildAt(1);
                EditText formIPTVSerialNoEditText = (EditText) formIPTVSerialNoEditTextView;
                if (i > 0) {
                    for (int J = 0; J < i; J++) {

                        LinearLayout previousIptvLayout = (LinearLayout) stbWrapper.getChildAt(J);

                        View PreviousFormIPTVSerialNoEditTextView = previousIptvLayout.getChildAt(1);
                        EditText PreviousFormIPTVSerialNoEditText = (EditText) PreviousFormIPTVSerialNoEditTextView;

                        if (formIPTVSerialNoEditText.getText().toString().equals(PreviousFormIPTVSerialNoEditText.getText().toString())) {
                            isSerialNoused = true;
                        } else {
                            isSerialNoused = false;
                        }
                    }
                }

                ///Validating
                //if (FormValidations.isFormSpinnerItemSelected(stbModelSpinner, FormValidations.SPINNER.STB_MODEL)) {
                    if (FormValidations.isFormEditTextValid(formIPTVSerialNoEditText, FormValidations.FORM_FIELDS.IPTV_ID)) {
                        if (!isSerialNoused) {
                            isValid = true;
                        } else {
                            isValid = false;
                            Utils.showDialog(this,
                                    "Invalid IPTV Serial No.",
                                    "Entered serial no. already used", null);
                        }

                    } else {
                        isValid = false;
                    }
               /* } else {
                    isValid = false;
                }
*/
            }
        } else {
            isValid = true;
        }
        return isValid;
    }
    private void updateStatusMessage(String message){
        Realm realm = Realm.getDefaultInstance();
        SIOfflineFormModel formModel = realm.where(SIOfflineFormModel.class)
                .equalTo("apsflTrackId", Constants.apsflTrackId)
                .findFirst();
        realm.beginTransaction();
        formModel.setStatusMessage(message);
        realm.commitTransaction();
        realm.close();
    }
}

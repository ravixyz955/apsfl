package com.app.apsfl.fragments;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.app.apsfl.R;
import com.app.apsfl.activities.SelectInstVillageActivity;
import com.app.apsfl.activities.SelectMandalActivity;
import com.app.apsfl.activities.SelectPOPActivity;
import com.app.apsfl.activities.SelectVillageActivity;
import com.app.apsfl.activities.SendOTPActivity;
import com.app.apsfl.adapters.DistrictSpinnerAdapter;
import com.app.apsfl.application.BaseApplication;
import com.app.apsfl.httpClient.RequestHandler;
import com.app.apsfl.interfaces.FragmentBackStackListener;
import com.app.apsfl.interfaces.ResponseHandler;
import com.app.apsfl.models.CustomerAddressModel;
import com.app.apsfl.models.CustomerInfoModel;
import com.app.apsfl.models.DistrictModel;
import com.app.apsfl.models.EnterpriseCustomer;
import com.app.apsfl.models.MandalModel;
import com.app.apsfl.models.OfflineFormModel;
import com.app.apsfl.models.VillageModel;
import com.app.apsfl.utils.Constants;
import com.app.apsfl.utils.FormValidations;
import com.app.apsfl.utils.LocationHelper;
import com.app.apsfl.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Locale;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class CustomerAddressFragment extends Fragment
        implements View.OnClickListener, FragmentBackStackListener,
        AdapterView.OnItemSelectedListener, LocationHelper.onLocationUpdate, ResponseHandler {

    public static final String NO_POP_SELECTED = "Click to select POP Name";
    public static final String NO_DISTRICT_SELECTED = "Select village to load district";
    public static final String NO_MANDAL_SELECTED = "Select village to load mandal";
    public static final String NO_VILLAGE_SELECTED = "Click to select city/village";
    private final String TAG = "CustomerAddressFragment";
    SharedPreferences sharedPreferences;
    private RequestHandler requestHandler;
    private LinearLayout previousScreenLayout, nextScreenLayout, lmoAddress, siLMOAddress, siLmoPOPAddress, layoutlangitude;
    private TextView selectedVillageName, selectedMandalName, selectedDistrictName, selectedPOPName,
            selectedSILMOVillageName, selectedSILMOMandalName, selectedSILMOPOPMandalName, pincodeTitle;
    private Spinner selectedSILMODistrictName, selectedSILMOPOPDistrictName;
    private EditText formAddress1EditText, formAddress2EditText,
            formLocalityEditText,
            formPinCodeEditText, formMobileEditText, formMobile1EditText, formSTDCodeEditText, formLandLineEditText,
            formLongitudeEditText, formLatitudeEditText, formLocationEditText;
    private Geocoder geocoder;
    private String popID = "", districtID = "", mandalID = "", villageID = "", lmoType, apsflUniqueId = "", entCustomerCode = "", entCustType = "";
    //private String region = "";
    private String siLMOmandalID = "", siLMODistrictId = "", popMandalID = "", popDistrictId = "";
    private CheckBox formCustomerDeclaration, formLMODeclaration;
    private RealmList<DistrictModel> districtSpinnerItems, popDistrictSpinnerItems;
    private double latitude, longitude;
    private String alowCharacterSet = "/#&- ";
    String[] listInfo = null;

    private InputFilter filter = new InputFilter() {

        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {

            if (source != null) {
                for (int i = start; i < end; i++) {
                    if (!Character.isLetterOrDigit(source.charAt(i))) {
                        if (!alowCharacterSet.contains("" + source.charAt(i))) {
                            return "";
                        }
                    }
                }
            }
            return null;
        }
    };

    @Override
    public void onLocationChange(Location location) {
        latitude = location.getLatitude();
        longitude = location.getLongitude();
        //getLocationFromLatLng(location.getLatitude(), location.getLongitude());
        LocationHelper.getInstance().removeLocationUpdates(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView()");
        View layoutView = inflater.inflate(R.layout.fragment_customer_address, container, false);
        initViews(layoutView);
        setupToolBar();
        String s = CustomerInfoFragment.addressSample;
        if( s != null){
            listInfo = s.split(" , ");
            if (s.isEmpty()) {
                formAddress1EditText.setText("null");
                formAddress2EditText.setText("null");
                formLocalityEditText.setText("null");
                formPinCodeEditText.setText("null");
                formMobileEditText.setText("null");
            } else {
                formAddress1EditText.setText(listInfo[0]);
                formAddress2EditText.setText(listInfo[1]);
                formLocalityEditText.setText(listInfo[2]);
                formPinCodeEditText.setText(listInfo[3]);
                formMobileEditText.setText(listInfo[4]);
            }

        }

        if (!lmoType.equals("LMO")) {
            setSpinnerData();
        }
        Realm realm = Realm.getDefaultInstance();
        CustomerAddressModel customerAddressModel = realm.where(CustomerAddressModel.class)
                .equalTo("formTime", Constants.formTime).findFirst();

        if (customerAddressModel == null && Constants.aadhaarData != null) {
            try {
                formAddress1EditText.setText(Constants.aadhaarData.getString("buildingName"));
                formAddress2EditText.setText(Constants.aadhaarData.getString("street"));
                formLocalityEditText.setText(Constants.aadhaarData.getString("village_name"));
                formPinCodeEditText.setText(Constants.aadhaarData.getString("pincode"));
                formMobileEditText.setText(Constants.aadhaarData.getString("phoneNo"));
                String villageSerialNumber = Constants.aadhaarData.getString("village");
                String villageName = Constants.aadhaarData.getString("village_name");
                //Todo

                // Realm realm = Realm.getDefaultInstance();
                VillageModel model = realm.where(VillageModel.class)
                        .equalTo("villageSerialNumber", villageSerialNumber).equalTo("villageName", villageName).findFirst();
                selectedPOPName.setText(NO_POP_SELECTED);
                if (lmoType.equals("LMO")) {
                    if (model != null) {
                        selectedVillageName.setText(model.getVillageName());
                        selectedMandalName.setText(model.getMandalName());
                        selectedDistrictName.setText(model.getDistrictName());
                        villageID = model.getVillageSerialNumber();
                        mandalID = model.getMandalSerialNumber();
                        districtID = model.getDistrictSerialNumber();
                        realm.beginTransaction();
                        model.setVillageChecked(true);
                        realm.commitTransaction();
                    } else {
                        selectedVillageName.setText(NO_VILLAGE_SELECTED);
                        selectedMandalName.setText(NO_MANDAL_SELECTED);
                        selectedDistrictName.setText(NO_DISTRICT_SELECTED);
                    }
                } else {
                    if (model != null) {
                        selectedSILMOVillageName.setText(model.getVillageName());
                        Log.d(TAG, "village name1 " + model.getVillageName());
                        selectedSILMOMandalName.setText(model.getMandalName());

                        selectedSILMODistrictName.setSelection(getIndex(selectedSILMODistrictName, model.getDistrictName()));//Todo
                        villageID = model.getVillageSerialNumber();
                        mandalID = model.getMandalSerialNumber();
                        districtID = model.getDistrictSerialNumber();
                        realm.beginTransaction();
                        model.setVillageChecked(true);
                        realm.commitTransaction();
                    } else {
                        selectedSILMOVillageName.setText(NO_VILLAGE_SELECTED);
                        selectedSILMOMandalName.setText("Click to select mandal");
                        selectedSILMODistrictName.setSelection(0);//Todo
                        selectedSILMOPOPDistrictName.setSelection(0);
                        selectedSILMOPOPMandalName.setText("Click to select Pop mandal");

                    }

                }
            } catch (Exception ex) {
                ex.printStackTrace();
                Log.d("Exception in", "\t" + "onCreateView()");
                selectedPOPName.setText(NO_POP_SELECTED);
                selectedVillageName.setText(NO_VILLAGE_SELECTED);
                selectedMandalName.setText(NO_MANDAL_SELECTED);
                selectedDistrictName.setText(NO_DISTRICT_SELECTED);
                selectedSILMOVillageName.setText(NO_VILLAGE_SELECTED);
                selectedSILMOMandalName.setText("Click to select mandal");
                selectedSILMODistrictName.setSelection(0);
            }
        } else {
            setData();
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                registerListeners();
            }
        }, 500);
        return layoutView;
    }

    private void initViews(View view) {
        geocoder = new Geocoder(getActivity(), Locale.getDefault());
        sharedPreferences = BaseApplication.getSharedPreferences();
        lmoType = sharedPreferences.getString(Constants.TENANT_TYPE, "");
        LinearLayout screenLayout = (LinearLayout) view.findViewById(R.id.previousNextLayout);
        previousScreenLayout = (LinearLayout) screenLayout.findViewById(R.id.previousScreenLayout);
        nextScreenLayout = (LinearLayout) screenLayout.findViewById(R.id.nextScreenLayout);
        TextView previousScreenName = (TextView) previousScreenLayout.findViewById(R.id.previousScreenName);
        TextView nextScreenName = (TextView) nextScreenLayout.findViewById(R.id.nextScreenName);
        previousScreenName.setText("Customer Info");
        switch (lmoType) {
            case "LMO":
                nextScreenName.setText(R.string.select_packages_screen_name);
                break;
            case "SI":
                nextScreenName.setText(R.string.customer_cpe_screen_name);
                break;
        }

        LinearLayout mainLayout = (LinearLayout) view.findViewById(R.id.mainLayout);
        layoutlangitude = (LinearLayout) mainLayout.findViewById(R.id.layout_langitude);
        layoutlangitude.setVisibility(View.GONE);
        selectedPOPName = (TextView) mainLayout.findViewById(R.id.selectedPOPName);
        formAddress1EditText = (EditText) mainLayout.findViewById(R.id.formAddress1EditText);
        formAddress2EditText = (EditText) mainLayout.findViewById(R.id.formAddress2EditText);
        formAddress1EditText.setFilters(new InputFilter[]{filter});
        formAddress2EditText.setFilters(new InputFilter[]{filter});


        lmoAddress = (LinearLayout) view.findViewById(R.id.lmoAddress);
        selectedVillageName = (TextView) mainLayout.findViewById(R.id.formSelectedVillage);
        selectedMandalName = (TextView) mainLayout.findViewById(R.id.selectedMandalName);
        selectedDistrictName = (TextView) mainLayout.findViewById(R.id.selectedDistrictName);
        //SILMO
        siLmoPOPAddress = (LinearLayout) view.findViewById(R.id.siLmoPOPAddress);
        selectedSILMOPOPMandalName = (TextView) mainLayout.findViewById(R.id.selectedSILMOPOPMandalName);
        selectedSILMOPOPDistrictName = (Spinner) mainLayout.findViewById(R.id.selectedSILMOPOPDistrictName);
        siLMOAddress = (LinearLayout) view.findViewById(R.id.siLmoAddress);
        selectedSILMOVillageName = (TextView) mainLayout.findViewById(R.id.formSelectedSILMOVillage);
        selectedSILMOMandalName = (TextView) mainLayout.findViewById(R.id.selectedSILMOMandalName);
        selectedSILMODistrictName = (Spinner) mainLayout.findViewById(R.id.selectedSILMODistrictName);

        formLocalityEditText = (EditText) mainLayout.findViewById(R.id.formLocalityEditText);
        formLocalityEditText.setFilters(new InputFilter[]{filter});
        pincodeTitle = (TextView) mainLayout.findViewById(R.id.pincodeTitle);
        formPinCodeEditText = (EditText) mainLayout.findViewById(R.id.formPinCodeEditText);
        formMobileEditText = (EditText) mainLayout.findViewById(R.id.formMobileEditText);
        formMobile1EditText = (EditText) mainLayout.findViewById(R.id.formMobile1EditText);
        formSTDCodeEditText = (EditText) mainLayout.findViewById(R.id.formSTDCodeEditText);
        formLandLineEditText = (EditText) mainLayout.findViewById(R.id.formLandLineEditText);
        formLongitudeEditText = (EditText) mainLayout.findViewById(R.id.formLongitudeEditText);
        formLatitudeEditText = (EditText) mainLayout.findViewById(R.id.formLatitudeEditText);
        formLocationEditText = (EditText) mainLayout.findViewById(R.id.formLocationEditText);
        formLocationEditText.setFilters(new InputFilter[]{filter});
        formCustomerDeclaration = (CheckBox) mainLayout.findViewById(R.id.formCustomerDeclaration);
        formLMODeclaration = (CheckBox) mainLayout.findViewById(R.id.formLMODeclaration);
        formCustomerDeclaration.setVisibility(View.GONE);
        formLMODeclaration.setVisibility(View.GONE);
        if (lmoType.equals("LMO")) {
            lmoAddress.setVisibility(view.VISIBLE);
            siLMOAddress.setVisibility(view.GONE);
            siLmoPOPAddress.setVisibility(view.GONE);
        } else {
            pincodeTitle.setText("Pin Code");
            districtSpinnerItems = new RealmList<>();
            popDistrictSpinnerItems = new RealmList<>();
            lmoAddress.setVisibility(view.GONE);
            siLMOAddress.setVisibility(view.VISIBLE);
            siLmoPOPAddress.setVisibility(view.VISIBLE);
        }
        requestHandler = new RequestHandler();
    }

    private void setupToolBar() {
        ActionBar mActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setTitle(R.string.fragment_address_info_title);
        }
    }

    private void setSpinnerData() {
        Realm realm = Realm.getDefaultInstance();
        districtSpinnerItems.clear();
        DistrictModel districtModel = new DistrictModel();
        districtModel.setDistrictID("");
        districtModel.setDistrictName("--Select--");
        districtSpinnerItems.add(districtModel);
        districtSpinnerItems.addAll(realm.where(DistrictModel.class).findAll());
        DistrictSpinnerAdapter districtSpinnerAdapter = new DistrictSpinnerAdapter(getActivity(), districtSpinnerItems);
        selectedSILMODistrictName.setAdapter(districtSpinnerAdapter);

        popDistrictSpinnerItems.clear();
        DistrictModel popDistrictModel = new DistrictModel();
        popDistrictModel.setDistrictID("");
        popDistrictModel.setDistrictName("--Select--");
        popDistrictSpinnerItems.add(popDistrictModel);
        popDistrictSpinnerItems.addAll(realm.where(DistrictModel.class).findAll());
        DistrictSpinnerAdapter popDistrictSpinnerAdapter = new DistrictSpinnerAdapter(getActivity(), popDistrictSpinnerItems);
        selectedSILMOPOPDistrictName.setAdapter(popDistrictSpinnerAdapter);

    }

    private void registerListeners() {
        previousScreenLayout.setOnClickListener(this);
        nextScreenLayout.setOnClickListener(this);
        selectedPOPName.setOnClickListener(this);

        if (lmoType.equals("LMO")) {
            selectedVillageName.setOnClickListener(this);
        } else {
            selectedSILMOVillageName.setOnClickListener(this);
            selectedSILMOMandalName.setOnClickListener(this);
            selectedSILMODistrictName.setOnItemSelectedListener(this);
            selectedSILMOPOPDistrictName.setOnItemSelectedListener(this);
            selectedSILMOPOPMandalName.setOnClickListener(this);

        }
    }

    private void setData() {
        Realm realm = Realm.getDefaultInstance();
        EnterpriseCustomer enterpriseCustomer = realm.where(EnterpriseCustomer.class).equalTo("isCustomerChecked", true).findFirst();
        if (Constants.cafType == 2 && enterpriseCustomer != null) {

            formAddress1EditText.setText(enterpriseCustomer.getAddress1().equals("null") ? "" : enterpriseCustomer.getAddress1());
            // formAddress1EditText.setEnabled(false);
            formAddress2EditText.setText(enterpriseCustomer.getAddress2().equals("null") ? "" : enterpriseCustomer.getAddress2());
            //   formAddress2EditText.setEnabled(false);
            formLocalityEditText.setText(enterpriseCustomer.getLocality().equals("null") ? "" : enterpriseCustomer.getLocality());
            //   formLocalityEditText.setEnabled(false);
            formMobileEditText.setText(enterpriseCustomer.getCustomerMobileNumber().equals("null") ? "" : enterpriseCustomer.getCustomerMobileNumber());
        }
        CustomerAddressModel model = realm.where(CustomerAddressModel.class)
                .equalTo("formTime", Constants.formTime).findFirst();
        if (model != null) {
            Log.d("Address Model", "\t" + model.toString());

            String infoAadharNo = realm.where(CustomerInfoModel.class).equalTo("formTime", Constants.formTime).findFirst().getCustomerAadhaarNumber();
            if (!model.getCustomerAadhaarNumber().equals(infoAadharNo)) {
                try {
                    formAddress1EditText.setText(Constants.aadhaarData.getString("buildingName"));
                    formAddress2EditText.setText(Constants.aadhaarData.getString("street"));
                    formLocalityEditText.setText(Constants.aadhaarData.getString("village_name"));
                    formPinCodeEditText.setText(Constants.aadhaarData.getString("pincode"));
                    formMobileEditText.setText(Constants.aadhaarData.getString("phoneNo"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                formAddress1EditText.setText(model.getAddress1());
                formAddress2EditText.setText(model.getAddress2());
                formLocalityEditText.setText(model.getLocality());
                formPinCodeEditText.setText(model.getPinCode());
                formMobileEditText.setText(model.getMobile());
            }
            popID = model.getPopID();
            // region=model.getRegion();//Todo
            if (Constants.isCAFInEditSILMO) {
                selectedPOPName.setText(NO_POP_SELECTED);
            }
            selectedPOPName.setText(model.getPopName());
            formSTDCodeEditText.setText(model.getStdCode());
            formLandLineEditText.setText(model.getLandLine());
            districtID = model.getDistrictID();
            mandalID = model.getMandalID();
            villageID = model.getVillageID();
            Constants.villageID = villageID;
            Constants.districtID = districtID;
            Constants.mandalID = mandalID;
            if (lmoType.equals("LMO")) {
                selectedVillageName.setText(model.getVillageName());
                selectedMandalName.setText(model.getMandalName());
                selectedDistrictName.setText(model.getDistrictName());
                if (Constants.cafType == 2) {
                    formMobileEditText.setEnabled(false);
                }
            } else {
                entCustomerCode = model.getEntCustomerCode();
                entCustType = model.getEntCustType();
                popMandalID = model.getMandalID();
                popDistrictId = model.getPopDistrictId();
                siLMODistrictId = model.getDistrictID();
                siLMOmandalID = model.getMandalID();
                Log.d(TAG, "set data pop mandal and popDistrictId" + popMandalID + "" + popDistrictId);
                selectedSILMOVillageName.setText(model.getVillageName().equals("") ? NO_VILLAGE_SELECTED : model.getVillageName());
                Log.d(TAG, "village name2 " + model.getVillageName());
                selectedSILMOMandalName.setText(model.getMandalName());
                selectedSILMOPOPMandalName.setText(model.getPopmandal());
                selectedSILMODistrictName.setSelection(getIndex(selectedSILMODistrictName, districtID));//Todo
                selectedSILMOPOPDistrictName.setSelection(getIndex(selectedSILMOPOPDistrictName, popDistrictId));
                formMobileEditText.setEnabled(false);
                //disable inst dist,mandal//Todo
                //  selectedSILMODistrictName.setEnabled(false);
                // selectedSILMOMandalName.setEnabled(false);


            }
            formMobile1EditText.setText(model.getMobile1());
            formCustomerDeclaration.setChecked(model.isCustomerChecked());
            formLMODeclaration.setChecked(model.isLMOChecked());
            formLongitudeEditText.setText(model.getLongitude());
            formLatitudeEditText.setText(model.getLatitude());
            formLocationEditText.setText(model.getLocation());
            apsflUniqueId = model.getApsflUniqueId();
            if (lmoType.equals("SI")) {//Todo
                Utils.showProgress(getActivity(), "Loading POP data....");
                requestHandler.getAllSILMOPOPData(getActivity(), this, popDistrictId, popMandalID, Constants.GET_SILMOPOPDATA2);

            }

        } else {
            if (lmoType.equals("LMO")) {
                selectedPOPName.setText(NO_POP_SELECTED);
                selectedVillageName.setText(NO_VILLAGE_SELECTED);
                selectedMandalName.setText(NO_MANDAL_SELECTED);
                selectedDistrictName.setText(NO_DISTRICT_SELECTED);
                if (Constants.cafType == 2) {
                    formMobileEditText.setEnabled(false);
                }
            } else {

                selectedPOPName.setText(NO_POP_SELECTED);
                selectedSILMOVillageName.setText(NO_VILLAGE_SELECTED);
                selectedSILMOMandalName.setText("Click to select mandal");
                selectedSILMODistrictName.setSelection(0);//Todo
                selectedSILMOPOPMandalName.setText("Click to select POP mandal");
                selectedSILMOPOPDistrictName.setSelection(0);//Todo
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case 1000:
                    String popName = data.getStringExtra("selectedPOPName");
                    popID = data.getStringExtra("selectedPOPID");
                    if (popName.equals("")) {
                        selectedPOPName.setText(NO_POP_SELECTED);
                    } else {
                        selectedPOPName.setText(popName);
                    }
                    selectedVillageName.setText(NO_VILLAGE_SELECTED);
                    selectedMandalName.setText(NO_MANDAL_SELECTED);
                    selectedDistrictName.setText(NO_DISTRICT_SELECTED);
                    break;

                case 1001:
                    selectedVillageName.setText(data.getStringExtra("villageName"));
                    selectedMandalName.setText(data.getStringExtra("mandalName"));
                    selectedDistrictName.setText(data.getStringExtra("districtName"));
                    villageID = data.getStringExtra("villageSerialNumber");
                    mandalID = data.getStringExtra("mandalSerialNumber");
                    districtID = data.getStringExtra("districtSerialNumber");

                    break;
                case 1002:
                    String mandalName = data.getStringExtra("mandalName");
                    if (mandalName.equals("")) {
                        selectedSILMOMandalName.setText("Click to select mandal");
                    } else {
                        siLMOmandalID = data.getStringExtra("mandalSerialno");

                        siLMODistrictId = data.getStringExtra("districtID");
                        selectedSILMOMandalName.setText(mandalName);
                        selectedSILMOVillageName.setText(NO_VILLAGE_SELECTED);

                        //Todo.
                        Utils.showProgress(getActivity(), "Loading Village data....");
                        requestHandler.getAllSILMOVillages(getActivity(), this, siLMODistrictId, siLMOmandalID, Constants.GET_SILMOVILLAGEDATA);
                    }
                    break;
                case 1003:
                    if (data.getStringExtra("villageName").equals("")) {
                        selectedSILMOVillageName.setText(NO_VILLAGE_SELECTED);
                    } else {
                        selectedSILMOVillageName.setText(data.getStringExtra("villageName"));
                        villageID = data.getStringExtra("villageSerialNumber");
                        mandalID = data.getStringExtra("mandalSerialNumber");
                        districtID = data.getStringExtra("districtSerialNumber");
                    }
                    break;
                case 1004:
                    String popMandalName = data.getStringExtra("mandalName");
                    if (popMandalName.equals("")) {
                        selectedSILMOPOPMandalName.setText("Click to select Pop mandal");
                    } else {
                        popMandalID = data.getStringExtra("mandalSerialno");
                        popDistrictId = data.getStringExtra("districtID");
                        selectedSILMOPOPMandalName.setText(popMandalName);
                        selectedPOPName.setText(NO_POP_SELECTED);
                        Log.d(TAG, "pop mandal and district ids " + popMandalID + " " + popDistrictId);
                        //Todo.
                        Utils.showProgress(getActivity(), "Loading POP data....");
                        requestHandler.getAllSILMOPOPData(getActivity(), this, popDistrictId, popMandalID, Constants.GET_SILMOPOPDATA);
                    }
                    break;

            }
        }
    }

    private boolean validateFormFields() {
        boolean isValid = false;
        if (!selectedPOPName.getText().toString().equals(NO_POP_SELECTED)) {
            if (FormValidations.isFormEditTextValid(formAddress1EditText, FormValidations.FORM_FIELDS.ADDRESS1))
                if (validateOptionalFields(OPTIONAL_FIELDS.ADDRESS2))
                    if (FormValidations.isFormEditTextValid(formLocalityEditText, FormValidations.FORM_FIELDS.LOCALITY))
                        if (FormValidations.isFormEditTextValid(formLocationEditText, FormValidations.FORM_FIELDS.LOCATION))
                            if (lmoType.equals("LMO")) {//LMO
                                if (!selectedVillageName.getText().toString().equals(NO_VILLAGE_SELECTED)) {
                                    if (FormValidations.isFormEditTextValid(formPinCodeEditText, FormValidations.FORM_FIELDS.PINCODE))
                                        if (FormValidations.isFormEditTextValid(formMobileEditText, FormValidations.FORM_FIELDS.MOBILE))
                                            if (validateOptionalFields(OPTIONAL_FIELDS.MOBILE_NO1))
                                                if (validateOptionalFields(OPTIONAL_FIELDS.STDCODE))
                                                    isValid = true;
                                } else {
                                    Utils.showDialog(getActivity(),
                                            getString(R.string.invalid_village_title),
                                            getString(R.string.invalid_village_message), null);
                                }
                            } else {//SILMO//Todo

                                if (selectedSILMODistrictName.getSelectedItemPosition() > 0) {
                                    if (!selectedSILMOMandalName.getText().toString().equals("Click to select mandal")) {

                                        if (!selectedSILMOVillageName.getText().toString().equals(NO_VILLAGE_SELECTED)) {
                                            if (FormValidations.isFormEditTextValid(formPinCodeEditText, FormValidations.FORM_FIELDS.SI_PINCODE))
                                                if (FormValidations.isFormEditTextValid(formMobileEditText, FormValidations.FORM_FIELDS.MOBILE))
                                                    if (validateOptionalFields(OPTIONAL_FIELDS.MOBILE_NO1))
                                                        if (validateOptionalFields(OPTIONAL_FIELDS.STDCODE))
                                                            isValid = true;
                                        } else {
                                            isValid = false;
                                            Utils.showDialog(getActivity(),
                                                    getString(R.string.invalid_village_title),
                                                    getString(R.string.invalid_village_message), null);
                                        }

                                    } else {
                                        isValid = false;
                                        Utils.showDialog(getActivity(),
                                                getString(R.string.invalid_mandal_title),
                                                getString(R.string.invalid_mandal_message), null);
                                    }
                                } else {
                                    isValid = false;
                                    Utils.showDialog(getActivity(),
                                            getString(R.string.invalid_district_title),
                                            getString(R.string.invalid_district_message), null);
                                }

                            }
        } else {
            isValid = false;
            Utils.showDialog(getActivity(),
                    getString(R.string.invalid_pop_name_title),
                    getString(R.string.invalid_pop_name_message), null);
        }
        return isValid;
    }

    public void onResume() {
        super.onResume();
        Log.d(TAG, "\t" + "onResume()");
        if (!LocationHelper.getInstance().init(getActivity(), this)) {
            Utils.showNoGPSDialog(getActivity());
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "\t" + "onPause()");
        LocationHelper.getInstance().removeLocationUpdates(getActivity());
    }

    private boolean validateOptionalFields(OPTIONAL_FIELDS field) {
        boolean isValid = true;
        switch (field) {
            case ADDRESS2:
                if (!TextUtils.isEmpty(formAddress2EditText.getText().toString())) {
                    isValid = FormValidations.isFormEditTextValid(formAddress2EditText, FormValidations.FORM_FIELDS.ADDRESS2);
                }
                break;

            case MOBILE_NO1:
                if (!TextUtils.isEmpty(formMobile1EditText.getText().toString())) {
                    isValid = FormValidations.isFormEditTextValid(formMobile1EditText, FormValidations.FORM_FIELDS.ALTERNATE_MOBILE);
                }
                break;

            case STDCODE:
                if (!TextUtils.isEmpty(formSTDCodeEditText.getText().toString()) &&
                        !TextUtils.isEmpty(formLandLineEditText.getText().toString())) {
                    isValid = FormValidations.isFormEditTextValid(formSTDCodeEditText, FormValidations.FORM_FIELDS.STD_CODE);
                    if (isValid) {
                        isValid = FormValidations.isFormEditTextValid(formLandLineEditText, FormValidations.FORM_FIELDS.LANDLINE);
                    }
                } else if (!TextUtils.isEmpty(formSTDCodeEditText.getText().toString()) &&
                        TextUtils.isEmpty(formLandLineEditText.getText().toString())) {
                    Utils.showDialog(getActivity(),
                            getActivity().getString(R.string.invalid_landline_title),
                            getActivity().getString(R.string.empty_landline_message), null);
                    isValid = false;
                } else if (TextUtils.isEmpty(formSTDCodeEditText.getText().toString()) &&
                        !TextUtils.isEmpty(formLandLineEditText.getText().toString())) {
                    Utils.showDialog(getActivity(),
                            getActivity().getString(R.string.invalid_std_code_title),
                            getActivity().getString(R.string.invalid_std_code_message), null);
                    isValid = false;
                }
                break;
        }
        return isValid;
    }

    @Override
    public void onBackPressed() {
        saveFormData();
        getActivity().getSupportFragmentManager().popBackStack();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.selectedSILMODistrictName:
                if (position > 0) {
                    DistrictModel districtModel = districtSpinnerItems.get(position);
                    siLMODistrictId = districtModel.getDistrictID();
                    Utils.showProgress(getActivity(), "Loading Mandals data....");
                    requestHandler.getAllSILMOMandals(getActivity(), this, siLMODistrictId, Constants.GET_MANDALDATA);

                    selectedSILMOMandalName.setText("Click to select mandal");
                    selectedSILMOVillageName.setText(NO_VILLAGE_SELECTED);
                } else {
                    selectedSILMOMandalName.setText("Click to select mandal");
                    selectedSILMOVillageName.setText(NO_VILLAGE_SELECTED);
                    // selectedPOPName.setText(NO_POP_SELECTED);
                }
                break;
            case R.id.selectedSILMOPOPDistrictName:
                if (position > 0) {
                    DistrictModel districtModel = popDistrictSpinnerItems.get(position);
                    popDistrictId = districtModel.getDistrictID();
                    Utils.showProgress(getActivity(), "Loading Pop Mandals data....");
                    requestHandler.getAllSILMOMandals(getActivity(), this, popDistrictId, Constants.GET_SILMOPOPMANDALDATA);

                    selectedSILMOPOPMandalName.setText("Click to select POP mandal");
                    selectedPOPName.setText(NO_POP_SELECTED);
                } else {
                    selectedSILMOPOPMandalName.setText("Click to select POP mandal");
                    selectedPOPName.setText(NO_POP_SELECTED);
                }
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void getLocationFromLatLng(double latitude, double longitude) {
        Log.d("latitude", "\t" + latitude);
        Log.d("longitude", "\t" + longitude);
        formLatitudeEditText.setText(String.format(Locale.getDefault(), "%.4f", latitude));
        formLongitudeEditText.setText(String.format(Locale.getDefault(), "%.4f", longitude));
        if (Utils.isNetworkAvailable(getActivity())) {
            try {
                List<Address> addressList = geocoder.getFromLocation(latitude, longitude, 1);
                if (addressList != null) {
                    String locationName = addressList.get(0).getLocality();
                    Log.d("location", "\t" + locationName);
                    // formLocationEditText.setText(locationName);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void saveFormData() {
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();
            CustomerAddressModel model = realm.where(CustomerAddressModel.class)
                    .equalTo("formTime", Constants.formTime)
                    .findFirst();
            if (model == null) {
                model = new CustomerAddressModel();
                model.setFormTime(Constants.formTime);
            }
            model.setAddress1(formAddress1EditText.getText().toString());
            model.setAddress2(formAddress2EditText.getText().toString());
            model.setLocality(formLocalityEditText.getText().toString());
            model.setPopID(popID);
            model.setPopName(selectedPOPName.getText().toString());
            if (lmoType.equals("LMO")) {
                model.setVillageName(selectedVillageName.getText().toString());
                model.setMandalName(selectedMandalName.getText().toString());
                model.setDistrictName(selectedDistrictName.getText().toString());
            } else {
                model.setVillageName(selectedSILMOVillageName.getText().toString());
                model.setMandalName(selectedSILMOMandalName.getText().toString());
                model.setDistrictName(selectedSILMODistrictName.getSelectedItem().toString());//Todo
                model.setPopmandal(selectedSILMOPOPMandalName.getText().toString());
                model.setPopDistrict(selectedSILMOPOPDistrictName.getSelectedItem().toString());
                model.setPopDistrictId(popDistrictId);
                model.setPopMandalId(popMandalID);
            }
            model.setDistrictID(districtID);
            model.setVillageID(villageID);
            model.setMandalID(mandalID);
            Constants.districtID = districtID;
            Constants.villageID = villageID;
            Constants.mandalID = mandalID;
            model.setPinCode(formPinCodeEditText.getText().toString());
            model.setMobile(formMobileEditText.getText().toString());
            model.setMobile1(formMobile1EditText.getText().toString());
            model.setStdCode(formSTDCodeEditText.getText().toString());
            model.setLandLine(formLandLineEditText.getText().toString());
            model.setCustomerChecked(formCustomerDeclaration.isChecked());
            model.setLMOChecked(formLMODeclaration.isChecked());
            model.setLatitude(formLatitudeEditText.getText().toString());
            model.setLongitude(formLongitudeEditText.getText().toString());
            model.setLocation(formLocationEditText.getText().toString());
            model.setApsflUniqueId(apsflUniqueId);
            CustomerInfoModel infoModel = realm.where(CustomerInfoModel.class)
                    .equalTo("formTime", Constants.formTime)
                    .findFirst();
            model.setCustomerAadhaarNumber(infoModel.getCustomerAadhaarNumber());
            realm.copyToRealmOrUpdate(model);

            OfflineFormModel offlineFormModel = realm.where(OfflineFormModel.class)
                    .equalTo("formTime", Constants.formTime).findFirst();
            offlineFormModel.setFormCAFData(getFormDataAsJSON(offlineFormModel).toString());
            if (Constants.cafType == 2) {
                int otp = (int) (Math.random() * 9000) + 1000;
                Log.d("OTP", "\t" + otp);
                offlineFormModel.setCafOTPNumber(String.valueOf(otp));
            }
            realm.copyToRealmOrUpdate(offlineFormModel);
            realm.commitTransaction();
        } catch (Exception ex) {
            realm.cancelTransaction();
            ex.printStackTrace();
        }
    }

    private JSONObject getFormDataAsJSON(OfflineFormModel offlineFormModel) {
        JSONObject formData = null;
        try {
            formData = new JSONObject(offlineFormModel.getFormCAFData());
            if (Constants.cafType == 2) {
                switch (lmoType) {

                    case "LMO":
                        EnterpriseCustomer enterpriseCustomer = Realm.getDefaultInstance().where(EnterpriseCustomer.class).equalTo("isCustomerChecked", true).findFirst();
                        formData.put("entCustomerCode", enterpriseCustomer.getCustomerID());
                        //formData.put("custCode", enterpriseCustomer.getPaymentCustomerId());
                        formData.put("entCustType", enterpriseCustomer.getEnterPriseCustomerType());
                        break;
                    case "SI":
                        formData.put("entCustomerCode", entCustomerCode);
                        //formData.put("custCode", enterpriseCustomer.getPaymentCustomerId());
                        formData.put("entCustType", entCustType);
                        break;

                }

            } else {
                formData.put("entCustType", "");
                formData.put("entCustomerCode", "");
            }
            formData.put("address1", formAddress1EditText.getText().toString());
            formData.put("address2", formAddress2EditText.getText().toString());
            formData.put("locality", formLocalityEditText.getText().toString());
            formData.put("state", "Telangana");
            formData.put("pinCode", formPinCodeEditText.getText().toString());
            formData.put("city", villageID);
            formData.put("district", districtID);
            formData.put("mandal", mandalID);
            formData.put("stdCode", formSTDCodeEditText.getText().toString());
            formData.put("mobileNo", formMobileEditText.getText().toString());
            formData.put("mobileNo1", formMobile1EditText.getText().toString());
            formData.put("landLineNo", formLandLineEditText.getText().toString());
            formData.put("longitude", longitude);//formLongitudeEditText.getText().toString()
            formData.put("latitude", latitude);//formLatitudeEditText.getText().toString()
            formData.put("location", formLocationEditText.getText().toString());
            formData.put("popId", popID);
            formData.put("customerDec", formCustomerDeclaration.isChecked() ? "Y" : "N");
            formData.put("lmoDec", formLMODeclaration.isChecked() ? "Y" : "N");
            formData.put("cafStatus", offlineFormModel.getCafStatus());

           /* if(Constants.isCAFInEditMode ){
                if(offlineFormModel.isPaymentDataAvailable()){
                    JSONObject cafData = new JSONObject(offlineFormModel.getFormCAFData());
                    if(offlineFormModel.getFormPaymentData() != null && !offlineFormModel.getFormPaymentData().isEmpty() && cafData.get("custId").){}

                }else{
                    formData.put("status", "2");
                }

            }else{
                formData.put("status", "0");
            }*/
            if (Constants.isCAFInEditSILMO) {
                formData.put("status", "88");
            } else {
                formData.put("status", Constants.isCAFInEditMode ? "2" : "0");
            }

            formData.put("popMandal", popMandalID);
            formData.put("popDistrict", popDistrictId);
            formData.put("tenantType", lmoType);
            formData.put("version", Constants.version);
            if (apsflUniqueId.equals("")) {
                formData.put("apsflUniqueId", JSONObject.NULL);
            } else {
                formData.put("apsflUniqueId", apsflUniqueId);
            }
            Log.d("CAF JSON", formData.toString(2));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return formData;
    }

    @Override
    public void onClick(View v) {
        Realm realm = Realm.getDefaultInstance();
        switch (v.getId()) {
            case R.id.previousScreenLayout:
                saveFormData();
                getActivity().getSupportFragmentManager().popBackStack();
                break;

            case R.id.nextScreenLayout:
                if (validateFormFields()) {
                    saveFormData();
//                    if (Constants.isCAFInEditMode) {
//                        startActivity(new Intent(getActivity(), WorkOrderActivity.class));
//                    } else {
                    Constants.aadhaarData = null;
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragmentContainer, new BasePackageFragment())
                            .addToBackStack(BasePackageFragment.class.getSimpleName())
                            .commit();
                   /* if (Constants.cafType == 2) {
                        if (Utils.isNetworkAvailable(getActivity())) {
                            if (lmoType.equals("SI")) {
                                Utils.showProgress(getActivity(), "Loading data....");
                                if (!popID.equals("")) {

                                    requestHandler.getSILMOMasterData2(getActivity(), this, popID, districtID, mandalID, villageID, Constants.GET_SILMOMASTERDATA);
                                } else {
                                    Utils.showDialog(getActivity(), "Invalid Substation",
                                            "Please select Valid Substation", null);
                                }
                            } else {
                                startActivity(new Intent(getActivity(), SendOTPActivity.class));
                            }

                        } else {
                            Utils.showDialog(getActivity(),
                                    "Unable to Sent SMS",
                                    "Due to No Internet Connection", null);

                        }

                    } else {
                       *//* getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragmentContainer, new CustomerCPEInfoFragment())
                                .addToBackStack(CustomerCPEInfoFragment.class.getSimpleName())
                                .commit();*//*
                        switch (lmoType) {

                            case "LMO":
                                getActivity().getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.fragmentContainer, new BasePackageFragment())
                                        .addToBackStack(BasePackageFragment.class.getSimpleName())
                                        .commit();
                                break;
                            case "SI":
                                getActivity().getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.fragmentContainer, new CustomerCPEInfoFragment())
                                        .addToBackStack(CustomerCPEInfoFragment.class.getSimpleName())
                                        .commit();
                                break;

                        }

                    }*/


//                    }
                }
                break;

            case R.id.selectedPOPName:
                if (lmoType.equals("LMO")) {
                    startActivityForResult(new Intent(getActivity(), SelectPOPActivity.class), 1000);
                } else {
                    //RealmResults<POPModel> popModelRealmResults = realm.where(POPModel.class).findAll();
                    // if (popModelRealmResults != null) {
                    startActivityForResult(new Intent(getActivity(), SelectPOPActivity.class), 1000);

                   /* } else {

                        Utils.showDialog(getActivity(),
                               "Select district and mandal",
                                "Please select district and mandal to load Pop data ", null);
                    }*/

                }


                break;

            case R.id.formSelectedVillage:

                startActivityForResult(new Intent(getActivity(), SelectVillageActivity.class), 1001);
                break;
            case R.id.selectedSILMOMandalName:
                RealmResults<MandalModel> mandalModels = realm.where(MandalModel.class).equalTo("districtID", siLMODistrictId).equalTo("isPopMandal", false).findAll();

                if (mandalModels.size() != 0) {
                    Intent intent = new Intent(getActivity(), SelectMandalActivity.class);
                    intent.putExtra("districtID", siLMODistrictId);
                    intent.putExtra("mondalType", "normal");
                    startActivityForResult(intent, 1002);
                } else {
                    Utils.showDialog(getActivity(),
                            "Select Installation District",
                            "Please Select Installation District to Change mandal", null);
                }
                break;
            case R.id.formSelectedSILMOVillage:
                if (selectedSILMODistrictName.getSelectedItemPosition() > 0) {
                    if (!selectedSILMOMandalName.getText().toString().equals("Click to select mandal")) {

                        startActivityForResult(new Intent(getActivity(), SelectInstVillageActivity.class), 1003);
                    } else {

                        Utils.showDialog(getActivity(),
                                getString(R.string.invalid_mandal_title),
                                getString(R.string.invalid_mandal_message), null);
                    }
                } else {

                    Utils.showDialog(getActivity(),
                            getString(R.string.invalid_district_title),
                            getString(R.string.invalid_district_message), null);
                }
                break;
            case R.id.selectedSILMOPOPMandalName:
                RealmResults<MandalModel> popMandalModels = realm.where(MandalModel.class).equalTo("districtID", popDistrictId).equalTo("isPopMandal", true).findAll();
                if (!popMandalModels.isEmpty()) {
                    Intent intent = new Intent(getActivity(), SelectMandalActivity.class);
                    intent.putExtra("districtID", popDistrictId);
                    intent.putExtra("mondalType", "popMandal");
                    startActivityForResult(intent, 1004);
                } else {
                    Utils.showDialog(getActivity(),
                            "Select POP District",
                            "Please Select POP District to Change mandal", null);
                }
                break;
        }
    }

    @Override
    public void responseHandler(Object response, int requestType) {
        switch (requestType) {

            case Constants.GET_MANDALDATA:
                Utils.cancelProgress();
                break;
            case Constants.GET_SILMOVILLAGEDATA:
                Utils.cancelProgress();
                // selectedSILMOVillageName.setText(NO_VILLAGE_SELECTED);
                //Todo
                break;
            case Constants.GET_SILMOPOPDATA:
                Utils.cancelProgress();
                break;
            case Constants.GET_SILMOMASTERDATA:
                Utils.cancelProgress();
                Log.d(TAG, "IN GET_SILMOMASTERDATA");
                if (response != null) {
                    startActivity(new Intent(getActivity(), SendOTPActivity.class));
                } else {
                    Utils.showDialog(this, getString(R.string.request_failure_title),
                            getString(R.string.request_failure_message), null);
                }
                break;
            case Constants.GET_SILMOPOPMANDALDATA:
                Utils.cancelProgress();
                break;
            case Constants.GET_SILMOPOPDATA2:
                Utils.changeProgressMessage("Village Data", "Loading Village data....");
                requestHandler.getAllSILMOVillages(getActivity(), this, siLMODistrictId, siLMOmandalID, Constants.GET_SILMOVILLAGEDATA);
                break;
        }
    }

    private int getIndex(Spinner spinner, String myString) {
        int position = 0;
        for (int i = 0; i < spinner.getCount(); i++) {
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(myString)) {
                position = i;
            }
        }
        // Check for this when you set the position.
        //return -1;
        Log.d(TAG, "" + position);
        return position;

    }

    private enum OPTIONAL_FIELDS {ADDRESS2, MOBILE_NO1, STDCODE}
}
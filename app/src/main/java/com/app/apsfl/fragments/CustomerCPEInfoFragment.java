package com.app.apsfl.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.app.apsfl.R;
import com.app.apsfl.activities.MainActivity;
import com.app.apsfl.activities.WorkOrderActivity;
import com.app.apsfl.adapters.CPEModelSpinnerAdapter;
import com.app.apsfl.adapters.CPEPurchaseSpinnerAdapter;
import com.app.apsfl.adapters.CustomSpinnerAdapter;
import com.app.apsfl.adapters.OLTIDSpinnerAdapter;
import com.app.apsfl.adapters.OLTPortSpinnerAdapter;
import com.app.apsfl.adapters.VpnSpinnerAdapter;
import com.app.apsfl.application.BaseApplication;
import com.app.apsfl.httpClient.RequestHandler;
import com.app.apsfl.interfaces.FragmentBackStackListener;
import com.app.apsfl.interfaces.ResponseHandler;
import com.app.apsfl.interfaces.UserActionInterface;
import com.app.apsfl.models.CPEDataModel;
import com.app.apsfl.models.CPEInfoModel;
import com.app.apsfl.models.CPEStockModel;
import com.app.apsfl.models.CustomerAddressModel;
import com.app.apsfl.models.EnterpriseCustomer;
import com.app.apsfl.models.IptvDataModel;
import com.app.apsfl.models.L1PortModel;
import com.app.apsfl.models.L2PortModel;
import com.app.apsfl.models.OfflineFormModel;
import com.app.apsfl.models.OltPortDetails;
import com.app.apsfl.models.POPOLTModel;
import com.app.apsfl.models.ProductModel;
import com.app.apsfl.models.SelectedIpTvPackage;
import com.app.apsfl.models.VpnServiceModel;
import com.app.apsfl.utils.Constants;
import com.app.apsfl.utils.FormValidations;
import com.app.apsfl.utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;
import io.realm.Sort;


public class CustomerCPEInfoFragment extends Fragment
        implements View.OnClickListener, AdapterView.OnItemSelectedListener,
        FragmentBackStackListener, UserActionInterface, RadioGroup.OnCheckedChangeListener, ResponseHandler {

    private final String TAG = CustomerCPEInfoFragment.class.getSimpleName();
    SharedPreferences sharedPreferences;
    String lmoType;
    private LinearLayout previousScreenLayout, nextScreenLayout;
    private Spinner oltIDSpinner, oltPortIDSpinner, oltPortLevel1Spinner, oltPortLevel2Spinner, oltPortLevel3Spinner,
            cpeONUSpinner, vpnServiceSpinner, telephonicConnCount, iptvConnCount;//, cpeSTBSpinner, cpeSTBPurchaseSpinner
    private EditText formONUMacAddress, formONUSerialNumber,
            onuUpFrontCharges, formInstallationCharge, onuEmiAmount, emiCountEditText;
    // formIPTVInstallments, formIPTVPrice, formIPTVSerialNumber, formIPTVMacAddress;
    // formCPECableChargeEditText;
    private TextView selectedPOPName, oltIDSpinnerHeader, oltPortLevel1Header, oltPortLevel2Header, oltPortLevel3Header,
            oltPortHeader;// formIPTVSpinnerHeader,
    //private RadioGroup formONURadioGroup;//formSTBRadioGroup;
    //private RadioButton onuYesRadioButton, onuNoRadioButton;// stbYesRadioButton, stbNoRadioButton;
    private LinearLayout formIfONULeaseLayout, formVpnLayout, formSTBLayout, stbWrapper, formtelephonicLayout;//, formIPTVLayout, formIfSTBLeaseLayout
    private RealmList<CPEDataModel> onuModelSpinnerItems, onuDeviceSpinnerItems, stbModelSpinnerItems;
    private RealmList<ProductModel> iptvPkgSpinnerItems;
    private RealmList<POPOLTModel> oltIDSpinnerItems;
    private RealmList<OltPortDetails> oltPortSpinnerItems;
    private RealmList<VpnServiceModel> vpnSpinnerItems;
    private String popName = "", popID = "", coreServiceCodes = "", entCustomerCode = "", entCustType = "";
    private RequestHandler requestHandler;
    private Button addIptv, removeIptv;
    public static String level3SlotList = null;
    private JSONArray iptvBoxList = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "\t" + "onCreateView()");
        View layoutView = inflater.inflate(R.layout.fragment_customer_cpe, container, false);
        initViews(layoutView);
        setupToolBar();
        setSpinnerData();
        setData();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                registerListeners();
            }
        }, 500);
        /*  setData();*/
        return layoutView;
    }

    private void initViews(View view) {
        requestHandler = new RequestHandler();
        sharedPreferences = BaseApplication.getSharedPreferences();
        lmoType = sharedPreferences.getString(Constants.TENANT_TYPE, "");
        Realm realm = Realm.getDefaultInstance();
        long value = realm.where(ProductModel.class)
                .equalTo("isProductChecked", true).count();

        Log.d(TAG, "total products isProductChecked cpeinfo " + value);
        LinearLayout previousNextLayout = (LinearLayout) view.findViewById(R.id.previousNextLayout);
        previousScreenLayout = (LinearLayout) previousNextLayout.findViewById(R.id.previousScreenLayout);
        nextScreenLayout = (LinearLayout) previousNextLayout.findViewById(R.id.nextScreenLayout);
        TextView previousScreenName = (TextView) previousScreenLayout.findViewById(R.id.previousScreenName);
        TextView nextScreenName = (TextView) nextScreenLayout.findViewById(R.id.nextScreenName);
        previousScreenName.setText(R.string.select_packages_screen_name);
        nextScreenName.setText("WorkOrder");
        LinearLayout mainLayout = (LinearLayout) view.findViewById(R.id.mainLayout);
        selectedPOPName = (TextView) mainLayout.findViewById(R.id.selectedPOPName);
        oltIDSpinnerHeader = (TextView) mainLayout.findViewById(R.id.oltIDSpinnerHeader);
        oltIDSpinner = (Spinner) mainLayout.findViewById(R.id.oltIDSpinner);
        oltPortHeader = (TextView) mainLayout.findViewById(R.id.oltPortHeader);
        oltPortIDSpinner = (Spinner) mainLayout.findViewById(R.id.oltPortIDSpinner);
        oltPortLevel1Header = (TextView) mainLayout.findViewById(R.id.oltPortLevel1Header);
        oltPortLevel2Header = (TextView) mainLayout.findViewById(R.id.oltPortLevel2Header);
        oltPortLevel3Header = (TextView) mainLayout.findViewById(R.id.oltPortLevel3Header);
        oltPortLevel1Spinner = (Spinner) mainLayout.findViewById(R.id.oltPortLevel1Spinner);
        oltPortLevel2Spinner = (Spinner) mainLayout.findViewById(R.id.oltPortLevel2Spinner);
        oltPortLevel3Spinner = (Spinner) mainLayout.findViewById(R.id.oltPortLevel3Spinner);
        oltPortSpinnerItems = new RealmList<>();
        cpeONUSpinner = (Spinner) mainLayout.findViewById(R.id.cpeModelSpinner);
        cpeONUSpinner.setEnabled(false);
        cpeONUSpinner.setClickable(false);
        onuModelSpinnerItems = new RealmList<>();
        onuDeviceSpinnerItems = new RealmList<>();
        stbModelSpinnerItems = new RealmList<>();
        iptvPkgSpinnerItems = new RealmList<>();
        emiCountEditText = (EditText) mainLayout.findViewById(R.id.emiCountEditText);

        formONUMacAddress = (EditText) mainLayout.findViewById(R.id.formCPEMacAddress);

        formONUMacAddress.setEnabled(false);
        formONUSerialNumber = (EditText) mainLayout.findViewById(R.id.formONUID);
        onuUpFrontCharges = (EditText) mainLayout.findViewById(R.id.formCPEUpFrontChargesEditText);
        formInstallationCharge = (EditText) mainLayout.findViewById(R.id.formCPEInstallationEditText);

        //formCPECableChargeEditText = (EditText) mainLayout.findViewById(R.id.formCPECableChargeEditText);
       /* formONURadioGroup = (RadioGroup) mainLayout.findViewById(R.id.formCPERadioGroup);
        onuYesRadioButton = (RadioButton) formONURadioGroup.findViewById(R.id.cpeYesRadioButton);
        onuNoRadioButton = (RadioButton) formONURadioGroup.findViewById(R.id.cpeNoRadioButton);
        formONURadioGroup.check(R.id.cpeYesRadioButton);*/

        formIfONULeaseLayout = (LinearLayout) mainLayout.findViewById(R.id.formIfCPELeaseLayout);
        //formIfONULeaseLayout.setVisibility(View.GONE);
        onuEmiAmount = (EditText) mainLayout.findViewById(R.id.formONUemiAmountEditText);

        formVpnLayout = (LinearLayout) mainLayout.findViewById(R.id.formVpnLayout);
        formVpnLayout.setVisibility(View.GONE);
        vpnServiceSpinner = (Spinner) mainLayout.findViewById(R.id.vpnServiceSpinner);
        vpnSpinnerItems = new RealmList<>();

        formSTBLayout = (LinearLayout) mainLayout.findViewById(R.id.formSTBLayout);
        stbWrapper = (LinearLayout) mainLayout.findViewById(R.id.stbWrapper);
        formSTBLayout.setVisibility(View.GONE);

        addIptv = (Button) mainLayout.findViewById(R.id.add_iptv);
        removeIptv = (Button) mainLayout.findViewById(R.id.remove_iptv);
        formtelephonicLayout = (LinearLayout) mainLayout.findViewById(R.id.formtelephonicLayout);
        telephonicConnCount = (Spinner) mainLayout.findViewById(R.id.telephonicConnCount);
        formtelephonicLayout.setVisibility(View.GONE);
        /*iptvConnCount = (Spinner) mainLayout.findViewById(R.id.iptvConnCount);*/
       /* if (Constants.cafType == 2) {
            formIPTVSpinnerHeader.setText(R.string.cpe_stb_model_optional_text);
        } else {
            formIPTVSpinnerHeader.setText(R.string.cpe_stb_model_mandatory_text);
        }*/
       /* if (Constants.isFromCAFResults) {
            previousScreenLayout.setVisibility(View.GONE);
            nextScreenLayout.setVisibility(View.GONE);
            LinearLayout nextLayout = (LinearLayout) previousNextLayout.findViewById(R.id.nextLayout);
            TextView screenName = (TextView) nextLayout.findViewById(R.id.nextScreenName);
            screenName.setText("Work Order");
            nextLayout.setVisibility(View.VISIBLE);
            nextLayout.setOnClickListener(this);
        }*/
        //loading package data
        checkForIpTvAndVpnVisibility();

    }

    private void setupToolBar() {
        ActionBar mActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setTitle(R.string.fragment_cpe_info_title);
        }
    }

    private void registerListeners() {
        previousScreenLayout.setOnClickListener(this);
        nextScreenLayout.setOnClickListener(this);
        addIptv.setOnClickListener(this);
        removeIptv.setOnClickListener(this);
        oltIDSpinner.setOnItemSelectedListener(this);
        oltPortIDSpinner.setOnItemSelectedListener(this);
        oltPortLevel1Spinner.setOnItemSelectedListener(this);
        oltPortLevel2Spinner.setOnItemSelectedListener(this);
        oltPortLevel3Spinner.setOnItemSelectedListener(this);
        cpeONUSpinner.setOnItemSelectedListener(this);
        //emiCountEditText.setOnItemSelectedListener(this);
        telephonicConnCount.setOnItemSelectedListener(this);
        /* iptvConnCount.setOnItemSelectedListener(this);*/
        formONUSerialNumber.addTextChangedListener(new GenericTextWatcher(formONUSerialNumber));
       /* formONURadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.cpeYesRadioButton:
                        formIfONULeaseLayout.setVisibility(View.GONE);
                        emiCountEditText.setSelection(0);
                        onuUpFrontCharges.setText("");
                        onuEmiAmount.setText("");
                        onuEmiAmount.setHint(R.string.cpe_installments_hint);
                        break;

                    case R.id.cpeNoRadioButton:
                        formIfONULeaseLayout.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });
*/
    }

    private void setData() {
        Realm realm = Realm.getDefaultInstance();
        CustomerAddressModel addressModel = realm.where(CustomerAddressModel.class)
                .equalTo("formTime", Constants.formTime).findFirst();
        if (addressModel != null) {
            popName = addressModel.getPopName();
            popID = addressModel.getPopID();
            selectedPOPName.setText(popName);
            if (lmoType.equals("SI")) {
                entCustomerCode = addressModel.getEntCustomerCode();
                entCustType = addressModel.getEntCustType();
            }
        }
        CPEInfoModel model = realm.where(CPEInfoModel.class)
                .equalTo("formTime", Constants.formTime).findFirst();
        if (model != null) {
            Log.d("CPE Model", "\t" + model.toString());
            if (popName.isEmpty()) {
                popName = model.getCpePOPName();
            }
            if (!popName.equals(model.getCpePOPName())) {

                oltPortHeader.setVisibility(View.GONE);
                oltPortIDSpinner.setVisibility(View.GONE);
                oltPortLevel1Header.setVisibility(View.GONE);
                oltPortLevel1Spinner.setVisibility(View.GONE);
                oltPortLevel2Header.setVisibility(View.GONE);
                oltPortLevel2Spinner.setVisibility(View.GONE);
                oltPortLevel3Header.setVisibility(View.GONE);
                oltPortLevel3Spinner.setVisibility(View.GONE);
                //oltIDSpinner.setSelection(0);
                Log.d(TAG, "Test1");
                loadOltIDData(0);


            } else {
                loadOltIDData(model.getCpeOLTIDPosition());
                if (model.getCpeOLTIDPosition() > 0) {
                    int portIDPosition = model.getCpeOLTPortIDPosition();
                    loadPortData(model.getCpeOLTIDPosition(), portIDPosition);
                    if (portIDPosition > 0) {
                        loadL1PortData(model.getCpeOLTPortIDPosition(), model.getCpeLevel1SlotPosition());
                        if (model.getCpeLevel1SlotPosition() > 0) {
                            loadL2andL3PortData(model.getCpeLevel1SlotPosition(),
                                    model.getCpeLevel2SlotPosition(),
                                    model.getCpeLevel3SlotPosition());
                           /* if ((model.getCpeLevel2SlotPosition() > 0) && (model.getCpeLevel3SlotPosition() > 0)) {

                            }*/
                        } else {
                            oltPortLevel2Header.setVisibility(View.GONE);
                            oltPortLevel2Spinner.setVisibility(View.GONE);
                            oltPortLevel3Header.setVisibility(View.GONE);
                            oltPortLevel3Spinner.setVisibility(View.GONE);
                        }
                    } else {
                        oltPortLevel1Header.setVisibility(View.GONE);
                        oltPortLevel1Spinner.setVisibility(View.GONE);
                        oltPortLevel2Header.setVisibility(View.GONE);
                        oltPortLevel2Spinner.setVisibility(View.GONE);
                        oltPortLevel3Header.setVisibility(View.GONE);
                        oltPortLevel3Spinner.setVisibility(View.GONE);
                    }
                } else {
                    oltPortHeader.setVisibility(View.GONE);
                    oltPortIDSpinner.setVisibility(View.GONE);
                    oltPortLevel1Header.setVisibility(View.GONE);
                    oltPortLevel1Spinner.setVisibility(View.GONE);
                    oltPortLevel2Header.setVisibility(View.GONE);
                    oltPortLevel2Spinner.setVisibility(View.GONE);
                    oltPortLevel3Header.setVisibility(View.GONE);
                    oltPortLevel3Spinner.setVisibility(View.GONE);
                }
            }

            /*if (model.getONUChecked()) {
                formONURadioGroup.check(R.id.cpeYesRadioButton);

            } else {
                formONURadioGroup.check(R.id.cpeNoRadioButton);
                formIfONULeaseLayout.setVisibility(View.VISIBLE);*/
            //emiCountEditText.setSelection(model.getOnuDevicePurchasePosition());
                /*onuEmiAmount.setText(model.getOnuPriceForInstallment());
                onuUpFrontCharges.setText(model.getOnuUpfrontEmount());*/


            //}
            formONUSerialNumber.setText(model.getOnuSerialNumber());
            formONUMacAddress.setText(model.getOnuMacAddress());
            cpeONUSpinner.setSelection(model.getOnuModelPosition());
            emiCountEditText.setText(model.getNoOfOnuInstallments());
            onuEmiAmount.setText(model.getOnuPriceForInstallment());
            onuUpFrontCharges.setText(model.getOnuUpfrontEmount());
            formInstallationCharge.setText(model.getOnuInstallationCharge());
            //telephonicConnCount.setSelection(model.getTeleConnCountPosition());
            //loadOnuPurchaseSpinner(model.getOnuModelPosition(), model.getOnuDevicePurchasePosition());
//need to check products are changed or not &&if changed remove iptv data
            /*if (isPackageChanged()) {
                Log.d(TAG, "In changed method");
                realm.where(IptvDataModel.class).equalTo("formTime", Constants.formTime).findAll().deleteAllFromRealm();
                checkForIpTvAndVpnVisibility();
            } else {*/
            Log.d(TAG, "In changed method");
            loadVpnData(model.getCpeOLTIDPosition(), model.getVpnSpinnerPosition());
            loadTelephoneConne(model.getTeleConnCountPosition());
            /*loadIptvConne(model.getIptvConnCountPosition());*/
            setStbData(model);

            //}
        } else {
            oltPortHeader.setVisibility(View.GONE);
            oltPortIDSpinner.setVisibility(View.GONE);
            oltPortLevel1Header.setVisibility(View.GONE);
            oltPortLevel1Spinner.setVisibility(View.GONE);
            oltPortLevel2Header.setVisibility(View.GONE);
            oltPortLevel2Spinner.setVisibility(View.GONE);
            oltPortLevel3Header.setVisibility(View.GONE);
            oltPortLevel3Spinner.setVisibility(View.GONE);
            Log.d("POPName", "\t" + popName);
            //if (popName.equals("null")&!popName.isEmpty()) {
            loadOltIDData(0);
            loadTelephoneConne(0);
            /* loadIptvConne(0);*/
            //checkForIpTvAndVpnVisibility();

            //}
        }
       /* if (lmoType.equals("SI")) {

            onuYesRadioButton.setEnabled(false);
            onuNoRadioButton.setEnabled(false);
           *//* stbYesRadioButton.setEnabled(false);
            stbNoRadioButton.setEnabled(false);*//*
        }*/
    }

    private void setSpinnerData() {
      /*  String[] onuDeviceSpinnerItems = getResources().getStringArray(R.array.onu_device_spinner_items);
        CustomSpinnerAdapter onuAdapter = new CustomSpinnerAdapter(getActivity(), onuDeviceSpinnerItems);
        emiCountEditText.setAdapter(onuAdapter);*/
        Realm realm = Realm.getDefaultInstance();
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
        onuModelSpinnerItems.addAll(realm.where(CPEDataModel.class).equalTo("cpeLovType", "ONU").distinct("cpeProfileID"));
        CPEModelSpinnerAdapter onuModelSpinnerAdapter = new CPEModelSpinnerAdapter(getActivity(), onuModelSpinnerItems);
        cpeONUSpinner.setAdapter(onuModelSpinnerAdapter);

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
                stbModelSpinnerItems.addAll(realm.where(CPEDataModel.class).equalTo("cpeLovType", "IPTV/Android Box").distinct("cpeProfileID"));
                CPEModelSpinnerAdapter stbModelSpinnerAdapter = new CPEModelSpinnerAdapter(getActivity(), stbModelSpinnerItems);
                spinner.setAdapter(stbModelSpinnerAdapter);
                break;
           /* case R.id.stbDevicePurchaseSpinner:
                int onuProfileID = stbModelSpinnerItems.get(stbPosition).getCpeProfileID();
                stbDeviceSpinnerItems.clear();
                CPEDataModel onuDataModel = new CPEDataModel();
                onuDataModel.setCpeProfileID(-1);
                onuDataModel.setCpeInstallmentCount("--Select--");
                onuDataModel.setCpeModelName(null);
                onuDataModel.setCpeProfileName(null);
                onuDataModel.setCpeModelDetails(null);
                onuDataModel.setCpePurchaseCost(null);
                onuDataModel.setCpeRentalCost(null);
                onuDataModel.setCpeInstallationCost(null);
                stbDeviceSpinnerItems.add(onuDataModel);
                stbDeviceSpinnerItems.addAll(realm.where(CPEDataModel.class).equalTo("cpeProfileID", onuProfileID).findAll());
                CPEPurchaseSpinnerAdapter stbPurchaseAdapter = new CPEPurchaseSpinnerAdapter(getActivity(), stbDeviceSpinnerItems);
                emiCountEditText.setAdapter(stbPurchaseAdapter);
                emiCountEditText.setSelection(stbPurchasePosition);


                String[] stbDeviceSpinnerItems = getResources().getStringArray(R.array.stb_device_spinner_items);
                CustomSpinnerAdapter stbAdapter = new CustomSpinnerAdapter(getActivity(), stbDeviceSpinnerItems);
                spinner.setAdapter(stbAdapter);
                break;*/

        }

    }

    private void setStbData(CPEInfoModel cpeInfoModel) {

        //Set Iptv data

        RealmList<IptvDataModel> stbList = cpeInfoModel.getSelectedIptvList();
        Log.d("setStbData", stbList.size() + "");
        if (stbList.size() == 0) {
            Realm realm = Realm.getDefaultInstance();
            RealmResults<ProductModel> products = realm.where(ProductModel.class)
                    .equalTo("isProductChecked", true)
                    .findAll();
            boolean isContainsIpTv = false;
            if (products.size() > 0) {
                for (ProductModel productModel : products) {
                    if (productModel.getCoreServiceCode().contains("IPTV")) {
                        formSTBLayout.setVisibility(View.VISIBLE);
                        isContainsIpTv = true;
                    }
                }

                if (isContainsIpTv) {
                    formSTBLayout.setVisibility(View.VISIBLE);
                    constructIptvLayout();
                }

            }
        } else {


            for (final IptvDataModel iptvDataModel : stbList) {
                final Spinner cpeSTBSpinner;
                final TextView iptvPackage, iptvPackageHeader;
                final EditText iptvBoxUpfrontPrice, iptvBoxEmiprice, formIPTVSerialNumber, formIPTVMacAddress, iptvEmiCount;
                final LinearLayout formIPTVLayout, formIfSTBLeaseLayout;
                //RadioGroup formSTBRadioGroup;
                //RadioButton stbYesRadioButton, stbNoRadioButton;
                final ArrayList<SelectedIpTvPackage> ipTvPackageProducts = new ArrayList<>();
                final boolean[] checkedPackages;
                final String[] selectedPackages;
                final String[] selectedPackageCode;
                final RealmList<CPEDataModel> stbDeviceSpinnerItems = new RealmList<>();

                int stbChildSize = stbList.indexOf(iptvDataModel);
                LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
                LinearLayout iptvLayout = (LinearLayout) layoutInflater.inflate(R.layout.layout_iptv, null);
                cpeSTBSpinner = (Spinner) iptvLayout.findViewById(R.id.cpeSTBModelSpinner);
                cpeSTBSpinner.setEnabled(false);
                cpeSTBSpinner.setClickable(false);
                setStbSpinner(cpeSTBSpinner);
                iptvEmiCount = (EditText) iptvLayout.findViewById(R.id.iptvEmiCount);
                // setStbSpinner(iptvEmiCountSpinner);
                iptvBoxUpfrontPrice = (EditText) iptvLayout.findViewById(R.id.iptvBoxUpfrontPrice);
                formIPTVLayout = (LinearLayout) iptvLayout.findViewById(R.id.formIPTVLayout);
               /* formSTBRadioGroup = (RadioGroup) iptvLayout.findViewById(R.id.formSTBRadioGroup);
                stbYesRadioButton = (RadioButton) formSTBRadioGroup.findViewById(R.id.stbYesRadioButton);
                stbNoRadioButton = (RadioButton) formSTBRadioGroup.findViewById(R.id.stbNoRadioButton);
                formSTBRadioGroup.check(R.id.stbYesRadioButton);*/
                formIfSTBLeaseLayout = (LinearLayout) iptvLayout.findViewById(R.id.formIfSTBLeaseLayout);
                // formIfSTBLeaseLayout.setVisibility(View.GONE);
                iptvBoxEmiprice = (EditText) iptvLayout.findViewById(R.id.iptvBoxEmiprice);
                formIPTVSerialNumber = (EditText) iptvLayout.findViewById(R.id.formIPTVSerialNoEditText);
                formIPTVMacAddress = (EditText) iptvLayout.findViewById(R.id.formIPTVMacAddressEditText);
                formIPTVMacAddress.setEnabled(false);
                /*if (lmoType.equals("SI")) {
                    stbYesRadioButton.setEnabled(false);
                    stbNoRadioButton.setEnabled(false);
                }*/

                iptvPackage = (TextView) iptvLayout.findViewById(R.id.iptvPackage);
                iptvPackageHeader = (TextView) iptvLayout.findViewById(R.id.iptvPackageHeader);
                Realm realm = Realm.getDefaultInstance();
                RealmResults<ProductModel> productModelsResult = realm.where(ProductModel.class).equalTo("isProductChecked", true)
                        .contains("coreServiceCode", "IPTV").notEqualTo("productType", "B").findAllSorted("productName", Sort.DESCENDING);
                checkedPackages = new boolean[productModelsResult.size()];
                selectedPackages = new String[productModelsResult.size()];
                selectedPackageCode = new String[productModelsResult.size()];
                String staticPackagesNames = "";
                Log.d("selectedPackages size", productModelsResult.size() + "");
                if (productModelsResult.size() > 0) {
                    for (int i = 0; i < productModelsResult.size(); i++) {
                        selectedPackages[i] = productModelsResult.get(i).getProductName();
                        selectedPackageCode[i] = productModelsResult.get(i).getProductCode();
                    }
                    for (String s : selectedPackages) {
                        if (staticPackagesNames.equals("")) {
                            staticPackagesNames = s;
                        } else {
                            staticPackagesNames += "," + s;
                        }
                    }
                    iptvPackage.setText(staticPackagesNames);
                    iptvPackage.setEnabled(false);
                } else {
                    iptvPackage.setText("");
                    iptvPackage.setEnabled(false);
                    iptvPackage.setVisibility(View.GONE);
                    iptvPackageHeader.setVisibility(View.GONE);
                }


                cpeSTBSpinner.setTag(stbChildSize);
                iptvEmiCount.setTag(stbChildSize);
                iptvPackage.setTag(stbChildSize);
                iptvBoxUpfrontPrice.setTag(stbChildSize);
                formIPTVLayout.setTag(stbChildSize);
               /* formSTBRadioGroup.setTag(stbChildSize);
                stbYesRadioButton.setTag(stbChildSize);
                stbNoRadioButton.setTag(stbChildSize);*/
                formIfSTBLeaseLayout.setTag(stbChildSize);
                iptvBoxEmiprice.setTag(stbChildSize);
                iptvBoxUpfrontPrice.setTag(stbChildSize);
                formIPTVSerialNumber.setTag(stbChildSize);
                formIPTVMacAddress.setTag(stbChildSize);

                cpeSTBSpinner.setSelection(iptvDataModel.getStbModelPosition());

               /* if (iptvDataModel.getSTBChecked()) {
                    formSTBRadioGroup.check(R.id.stbYesRadioButton);
                } else {
                    formSTBRadioGroup.check(R.id.stbNoRadioButton);
                    formIfSTBLeaseLayout.setVisibility(View.VISIBLE);
                }*/

                formIPTVSerialNumber.setText(iptvDataModel.getIpTVSerialNumber());
                formIPTVMacAddress.setText(iptvDataModel.getIpTVMacAddress());

                // iptvEmiCount.setSelection(iptvDataModel.getStbDevicePurchasePosition());
                iptvEmiCount.setText(iptvDataModel.getNoOfIptvInstallments());
                iptvBoxEmiprice.setText(iptvDataModel.getIptvPriceForInstallment());
                iptvBoxUpfrontPrice.setText(iptvDataModel.getUpfrontAmount());


           /* String ipTvpkgNames = iptvDataModel.getIptvPkg();
            String[] pkgNames = ipTvpkgNames.split(",");
            boolean resetPkgtext = false;
            for (String name : pkgNames) {
                if (!Arrays.asList(selectedPackages).contains(name)) {
                    resetPkgtext = true;
                }
            }
            if (resetPkgtext) {
                iptvPackage.setText("--Select--");
            } else {
                iptvPackage.setText(iptvDataModel.getIptvPkg());
            }*/


                //iptvPackage.setText(iptvDataModel.getIptvPkg());
                cpeSTBSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        CPEDataModel cpeDataModel = stbModelSpinnerItems.get(position);

                        if (cpeDataModel.getCpeProfileID() != -1) {

                            iptvEmiCount.setText(cpeDataModel.getCpeInstallmentCount());
                            iptvBoxUpfrontPrice.setText(cpeDataModel.getUpFrontCharges());
                            iptvBoxEmiprice.setText(cpeDataModel.getCpePurchaseCost());
                            //loadstbPurchaseSpinner(stbDeviceSpinnerItems, iptvEmiCountSpinner, position, iptvDataModel.getStbDevicePurchasePosition());
                        } else {
                            iptvEmiCount.setText("");
                            iptvBoxUpfrontPrice.setText("");
                            iptvBoxEmiprice.setText("");
                            //iptvEmiCountSpinner.setSelection(0);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
               /* iptvEmiCount.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        CPEDataModel cpeDataModel = stbDeviceSpinnerItems.get(position);
                        if (cpeDataModel.getCpeProfileID() != -1) {
                            iptvBoxEmiprice.setText(cpeDataModel.getCpeInstallmentCost());
                            iptvBoxUpfrontPrice.setText(cpeDataModel.getUpFrontCharges());
                            // formInstallationCharge.setText(cpeDataModel.getCpeInstallationCost());
                            //onuEmiAmount.setText("");
                            //onuEmiAmount.setHint(R.string.cpe_installments_hint);
                        } else {
                            iptvBoxEmiprice.setText("");
                            iptvBoxUpfrontPrice.setText("");
                        }


                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });*/
                formIPTVSerialNumber.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        String stbSerialNumber = formIPTVSerialNumber.getText().toString();
                        int stbPositionId = stbModelSpinnerItems.get(cpeSTBSpinner.getSelectedItemPosition()).getCpeProfileID();
                        CPEStockModel iptvCpeStocks = Realm.getDefaultInstance().where(CPEStockModel.class).
                                equalTo("cpeSerialNumber", stbSerialNumber).equalTo("cpeProfileID", stbPositionId).findFirst();
                        if (iptvCpeStocks != null) {
                            String macId = iptvCpeStocks.getCpeMacId();
                            formIPTVMacAddress.setText(macId);

                        } else {
                            formIPTVMacAddress.setText("");
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
              /*  formSTBRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        switch (checkedId) {
                            case R.id.stbYesRadioButton:
                                formIfSTBLeaseLayout.setVisibility(View.GONE);
                                iptvEmiCountSpinner.setSelection(0);
                                iptvBoxUpfrontPrice.setText("");
                                iptvBoxEmiprice.setText("");
                                iptvBoxEmiprice.setHint(R.string.iptv_installments_hint);
                                break;

                            case R.id.stbNoRadioButton:
                                formIfSTBLeaseLayout.setVisibility(View.VISIBLE);
                                break;
                        }
                    }
                });*/
           /* iptvPackage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iptvPackage.setText("");
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                    //make a list to hold state of multi selected pkg item

                    for (int i = 0; i < selectedPackages.length; i++) {
                        SelectedIpTvPackage selectedIpTvPackage = new SelectedIpTvPackage();
                        selectedIpTvPackage.setPackageName(selectedPackages[i]);
                        selectedIpTvPackage.setpackagecode(selectedPackageCode[i]);
                        selectedIpTvPackage.setSelectedPackages(checkedPackages[i]);
                        ipTvPackageProducts.add(selectedIpTvPackage);
                    }

                    builder.setMultiChoiceItems(selectedPackages, checkedPackages, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            //set state to pojo list
                            ipTvPackageProducts.get(which).setSelectedPackages(isChecked);
                        }
                    });
                    builder.setCancelable(false);
                    builder.setTitle("Selected Packages");

                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // save state of selected vos
                            ArrayList<SelectedIpTvPackage> selectedList = new ArrayList<>();
                            Log.d("ipTvPackageProduct size", ipTvPackageProducts.size() + "");
                            for (int i = 0; i < ipTvPackageProducts.size(); i++) {
                                Log.d("i value", i + "");
                                SelectedIpTvPackage selectedIpTvPackage = ipTvPackageProducts.get(i);
                                selectedPackages[i] = selectedIpTvPackage.getPackageName();
                                selectedPackageCode[i] = selectedIpTvPackage.getPackageCOde();
                                checkedPackages[i] = selectedIpTvPackage.isSelectedPackages();
                                if (selectedIpTvPackage.isSelectedPackages()) {
                                    selectedList.add(selectedIpTvPackage);
                                }
                            }

                            for (int i = 0; i < selectedList.size(); i++) {
                                // if element is last then not attach comma or attach it
                                if (i != selectedList.size() - 1)
                                    iptvPackage.setText(iptvPackage.getText() + selectedList.get(i).getPackageName() + ",");
                                else
                                    iptvPackage.setText(iptvPackage.getText() + selectedList.get(i).getPackageName());
                            }
                            ipTvPackageProducts.clear();
                        }
                    });

                  *//*  builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // make sure to clear list that duplication dont formed here
                            ipTvPackageProducts.clear();
                        }
                    });

                    builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // make sure to clear list that duplication dont formed here
                            ipTvPackageProducts.clear();
                        }
                    });*//*

                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            });
*/
                stbWrapper.addView(iptvLayout);
            }
        }

    }

    /* private void setStbData1(CPEInfoModel cpeInfoModel) {

         //Set Iptv data
         Realm realm = Realm.getDefaultInstance();
         int ipTvChaildCount = stbWrapper.getChildCount();
         if (ipTvChaildCount != 0) {
             for (int i = 0; i < ipTvChaildCount; i++) {
                 Log.d("stbWrapper ChildCount", stbWrapper.getChildCount() + "");
                 Log.d("stbWrapper i", i + "");
                 LinearLayout iptvLayout = (LinearLayout) stbWrapper.getChildAt(i);
                 Log.d("iptvLayout ChildCount", iptvLayout.getChildCount() + "");
                 Log.d("iptvLayout", iptvLayout.getTag().toString());
                 IptvDataModel iptvDataModel = realm.where(IptvDataModel.class)
                         .equalTo("iptvposition", i).equalTo("formTime", Constants.formTime)
                         .findFirst();
                 Log.d(TAG,"iptvDataModel"+iptvDataModel.toString());
                 if(iptvDataModel!=null){
                     View stbModelSpinnerView = iptvLayout.getChildAt(1);
                     Spinner stbModelSpinner = (Spinner) stbModelSpinnerView;
                     //Object tag = stbModelSpinner.getTag();
                     int position = stbModelSpinner.getSelectedItemPosition();
                     stbModelSpinner.setSelection(iptvDataModel.getStbModelPosition());

                     View formIPTVSerialNoEditTextView = iptvLayout.getChildAt(3);
                     EditText formIPTVSerialNoEditText = (EditText) formIPTVSerialNoEditTextView;
                     formIPTVSerialNoEditText.setText(iptvDataModel.getIpTVSerialNumber());

                     View formIPTVMacAddressEditTextView = iptvLayout.getChildAt(5);
                     EditText formIPTVMacAddressEditText = (EditText) formIPTVMacAddressEditTextView;
                     formIPTVMacAddressEditText.setText(iptvDataModel.getIpTVMacAddress());

                     View formSTBLeaseLayoutView = iptvLayout.getChildAt(6);
                     LinearLayout formSTBLeaseLayout = (LinearLayout) formSTBLeaseLayoutView;

                     View formSTBRadioGroupView = formSTBLeaseLayout.getChildAt(1);
                     RadioGroup formSTBRadioGroup = (RadioGroup) formSTBRadioGroupView;

                     View stbYesRadioButtonView = formSTBRadioGroup.getChildAt(0);
                     RadioButton stbYesRadioButton = (RadioButton) stbYesRadioButtonView;
                     stbYesRadioButton.setChecked(iptvDataModel.getSTBChecked());

                     View stbNoRadioButtonView = formSTBRadioGroup.getChildAt(1);
                     RadioButton stbNoRadioButton = (RadioButton) stbNoRadioButtonView;
                     boolean value1 = stbNoRadioButton.isChecked();

                     View formIfSTBLeaseLayoutView = iptvLayout.getChildAt(7);
                     LinearLayout formIfSTBLeaseLayout = (LinearLayout) formIfSTBLeaseLayoutView;

                     View stbDevicePurchaseSpinnerView = formIfSTBLeaseLayout.getChildAt(1);
                     Spinner stbDevicePurchaseSpinner = (Spinner) stbDevicePurchaseSpinnerView;
                     stbDevicePurchaseSpinner.setSelection(iptvDataModel.getStbDevicePurchasePosition());


                     View iptvBoxEmiPrice = formIfSTBLeaseLayout.getChildAt(3);
                     EditText iptvBoxEmiPriceEditText = (EditText) iptvBoxEmiPrice;
                     iptvBoxEmiPriceEditText.setText(iptvDataModel.getIptvPriceForInstallment());


                     View iptvUpfrontPrice = formIfSTBLeaseLayout.getChildAt(5);
                     EditText iptvUpfrontPriceEditText = (EditText) iptvUpfrontPrice;
                     iptvUpfrontPriceEditText.setText(iptvDataModel.getUpfrontAmount());

                     View iptvPackageView = iptvLayout.getChildAt(9);
                     TextView iptvPackage = (TextView) iptvPackageView;
                     iptvPackage.setText(iptvDataModel.getIptvPkg());
                 }

             }
         }

     }
 */
    private boolean validateFormFields() {
        boolean isValid = false;
        if (FormValidations.isFormSpinnerItemSelected(oltIDSpinner, FormValidations.SPINNER.OLT_ID))
            if (FormValidations.isFormSpinnerItemSelected(oltPortIDSpinner, FormValidations.SPINNER.OLT_PORT_ID))
                if (lmoType.equals("SI") || FormValidations.isFormSpinnerItemSelected(oltPortLevel1Spinner, FormValidations.SPINNER.OLT_LEVEL_1))
                    if (lmoType.equals("SI") || FormValidations.isFormSpinnerItemSelected(oltPortLevel2Spinner, FormValidations.SPINNER.OLT_LEVEL_2))
                        if (lmoType.equals("SI") || FormValidations.isFormSpinnerItemSelected(oltPortLevel3Spinner, FormValidations.SPINNER.OLT_LEVEL_3))
                            if (lmoType.equals("SI") || areLevelSlotsValid())
                                if (FormValidations.isFormSpinnerItemSelected(cpeONUSpinner, FormValidations.SPINNER.ONU_MODEL))
                                    if (FormValidations.isFormEditTextValid(formONUSerialNumber, FormValidations.FORM_FIELDS.ONU_ID))
                                        if (isSerialNumberValid(formONUSerialNumber.getText().toString(), onuModelSpinnerItems.get(cpeONUSpinner.getSelectedItemPosition()).getCpeProfileID(), true) &&
                                                areSerialNumbersSubmitted(true, formONUSerialNumber.getText().toString()))
                                            // if (FormValidations.isFormEditTextValid(formONUMacAddress, FormValidations.FORM_FIELDS.ONU_MAC_ADDRESS))
                                           /* if (formIfONULeaseLayout.getVisibility() == View.VISIBLE) {
                                                if (FormValidations.isFormSpinnerItemSelected(emiCountEditText, FormValidations.SPINNER.ONU_DEVICE_PURCHASE))
                                                    // if (FormValidations.isFormEditTextValid(formCPECableChargeEditText, FormValidations.FORM_FIELDS.EXTRA_CABLE_CHARGE))
                                                    if (formtelephonicLayout.getVisibility() == View.GONE || FormValidations.isFormSpinnerItemSelected(telephonicConnCount, FormValidations.SPINNER.TELEPHONICCONN_COUNT))
                                                        if (formVpnLayout.getVisibility() == View.VISIBLE) {
                                                            if (FormValidations.isFormSpinnerItemSelected(vpnServiceSpinner, FormValidations.SPINNER.VPNSERVICE))
                                                                if (validateIptvLayout())
                                                                    isValid = true;
                                                        } else {
                                                            if (validateIptvLayout())
                                                                isValid = true;
                                                        }
                                            } else {*/
                                            if (formtelephonicLayout.getVisibility() == View.GONE || FormValidations.isFormSpinnerItemSelected(telephonicConnCount, FormValidations.SPINNER.TELEPHONICCONN_COUNT))
                                                if (formVpnLayout.getVisibility() == View.VISIBLE) {
                                                    if (FormValidations.isFormSpinnerItemSelected(vpnServiceSpinner, FormValidations.SPINNER.VPNSERVICE))
                                                        if (validateIptvLayout())
                                                            isValid = true;
                                                } else {
                                                    if (validateIptvLayout())
                                                        isValid = true;
                                                }

        //}
        //isValid = true;//Todo remove
        return isValid;

    }

    private boolean validateIptvLayout() {
        boolean isValid = false, isSerialNoused = false;
        //need to handle if no iptv layout//Todo
        int ipTvChaildCount = stbWrapper.getChildCount();
        if (ipTvChaildCount != 0) {
            for (int i = 0; i < ipTvChaildCount; i++) {
                LinearLayout iptvLayout = (LinearLayout) stbWrapper.getChildAt(i);


                View formIPTVSerialNoEditTextView = iptvLayout.getChildAt(1);
                EditText formIPTVSerialNoEditText = (EditText) formIPTVSerialNoEditTextView;
                if (i > 0) {
                    for (int J = 0; J < i; J++) {

                        LinearLayout previousIptvLayout = (LinearLayout) stbWrapper.getChildAt(J);

                        View PreviousFormIPTVSerialNoEditTextView = previousIptvLayout.getChildAt(1);
                        EditText PreviousFormIPTVSerialNoEditText = (EditText) PreviousFormIPTVSerialNoEditTextView;

                        isSerialNoused = formIPTVSerialNoEditText.getText().toString().equals(PreviousFormIPTVSerialNoEditText.getText().toString());
                    }
                }
                View formIPTVMacAddressEditTextView = iptvLayout.getChildAt(3);
                EditText formIPTVMacAddressEditText = (EditText) formIPTVMacAddressEditTextView;

                View stbModelSpinnerView = iptvLayout.getChildAt(5);
                Spinner stbModelSpinner = (Spinner) stbModelSpinnerView;
              /*  View formSTBLeaseLayoutView = iptvLayout.getChildAt(6);
                LinearLayout formSTBLeaseLayout = (LinearLayout) formSTBLeaseLayoutView;

                View formSTBRadioGroupView = formSTBLeaseLayout.getChildAt(1);
                RadioGroup formSTBRadioGroup = (RadioGroup) formSTBRadioGroupView;

                View stbYesRadioButtonView = formSTBRadioGroup.getChildAt(0);
                RadioButton stbYesRadioButton = (RadioButton) stbYesRadioButtonView;

                View stbNoRadioButtonView = formSTBRadioGroup.getChildAt(1);
                RadioButton stbNoRadioButton = (RadioButton) stbNoRadioButtonView;*/

               /* View formIfSTBLeaseLayoutView = iptvLayout.getChildAt(6);
                LinearLayout formIfSTBLeaseLayout = (LinearLayout) formIfSTBLeaseLayoutView;

                View stbDevicePurchaseSpinnerView = formIfSTBLeaseLayout.getChildAt(1);
                EditText stbDevicePurchaseSpinner = (EditText) stbDevicePurchaseSpinnerView;


                View formIPTVInstallmentsEditTextView = formIfSTBLeaseLayout.getChildAt(3);
                EditText formIPTVInstallmentsEditText = (EditText) formIPTVInstallmentsEditTextView;

                View formIPTVPriceEditTextView = formIfSTBLeaseLayout.getChildAt(5);
                EditText formIPTVPriceEditText = (EditText) formIPTVPriceEditTextView;*/


                View iptvPackageView = iptvLayout.getChildAt(8);
                TextView iptvPackage = (TextView) iptvPackageView;
                String iptvPackageNames = iptvPackage.getText().toString();


                ///Validating
                if (FormValidations.isFormSpinnerItemSelected(stbModelSpinner, FormValidations.SPINNER.STB_MODEL)) {
                    if (FormValidations.isFormEditTextValid(formIPTVSerialNoEditText, FormValidations.FORM_FIELDS.IPTV_ID)) {
                        if (isSerialNumberValid(formIPTVSerialNoEditText.getText().toString(), stbModelSpinnerItems.get(stbModelSpinner.getSelectedItemPosition()).getCpeProfileID(), false) && areSerialNumbersSubmitted(false, formIPTVSerialNoEditText.getText().toString())) {
                            if (!isSerialNoused) {
                                // if (FormValidations.isFormEditTextValid(formIPTVMacAddress, FormValidations.FORM_FIELDS.IPTV_MAC_ADDRESS))
                                /*if (formIfSTBLeaseLayout.getVisibility() == View.VISIBLE) {
                                    if (FormValidations.isFormSpinnerItemSelected(stbDevicePurchaseSpinner, FormValidations.SPINNER.STB_DEVICE_PURCHASE)) {
                                        if (iptvPackage.getVisibility() == View.GONE || !iptvPackage.getText().toString().equals("--Select--"))
                                            isValid = true;
                                        else {
                                            isValid = false;
                                            Utils.showDialog(getActivity(),
                                                    "Invalid IPTV Package",
                                                    "Please select IPTV package ", null);
                                        }
                                    } else {
                                        isValid = false;
                                    }
                                } else {*/
                                isValid = true;
                                   /* if (!iptvPackage.getText().toString().equals("--Select--") && !iptvPackage.getText().toString().equals(""))
                                        //if (validateIptvPackage(iptvPackage.getText().toString()))
                                        isValid = true;
                                    else {
                                        isValid = false;
                                        Utils.showDialog(getActivity(),
                                                "Invalid IPTV Packages",
                                                "Please select IPTV packages ", null);
                                    }*/
                                // }
                            } else {
                                isValid = false;
                                Utils.showDialog(getActivity(),
                                        "Invalid IPTV Serial No.",
                                        "Entered serial no. already used", null);
                            }
                        } else {
                            isValid = false;
                        }
                    } else {
                        isValid = false;
                    }
                } else {
                    isValid = false;
                }

            }
        } else {
            isValid = true;
        }
        return isValid;
    }

    private boolean isSerialNumberValid(String serialNumber, int profileID, boolean isONU) {
        Log.d("Serial Number -> ", serialNumber);
        Log.d("Profile ID ->", "" + profileID);
        boolean isValid = false;
        RealmResults<CPEStockModel> cpeStocks = Realm.getDefaultInstance().where(CPEStockModel.class).
                equalTo("cpeSerialNumber", serialNumber).equalTo("cpeProfileID", profileID).findAll();
        if (!cpeStocks.isEmpty()) {
            isValid = true;
        } else {
            Utils.showDialog(this,
                    isONU ? getString(R.string.invalid_cpe_id_title) : getString(R.string.invalid_iptv_id_title),
                    isONU ? getString(R.string.invalid_cpe_id_message) : getString(R.string.invalid_iptv_id_message), null);
        }
        return isValid;
    }

    private boolean areSerialNumbersSubmitted(boolean isONU, String serialnumber) {
        boolean isValid = false;
        try {
            Realm realm = Realm.getDefaultInstance();

            RealmResults<OfflineFormModel> results = realm.where(OfflineFormModel.class).notEqualTo("formTime", Constants.formTime).findAll();
            if (!results.isEmpty()) {
                for (OfflineFormModel model : results) {
                    if (isONU) {
                        Log.d(TAG, "is cpu no used" + model.isCpeSerialNoUsed());
                        if (model.getOnuSerialNumber() != null &&
                                model.getOnuSerialNumber().equals(serialnumber) && model.isCpeSerialNoUsed()) {
                            isValid = false;
                            Utils.showDialog(this, getString(R.string.invalid_cpe_id_message),
                                    getString(R.string.onu_serial_number_exist_message), null);
                            break;
                        } else {
                            isValid = true;
                        }
                    } else {

                        if (model.getStbSerialNumber() != null &&
                                model.getStbSerialNumber().contains(serialnumber) && model.isCpeSerialNoUsed()) {
                            isValid = false;
                            Utils.showDialog(this, getString(R.string.invalid_iptv_id_message),
                                    getString(R.string.iptv_serial_number_exist_message), null);
                            break;
                        } else {
                            isValid = true;
                        }
                    }
                }
            } else {
                isValid = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d("Exception in", "\t" + "areSerialNumbersSubmitted()");
        }
        return isValid;
    }

    private boolean areLevelSlotsValid() {
        boolean isValid = false;
        try {
            String oltPortNumber = oltPortSpinnerItems.get(oltPortIDSpinner.getSelectedItemPosition()).getPortNo();
            String l1PortID = oltPortLevel1Spinner.getSelectedItem().toString();
            Log.d(TAG, "l1PortID  " + l1PortID);
            String l2PortID = oltPortLevel2Spinner.getSelectedItem().toString();
            Log.d(TAG, "l2PortID " + l2PortID);
            String l3PortID = oltPortLevel3Spinner.getSelectedItem().toString();
            Log.d(TAG, "l3PortID " + l3PortID);
            Realm realm = Realm.getDefaultInstance();
            RealmResults<OfflineFormModel> results = realm.where(OfflineFormModel.class).notEqualTo("formTime", Constants.formTime).findAll();
            if (!results.isEmpty()) {
                for (OfflineFormModel model : results) {
                    if (model.getOltPortNumber() != null && model.getOltPortNumber().equals(oltPortNumber)) {
                        if (model.getL1PortNumber() != null && model.getL1PortNumber().equals(l1PortID)
                                && model.getL2PortNumber() != null && model.getL2PortNumber().equals(l2PortID)
                                && model.getL3PortNumber() != null && model.getL3PortNumber().equals(l3PortID)) {
                            isValid = false;
                            Utils.showDialog(this, getString(R.string.invalid_slot_title), getString(R.string.invalid_slot_message), null);
                            break;
                        } else {
                            isValid = true;
                        }
                    } else {
                        isValid = true;
                    }
                }
            } else {
                isValid = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d("Exception in", "\t" + "areLevelSlotsValid()");
        }
        return isValid;
    }

    private boolean validateIptvPackage(String ipTvpackageNames) {
        boolean packagesNotChanged = true;
        Realm realm = Realm.getDefaultInstance();
        String[] iptvPkgNamesArray = ipTvpackageNames.split(",");
        RealmResults<ProductModel> productModelsResult = realm.where(ProductModel.class).equalTo("isProductChecked", true).contains("coreServiceCode", "IPTV").notEqualTo("productType", "B").findAllSorted("productName", Sort.DESCENDING);
        for (String name : iptvPkgNamesArray) {
            if (productModelsResult.size() > 0) {
                for (int i = 0; i < productModelsResult.size(); i++) {
                    if (!productModelsResult.get(i).getProductName().equals(name)) {
                        packagesNotChanged = false;
                    }
                }
            }
        }
        return packagesNotChanged;
    }

    private void saveFormData() {
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();
            CPEInfoModel model = realm.where(CPEInfoModel.class)
                    .equalTo("formTime", Constants.formTime)
                    .findFirst();
            if (model == null) {
                model = new CPEInfoModel();
                model.setFormTime(Constants.formTime);

            }

            model.setOnuModel(onuModelSpinnerItems.get(cpeONUSpinner.getSelectedItemPosition()).getCpeModelName());
            model.setInstallationTax(onuModelSpinnerItems.get(cpeONUSpinner.getSelectedItemPosition()).getInstallationTaxAmount());
            model.setCpePOPName(selectedPOPName.getText().toString());
            model.setCpeOLTIDPosition(oltIDSpinner.getSelectedItemPosition());
            model.setCpeOLTPortIDPosition(oltPortIDSpinner.getSelectedItemPosition());
            model.setCpeLevel1SlotPosition(oltPortLevel1Spinner.getSelectedItemPosition());
            model.setCpeLevel2SlotPosition(oltPortLevel2Spinner.getSelectedItemPosition());
            model.setCpeLevel3SlotPosition(oltPortLevel3Spinner.getSelectedItemPosition());
            model.setOnuSerialNumber(formONUSerialNumber.getText().toString());
            model.setOnuModelPosition(cpeONUSpinner.getSelectedItemPosition());
            model.setVpnSpinnerPosition(vpnServiceSpinner.getSelectedItemPosition());
            model.setVpnServiceName(vpnServiceSpinner.getSelectedItemPosition() > 0 ?
                    vpnSpinnerItems.get(vpnServiceSpinner.getSelectedItemPosition()).getVpnsrvcName() : "N/A");


            model.setOnuInstallationCharge(formInstallationCharge.getText().toString());
            // if (!onuYesRadioButton.isChecked()) {
            model.setOnuTax(onuModelSpinnerItems.get(cpeONUSpinner.getSelectedItemPosition()).getCpeTax());
            model.setNoOfOnuInstallments(emiCountEditText.getText().toString());
            model.setOnuPriceForInstallment(onuEmiAmount.getText().toString());
            model.setOnuUpfrontEmount(onuUpFrontCharges.getText().toString());
           /* } else {
                model.setOnuTax("0.00");
                model.setOnuPriceForInstallment("0.00");
                model.setOnuUpfrontEmount("0.00");
            }*/

            // model.setONUChecked(onuYesRadioButton.isChecked());
            // model.setOnuDevicePurchasePosition(emiCountEditText.getSelectedItemPosition());

            model.setOnuMacAddress(formONUMacAddress.getText().toString());
            model.setTeleConnCountPosition(telephonicConnCount.getSelectedItemPosition());
            /*model.setIptvConnCountPosition(iptvConnCount.getSelectedItemPosition());*/
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
                    IptvDataModel iptvDataModel = realm.where(IptvDataModel.class)
                            .equalTo("iptvposition", i).equalTo("formTime", Constants.formTime)
                            .findFirst();
                    if (iptvDataModel == null) {
                        iptvDataModel = new IptvDataModel();
                        iptvDataModel.setIptvpositionformTime(i + " " + Constants.formTime);
                        iptvDataModel.setIptvposition(i);
                        iptvDataModel.setFormTime(Constants.formTime);
                    }

                    View formIPTVSerialNoEditTextView = iptvLayout.getChildAt(1);
                    EditText formIPTVSerialNoEditText = (EditText) formIPTVSerialNoEditTextView;
                    iptvDataModel.setIpTVSerialNumber(formIPTVSerialNoEditText.getText().toString());

                    View formIPTVMacAddressEditTextView = iptvLayout.getChildAt(3);
                    EditText formIPTVMacAddressEditText = (EditText) formIPTVMacAddressEditTextView;
                    iptvDataModel.setIpTVMacAddress(formIPTVMacAddressEditText.getText().toString());

                    View stbModelSpinnerView = iptvLayout.getChildAt(5);
                    Spinner stbModelSpinner = (Spinner) stbModelSpinnerView;
                    //Object tag = stbModelSpinner.getTag();
                    int position = stbModelSpinner.getSelectedItemPosition();
                    iptvDataModel.setStbModelPosition(stbModelSpinner.getSelectedItemPosition());
                    if (stbModelSpinner.getSelectedItemPosition() > 0) {
                        // iptvDataModel.setSelectedSTBDataModel(stbModelSpinnerItems.get(stbModelSpinner.getSelectedItemPosition()));
                        iptvDataModel.setIptvBoxModel(stbModelSpinnerItems.get(stbModelSpinner.getSelectedItemPosition()).getCpeModelName());
                    }
                    String stdmodelValue = String.valueOf(stbModelSpinnerItems.get(stbModelSpinner.getSelectedItemPosition()).getCpeProfileID());

                   /* View formSTBLeaseLayoutView = iptvLayout.getChildAt(6);
                    LinearLayout formSTBLeaseLayout = (LinearLayout) formSTBLeaseLayoutView;

                    View formSTBRadioGroupView = formSTBLeaseLayout.getChildAt(1);
                    RadioGroup formSTBRadioGroup = (RadioGroup) formSTBRadioGroupView;

                    View stbYesRadioButtonView = formSTBRadioGroup.getChildAt(0);
                    RadioButton stbYesRadioButton = (RadioButton) stbYesRadioButtonView;
                    iptvDataModel.setSTBChecked(stbYesRadioButton.isChecked());

                    View stbNoRadioButtonView = formSTBRadioGroup.getChildAt(1);
                    RadioButton stbNoRadioButton = (RadioButton) stbNoRadioButtonView;
                    boolean value1 = stbNoRadioButton.isChecked();*/

                    View formIfSTBLeaseLayoutView = iptvLayout.getChildAt(6);
                    LinearLayout formIfSTBLeaseLayout = (LinearLayout) formIfSTBLeaseLayoutView;

                    View stbDevicePurchaseSpinnerView = formIfSTBLeaseLayout.getChildAt(1);
                    EditText stbDevicePurchase = (EditText) stbDevicePurchaseSpinnerView;
                    iptvDataModel.setNoOfIptvInstallments(stbDevicePurchase.getText().toString());
                    // iptvDataModel.setStbDevicePurchasePosition(stbDevicePurchase.getSelectedItemPosition());

                    View iptvBoxEmiPrice = formIfSTBLeaseLayout.getChildAt(3);
                    EditText iptvBoxEmiPriceEditText = (EditText) iptvBoxEmiPrice;
                    iptvDataModel.setIptvPriceForInstallment(iptvBoxEmiPriceEditText.getText().toString());

                    View iptvUpfrontPrice = formIfSTBLeaseLayout.getChildAt(5);
                    EditText iptvUpfrontPriceEditText = (EditText) iptvUpfrontPrice;


                    View iptvPackageView = iptvLayout.getChildAt(8);
                    TextView iptvPackage = (TextView) iptvPackageView;
                    String iptvPackageNames = iptvPackage.getText().toString();
                    iptvDataModel.setIptvPkg(iptvPackageNames);
                    String[] iptvPkgNamesArray = iptvPackageNames.split(",");
                    String iptvpkgCodes = "";
                    for (String name : iptvPkgNamesArray) {
                        ProductModel productModel = realm.where(ProductModel.class).equalTo("productName", name).findFirst();
                        if (productModel != null) {
                            if (iptvpkgCodes.equals("")) {
                                iptvpkgCodes = iptvpkgCodes + realm.where(ProductModel.class).equalTo("productName", name).findFirst().getProductCode();
                            } else {
                                iptvpkgCodes = iptvpkgCodes + "," + realm.where(ProductModel.class).equalTo("productName", name).findFirst().getProductCode();
                            }
                        }
                    }
                    //String stbInstallmentCount;
                    // if (!stbYesRadioButton.isChecked()) {
                    // stbInstallmentCount = stbDevicePurchase.getSelectedItem().toString();
                    CPEDataModel cpeDataModel = realm.where(CPEDataModel.class).equalTo("cpeProfileID", stbModelSpinnerItems.get(stbModelSpinner.getSelectedItemPosition()).getCpeProfileID()).findFirst();
                    if (cpeDataModel != null) {
                        String taxValue = cpeDataModel.getCpeTax();
                        iptvDataModel.setIptvBoxTax(taxValue);
                        iptvDataModel.setUpfrontAmount(iptvUpfrontPriceEditText.getText().toString());
                    }

                    /*} else {
                        iptvDataModel.setIptvBoxTax("0.00");
                        iptvDataModel.setUpfrontAmount("0.00");
                    }*/


                    realm.copyToRealmOrUpdate(iptvDataModel);
                    // stbList.add(iptvDataModel);


                    iptvBox = new JSONObject();
                    // formData.put("stbSrlNo", "");//formIPTVSerialNumber.getText().toString()

                    iptvBox.put("stbEmiPrice", iptvBoxEmiPriceEditText.getText().toString());//Emi price
                    //formIPTVPrice.getText().toString()
                    iptvBox.put("macAddress", formIPTVMacAddressEditText.getText().toString());
                    switch (lmoType) {
                        case "LMO":
                           /* if (stbYesRadioButton.isChecked()) {
                                iptvBox.put("stbInstallmentCount", JSONObject.NULL);
                            } else {*/
                            iptvBox.put("stbInstallmentCount", stbDevicePurchase.getText().toString());
                            //}
                            //iptvBox.put("stbLease", stbYesRadioButton.isChecked() ? "Y" : "N");
                            break;
                        case "SI":
                            iptvBox.put("stbDevice", JSONObject.NULL);
                            iptvBox.put("stbLease", JSONObject.NULL);
                            break;

                    }
                    if (stdmodelValue.equals("-1")) {
                        iptvBox.put("stbModel", "NA");
                    } else {
                        iptvBox.put("stbModel", stdmodelValue);
                    }
                    iptvBox.put("stbSerialNo", formIPTVSerialNoEditText.getText().toString());
                    iptvBox.put("stbPrice", iptvUpfrontPriceEditText.getText().toString());//uppront price
                    iptvBox.put("iptvSrvcCodes", iptvpkgCodes);

                    iptvBoxList.put(iptvBox);

                }
            }
            RealmList<IptvDataModel> stbList = new RealmList<>();
            RealmResults<IptvDataModel> iptvDataModels = realm.where(IptvDataModel.class).equalTo("formTime", Constants.formTime).findAll();
            Log.d(TAG, iptvDataModels.toString());
            stbList.clear();
            stbList.addAll(iptvDataModels);
            Log.d("stbSavedata", stbList.size() + "");
            Log.d("stblist", stbList.toString());

            model.setSelectedIptvList(stbList);

            realm.copyToRealmOrUpdate(model);

            OfflineFormModel offlineFormModel = realm.where(OfflineFormModel.class)
                    .equalTo("formTime", Constants.formTime).findFirst();
            if (offlineFormModel == null) {
                offlineFormModel = new OfflineFormModel();
                offlineFormModel.setFormTime(Constants.formTime);
                offlineFormModel.setCafType(Constants.cafType);
                offlineFormModel.setFormCAFData("");
                offlineFormModel.setFormPaymentData(getFormDataAsJSON(null).toString());
                offlineFormModel.setFormUploaded(false);
                offlineFormModel.setIsPaymentDataAvailable(false);
                offlineFormModel.setCpeSerialNoUsed(false);
                offlineFormModel.setCafStatus("0");
            } else {
                Log.d("Payment JSON", "\t" + offlineFormModel.getFormPaymentData().isEmpty());

                offlineFormModel.setFormPaymentData(getFormDataAsJSON(offlineFormModel.getFormPaymentData()).toString());
            }
            offlineFormModel.setL1PortNumber(String.valueOf(oltPortLevel1Spinner.getSelectedItemPosition()));
            offlineFormModel.setL2PortNumber(String.valueOf(oltPortLevel2Spinner.getSelectedItemPosition()));
            offlineFormModel.setL3PortNumber(String.valueOf(oltPortLevel3Spinner.getSelectedItemPosition()));
            offlineFormModel.setOnuSerialNumber(formONUSerialNumber.getText().toString());
            String stbserialNums = "";
            RealmResults<IptvDataModel> realmResults = realm.where(IptvDataModel.class).equalTo("formTime", Constants.formTime).findAll();
            for (int i = 0; i < realmResults.size(); i++) {
                if (i == 0) {
                    stbserialNums = realmResults.get(i).getIpTVSerialNumber();
                } else {
                    stbserialNums += "," + realmResults.get(i).getIpTVSerialNumber();
                }
            }
            offlineFormModel.setStbSerialNumber(stbserialNums);

            realm.copyToRealmOrUpdate(offlineFormModel);
            realm.commitTransaction();
        } catch (Exception ex) {
            realm.cancelTransaction();
            ex.printStackTrace();
            Log.d("Exception in -> ", "saveFormData()");
        }
    }

    private JSONObject getFormDataAsJSON(String paymentJSON) {
        JSONObject formData = null;
        JSONObject customerCAFVO = null;
        try {
            if (paymentJSON == null || paymentJSON.isEmpty()) {
                formData = new JSONObject();
                customerCAFVO = new JSONObject();
            } else {
                formData = new JSONObject(paymentJSON);
                customerCAFVO = new JSONObject(formData.getJSONObject("customerCafVO").toString());
            }
            formData.put("cpeSrlNo", formONUSerialNumber.getText().toString());

            customerCAFVO.put("cpeId", formONUSerialNumber.getText().toString());
            customerCAFVO.put("custType", Constants.cafType == 1 ? "INDIVIDUAL" : "ENTERPRISE");
            customerCAFVO.put("city", Constants.villageID);
            customerCAFVO.put("mandal", Constants.mandalID);
            if (Constants.cafType == 2) {
                switch (lmoType) {

                    case "LMO":
                        EnterpriseCustomer enterpriseCustomer = Realm.getDefaultInstance().where(EnterpriseCustomer.class).equalTo("isCustomerChecked", true).findFirst();
                        customerCAFVO.put("entCustomerCode", enterpriseCustomer.getCustomerID());
                        customerCAFVO.put("entCustType", enterpriseCustomer.getEnterPriseCustomerType());
                        break;
                    case "SI":
                        customerCAFVO.put("entCustomerCode", entCustomerCode);
                        customerCAFVO.put("entCustType", entCustType);
                        break;

                }

            } else {
                customerCAFVO.put("entCustType", "");
                customerCAFVO.put("entCustomerCode", "");
            }

            customerCAFVO.put("l1Slot", oltPortLevel1Spinner.getSelectedItem() != null ? oltPortLevel1Spinner.getSelectedItem().toString() : "");
            customerCAFVO.put("l2Slot", oltPortLevel2Spinner.getSelectedItem() != null ? oltPortLevel2Spinner.getSelectedItem().toString() : "");
            customerCAFVO.put("l3Slot", oltPortLevel3Spinner.getSelectedItem() != null ? oltPortLevel3Spinner.getSelectedItem().toString() : "");

            customerCAFVO.put("instCharge", formInstallationCharge.getText().toString());
            customerCAFVO.put("oltId", oltIDSpinner.getSelectedItemPosition() > 0 ? oltIDSpinnerItems.get(oltIDSpinner.getSelectedItemPosition()).getPopOLTSerialNumber() : "");
            customerCAFVO.put("oltPortId", oltPortIDSpinner.getSelectedItemPosition() > 0 ? oltPortSpinnerItems.get(oltPortIDSpinner.getSelectedItemPosition()).getPortNo() : "");
            customerCAFVO.put("onuMacAddress", formONUMacAddress.getText().toString());
            customerCAFVO.put("cpeModal", String.valueOf(onuModelSpinnerItems.get(cpeONUSpinner.getSelectedItemPosition()).getCpeProfileID()));
            customerCAFVO.put("popId", popID);
            customerCAFVO.put("cpePrice", onuUpFrontCharges.getText().toString());
            //Todo
            ///need review//dec 17
            if (lmoType.equals("SI")) {
                customerCAFVO.put("onuEmiPrice", JSONObject.NULL);

            } else {

               /* if (onuYesRadioButton.isChecked()) {
                    customerCAFVO.put("installmentCount", JSONObject.NULL);
                } else {*/
                customerCAFVO.put("installmentCount", emiCountEditText.getText().toString());
                //}

            }

            //customerCAFVO.put("cpeLease", onuYesRadioButton.isChecked() ? "Y" : "N");
            customerCAFVO.put("onuEmiPrice", onuEmiAmount.getText().toString());
            // customerCAFVO.put("cableCharge", formCPECableChargeEditText.getText().toString());
            customerCAFVO.put("cableCharge", "0");
            //Todo
            customerCAFVO.put("vpnService", vpnServiceSpinner.getSelectedItemPosition() > 0 ?
                    vpnSpinnerItems.get(vpnServiceSpinner.getSelectedItemPosition()).getVpnsrvcName() : "");
            Log.d(TAG, "vpnService" + (vpnServiceSpinner.getSelectedItemPosition() > 0 ?
                    vpnSpinnerItems.get(vpnServiceSpinner.getSelectedItemPosition()).getVpnsrvcName() : ""));
            customerCAFVO.put("noOfTPConn", telephonicConnCount.getSelectedItemPosition() > 0 ? telephonicConnCount.getSelectedItem() : "");
            Log.d(TAG, "noOfTPConn" + telephonicConnCount.getSelectedItem());

            customerCAFVO.put("iptvBoxList", iptvBoxList);

            Log.d(TAG, "iptvBoxList" + iptvBoxList);
            //need to check for SILMO////////////////////////Todo
            Realm realm = Realm.getDefaultInstance();
            RealmResults<ProductModel> products = realm.where(ProductModel.class)
                    .equalTo("isProductChecked", true)
                    .findAll();
            String productCodes = "";
            for (ProductModel productModel : products) {
                if (productCodes.equals("")) {
                    productCodes = productModel.getProductCode();
                } else {
                    productCodes += "," + productModel.getProductCode();
                }
            }
            customerCAFVO.put("prodCode", productCodes);
            customerCAFVO.put("tenantType", lmoType);
            customerCAFVO.put("version", Constants.version);
            formData.put("customerCafVO", customerCAFVO);
            formData.put("tenantType", lmoType);
            Log.d("CPE JSON", formData.toString(2));
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d("Exception in -> ", "getFormDataAsJSON");
        }
        return formData;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.previousScreenLayout:
                saveFormData();
                getActivity().getSupportFragmentManager().popBackStack();
                break;

            case R.id.nextScreenLayout:
            case R.id.nextLayout:
                if (validateFormFields()) {
                    saveFormData();
                    if (lmoType.equals("SI")) {
                        saveSelectedPackages();
                    }
                    startActivity(new Intent(getActivity(), WorkOrderActivity.class));
                }
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
                    final CPEInfoModel cpeInfoModel = realm.where(CPEInfoModel.class).equalTo("formTime", Constants.formTime).findFirst();
                    final IptvDataModel iptvDataModel = realm.where(IptvDataModel.class)
                            .equalTo("iptvposition", childSize - 1).equalTo("formTime", Constants.formTime)
                            .findFirst();
                    if (cpeInfoModel != null && cpeInfoModel.getSelectedIptvList().size() > 0) {
                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                cpeInfoModel.getSelectedIptvList().remove(iptvDataModel);
                                if (iptvDataModel != null) {
                                    realm.where(IptvDataModel.class)
                                            .equalTo("iptvposition", childSize - 1).equalTo("formTime", Constants.formTime)
                                            .findFirst().deleteFromRealm();
                                }
                            }
                        });
                    }
                }
                break;
        }
    }

    private void loadOltIDData(int position) {
        oltIDSpinnerItems = new RealmList<>();
        POPOLTModel popOltModel = new POPOLTModel();
        popOltModel.setPopOLTID("-1");
        popOltModel.setPopID("");
        popOltModel.setPopName("");
        popOltModel.setPopOLTSerialNumber("");
        popOltModel.setPopLabelNumber("--Select--");
        oltIDSpinnerItems.add(popOltModel);
        Realm realm = Realm.getDefaultInstance();
        /*  popID = realm.where(POPModel.class).equalTo("popName", popName).findFirst().getPopID();*/
        Log.d(TAG, "POP ID " + popID);
        oltIDSpinnerItems.addAll(realm.where(POPOLTModel.class).equalTo("popID", popID).findAll().sort("popLabelNumber", Sort.ASCENDING));
        OLTIDSpinnerAdapter adapter = new OLTIDSpinnerAdapter(getActivity(), oltIDSpinnerItems);
        oltIDSpinner.setAdapter(adapter);
        oltIDSpinner.setSelection(position);
        oltIDSpinnerHeader.setVisibility(View.VISIBLE);
        oltIDSpinner.setVisibility(View.VISIBLE);
        Constants.oltSerialNumber = oltIDSpinnerItems.get(position).getPopOLTSerialNumber();
    }

    private void loadTelephoneConne(int position) {
        String[] telphoneConnSpinnerItems = getResources().getStringArray(R.array.tele_conn_count_spinner_items);
        CustomSpinnerAdapter telphoneConnAdapter = new CustomSpinnerAdapter(getActivity(), telphoneConnSpinnerItems);
        telephonicConnCount.setAdapter(telphoneConnAdapter);
        telephonicConnCount.setSelection(position);

    }

    /*private void loadIptvConne(int position) {
        String[] iptvConnSpinnerItems = getResources().getStringArray(R.array.tele_conn_count_spinner_items);
        CustomSpinnerAdapter iptvConnAdapter = new CustomSpinnerAdapter(getActivity(), iptvConnSpinnerItems);
        iptvConnCount.setAdapter(iptvConnAdapter);
        iptvConnCount.setSelection(position);

    }*/

    private void loadPortData(int oltIdPosition, int oltportIdPosition) {
        if (oltIdPosition > 0) {
            try {
                Realm realm = Realm.getDefaultInstance();
                String oltPopID = oltIDSpinnerItems.get(oltIdPosition).getPopOLTID().toString();
                OltPortDetails oltPortDataModel = new OltPortDetails();
                oltPortDataModel.setPortNo("--Select--");
                oltPortDataModel.setPopIdPortNo("-1");
                oltPortDataModel.setPopId("");
                oltPortSpinnerItems.clear();
                oltPortSpinnerItems.add(oltPortDataModel);
                oltPortSpinnerItems.addAll(realm.where(OltPortDetails.class).equalTo("popId", oltPopID).findAll());
                OLTPortSpinnerAdapter oltPortSpinnerAdapter = new OLTPortSpinnerAdapter(getActivity(), oltPortSpinnerItems);
                oltPortIDSpinner.setAdapter(oltPortSpinnerAdapter);
                oltPortIDSpinner.setSelection(oltportIdPosition);
                oltPortHeader.setVisibility(View.VISIBLE);
                oltPortIDSpinner.setVisibility(View.VISIBLE);
                Constants.oltPortNumber = oltPortSpinnerItems.get(oltportIdPosition).getPortNo();
            } catch (Exception ex) {
                ex.printStackTrace();
                Log.d("Exception -> ", "loadPortData()");
            }
        }
    }

    private void loadL1PortData(int oltPortIDPosition, int l1PortPosition) {
        if (oltPortIDPosition > 0) {
            try {
                Realm realm = Realm.getDefaultInstance();
                String popIdPortNo = oltPortSpinnerItems.get(oltPortIDPosition).getPopIdPortNo();
                Log.d("popIdPortNo", popIdPortNo.toString());
                L1PortModel l1PortModel = realm.where(L1PortModel.class).equalTo("popIdPortno", popIdPortNo).findFirst();
                Log.d("L1PortModel", l1PortModel.toString());
                String[] data = l1PortModel.getL1PortNumbers().split(",");
                CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(getActivity(), data);

                oltPortLevel1Spinner.setAdapter(adapter);
                oltPortLevel1Spinner.setSelection(l1PortPosition);
                oltPortLevel1Header.setVisibility(View.VISIBLE);
                oltPortLevel1Spinner.setVisibility(View.VISIBLE);
            } catch (Exception ex) {
                ex.printStackTrace();
                Log.d("Exception -> ", "loadL1PortData()");
            }
        }
    }

    private void loadL2andL3PortData(int l1Position, int l2Position, int l3Position) {

        if (l1Position > 0) {
            try {
                Realm realm = Realm.getDefaultInstance();
                if (oltPortIDSpinner.getSelectedItemPosition() > 0) {
                    String l1PortNumber = oltPortSpinnerItems.get(oltPortIDSpinner.getSelectedItemPosition()).getPopIdPortNo() + oltPortLevel1Spinner.getItemAtPosition(l1Position).toString();
                    String[] l3Data = new String[0];
                    //l3Data = new String[];
                    Log.d("l1PortNumber", l1PortNumber.toString());
                    L2PortModel l2PortModel = realm.where(L2PortModel.class).equalTo("l1PortNumber", l1PortNumber).findFirst();
                    Log.d("L2PortModel", l2PortModel.toString());
                    String[] l2Data = l2PortModel.getL2PortNumbers().split(",");
                    CustomSpinnerAdapter l2Adapter = new CustomSpinnerAdapter(getActivity(), l2Data);
                    oltPortLevel2Spinner.setAdapter(l2Adapter);
                    oltPortLevel2Spinner.setSelection(l2Position);

                    //L3PortModel l3PortModel = realm.where(L3PortModel.class).equalTo("l1PortNumber", l1PortNumber).findFirst();
                    //String[] l3Data = l3PortModel.getL3PortNumbers().split(",");
                    /*if (level3SlotList != null) {
                        l3Data = level3SlotList.split(",");
                    }
                    CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(getActivity(), l3Data);
                    oltPortLevel3Spinner.setAdapter(adapter);
                    oltPortLevel3Spinner.setSelection(l3Position);*/

                    oltPortLevel2Header.setVisibility(View.VISIBLE);
                    oltPortLevel2Spinner.setVisibility(View.VISIBLE);
                    /*oltPortLevel3Header.setVisibility(View.VISIBLE);
                    oltPortLevel3Spinner.setVisibility(View.VISIBLE);*/
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                Log.d("Exception -> ", "loadL2andL3PortData()");
            }
        }
    }

    private void loadVpnData(int oltIdPosition, int VpnValuePosition) {

        if (oltIdPosition > 0) {
            try {
                Realm realm = Realm.getDefaultInstance();
                String oltSerialNo = oltIDSpinnerItems.get(oltIdPosition).getPopOLTSerialNumber().toString();
                String oltPopSubstnuid = oltIDSpinnerItems.get(oltIdPosition).getPopID().toString();
                VpnServiceModel vpnServiceModel = new VpnServiceModel();
                vpnServiceModel.setVpnsrvcName("--Select--");
                vpnServiceModel.setSubstnUid("");
                vpnServiceModel.setOltSerialNo("");

                vpnSpinnerItems.clear();
                vpnSpinnerItems.add(vpnServiceModel);
                vpnSpinnerItems.addAll(realm.where(VpnServiceModel.class).equalTo("substnUid", oltPopSubstnuid).equalTo("oltSerialNo", oltSerialNo).findAllSorted("vpnsrvcName", Sort.ASCENDING));

                VpnSpinnerAdapter vpnSpinnerAdapter = new VpnSpinnerAdapter(getActivity(), vpnSpinnerItems);
                vpnServiceSpinner.setAdapter(vpnSpinnerAdapter);
                vpnServiceSpinner.setSelection(VpnValuePosition);
            } catch (Exception ex) {
                ex.printStackTrace();
                Log.d("Exception -> ", "loadVpnData()");
            }

        }

    }

    @Override
    public void onBackPressed() {
        if (getActivity().getSupportFragmentManager().getBackStackEntryCount() > 0) {
            saveFormData();
            getActivity().getSupportFragmentManager().popBackStack();
        } else {
            Utils.showUserConfirmationDialog(getActivity(), this,
                    getString(R.string.discard_form_message), Constants.DISCARD_FORM);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        CPEDataModel cpeDataModel;
        switch (parent.getId()) {
            case R.id.oltIDSpinner:
                if (position > 0) {
                    Constants.oltSerialNumber = oltIDSpinnerItems.get(position).getPopOLTSerialNumber();
                    Log.d("oltSerialNumber", "\t" + Constants.oltSerialNumber);
                    loadPortData(position, 0);
                    switch (lmoType) {
                        case "LMO":
                            loadVpnData(position, 0);
                            break;
                        case "SI":
                            Utils.showProgress(getActivity(), getString(R.string.processing_request));
                            requestHandler.getSILMOVPNSrvcNamesList(getActivity(), this, oltIDSpinnerItems.get(position).getPopOLTSerialNumber(),
                                    oltIDSpinnerItems.get(position).getPopID(), Constants.GET_VPNSRVCNAMES);


                    }

                } else {
                    oltPortHeader.setVisibility(View.GONE);
                    oltPortIDSpinner.setVisibility(View.GONE);
                    oltPortLevel1Header.setVisibility(View.GONE);
                    oltPortLevel1Spinner.setVisibility(View.GONE);
                    oltPortLevel2Header.setVisibility(View.GONE);
                    oltPortLevel2Spinner.setVisibility(View.GONE);
                    oltPortLevel3Header.setVisibility(View.GONE);
                    oltPortLevel3Spinner.setVisibility(View.GONE);
                }
                break;

            case R.id.oltPortIDSpinner:
                if (position > 0) {
                    Constants.oltPortNumber = oltPortSpinnerItems.get(position).getPortNo();
                    Log.d("oltPortNumber", "\t" + Constants.oltPortNumber);
                    switch (lmoType) {
                        case "LMO":
                            loadL1PortData(position, 0);
                            break;
                        case "SI":
                            break;
                    }
                } else {
                    oltPortLevel1Header.setVisibility(View.GONE);
                    oltPortLevel1Spinner.setVisibility(View.GONE);
                    oltPortLevel2Header.setVisibility(View.GONE);
                    oltPortLevel2Spinner.setVisibility(View.GONE);
                    oltPortLevel3Header.setVisibility(View.GONE);
                    oltPortLevel3Spinner.setVisibility(View.GONE);
                }
                break;

            case R.id.oltPortLevel1Spinner:
                if (position > 0) {
                    loadL2andL3PortData(position, 0, 0);
                } else {
                    oltPortLevel2Header.setVisibility(View.GONE);
                    oltPortLevel2Spinner.setVisibility(View.GONE);
                    oltPortLevel3Header.setVisibility(View.GONE);
                    oltPortLevel3Spinner.setVisibility(View.GONE);
                }
                break;

            case R.id.cpeModelSpinner:
                //Todo
                if (position > 0) {
                    String stbPositionIdEmiCount = onuModelSpinnerItems.get(position).getCpeProfileIDcpeInstallmentCount();
                    CPEDataModel cpeDataModel1 = Realm.getDefaultInstance().where(CPEDataModel.class).equalTo("cpeProfileIDcpeInstallmentCount", stbPositionIdEmiCount).findFirst();
                    if (cpeDataModel1 != null) {
                        String installationCost = cpeDataModel1.getCpeInstallationCost();
                        formInstallationCharge.setText(installationCost);
                        emiCountEditText.setText(cpeDataModel1.getCpeInstallmentCount());
                        onuEmiAmount.setText(cpeDataModel1.getCpeInstallmentCost());
                        onuUpFrontCharges.setText(cpeDataModel1.getUpFrontCharges());

                    } else {
                        formInstallationCharge.setText("");
                        emiCountEditText.setText("");
                        onuUpFrontCharges.setText("");
                        onuEmiAmount.setText("");
                    }

                }

                //cpeDataModel = onuModelSpinnerItems.get(position);
                // if (cpeDataModel.getCpeProfileID() != -1) {
                // loadOnuPurchaseSpinner(position, 0);
                // if (formIfONULeaseLayout.getVisibility() == View.VISIBLE) {

                        /*switch (emiCountEditText.getSelectedItemPosition()) {
                            case 1: // Purchase
                                onuUpFrontCharges.setText(cpeDataModel.getCpePurchaseCost());

                                onuEmiAmount.setText("");
                                onuEmiAmount.setHint(R.string.cpe_installments_hint);
                                break;

                            case 2:  // Installment
                                onuUpFrontCharges.setText(cpeDataModel.getCpeInstallmentCost());
                                //formInstallationCharge.setText(cpeDataModel.getCpeInstallationCost());
                                onuEmiAmount.setText(cpeDataModel.getCpeInstallmentCount());
                                break;
                        }*/
                // }
                // }
                break;

          /*  case R.id.emiCountEditText:
                cpeDataModel = onuDeviceSpinnerItems.get(position);
                if (cpeDataModel.getCpeProfileID() != -1) {
                    onuUpFrontCharges.setText(cpeDataModel.getUpFrontCharges());
                    onuEmiAmount.setText(cpeDataModel.getCpeInstallmentCost());
                    formInstallationCharge.setText(cpeDataModel.getCpeInstallationCost());
                    //onuEmiAmount.setText("");
                    //onuEmiAmount.setHint(R.string.cpe_installments_hint);
                } else {
                    onuUpFrontCharges.setText("");
                    onuEmiAmount.setText("");
                }*/

            case R.id.telephonicConnCount:
                break;

            case R.id.oltPortLevel2Spinner:
                JSONObject oltJson = new JSONObject();
                String LMOCODE = MainActivity.mLmoCode;
                String oltSerialNumber = oltIDSpinnerItems.get(oltIDSpinner.getSelectedItemPosition()).getPopOLTSerialNumber();
                String oltPortNumber = oltPortSpinnerItems.get(oltPortIDSpinner.getSelectedItemPosition()).getPortNo();
                String l1PortID = oltPortLevel1Spinner.getSelectedItem().toString();
                String l2PortID = oltPortLevel2Spinner.getSelectedItem().toString();
                String portSlotValue = l1PortID + "-" + l2PortID;

                if (!l2PortID.equalsIgnoreCase("--select--")) {

                    try {
                        oltJson.put("oltSrlNo", oltSerialNumber);
                        oltJson.put("lmoCode", LMOCODE);
                        oltJson.put("oltPort", oltPortNumber);
                        oltJson.put("l1L2slot", portSlotValue);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    requestHandler.validateOltSlots(CustomerCPEInfoFragment.this, oltJson, Constants.OLTSLOT3_SLOT_DATA);

                    //Toast.makeText(getContext(), "oltPortLevel3Spinner is selected", Toast.LENGTH_SHORT).show();
                /*String oltPortNumber = oltPortSpinnerItems.get(oltPortIDSpinner.getSelectedItemPosition()).getPortNo();
                String l1PortID = oltPortLevel1Spinner.getSelectedItem().toString();
                Log.d(TAG, "l1PortID  " + l1PortID);
                String l2PortID = oltPortLevel2Spinner.getSelectedItem().toString();
                Log.d(TAG, "l2PortID " + l2PortID);
                String l3PortID = oltPortLevel3Spinner.getSelectedItem().toString();
                Log.d(TAG, "l3PortID " + l3PortID);
                if (!l3PortID.equalsIgnoreCase("--select--")) {

                    String portSlotValue = l1PortID + "-" + l2PortID + "-" + l3PortID + ",";
                    String oltSerialNumber = oltIDSpinnerItems.get(oltIDSpinner.getSelectedItemPosition()).getPopOLTSerialNumber();
                    JSONObject oltJson = new JSONObject();
                    try {
                        oltJson.put("oltSrlNo", oltSerialNumber);
                        oltJson.put("oltPort", oltPortNumber);
                        oltJson.put("portSlotValue", portSlotValue);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    //requestHandler.validateOltSlots(CustomerCPEInfoFragment.this, oltJson, Constants.OLTSLOT_VALIDATION_REQUEST);
                }
                break;
            case R.id.iptvConnCount:
                String iptvCount = iptvConnCount.getSelectedItem().toString();
                stbWrapper.removeAllViews();
                if (!iptvCount.equals("--Select--")) {
                    int count = Integer.parseInt(iptvCount);
                    for (int i = 0; i < count; i++) {
                        constructIptvLayout();
                    }
                }
                break;*/
                }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void loadOnuPurchaseSpinner(int onuPosition, int onuPurchasePosition) {
        if (onuPosition > 0) {
            Realm realm = Realm.getDefaultInstance();
            int onuProfileID = onuModelSpinnerItems.get(onuPosition).getCpeProfileID();
            onuDeviceSpinnerItems.clear();
            CPEDataModel onuDataModel = new CPEDataModel();
            onuDataModel.setCpeProfileID(-1);
            onuDataModel.setCpeInstallmentCount("--Select--");
            onuDataModel.setCpeModelName(null);
            onuDataModel.setCpeProfileName(null);
            onuDataModel.setCpeModelDetails(null);
            onuDataModel.setCpePurchaseCost(null);
            onuDataModel.setCpeRentalCost(null);
            onuDataModel.setCpeInstallationCost(null);
            onuDeviceSpinnerItems.add(onuDataModel);
            onuDeviceSpinnerItems.addAll(realm.where(CPEDataModel.class).equalTo("cpeProfileID", onuProfileID).findAll());
            CPEPurchaseSpinnerAdapter onuPurchaseAdapter = new CPEPurchaseSpinnerAdapter(getActivity(), onuDeviceSpinnerItems);
            // emiCountEditText.setAdapter(onuPurchaseAdapter);
            // emiCountEditText.setSelection(onuPurchasePosition);
        }


    }

    private void loadstbPurchaseSpinner(RealmList<CPEDataModel> stbDeviceSpinnerItems, Spinner spinner, int stbPosition, int stbPurchasePosition) {
        Realm realm = Realm.getDefaultInstance();
        stbDeviceSpinnerItems.clear();
        CPEDataModel onuDataModel = new CPEDataModel();
        onuDataModel.setCpeProfileID(-1);
        onuDataModel.setCpeInstallmentCount("--Select--");
        onuDataModel.setCpeModelName(null);
        onuDataModel.setCpeProfileName(null);
        onuDataModel.setCpeModelDetails(null);
        onuDataModel.setCpePurchaseCost(null);
        onuDataModel.setCpeRentalCost(null);
        onuDataModel.setCpeInstallationCost(null);
        stbDeviceSpinnerItems.add(onuDataModel);
        if (stbPosition > 0) {
            int onuProfileID = stbModelSpinnerItems.get(stbPosition).getCpeProfileID();
            stbDeviceSpinnerItems.addAll(realm.where(CPEDataModel.class).equalTo("cpeProfileID", onuProfileID).findAll());
        }
        CPEPurchaseSpinnerAdapter stbPurchaseAdapter = new CPEPurchaseSpinnerAdapter(getActivity(), stbDeviceSpinnerItems);
        spinner.setAdapter(stbPurchaseAdapter);
        spinner.setSelection(stbPurchasePosition);


    }

    @Override
    public void onDialogConfirmed(int actionType) {
        switch (actionType) {
            case Constants.DISCARD_FORM:
                Log.d(TAG, "DISCARD FORM");
                /*Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                realm.where(CustomerInfoModel.class).equalTo("formTime", Constants.formTime).findAll().deleteAllFromRealm();
                realm.where(CPEInfoModel.class).equalTo("formTime", Constants.formTime).findAll().deleteAllFromRealm();
                realm.where(CustomerAddressModel.class).equalTo("formTime", Constants.formTime).findAll().deleteAllFromRealm();
                realm.where(OfflineFormModel.class)
                        .equalTo("formTime", Constants.formTime)
                        .findAll().deleteAllFromRealm();
                realm.commitTransaction();
                realm.close();*/
                Utils.resetStaticVariables();
                startActivity(new Intent(getActivity(), MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

    }

    //For silmo
    private void saveSelectedPackages() {
        JSONObject packagesJSON;
        Realm realm = Realm.getDefaultInstance();
        try {
            OfflineFormModel offlineFormModel = realm.where(OfflineFormModel.class)
                    .equalTo("formTime", Constants.formTime).findFirst();
            packagesJSON = new JSONObject(offlineFormModel.getFormPaymentData());
            JSONObject customerCAFVO = new JSONObject(packagesJSON.getJSONObject("customerCafVO").toString());
            SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();
            customerCAFVO.put("loginId", sharedPreferences.getString(Constants.USER_NAME, ""));
            customerCAFVO.put("cafNo", Constants.cafNumber.equals("") ? "" : Long.parseLong(Constants.cafNumber));
            customerCAFVO.put("custId", Constants.customerID);
            customerCAFVO.put("ipAddress", Utils.getIPAddress(getActivity()));
            customerCAFVO.put("billCycle", Constants.billCycle);
            customerCAFVO.put("district", Constants.districtID);
            RealmResults<ProductModel> products = realm.where(ProductModel.class)
                    .equalTo("isProductChecked", true)
                    .findAll();
            JSONArray productsArray = new JSONArray();
            for (ProductModel productModel : products) {
                JSONObject productJSON = new JSONObject(productModel.getProductData());
                productsArray.put(productJSON);
            }
            customerCAFVO.put("products", productsArray);
            customerCAFVO.put("flag", "NoCafFeatures");//if no feature codes
            customerCAFVO.put("status", "89");
            //Todo
            customerCAFVO.put("cafStatus", "89");
            //customerCAFVO.put("cafStatus", offlineFormModel.getCafStatus());
            customerCAFVO.put("coreSrvcCode", coreServiceCodes);
            // customerCAFVO.put("vpnService", "");
            packagesJSON.put("customerCafVO", customerCAFVO);
            Log.d("Packages JSON", packagesJSON.toString(2));
            //Log.d("Product JSON", productsArray.toString());
            realm.beginTransaction();
            offlineFormModel.setFormPaymentData(packagesJSON.toString());
            realm.copyToRealmOrUpdate(offlineFormModel);
            realm.commitTransaction();
            realm.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            realm.cancelTransaction();
            realm.close();
            Log.d("Exception -> ", "saveSelectedPackages()");
        }
    }

    @Override
    public void responseHandler(Object response, int requestType) {
        Log.d(TAG, "CALL FOR switch");
        switch (requestType) {

            case Constants.GET_PACKAGES:

                if (response != null) {
                    Log.d(TAG, "CALL FOR CORESERVICE CODE");
                    requestHandler.getCoreSrvcCodeByCafNo(getActivity(), this, Constants.cafNumber, Constants.CORESERVICECODE);
                } else {
                    Utils.cancelProgress();
                    Utils.showDialog(this, getString(R.string.request_failure_title),
                            getString(R.string.request_failure_message), null);
                }
                break;
            case Constants.CORESERVICECODE:
                Utils.cancelProgress();
                if (response != null) {
                    JSONObject data = (JSONObject) response;
                    try {
                        coreServiceCodes = data.getString("statusMessage");
                        if (coreServiceCodes.contains("IPTV")) {
                            formSTBLayout.setVisibility(View.VISIBLE);
                            constructIptvLayout();
                        }
                        if (coreServiceCodes.contains("VPN")) {
                            formVpnLayout.setVisibility(View.VISIBLE);
                            //requestHandler.getCoreSrvcCodeByCafNo(getActivity(), this, Constants.cafNumber, Constants.CORESERVICECODE);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                } else {
                    Utils.cancelProgress();
                    Utils.showDialog(this, getString(R.string.request_failure_title),
                            getString(R.string.request_failure_message), null);
                }
                break;

            case Constants.GET_VPNSRVCNAMES:
                Utils.cancelProgress();
                if (response != null) {
                    loadVpnData(oltIDSpinner.getSelectedItemPosition(), 0);
                }
                break;
            case Constants.OLTSLOT3_SLOT_DATA:
                if (response != null && !response.equals(" ")) {
                    //JSONObject data = (JSONObject) response;
/*
                    try {
                        level3SlotList = data.getString("level3SlotList");

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
*/
                    String l3slots = response.toString();
                    try {
                        JSONObject object = new JSONObject(l3slots);
                        level3SlotList = object.getString("level3SlotList");
                        loadL3data(level3SlotList);
                        Log.d(TAG, "responseHandler: " + level3SlotList);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    Utils.showDialog(this, getString(R.string.Error), getString(R.string.slotalready_assigned_message), null);
                }
        }

    }

    private void loadL3data(String level3SlotList) {
        String[] l3Data = null, finalL3Data = null;
        if (level3SlotList != null) {
            level3SlotList = level3SlotList.replaceAll("[\\[\\]]*", "");
            l3Data = level3SlotList.split(",");
            finalL3Data = new String[l3Data.length + 1];
            for (int i = 0; i < finalL3Data.length; i++) {
                if (i == 0) {
                    finalL3Data[0] = "--Select--";
                } else {
                    finalL3Data[i] = l3Data[i - 1];
                }
            }

        }
        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(getActivity(), finalL3Data);
        oltPortLevel3Spinner.setAdapter(adapter);
        //oltPortLevel3Spinner.setSelection(0);
        oltPortLevel3Header.setVisibility(View.VISIBLE);
        oltPortLevel3Spinner.setVisibility(View.VISIBLE);
    }

    public void checkForIpTvAndVpnVisibility() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<ProductModel> products = realm.where(ProductModel.class)
                .equalTo("isProductChecked", true)
                .findAll();
        boolean isContainsIpTv = false;
        boolean isContainsVpn = false;
        boolean isContainTelePhoneConn = false;
        if (products.size() > 0) {
            for (ProductModel productModel : products) {
                if (productModel.getCoreServiceCode().contains("IPTV")) {
                    formSTBLayout.setVisibility(View.VISIBLE);
                    isContainsIpTv = true;
                }
                if (productModel.getCoreServiceCode().contains("VPN")) {
                    isContainsVpn = true;
                }
                if (productModel.getCoreServiceCode().contains("VOIP")) {
                    isContainTelePhoneConn = true;
                }
            }
            if (isContainsVpn) {
                formVpnLayout.setVisibility(View.VISIBLE);
            }
            if (isContainsIpTv) {
                formSTBLayout.setVisibility(View.VISIBLE);
                CPEInfoModel cpeInfoModel = realm.where(CPEInfoModel.class).equalTo("formTime", Constants.formTime).findFirst();
                if (cpeInfoModel == null) {
                    constructIptvLayout();
                }
            } else {
                realm.beginTransaction();
                realm.where(IptvDataModel.class).equalTo("formTime", Constants.formTime).findAll().deleteAllFromRealm();
                realm.commitTransaction();
                realm.close();
            }
            if (isContainTelePhoneConn) {
                formtelephonicLayout.setVisibility(View.VISIBLE);
            }
        }
    }

    private void constructIptvLayout() {

        final Spinner cpeSTBSpinner;
        final EditText iptvBoxUpfrontPrice, iptvBoxEmiprice, formIPTVSerialNumber, formIPTVMacAddress, iptvEmiCount;
        final LinearLayout formIPTVLayout, formIfSTBLeaseLayout;
        //RadioGroup formSTBRadioGroup;
        //RadioButton stbYesRadioButton, stbNoRadioButton;
        final TextView iptvPackage, iptvPackageHeader;
        final ArrayList<SelectedIpTvPackage> ipTvPackageProducts = new ArrayList<>();
        final boolean[] checkedPackages;
        final String[] selectedPackages;
        final String[] selectedPackageCode;
        final RealmList<CPEDataModel> stbDeviceSpinnerItems = new RealmList<>();

        int stbChildSize = stbWrapper.getChildCount() + 1;
        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
        LinearLayout iptvLayout = (LinearLayout) layoutInflater.inflate(R.layout.layout_iptv, null);
        cpeSTBSpinner = (Spinner) iptvLayout.findViewById(R.id.cpeSTBModelSpinner);
        setStbSpinner(cpeSTBSpinner);
        cpeSTBSpinner.setEnabled(false);
        cpeSTBSpinner.setClickable(false);
        iptvEmiCount = (EditText) iptvLayout.findViewById(R.id.iptvEmiCount);
        iptvBoxUpfrontPrice = (EditText) iptvLayout.findViewById(R.id.iptvBoxUpfrontPrice);
        formIPTVLayout = (LinearLayout) iptvLayout.findViewById(R.id.formIPTVLayout);
       /* formSTBRadioGroup = (RadioGroup) iptvLayout.findViewById(R.id.formSTBRadioGroup);
        stbYesRadioButton = (RadioButton) formSTBRadioGroup.findViewById(R.id.stbYesRadioButton);
        stbNoRadioButton = (RadioButton) formSTBRadioGroup.findViewById(R.id.stbNoRadioButton);
        formSTBRadioGroup.check(R.id.stbYesRadioButton);*/
        formIfSTBLeaseLayout = (LinearLayout) iptvLayout.findViewById(R.id.formIfSTBLeaseLayout);
        //formIfSTBLeaseLayout.setVisibility(View.GONE);
        iptvBoxEmiprice = (EditText) iptvLayout.findViewById(R.id.iptvBoxEmiprice);
        formIPTVSerialNumber = (EditText) iptvLayout.findViewById(R.id.formIPTVSerialNoEditText);
        formIPTVMacAddress = (EditText) iptvLayout.findViewById(R.id.formIPTVMacAddressEditText);
        formIPTVMacAddress.setEnabled(false);
       /* if (lmoType.equals("SI")) {
            stbYesRadioButton.setEnabled(false);
            stbNoRadioButton.setEnabled(false);
        }*/
        iptvPackage = (TextView) iptvLayout.findViewById(R.id.iptvPackage);
        iptvPackageHeader = (TextView) iptvLayout.findViewById(R.id.iptvPackageHeader);
        Realm realm = Realm.getDefaultInstance();
        RealmResults<ProductModel> productModelsResult = realm.where(ProductModel.class).equalTo("isProductChecked", true).contains("coreServiceCode", "IPTV").notEqualTo("productType", "B").findAllSorted("productName", Sort.DESCENDING);
        checkedPackages = new boolean[productModelsResult.size()];
        selectedPackages = new String[productModelsResult.size()];
        selectedPackageCode = new String[productModelsResult.size()];
        Log.d("selectedPackages size", productModelsResult.size() + "");
        Log.d("selectedPackages size", productModelsResult.toString());
        String staticPackagesNames = "";
        if (productModelsResult.size() > 0) {
            for (int i = 0; i < productModelsResult.size(); i++) {
                checkedPackages[i] = true;
                selectedPackages[i] = productModelsResult.get(i).getProductName();
                selectedPackageCode[i] = productModelsResult.get(i).getProductCode();
            }
            for (String s : selectedPackages) {
                if (staticPackagesNames.equals("")) {
                    staticPackagesNames = s;
                } else {
                    staticPackagesNames += "," + s;
                }
            }
            iptvPackage.setText(staticPackagesNames);
            iptvPackage.setEnabled(false);
        } else {
            iptvPackage.setText("");
            iptvPackage.setEnabled(false);
            iptvPackage.setVisibility(View.GONE);
            iptvPackageHeader.setVisibility(View.GONE);
        }
        cpeSTBSpinner.setTag(stbChildSize);
        iptvEmiCount.setTag(stbChildSize);
        iptvPackage.setTag(stbChildSize);
        iptvBoxUpfrontPrice.setTag(stbChildSize);
        formIPTVLayout.setTag(stbChildSize);
        /*formSTBRadioGroup.setTag(stbChildSize);
        stbYesRadioButton.setTag(stbChildSize);
        stbNoRadioButton.setTag(stbChildSize);*/
        formIfSTBLeaseLayout.setTag(stbChildSize);
        iptvBoxEmiprice.setTag(stbChildSize);
        formIPTVSerialNumber.setTag(stbChildSize);
        formIPTVMacAddress.setTag(stbChildSize);

        cpeSTBSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                CPEDataModel cpeDataModel = stbModelSpinnerItems.get(position);
                if (cpeDataModel.getCpeProfileID() != -1) {
                    iptvEmiCount.setText(cpeDataModel.getCpeInstallmentCount());
                    iptvBoxUpfrontPrice.setText(cpeDataModel.getUpFrontCharges());
                    iptvBoxEmiprice.setText(cpeDataModel.getCpePurchaseCost());
                    //loadstbPurchaseSpinner(stbDeviceSpinnerItems, iptvEmiCount, position, 0);
                } else {
                    iptvEmiCount.setText("");
                    iptvBoxUpfrontPrice.setText("");
                    iptvBoxEmiprice.setText("");
                    //iptvEmiCount.setSelection(0);
                }
                // CPEDataModel cpeDataModel;
                //  if (position > 0) {
                // loadstbPurchaseSpinner(stbDeviceSpinnerItems,iptvEmiCountSpinner,position,0);
                   /*
                    cpeDataModel = stbModelSpinnerItems.get(position);
                    if (cpeDataModel.getCpeProfileID() != -1) {
                        if (formIfSTBLeaseLayout.getVisibility() == View.VISIBLE) {
                            switch (iptvEmiCountSpinner.getSelectedItemPosition()) {
                                case 1: // Purchase
                                    iptvBoxUpfrontPrice.setText(cpeDataModel.getCpePurchaseCost());
                                    iptvBoxEmiprice.setText("");
                                    iptvBoxEmiprice.setHint(R.string.iptv_installments_hint);
                                    break;

                                case 2: // Installment
                                    iptvBoxUpfrontPrice.setText(cpeDataModel.getCpeInstallmentCost());
                                    iptvBoxEmiprice.setText(cpeDataModel.getCpeInstallmentCount());
                                    break;
                            }
                        }
                    }*/
                // }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
       /* iptvEmiCount.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                CPEDataModel cpeDataModel = stbDeviceSpinnerItems.get(position);
                if (cpeDataModel.getCpeProfileID() != -1) {
                    iptvBoxEmiprice.setText(cpeDataModel.getCpeInstallmentCost());
                    iptvBoxUpfrontPrice.setText(cpeDataModel.getUpFrontCharges());
                    // formInstallationCharge.setText(cpeDataModel.getCpeInstallationCost());
                    //onuEmiAmount.setText("");
                    //onuEmiAmount.setHint(R.string.cpe_installments_hint);
                } else {
                    iptvBoxEmiprice.setText("");
                    iptvBoxUpfrontPrice.setText("");
                }

               *//* switch (position) {
                    case 1: // Purchase

                        if (cpeDataModel.getCpeProfileID() != -1) {
                            iptvBoxUpfrontPrice.setText(cpeDataModel.getCpePurchaseCost());
                            iptvBoxEmiprice.setText("");
                            iptvBoxEmiprice.setHint(R.string.iptv_installments_hint);
                        }
                        break;

                    case 2: // Installment
                        cpeDataModel = stbModelSpinnerItems.get(cpeSTBSpinner.getSelectedItemPosition());
                        if (cpeDataModel.getCpeProfileID() != -1) {
                            iptvBoxUpfrontPrice.setText(cpeDataModel.getCpeInstallmentCost());
                            iptvBoxEmiprice.setText(cpeDataModel.getCpeInstallmentCount());
                        }
                        break;
                }*//*

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/

        formIPTVSerialNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String stbSerialNumber = formIPTVSerialNumber.getText().toString();
                // int stbPositionId = stbModelSpinnerItems.get(cpeSTBSpinner.getSelectedItemPosition()).getCpeProfileID();
                CPEStockModel iptvCpeStocks = Realm.getDefaultInstance().where(CPEStockModel.class).
                        equalTo("cpeSerialNumber", stbSerialNumber).findFirst();
                if (iptvCpeStocks != null) {
                    String macId = iptvCpeStocks.getCpeMacId();
                    formIPTVMacAddress.setText(macId);
                    int profileId = iptvCpeStocks.getCpeProfileID();
                    CPEDataModel cpeDataModel = Realm.getDefaultInstance().where(CPEDataModel.class).equalTo("cpeProfileID", profileId).findFirst();
                    if (cpeDataModel != null) {
                        cpeSTBSpinner.setSelection(getIndex(cpeSTBSpinner, cpeDataModel.getCpeModelName()));
                    }

                } else {
                    formIPTVMacAddress.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
       /* formSTBRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.stbYesRadioButton:
                        formIfSTBLeaseLayout.setVisibility(View.GONE);
                        iptvEmiCountSpinner.setSelection(0);
                        iptvBoxUpfrontPrice.setText("");
                        iptvBoxEmiprice.setText("");
                        iptvBoxEmiprice.setHint(R.string.iptv_installments_hint);
                        break;

                    case R.id.stbNoRadioButton:
                        formIfSTBLeaseLayout.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });*/

       /* iptvPackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iptvPackage.setText("");
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                //make a list to hold state of multi selected pkg item

                for (int i = 0; i < selectedPackages.length; i++) {
                    SelectedIpTvPackage selectedIpTvPackage = new SelectedIpTvPackage();
                    selectedIpTvPackage.setPackageName(selectedPackages[i]);
                    selectedIpTvPackage.setpackagecode(selectedPackageCode[i]);
                    selectedIpTvPackage.setSelectedPackages(checkedPackages[i]);
                    ipTvPackageProducts.add(selectedIpTvPackage);
                }

                builder.setMultiChoiceItems(selectedPackages, checkedPackages, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        //set state to pojo list
                        ipTvPackageProducts.get(which).setSelectedPackages(isChecked);
                        *//*Toast.makeText(getActivity(),
                                ipTvPackageProducts.get(which).getPackageCOde() + " " + isChecked, Toast.LENGTH_SHORT).show();*//*
                    }
                });
                builder.setCancelable(false);
                builder.setTitle("Selected Packages");

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // save state of selected vos
                        ArrayList<SelectedIpTvPackage> selectedList = new ArrayList<>();
                        Log.d("ipTvPackageProduct size", ipTvPackageProducts.size() + "");
                        for (int i = 0; i < ipTvPackageProducts.size(); i++) {
                            Log.d("i value", i + "");
                            SelectedIpTvPackage selectedIpTvPackage = ipTvPackageProducts.get(i);
                            selectedPackages[i] = selectedIpTvPackage.getPackageName();
                            selectedPackageCode[i] = selectedIpTvPackage.getPackageCOde();
                            checkedPackages[i] = selectedIpTvPackage.isSelectedPackages();
                            if (selectedIpTvPackage.isSelectedPackages()) {
                                selectedList.add(selectedIpTvPackage);
                            }
                        }

                        for (int i = 0; i < selectedList.size(); i++) {
                            // if element is last then not attach comma or attach it
                            if (i != selectedList.size() - 1)
                                iptvPackage.setText(iptvPackage.getText() + selectedList.get(i).getPackageName() + ",");
                            else
                                iptvPackage.setText(iptvPackage.getText() + selectedList.get(i).getPackageName());//
                        }
                        ipTvPackageProducts.clear();
                    }
                });

               *//* builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // make sure to clear list that duplication dont formed here
                        ipTvPackageProducts.clear();
                    }
                });

                builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // make sure to clear list that duplication dont formed here
                        ipTvPackageProducts.clear();
                    }
                });*//*

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });*/

        stbWrapper.addView(iptvLayout);


    }

    private boolean isPackageChanged() {
        boolean changed = false;
        Realm realm = Realm.getDefaultInstance();
        OfflineFormModel offlineFormModel = realm.where(OfflineFormModel.class).
                equalTo("formTime", Constants.formTime).findFirst();
        if (offlineFormModel != null) {
            String data = offlineFormModel.getFormPaymentData();
            JSONObject paymentData = null;
            try {
                RealmResults<ProductModel> productModels = realm.where(ProductModel.class)
                        .equalTo("isProductChecked", true)
                        .findAll();
                paymentData = new JSONObject(data).getJSONObject("customerCafVO");
                JSONArray products = paymentData.getJSONArray("products");
                for (int i = 0; i < products.length(); i++) {
                    JSONObject eachProduct = products.getJSONObject(i);
                    for (ProductModel productModel : productModels) {
                        if (!productModel.getProductCode().equals(eachProduct.getString("prodcode"))) {
                            changed = true;
                            Log.d(TAG, "products Changed Status" + changed);
                        }
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return changed;
    }

    private class GenericTextWatcher implements TextWatcher {

        private View view;

        private GenericTextWatcher(View view) {
            this.view = view;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            //need to place in after text change if cpe serial number is checked.
           /* switch (view.getId()) {
                case R.id.formONUID:*/
            String onuSerialNumber = formONUSerialNumber.getText().toString();
            //int onuId = onuModelSpinnerItems.get(cpeONUSpinner.getSelectedItemPosition()).getCpeProfileID();
            CPEStockModel onuCpeStocks = Realm.getDefaultInstance().where(CPEStockModel.class).
                    equalTo("cpeSerialNumber", onuSerialNumber).findFirst();//.equalTo("cpeProfileID", onuId)
            if (onuCpeStocks != null) {
                String macId = onuCpeStocks.getCpeMacId();
                formONUMacAddress.setText(macId);
                if (onuCpeStocks != null) {
                    int profileId = onuCpeStocks.getCpeProfileID();
                    CPEDataModel cpeDataModel = Realm.getDefaultInstance().where(CPEDataModel.class).equalTo("cpeProfileID", profileId).findFirst();
                    if (cpeDataModel != null) {
                        cpeONUSpinner.setSelection(getIndex(cpeONUSpinner, cpeDataModel.getCpeModelName()));
                    }


                }

            } else {
                formONUMacAddress.setText("");
            }
                 /*   break;

            }*/

        }

        @Override
        public void afterTextChanged(Editable s) {
            String text = s.toString();


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
        return position;

    }
}
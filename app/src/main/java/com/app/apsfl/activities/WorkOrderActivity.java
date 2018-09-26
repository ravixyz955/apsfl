package com.app.apsfl.activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.app.apsfl.R;
import com.app.apsfl.adapters.CustomSpinnerAdapter;
import com.app.apsfl.application.BaseApplication;
import com.app.apsfl.httpClient.RequestHandler;
import com.app.apsfl.interfaces.ResponseHandler;
import com.app.apsfl.interfaces.UserActionInterface;
import com.app.apsfl.models.CPEDataModel;
import com.app.apsfl.models.CPEInfoModel;
import com.app.apsfl.models.CustomerAddressModel;
import com.app.apsfl.models.CustomerInfoModel;
import com.app.apsfl.models.IptvDataModel;
import com.app.apsfl.models.MandalModel;
import com.app.apsfl.models.OfflineFormModel;
import com.app.apsfl.models.POPModel;
import com.app.apsfl.models.ProductModel;
import com.app.apsfl.models.VillageModel;
import com.app.apsfl.utils.Constants;
import com.app.apsfl.utils.FormValidations;
import com.app.apsfl.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import io.realm.Realm;
import io.realm.RealmResults;

public class WorkOrderActivity extends AppCompatActivity
        implements RadioGroup.OnCheckedChangeListener, ResponseHandler,
        UserActionInterface, View.OnClickListener, AdapterView.OnItemSelectedListener {

    public static final String TAG = "WorkOrderActivity";
    SharedPreferences sharedPreferences;
    private Toolbar mToolbar;
    private Integer customerID;
    private TextView feaseCAFNo, feaseAadhaarNo, feaseCustomerFirstName,feaseCustomerLastName, feaseProducts, feaseCPECharges, paymentDDDate,
            feaseTotalCharge, feaseBillFrequency, feaseEffectiveDate, formLMOName, formLMOWallet, formLMOCreditLimit, formLMORemainingLimit,
            feaseTotalInstallationAmount,vpnServiceName,amountTv;
    private RadioGroup feaseRadioGroup;
    private RadioButton feaseRadioYes;
    private Spinner paymentSpinner;
    private int amountPercentage;
    private EditText paymentAmountEditText;
    private Calendar calendarInstance;
    private LinearLayout paymentAmountLayout,feasibilityLayout;
    private RequestHandler requestHandler;
    private String lmoType, billCycle,Paymentspinnertext,payamount;
    private DatePickerDialog.OnDateSetListener dateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    calendarInstance.set(Calendar.YEAR, year);
                    calendarInstance.set(Calendar.MONTH, monthOfYear);
                    calendarInstance.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    updateCustomerDOB();
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_order);
        initViews();
        setupToolBar();
        registerListeners();
        setSpinnerData();
        getWalletBalance();
    }

    private void initViews() {
        requestHandler = new RequestHandler();
        calendarInstance = Calendar.getInstance();
        mToolbar = (Toolbar) findViewById(R.id.toolBar);
        LinearLayout mainLayout = (LinearLayout) findViewById(R.id.mainLayout);
        LinearLayout tenantBalanceLayout = (LinearLayout) mainLayout.findViewById(R.id.tenantBalanceLayout);
        amountTv= (TextView)findViewById(R.id.amountTv);
        formLMOName = (TextView) tenantBalanceLayout.findViewById(R.id.lmoName);
        formLMOWallet = (TextView) tenantBalanceLayout.findViewById(R.id.lmoWallet);
        formLMOCreditLimit = (TextView) tenantBalanceLayout.findViewById(R.id.lmoCreditLimit);
        formLMORemainingLimit = (TextView) tenantBalanceLayout.findViewById(R.id.lmoRemainingLimit);
        feaseCAFNo = (TextView) mainLayout.findViewById(R.id.feaseCAFNo);
        feaseAadhaarNo = (TextView) mainLayout.findViewById(R.id.feaseAadhaarNo);
        feaseCustomerFirstName = (TextView) mainLayout.findViewById(R.id.feaseCustomerFirstName);
        TextView customerSurnameHeader = (TextView) mainLayout.findViewById(R.id.customerSurnameHeader);
        feaseCustomerLastName = (TextView) mainLayout.findViewById(R.id.feaseCustomerLastName);
        feaseProducts = (TextView) mainLayout.findViewById(R.id.feaseProducts);
        // feaseTotalInstallationAmount = (TextView) mainLayout.findViewById(R.id.feaseTotalInstAmount);
        feaseCPECharges = (TextView) mainLayout.findViewById(R.id.feaseCPECharges);
        feaseTotalCharge = (TextView) mainLayout.findViewById(R.id.feaseTotalCharge);
        feaseEffectiveDate = (TextView) mainLayout.findViewById(R.id.feaseEffectiveDate);
        feaseBillFrequency = (TextView) mainLayout.findViewById(R.id.feaseBillFrequency);
        feaseRadioGroup = (RadioGroup) mainLayout.findViewById(R.id.feaseCheckRadioGroup);
        feaseRadioYes = (RadioButton) feaseRadioGroup.findViewById(R.id.feaseRadioYes);
        RadioButton feaseRadioNo = (RadioButton) feaseRadioGroup.findViewById(R.id.feaseRadioNo);
       /* feaseONUModelName = (TextView) mainLayout.findViewById(R.id.feaseONUModelName);
        feaseONUSerialNumber = (TextView) mainLayout.findViewById(R.id.feaseONUSerialNumber);
        feaseONUMacAddress = (TextView) mainLayout.findViewById(R.id.feaseONUMacAddress);
        feaseIPTVModelName = (TextView) mainLayout.findViewById(R.id.feaseIPTVModelName);
        feaseIPTVSerialNumber = (TextView) mainLayout.findViewById(R.id.feaseIPTVSerialNumber);
        feaseIPTVMacAddress = (TextView) mainLayout.findViewById(R.id.feaseIPTVMacAddress);*/
        paymentSpinner = (Spinner) mainLayout.findViewById(R.id.paymentSpinner);
        paymentAmountLayout = (LinearLayout) mainLayout.findViewById(R.id.paymentAmountLayout);
        paymentAmountEditText = (EditText) paymentAmountLayout.findViewById(R.id.paymentAmountEditText);
        LinearLayout paymentDDLayout = (LinearLayout) mainLayout.findViewById(R.id.paymentDDLayout);
        paymentDDDate = (TextView) paymentDDLayout.findViewById(R.id.paymentDDDate);
        EditText paymentDDNOEditText = (EditText) paymentDDLayout.findViewById(R.id.paymentDDNOEditText);
        EditText paymentBankEditText = (EditText) paymentDDLayout.findViewById(R.id.paymentBankEditText);
        EditText paymentBranchEditText = (EditText) paymentDDLayout.findViewById(R.id.paymentBranchEditText);
        paymentDDLayout.setVisibility(View.GONE);
        feasibilityLayout= (LinearLayout) mainLayout.findViewById(R.id.feasibilityLayout);
        feasibilityLayout.setVisibility(View.GONE);
        // vpnServiceName= (TextView) mainLayout.findViewById(R.id.vpnServiceName);
        sharedPreferences = BaseApplication.getSharedPreferences();
        lmoType = sharedPreferences.getString(Constants.TENANT_TYPE, "");
        if (Constants.cafType == 2) {
            customerSurnameHeader.setVisibility(View.GONE);
            feaseCustomerLastName.setVisibility(View.GONE);
        }
        if (lmoType.equals("SI")) {
            paymentAmountLayout.setVisibility(View.GONE);
            feaseRadioNo.setEnabled(false);
            feaseRadioNo.setEnabled(false);
        }
    }

    private void setupToolBar() {
        setSupportActionBar(mToolbar);
        ActionBar mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void registerListeners() {
        feaseRadioGroup.setOnCheckedChangeListener(this);
        paymentSpinner.setOnItemSelectedListener(this);
        paymentDDDate.setOnClickListener(this);
        feaseProducts.setOnClickListener(this);
        feaseCPECharges.setOnClickListener(this);
    }

    private void getWalletBalance() {
        if (lmoType.equals("LMO") && Utils.isNetworkAvailable(this)) {
            Utils.showProgress(this, getString(R.string.processing_request));
            requestHandler.getWalletBalance(this, null, Constants.GET_WALLET_BALANCE);
        } else {
            SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();
            formLMOName.setText(String.format("%s", sharedPreferences.getString(Constants.LMO_NAME, "")));
            formLMOWallet.setText(String.format("%s", "NA"));
            formLMOCreditLimit.setText(String.format("%s", "NA"));
            formLMORemainingLimit.setText(String.format("%s", "NA"));
            loadSavedData();
        }
    }

    private void setSpinnerData() {
        String[] paymentModes = getResources().getStringArray(R.array.cash_mode_spinner_items);
        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(this, paymentModes);
        paymentSpinner.setAdapter(adapter);
    }

    private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                dateSetListener,
                calendarInstance.get(Calendar.YEAR),
                calendarInstance.get(Calendar.MONTH),
                calendarInstance.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.getDatePicker().setMaxDate(Calendar.getInstance().getTimeInMillis());
        datePickerDialog.show();
    }

    private void updateCustomerDOB() {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
        paymentDDDate.setText(format.format(calendarInstance.getTime()));
    }

    private void loadSavedData() {
        Realm realm = Realm.getDefaultInstance();
        try {
            CustomerInfoModel customerInfoModel = realm.where(CustomerInfoModel.class)
                    .equalTo("formTime", Constants.formTime).findFirst();
            CPEInfoModel cpeInfoModel = realm.where(CPEInfoModel.class)
                    .equalTo("formTime", Constants.formTime).findFirst();
            feaseCAFNo.setText(Constants.cafNumber.equals("") ? "" : Constants.cafNumber);
            feaseAadhaarNo.setText(customerInfoModel.getCustomerAadhaarNumber());
            feaseCustomerFirstName.setText(customerInfoModel.getCustomerFirstName());
            feaseCustomerLastName.setText(customerInfoModel.getCustomerLastName());
            // vpnServiceName.setText(cpeInfoModel.getVpnServiceName());
            feaseProducts.setText(String.format("%s", "Click to see selected packages"));
            feaseCPECharges.setText(String.format("%s", "Click to see CPE charge details"));
            //String abcd=getTotalCharge(cpeInfoModel);
            // feaseTotalInstallationAmount.setText("");//getTotalInstallationAmount(cpeInfoModel)

            feaseTotalCharge.setText(getTotalCharge(cpeInfoModel));//Total charge
            feaseEffectiveDate.setText(Utils.getCurrentDate());
            switch (Constants.billFrequencyValue) {
                case 1:
                    feaseBillFrequency.setText(String.format("%s", "MONTHLY"));
                    billCycle = "MONTHLY";
                    break;

                case 3:
                    feaseBillFrequency.setText(String.format("%s", "QUARTERLY"));
                    billCycle = "QUARTERLY";
                    break;

                case 6:
                    feaseBillFrequency.setText(String.format("%s", "HALFYEARLY"));
                    billCycle = "HALFYEARLY";
                    break;

                case 12:
                    feaseBillFrequency.setText(String.format("%s", "YEARLY"));
                    billCycle = "YEARLY";
                    break;
            }
            realm.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d(TAG, "exception in loadSavedData method");
            realm.close();
        }
    }

    private String getTotalCharge(CPEInfoModel cpeInfoModel) {
        Realm realm = Realm.getDefaultInstance();
        float totalProductCharge = 0, productSelectedCount = 1;
        RealmResults<ProductModel> products = realm.where(ProductModel.class)
                .equalTo("isProductChecked", true)
                .findAll();
        for (ProductModel productModel : products) {
            if (totalProductCharge == 0) {

                productSelectedCount=realm.where(IptvDataModel.class).equalTo("formTime",Constants.formTime).contains("iptvPkg",productModel.getProductName()).count();
                if(productSelectedCount == 0){
                    productSelectedCount = 1;
                }
                Log.d(TAG,"productSelectedCount"+productSelectedCount);
                totalProductCharge = ((Float.parseFloat(productModel.getProductSecurityCharge())* Constants.billFrequencyValue )
                        + Float.parseFloat(productModel.getProductActivationCharge())
                        + Float.parseFloat(productModel.getProductActivationTax()))* productSelectedCount;
            } else {

                productSelectedCount=realm.where(IptvDataModel.class).equalTo("formTime",Constants.formTime).contains("iptvPkg",productModel.getProductCode()).count();
                if(productSelectedCount == 0){
                    productSelectedCount = 1;
                }
                totalProductCharge += ((Float.parseFloat(productModel.getProductSecurityCharge())* Constants.billFrequencyValue )
                        + Float.parseFloat(productModel.getProductActivationCharge())
                        + Float.parseFloat(productModel.getProductActivationTax()))* productSelectedCount;
            }
        }



        float onuCharge = 0, installationTax = 0,installationCharge = 0;
        installationCharge= Float.parseFloat(cpeInfoModel.getOnuInstallationCharge());
        installationTax = Float.parseFloat(cpeInfoModel.getInstallationTax());

        onuCharge = Float.parseFloat(cpeInfoModel.getOnuUpfrontEmount())
                + Float.parseFloat(cpeInfoModel.getOnuTax());

       /* switch (cpeInfoModel.getOnuDevicePurchasePosition()) {
            case 1: // Purchase
                onuCharge = Float.parseFloat(cpeInfoModel.getOnuPriceForInstallment())
                        + Float.parseFloat(cpeInfoModel.getOnuTax());
               // installationTax = Float.parseFloat(onuDataModel.getInstallationTaxAmount());
                Log.d(TAG, "Purchase onumodel" + cpeInfoModel.toString());
               // Log.d(TAG, "cpe Tax:" + onuDataModel.getCpeTax());
                Log.d(TAG, "installationTax1:" + installationTax);
                break;

            case 2: // Installment
                //  onuCharge = Float.parseFloat(onuDataModel.getCpeInstallmentCost());

                break;
        }*/

        float stbCharge = 0;
        for(int i=0;i<cpeInfoModel.getSelectedIptvList().size();i++){
            stbCharge += Float.parseFloat(cpeInfoModel.getSelectedIptvList().get(i).getUpfrontAmount())
                    + Float.parseFloat(cpeInfoModel.getSelectedIptvList().get(i).getIptvBoxTax());
            /*switch (cpeInfoModel.getSelectedIptvList().get(i).getStbDevicePurchasePosition()) {
                case 1: // Purchase

                    // installationTax = Float.parseFloat(stbDataModel.getInstallationTaxAmount());
                   // Log.d(TAG, "Purchase stbmodel " + stbDataModel.toString());

                    //Log.d(TAG, "cpe Tax:" + stbDataModel.getCpeTax());
                   // Log.d(TAG, "installationTax2:" + installationTax);
                    break;

                case 2: // Installment
                    //  stbCharge = Float.parseFloat(stbDataModel.getCpeInstallmentCost());

                    break;
            }*/
        }

        float totalCPECharge = onuCharge + stbCharge + installationTax + installationCharge;
       /* CustomerAddressModel addressModel = realm.where(CustomerAddressModel.class)
                .equalTo("formTime", Constants.formTime).findFirst();
        float totalCPETax = getCPETax(addressModel.getPinCode(), totalCPECharge);*/
        Log.d("Product Charge", "\t" + totalProductCharge);
        Log.d("CPE Charge", "\t" + totalCPECharge);
        Log.d("installation Charge", "\t" + installationTax +" "+ installationCharge);
        return String.format(Locale.getDefault(), "%.2f", (totalProductCharge + totalCPECharge));
    }
    //Installation
   /* private String getTotalInstallationAmount(CPEInfoModel cpeInfoModel){

        CPEDataModel onuDataModel = cpeInfoModel.getSelectedONUDataModel();
        float installationTax = 0,installationCharge = 0;
        installationCharge= Float.parseFloat(onuDataModel.getCpeInstallationCost());
        installationTax = Float.parseFloat(onuDataModel.getInstallationTaxAmount());
        return String.format(Locale.getDefault(), "%.2f", (installationCharge + installationTax));
    }*/
    /*private float getCPETax(String pinCode, float totalCPECharge) {
        float totalCPETax = 0;
        String regionCode;
        Realm realm = Realm.getDefaultInstance();
        TaxRegionModel taxRegionModel = realm.where(TaxRegionModel.class).equalTo("pinCode", pinCode).findFirst();
        if (taxRegionModel == null) {
            regionCode = "GENERAL";
        } else {
            regionCode = taxRegionModel.getRegionCode();
        }
        String taxCode = realm.where(ChargeTaxModel.class).equalTo("chargeCode", "CPECOST").findFirst().getTaxCode();
        TaxModel taxModel = realm.where(TaxModel.class)
                .beginGroup()
                .equalTo("regionCode", regionCode)
                .equalTo("taxCode", taxCode)
                .greaterThanOrEqualTo("effectiveFrom", System.currentTimeMillis())
                .lessThan("effectiveTo", System.currentTimeMillis())
                .endGroup()
                .findFirst();
        double taxPercentage;
        if (taxModel != null) {
            taxPercentage = taxModel.getTaxPercentage();
            if (taxModel.isAbsolute()) {
                totalCPETax = (float) (totalCPECharge * taxPercentage);
            } else {
                totalCPETax = (float) ((totalCPECharge * taxPercentage) / 100);
            }
        }
        realm.close();
        return totalCPETax;
    }*/
//Commented by sandeep on 23-02-2018
    private void validateFields() {
        if (FormValidations.isFormSpinnerItemSelected(paymentSpinner, FormValidations.SPINNER.PAYMENT_MODE))
            if (FormValidations.isFormEditTextValid(paymentAmountEditText, FormValidations.FORM_FIELDS.PAYMENT_AMOUNT)) {
                Float amountEntered = Float.valueOf(paymentAmountEditText.getText().toString());
                Float amountToPay = Float.valueOf(feaseTotalCharge.getText().toString());
                if (amountEntered >= amountToPay) {
                    if (amountPercentage < 70) {
                        processPayment();
                    } else if (amountPercentage >= 70 && amountPercentage < 90) {
                        Utils.showDialog(this, getString(R.string.payment_credit_warning_title),
                                getString(R.string.payment_credit_reached_70), Constants.PAYMENT_GREATER_70);
                    } else {
                        Utils.showDialog(this, getString(R.string.payment_credit_warning_title),
                                getString(R.string.payment_credit_reached_90), Constants.PAYMENT_GREATER_90);
                    }
                } else {
                    Utils.showDialog(this, getString(R.string.invalid_payment_amount_title),
                            getString(R.string.amount_less_than_total), null);
                }
            }
    }

    private void processPayment() {

        savePaymentFormData();
        if (Constants.isFromCAFResults) {
            makeCAFPaymentRequest(getFormPaymentDataAsJSON());
        } else {
            submitCAFForm(getCAFFormDataAsJSON());
        }
    }

    private void savePaymentFormData() {
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();
            OfflineFormModel offlineFormModel = realm.where(OfflineFormModel.class)
                    .equalTo("formTime", Constants.formTime).findFirst();
            offlineFormModel.setFormPaymentData(getFormPaymentDataAsJSON().toString());
            offlineFormModel.setIsPaymentDataAvailable(true);
            offlineFormModel.setCpeSerialNoUsed(true);
            realm.copyToRealmOrUpdate(offlineFormModel);
            realm.commitTransaction();
            realm.close();
        } catch (Exception ex) {
            realm.close();
            ex.printStackTrace();
            Log.d("Exception in  ->  ", "savePaymentFormData");
        }
    }

    private JSONObject getFormPaymentDataAsJSON() {
        JSONObject requestData = null;
        try {
            OfflineFormModel model = Realm.getDefaultInstance().where(OfflineFormModel.class)
                    .equalTo("formTime", Constants.formTime).findFirst();
            requestData = new JSONObject(model.getFormPaymentData());
            SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();
            requestData.put("cafNo", !feaseCAFNo.getText().toString().equals("") ?
                    feaseCAFNo.getText().toString() : Constants.cafNumber);
            requestData.put("parentCafno", !feaseCAFNo.getText().toString().equals("") ?
                    feaseCAFNo.getText().toString() : Constants.cafNumber);
            requestData.put("loginId", sharedPreferences.getString(Constants.USER_NAME, ""));
            requestData.put("custId", customerID);
            requestData.put("lmoCode", sharedPreferences.getString(Constants.LMO_CODE, ""));
            requestData.put("tenantCode", sharedPreferences.getString(Constants.LMO_CODE, ""));
            requestData.put("aadharNumber", feaseAadhaarNo.getText().toString());
            requestData.put("customerName", feaseCustomerFirstName.getText().toString());
            requestData.put("totalCharge", feaseTotalCharge.getText().toString());
            //commented by sandeep on 23-02-2018.
/*            requestData.put("paymentMode", paymentSpinner.getSelectedItemPosition() == 1 ? "CASH" : "");
            requestData.put("paidAmount", paymentAmountEditText.getText().toString());*/
            requestData.put("paymentMode", "CASH");
             requestData.put("paidAmount",  "0");
            requestData.put("feasibility", feaseRadioYes.isChecked() ? "Y" : "N");
            requestData.put("ipAddress", Utils.getIPAddress(this));
            requestData.put("payment", JSONObject.NULL);
            requestData.put("oltSrlNo", Constants.oltSerialNumber);
            requestData.put("oltPortNo", Constants.oltPortNumber);
            requestData.put("district", Constants.districtID);
            requestData.put("village", Constants.villageID);
            requestData.put("mandal", Constants.mandalID);
            Log.d("Payment JSON", "\t" + requestData.toString());
        } catch (Exception e) {
            Log.d("Exception in -> ", "getFormPaymentDataAsJSON");
            e.printStackTrace();
        }
        return requestData;
    }

    private void makeCAFPaymentRequest(JSONObject requestData) {
        requestHandler.submitCAFPayment(this, null, requestData, Constants.SAVE_CAF_PAYMENT);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.feasibility_check_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                onBackPressed();
                return true;

            case R.id.feasibility_done:
                processPayment();
/*                if (paymentAmountEditText.getVisibility() == View.VISIBLE) {
                    if(TextUtils.isEmpty(paymentAmountEditText.getText().toString())) {
                        paymentAmountEditText.setError("please enter amount");
                    }
                    else{
                        payamount=paymentAmountEditText.getText().toString();
                        processPayment();
                    }

                    //validateFields();
                } else {
                    payamount="0";
                    processPayment();
                }*/
                return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
      /*  Utils.showUserConfirmationDialog(this, null,
                getString(R.string.discard_payment_message), Constants.PAYMENT_DISCARD);*/
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {

            case R.id.feaseRadioYes:
                paymentAmountLayout.setVisibility(View.VISIBLE);
                break;

            case R.id.feaseRadioNo:
                paymentAmountLayout.setVisibility(View.GONE);
                break;
        }
    }

    private void submitCAFForm(JSONObject requestData) {
        if (Utils.isNetworkAvailable(this)) {
            Utils.showProgress(this, getString(R.string.submitting_caf_payment));
            try {
                if (requestData.getString("cafNo").equals("")) {
                    new RequestHandler().getCAFNumber(this, Constants.GET_CAF_NUMBER);
                } else {
                    Log.d("CAF JSON", "\t" + requestData.toString(2));
                    new RequestHandler().submitCAFForm(this, null, requestData, Constants.SAVE_CAF_FORM);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            updateStatusMessage("Unable to submitted because no internet connection ");
            Utils.showDialog(this, getString(R.string.caf_form_saved_title),
                    getString(R.string.caf_form_saved_no_internet), Constants.SAVE_CAF_OFFLINE);
        }
    }

    private JSONObject getCAFFormDataAsJSON() {
        JSONObject formJSON = null;
        Realm realm = Realm.getDefaultInstance();
        try {
            OfflineFormModel offlineFormModel = realm.where(OfflineFormModel.class)
                    .equalTo("formTime", Constants.formTime).findFirst();
            formJSON = new JSONObject(offlineFormModel.getFormCAFData());
            if (formJSON.getString("cafNo").equals("")) {
                formJSON.put("cafNo", Constants.cafNumber);
            }
            if (formJSON.getString("ipAddress").equals("0.0.0.0")) {
                formJSON.put("ipAddress", Utils.getIPAddress(this));
            }
            Log.d("CAF JSON", formJSON.toString(2));
        } catch (Exception ex) {
            realm.close();
            Log.d("Exception in ->  ", "getCAFFormDataAsJSON()");
            ex.printStackTrace();
        }
        realm.close();
        return formJSON;
    }

    private void saveCustomerID(Integer customerID) {
        try {
            Realm realm = Realm.getDefaultInstance();
            realm.beginTransaction();
            OfflineFormModel offlineFormModel = realm.where(OfflineFormModel.class)
                    .equalTo("formTime", Constants.formTime).findFirst();
            JSONObject packages = new JSONObject(offlineFormModel.getFormPaymentData()).put("custId", customerID);
            packages.put("customerCafVO", packages.getJSONObject("customerCafVO").put("custId", customerID));
            offlineFormModel.setFormPaymentData(packages.toString());
            /*//Todo
            JSONObject cafjson=new JSONObject(offlineFormModel.getFormCAFData());
            cafjson.put("status","2");
            offlineFormModel.setFormCAFData(cafjson.toString());
*/
            realm.commitTransaction();
            realm.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void deleteSubmittedData() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.where(CustomerInfoModel.class).equalTo("formTime", Constants.formTime).findAll().deleteAllFromRealm();
        realm.where(CPEInfoModel.class).equalTo("formTime", Constants.formTime).findAll().deleteAllFromRealm();
        realm.where(IptvDataModel.class).equalTo("formTime", Constants.formTime).findAll().deleteAllFromRealm();
        realm.where(CustomerAddressModel.class).equalTo("formTime", Constants.formTime).findAll().deleteAllFromRealm();
        realm.where(OfflineFormModel.class)
                .equalTo("formTime", Constants.formTime)
                .findAll().deleteAllFromRealm();
        realm.commitTransaction();
        realm.close();
        Utils.resetStaticVariables();
        resetLists();
    }

    @Override
    public void responseHandler(Object response, int requestType) {
        switch (requestType) {
            case Constants.GET_WALLET_BALANCE:
                Utils.cancelProgress();
                SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();
                formLMOName.setText(String.format("%s", sharedPreferences.getString(Constants.LMO_NAME, "")));
                if (response != null) {
                    try {
                        JSONObject responseData = (JSONObject) response;
                        amountPercentage = responseData.getInt("pecentage");
                        String walletBalance = responseData.getString("walletAmount");
                        formLMOWallet.setText(String.format("%s", walletBalance));
                        formLMOCreditLimit.setText(String.format("%s", responseData.getString("creditAmount")));
                        formLMORemainingLimit.setText(String.format("%s", responseData.getString("actualUserAmount")));
                        loadSavedData();
                    } catch (Exception ex) {
                        Log.d(TAG, "exception in ---> GET_WALLET_BALANCE response method");

                        ex.printStackTrace();
                    }
                } else {
                    formLMOWallet.setText(String.format("%s", "NA"));
                    formLMOCreditLimit.setText(String.format("%s", "NA"));
                    formLMORemainingLimit.setText(String.format("%s", "NA"));
                }
                break;

            case Constants.GET_CAF_PAYMENT_DETAILS:

                break;

            case Constants.GET_CAF_NUMBER:
                if (response != null) {
                    new RequestHandler().submitCAFForm(this, null, getCAFFormDataAsJSON(), Constants.SAVE_CAF_FORM);
                } else {
                    Utils.cancelProgress();
                    Utils.showDialog(this, getString(R.string.caf_form_saved_title),
                            getString(R.string.caf_form_saved_request_failed), Constants.SAVE_CAF_OFFLINE);
                }
                break;

            case Constants.SAVE_CAF_FORM:
                try {
                    Log.d(TAG,"SAVE_CAF_FORM" + response.toString());
                    JSONObject responseData = (JSONObject) response;

                    if(responseData.getString("statusCode").equals("200")){
                        customerID = Integer.valueOf(responseData.getString("statusMessage"));
                        saveCustomerID(customerID);
                        makeCAFPaymentRequest(getFormPaymentDataAsJSON());
                    }
                    else{
                        Utils.cancelProgress();
                        updateStatusMessage(responseData.getString("statusMessage"));
                        Utils.showDialog(this, getString(R.string.request_failure_title),
                                responseData.getString("statusMessage"), Constants.SAVE_CAF_OFFLINE);

                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                    Utils.cancelProgress();
                    updateStatusMessage("Request failed");
                    Utils.showDialog(this, getString(R.string.request_failure_title),
                            "Please try after some time", Constants.SAVE_CAF_OFFLINE);

                }
                break;

            case Constants.SAVE_CAF_PACKAGES:
                try {
                    if (response != null) {
                        makeCAFPaymentRequest(getFormPaymentDataAsJSON());
                    } else {
                        Utils.cancelProgress();
                        Utils.showDialog(this, getString(R.string.caf_form_saved_title),
                                getString(R.string.caf_form_saved_request_failed), Constants.SAVE_CAF_OFFLINE);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;


            case Constants.SAVE_CAF_PAYMENT:
                Utils.cancelProgress();
                if (response != null) {
                    if (response instanceof String) {
                        deleteSubmittedData();
                        startActivity(new Intent(this, PaymentSuccessActivity.class)
                                .putExtra("message", response.toString()));
                    } else if (response instanceof Integer) {
                        deleteSubmittedData();
                        Utils.showDialog(this, "CAF submitted successfully",
                                "Feasibility Status has been Updated Successfully.", Constants.PAYMENT_SUCCESS);
                    } else if (response instanceof JSONObject) {
                        try {
                            JSONObject responseData = (JSONObject) response;
                            if (!responseData.getString("statusCode").equals("200")) {
                                if (Constants.isFromCAFResults) {
                                    deleteSubmittedData();
                                }
                                updateStatusMessage(responseData.getString("statusMessage"));
                                Utils.showDialog(this, getString(R.string.payment_failure_title),
                                        responseData.getString("statusMessage"), Constants.PAYMENT_FAILURE);

                            } else {
                                deleteSubmittedData();
                                Utils.showDialog(this, getString(R.string.payment_success_title),
                                        responseData.getString("statusMessage"), Constants.PAYMENT_FAILURE);
                            }
                        } catch (JSONException ex) {
                            ex.printStackTrace();
                            if (Constants.isFromCAFResults) {
                                deleteSubmittedData();
                            }
                            updateStatusMessage("Your Payment was unsuccessful");
                            Utils.showDialog(this, getString(R.string.payment_failure_title),
                                    getString(R.string.payment_failure_message), Constants.PAYMENT_FAILURE);
                        }
                    }
                } else {
                    if (Constants.isFromCAFResults) {
                        deleteSubmittedData();
                    }
                    updateStatusMessage("Your Payment was unsuccessful");
                    Utils.showDialog(this, getString(R.string.payment_failure_title),
                            getString(R.string.payment_failure_message), Constants.PAYMENT_FAILURE);
                }
                break;
           /* case Constants.GET_PACKAGES:
                Utils.cancelProgress();
                if (response!=null)
                {
                    startActivity(new Intent(this, SelectedPackagesActivity.class));
                }
                break;*/
        }
    }

    @Override
    public void onDialogConfirmed(int actionType) {
        switch (actionType) {

            case Constants.PAYMENT_DISCARD:
                super.onBackPressed();
                break;

            case Constants.PAYMENT_GREATER_70:
                processPayment();
                break;

            case Constants.PAYMENT_GREATER_90:
                break;

            case Constants.SAVE_CAF_OFFLINE:
            case Constants.PAYMENT_FAILURE:
                Constants.cafNumber = "";
                Constants.formTime = null;
                if (Constants.map != null && !Constants.map.isEmpty()) {
                    Constants.map.clear();
                }
                startActivity(new Intent(this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                break;

            case Constants.PAYMENT_SUCCESS:
                startActivity(new Intent(this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.paymentDDDate:
                showDatePickerDialog();
                break;

            case R.id.feaseProducts:
               /* switch (lmoType) {
                    case "LMO":*/
                startActivity(new Intent(this, SelectedPackagesActivity.class));
                       /* break;
                    case "SI":
                        Utils.showProgress(this,getString(R.string.processing_request));
                        requestHandler.getSelectedPackages(this, null,Constants.cafNumber,billCycle ,Constants.GET_PACKAGES);
                        break;
                }*/

                break;

            case R.id.feaseCPECharges:
                startActivity(new Intent(this, SelectedCPEActivity.class));
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.paymentSpinner:
                Paymentspinnertext = paymentSpinner.getSelectedItem().toString();

                if (Paymentspinnertext.equals("CASH")) {
                    paymentAmountEditText.setVisibility(View.VISIBLE);
                    amountTv.setVisibility(View.VISIBLE);

                }
                else if(Paymentspinnertext.equals("--Select--")){
                    paymentAmountEditText.setVisibility(View.INVISIBLE);
                    amountTv.setVisibility(View.INVISIBLE);
                }
                else {



            }
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void resetLists() {
        Realm realm = Realm.getDefaultInstance();
        try {
            POPModel popModel = realm.where(POPModel.class).equalTo("isPOPChecked", true).findFirst();
            MandalModel mandalModel = realm.where(MandalModel.class).equalTo("isMandalChecked", true).findFirst();
            VillageModel villageModel = realm.where(VillageModel.class).equalTo("isVillageChecked", true).findFirst();
            RealmResults<ProductModel> productResults = realm.where(ProductModel.class).findAll();
            realm.beginTransaction();
            if (popModel != null && popModel.isPOPChecked()) {
                popModel.setPOPChecked(false);
            }
            if (mandalModel != null && mandalModel.isMandalChecked()) {
                mandalModel.setMandalChecked(false);
            }
            if (villageModel != null && villageModel.isVillageChecked()) {
                villageModel.setVillageChecked(false);
            }

            for (ProductModel productModel : productResults) {
                if (productModel.isProductChecked()) {
                    productModel.setProductChecked(false);
                }

            }
            realm.commitTransaction();
            realm.close();
        } catch (Exception ex) {
            Log.d("Exception in -> ", "reset models ");
            realm.cancelTransaction();
            ex.printStackTrace();
        }
    }
    private void updateStatusMessage(String message){
        Realm realm = Realm.getDefaultInstance();
        OfflineFormModel formModel = realm.where(OfflineFormModel.class)
                .equalTo("formTime", Constants.formTime)
                .findFirst();
        if(formModel != null) {
            realm.beginTransaction();
            formModel.setStatusMessage(message);
            realm.commitTransaction();
        }
        realm.close();
    }
}
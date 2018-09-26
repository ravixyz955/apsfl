package com.app.apsfl.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.app.apsfl.R;
import com.app.apsfl.application.BaseApplication;
import com.app.apsfl.httpClient.RequestHandler;
import com.app.apsfl.interfaces.ResponseHandler;
import com.app.apsfl.interfaces.UserActionInterface;
import com.app.apsfl.models.CustomerAddressModel;
import com.app.apsfl.models.CustomerInfoModel;
import com.app.apsfl.models.EnterpriseCustomer;
import com.app.apsfl.models.IptvSIDataModel;
import com.app.apsfl.models.OfflineEditCafModel;
import com.app.apsfl.models.OfflineFormModel;
import com.app.apsfl.models.SICpeInfoModel;
import com.app.apsfl.models.SICustomerInfoModel;
import com.app.apsfl.models.SIOfflineFormModel;
import com.app.apsfl.utils.Constants;
import com.app.apsfl.utils.FormValidations;
import com.app.apsfl.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import io.realm.Realm;

public class SendOTPActivity extends AppCompatActivity
        implements ResponseHandler, UserActionInterface {

    String message;
    String lmoType;
    private EditText otpEditText;
    private Integer customerID;
    private RequestHandler requestHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_otp);
        initViews();
        sendOTP();
    }

    private void initViews() {
        requestHandler = new RequestHandler();
        otpEditText = (EditText) findViewById(R.id.otpEditText);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.activity_otp_title);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void sendOTP() {
        if (Utils.isNetworkAvailable(this)) {
            try {
                SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();
                Realm realm = Realm.getDefaultInstance();
                CustomerInfoModel infoModel = realm.where(CustomerInfoModel.class).equalTo("formTime", Constants.formTime).findFirst();
                CustomerAddressModel addressModel = realm.where(CustomerAddressModel.class).equalTo("formTime", Constants.formTime).findFirst();
                EnterpriseCustomer customer = realm.where(EnterpriseCustomer.class).equalTo("isCustomerChecked", true).findFirst();
                lmoType = sharedPreferences.getString(Constants.TENANT_TYPE, "");


                JSONObject requestBody = new JSONObject();
                switch (lmoType) {
                    case "LMO":
                        message = sharedPreferences.getString(Constants.LMO_NAME, "") + ",\n "
                                + Constants.cafNumber + ", "
                                + infoModel.getCustomerFirstName() + " " + infoModel.getCustomerLastName() + ", "
                                + addressModel.getAddress1() + " " + addressModel.getAddress2() + ", \n OTP:"
                                + getOTP() + ", \n"
                                + sharedPreferences.getString(Constants.LMO_MOBILE_NUMBER, "");
                        requestBody.put("mobileNo", customer.getCustomerMobileNumber());
                        Log.d("LMO SMS mobile number", customer.getCustomerMobileNumber());
                        break;
                    case "SI":
                        SICustomerInfoModel siCustomerInfoModel = realm.where(SICustomerInfoModel.class).equalTo("apsflTrackId", Constants.apsflTrackId).findFirst();

                        //  String apsflUniqueId = addressModel.getApsflUniqueId().equals("null") ? "" : addressModel.getApsflUniqueId() ;
                        message = sharedPreferences.getString(Constants.LMO_NAME, "") + ",\n "
                                + siCustomerInfoModel.getCafNo() + ", "
                                + siCustomerInfoModel.getNameOfContactPersonName() + ", "
                                + siCustomerInfoModel.getInstAddress() + ", \n OTP:"
                                + getOTP() + ", \n"
                                + sharedPreferences.getString(Constants.LMO_MOBILE_NUMBER, "") + ",\n APSFL Track Id:"
                                + Constants.apsflTrackId + ",\n ONT location:" + siCustomerInfoModel.getCpeDeviceLocation();
                        requestBody.put("mobileNo", siCustomerInfoModel.getNumberOfContactPerson());
                        Log.d("SILMO SMS mobile number", siCustomerInfoModel.getNumberOfContactPerson());
                        break;
                }
                requestBody.put("msg", message);
                Log.d("SMS JSON", "\t" + requestBody.toString(2));
                new RequestHandler().sendOTP(this, requestBody, Constants.SEND_OTP);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
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
                switch (lmoType) {

                    case "LMO":
                        super.onBackPressed();
                        break;
                    case "SI":
                        onBackPressed();
                        break;
                }

                return true;

            case R.id.feasibility_done:
                isOTPValid();
                return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        updateStatusMessage("OTP is invalid");
        Utils.showUserConfirmationDialog(this, null,
                "Form will be saved in Resubmit CAF's", Constants.SAVE_IN_PENDING);
    }

    private String getOTP() {
        String otp = "";
        Realm realm = Realm.getDefaultInstance();
        // EnterpriseCustomer customer = realm.where(EnterpriseCustomer.class).equalTo("isCustomerChecked", true).findFirst();
        //if (customer != null) {
        switch (lmoType) {
            case "LMO":
                OfflineFormModel formModel = realm.where(OfflineFormModel.class)
                        .equalTo("formTime", Constants.formTime)
                        .findFirst();//.equalTo("enterpriseCustomerCode", customer.getCustomerID())
                otp = formModel.getCafOTPNumber();
                break;
            case "SI":
                SIOfflineFormModel siformModel = realm.where(SIOfflineFormModel.class)
                        .equalTo("apsflTrackId", Constants.apsflTrackId)
                        .findFirst();//.equalTo("enterpriseCustomerCode", customer.getCustomerID())
                otp = siformModel.getCafOTPNumber();
                break;
        }

        //}
        return otp;
    }

    private void isOTPValid() {
        if (FormValidations.isFormEditTextValid(otpEditText, FormValidations.FORM_FIELDS.OTP)) {
            String otp = otpEditText.getText().toString();
            if (otp.equals(getOTP())) {
                if (lmoType.equals("LMO")) {
                    startActivity(new Intent(this, NewCAFActivity.class).putExtra("fromOTPScreen", true));
                } else {
                    makeCAFPaymentRequest(getCAFPaymentDataAsJSON());
                    // submitCAFForm(getCAFFormDataAsJSON());
                    ////////////////////////Todo
                    //new RequestHandler().submitCAFPayment(this, null, getCAFPaymentDataAsJSON(), Constants.SAVE_CAF_PAYMENT);
                }
            } else {
                Utils.showDialog(this, getString(R.string.invalid_otp_title),
                        getString(R.string.wrong_otp_message), null);
            }
        }
    }

    @Override
    public void responseHandler(Object response, int requestType) {
        switch (requestType) {
            case Constants.SEND_OTP:
                switch (lmoType) {
                    case "LMO":
                        if (response != null) {
                            Utils.showToast(this, "OTP has been sent successfully");
                        }
                        break;
                    case "SI":
                        if (response != null) {
                            try {
                                JSONObject requestBody = new JSONObject();
                                SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();
                                requestBody.put("mobileNo", sharedPreferences.getString(Constants.LMO_MOBILE_NUMBER, ""));
                                requestBody.put("msg", message);
                                new RequestHandler().sendOTP(this, requestBody, Constants.SEND_OTP2);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                }

                break;
            case Constants.SEND_OTP2:
                if (response != null) {
                    Utils.showToast(this, "OTP has been sent successfully");
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
                    JSONObject responseData = (JSONObject) response;

                    if(responseData.getString("statusCode").equals("200")){
                        customerID = Integer.valueOf(responseData.getString("statusMessage"));
                        saveCustomerID(customerID);
                        makeCAFPaymentRequest(getCAFPaymentDataAsJSON());
                    }
                    else{
                        Utils.cancelProgress();
                        Utils.showDialog(this, getString(R.string.request_failure_title),
                                responseData.getString("statusMessage"), Constants.SAVE_CAF_OFFLINE);

                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;

            case Constants.SAVE_CAF_PACKAGES:
                try {
                    if (response != null) {
                        makeCAFPaymentRequest(getCAFPaymentDataAsJSON());
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
                Realm realm = Realm.getDefaultInstance();
                if (response != null) {
                    if (response instanceof String) {
                        // Success Payment
                        deleteSubmittedData();
                        startActivity(new Intent(this, PaymentSuccessActivity.class)
                                .putExtra("message", response.toString()));
                    } else if (response instanceof Integer) {
                        // Feasibility Respoonse
                        deleteSubmittedData();
                        Utils.showDialog(this, "CAF submitted successfully",
                                "Feasibility Status has been Updated Successfully.", Constants.PAYMENT_SUCCESS);
                    } else if (response instanceof JSONObject) {
                        // Some error - payment failed
                        try {
                            JSONObject responseData = (JSONObject) response;
                            if (!responseData.getString("statusCode").equals("200")) {
                                updateStatusMessage(responseData.getString("statusMessage"));
                                Utils.showDialog(this, getString(R.string.payment_failure_title_si),
                                        responseData.getString("statusMessage"), Constants.PAYMENT_FAILURE);
                            } else {
                                deleteSubmittedData();
                                Utils.showDialog(this, getString(R.string.payment_success_title_si),
                                        responseData.getString("statusMessage"), Constants.PAYMENT_FAILURE);
                            }
                        } catch (JSONException ex) {
                            ex.printStackTrace();
                            Utils.showDialog(this, getString(R.string.payment_failure_title_si),
                                    getString(R.string.payment_failure_message_si), Constants.PAYMENT_FAILURE);
                        }
                    }
                } else {
                    updateStatusMessage("Your Order was unsuccessful. Please try again");
                    Utils.showDialog(this, getString(R.string.payment_failure_title_si),
                            getString(R.string.payment_failure_message_si), Constants.PAYMENT_FAILURE);
                }
                break;
        }
    }

    private JSONObject getCAFPaymentDataAsJSON() {
        JSONObject formJSON = null;
        Realm realm = Realm.getDefaultInstance();
        try {
            //  OfflineFormModel offlineFormModel = offlineFormList.get(currentFormPosition);
            SIOfflineFormModel offlineFormModel = realm.where(SIOfflineFormModel.class).equalTo("apsflTrackId", Constants.apsflTrackId).findFirst();
            formJSON = new JSONObject(offlineFormModel.getFormPaymentData());
            /*Log.d("Initial JSON", formJSON.toString(2));
            if (formJSON.getString("cafNo").equals("")) {
                formJSON.put("cafNo", Constants.cafNumber);
            }
            if (formJSON.getString("parentCafno").equals("")) {
                formJSON.put("parentCafno", Constants.cafNumber);
            }
            if (formJSON.getString("ipAddress").equals("0.0.0.0")) {
                formJSON.put("ipAddress", Utils.getIPAddress(this));
            }
            JSONObject customerCafVO = formJSON.getJSONObject("customerCafVO");
            if (customerCafVO.getString("cafNo").equals("")) {
                customerCafVO.put("cafNo", Constants.cafNumber);
            }
            if (customerCafVO.getString("ipAddress").equals("0.0.0.0")) {
                customerCafVO.put("ipAddress", Utils.getIPAddress(this));
            }
            formJSON.put("customerCafVO", customerCafVO);*/
            Log.d("Payment JSON", formJSON.toString());
        } catch (Exception ex) {
            Log.d("Exception in ->  ", "getCAFPaymentDataAsJSON()");
            ex.printStackTrace();
        }
        return formJSON;
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
            realm.commitTransaction();
            realm.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void makeCAFPaymentRequest(JSONObject requestData) {
        /// Utils.showDialog();////////////////////Todo
        Log.d("SMS ACTIVITY", requestData.toString());
        requestHandler.submitCAFPayment(this, null, requestData, Constants.SAVE_CAF_PAYMENT);
    }

    @Override
    public void onDialogConfirmed(int actionType) {
        switch (actionType) {

            case Constants.SAVE_IN_PENDING:
                Realm realm = Realm.getDefaultInstance();
                try {
                    realm.beginTransaction();
                    SIOfflineFormModel offlineFormModel = realm.where(SIOfflineFormModel.class)
                            .equalTo("apsflTrackId", Constants.apsflTrackId).findFirst();
                    offlineFormModel.setNetworkAvailble(false);//if sms is not reached
                    realm.copyToRealmOrUpdate(offlineFormModel);
                    realm.commitTransaction();
                    realm.close();
                } catch (Exception ex) {
                    realm.cancelTransaction();
                    realm.close();
                    ex.printStackTrace();
                    Log.d("Exception in  ->  ", "Sms failed");
                }
                startActivity(new Intent(this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));

                break;
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
    private void deleteSubmittedData() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.where(SIOfflineFormModel.class).equalTo("apsflTrackId", Constants.apsflTrackId).findAll().deleteAllFromRealm();
        realm.where(SICustomerInfoModel.class).equalTo("apsflTrackId", Constants.apsflTrackId).findAll().deleteAllFromRealm();
        realm.where(SICpeInfoModel.class).equalTo("apsflTrackId", Constants.apsflTrackId).findAll().deleteAllFromRealm();
        realm.where(IptvSIDataModel.class).equalTo("apsflTrackId", Constants.apsflTrackId).findAll().deleteAllFromRealm();
        realm.commitTransaction();
        Constants.apsflTrackId="";
        realm.close();
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
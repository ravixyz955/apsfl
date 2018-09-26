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
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.app.apsfl.R;
import com.app.apsfl.adapters.CustomSpinnerAdapter;
import com.app.apsfl.application.BaseApplication;
import com.app.apsfl.httpClient.RequestHandler;
import com.app.apsfl.interfaces.ResponseHandler;
import com.app.apsfl.interfaces.UserActionInterface;
import com.app.apsfl.models.PaymentModel;
import com.app.apsfl.utils.Constants;
import com.app.apsfl.utils.FormValidations;
import com.app.apsfl.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;

public class MakePaymentActivity extends AppCompatActivity
        implements ResponseHandler, UserActionInterface {

    private Toolbar mToolbar;
    private TextView formLMOName, formLMOWallet, formLMOCreditLimit, formLMORemainingLimit,
             paymentAadhaarNo, paymentCustomerName, totalPayableAmount;//paymentCAFNumber,
    private Spinner entryPaymentSpinner;
    private EditText paymentAmountToPay;
    private int amountPercentage;
    private PaymentModel paymentModel;
    private RequestHandler requestHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_payments);
        initViews();
        setupToolBar();
        setSpinnerData();
        getWalletBalance();
    }

    private void initViews() {
        requestHandler = new RequestHandler();
        paymentModel = getIntent().getParcelableExtra("paymentModel");
        mToolbar = (Toolbar) findViewById(R.id.toolBar);
        LinearLayout tenantBalanceLayout = (LinearLayout) findViewById(R.id.tenantBalanceLayout);
        if (tenantBalanceLayout != null) {
            formLMOName = (TextView) tenantBalanceLayout.findViewById(R.id.lmoName);
            formLMOWallet = (TextView) tenantBalanceLayout.findViewById(R.id.lmoWallet);
            formLMOCreditLimit = (TextView) tenantBalanceLayout.findViewById(R.id.lmoCreditLimit);
            formLMORemainingLimit = (TextView) tenantBalanceLayout.findViewById(R.id.lmoRemainingLimit);
        }
       // paymentCAFNumber = (TextView) findViewById(R.id.paymentCAFNumber);
        paymentAadhaarNo = (TextView) findViewById(R.id.paymentAadhaarNo);
        paymentCustomerName = (TextView) findViewById(R.id.paymentCustomerName);
        totalPayableAmount = (TextView) findViewById(R.id.totalPayableAmount);
        entryPaymentSpinner = (Spinner) findViewById(R.id.entryPaymentSpinner);
        paymentAmountToPay = (EditText) findViewById(R.id.paymentAmountToPay);
    }

    private void setupToolBar() {
        setSupportActionBar(mToolbar);
        ActionBar mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setSpinnerData() {
        String[] paymentOptions = getResources().getStringArray(R.array.cash_mode_spinner_items);
        CustomSpinnerAdapter spinnerAdapter = new CustomSpinnerAdapter(this, paymentOptions);
        entryPaymentSpinner.setAdapter(spinnerAdapter);
    }

    private void getWalletBalance() {
        if (Utils.isNetworkAvailable(this)) {
            Utils.showProgress(this, getString(R.string.processing_request));
            requestHandler.getWalletBalance(this, null, Constants.GET_WALLET_BALANCE);
        }
    }

    private void setData(PaymentModel paymentModel) {
       // paymentCAFNumber.setText(paymentModel.getPaymentCAFNumber());
        paymentAadhaarNo.setText(paymentModel.getPaymentAadhaarNumber());
        paymentCustomerName.setText(paymentModel.getPaymentCustomerName());
        totalPayableAmount.setText(paymentModel.getPaymentTotalCharges());
        Utils.cancelProgress();
    }

    private void validateFields() {
        if (FormValidations.isFormSpinnerItemSelected(entryPaymentSpinner, FormValidations.SPINNER.PAYMENT_MODE))
            if (FormValidations.isFormEditTextValid(paymentAmountToPay, FormValidations.FORM_FIELDS.PAYMENT_AMOUNT)) {
                if (amountPercentage < 70) {
                    makePaymentRequest();
                } else if (amountPercentage >= 70 && amountPercentage < 90) {
                    Utils.showDialog(this, getString(R.string.payment_credit_warning_title),
                            getString(R.string.payment_credit_reached_70), Constants.PAYMENT_GREATER_70);
                } else {
                    Utils.showDialog(this, getString(R.string.payment_credit_warning_title),
                            getString(R.string.payment_credit_reached_90), Constants.PAYMENT_GREATER_90);
                }
            }
    }

    private void makePaymentRequest() {
        try {
            Utils.showProgress(this, getString(R.string.submitting_caf_payment));
            SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();
            JSONObject requestData = new JSONObject();
            JSONObject customerCafVO = new JSONObject();
            requestData.put("cafNo",0);
            requestData.put("loginId", sharedPreferences.getString(Constants.LMO_NAME, ""));
            requestData.put("tenantCode", sharedPreferences.getString(Constants.LMO_CODE, ""));
            requestData.put("tenantType",sharedPreferences.getString(Constants.TENANT_TYPE,""));
            requestData.put("custId", paymentModel.getPaymentCustomerID());
            requestData.put("mobileNo", paymentModel.getPaymentMobileNo());
            requestData.put("aadharNumber", paymentModel.getPaymentAadhaarNumber());
            requestData.put("customerName", paymentCustomerName.getText().toString());
            requestData.put("totalCharge", totalPayableAmount.getText().toString());
            requestData.put("paymentMode", entryPaymentSpinner.getSelectedItemPosition() == 1 ? "CASH" : "");
            requestData.put("paidAmount", paymentAmountToPay.getText().toString());
            requestData.put("feasibility", "Y");
            requestData.put("payment", "Monthly");
            requestData.put("custType", paymentModel.getPaymentCustomerType());
            requestData.put("ipAddress", Utils.getIPAddress(this));
            requestData.put("district", paymentModel.getPaymentDistrictID());
            customerCafVO.put("version", Constants.version);
            requestData.put("customerCafVO",customerCafVO);
            Log.d("Payment JSON", "\t" + requestData.toString(2));
            requestHandler.submitMonthlyPayment(this, requestData, Constants.SAVE_CAF_PAYMENT);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.payment_entry_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                return true;

            case R.id.payment_submit:
                Utils.hideKeyboard(paymentAmountToPay);
                validateFields();
                return true;
        }
        return false;
    }

    @Override
    public void responseHandler(Object response, int requestType) {
        switch (requestType) {
            case Constants.GET_WALLET_BALANCE:
                SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();
                formLMOName.setText(String.format("%s", sharedPreferences.getString(Constants.LMO_NAME, "")));
                if (response != null) {
                    try {
                        JSONObject responseData = (JSONObject) response;
                        amountPercentage = responseData.getInt("pecentage");
                        String walletBalance = responseData.getString("walletAmount");
                        String creditAmount = responseData.getString("creditAmount");
                        String actualUserAmount = responseData.getString("actualUserAmount");
                        formLMOWallet.setText(String.format("%s", walletBalance));
                        formLMOCreditLimit.setText(String.format("%s", creditAmount));
                        formLMORemainingLimit.setText(String.format("%s", actualUserAmount));
                    } catch (Exception ex) {
                        Utils.cancelProgress();
                        ex.printStackTrace();
                    }
                    setData(paymentModel);
                }
                break;

            case Constants.SAVE_CAF_PAYMENT:
                Utils.cancelProgress();
                if (response != null) {
                    JSONObject responseData=(JSONObject) response;
                    try {
                        if(responseData.getString("statusCode").equals("200")){
                            Utils.showDialog(this, getString(R.string.payment_success_title),
                                    responseData.getString("statusMessage"), Constants.PAYMENT_SUCCESS);
                        }else{
                            Utils.showDialog(this, getString(R.string.payment_failure_title),
                                    responseData.getString("statusMessage"), Constants.PAYMENT_FAILURE);
                        }
                    } catch (JSONException e) {
                        Utils.showDialog(this, getString(R.string.payment_failure_title),
                                getString(R.string.payment_failure_message), Constants.PAYMENT_FAILURE);
                        e.printStackTrace();
                    }

                } else {
                    Utils.showDialog(this, getString(R.string.payment_failure_title),
                            getString(R.string.payment_failure_message), Constants.PAYMENT_FAILURE);
                }
                break;
        }
    }

    @Override
    public void onDialogConfirmed(int actionType) {
        switch (actionType) {

            case Constants.PAYMENT_GREATER_70:
                makePaymentRequest();
                break;

            case Constants.PAYMENT_GREATER_90:
                break;

            case Constants.PAYMENT_FAILURE:
            case Constants.PAYMENT_SUCCESS:
                startActivity(new Intent(this, SearchPaymentsActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                break;
        }
    }
}
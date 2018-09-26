package com.app.apsfl.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.app.apsfl.R;
import com.app.apsfl.adapters.OfflineFormAdapter;
import com.app.apsfl.adapters.SIOfflineFormAdapter;
import com.app.apsfl.application.BaseApplication;
import com.app.apsfl.httpClient.RequestHandler;
import com.app.apsfl.interfaces.ListSelectionInterface;
import com.app.apsfl.interfaces.ResponseHandler;
import com.app.apsfl.interfaces.UserActionInterface;
import com.app.apsfl.models.EnterpriseCustomer;
import com.app.apsfl.models.OfflineFormModel;
import com.app.apsfl.models.SICustomerInfoModel;
import com.app.apsfl.models.SIOfflineFormModel;
import com.app.apsfl.utils.Constants;
import com.app.apsfl.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;
import io.realm.Sort;

public class SIPendingFormActivity extends AppCompatActivity
        implements ListSelectionInterface, ResponseHandler, UserActionInterface {

    private final String TAG = "OfflineFormActivity";
    SharedPreferences sharedPreferences;
    private Toolbar mToolBar;
    private RecyclerView offlineFormRecyclerView;
    private SIOfflineFormAdapter formAdapter;
    private RealmList<SIOfflineFormModel> offlineFormList;
    private TextView noFormsTextView;
    private int currentFormPosition = 0;
    private String lmoType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline_form);
        initViews();
        setupToolBar();
        setupRecyclerView();
        loadOfflineFormData();
    }

    private void initViews() {
        mToolBar = (Toolbar) findViewById(R.id.toolBar);
        offlineFormRecyclerView = (RecyclerView) findViewById(R.id.offlineFormRecyclerView);
        noFormsTextView = (TextView) findViewById(R.id.noFormsTextView);
        offlineFormList = new RealmList<>();
        sharedPreferences = BaseApplication.getSharedPreferences();
        lmoType = sharedPreferences.getString(Constants.TENANT_TYPE, "");
    }

    private void setupToolBar() {
        setSupportActionBar(mToolBar);
        ActionBar mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setupRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        offlineFormRecyclerView.setLayoutManager(manager);
        formAdapter = new SIOfflineFormAdapter(this, offlineFormList);
        formAdapter.setHasStableIds(true);
        offlineFormRecyclerView.setAdapter(formAdapter);
        offlineFormRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }
    //isNetworkAvailble
    private void loadOfflineFormData() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Log.d("offline pending forms",realm.where(SIOfflineFormModel.class).findAll().toString());
        offlineFormList.clear();
        offlineFormList.addAll(realm.where(SIOfflineFormModel.class)
                .beginGroup()
                .equalTo("isFormUploaded", false).equalTo("isNetworkAvailble",false)
                .endGroup()
                .findAllSorted("apsflTrackId", Sort.DESCENDING));
        realm.commitTransaction();
        formAdapter.notifyDataSetChanged();
        if (offlineFormList.isEmpty()) {
            offlineFormRecyclerView.setVisibility(View.GONE);
            noFormsTextView.setVisibility(View.VISIBLE);
        } else {
            offlineFormRecyclerView.setVisibility(View.VISIBLE);
            noFormsTextView.setVisibility(View.GONE);
        }
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
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "\t" + "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "\t" + "onPause()");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onItemClicked(int viewType, int position) {
        switch (viewType) {
            case Constants.PENDING_CAF_SUBMIT:
                currentFormPosition = position;
                Constants.apsflTrackId=offlineFormList.get(position).getApsflTrackId();
                if (Utils.isNetworkAvailable(this)) {
                    Realm realm = Realm.getDefaultInstance();
                    try {
                        SIOfflineFormModel offlineFormModel = realm.where(SIOfflineFormModel.class)
                                .equalTo("apsflTrackId", Constants.apsflTrackId).findFirst();
                        realm.beginTransaction();
                        //  if (Constants.cafType == 2) {
                        int otp = (int) (Math.random() * 9000) + 1000;
                        Log.d("OTP", "\t" + otp);
                        offlineFormModel.setCafOTPNumber(String.valueOf(otp));
                        //  }
                        offlineFormModel.setNetworkAvailble(true);
                        realm.copyToRealmOrUpdate(offlineFormModel);
                        realm.commitTransaction();
                        realm.close();
                    } catch (Exception ex) {
                        realm.close();
                        ex.printStackTrace();
                        Log.d("Exception in  ->  ", "savePaymentFormData");
                    }
                    startActivity(new Intent(this, SendOTPActivity.class));
                }else{
                    Utils.showDialog(this,
                            "Unable to Send OTP",
                            "Please try submitting CAF when internet is available.", null);
                }
                break;


            case Constants.PENDING_CAF_EDIT:
                // if (!offlineFormList.get(position).getFormCAFData().equals("")) {
                processCAFEdit(position);
                //  } else {
                   /* Constants.isFromCAFResults = true;
                    startActivity(new Intent(this, NewCAFActivity.class));*/
                //  Utils.showDialog(this, "No CAF Data Found", "No CAF data found for the selected entry", null);
                //  }
                break;
        }
    }


    private void processCAFEdit(int formPosition) {

        /*
        * Start edit for previously saved caf form based on formTime
        * Set the boolean isCAFInEditMode = true
        * Set Constants.formTime = selected offline form's time,
         * since we are going to get all the saved form data using this time
        * */
        //try {
        Constants.apsflTrackId=offlineFormList.get(formPosition).getApsflTrackId();

           /* if (!lmoType.equals("SI") && Constants.cafType == 2) {
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();

                RealmResults<EnterpriseCustomer> customerList = realm.where(EnterpriseCustomer.class).findAll();

                for (EnterpriseCustomer customer : customerList) {
                    if (customer.isCustomerChecked()) {
                        customer.setCustomerChecked(false);
                        break;
                    }
                }
                EnterpriseCustomer enterpriseCustomer = realm.where(EnterpriseCustomer.class)
                        .equalTo("customerID", formData.getString("entCustomerCode")).findFirst();

                if (enterpriseCustomer != null) {
                    enterpriseCustomer.setCustomerChecked(true);
                }
                realm.copyToRealmOrUpdate(enterpriseCustomer);
                realm.commitTransaction();
            }*/
        Log.d(TAG, "Selected Form Time" + "\t" + Constants.formTime);
        startActivity(new Intent(this, SICustomerInfoModel.class));
       /* } catch (Exception ex) {
            ex.printStackTrace();
        }*/
    }

  /*  private void processCAFSubmission(int formPosition) {
        try {
            JSONObject cafData = new JSONObject(offlineFormList.get(formPosition).getFormCAFData());
            if (Utils.isNetworkAvailable(this)) {
                Utils.showProgress(this, getString(R.string.submitting_caf_payment));
                try {
                    if (cafData.getString("cafNo").equals("")) {
                        new RequestHandler().getCAFNumber(this, Constants.GET_CAF_NUMBER);
                    } else {
                        if (cafData.getString("ipAddress").equals("0.0.0.0")) {
                            cafData.put("ipAddress", Utils.getIPAddress(this));
                        }
                        Log.d("CAF JSON", "\t" + cafData.toString(2));
                        new RequestHandler().submitCAFForm(this, null, cafData, Constants.SAVE_CAF_FORM);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Utils.showNoNetworkDialog(this);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }*/

   /* private JSONObject getCAFFormDataAsJSON() {
        JSONObject formJSON = null;
        try {
            OfflineFormModel offlineFormModel = offlineFormList.get(currentFormPosition);
            formJSON = new JSONObject(offlineFormModel.getFormCAFData());
            if (formJSON.getString("cafNo").equals("")) {
                formJSON.put("cafNo", Constants.cafNumber);
            }
            if (formJSON.getString("ipAddress").equals("0.0.0.0")) {
                formJSON.put("ipAddress", Utils.getIPAddress(this));
            }
            Log.d("CAF JSON", formJSON.toString(2));
        } catch (Exception ex) {
            Log.d("Exception in ->  ", "getCAFFormDataAsJSON()");
            ex.printStackTrace();
        }
        return formJSON;
    }*/

    /*private JSONObject getCAFPaymentDataAsJSON() {
        JSONObject formJSON = null;
        try {
            OfflineFormModel offlineFormModel = offlineFormList.get(currentFormPosition);
            formJSON = new JSONObject(offlineFormModel.getFormPaymentData());
            Log.d("Initial JSON", formJSON.toString(2));
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
            formJSON.put("customerCafVO", customerCafVO);
            Log.d("Payment JSON", formJSON.toString());
        } catch (Exception ex) {
            Log.d("Exception in ->  ", "getCAFPaymentDataAsJSON()");
            ex.printStackTrace();
        }
        return formJSON;
    }
*/
    /*private void saveCustomerID(Integer customerID) {
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();
            OfflineFormModel model = offlineFormList.get(currentFormPosition);
            JSONObject packages = new JSONObject(model.getFormPaymentData()).put("custId", customerID);
            packages.put("customerCafVO", packages.getJSONObject("customerCafVO").put("custId", customerID));
            model.setFormPaymentData(packages.toString());
            realm.copyToRealmOrUpdate(model);
            realm.commitTransaction();
            realm.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d("Exception in ->", "saveCustomerID()");
            realm.cancelTransaction();
            realm.close();
        }
    }*/

    @Override
    public void responseHandler(Object response, int requestType) {
        switch (requestType) {

           /* case Constants.GET_CAF_NUMBER:
                if (response != null) {
                    new RequestHandler().submitCAFForm(this, null, getCAFFormDataAsJSON(), Constants.SAVE_CAF_FORM);
                } else {
                    Utils.cancelProgress();
                    Utils.showDialog(this, getString(R.string.request_failure_title),
                            getString(R.string.request_failure_message), null);
                }
                break;

            case Constants.SAVE_CAF_FORM:
                try {
                    JSONObject responseData = (JSONObject) response;
                    if (responseData.has("customerID")) {
                        Integer customerID = Integer.valueOf(responseData.getString("customerID"));
                        saveCustomerID(customerID);
                        new RequestHandler().submitCAFPayment(this, null, getCAFPaymentDataAsJSON(), Constants.SAVE_CAF_PAYMENT);
                    } else {
                        Utils.cancelProgress();
                        Utils.showDialog(this, getString(R.string.request_failure_title),
                                getString(R.string.request_failure_message), null);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
*/
            case Constants.SAVE_CAF_PAYMENT:
                Utils.cancelProgress();
                Realm realm = Realm.getDefaultInstance();
                if (response != null) {
                    if (response instanceof String) {
                        // Success Payment
                        realm.beginTransaction();
                        offlineFormList.get(currentFormPosition).deleteFromRealm();
                        realm.commitTransaction();
                        startActivity(new Intent(this, PaymentSuccessActivity.class)
                                .putExtra("message", response.toString()));
                    } else if (response instanceof Integer) {
                        // Feasibility Respoonse
                        realm.beginTransaction();
                        offlineFormList.get(currentFormPosition).deleteFromRealm();
                        realm.commitTransaction();
                        Utils.showDialog(this, "CAF submitted successfully",
                                "Feasibility Status has been Updated Successfully.", Constants.PAYMENT_SUCCESS);
                    } else if (response instanceof JSONObject) {
                        // Some error - payment failed
                        try {
                            JSONObject responseData = (JSONObject) response;
                            if (!responseData.getString("statusCode").equals("200")) {
                                if (Constants.isFromCAFResults) {
                                }
                                Utils.showDialog(this, getString(R.string.payment_failure_title_si),
                                        responseData.getString("statusMessage"), Constants.PAYMENT_FAILURE);
                            } else {
                                realm.beginTransaction();
                                offlineFormList.get(currentFormPosition).deleteFromRealm();
                                realm.commitTransaction();
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
                    Utils.showDialog(this, getString(R.string.payment_failure_title_si),
                            getString(R.string.payment_failure_message_si), Constants.PAYMENT_FAILURE);
                }
                break;
        }
    }

    @Override
    public void onDialogConfirmed(int actionType) {
        switch (actionType) {
            case Constants.PAYMENT_SUCCESS:
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                offlineFormList.get(currentFormPosition).deleteFromRealm();
                realm.commitTransaction();
                loadOfflineFormData();
                break;
        }
    }
}
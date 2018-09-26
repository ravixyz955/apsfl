package com.app.apsfl.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;

import com.app.apsfl.R;
import com.app.apsfl.application.BaseApplication;
import com.app.apsfl.httpClient.RequestHandler;
import com.app.apsfl.interfaces.ResponseHandler;
import com.app.apsfl.utils.Constants;
import com.app.apsfl.utils.FormValidations;
import com.app.apsfl.utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import io.realm.Realm;

public class LoginActivity extends AppCompatActivity
        implements View.OnClickListener, View.OnTouchListener, ResponseHandler {

    private static final String TAG = LoginActivity.class.getSimpleName();

    private ScrollView loginParentLayout;
    private EditText loginUserName, loginUserPassword, ipaddress;
    private Button loginButton, forgotPassword;
    private RequestHandler requestHandler;
    public static String ip_address = null;
    public static String LMO_CODE_SAVE = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        registerListeners();
    }

    private void initViews() {
        loginParentLayout = (ScrollView) findViewById(R.id.loginParentLayout);
        loginUserName = (EditText) findViewById(R.id.loginUsername);
        loginUserPassword = (EditText) findViewById(R.id.loginUserPassword);
        loginButton = (Button) findViewById(R.id.loginButton);
        forgotPassword = (Button) findViewById(R.id.forgotPasswordButton);
        //ipaddress=(EditText)findViewById(R.id.ipAddress);
        requestHandler = new RequestHandler();
        //loginUserName.setText("LMO5967");
        // loginUserPassword.setText("667878");
    }

    private void registerListeners() {
        loginUserName.setOnTouchListener(this);
        loginUserPassword.setOnTouchListener(this);
        loginButton.setOnClickListener(this);
        forgotPassword.setOnClickListener(this);


    }

    private void scrollLayout() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loginParentLayout.smoothScrollTo(0, loginButton.getBottom());
            }
        }, 400);
    }

    private void checkIfNewUserLogin(String userName, String userPassword) {
        SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();
        String name = sharedPreferences.getString(Constants.USER_NAME, "");
        if (!name.equals(userName)) {
            Log.d(TAG + "->  ", "New User Login Detected");
            Log.d(TAG + "->  ", "Removing Old User Data");
            Realm realm = Realm.getDefaultInstance();
            sharedPreferences.edit().clear().apply();
            realm.beginTransaction();
            realm.deleteAll();
            realm.commitTransaction();
            realm.close();
        }
        makeLoginRequest(userName, userPassword);
    }

    private void makeLoginRequest(final String userName,
                                  final String userPassword) {
        Utils.showProgress(this, getString(R.string.logging_in));
        requestHandler.userLogin(this, userName, userPassword, Constants.LOGIN_REQUEST);
    }

    private void processOfflineLogin(final String userName,
                                     final String userPassword) {
        SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();
        if (sharedPreferences.contains(Constants.USER_NAME)
                && sharedPreferences.contains(Constants.USER_PASSWORD)) {
            String name = sharedPreferences.getString(Constants.USER_NAME, "");
            String password = sharedPreferences.getString(Constants.USER_PASSWORD, "");
            if (name.equals(userName) && password.equals(userPassword)) {
                startActivity(new Intent(this, MainActivity.class));
            } else {
                Utils.showDialog(this, getString(R.string.login_failed_title),
                        getString(R.string.login_wrong_credentials_message), null);
            }
        } else {
            Utils.showNoNetworkDialog(this);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.loginButton:
                Utils.hideKeyboard(view);
                if (FormValidations.isFormEditTextValid(loginUserName, FormValidations.FORM_FIELDS.LOGIN_USER)) {
                    if (FormValidations.isFormEditTextValid(loginUserPassword, FormValidations.FORM_FIELDS.LOGIN_PWD)) {
                        String userName = loginUserName.getText().toString();
                        String userPassword = loginUserPassword.getText().toString();
                        // ip_address=ipaddress.getText().toString();
                        if (Utils.isNetworkAvailable(this)) {
                            checkIfNewUserLogin(userName, userPassword);
                            LMO_CODE_SAVE = userName;
                        } else {
                            processOfflineLogin(userName, userPassword);
                            LMO_CODE_SAVE = userName;
                        }
                    }
                }
                break;
            case R.id.forgotPasswordButton:

                startActivity(new Intent(this, ForgotPasswordActivity.class));
                break;
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        switch (view.getId()) {
            case R.id.loginUsername:
                scrollLayout();
                break;

            case R.id.loginUserPassword:
                scrollLayout();
                break;
        }
        return false;
    }

    private void saveUserData(String lmoName,
                              String lmoCode,
                              String lmoMobileNumber,
                              String subStationCodes, String regionListData, String lmoType) {

        String userName = loginUserName.getText().toString();
        String userPassword = loginUserPassword.getText().toString();
        SharedPreferences.Editor editor = BaseApplication.getSharedPreferences().edit();
        editor.putString(Constants.USER_NAME, userName);
        editor.putString(Constants.USER_PASSWORD, userPassword);
        editor.putString(Constants.LMO_NAME, lmoName);
        editor.putString(Constants.LMO_CODE, lmoCode);
        editor.putString(Constants.LMO_MOBILE_NUMBER, lmoMobileNumber);
        editor.putString(Constants.SUB_STATION_CODES, subStationCodes);
        editor.putString(Constants.LMO_REGIONS_LIST, regionListData);
        editor.putString(Constants.TENANT_TYPE, lmoType);
        editor.apply();
        Log.d(TAG, "\t" + "Saved current user to preferences");
        getMasterData();
    }

    private void getMasterData() {
        Utils.changeProgressMessage(getString(R.string.progress_login_success_title),
                getString(R.string.progress_getting_data_message));
        SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();
        String lmoType = sharedPreferences.getString(Constants.TENANT_TYPE, "");
        switch (lmoType) {
            case "LMO":
                requestHandler.getMasterData(this, Constants.GET_MASTER_DATA);
                break;
            case "SI":
                requestHandler.getSILMOMasterData(this, Constants.GET_MASTER_DATA);
                break;
        }

    }

    @Override
    public void responseHandler(Object response, int requestType) {
        switch (requestType) {
            case Constants.LOGIN_REQUEST:
                if (response != null) {
                    try {
                        JSONObject data = (JSONObject) response;
                        if (data.getString("statusCode").equals("200")) {
                            String lmoName = data.getString("lmoName");
                            String lmoCode = data.getString("lmoCode");
                            String lmoMobileNumber = data.getString("mobileNo");
                            String subStationCodes = data.getString("subStationCodes").replace(" ", "");
                            String lmoType = data.getString("tenantType");//Todo
                            JSONArray regionListArray = data.optJSONArray("regionList");
                            String regionListData = "";
                            for (int i = 0; i < regionListArray.length(); i++) {
                                if (i == 0) {
                                    regionListData = regionListArray.getString(i);
                                } else {
                                    regionListData = regionListData + "," + regionListArray.getString(i);
                                }
                            }
                            saveUserData(lmoName, lmoCode, lmoMobileNumber, subStationCodes, regionListData, lmoType);

                        } else {
                            Utils.cancelProgress();
                            /*String message=data.getString("message");
                            if(message.contains("update")){
                                Utils.showDialog(this, "Update Mobile App",
                                        data.getString("message"), null);
                            }else{*/
                            Utils.showDialog(this, getString(R.string.login_failed_title),
                                    data.getString("message"), null);
                            // }

                        }
                    } catch (JSONException ex) {
                        Utils.cancelProgress();
                        ex.printStackTrace();
                    }
                } else {
                    Utils.cancelProgress();
                    Utils.showDialog(this, getString(R.string.login_failed_title),
                            getString(R.string.login_failed_message), null);
                }
                break;

            case Constants.GET_MASTER_DATA:
                Utils.cancelProgress();
                if (response != null) {
                    startActivity(new Intent(this, MainActivity.class));
                } else {
                    Utils.showDialog(this, getString(R.string.request_failure_title),
                            getString(R.string.request_failure_message), null);
                }
                break;
        }
    }
}
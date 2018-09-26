package com.app.apsfl.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.app.apsfl.R;
import com.app.apsfl.application.BaseApplication;
import com.app.apsfl.httpClient.RequestHandler;
import com.app.apsfl.interfaces.ResponseHandler;
import com.app.apsfl.interfaces.UserActionInterface;
import com.app.apsfl.utils.Constants;
import com.app.apsfl.utils.FormValidations;
import com.app.apsfl.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;

//Reset pwd
public class ChangePassword extends AppCompatActivity implements View.OnClickListener, ResponseHandler, UserActionInterface {

    public static final String TAG = ChangePassword.class.getName();
    EditText newPassword, confirmPwd, oldPassword;
    Button newPasswordSubmit;
    RequestHandler requestHandler;
    SharedPreferences sharedPreferences;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        initViews();
        setupToolBar();
    }

    private void initViews() {
        oldPassword = (EditText) findViewById(R.id.old_password);
        newPassword = (EditText) findViewById(R.id.new_password);
        confirmPwd = (EditText) findViewById(R.id.confirm_pwd);
        newPasswordSubmit = (Button) findViewById(R.id.new_password_submit);
        requestHandler = new RequestHandler();
        sharedPreferences = BaseApplication.getSharedPreferences();
        mToolbar = (Toolbar) findViewById(R.id.toolBar);
        newPasswordSubmit.setOnClickListener(this);

    }

    private void setupToolBar() {

        setSupportActionBar(mToolbar);
        ActionBar mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
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
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.new_password_submit:
                if (sharedPreferences.getString(Constants.USER_PASSWORD, "").equals(oldPassword.getText().toString())) {
                    if (FormValidations.isFormEditTextValid(newPassword, FormValidations.FORM_FIELDS.CHANGE_PWD)) {

                        if (FormValidations.isFormEditTextValid(confirmPwd, FormValidations.FORM_FIELDS.CHANGE_PWD)) {

                            if (newPassword.getText().toString().trim().equals(confirmPwd.getText().toString().trim())) {
                                Utils.showProgress(this, "requesting...");
                                String loginId = sharedPreferences.getString(Constants.USER_NAME, "");
                                String userNewPassword = newPassword.getText().toString();

                                JSONObject requestObj = new JSONObject();
                                try {
                                    requestObj.put("loginID", loginId);
                                    requestObj.put("newPwd", userNewPassword);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                                requestHandler.changePassword(this, requestObj, Constants.CHANGE_PASSWORD);
                            } else {
                                Utils.showDialog(this,
                                        "Reset Password",
                                        "New Password and confirm Password are not Matched", null);//"Old and New passwords are not matched"
                            }
                        }
                    }
                }
                else{
                    Utils.showDialog(this,
                            "Reset Password",
                            "Invalid old password", null);
                }
                break;
        }


    }

    @Override
    public void responseHandler(Object response, int requestType) {

        switch (requestType) {

            case Constants.CHANGE_PASSWORD:

                Utils.cancelProgress();
                if (response != null) {
                    Utils.showDialog(this, "Reset Password", "Password Changed Successfully", Constants.CHANGE_PWD_SUCCESS);

                } else {
                    Utils.showDialog(this, "Reset Password", "Request Failed Please try again..", null);
                }
                break;


        }


    }

    private void startLoginScreen() {
        startActivity(new Intent(this, LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
    }

    private boolean isOldPwdValid() {

        boolean isValid = false;
        if (sharedPreferences.getString(Constants.USER_PASSWORD, "").equals(oldPassword.getText().toString())) {

        }
        return isValid;
    }

    @Override
    public void onDialogConfirmed(int actionType) {

        switch (actionType) {

            case Constants.CHANGE_PWD_SUCCESS:

                startLoginScreen();
                break;

        }
    }
}

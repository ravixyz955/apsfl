package com.app.apsfl.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.app.apsfl.R;
import com.app.apsfl.httpClient.RequestHandler;
import com.app.apsfl.interfaces.ResponseHandler;
import com.app.apsfl.interfaces.UserActionInterface;
import com.app.apsfl.utils.Constants;
import com.app.apsfl.utils.FormValidations;
import com.app.apsfl.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;

public class ForgotPasswordActivity extends AppCompatActivity implements View.OnClickListener, ResponseHandler, UserActionInterface {

    public static final String TAG = ForgotPasswordActivity.class.getName();
    EditText lmoUserName;
    Button forgetPasswordSubmit;
    RequestHandler requestHandler;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        initViews();
        setupToolBar();
    }

    private void initViews() {

        lmoUserName = (EditText) findViewById(R.id.lmoUserName);
        forgetPasswordSubmit = (Button) findViewById(R.id.forget_password_submit);
        requestHandler = new RequestHandler();
        mToolbar = (Toolbar) findViewById(R.id.toolBar);
        forgetPasswordSubmit.setOnClickListener(this);

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

            case R.id.forget_password_submit:

                if (FormValidations.isFormEditTextValid(lmoUserName, FormValidations.FORM_FIELDS.LOGIN_USER)) {

                    Utils.showProgress(this, "requesting...");
                    String username = lmoUserName.getText().toString();
                    requestHandler.forgotPassword(this, username, Constants.FORGOT_PASSWORD_REQUEST);
                }
                break;
        }


    }

    @Override
    public void responseHandler(Object response, int requestType) {

        switch (requestType) {

            case Constants.FORGOT_PASSWORD_REQUEST:
                Utils.cancelProgress();

                if (response != null) {

                    try {
                        JSONObject data = (JSONObject) response;
                        String message = data.getString("message");


                        if (message.equals("success")) {

                            Utils.showDialog(this, "Forgot Password", "Success... Password is send to your mail id.", Constants.FORGOT_PASSWORD_DIALOG);

                        } else if (message.equals("failure")) {
                            Utils.showDialog(this, "Forgot Password", "Failed to Sent Password to Email ID", null);

                        } else {

                            Utils.showDialog(this, "Forgot Password", "Request Failed.Please try again later", null);
                        }

                    } catch (JSONException e) {
                        Utils.showDialog(this, "Failed", "Please try again later", null);
                        e.printStackTrace();
                    }
                } else {
                    Utils.showDialog(this, "Failed", "Please try again later", null);

                }
                break;
        }


    }

    @Override
    public void onDialogConfirmed(int actionType) {
        switch (actionType) {

            case Constants.FORGOT_PASSWORD_DIALOG:

                startActivity(new Intent(ForgotPasswordActivity.this, LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));

                break;
        }

    }
}

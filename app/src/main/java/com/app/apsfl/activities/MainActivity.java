package com.app.apsfl.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.apsfl.R;
import com.app.apsfl.application.BaseApplication;
import com.app.apsfl.httpClient.RequestHandler;
import com.app.apsfl.interfaces.ResponseHandler;
import com.app.apsfl.interfaces.UserActionInterface;
import com.app.apsfl.utils.Constants;
import com.app.apsfl.utils.Utils;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, ResponseHandler, UserActionInterface {

    private static final String TAG = MainActivity.class.getSimpleName();
    SharedPreferences sharedPreferences;
    private Toolbar mToolbar;
    private TextView individualCAFLayout;
    private TextView enterpriseCAFLayout;
    private TextView searchCAFLayout;
    private TextView makePaymentsLayout, bulkmonthlypayments;
    private TextView pendingFormsLayout, failedFormsLayout, offlineSavedForms;
    private TextView changePassword;
    private Typeface mTypeface;
    private String lmoType;
    public static String mLmoCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "\t" + "onCreate");
        setContentView(R.layout.activity_main);
        initViews();
        setupToolBar();
        registerListeners();
    }

    public void viewRevenueSharing(View v) {
        //startActivity(new Intent(this,RevenueSharingActivity.class));
        startActivity(new Intent(this, ViewRevenueSharing.class));
    }

    public void ponChangeRequest(View v) {
        startActivity(new Intent(this, PonChangeActivity.class));
    }

    private void setTypeFace() {
        mTypeface = Typeface.createFromAsset(getAssets(), "roboto/roboto-medium-webfont.ttf");
    }

    private void initViews() {
        mToolbar = (Toolbar) findViewById(R.id.toolBar);
        TextView txtLoginUsername = (TextView) findViewById(R.id.txtLoginUsername);
        individualCAFLayout = (TextView) findViewById(R.id.individualCAFLayout);
        enterpriseCAFLayout = (TextView) findViewById(R.id.enterpriseCAFLayout);
        searchCAFLayout = (TextView) findViewById(R.id.searchCAFLayout);
        makePaymentsLayout = (TextView) findViewById(R.id.makePaymentsLayout);
        bulkmonthlypayments = (TextView) findViewById(R.id.makeBulkPaymentsLayout);
        pendingFormsLayout = (TextView) findViewById(R.id.pendingFormsLayout);
        changePassword = (TextView) findViewById(R.id.action_change_password);
        failedFormsLayout = (TextView) findViewById(R.id.failedFormsLayout);
        offlineSavedForms = (TextView) findViewById(R.id.offlineSavedForms);
        setTypeFace();
        sharedPreferences = BaseApplication.getSharedPreferences();
        txtLoginUsername.setText(String.format("%s", sharedPreferences.getString(Constants.LMO_NAME, "")));
        mLmoCode = String.format("%s", sharedPreferences.getString(Constants.LMO_CODE, ""));
        txtLoginUsername.setTypeface(mTypeface);
        lmoType = sharedPreferences.getString(Constants.TENANT_TYPE, "");
        if (lmoType.equals("SI")) {
            pendingFormsLayout.setText("Resubmit CAFs");
            individualCAFLayout.setVisibility(View.GONE);
            enterpriseCAFLayout.setVisibility(View.GONE);
            makePaymentsLayout.setVisibility(View.GONE);
            failedFormsLayout.setVisibility(View.VISIBLE);
            // pendingFormsLayout.setVisibility(View.GONE);
            changePassword.setVisibility(View.GONE);
            LinearLayout.LayoutParams Params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200);
            Params.setMargins(10, 10, 10, 0);
            searchCAFLayout.setLayoutParams(Params);
            makePaymentsLayout.setLayoutParams(Params);
            bulkmonthlypayments.setLayoutParams(Params);
            pendingFormsLayout.setLayoutParams(Params);
            failedFormsLayout.setLayoutParams(Params);
            offlineSavedForms.setLayoutParams(Params);
        } else {
            offlineSavedForms.setVisibility(View.GONE);
        }
        individualCAFLayout.setTypeface(mTypeface);
        enterpriseCAFLayout.setTypeface(mTypeface);
        searchCAFLayout.setTypeface(mTypeface);
        makePaymentsLayout.setTypeface(mTypeface);
        bulkmonthlypayments.setTypeface(mTypeface);
        pendingFormsLayout.setTypeface(mTypeface);
        changePassword.setTypeface(mTypeface);
        failedFormsLayout.setTypeface(mTypeface);
        offlineSavedForms.setTypeface(mTypeface);
    }

    private void setupToolBar() {
        setSupportActionBar(mToolbar);
    }

    private void registerListeners() {
        individualCAFLayout.setOnClickListener(this);
        enterpriseCAFLayout.setOnClickListener(this);
        searchCAFLayout.setOnClickListener(this);
        makePaymentsLayout.setOnClickListener(this);
        bulkmonthlypayments.setOnClickListener(this);
        pendingFormsLayout.setOnClickListener(this);
        changePassword.setOnClickListener(this);
        failedFormsLayout.setOnClickListener(this);
        offlineSavedForms.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_menu, menu);
        if (lmoType.equals("SI")) {
            menu.findItem(R.id.action_main_sync).setVisible(false);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_main_sync:
                if (Utils.isNetworkAvailable(this)) {
                    Utils.showProgress(this, getString(R.string.progress_syncing_master_data));
                    new RequestHandler().getMasterData(this, Constants.GET_MASTER_DATA);
                } else {
                    Utils.showDialog(this, getString(R.string.no_internet_title)
                            , getString(R.string.no_internet_message), null);
                }
                return true;

            case R.id.action_main_logout:
                onBackPressed();
                return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        Utils.showUserConfirmationDialog(this, null,
                getString(R.string.user_logout_message), Constants.USER_LOGOUT);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.individualCAFLayout:
                Constants.cafType = 1;
                startActivity(new Intent(this, NewCAFActivity.class));
                break;

            case R.id.enterpriseCAFLayout:
                Constants.cafType = 2;
                startActivity(new Intent(this, EnterpriseCustomersActivity.class));
                break;
            case R.id.searchCAFLayout:
                if (Utils.isNetworkAvailable(this)) {
                    startActivity(new Intent(this, SearchCAFActivity.class));
                } else {
                    Utils.showNoNetworkDialog(this);
                }
                break;
            case R.id.makePaymentsLayout:
                if (Utils.isNetworkAvailable(this)) {
                    startActivity(new Intent(this, SearchPaymentsActivity.class));
                } else {
                    Utils.showNoNetworkDialog(this);
                }
                break;
            case R.id.makeBulkPaymentsLayout:
                if (Utils.isNetworkAvailable(this)) {
                    startActivity(new Intent(this, MonthlyBulkPaymentAxtivity.class));
                } else {
                    Utils.showNoNetworkDialog(this);
                }
                break;
            case R.id.pendingFormsLayout:
                if (lmoType.equals("LMO")) {
                    startActivity(new Intent(this, OfflineFormActivity.class));
                } else {
                    startActivity(new Intent(this, SIPendingFormActivity.class));
                }
                break;
            case R.id.action_change_password:
                startActivity(new Intent(this, ChangePassword.class));
                break;
            case R.id.failedFormsLayout:
                startActivity(new Intent(this, FailedForms.class));
                break;
            case R.id.offlineSavedForms:
                startActivity(new Intent(this, OfflineEditForms.class));
                break;
        }
    }

    @Override
    public void responseHandler(Object response, int requestType) {
        switch (requestType) {
            case Constants.GET_MASTER_DATA:
                Utils.cancelProgress();
                break;
        }
    }

    @Override
    public void onDialogConfirmed(int actionType) {
        switch (actionType) {
            case Constants.USER_LOGOUT:
                startActivity(new Intent(MainActivity.this, LoginActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                break;
        }
    }
}
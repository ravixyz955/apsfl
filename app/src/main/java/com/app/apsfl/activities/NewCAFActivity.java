package com.app.apsfl.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.app.apsfl.R;
import com.app.apsfl.application.BaseApplication;
import com.app.apsfl.fragments.BasePackageFragment;
import com.app.apsfl.fragments.CustomerCPEInfoFragment;
import com.app.apsfl.fragments.CustomerInfoFragment;
import com.app.apsfl.httpClient.RequestHandler;
import com.app.apsfl.interfaces.FragmentBackStackListener;
import com.app.apsfl.interfaces.ResponseHandler;
import com.app.apsfl.models.MandalModel;
import com.app.apsfl.models.OfflineFormModel;
import com.app.apsfl.models.POPModel;
import com.app.apsfl.models.ProductModel;
import com.app.apsfl.models.VillageModel;
import com.app.apsfl.utils.Constants;
import com.app.apsfl.utils.Utils;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class NewCAFActivity extends AppCompatActivity
        implements ResponseHandler {

    public static final String TAG = "NewCAFActivity";
    private Toolbar mToolbar;
    private RequestHandler requestHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate()");
        setContentView(R.layout.activity_new_caf);
        if (Constants.formTime == null) {
            resetLists();
            Constants.formTime = System.currentTimeMillis();
            Log.d(TAG, "New Time" + "\t" + Constants.formTime);

        } else {
            Realm realm = Realm.getDefaultInstance();
            OfflineFormModel offlineFormModel = realm.where(OfflineFormModel.class)
                    .equalTo("formTime", Constants.formTime).findFirst();
            if (offlineFormModel != null) {
                Constants.cafType = offlineFormModel.getCafType();

            }
        }
        initViews();
        setupToolBar();

        getCAFNumber();
    }

    private void initViews() {
        requestHandler = new RequestHandler();
        mToolbar = (Toolbar) findViewById(R.id.toolBar);
    }

    private void setupToolBar() {
        setSupportActionBar(mToolbar);
        ActionBar mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setDisplayHomeAsUpEnabled(true);
        }
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
            // if(Constants.isCAFInEditSILMO){
            for (ProductModel productModel : productResults) {
                if (productModel.isProductChecked()) {
                    productModel.setProductChecked(false);
                }
                // }
            }
            realm.commitTransaction();
            realm.close();
        } catch (Exception ex) {
            Log.d("Exception in -> ", "reset models ");
            realm.cancelTransaction();
            ex.printStackTrace();
        }
    }

    private void getCAFNumber() {
        if (Utils.isNetworkAvailable(this) && !Constants.isCAFInEditMode && Constants.cafNumber.equals("")) {
            Log.d(TAG, "getCAFNumber()");
            Utils.showProgress(this, getString(R.string.generating_caf_number));
            requestHandler.getCAFNumber(this, Constants.GET_CAF_NUMBER);
        } else {
            loadFragment();
        }
    }

    private void loadFragment() {
        Log.d(TAG, "loadFragment()");

        if (Constants.isFromCAFResults || (getIntent() != null && getIntent().hasExtra("fromOTPScreen"))) {

            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,
                    new BasePackageFragment()).commit();
        } else {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, new CustomerInfoFragment())
                    .commit();
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
    public void onBackPressed() {
        Fragment fragment = getVisibleFragment();
        if (fragment != null) {
            FragmentBackStackListener listener = (FragmentBackStackListener) fragment;
            listener.onBackPressed();
        }
    }

    private Fragment getVisibleFragment() {
        Fragment visibleFragment = null;
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (fragments != null) {
            for (Fragment fragment : fragments) {
                if (fragment != null && fragment.isVisible()) {
                    Log.d(fragment.getClass().getSimpleName() + "\t" + "isVisible",
                            "\t" + fragment.isVisible());
                    visibleFragment = fragment;
                    break;
                }
            }
        }
        return visibleFragment;
    }

    @Override
    public void responseHandler(Object response, int requestType) {
        switch (requestType) {
            case Constants.GET_CAF_NUMBER:
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Utils.cancelProgress();
                        loadFragment();
                    }
                }, 1000);
                break;
        }
    }
}
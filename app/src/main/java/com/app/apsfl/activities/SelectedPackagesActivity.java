package com.app.apsfl.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.app.apsfl.R;
import com.app.apsfl.adapters.SelectedPackagesAdapter;
import com.app.apsfl.application.BaseApplication;
import com.app.apsfl.models.OfflineFormModel;
import com.app.apsfl.models.ProductModel;
import com.app.apsfl.utils.Constants;

import org.json.JSONArray;
import org.json.JSONObject;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class SelectedPackagesActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private RecyclerView packagesRecyclerView;
    private SelectedPackagesAdapter mAdapter;
    private RealmList<ProductModel> packagesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_products_services);
        initViews();
        setupToolBar();
        setupRecyclerView();
        loadData();
    }

    private void initViews() {
        packagesList = new RealmList<>();
        mToolbar = (Toolbar) findViewById(R.id.toolBar);
        packagesRecyclerView = (RecyclerView) findViewById(R.id.selectedPackagesRecyclerView);
    }

    private void setupToolBar() {
        setSupportActionBar(mToolbar);
        ActionBar mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setupRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        packagesRecyclerView.setLayoutManager(manager);
        mAdapter = new SelectedPackagesAdapter(this, packagesList);
        packagesRecyclerView.setAdapter(mAdapter);
    }

    private void loadData() {
        Realm realm = Realm.getDefaultInstance();
        SharedPreferences sharedPreferences= BaseApplication.getSharedPreferences();
        String lmoType=sharedPreferences.getString(Constants.TENANT_TYPE,"");
        if (lmoType.equals("LMO") && Constants.formTime != null && Constants.isCAFInEditMode) {
            OfflineFormModel offlineFormModel = realm.where(OfflineFormModel.class).
                    equalTo("formTime", Constants.formTime).findFirst();
            if (offlineFormModel != null) {
                packagesList.clear();
                packagesList.addAll(getPackagesList(offlineFormModel.getFormPaymentData()));
            }
        } else {
            RealmResults<ProductModel> results = realm.where(ProductModel.class)
                    .equalTo("isProductChecked", true)
                    .findAll();
            packagesList.clear();
            packagesList.addAll(results);
        }
        mAdapter.updateData(packagesList);
    }

    private RealmList<ProductModel> getPackagesList(String data) {
        RealmList<ProductModel> packagesList = new RealmList<>();
        try {
            JSONObject paymentData = new JSONObject(data).getJSONObject("customerCafVO");
            JSONArray products = paymentData.getJSONArray("products");
            for (int i = 0; i < products.length(); i++) {
                JSONObject eachProduct = products.getJSONObject(i);
                ProductModel productModel = new ProductModel();
                productModel.setProductType(eachProduct.getString("prodType"));
                productModel.setProductName(eachProduct.getString("prodname"));
                JSONObject productData = new JSONObject();
                JSONArray services = eachProduct.getJSONArray("servicesList");
                productData.put("servicesList", services);
                productModel.setProductData(productData.toString());
                JSONArray productCharges = eachProduct.getJSONArray("chargeTypeList");
                for (int k = 0; k < productCharges.length(); k++) {
                    JSONObject eachCharge = productCharges.getJSONObject(k);
                    switch (eachCharge.getString("chargeType")) {
                        case "Recurring":
                            productModel.setProductRecurringCharge(eachCharge.getString("chargeAmt"));
                            productModel.setProductRecurringTax(eachCharge.getString("taxAmt"));
                            break;

                        case "Activation":
                            productModel.setProductActivationCharge(eachCharge.getString("chargeAmt"));
                            productModel.setProductActivationTax(eachCharge.getString("taxAmt"));
                            break;

                        case "Deposit":
                            productModel.setProductSecurityCharge(eachCharge.getString("chargeAmt"));
                            productModel.setProductSecurityTax(eachCharge.getString("taxAmt"));
                            break;
                    }
                }
                packagesList.add(productModel);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d("Exception in :", "getPackagesList()");
        }
        return packagesList;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                break;
        }
        return false;
    }
}
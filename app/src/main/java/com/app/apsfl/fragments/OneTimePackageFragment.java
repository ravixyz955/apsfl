package com.app.apsfl.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.app.apsfl.R;
import com.app.apsfl.activities.WorkOrderActivity;
import com.app.apsfl.adapters.ProductListAdapter;
import com.app.apsfl.application.BaseApplication;
import com.app.apsfl.httpClient.RequestHandler;
import com.app.apsfl.interfaces.FragmentBackStackListener;
import com.app.apsfl.interfaces.ListSelectionInterface;
import com.app.apsfl.interfaces.ResponseHandler;
import com.app.apsfl.models.OfflineFormModel;
import com.app.apsfl.models.ProductModel;
import com.app.apsfl.utils.Constants;
import com.app.apsfl.utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class OneTimePackageFragment extends Fragment
        implements TextWatcher, FragmentBackStackListener,
        ListSelectionInterface, ResponseHandler {

    private static final String TAG = "AddOnPackageFragment";
    private RecyclerView productRecyclerView;
    private ProductListAdapter productAdapter;
    private RealmList<ProductModel> productList;
    private EditText searchProductEditText;
    private TextView noProductsTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "\t" + "onCreateView");
        View layoutView = inflater.inflate(R.layout.fragment_select_package, container, false);
        initViews(layoutView);
        setupToolBar();
        registerListeners();
        setupRecyclerView();
        loadProducts();
        return layoutView;
    }

    private void initViews(View view) {
        searchProductEditText = (EditText) view.findViewById(R.id.searchProductEditText);
        productRecyclerView = (RecyclerView) view.findViewById(R.id.productRecyclerView);
        noProductsTextView = (TextView) view.findViewById(R.id.noProductsTextView);
        productList = new RealmList<>();
        setHasOptionsMenu(true);
    }

    private void setupToolBar() {
        ActionBar mActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setTitle(R.string.fragment_one_time_package_title);
        }
    }

    private void registerListeners() {
        searchProductEditText.addTextChangedListener(this);
    }

    private void setupRecyclerView() {
        productRecyclerView.setLayoutManager(
                new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        productAdapter = new ProductListAdapter(this, productList);
        productRecyclerView.setAdapter(productAdapter);
    }

    private void loadProducts() {
        Log.d(TAG, "loadProducts");
        Realm realm = Realm.getDefaultInstance();
        try {
            RealmResults<ProductModel> results;
            if (Constants.cafType == 1) {
                // Individual One-time Products
                results = realm.where(ProductModel.class)
                        .equalTo("isIndividualProduct", true)
                        .equalTo("productType", "O").findAll();
            } else {
                // Enterprise One-time Products
                results = realm.where(ProductModel.class)
                        .equalTo("isIndividualProduct", false)
                        .equalTo("productType", "O").findAll();
            }
            ProductModel productModel = realm.where(ProductModel.class).equalTo("productType", "B")
                    .equalTo("isProductChecked", true).findFirst();

            int baseServicelistSize=new JSONObject(productModel.getProductData()).getJSONArray("servicesList").length();

            for(int k=0;k<baseServicelistSize;k++){
                String baseServiceCode = new JSONObject(productModel.getProductData())
                        .getJSONArray("servicesList").getJSONObject(k).getString("serviceCode");
                Log.d("Add on results", "\t" + results.size());
                productList.clear();
                for (int i = 0; i < results.size(); i++) {
                    ProductModel resultModel = results.get(i);
                    int servicelistSize = new JSONObject(resultModel.getProductData())
                            .getJSONArray("servicesList").length();
                    for(int j=0;j<servicelistSize;j++){
                        String serviceCode = new JSONObject(resultModel.getProductData())
                                .getJSONArray("servicesList").getJSONObject(j).getString("serviceCode");
                        //To show pacakage not matched with serviceCode for selected base package
                        if (!serviceCode.equals(baseServiceCode)) {
                            productList.add(resultModel);
                        }
                    }
                }
            }
            productAdapter.updateData(productList);
            if (productList.isEmpty()) {
                productRecyclerView.setVisibility(View.GONE);
                searchProductEditText.setVisibility(View.GONE);
                noProductsTextView.setVisibility(View.VISIBLE);
            } else {
                productRecyclerView.setVisibility(View.VISIBLE);
                searchProductEditText.setVisibility(View.VISIBLE);
                noProductsTextView.setVisibility(View.GONE);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.product_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.product_done:
                if (isBasePackageVOIP()) {
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragmentContainer, new VOIPFragment())
                            .addToBackStack(VOIPFragment.class.getSimpleName())
                            .commit();
                } else {
                    saveSelectedPackages();
                   /* getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragmentContainer, new CustomerCPEInfoFragment())
                            .addToBackStack(CustomerCPEInfoFragment.class.getSimpleName())
                            .commit();*/
                }
                return true;
        }
        return false;
    }

    private boolean isBasePackageVOIP() {
        boolean isVOIP = false;
        Realm realm = Realm.getDefaultInstance();
        try {
            ProductModel productModel = realm.where(ProductModel.class).equalTo("productType", "B")
                    .equalTo("isProductChecked", true).findFirst();
            if (productModel != null) {
                JSONArray serviceList = new JSONObject(productModel.getProductData()).getJSONArray("servicesList");
                for (int i = 0; i < serviceList.length(); i++) {
                    JSONObject eachService = serviceList.getJSONObject(i);
                    if (eachService.getString("coreServiceCode").contains("VOIP")) {
                        if(eachService.getString("featureCodes").equals("0")){
                            isVOIP = false;
                        }else {
                            isVOIP = true;
                        }
                        break;
                    }
                }
            }
            realm.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            realm.close();
        }
        return isVOIP;
    }
//execute if no telephonic features
    private void saveSelectedPackages() {
        JSONObject packagesJSON;
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();

            OfflineFormModel offlineFormModel = realm.where(OfflineFormModel.class)
                    .equalTo("formTime", Constants.formTime).findFirst();
            JSONObject customerCAFVO;
            if (offlineFormModel == null) {
                offlineFormModel = new OfflineFormModel();
                offlineFormModel.setFormTime(Constants.formTime);
                offlineFormModel.setCafType(Constants.cafType);
                offlineFormModel.setFormCAFData("");
                offlineFormModel.setFormUploaded(false);
                offlineFormModel.setIsPaymentDataAvailable(false);
                offlineFormModel.setCpeSerialNoUsed(false);
                offlineFormModel.setCafStatus("0");
                packagesJSON = new JSONObject();
                customerCAFVO = new JSONObject();

            } else if (offlineFormModel.getFormPaymentData() == null || offlineFormModel.getFormPaymentData().isEmpty()) {
                packagesJSON = new JSONObject();
                customerCAFVO = new JSONObject();
            } else {
                packagesJSON = new JSONObject(offlineFormModel.getFormPaymentData());
                customerCAFVO = new JSONObject(packagesJSON.getJSONObject("customerCafVO").toString());
            }

          /*

            OfflineFormModel offlineFormModel = realm.where(OfflineFormModel.class)
                    .equalTo("formTime", Constants.formTime).findFirst();
            String paymentJSON =null;
            JSONObject customerCAFVO;
            if (offlineFormModel != null) {
                paymentJSON=offlineFormModel.getFormPaymentData();
            }
            if (paymentJSON == null || paymentJSON.isEmpty()) {
                packagesJSON = new JSONObject();
                customerCAFVO = new JSONObject();
            } else {
                packagesJSON = new JSONObject(offlineFormModel.getFormPaymentData());
                customerCAFVO = new JSONObject(packagesJSON.getJSONObject("customerCafVO").toString());
            }*/
            SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();
            customerCAFVO.put("loginId", sharedPreferences.getString(Constants.USER_NAME, ""));
            customerCAFVO.put("cafNo", Constants.cafNumber.equals("") ? "" : Long.parseLong(Constants.cafNumber));
            customerCAFVO.put("custId", Constants.customerID);
            customerCAFVO.put("ipAddress", Utils.getIPAddress(getActivity()));
            customerCAFVO.put("billCycle", Constants.billCycle);
            customerCAFVO.put("district", Constants.districtID);
            RealmResults<ProductModel> products = realm.where(ProductModel.class)
                    .equalTo("isProductChecked", true)
                    .findAll();
            JSONArray productsArray = new JSONArray();
            for (ProductModel productModel : products) {
                JSONObject productJSON = new JSONObject(productModel.getProductData());
                productsArray.put(productJSON);
            }
            String coreServiceCodes="";
            for (ProductModel productModel : products) {
                if(coreServiceCodes.equals("")){
                    coreServiceCodes=productModel.getCoreServiceCode();
                }else{

                    coreServiceCodes += "," +productModel.getCoreServiceCode();
                }
            }
            customerCAFVO.put("products", productsArray);
            customerCAFVO.put("flag", "NoCafFeatures");
//Todo
            customerCAFVO.put("status", "0");
            customerCAFVO.put("cafStatus", offlineFormModel.getCafStatus());
            customerCAFVO.put("coreSrvcCode", coreServiceCodes);
            //customerCAFVO.put("vpnService", "");
            packagesJSON.put("customerCafVO", customerCAFVO);
            Log.d("Packages JSON", packagesJSON.toString(2));

            offlineFormModel.setFormPaymentData(packagesJSON.toString());
            realm.copyToRealmOrUpdate(offlineFormModel);
            realm.commitTransaction();
            realm.close();
            //startWorkOrderScreen();
            startCustomerCPEInfoScreen();
        } catch (Exception ex) {
            ex.printStackTrace();
            realm.cancelTransaction();
            realm.close();
            Log.d("Exception -> ", "saveSelectedPackages()");
        }
    }

    private void resetAddOnPackages() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmResults<ProductModel> results = realm.where(ProductModel.class)
                .equalTo("productType", "O").findAll();
        for (int i = 0; i < results.size(); i++) {
            results.get(i).setProductChecked(false);
            results.get(i).setProductInfoShown(false);
        }
        realm.commitTransaction();
        realm.close();
    }

    @Override
    public void onBackPressed() {
        resetAddOnPackages();
        getActivity().getSupportFragmentManager().popBackStack();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        String searchQuery = searchProductEditText.getText().toString();
        if (searchQuery.trim().equals("")) {
            loadProducts();
        } else {
            filter(searchQuery);
        }
    }

    private void filter(String searchQuery) {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<ProductModel> results;
        if (Constants.cafType == 1) {
            results = realm.where(ProductModel.class)
                    .equalTo("isIndividualProduct", true)
                    .equalTo("productType", "O")
                    .beginGroup()
                    .contains("productName", searchQuery, Case.INSENSITIVE)
                    .endGroup()
                    .findAll();
        } else {
            results = realm.where(ProductModel.class)
                    .equalTo("isIndividualProduct", false)
                    .equalTo("productType", "O")
                    .beginGroup()
                    .contains("productName", searchQuery, Case.INSENSITIVE)
                    .endGroup()
                    .findAll();
        }
        Log.d(TAG, "Text Queried Results Size" + "\t" + results.size());
        ProductModel productModel = realm.where(ProductModel.class).equalTo("productType", "B")
                .equalTo("isProductChecked", true).findFirst();
        int baseServicelistSize= 0;
        try {
            baseServicelistSize = new JSONObject(productModel.getProductData()).getJSONArray("servicesList").length();

            for(int k=0;k<baseServicelistSize;k++){
                String baseServiceCode = new JSONObject(productModel.getProductData())
                        .getJSONArray("servicesList").getJSONObject(k).getString("serviceCode");
                Log.d("Add on results", "\t" + results.size());
                productList.clear();
                for (int i = 0; i < results.size(); i++) {
                    ProductModel resultModel = results.get(i);
                    int servicelistSize = new JSONObject(resultModel.getProductData())
                            .getJSONArray("servicesList").length();
                    for(int j=0;j<servicelistSize;j++){
                        String serviceCode = new JSONObject(resultModel.getProductData())
                                .getJSONArray("servicesList").getJSONObject(j).getString("serviceCode");
                        //To show pacakage not matched with serviceCode for selected base package
                        if (!serviceCode.equals(baseServiceCode)) {
                            productList.add(resultModel);
                        }
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "Text Filtered Results Size" + "\t" + productList.size());
        productAdapter.updateData(productList);
    }

    @Override
    public void onItemClicked(int viewType, int position) {
        Log.d("Clicked Position", "\t" + position);
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        switch (viewType) {
            case Constants.PRODUCT_CHECK:
                if (productList.get(position).isProductChecked()) {
                    productList.get(position).setProductChecked(false);
                } else {
                    productList.get(position).setProductChecked(true);
                }
                break;

            case Constants.PRODUCT_SHOW_MORE:
                if (productList.get(position).isProductInfoShown()) {
                    productList.get(position).setProductInfoShown(false);
                } else {
                    productList.get(position).setProductInfoShown(true);
                }
                break;
        }
        realm.commitTransaction();
        productAdapter.updateData(productList);
    }

    private void submitPackages(JSONObject requestData) {
        if (Utils.isNetworkAvailable(getActivity())) {
            Utils.showProgress(getActivity(), getString(R.string.processing_request));
            new RequestHandler().submitCAFPackages(getActivity(), this, requestData, Constants.SAVE_CAF_PACKAGES);
        } else {
            Utils.showNoNetworkDialog(getActivity());
        }
    }

    private void startWorkOrderScreen() {
        startActivity(new Intent(getActivity(), WorkOrderActivity.class));
    }
    private void startCustomerCPEInfoScreen() {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, new CustomerCPEInfoFragment())
                .addToBackStack(CustomerCPEInfoFragment.class.getSimpleName())
                .commit();
    }

    @Override
    public void responseHandler(Object response, int requestType) {
        switch (requestType) {
            case Constants.SAVE_CAF_PACKAGES:
                Utils.cancelProgress();
                if (response != null) {
                    startWorkOrderScreen();
                } else {
                    Utils.showToast(getActivity(), "Request Failed. Please try again.");
                }
                break;
        }
    }
}
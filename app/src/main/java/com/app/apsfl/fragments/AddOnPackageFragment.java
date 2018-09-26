package com.app.apsfl.fragments;

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
import com.app.apsfl.adapters.ProductListAdapter;
import com.app.apsfl.interfaces.FragmentBackStackListener;
import com.app.apsfl.interfaces.ListSelectionInterface;
import com.app.apsfl.models.ProductModel;
import com.app.apsfl.utils.Constants;

import org.json.JSONException;
import org.json.JSONObject;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class AddOnPackageFragment extends Fragment
        implements TextWatcher, FragmentBackStackListener, ListSelectionInterface {


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
            mActionBar.setTitle(R.string.fragment_add_on_package_title);
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
               /* String serviceCodes= realm.where(ProductModel.class).equalTo("isIndividualProduct", true)
                        .equalTo("productType", "B").equalTo("isProductChecked",true).findFirst().getCoreServiceCode();
                String[] serviceCodesArray=serviceCodes.split(",");//your string array
                RealmQuery<ProductModel> realmQuery  = realm.where(ProductModel.class)
                        .in("serviceCode",serviceCodesArray);
                results = realmQuery.equalTo("isIndividualProduct", true)
                        .equalTo("productType", "A").findAll();*/
                // Individual Add-On Products
             /*  String serviceCodes= realm.where(ProductModel.class).equalTo("isIndividualProduct", true)
                        .equalTo("productType", "B").equalTo("isProductChecked",true).findFirst().getCoreServiceCode();
                String[] serviceCodesArray=serviceCodes.split(",");
                .not().beginGroup().in("serviceCode",serviceCodesArray)*/

                results = realm.where(ProductModel.class).equalTo("isIndividualProduct", true)
                        .equalTo("productType", "A").findAll();
            } else {
                // Enterprise Add-On Products
                results = realm.where(ProductModel.class).equalTo("isIndividualProduct", false)
                        .equalTo("productType", "A").findAll();
            }
            ProductModel productModel = realm.where(ProductModel.class).equalTo("productType", "B")
                    .equalTo("isProductChecked", true).findFirst();
            int baseServicelistSize = new JSONObject(productModel.getProductData()).getJSONArray("servicesList").length();

            for (int k = 0; k < baseServicelistSize; k++) {
                String baseServiceCode = new JSONObject(productModel.getProductData())
                        .getJSONArray("servicesList").getJSONObject(k).getString("serviceCode");
                Log.d("Add on results", "\t" + results.size());
                productList.clear();
                for (int i = 0; i < results.size(); i++) {
                    ProductModel resultModel = results.get(i);
                    int servicelistSize = new JSONObject(resultModel.getProductData())
                            .getJSONArray("servicesList").length();
                    for (int j = 0; j < servicelistSize; j++) {
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
                startOneTimePackageFragment();
                return true;
        }
        return false;
    }

    private void startOneTimePackageFragment() {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, new OneTimePackageFragment())
                .addToBackStack(OneTimePackageFragment.class.getSimpleName())
                .commit();
    }

    private void resetAddOnPackages() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmResults<ProductModel> results = realm.where(ProductModel.class)
                .equalTo("productType", "A").findAll();
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
                    .equalTo("productType", "A")
                    .beginGroup()
                    .contains("productName", searchQuery, Case.INSENSITIVE)
                    .endGroup()
                    .findAll();
        } else {
            results = realm.where(ProductModel.class)
                    .equalTo("isIndividualProduct", false)
                    .equalTo("productType", "A")
                    .beginGroup()
                    .contains("productName", searchQuery, Case.INSENSITIVE)
                    .endGroup()
                    .findAll();
        }
        Log.d(TAG, "Text Queried Results Size" + "\t" + results.size());
        ProductModel productModel = realm.where(ProductModel.class).equalTo("productType", "B")
                .equalTo("isProductChecked", true).findFirst();
        int baseServicelistSize = 0;
        try {
            baseServicelistSize = new JSONObject(productModel.getProductData()).getJSONArray("servicesList").length();

            for (int k = 0; k < baseServicelistSize; k++) {
                String baseServiceCode = new JSONObject(productModel.getProductData())
                        .getJSONArray("servicesList").getJSONObject(k).getString("serviceCode");
                Log.d("Add on results", "\t" + results.size());
                productList.clear();
                for (int i = 0; i < results.size(); i++) {
                    ProductModel resultModel = results.get(i);
                    int servicelistSize = new JSONObject(resultModel.getProductData())
                            .getJSONArray("servicesList").length();
                    for (int j = 0; j < servicelistSize; j++) {
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
}
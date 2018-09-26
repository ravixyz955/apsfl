package com.app.apsfl.fragments;

import android.content.Intent;
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
import com.app.apsfl.activities.MainActivity;
import com.app.apsfl.adapters.ProductListAdapter;
import com.app.apsfl.interfaces.FragmentBackStackListener;
import com.app.apsfl.interfaces.ListSelectionInterface;
import com.app.apsfl.interfaces.UserActionInterface;
import com.app.apsfl.models.ProductModel;
import com.app.apsfl.utils.Constants;
import com.app.apsfl.utils.Utils;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class BasePackageFragment extends Fragment
        implements TextWatcher, FragmentBackStackListener, ListSelectionInterface,UserActionInterface {

    private static final String TAG = "BasePackageFragment";
    private RecyclerView productRecyclerView;
    private ProductListAdapter productAdapter;
    private RealmList<ProductModel> productList;
    private EditText searchProductEditText;
    private TextView noProductsTextView;
    private int previousPosition;

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
        Constants.isFromBasePackage=false;
        setHasOptionsMenu(true);
    }

    private void setupToolBar() {
        ActionBar mActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setTitle(R.string.fragment_base_package_title);
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
        RealmResults<ProductModel> results;
        if (Constants.cafType == 1) {
            // Individual Base Products
            results = realm.where(ProductModel.class).equalTo("isIndividualProduct", true)
                    .equalTo("productType", "B").findAll();
        } else {
            // Enterprise Base Products
            results = realm.where(ProductModel.class).equalTo("isIndividualProduct", false)
                    .equalTo("productType", "B").findAll();
        }
        productList.clear();
        productList.addAll(results);
        for (ProductModel model : productList) {
            if (model.isProductChecked()) {
                previousPosition = productList.indexOf(model);
                break;
            }
        }
        productAdapter.updateData(productList);
        if (productList.isEmpty()) {
            productRecyclerView.setVisibility(View.GONE);
            noProductsTextView.setVisibility(View.VISIBLE);
        } else {
            productRecyclerView.setVisibility(View.VISIBLE);
            noProductsTextView.setVisibility(View.GONE);
        }
        getActivity().invalidateOptionsMenu();
    }

    private void resetProductsList() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<ProductModel> results = realm.where(ProductModel.class).findAll();
        realm.beginTransaction();
        for (int i = 0; i < results.size(); i++) {
            ProductModel model = results.get(i);
            model.setProductCheckBoxVisible(true);
            model.setProductChecked(false);
            model.setProductInfoShown(false);
        }
        realm.commitTransaction();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.product_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.product_done:
                startAddOnPackageFragment();
                return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        if (getActivity().getSupportFragmentManager().getBackStackEntryCount() > 0) {
            resetProductsList();
            Constants.isFromBasePackage=true;
            getActivity().getSupportFragmentManager().popBackStack();
        } else {
            Utils.showUserConfirmationDialog(getActivity(), this,
                    getString(R.string.discard_form_message), Constants.DISCARD_FORM);
        }


    }

    private void startAddOnPackageFragment() {
        String productCodes = getSelectedProductCodes();
        if (!productCodes.equals("")) {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, new AddOnPackageFragment())
                    .addToBackStack(AddOnPackageFragment.class.getSimpleName())
                    .commit();
        } else {
            Utils.showDialog(this,
                    getString(R.string.no_package_selected_title),
                    getString(R.string.no_package_selected_message), null);
        }
    }

    private String getSelectedProductCodes() {
        String productCodes = "";
        for (ProductModel model : productList) {
            if (model.isProductChecked()) {
                if (productCodes.equals("")) {
                    productCodes += model.getProductCode();
                } else {
                    productCodes += "," + model.getProductCode();
                }
            }
        }
        Log.d(TAG, "\t" + productCodes);
        return productCodes;
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
                    .equalTo("productType", "B")
                    .beginGroup()
                    .contains("productName", searchQuery, Case.INSENSITIVE)
                    .endGroup()
                    .findAll();
        } else {
            results = realm.where(ProductModel.class)
                    .equalTo("isIndividualProduct", false)
                    .equalTo("productType", "B")
                    .beginGroup()
                    .contains("productName", searchQuery, Case.INSENSITIVE)
                    .endGroup()
                    .findAll();
        }
        Log.d(TAG, "Text Queried Results Size" + "\t" + results.size());
        productList.clear();
        productList.addAll(results);
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
                if (previousPosition != position) {
                    productList.get(position).setProductChecked(true);
                    productList.get(previousPosition).setProductChecked(false);
                    previousPosition = position;
                } else {
                    if (productList.get(position).isProductChecked()) {
                        productList.get(position).setProductChecked(false);
                    } else {
                        productList.get(position).setProductChecked(true);
                    }
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

    @Override
    public void onDialogConfirmed(int actionType) {
        switch (actionType) {
            case Constants.DISCARD_FORM:
                Log.d(TAG, "DISCARD FORM");
                /*Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                realm.where(CustomerInfoModel.class).equalTo("formTime", Constants.formTime).findAll().deleteAllFromRealm();
                realm.where(CPEInfoModel.class).equalTo("formTime", Constants.formTime).findAll().deleteAllFromRealm();
                realm.where(CustomerAddressModel.class).equalTo("formTime", Constants.formTime).findAll().deleteAllFromRealm();
                realm.where(OfflineFormModel.class)
                        .equalTo("formTime", Constants.formTime)
                        .findAll().deleteAllFromRealm();
                realm.commitTransaction();
                realm.close();*/
                Utils.resetStaticVariables();
                startActivity(new Intent(getActivity(), MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                break;
        }
    }
}
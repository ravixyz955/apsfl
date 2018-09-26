package com.app.apsfl.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.app.apsfl.R;
import com.app.apsfl.adapters.EnterpriseCustomerAdapter;
import com.app.apsfl.models.EnterpriseCustomer;
import com.app.apsfl.utils.RecyclerViewClickListener;
import com.app.apsfl.utils.Utils;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class EnterpriseCustomersActivity extends AppCompatActivity implements TextWatcher {

    private static final String TAG = "EnterpriseCustomers";

    private Toolbar mToolbar;
    private RecyclerView enterpriseCustomerRecyclerView;
    private RealmList<EnterpriseCustomer> customerList;
    private EnterpriseCustomerAdapter customerAdapter;
    private int previousSelectedPosition = 0;
    private EditText searchENTPEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterprise_customers);
        Log.d(TAG, "onCreate");
        initViews();
        setupToolbar();
        registerListeners();
        setupRecyclerView();
        getAllEnterpriseCustomers();
    }

    private void initViews() {
        mToolbar = (Toolbar) findViewById(R.id.toolBar);
        searchENTPEditText = (EditText)findViewById(R.id.searchENTPEditText);
        enterpriseCustomerRecyclerView = (RecyclerView) findViewById(R.id.enterpriseCustomerRecyclerView);
        customerList=new RealmList<>();
    }

    private void setupToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.enterprise_customer_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            case R.id.enterprise_customer_submit:
                if (isCustomerChecked()) {
                    startActivity(new Intent(this, NewCAFActivity.class));
                } else {
                    Utils.showDialog(this,
                            getString(R.string.no_customer_selected_title),
                            getString(R.string.no_customer_selected_message), null);
                }
                return true;
        }
        return false;
    }
    private void registerListeners() {
        searchENTPEditText.addTextChangedListener(this);
    }
    private void setupRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        enterpriseCustomerRecyclerView.setLayoutManager(manager);
        enterpriseCustomerRecyclerView.addOnItemTouchListener(
                new RecyclerViewClickListener(this, new RecyclerViewClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Realm realm = Realm.getDefaultInstance();
                        realm.beginTransaction();
                        if (previousSelectedPosition == position) {
                            customerList.get(position).setCustomerChecked(true);
                        } else {
                            customerList.get(previousSelectedPosition).setCustomerChecked(false);
                            customerList.get(position).setCustomerChecked(true);
                            previousSelectedPosition = position;
                        }
                        realm.commitTransaction();
                        customerAdapter.notifyDataSetChanged();
                    }
                }));
    }

    private boolean isCustomerChecked() {
        boolean isChecked = false;
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).isCustomerChecked()) {
                isChecked = true;
                break;
            }
        }
        return isChecked;
    }

    private void getAllEnterpriseCustomers() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<EnterpriseCustomer> results = realm.where(EnterpriseCustomer.class).findAllSorted("customerName");
        realm.beginTransaction();
        for (EnterpriseCustomer customer : results) {
            if (customer.isCustomerChecked()) {
                customer.setCustomerChecked(false);
                break;
            }
        }
        realm.commitTransaction();
        customerList.clear();
        customerList.addAll(results);

        setAdapter();
    }

    private void setAdapter() {
        customerAdapter = new EnterpriseCustomerAdapter(this, customerList);
        enterpriseCustomerRecyclerView.setAdapter(customerAdapter);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        String searchQuery = searchENTPEditText.getText().toString();
        if (searchQuery.trim().equals("")) {
            getAllEnterpriseCustomers();
        } else {
            filter(searchQuery);
        }
    }
    private void filter(String searchQuery) {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<EnterpriseCustomer> results;
        results = realm.where(EnterpriseCustomer.class)
                .beginGroup()
                .contains("customerName", searchQuery, Case.INSENSITIVE)
                .endGroup()
                .findAll();

        //Log.d(TAG, "Text Queried Results Size" + "\t" + results.size());
        customerList.clear();
        customerList.addAll(results);
        //Log.d(TAG, "Text Filtered Results Size" + "\t" + customerList.size());
        customerAdapter.updateData(customerList);
    }
}
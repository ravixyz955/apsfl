package com.app.apsfl.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.app.apsfl.R;
import com.app.apsfl.adapters.OfflineFormEditAdapter;
import com.app.apsfl.interfaces.ListSelectionInterface;
import com.app.apsfl.models.OfflineEditCafModel;
import com.app.apsfl.models.SICpeInfoModel;
import com.app.apsfl.models.SICustomerInfoModel;
import com.app.apsfl.utils.Constants;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;
import io.realm.Sort;

public class OfflineEditForms extends AppCompatActivity implements ListSelectionInterface,TextWatcher {

    Realm realm;
    private RecyclerView offlineEditFormRecyclerView;
    private Toolbar mToolBar;
    private TextView noFormsTextView;
    private RealmList<OfflineEditCafModel> offlineEditFormList;
    private OfflineFormEditAdapter formAdapter;
    private EditText searchCafEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline_edit_forms);
        initViews();
        setupToolBar();
        registerListeners();
        setupRecyclerView();
        loadOfflineFormData();
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

    private void initViews() {
        realm = Realm.getDefaultInstance();
        mToolBar = (Toolbar) findViewById(R.id.toolBar);
        offlineEditFormRecyclerView = (RecyclerView) findViewById(R.id.offlineEditFormRecyclerView);
        noFormsTextView = (TextView) findViewById(R.id.noFormsTextView);
        searchCafEditText= (EditText) findViewById(R.id.searchCafEditText);
        offlineEditFormList = new RealmList<>();
    }

    private void setupToolBar() {
        setSupportActionBar(mToolBar);
        ActionBar mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
    private void registerListeners() {
        searchCafEditText.addTextChangedListener(this);
    }
    private void setupRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        offlineEditFormRecyclerView.setLayoutManager(manager);
        formAdapter = new OfflineFormEditAdapter(this, offlineEditFormList);
        formAdapter.setHasStableIds(true);
        offlineEditFormRecyclerView.setAdapter(formAdapter);
        offlineEditFormRecyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    private void loadOfflineFormData() {
        offlineEditFormList.clear();
        offlineEditFormList.addAll(realm.where(OfflineEditCafModel.class).findAllSorted("apsflTrackId", Sort.ASCENDING));
        formAdapter.notifyDataSetChanged();
        if (offlineEditFormList.isEmpty()) {
            offlineEditFormRecyclerView.setVisibility(View.GONE);
            noFormsTextView.setVisibility(View.VISIBLE);
        } else {
            offlineEditFormRecyclerView.setVisibility(View.VISIBLE);
            noFormsTextView.setVisibility(View.GONE);
        }
    }

    @Override
    public void onItemClicked(int viewType, int position) {
        switch (viewType) {
            case Constants.PENDING_CAF_SILMO_EDIT:
///need to check if same apsflTrack id is present in pending and failed
                final OfflineEditCafModel offlineEditCafModel = offlineEditFormList.get(position);
                Constants.apsflTrackId = offlineEditCafModel.getApsflTrackId();
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        SICustomerInfoModel siCustomerInfoModel = realm.where(SICustomerInfoModel.class).equalTo("apsflTrackId", Constants.apsflTrackId).findFirst();
                        if(siCustomerInfoModel == null){
                            siCustomerInfoModel = realm.createObject(SICustomerInfoModel.class,offlineEditCafModel.getApsflTrackId());
                        }
                        //siCustomerInfoModel.setApsflTrackId(offlineEditCafModel.getApsflTrackId());
                        siCustomerInfoModel.setCafNo(offlineEditCafModel.getCafNo());
                        siCustomerInfoModel.setOrganizationName(offlineEditCafModel.getOrganizationName());
                        siCustomerInfoModel.setNameOfContactPersonName(offlineEditCafModel.getContactPersonName());
                        siCustomerInfoModel.setNumberOfContactPerson(offlineEditCafModel.getContactPersonMobileNo());
                        siCustomerInfoModel.setSelectedInstDistId(offlineEditCafModel.getInstDistId());
                        siCustomerInfoModel.setInstAddress(offlineEditCafModel.getInstAddress1());
                        siCustomerInfoModel.setCpeDeviceLocation(offlineEditCafModel.getCpeplace());
                        siCustomerInfoModel.setSelectedInstMandalId(offlineEditCafModel.getInstMandalId());
                        siCustomerInfoModel.setSelectedInstVillage("Select Installation Village");
                        //to send Json
                        siCustomerInfoModel.setEntCustomerCode(offlineEditCafModel.getEntCustomerCode());
                        siCustomerInfoModel.setEntCustType(offlineEditCafModel.getEntCustType());
                        siCustomerInfoModel.setCustId(offlineEditCafModel.getCustId());
                        siCustomerInfoModel.setBillCycle(offlineEditCafModel.getBillCycle());
                        siCustomerInfoModel.setCoreSrvcCode(offlineEditCafModel.getCoreServiceCodes());

                    }
                });

                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        SICpeInfoModel cpeInfoModel = realm.where(SICpeInfoModel.class).equalTo("apsflTrackId", Constants.apsflTrackId).findFirst();
                        if(cpeInfoModel == null){
                            cpeInfoModel = realm.createObject(SICpeInfoModel.class,offlineEditCafModel.getApsflTrackId());
                        }
                        // cpeInfoModel.setApsflTrackId(offlineEditCafModel.getApsflTrackId());
                        cpeInfoModel.setPackageDetails(offlineEditCafModel.getPackageNames());
                        cpeInfoModel.setPopDistId(offlineEditCafModel.getInstDistId());
                        cpeInfoModel.setPopMandalId(offlineEditCafModel.getInstMandalId());
                        cpeInfoModel.setSelectedPop("Select to load POP");
                        cpeInfoModel.setOltIdPosition(0);
                        cpeInfoModel.setOltPortIdPosition(0);
                        cpeInfoModel.setOnuModelPosition(0);
                        cpeInfoModel.setIptvPosition(0);
                        cpeInfoModel.setVpnPosition(0);
                        cpeInfoModel.setIptvPackages(offlineEditCafModel.getIptvPackages());

                    }
                });
                startActivity(new Intent(this, SICustomerInformation.class));
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        String searchQuery = searchCafEditText.getText().toString();
        if (searchQuery.trim().equals("")) {
            loadOfflineFormData();
        } else {
            filter(searchQuery);
        }
    }
    private void filter(String searchQuery) {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<OfflineEditCafModel> results;

        results = realm.where(OfflineEditCafModel.class)
                .beginGroup()
                .contains("apsflTrackId", searchQuery, Case.INSENSITIVE)
                .or()
                .contains("instAddress1", searchQuery, Case.INSENSITIVE)
                .or()
                .contains("cpeplace", searchQuery, Case.INSENSITIVE)
                .or()
                .contains("cafNo", searchQuery, Case.INSENSITIVE)
                .endGroup()
                .findAll();

        Log.d("offlineEditForms", "Text Queried Results Size" + "\t" + results.size());
        offlineEditFormList.clear();
        offlineEditFormList.addAll(results);
        Log.d("offlineEditForms", "Text Filtered Results Size" + "\t" + offlineEditFormList.size());
        formAdapter.updateData(offlineEditFormList);
    }
}

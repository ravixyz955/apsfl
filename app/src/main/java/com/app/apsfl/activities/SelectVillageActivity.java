package com.app.apsfl.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.app.apsfl.R;
import com.app.apsfl.adapters.VillageListAdapter;
import com.app.apsfl.application.BaseApplication;
import com.app.apsfl.models.POPModel;
import com.app.apsfl.models.VillageModel;
import com.app.apsfl.utils.Constants;
import com.app.apsfl.utils.RecyclerViewClickListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmList;
import io.realm.RealmResults;
import io.realm.Sort;

public class SelectVillageActivity extends AppCompatActivity {


    private static final String TAG = "SelectVillageActivity";

    private Toolbar mToolbar;
    private RecyclerView cityRecyclerView;
    private RealmList<VillageModel> villageList;
    List<VillageModel> matchedVillagesList;
    private VillageListAdapter villageListAdapter;
    private int previousPosition = 0;
    private TextView noVillagesTextView;
    private String districtID, mandalSerialNumber;
    public static int villagePosition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_city);
        Log.d(TAG, "onCreate");
        initViews();
        setupToolbar();
        setupRecyclerView();
        loadVillageData();
        final List<VillageModel> matchedVillagesList = new ArrayList<VillageModel>();

    }

    private void initViews() {
        mToolbar = (Toolbar) findViewById(R.id.toolBar);
        cityRecyclerView = (RecyclerView) findViewById(R.id.cityRecyclerView);
        noVillagesTextView = (TextView) findViewById(R.id.noDataTextView);
        villageList = new RealmList<>();
        matchedVillagesList = new ArrayList<VillageModel>();
        if (getIntent() != null && getIntent().hasExtra("districtID") && getIntent().hasExtra("mandalId")) {
            districtID = getIntent().getStringExtra("districtID");
            mandalSerialNumber = getIntent().getStringExtra("mandalId");
            //isDataChanged = getIntent().getBooleanExtra("isDataChanged", false);
            //mandalType = getIntent().getStringExtra("mondalType");
        }
        Realm realm = Realm.getDefaultInstance();
        RealmResults<VillageModel> villageModels = realm.where(VillageModel.class).equalTo("isVillageChecked", true).findAll();
        for (VillageModel villageModel : villageModels) {
            realm.beginTransaction();
            villageModel.setVillageChecked(false);
            realm.commitTransaction();
        }
        realm.close();
    }

    private void setupToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setupRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        cityRecyclerView.setLayoutManager(manager);
        /*cityRecyclerView.addOnItemTouchListener(
                new RecyclerViewClickListener(this, new RecyclerViewClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Realm realm = Realm.getDefaultInstance();
                        realm.beginTransaction();
                        *//*if (previousPosition != position) {
                            villageList.get(position).setVillageChecked(true);
                            villageList.get(previousPosition).setVillageChecked(false);
                            previousPosition = position;
                        } else {
                            villageList.get(position).setVillageChecked(true);
                        }*//*
                        VillageModel villageModel = realm.where(VillageModel.class).equalTo("isVillageChecked", true)
                                .findFirst();
                        if (villageModel != null) {
                            villageModel.setVillageChecked(false);
                        }
                        //villageList.get(position).setVillageChecked(true);
                        int listSize = matchedVillagesList.size();
                        Log.i(TAG, "onItemClick: " + position + "," + listSize);
                        matchedVillagesList.get(position).setVillageChecked(true);

                        realm.commitTransaction();
                        villageListAdapter.notifyDataSetChanged();
                    }
                }))*/
        ;
    }

    //load village data
    private void loadVillageData() {
        Realm realm = Realm.getDefaultInstance();
        Context mContext = getApplicationContext();

      /*  SharedPreferences sharedPreferences= BaseApplication.getSharedPreferences();
        if(sharedPreferences.getString(Constants.TENANT_TYPE, "").equals("LMO")) {*/
        RealmResults<VillageModel> results = null;
        SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();
        SharedPreferences villageModelsharedPreferences = mContext.getSharedPreferences("villageModels", mContext.MODE_PRIVATE);
        //final List<VillageModel> matchedVillagesList = new ArrayList<VillageModel>();
        Gson gson = new Gson();
        String json = villageModelsharedPreferences.getString("villageModelslist", "");
        Type type = new TypeToken<ArrayList<VillageModel>>() {
        }.getType();
        List<VillageModel> finalVillageModels = null;
        if (finalVillageModels == null) {
            finalVillageModels = new ArrayList<VillageModel>();
            finalVillageModels = gson.fromJson(json, type);
        }
        int size = finalVillageModels.size();
        Log.i(TAG, "loadVillageData: " + size);
        switch (sharedPreferences.getString(Constants.TENANT_TYPE, "")) {
            case "LMO":
                POPModel popModel = realm.where(POPModel.class).equalTo("isPOPChecked", true).findFirst();
                if (popModel != null) {
                    String subStationUID = popModel.getPopID();
                    for (VillageModel villageModel : finalVillageModels) {
                        String TestsubStationUID = villageModel.getSubStationUID();
                        if (subStationUID.equals(TestsubStationUID)) {
                            matchedVillagesList.add(villageModel);
                        }
                    }
                    //results = matchedVillagesList;
                    int actualSize = matchedVillagesList.size();
                    Log.i(TAG, "loadVillageData: " + actualSize);
                    /*results = realm.where(VillageModel.class)
                            .equalTo("subStationUID", subStationUID)
                            .findAllSorted("villageName", Sort.ASCENDING);
                    int notesCount = realm.where(VillageModel.class).equalTo("subStationUID", subStationUID).findAll().size();
                    Log.i(TAG, "loadVillageData: "+notesCount);*/
                }
                break;
            case "SI":
                results = realm.where(VillageModel.class).beginGroup()
                        .equalTo("districtSerialNumber", districtID).equalTo("mandalSerialNumber", mandalSerialNumber).endGroup().findAllSorted("villageName", Sort.ASCENDING);
                break;
        }
        villageList.clear();
        if (results != null) {
            villageList.addAll(results);
        }
        //if (!villageList.isEmpty()) {
        if (!matchedVillagesList.isEmpty()) {
            cityRecyclerView.setVisibility(View.VISIBLE);
            noVillagesTextView.setVisibility(View.GONE);
            //villageListAdapter = new VillageListAdapter(this, villageList);
            villageListAdapter = new VillageListAdapter(this, matchedVillagesList);
            cityRecyclerView.setAdapter(villageListAdapter);
        } else {
            cityRecyclerView.setVisibility(View.GONE);
            noVillagesTextView.setVisibility(View.VISIBLE);
        }

           /* POPModel popModel = realm.where(POPModel.class).equalTo("isPOPChecked", true).findFirst();
            if (popModel != null) {
                String subStationUID = popModel.getPopID();
                RealmResults<VillageModel> results = realm.where(VillageModel.class)
                        .equalTo("subStationUID", subStationUID)
                        .findAllSorted("villageName", Sort.ASCENDING);
                villageList.clear();
                villageList.addAll(results);
               *//* for (VillageModel model : villageList) {
                    if (model.isVillageChecked()) {
                        previousPosition = villageList.indexOf(model);
                        break;
                    }
                }*//*
                Log.d("Size", "\t" + villageList.size());
                if (!villageList.isEmpty()) {
                    cityRecyclerView.setVisibility(View.VISIBLE);
                    noVillagesTextView.setVisibility(View.GONE);
                    villageListAdapter = new VillageListAdapter(this, villageList);
                    cityRecyclerView.setAdapter(villageListAdapter);
                } else {
                    cityRecyclerView.setVisibility(View.GONE);
                    noVillagesTextView.setVisibility(View.VISIBLE);
                }
            } else {
                cityRecyclerView.setVisibility(View.GONE);
                noVillagesTextView.setVisibility(View.VISIBLE);
            }*/
       /* }else{

            RealmResults<VillageModel> results = realm.where(VillageModel.class)
                    .findAllSorted("villageName", Sort.ASCENDING);
            villageList.clear();
            villageList.addAll(results);
            Log.d("Size", "\t" + villageList.size());
            if (!villageList.isEmpty()) {
                cityRecyclerView.setVisibility(View.VISIBLE);
                noVillagesTextView.setVisibility(View.GONE);
                villageListAdapter = new VillageListAdapter(this, villageList);
                cityRecyclerView.setAdapter(villageListAdapter);
            } else {
                cityRecyclerView.setVisibility(View.GONE);
                noVillagesTextView.setVisibility(View.VISIBLE);
            }
        }*/
        cityRecyclerView.addOnItemTouchListener(
                new RecyclerViewClickListener(this, new RecyclerViewClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        villagePosition = position;
                        Realm realm = Realm.getDefaultInstance();
                        realm.beginTransaction();
                        VillageModel villageModel;
                      /*  VillageModel villageModel = realm.where(VillageModel.class).equalTo("isVillageChecked", true)
                                .findFirst();
                      */ /* if (villageModel != null) {
                            villageModel.setVillageChecked(false);
                        }*/
                        // matchedVillagesList.get(position).setVillageChecked(true);
                        int listSize = matchedVillagesList.size();
                        Log.i(TAG, "onItemClick: " + position + "," + listSize);
                        for (VillageModel villageModel1 : matchedVillagesList) {
                            villageModel1.setVillageChecked(false);
                        }
                        matchedVillagesList.get(position).setVillageChecked(true);
                        realm.commitTransaction();
                        villageListAdapter.notifyDataSetChanged();
                    }
                }));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mandal_activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.mandal_done:
                onBackPressed();
                return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SelectVillageActivity.this, NewCAFActivity.class);
        //if (!villageList.isEmpty()) {
        if (!matchedVillagesList.isEmpty()) {
            Log.i(TAG, "onBackPressed: " + "Hello");
            //VillageModel model = Realm.getDefaultInstance().where(VillageModel.class).equalTo("isVillageChecked", true).findFirst();
            VillageModel model = matchedVillagesList.get(villagePosition);
            if (model != null) {
                intent.putExtra("villageName", model.getVillageName());
                intent.putExtra("villageSerialNumber", model.getVillageSerialNumber());
                intent.putExtra("mandalName", model.getMandalName());
                intent.putExtra("mandalSerialNumber", model.getMandalSerialNumber());
                intent.putExtra("districtName", model.getDistrictName());
                intent.putExtra("districtSerialNumber", model.getDistrictSerialNumber());
                intent.putExtra("region", model.getRegion());
                setResult(RESULT_OK, intent);
            } else {
                setResult(RESULT_CANCELED, intent);
            }
        } else {
            setResult(RESULT_CANCELED, intent);
        }
        finish();
    }
}
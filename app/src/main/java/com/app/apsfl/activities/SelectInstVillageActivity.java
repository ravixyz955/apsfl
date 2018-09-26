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
import android.widget.TextView;

import com.app.apsfl.R;
import com.app.apsfl.adapters.InstallationVillageListAdapter;
import com.app.apsfl.models.InstallationVillageModel;
import com.app.apsfl.utils.RecyclerViewClickListener;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;
import io.realm.Sort;

public class SelectInstVillageActivity extends AppCompatActivity implements TextWatcher {
    private static final String TAG = "SelectInstVillActivity";

    private Toolbar mToolbar;
    private RecyclerView cityRecyclerView;
    private RealmList<InstallationVillageModel> villageList;
    private InstallationVillageListAdapter villageListAdapter;
    private int previousPosition = 0;
    private TextView noVillagesTextView;
    private EditText searchVillageEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_inst_village);
        Log.d(TAG, "onCreate");
        initViews();
        setupToolbar();
        registerListeners();
        setupRecyclerView();
        loadMandalData();
    }
    private void initViews() {
        mToolbar = (Toolbar) findViewById(R.id.toolBar);
        searchVillageEditText = (EditText)findViewById(R.id.searchVillageEditText);
        cityRecyclerView = (RecyclerView) findViewById(R.id.cityRecyclerView);
        noVillagesTextView = (TextView) findViewById(R.id.noDataTextView);
        villageList = new RealmList<>();

    }

    private void setupToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
    private void registerListeners() {
        searchVillageEditText.addTextChangedListener(this);
    }

    private void setupRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        cityRecyclerView.setLayoutManager(manager);
        cityRecyclerView.addOnItemTouchListener(
                new RecyclerViewClickListener(this, new RecyclerViewClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Realm realm = Realm.getDefaultInstance();
                        realm.beginTransaction();
                        /*if (previousPosition != position) {
                            villageList.get(position).setVillageChecked(true);
                            villageList.get(previousPosition).setVillageChecked(false);
                            previousPosition = position;
                        } else {
                            villageList.get(position).setVillageChecked(true);
                        }*/
                        InstallationVillageModel installationVillageModel = realm.where(InstallationVillageModel.class).equalTo("isVillageChecked", true)
                                .findFirst();
                        if (installationVillageModel != null) {
                            installationVillageModel.setVillageChecked(false);
                        }
                        villageList.get(position).setVillageChecked(true);


                        realm.commitTransaction();
                        villageListAdapter.notifyDataSetChanged();
                    }
                }));
    }
    //load village data
    private void loadMandalData() {
        Realm realm = Realm.getDefaultInstance();
            RealmResults<InstallationVillageModel> results = realm.where(InstallationVillageModel.class)
                    .findAllSorted("villageName", Sort.ASCENDING);
            villageList.clear();
            villageList.addAll(results);
       /* for (InstallationVillageModel model : villageList) {
            if (model.isVillageChecked()) {
                previousPosition = villageList.indexOf(model);
                break;
            }
        }*/
            Log.d("Size", "\t" + villageList.size());
            if (!villageList.isEmpty()) {
                cityRecyclerView.setVisibility(View.VISIBLE);
                noVillagesTextView.setVisibility(View.GONE);
                villageListAdapter = new InstallationVillageListAdapter(this, villageList);
                cityRecyclerView.setAdapter(villageListAdapter);
            } else {
                cityRecyclerView.setVisibility(View.GONE);
                noVillagesTextView.setVisibility(View.VISIBLE);
            }

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
            case R.id.mandal_done:
                onBackPressed();
                return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SelectInstVillageActivity.this, NewCAFActivity.class);
        if (!villageList.isEmpty()) {
            InstallationVillageModel model = Realm.getDefaultInstance().where(InstallationVillageModel.class).equalTo("isVillageChecked", true).findFirst();
            if (model != null) {
                intent.putExtra("villageName", model.getVillageName());
                intent.putExtra("villageSerialNumber", model.getVillageSerialNumber());
                intent.putExtra("mandalSerialNumber", model.getMandalSerialNumber());
                intent.putExtra("districtSerialNumber", model.getDistrictSerialNumber());
                //intent.putExtra("region",model.getRegion());
                setResult(RESULT_OK, intent);
            } else {
                setResult(RESULT_CANCELED, intent);
            }
        } else {
            setResult(RESULT_CANCELED, intent);
        }
        finish();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        String searchQuery = searchVillageEditText.getText().toString();
        if (searchQuery.trim().equals("")) {
            loadMandalData();
        } else {
            filter(searchQuery);
        }
    }
    private void filter(String searchQuery) {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<InstallationVillageModel> results;
            results = realm.where(InstallationVillageModel.class)
                    .beginGroup()
                    .contains("villageName", searchQuery, Case.INSENSITIVE)
                    .endGroup()
                    .findAll();

       // Log.d(TAG, "Text Queried Results Size" + "\t" + results.size());
        villageList.clear();
        villageList.addAll(results);
       // Log.d(TAG, "Text Filtered Results Size" + "\t" + villageList.size());
        villageListAdapter.updateData(villageList);
    }
}

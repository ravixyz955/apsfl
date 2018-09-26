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
import com.app.apsfl.adapters.MandalListAdapter;
import com.app.apsfl.models.MandalModel;
import com.app.apsfl.models.VillageModel;
import com.app.apsfl.utils.RecyclerViewClickListener;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;
import io.realm.Sort;

public class SelectMandalActivity extends AppCompatActivity implements TextWatcher {


    private static final String TAG = "SelectMandalActivity";

    private Toolbar mToolbar;
    private RecyclerView mandalRecyclerView;
    private RealmList<VillageModel> mandalList;
    private MandalListAdapter mandalListAdapter;
    private String mandalName = "";
    private String districtID, mandalSerialNumber;
    private boolean isDataChanged;
    private int previousPosition = 0;
    private TextView noMandalsTextView;
    private String mandalType;
    private EditText searchMandalEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_mandal);
        Log.d(TAG, "onCreate");
        initViews();
        setupToolbar();
        registerListeners();
        setupRecyclerView();
        loadMandalData();
    }

    private void initViews() {
        mToolbar = (Toolbar) findViewById(R.id.toolBar);
        searchMandalEditText = (EditText) findViewById(R.id.searchMandalEditText);
        mandalRecyclerView = (RecyclerView) findViewById(R.id.mandalRecyclerView);
        noMandalsTextView = (TextView) findViewById(R.id.noDataTextView);
        if (getIntent() != null && getIntent().hasExtra("districtID")) {
            districtID = getIntent().getStringExtra("districtID");
            isDataChanged = getIntent().getBooleanExtra("isDataChanged", false);
            //mandalType = getIntent().getStringExtra("mondalType");
        }
        mandalList = new RealmList<>();


    }

    private void setupToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void registerListeners() {
        searchMandalEditText.addTextChangedListener(this);
    }

    private void setupRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mandalRecyclerView.setLayoutManager(manager);
        mandalRecyclerView.addOnItemTouchListener(
                new RecyclerViewClickListener(this, new RecyclerViewClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        isDataChanged = true;
                        Realm realm = Realm.getDefaultInstance();
                        realm.beginTransaction();
                        mandalName = mandalList.get(position).getMandalName();
                        mandalSerialNumber = mandalList.get(position).getMandalSerialNumber();
                        districtID = mandalList.get(position).getDistrictSerialNumber();
                        VillageModel mandalModel=realm.where(VillageModel.class).equalTo("isVillageChecked",true).findFirst();
                        // MandalModel mandalModel = realm.where(MandalModel.class).equalTo("districtID", districtID).equalTo("isMandalChecked", true)
                        // .findFirst();
                        if (mandalModel != null) {
                            mandalModel.setVillageChecked(false);
                        }
                        mandalList.get(position).setVillageChecked(true);
                        realm.commitTransaction();
                        mandalListAdapter.notifyDataSetChanged();
                    }
                }));
    }

    private void loadMandalData() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<VillageModel> results = realm.where(VillageModel.class).equalTo("districtSerialNumber", districtID)
                .findAllSorted("mandalName", Sort.ASCENDING).distinct("mandalName");
      /*  RealmResults<VillageModel> results = realm.where(VillageModel.class).equalTo("districtSerialNumber", districtID)
                .findAllSorted("mandalName", Sort.ASCENDING).distinct("mandalName");*/

        // mandalList = realm.where(MandalModel.class).findAllSorted("mandalName", Sort.ASCENDING);

        mandalList.clear();
        mandalList.addAll(results);
        /*for (MandalModel mandalModel : mandalList) {
            if (mandalModel.isMandalChecked()) {
                previousPosition = mandalList.indexOf(mandalModel);
                break;
            }
        }*/
        Log.d("Size", "\t" + mandalList.size());
        if (!mandalList.isEmpty()) {
            for (VillageModel model : mandalList) {
                if (model.isVillageChecked()) {
                    mandalName = model.getMandalName();
                    mandalSerialNumber = model.getMandalSerialNumber();
                    break;
                }
            }
            if (isDataChanged) {
                realm.beginTransaction();
                for (int i = 0; i < mandalList.size(); i++) {
                    mandalList.get(i).setVillageChecked(false);
                }
                realm.commitTransaction();
            }
            mandalRecyclerView.setVisibility(View.VISIBLE);
            noMandalsTextView.setVisibility(View.GONE);
            mandalListAdapter = new MandalListAdapter(this, mandalList);
            mandalRecyclerView.setAdapter(mandalListAdapter);
        } else {
            mandalRecyclerView.setVisibility(View.GONE);
            noMandalsTextView.setVisibility(View.VISIBLE);
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
        Intent intent = new Intent(SelectMandalActivity.this, NewCAFActivity.class);
        if (!mandalList.isEmpty()) {
            intent.putExtra("mandalName", mandalName);
            intent.putExtra("mandalSerialno", mandalSerialNumber);
            intent.putExtra("districtID", districtID);
            Log.d(TAG, "Mondal,district Id" + mandalSerialNumber + "" + districtID);
            setResult(RESULT_OK, intent);
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
        String searchQuery = searchMandalEditText.getText().toString();
        if (searchQuery.trim().equals("")) {
            loadMandalData();
        } else {
            filter(searchQuery);
        }
    }

    private void filter(String searchQuery) {
        Realm realm = Realm.getDefaultInstance();
        for (VillageModel mandalModel : mandalList) {
            if (mandalModel.isVillageChecked()) {
                previousPosition = mandalList.indexOf(mandalModel);
                break;
            }
        }
        RealmResults<VillageModel> results = realm.where(VillageModel.class).equalTo("districtSerialNumber", districtID)
                .beginGroup()
                .contains("mandalName", searchQuery, Case.INSENSITIVE)
                .endGroup()
                .findAll().distinct("mandalName");


        Log.d(TAG, "Text Queried Results Size" + "\t" + results.size());
        mandalList.clear();
        mandalList.addAll(results);
        Log.d(TAG, "Text Filtered Results Size" + "\t" + mandalList.size());
        mandalListAdapter.updateData(mandalList);
    }
}

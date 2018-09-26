package com.app.apsfl.activities;

import android.content.Intent;
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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.apsfl.R;
import com.app.apsfl.adapters.POPNameAdapter;
import com.app.apsfl.models.POPModel;
import com.app.apsfl.utils.RecyclerViewClickListener;
import com.app.apsfl.utils.Utils;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class SelectPOPActivity extends AppCompatActivity {

    private static final String TAG = "SelectPOPActivity";

    private Toolbar mToolbar;
    private RecyclerView popNameRecyclerView;
    private POPNameAdapter popNameAdapter;
    private RealmList<POPModel> popNamesList;
    private TextView noPOPTextView;
    private String selectedPOPName = "", selectedPOPID = "";
    private int previousPosition;
    private LinearLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate()");
        setContentView(R.layout.activity_pop_name);
        initViews();
        setupToolBar();
        setupRecyclerView();
        loadData();
    }

    private void initViews() {
        mainLayout = (LinearLayout) findViewById(R.id.mainLayout);
        mToolbar = (Toolbar) findViewById(R.id.toolBar);
        popNameRecyclerView = (RecyclerView) findViewById(R.id.popNameRecyclerView);
        noPOPTextView = (TextView) findViewById(R.id.noPOPTextView);
        popNamesList = new RealmList<>();
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
        popNameRecyclerView.setLayoutManager(manager);
        popNameAdapter = new POPNameAdapter(this, popNamesList);
        popNameRecyclerView.setAdapter(popNameAdapter);
        popNameRecyclerView.addOnItemTouchListener(new RecyclerViewClickListener(this,
                new RecyclerViewClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Realm realm = Realm.getDefaultInstance();
                        realm.beginTransaction();
                        selectedPOPName = popNamesList.get(position).getPopName();
                        selectedPOPID = popNamesList.get(position).getPopID();
                        /*if (previousPosition != position) {
                            popNamesList.get(position).setPOPChecked(true);
                            popNamesList.get(previousPosition).setPOPChecked(false);
                            previousPosition = position;
                        } else {
                            popNamesList.get(position).setPOPChecked(true);
                        }*/
                        POPModel popModel = realm.where(POPModel.class).equalTo("isPOPChecked", true)
                                .findFirst();
                        if (popModel != null) {
                            popModel.setPOPChecked(false);
                        }
                        popNamesList.get(position).setPOPChecked(true);

                        realm.commitTransaction();
                        popNameAdapter.notifyDataSetChanged();
                    }
                }
        ));
    }

    private void loadData() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<POPModel> allResults = realm.where(POPModel.class).findAll();
        /*for (POPModel popModel : allResults) {
            if (popModel.isPOPChecked()) {
               // previousPosition = allResults.indexOf(popModel);
                selectedPOPName = popModel.getPopName();
                selectedPOPID = popModel.getPopID();
                break;
            }
        }*/
        popNamesList.clear();
        popNamesList.addAll(allResults);
        popNameAdapter.updateData(popNamesList);
        Log.d("Size", "\t" + popNamesList.size());
        if (!popNamesList.isEmpty()) {
            popNameRecyclerView.setVisibility(View.VISIBLE);
            noPOPTextView.setVisibility(View.GONE);
        } else {
            popNameRecyclerView.setVisibility(View.GONE);
            noPOPTextView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.pop_name_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
            case R.id.action_done:
                onBackPressed();
                return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        Utils.hideKeyboard(mainLayout);
        Intent intent = new Intent(this, NewCAFActivity.class);
        intent.putExtra("selectedPOPName", selectedPOPName);
        intent.putExtra("selectedPOPID", selectedPOPID);
        setResult(RESULT_OK, intent);
        finish();
    }
}
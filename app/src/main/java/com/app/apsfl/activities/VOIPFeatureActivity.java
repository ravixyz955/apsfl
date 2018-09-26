package com.app.apsfl.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import com.app.apsfl.R;
import com.app.apsfl.adapters.CustomSpinnerAdapter;
import com.app.apsfl.models.FormSpinnerModel;
import com.app.apsfl.models.VOIPFeatureModel;
import com.app.apsfl.models.VOIPSavedModel;
import com.app.apsfl.utils.Constants;
import com.app.apsfl.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;

import io.realm.Realm;
import io.realm.RealmResults;

public class VOIPFeatureActivity extends AppCompatActivity
        implements View.OnClickListener {

    private static final String TAG = "VOIPFeatureActivity";
    private Toolbar mToolbar;
    private String featureCode;
    private ScrollView mainLayout;
    private LinearLayout mainContainer;
    private TextView noFeaturesTextView;
    private RealmResults<VOIPFeatureModel> results;
    private boolean isListEmpty = false;
    private int mCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate()");
        setContentView(R.layout.activity_voip_feature);
        initViews();
        setupToolBar();
        if (Constants.map == null) {
            Constants.map = new HashMap<>();
            Log.d("New Map", String.valueOf(Constants.map.size()));
            constructLayout();
        } else {
            Log.d("Saved Map Size -> ", String.valueOf(Constants.map.size()));
            loadSavedData();
        }
    }

    private void initViews() {
        if (getIntent() != null && getIntent().hasExtra("featureCode")) {
            featureCode = getIntent().getStringExtra("featureCode");
        }
        mToolbar = (Toolbar) findViewById(R.id.toolBar);
        mainLayout = (ScrollView) findViewById(R.id.mainLayout);
        mainContainer = (LinearLayout) findViewById(R.id.mainContainer);
        noFeaturesTextView = (TextView) findViewById(R.id.noFeaturesTextView);
        results = Realm.getDefaultInstance().where(VOIPFeatureModel.class)
                .equalTo("featureCode", featureCode).findAll();
    }

    private void setupToolBar() {
        setSupportActionBar(mToolbar);
        ActionBar mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setTitle(featureCode);
            mActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void constructLayout() {
        try {
            if (!results.isEmpty()) {
                isListEmpty = false;
                mainLayout.setVisibility(View.VISIBLE);
                noFeaturesTextView.setVisibility(View.GONE);
                LayoutInflater layoutInflater = LayoutInflater.from(this);
                for (VOIPFeatureModel model : results) {
//                    LinearLayout eachFeature = (LinearLayout) layoutInflater.inflate(R.layout.layout_each_voip_feature, null, false);
                    if (model.getParamType().equals("LOV")) {
                        // Inflate Spinner Layout
                        LinearLayout spinnerLayout = (LinearLayout) layoutInflater.inflate(R.layout.layout_field_spinner, null);
                        TextView featureSpinnerName = (TextView) spinnerLayout.findViewById(R.id.featureSpinnerName);
                        Spinner featureSpinner = (Spinner) spinnerLayout.findViewById(R.id.featureSpinner);
                        setSpinnerData(featureSpinner, model.getParamLovName());
                        featureSpinner.setSelection(0);
                        featureSpinner.setTag(model);
                        featureSpinnerName.setText(model.getParamName());
                        mainContainer.addView(spinnerLayout);
                    } else {
                        // Inflate input layout
                        LinearLayout inputLayout = (LinearLayout) layoutInflater.inflate(R.layout.layout_field_input, null);
                        TextView inputName = (TextView) inputLayout.findViewById(R.id.featureInputName);
                        EditText inputValue = (EditText) inputLayout.findViewById(R.id.featureInputValue);
                        inputName.setText(model.getParamName());
                        inputValue.setTag(model);
                        mainContainer.addView(inputLayout);
                    }
//                    if (mCount > 0) {
//                        TextView removeView = (TextView) layoutInflater.inflate(R.layout.layout_field_remove, null, false);
//                        removeView.setTag(mCount);
//                        removeView.setOnClickListener(this);
//                        eachFeature.addView(removeView);
//                    }
//                    mainContainer.addView(eachFeature);
                }
            } else {
                mainLayout.setVisibility(View.GONE);
                noFeaturesTextView.setVisibility(View.VISIBLE);
                isListEmpty = true;
                invalidateOptionsMenu();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d("Exception in ->", "constructLayout()");
        }
    }

    private void loadSavedData() {
        Log.d(TAG, "Loading Saved Data");
        ArrayList<VOIPSavedModel> list;
        if (Constants.map != null && !Constants.map.isEmpty() && Constants.map.get(featureCode) != null) {
            list = Constants.map.get(featureCode);
            if (!list.isEmpty()) {
                isListEmpty = false;
                LayoutInflater layoutInflater = LayoutInflater.from(this);
                for (VOIPSavedModel model : list) {
//                    LinearLayout eachFeature = (LinearLayout) layoutInflater.inflate(R.layout.layout_each_voip_feature, null, false);
                    if (!model.getParamLovName().equals("")) {
                        // Inflate Spinner Layout
                        LinearLayout spinnerLayout = (LinearLayout) layoutInflater.inflate(R.layout.layout_field_spinner, null);
                        TextView featureSpinnerName = (TextView) spinnerLayout.findViewById(R.id.featureSpinnerName);
                        Spinner featureSpinner = (Spinner) spinnerLayout.findViewById(R.id.featureSpinner);
                        setSpinnerData(featureSpinner, model.getParamLovName());
                        featureSpinner.setSelection(model.getInputSpinnerPosition());
                        featureSpinnerName.setText(model.getParamName());
                        featureSpinner.setTag(model);
                        mainContainer.addView(spinnerLayout);
                    } else {
                        // Inflate input layout
                        LinearLayout inputLayout = (LinearLayout) layoutInflater.inflate(R.layout.layout_field_input, null);
                        TextView inputName = (TextView) inputLayout.findViewById(R.id.featureInputName);
                        EditText inputValue = (EditText) inputLayout.findViewById(R.id.featureInputValue);
                        inputName.setText(model.getParamName());
                        inputValue.append(model.getInputFieldValue());
                        inputValue.setTag(model);
                        mainContainer.addView(inputLayout);
                    }
//                    if (model.isRemoveVisible()) {
//                        mCount++;
//                        TextView removeView = (TextView) layoutInflater.inflate(R.layout.layout_field_remove, null, false);
//                        removeView.setTag(mCount);
//                        removeView.setOnClickListener(this);
//                        eachFeature.addView(removeView);
//                    }
//                    mainContainer.addView(eachFeature);
                }
            } else {
                Log.d("loadSavedData() -> ", "List empty");
                mainLayout.setVisibility(View.GONE);
                noFeaturesTextView.setVisibility(View.VISIBLE);
                isListEmpty = true;
                invalidateOptionsMenu();
            }
        } else {
            Log.d("loadSavedData() -> ", "No Data Found");
            constructLayout();
        }
    }

    private void setSpinnerData(Spinner spinner, String type) {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<FormSpinnerModel> results = realm.where(FormSpinnerModel.class).findAll();
        String[] data = null;
        switch (type) {
            case "VMADDRESS":
                data = results.get(0).getVmAddresses().split(",");
                break;

            case "HotlinePriority":
                data = results.get(0).getHotLinePriorities().split(",");
                break;
        }
        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(this, data);
        spinner.setAdapter(adapter);
    }

    private void addChildView() {
        int maxCount = results.get(0).getMaxParamValues();
        Log.d("ParamCount", "\t" + maxCount);
        if (maxCount != mainContainer.getChildCount() / 2) {
            constructLayout();
//            mCount++;
            Log.d("ChildCount", "\t" + mainContainer.getChildCount());
        } else {
            Utils.showDialog(this, "Alert", "Max Permitted Count Reached", null);
        }
    }
    private void saveData() {
        Log.d(TAG, "saveData()");
        ArrayList<VOIPSavedModel> list;
        if (Constants.map != null && !Constants.map.isEmpty() && Constants.map.get(featureCode) != null) {
            list = Constants.map.get(featureCode);
            list.clear();
        } else {
            list = new ArrayList<>();
        }
        for (int i = 0; i < mainContainer.getChildCount(); i++) {
            VOIPSavedModel savedModel = new VOIPSavedModel();
            LinearLayout eachFeature = (LinearLayout) mainContainer.getChildAt(i);
            for (int j = 0; j < eachFeature.getChildCount(); j++) {
//                LinearLayout eachChild = (LinearLayout) eachFeature.getChildAt(j);
                View childView = eachFeature.getChildAt(j);
//                for (int k = 0; k < eachChild.getChildCount(); k++) {
//                    View childView = eachChild.getChildAt(k);
                Log.d("Child View", childView.getClass().getName());
                if (childView instanceof EditText) {
                    EditText field = (EditText) childView;
                    Object tag = field.getTag();
                    VOIPFeatureModel featureModel = null;
                    VOIPSavedModel model = null;
                    if (tag instanceof VOIPFeatureModel) {
                        featureModel = (VOIPFeatureModel) field.getTag();
                    } else {
                        model = (VOIPSavedModel) field.getTag();
                    }
                    savedModel.setInputFieldValue(field.getText().toString());
                    savedModel.setParamCode(featureModel != null ? featureModel.getParamCode() : model.getParamCode());
                    savedModel.setParamLovName(featureModel != null ? featureModel.getParamLovName() : model.getParamLovName());
                    savedModel.setParamName(featureModel != null ? featureModel.getParamName() : model.getParamName());
                    savedModel.setInputSpinnerPosition(0);
                } else if (childView instanceof Spinner) {
                    Spinner spinner = (Spinner) childView;
                    Object tag = spinner.getTag();
                    VOIPFeatureModel featureModel = null;
                    VOIPSavedModel model = null;
                    if (tag instanceof VOIPFeatureModel) {
                        featureModel = (VOIPFeatureModel) spinner.getTag();
                    } else {
                        model = (VOIPSavedModel) spinner.getTag();
                    }
                    savedModel.setInputFieldValue("");
                    savedModel.setParamCode(featureModel != null ? featureModel.getParamCode() : model.getParamCode());
                    savedModel.setParamLovName(featureModel != null ? featureModel.getParamLovName() : model.getParamLovName());
                    savedModel.setParamName(featureModel != null ? featureModel.getParamName() : model.getParamName());
                    savedModel.setInputSpinnerPosition(spinner.getSelectedItemPosition());
                } else if (childView instanceof TextView) {
                    savedModel.setRemoveVisible(true);
                }
//                }
            }
            list.add(savedModel);
        }
        Log.d("List Size", String.valueOf(list.size()));
        for (VOIPSavedModel model : list) {
            Log.d("Saved Model", model.toString());
        }
        Constants.map.put(featureCode, list);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_voip_menu, menu);
        MenuItem actionAdd = menu.findItem(R.id.voip_feature_add);
        MenuItem actionDone = menu.findItem(R.id.voip_feature_done);
        actionAdd.setVisible(!isListEmpty);
        actionDone.setVisible(!isListEmpty);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.voip_feature_add:
                addChildView();
                return true;

            case android.R.id.home:
            case R.id.voip_feature_done:
                onBackPressed();
                return true;
        }
        return false;
    }

    private boolean areAllFieldsFilled() {
        boolean isFilled = false;
        ArrayList<VOIPSavedModel> list = Constants.map.get(featureCode);
        for (VOIPSavedModel model : list) {
            isFilled = !model.getInputFieldValue().equals("") || model.getInputSpinnerPosition() > 0;
            model.setFilled(isFilled);
            list.set(list.indexOf(model), model);
        }
        Constants.map.put(featureCode, list);
        Log.d("areAllFieldsFilled", String.valueOf(isFilled));
        return isFilled;
    }

    @Override
    public void onBackPressed() {
        saveData();
        Intent intent = new Intent(this, NewCAFActivity.class);
        intent.putExtra("position", getIntent().getIntExtra("position", 0));
        intent.putExtra("areAllFieldsFilled", areAllFieldsFilled());
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public void onClick(View view) {
        Log.d("OnClick()", view.getTag().toString());
        int position = Integer.parseInt(view.getTag().toString());
        mainContainer.removeViewAt(position);
        mainContainer.invalidate();
    }
}
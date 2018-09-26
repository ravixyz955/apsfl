package com.app.apsfl.activities;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.app.apsfl.R;
import com.app.apsfl.adapters.CustomSpinnerAdapter;
import com.app.apsfl.adapters.DistrictSpinnerAdapter;

import com.app.apsfl.application.BaseApplication;
import com.app.apsfl.httpClient.RequestHandler;
import com.app.apsfl.interfaces.ResponseHandler;
import com.app.apsfl.models.CAFResultModel;
import com.app.apsfl.models.DistrictModel;

import com.app.apsfl.models.POPModel;
import com.app.apsfl.utils.Constants;
import com.app.apsfl.utils.FormValidations;
import com.app.apsfl.utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import io.realm.Realm;
import io.realm.RealmList;

public class SearchCAFActivity extends AppCompatActivity
        implements View.OnClickListener, ResponseHandler, AdapterView.OnItemSelectedListener {



    List<POPModel> popModels = null;
    String status = "";
    private Toolbar mToolbar;
    private TextView searchFromDate, searchToDate, searchAadhaarHeader, mandalheader, distheader;
    private Spinner statusSpinner, districtSpinner;
    private TextView selectedMandal, selectedPop;
    private EditText aadhaarEditText, cafNumberEditText, searchTrackIdEditText;
    private Calendar fromDateInstance, toDateInstance;
    private boolean isFromDate;
    private RequestHandler requestHandler;
    private LinearLayout mainLayout, apsflTrackIdLayout, districtMandalLayout, fromDateLayout, toDateLayout, cafLayout, aadharLayout, poplayout;
    private SimpleDateFormat dateFormat;
    private String lmoType, mandalId = "", districtId = "", popId = "";
    private SharedPreferences sharedPreferences;
    private RealmList<DistrictModel> districtSpinnerItems;
    private DatePickerDialog.OnDateSetListener fromDateListener =
            new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    fromDateInstance.set(Calendar.YEAR, year);
                    fromDateInstance.set(Calendar.MONTH, monthOfYear);
                    fromDateInstance.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    updateUI();
                }
            };
    private DatePickerDialog.OnDateSetListener toDateListener =
            new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    toDateInstance.set(Calendar.YEAR, year);
                    toDateInstance.set(Calendar.MONTH, monthOfYear);
                    toDateInstance.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    updateUI();
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_caf);
        initViews();
        setupToolBar();
        setSpinnerData();
        registerListeners();
    }

    private void initViews() {
        dateFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
        mainLayout = (LinearLayout) findViewById(R.id.mainLayout);
        apsflTrackIdLayout = (LinearLayout) findViewById(R.id.apsflTrack_layout);
        districtMandalLayout = (LinearLayout) findViewById(R.id.district_mandal_layout);
        mToolbar = (Toolbar) findViewById(R.id.toolBar);
        fromDateInstance = Calendar.getInstance();
        toDateInstance = Calendar.getInstance();
        requestHandler = new RequestHandler();
        searchFromDate = (TextView) findViewById(R.id.searchFromDateValue);
        searchToDate = (TextView) findViewById(R.id.searchToDateValue);
        statusSpinner = (Spinner) findViewById(R.id.statusSpinner);
        aadhaarEditText = (EditText) findViewById(R.id.searchAadhaarEditText);
        cafNumberEditText = (EditText) findViewById(R.id.searchCAFEditText);
        searchTrackIdEditText = (EditText) findViewById(R.id.searchTrackIdEditText);
        districtSpinner = (Spinner) findViewById(R.id.districtSpinner);
        selectedMandal = (TextView) findViewById(R.id.selectedMandal);
        selectedPop = (TextView) findViewById(R.id.selectedPop);
        searchAadhaarHeader = (TextView) findViewById(R.id.searchAadhaarHeader);

        fromDateLayout = (LinearLayout) findViewById(R.id.layout_fromDate);
        toDateLayout = (LinearLayout) findViewById(R.id.layout_toDate);
        aadharLayout = (LinearLayout) findViewById(R.id.layout_aadhar);
        cafLayout = (LinearLayout) findViewById(R.id.layout_cafno);
        poplayout = (LinearLayout) findViewById(R.id.poplayout);

        mandalheader = (TextView) findViewById(R.id.mandalheader);
        distheader = (TextView) findViewById(R.id.distheader);

        sharedPreferences = BaseApplication.getSharedPreferences();
        lmoType = sharedPreferences.getString(Constants.TENANT_TYPE, "");
        switch (lmoType) {
            case "LMO":
                apsflTrackIdLayout.setVisibility(View.GONE);
                districtMandalLayout.setVisibility(View.GONE);
                break;
            case "SI":
                searchAadhaarHeader.setText("Registration No");
                fromDateLayout.setVisibility(View.GONE);
                toDateLayout.setVisibility(View.GONE);
                aadharLayout.setVisibility(View.GONE);
                cafLayout.setVisibility(View.GONE);
                districtSpinnerItems = new RealmList<>();
                break;
        }

    }

    private void setupToolBar() {
        setSupportActionBar(mToolbar);
        ActionBar mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void registerListeners() {
        searchFromDate.setOnClickListener(this);
        searchToDate.setOnClickListener(this);
        statusSpinner.setOnItemSelectedListener(this);
        districtSpinner.setOnItemSelectedListener(this);
        selectedMandal.setOnClickListener(this);
        selectedPop.setOnClickListener(this);
    }

    private void setSpinnerData() {
        String[] cafStatuses;
        if (lmoType.equals("LMO")) {
            cafStatuses = getResources().getStringArray(R.array.caf_status_spinner_items);
        } else {
            cafStatuses = getResources().getStringArray(R.array.caf_status_spinner_items_SILMO);
        }
        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(this, cafStatuses);
        statusSpinner.setAdapter(adapter);
       /* if(lmoType.equals("SI")){
            statusSpinner.setSelection(6);
        }
*/
    }

    private void showFromDateDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                fromDateListener,
                fromDateInstance.get(Calendar.YEAR),
                fromDateInstance.get(Calendar.MONTH),
                fromDateInstance.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.getDatePicker().setMaxDate(new Date().getTime());
        datePickerDialog.show();
    }

    private void showToDateDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                toDateListener,
                toDateInstance.get(Calendar.YEAR),
                toDateInstance.get(Calendar.MONTH),
                toDateInstance.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.getDatePicker().setMaxDate(new Date().getTime());
        datePickerDialog.show();
    }

    private void updateUI() {

        if (isFromDate) {
            searchFromDate.setText(dateFormat.format(fromDateInstance.getTime()));
        } else {
            searchToDate.setText(dateFormat.format(toDateInstance.getTime()));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_caf_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                super.onBackPressed();
                return true;

            case R.id.search_caf_done:
                Utils.hideKeyboard(mainLayout);
                validateFields();
                return true;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        Realm realm = Realm.getDefaultInstance();
        switch (v.getId()) {

            case R.id.searchFromDateValue:
                isFromDate = true;
                showFromDateDialog();
                break;

            case R.id.searchToDateValue:
                isFromDate = false;
                showToDateDialog();
                break;
            case R.id.selectedMandal:
                if (districtSpinner.getSelectedItemPosition() > 0) {
                    Intent intent = new Intent(this, SelectMandalActivity.class);
                    intent.putExtra("districtID", districtId);
                    startActivityForResult(intent, 1004);
                } else {
                    Utils.showDialog(this, "Alert",
                            "Please select District", null);
                }
               /* RealmResults<MandalModel> popMandalModels = realm.where(MandalModel.class).equalTo("districtID", districtId).equalTo("isPopMandal", true).findAll();
                if (!popMandalModels.isEmpty()) {
                    Intent intent = new Intent(this, SelectMandalActivity.class);
                    intent.putExtra("districtID", districtId);
                    intent.putExtra("mondalType", "popMandal");
                    startActivityForResult(intent, 1004);
                } else {
                    Utils.showDialog(this,
                            "Select POP District",
                            "Please Select POP District to Change mandal", null);
                }*/
                break;
               /* EditMandalAdapter editMandalAdapter= (EditMandalAdapter) selectedMandal.getAdapter();
                String mandalId=editMandalAdapter.getItem().*/
               /* Realm realm = Realm.getDefaultInstance();
                RealmResults<MandalModel> MandalModels = realm.where(MandalModel.class).equalTo("districtID", districtId).equalTo("isPopMandal", false).findAll();
                if (!MandalModels.isEmpty()) {
                    Intent intent = new Intent(this, SelectMandalActivity.class);
                    intent.putExtra("districtID", districtId);
                    intent.putExtra("mondalType", "normal");
                    startActivityForResult(intent, 1000);
                } else {
                    Utils.showDialog(this,
                            "Please Select District",
                            "Please Select District to load mandal data", null);
                }*/

            case R.id.selectedPop:
                if (!selectedMandal.getText().toString().equals("Click to select mandal") ) {
                    Intent intent1 = new Intent(this, SelectSIPOPActivity.class);
                    intent1.putExtra("districtID", districtId);
                    intent1.putExtra("mandalID", mandalId);
                    startActivityForResult(intent1, 1000);
                    //startActivityForResult(new Intent(this, SelectPOPActivity.class), 1000);
                } else {
                Utils.showDialog(this, "Alert",
                        "Please select Mandal", null);
                }
                break;

        }
    }

    private boolean checkDates(String from, String to) {
        boolean isValid = false;
        try {
            Date fromDate = dateFormat.parse(from);
            Date toDate = dateFormat.parse(to);
            Log.d("Compared Value", "\t" + fromDate.compareTo(toDate));
            isValid = !(fromDate.compareTo(toDate) > 0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return isValid;
    }

    private void validateFields() {
        String fromDate = searchFromDate.getText().toString();
        String toDate = searchToDate.getText().toString();
        String aadhaarText = aadhaarEditText.getText().toString();
        String cafText = cafNumberEditText.getText().toString();
        String trackId = searchTrackIdEditText.getText().toString();

        // if (lmoType.equals("LMO") || !trackId.equals("")) {
        if ((!fromDate.equals(getString(R.string.search_caf_from_date_hint))
                && !toDate.equals(getString(R.string.search_caf_to_date_hint)))) {
            if (checkDates(fromDate, toDate)) {
                if (statusSpinner.getSelectedItemPosition() >= 0) {
                    if (!aadhaarText.equals("")) {
                        if (FormValidations.isFormEditTextValid(aadhaarEditText, FormValidations.FORM_FIELDS.AADHAAR_NUMBER_ENTERPRISE)) {
                            makeSearchCAFRequest();
                        }
                    } else {
                        makeSearchCAFRequest();
                    }

                } else {
                    makeSearchCAFRequest();
                }
            } else {
                Utils.showDialog(this, "Invalid Date Selection",
                        "From date cannot be greater than To date", null);
            }

        } else if ((fromDate.equals(getString(R.string.search_caf_from_date_hint))
                && !toDate.equals(getString(R.string.search_caf_to_date_hint)))) {
            Utils.showDialog(this, "Alert",
                    "Please select valid from date", null);
        } else if ((!fromDate.equals(getString(R.string.search_caf_from_date_hint))
                && toDate.equals(getString(R.string.search_caf_to_date_hint)))) {
            Utils.showDialog(this, "Alert",
                    "Please select valid to date", null);
        } else if (statusSpinner.getSelectedItemPosition() > 0) {
            if (lmoType.equals("SI") && statusSpinner.getSelectedItemPosition() == 3) {
                if (!trackId.equals("")) {
                    makeSearchCAFRequest();
                } else if (districtSpinner.getSelectedItemPosition() > 0) {
                    if (!selectedMandal.getText().equals("Click to select mandal")) {
                        makeSearchCAFRequest();
                    } else {
                        Utils.showDialog(this, "Alert",
                                "Please select valid mandal ", null);
                    }
                } else {
                    Utils.showDialog(this, "Alert",
                            "Please select District and Mandal or Enter APSFL TrackId  ", null);
                }
            } else if (!aadhaarText.equals("")) {
                if (FormValidations.isFormEditTextValid(aadhaarEditText, FormValidations.FORM_FIELDS.AADHAAR_NUMBER_ENTERPRISE)) {
                    makeSearchCAFRequest();
                }
            } else {
                makeSearchCAFRequest();
            }
        } else if (!aadhaarText.equals("")) {
            if (FormValidations.isFormEditTextValid(aadhaarEditText, FormValidations.FORM_FIELDS.AADHAAR_NUMBER_ENTERPRISE)) {
                makeSearchCAFRequest();
            }

        } else if (!cafText.equals("")) {
            makeSearchCAFRequest();
        } else if (!trackId.equals("")) {
            makeSearchCAFRequest();
        } else if (districtSpinner.getSelectedItemPosition() > 0) {
            if (!selectedMandal.getText().equals("Click to select mandal")) {
                makeSearchCAFRequest();
            } else {
                Utils.showDialog(this, "Alert",
                        "Please select valid mandal ", null);
            }

               /* if(selectedMandal.getSelectedItemPosition() > 0){
                    if(selectedPop.getSelectedItemPosition() > 0) {
                        makeSearchCAFRequest();
                    }
                }
                else{
                    Utils.showDialog(this, "Alert",
                            "Please select valid mandal ", null);
                }*/

        } else {
            Utils.showDialog(this, "Alert",
                    "Please select any one of the fields", null);
        }
      /*}else {
            Utils.showDialog(this, "Alert",
                    "Please enter valid trackId", null);
      }*/
    }

    private void makeSearchCAFRequest() {
        try {
            Utils.showProgress(this, getString(R.string.processing_request));
            JSONObject requestData = new JSONObject();
            requestData.put("aadharNo", aadhaarEditText.getText().toString());
            String status = "";
            switch (lmoType) {

                case "LMO":
                    switch (statusSpinner.getSelectedItemPosition()) {
                        case 0:
                            status = "";
                            break;
                        case 1:
                            status = "0";
                            break;
                        case 2:
                            status = "2";
                            break;
                        case 3:
                            status = "3";
                            break;
                        case 4:
                            status = "6";
                            break;
                        case 5:
                            status = "88";
                            break;
                    }
                    break;
                case "SI":
                    switch (statusSpinner.getSelectedItemPosition()) {
                        case 0:
                            status = "";
                            break;
                        case 1:
                            status = "2";

                            break;
                        case 2:
                            status = "6";
                            break;
                        case 3:
                            status = "88";
                            break;
                    }
                    break;
                /*case 1:
                            status = "0";
                            break;*/
            }

            requestData.put("status", status);
            requestData.put("cafNo", cafNumberEditText.getText().toString());
            SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();
            requestData.put("tenantCode", sharedPreferences.getString(Constants.LMO_CODE, ""));
            requestData.put("tenantType", sharedPreferences.getString(Constants.TENANT_TYPE, ""));
            requestData.put("apsflTrackId", searchTrackIdEditText.getText().toString());
            requestData.put("effectiveFrom",
                    searchFromDate.getText().toString().equals(getString(R.string.search_caf_from_date_hint)) ?
                            "" : searchFromDate.getText().toString());
            requestData.put("effectiveTo",
                    searchToDate.getText().toString().equals(getString(R.string.search_caf_to_date_hint)) ?
                            "" : searchToDate.getText().toString());
            requestData.put("district", districtId);
            requestData.put("mandal", mandalId);
            requestData.put("popName", popId);
            Log.d("Request JSON", "\t" + requestData.toString());
            requestHandler.getSearchCAFResults(this, requestData, Constants.SEARCH_CAF_RESULTS);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void responseHandler(Object response, int requestType) {
        switch (requestType) {
            case Constants.SEARCH_CAF_RESULTS:
                Utils.cancelProgress();
                if (response != null) {
                    //noinspection unchecked
                    ArrayList<CAFResultModel> cafResults = (ArrayList<CAFResultModel>) response;
                    CAFResultsActivity.cafResultList = cafResults;
                    Intent intent = new Intent(this, CAFResultsActivity.class);
                    intent.putExtra("status", statusSpinner.getSelectedItemPosition());
                    //intent.putParcelableArrayListExtra("cafResults", cafResults);
                    startActivity(intent);
                } else {
                    Utils.showDialog(this, "No records found", "No data found for the searched criteria", null);
                }
                break;
            case Constants.GET_SILMOPOPMANDALDATA:
                Utils.cancelProgress();
                break;

            case Constants.GET_EDIT_DISTRICT:
                Utils.cancelProgress();
                List<String> districts = null;
                if (response != null) {
                    try {
                        JSONArray responseData = new JSONArray(response.toString());
                        districts = new ArrayList<String>();
                        districts.add("--Select--");
                        for (int i = 0; i < responseData.length(); i++) {
                            JSONObject eachValue = responseData.getJSONObject(i);
                            districts.add(eachValue.getString("districtName"));
                        }

                        String[] districtNames = new String[districts.size()];
                        districtNames = districts.toArray(districtNames);
                        CustomSpinnerAdapter districtSpinnerAdapter = new CustomSpinnerAdapter(this, districtNames);
                        districtSpinner.setAdapter(districtSpinnerAdapter);
                    } catch (JSONException ex) {
                        Utils.cancelProgress();
                        ex.printStackTrace();
                    }
                } else {
                    Utils.cancelProgress();
                    Utils.showDialog(this, "Unable to loading data",
                            "Please try again later", null);
                }


                //Load spinner
                break;
            case Constants.GET_SILMOPOPDATA:
                Utils.cancelProgress();
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {

            case R.id.statusSpinner:
                if (lmoType.equals("SI")) {
                    districtMandalLayout.setVisibility(View.VISIBLE);
                    // Utils.showProgress(this, getString(R.string.processing_request));
                    mandalId = ""; districtId = ""; popId = "";
                    loadDistrictData();
                    int value = statusSpinner.getSelectedItemPosition();

                    if (value == 3) {
                        poplayout.setVisibility(View.GONE);
                        //mandalheader.setText("Mandal*");
                        //distheader.setText("District*");
                    } else {
                        poplayout.setVisibility(View.VISIBLE);
                        // mandalheader.setText("Mandal");
                        // distheader.setText("District");
                    }
                    // requestHandler.getPendingEditDistrict(this,Constants.GET_EDIT_DISTRICT);

                } else {
                    districtMandalLayout.setVisibility(View.GONE);
                    districtSpinner.setSelection(0);
                }
                break;

            case R.id.districtSpinner:
                if (position > 0) {
                    DistrictModel districtModel = districtSpinnerItems.get(position);
                    districtId = districtModel.getDistrictID();
                   /* Utils.showProgress(this, "Loading  Mandals data....");
                    requestHandler.getAllSILMOMandals(this, null, districtId, Constants.GET_SILMOPOPMANDALDATA);*/

                    selectedMandal.setText("Click to select mandal");
                    selectedPop.setText("Click to select POP");
                } else {
                    selectedMandal.setText("Click to select mandal");
                    selectedPop.setText("Click to select POP");
                }
                break;
            case R.id.selectedMandal:

                break;


        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void loadDistrictData() {

        Realm realm = Realm.getDefaultInstance();
        districtSpinnerItems.clear();
        DistrictModel districtModel = new DistrictModel();
        districtModel.setDistrictID("");
        districtModel.setDistrictName("--Select--");
        districtSpinnerItems.add(districtModel);
        districtSpinnerItems.addAll(realm.where(DistrictModel.class).findAll());
        DistrictSpinnerAdapter districtSpinnerAdapter = new DistrictSpinnerAdapter(this, districtSpinnerItems);
        districtSpinner.setAdapter(districtSpinnerAdapter);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case 1000:
                    String popName = data.getStringExtra("selectedPOPName");
                    popId = data.getStringExtra("selectedPOPID");
                    if (popName.equals("")) {
                        selectedPop.setText("Click to select POP");
                    } else {
                        selectedPop.setText(popName);
                    }
                    // selectedVillageName.setText(NO_VILLAGE_SELECTED);
                    // selectedMandal.setText("Click to select Pop mandal");
                    //selectedDistrictName.setText(NO_DISTRICT_SELECTED);
                    break;
                case 1004:
                    String popMandalName = data.getStringExtra("mandalName");
                    if (popMandalName.equals("")) {
                        selectedMandal.setText("Click to select Pop mandal");
                    } else {
                        mandalId = data.getStringExtra("mandalSerialno");
                        //districtId = data.getStringExtra("districtID");
                        selectedMandal.setText(popMandalName);
                        selectedPop.setText("Click to select POP");
                        Log.d("Search", "pop mandal and district ids " + mandalId + " " + districtId);
                        //Todo.
                     /*   Utils.showProgress(this, "Loading POP data....");
                        requestHandler.getAllSILMOPOPData(this, null, districtId, mandalId, Constants.GET_SILMOPOPDATA);*/
                    }
                    break;
            }
        }
    }
}

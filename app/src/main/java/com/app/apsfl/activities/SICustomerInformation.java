package com.app.apsfl.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.app.apsfl.R;
import com.app.apsfl.adapters.DistrictSpinnerAdapter;
import com.app.apsfl.application.BaseApplication;
import com.app.apsfl.interfaces.ResponseHandler;
import com.app.apsfl.interfaces.UserActionInterface;
import com.app.apsfl.models.DistrictModel;
import com.app.apsfl.models.IptvSIDataModel;
import com.app.apsfl.models.OfflineFormModel;
import com.app.apsfl.models.SICpeInfoModel;
import com.app.apsfl.models.SICustomerInfoModel;
import com.app.apsfl.models.SIOfflineFormModel;
import com.app.apsfl.models.VillageModel;
import com.app.apsfl.utils.Constants;
import com.app.apsfl.utils.Utils;

import org.json.JSONObject;

import io.realm.Realm;
import io.realm.RealmList;

public class SICustomerInformation extends AppCompatActivity implements View.OnClickListener, UserActionInterface, ResponseHandler, AdapterView.OnItemSelectedListener {

    private Toolbar mToolbar;
    private LinearLayout nextLayout;
    private EditText organizationName, contactPerson, contactPersonMobileNo, instAddress, deviceLocation;
    private TextView instMandal, instVillage,cafNumber, trackId;
    private Spinner instDistSpinner;
    private Realm realm;
    private RealmList<DistrictModel> districtInstSpinnerItems;
    private String instDistId = "", instMandalId = "", instVillageId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sicustomer_information);
        initViews();
        setupToolBar();
        setSpinnerData();
        registerListeners();
        setData();
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
        mToolbar = (Toolbar) findViewById(R.id.toolBar);
        nextLayout = (LinearLayout) findViewById(R.id.nextLayout);
        TextView nextScreenName = (TextView) nextLayout.findViewById(R.id.nextScreenName);
        nextScreenName.setText("Provide CPE Details");
        cafNumber = (TextView) findViewById(R.id.cafNumber);
        trackId = (TextView) findViewById(R.id.trackId);
        organizationName = (EditText) findViewById(R.id.organizationName);
        contactPersonMobileNo = (EditText) findViewById(R.id.contactPersonMobileNo);
        contactPerson = (EditText) findViewById(R.id.contactPerson);
        instAddress = (EditText) findViewById(R.id.instAddress);
        deviceLocation = (EditText) findViewById(R.id.deviceLocation);

        instDistSpinner = (Spinner) findViewById(R.id.instDistSpinner);
        instDistSpinner.setEnabled(false);
        instMandal = (TextView) findViewById(R.id.instMandal);
        instVillage = (TextView) findViewById(R.id.instVillage);
        districtInstSpinnerItems = new RealmList<>();

    }

    private void setupToolBar() {
        setSupportActionBar(mToolbar);
        ActionBar mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setSpinnerData() {
        Realm realm = Realm.getDefaultInstance();
        districtInstSpinnerItems.clear();
        DistrictModel districtModel = new DistrictModel();
        districtModel.setDistrictID("");
        districtModel.setDistrictName("--Select--");
        districtInstSpinnerItems.add(districtModel);
        districtInstSpinnerItems.addAll(realm.where(DistrictModel.class).findAll());
        DistrictSpinnerAdapter districtSpinnerAdapter = new DistrictSpinnerAdapter(this, districtInstSpinnerItems);
        instDistSpinner.setAdapter(districtSpinnerAdapter);



    }

    private void registerListeners() {

        nextLayout.setOnClickListener(this);
        // instMandal.setOnClickListener(this);
        instVillage.setOnClickListener(this);
        // instDistSpinner.setOnItemSelectedListener(this);
    }

    private void setData() {
        SICustomerInfoModel customerInfoModel = realm.where(SICustomerInfoModel.class).equalTo("apsflTrackId", Constants.apsflTrackId).findFirst();
        if (customerInfoModel != null) {
            cafNumber.setText(customerInfoModel.getCafNo());
            trackId.setText(customerInfoModel.getApsflTrackId());
            organizationName.setText(customerInfoModel.getOrganizationName());
            contactPerson.setText(customerInfoModel.getNameOfContactPersonName());
            contactPersonMobileNo.setText(customerInfoModel.getNumberOfContactPerson());
            instAddress.setText(customerInfoModel.getInstAddress());
            deviceLocation.setText(customerInfoModel.getCpeDeviceLocation());
            instDistId = customerInfoModel.getSelectedInstDistId();
            instMandalId = customerInfoModel.getSelectedInstMandalId();
            instVillageId = customerInfoModel.getInstVillageId();
            DistrictModel districtModel=realm.where(DistrictModel.class).equalTo("districtID",instDistId).findFirst();
            if(districtModel != null){
                instDistSpinner.setSelection(districtInstSpinnerItems.indexOf(districtModel));
            }
            VillageModel villageModel=realm.where(VillageModel.class).equalTo("districtSerialNumber",instDistId).equalTo("mandalSerialNumber",instMandalId).findFirst();
            if(villageModel != null){
                instMandal.setText(villageModel.getMandalName());
            }
            instVillage.setText(customerInfoModel.getSelectedInstVillage());
        }
       /* cafNumber.setEnabled(false);
        trackId.setEnabled(false);
        organizationName.setEnabled(false);
        contactPerson.setEnabled(false);
        contactPersonMobileNo.setEnabled(false);
        instAddress.setEnabled(false);
        deviceLocation.setEnabled(false);*/


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.instMandal:
                //no need
                /*Intent intent = new Intent(this, SelectMandalActivity.class);
                intent.putExtra("districtID", instDistId);
                startActivityForResult(intent, 1002);*/

                break;
            case R.id.instVillage:
                Intent intent = new Intent(this,SelectVillageActivity.class);
                intent.putExtra("districtID", instDistId);
                intent.putExtra("mandalId",instMandalId);
                startActivityForResult(intent, 1002);
                break;
            case R.id.nextLayout:
                if (validateFormFields()) {
                    saveFormData();
                    startActivity(new Intent(this, SICPEInformation.class));
                }
                break;

        }
    }

    private void saveFormData() {
        try {
            SICustomerInfoModel customerInfoModel = realm.where(SICustomerInfoModel.class).equalTo("apsflTrackId", Constants.apsflTrackId).findFirst();
            realm.beginTransaction();
            customerInfoModel.setInstVillageId(instVillageId);
            customerInfoModel.setSelectedInstVillage(instVillage.getText().toString());
            realm.copyToRealmOrUpdate(customerInfoModel);
            realm.commitTransaction();
        }catch (Exception ex) {
            realm.cancelTransaction();
            // realm.close();
            Log.d("Exception in -> ", "saveFormData");
            ex.printStackTrace();
        }


    }

    @Override
    public void onBackPressed() {
        //int editCafType=Constants.cafType;
        //Constants.cafType=editCafType;
        SIOfflineFormModel siOfflineFormModel=realm.where(SIOfflineFormModel.class).equalTo("apsflTrackId",Constants.apsflTrackId).findFirst();
        if(siOfflineFormModel != null){//if user editing failed caf and online edit
            if(siOfflineFormModel.getCafOTPNumber() == null){//when user enter data upto cpe screen online
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                realm.where(SICustomerInfoModel.class).equalTo("apsflTrackId", Constants.apsflTrackId).findAll().deleteAllFromRealm();
                realm.where(SICpeInfoModel.class).equalTo("apsflTrackId", Constants.apsflTrackId).findAll().deleteAllFromRealm();
                realm.where(IptvSIDataModel.class).equalTo("apsflTrackId", Constants.apsflTrackId).findAll().deleteAllFromRealm();
                realm.commitTransaction();
                realm.close();
            }
            Constants.apsflTrackId = "";
            finish();
        }else{

            Utils.showUserConfirmationDialog(this, null,
                    getString(R.string.discard_form_message), Constants.DISCARD_FORM);
        }

    }

    @Override
    public void onDialogConfirmed(int actionType) {
        switch (actionType) {
            case Constants.DISCARD_FORM:
                Log.d("Si", "DISCARD FORM");
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                realm.where(SICustomerInfoModel.class).equalTo("apsflTrackId", Constants.apsflTrackId).findAll().deleteAllFromRealm();
                realm.where(SICpeInfoModel.class).equalTo("apsflTrackId", Constants.apsflTrackId).findAll().deleteAllFromRealm();
                realm.where(IptvSIDataModel.class).equalTo("apsflTrackId", Constants.apsflTrackId).findAll().deleteAllFromRealm();
                realm.commitTransaction();
                realm.close();
                Constants.apsflTrackId = "";
                finish();

        }
    }

    @Override
    public void responseHandler(Object response, int requestType) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position > 0) {
            DistrictModel districtModel = districtInstSpinnerItems.get(position);
            instDistId = districtModel.getDistrictID();
            // instMandal.setText("Click to select mandal");
            ///instVillage.setText("Click to select village");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {

                case 1002:
                    instVillage.setText(data.getStringExtra("villageName"));
                    instVillageId = data.getStringExtra("villageSerialNumber");
                    /*mandalID = data.getStringExtra("mandalSerialNumber");
                    districtID = data.getStringExtra("districtSerialNumber");
*/
                    break;

            }
        }
    }
    private boolean validateFormFields() {
        boolean isValid = false;
        if(instVillage.getText().equals("Select Installation Village")|| instVillage.getText().equals("")){
            isValid= false;
            Utils.showDialog(this,
                    getString(R.string.invalid_village_title),
                    getString(R.string.invalid_village_message), null);
        }else{
            isValid=true;
        }
        return  isValid;
    }
}

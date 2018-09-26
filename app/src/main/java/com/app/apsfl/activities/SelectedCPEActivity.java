package com.app.apsfl.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.app.apsfl.R;
import com.app.apsfl.adapters.SelectedCPEAdapter;
import com.app.apsfl.models.CPEDataModel;
import com.app.apsfl.models.CPEInfoModel;
import com.app.apsfl.models.IptvDataModel;
import com.app.apsfl.utils.Constants;

import io.realm.Realm;
import io.realm.RealmList;

public class SelectedCPEActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private RecyclerView cpeModelRecyclerView;
    private SelectedCPEAdapter mAdapter;
    private RealmList<IptvDataModel> iptvModelList;
    private TextView noDataTextView,onuModelName,onuModelType,onuSerialNo,onuMacId,onuPurchaseCost;
    private TextView onuInstallmentCost,installationCharge,extraCableCharge,onuModelTax,onuModelTotalCharge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_cpe);
        initViews();
        setupToolBar();
        setupRecyclerView();
        loadData();
    }

    private void initViews() {
        mToolbar = (Toolbar) findViewById(R.id.toolBar);
        onuModelName= (TextView) findViewById(R.id.onuModelName);
        onuModelType= (TextView) findViewById(R.id.onuModelType);
        onuSerialNo= (TextView) findViewById(R.id.onuSerialNo);
        onuMacId= (TextView) findViewById(R.id.onuMacId);
        onuPurchaseCost= (TextView) findViewById(R.id.onuPurchaseCost);
        onuInstallmentCost= (TextView) findViewById(R.id.onuInstallmentCost);
        installationCharge= (TextView) findViewById(R.id.installationCharge);
        extraCableCharge= (TextView) findViewById(R.id.extraCableCharge);
        onuModelTax= (TextView) findViewById(R.id.onuModelTax);
        onuModelTotalCharge= (TextView) findViewById(R.id.onuModelTotalCharge);
        cpeModelRecyclerView = (RecyclerView) findViewById(R.id.cpeModelRecyclerView);
        noDataTextView = (TextView) findViewById(R.id.noDataTextView);
        iptvModelList = new RealmList<>();
    }

    private void setupToolBar() {
        setSupportActionBar(mToolbar);
        ActionBar mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setTitle(R.string.activity_selected_cpe_title);
            mActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setupRecyclerView() {
        cpeModelRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mAdapter = new SelectedCPEAdapter(this, iptvModelList);
        cpeModelRecyclerView.setAdapter(mAdapter);
    }

    private void loadData() {
        Realm realm = Realm.getDefaultInstance();
        CPEInfoModel cpeInfoModel = realm.where(CPEInfoModel.class).equalTo("formTime", Constants.formTime).findFirst();
        Log.d("cpeInfoModel",cpeInfoModel.toString());
        onuModelName.setText(cpeInfoModel.getOnuModel());
        onuModelType.setText("ONU");
        onuSerialNo.setText(cpeInfoModel.getOnuSerialNumber());
        onuMacId.setText(cpeInfoModel.getOnuMacAddress());
        installationCharge.setText(cpeInfoModel.getOnuInstallationCharge());
        extraCableCharge.setText("0.00");
        Double onuTotalCost = 0.0;
        Double installationCost=Double.valueOf(cpeInfoModel.getOnuInstallationCharge());
        Double installationTax=Double.valueOf(cpeInfoModel.getInstallationTax());

        onuPurchaseCost.setText(cpeInfoModel.getOnuUpfrontEmount());
        onuInstallmentCost.setText("0.00");
        onuModelTax.setText(String.format("Tax : %s",(Double.valueOf(cpeInfoModel.getOnuTax()) + Double.valueOf(cpeInfoModel.getInstallationTax()))));
        onuTotalCost = Double.valueOf(cpeInfoModel.getOnuUpfrontEmount()) + Double.valueOf(cpeInfoModel.getOnuTax())+ Double.valueOf(cpeInfoModel.getInstallationTax()) ;

     /*   switch (cpeInfoModel.getOnuDevicePurchasePosition()) {
            case 1:   // Purchase
                onuPurchaseCost.setText(cpeInfoModel.getOnuPriceForInstallment());
                onuInstallmentCost.setText("0.00");
                onuModelTax.setText(String.format("Tax : %s",(Double.valueOf(cpeInfoModel.getOnuTax()) + Double.valueOf(cpeInfoModel.getInstallationTax()))));
                onuTotalCost = Double.valueOf(cpeInfoModel.getOnuPriceForInstallment()) + Double.valueOf(cpeInfoModel.getOnuTax()) ;
                break;

            case 2:   // Installment

                onuPurchaseCost.setText("0.00");
                onuInstallmentCost.setText(cpeInfoModel.getOnuPriceForInstallment());
                onuModelTax.setText(String.format("Tax : %s", cpeInfoModel.getInstallationTax()));
                onuTotalCost = 0.00;
                break;

            default:
                onuInstallmentCost.setText("0.00");
                onuPurchaseCost.setText("0.00");
                onuModelTax.setText(String.format("Tax : %s",  cpeInfoModel.getInstallationTax()));
                onuTotalCost = 0.00;
                break;
        }*/
        onuTotalCost=onuTotalCost+installationCost;
        onuModelTotalCharge.setText(onuTotalCost.toString());

        RealmList<IptvDataModel> list = new RealmList<>();
        if (cpeInfoModel != null) {
            /*Log.d("cpeInfoModel", "\t" + cpeInfoModel.toString());
            list.add(cpeInfoModel.getSelectedONUDataModel());*/
            RealmList<IptvDataModel> iptvDataModels=cpeInfoModel.getSelectedIptvList();
            iptvModelList.clear();
            iptvModelList.addAll(iptvDataModels);
            /*CPEDataModel stbmodel = cpeInfoModel.getSelectedIptvList().get(1).getSelectedSTBDataModel();

            if (stbmodel.getCpeProfileID() != -1) {
                list.add(cpeInfoModel.getSelectedIptvList().get(1).getSelectedSTBDataModel());
            }*/
            for (IptvDataModel iptvDataModel : list) {
                CPEDataModel cpeDataModel = new CPEDataModel();
                Double stbtotal = 0.0;
             /*  // installationTax= Double.valueOf(dataModel.getInstallationTaxAmount());
                // cpeDataModel.setCpeModelName(iptvDataModel.getCpeModelName());
               // cpeDataModel.setCpeLovType(iptvDataModel.getCpeLovType());
                Log.d("SelectCPEActivity","dataModel "+iptvDataModel.toString());
                switch (dataModel.getCpeLovType()) {
                    case "IPTV/Android Box":
                        switch (cpeInfoModel.getSelectedIptvList().get(1).getStbDevicePurchasePosition()) {
                            case 1:   // Purchase
                                cpeDataModel.setCpePurchaseCost(dataModel.getCpePurchaseCost());
                                cpeDataModel.setCpeInstallmentCost("0.00");
                                cpeDataModel.setCpeTax(String.format("Tax : %s", dataModel.getCpeTax()));
                                total = Double.valueOf(dataModel.getCpePurchaseCost()) + Double.valueOf(dataModel.getCpeTax());
                                break;

                            case 2:   // Installment
                                cpeDataModel.setCpeInstallmentCost(dataModel.getCpeInstallmentCost());
                                cpeDataModel.setCpePurchaseCost("0.00");
                                cpeDataModel.setCpeTax(String.format("Tax : %s", 0.00));
                                total = 0.00 ;
                                break;

                            default:
                                cpeDataModel.setCpePurchaseCost("0.00");
                                cpeDataModel.setCpeInstallmentCost("0.00");
                                cpeDataModel.setCpeTax("Tax : 0.00");
                                total = 0.00;
                                break;
                        }
                        break;
                }
                cpeDataModel.setCpeTotalCost(String.format(Locale.getDefault(), "%.2f", total ));//+ installationTax*/
                //iptvModelList.add(cpeDataModel);
            }
            if (!iptvModelList.isEmpty()) {
                cpeModelRecyclerView.setVisibility(View.VISIBLE);
                noDataTextView.setVisibility(View.GONE);
            } else {
                cpeModelRecyclerView.setVisibility(View.GONE);
               // noDataTextView.setVisibility(View.VISIBLE);
            }
            Log.d("SelectedCPEActivity", "in loadData9");
            mAdapter.updateData(iptvModelList);
        } else {
            cpeModelRecyclerView.setVisibility(View.GONE);
            noDataTextView.setVisibility(View.VISIBLE);
        }
        Log.d("SelectedCPEActivity", "in loadData10");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                return true;
        }
        return false;
    }
}

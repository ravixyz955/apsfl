package com.app.apsfl.fragments;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.app.apsfl.R;
import com.app.apsfl.activities.VOIPFeatureActivity;
import com.app.apsfl.activities.WorkOrderActivity;
import com.app.apsfl.adapters.VOIPAdapter;
import com.app.apsfl.application.BaseApplication;
import com.app.apsfl.interfaces.FragmentBackStackListener;
import com.app.apsfl.interfaces.ResponseHandler;
import com.app.apsfl.models.OfflineFormModel;
import com.app.apsfl.models.ProductModel;
import com.app.apsfl.models.VOIPFeatureNameModel;
import com.app.apsfl.models.VOIPSavedModel;
import com.app.apsfl.utils.Constants;
import com.app.apsfl.utils.RecyclerViewClickListener;
import com.app.apsfl.utils.Utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

import io.realm.Realm;
import io.realm.RealmResults;

public class VOIPFragment extends Fragment implements
        FragmentBackStackListener, ResponseHandler {

    public static final String TAG = "VOIPFragment";
    private RecyclerView voipRecyclerView;
    private VOIPAdapter voipAdapter;
    private ArrayList<VOIPFeatureNameModel> data;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView()");
        View view = inflater.inflate(R.layout.fragment_voip_service, container, false);
        initViews(view);
        setupToolBar();
        setupRecyclerView();
        loadData();
        setAdapter();
        return view;
    }

    private void initViews(View view) {
        voipRecyclerView = (RecyclerView) view.findViewById(R.id.voipRecyclerView);
        data = new ArrayList<>();
        setHasOptionsMenu(true);
    }

    private void setupToolBar() {
        ActionBar mActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setTitle(R.string.fragment_telephone_service_title);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.product_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            case R.id.product_done:
                if (areFeaturesFilled()) {
                    saveSelectedPackages();
                } else {
                    Utils.showDialog(this, "Alert", "Please select or enter all values", null);
                }
                return true;
        }
        return false;
    }

    private void setupRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        voipRecyclerView.setLayoutManager(manager);
        voipRecyclerView.addOnItemTouchListener(new RecyclerViewClickListener(getActivity(),
                new RecyclerViewClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        VOIPFeatureNameModel model = data.get(position);
                        Intent intent = new Intent(getActivity(), VOIPFeatureActivity.class);
                        intent.putExtra("position", position);
                        intent.putExtra("featureCode", model.getFeatureCode());
                        startActivityForResult(intent, 1000);
                    }
                }));
    }

    private void loadData() {
        data.clear();
        Realm realm = Realm.getDefaultInstance();
        ProductModel productModel = realm.where(ProductModel.class).equalTo("isProductChecked", true).
                equalTo("productType", "B").findFirst();
        String featureCodes = productModel.getFeatureCodes();
        if (!featureCodes.equals("")) {
            if (featureCodes.contains(",")) {
                String[] features = featureCodes.split(",");
                for (String feature : features) {

                    VOIPFeatureNameModel nameModel = new VOIPFeatureNameModel();
                    nameModel.setFeatureCode(feature);
                    nameModel.setFeatureFilled(false);
                    data.add(nameModel);
                }
            } else {
                VOIPFeatureNameModel nameModel = new VOIPFeatureNameModel();
                nameModel.setFeatureCode(featureCodes);
                nameModel.setFeatureFilled(false);
                data.add(nameModel);
            }
        }
        if (Constants.map != null && !Constants.map.isEmpty()) {
            for (VOIPFeatureNameModel model : data) {
                if (Constants.map.get(model.getFeatureCode()) != null) {
                    ArrayList<VOIPSavedModel> list = Constants.map.get(model.getFeatureCode());
                    if (!list.isEmpty()) {
                        for (VOIPSavedModel savedModel : list) {
                            if (savedModel.isFilled()) {
                                model.setFeatureFilled(true);
                                data.set(data.indexOf(model), model);
                            }
                        }
                    }
                }
            }
        }
    }

    //to check all features filled
    private boolean areFeaturesFilled() {
        boolean isFilled = true;
        if (Constants.map != null && !Constants.map.isEmpty()) {
            for (VOIPFeatureNameModel model : data) {
                if (Constants.map.get(model.getFeatureCode()) != null) {
                    ArrayList<VOIPSavedModel> list = Constants.map.get(model.getFeatureCode());
                    if (!list.isEmpty()) {
                        for (VOIPSavedModel savedModel : list) {
                            if (!savedModel.isFilled()) {
                                isFilled = false;
                                break;
                            }
                        }
                    }
                }
            }
        } else {
            isFilled = false;
        }
        return isFilled;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            int position = data.getIntExtra("position", 0);
            boolean isFilled = data.getBooleanExtra("areAllFieldsFilled", false);
            this.data.get(position).setFeatureFilled(isFilled);
            voipAdapter.notifyItemChanged(position);
        }
    }

    private void setAdapter() {
        voipAdapter = new VOIPAdapter(getActivity(), data);
        voipRecyclerView.setAdapter(voipAdapter);
    }

    private void saveSelectedPackages() {
        JSONObject packagesJSON;
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();
            OfflineFormModel offlineFormModel = realm.where(OfflineFormModel.class)
                    .equalTo("formTime", Constants.formTime).findFirst();
            JSONObject customerCAFVO;
            if (offlineFormModel == null) {
                offlineFormModel = new OfflineFormModel();
                offlineFormModel.setFormTime(Constants.formTime);
                offlineFormModel.setCafType(Constants.cafType);
                offlineFormModel.setFormCAFData("");
                offlineFormModel.setFormUploaded(false);
                offlineFormModel.setIsPaymentDataAvailable(false);
                offlineFormModel.setCpeSerialNoUsed(false);
                offlineFormModel.setCafStatus("0");
                packagesJSON = new JSONObject();
                customerCAFVO = new JSONObject();

            } else if (offlineFormModel.getFormPaymentData() == null || offlineFormModel.getFormPaymentData().isEmpty()) {
                packagesJSON = new JSONObject();
                customerCAFVO = new JSONObject();
            } else {
                packagesJSON = new JSONObject(offlineFormModel.getFormPaymentData());
                customerCAFVO = new JSONObject(packagesJSON.getJSONObject("customerCafVO").toString());
            }
            SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();
            customerCAFVO.put("loginId", sharedPreferences.getString(Constants.USER_NAME, ""));
            customerCAFVO.put("cafNo", Constants.cafNumber.equals("") ? "" : Long.parseLong(Constants.cafNumber));
            customerCAFVO.put("custId", Constants.customerID);
            customerCAFVO.put("ipAddress", Utils.getIPAddress(getActivity()));
            customerCAFVO.put("billCycle", Constants.billCycle);
            customerCAFVO.put("district", Constants.districtID);
            customerCAFVO.put("status", "0");
            customerCAFVO.put("cafStatus", offlineFormModel.getCafStatus());
            RealmResults<ProductModel> products = realm.where(ProductModel.class)
                    .equalTo("isProductChecked", true)
                    .findAll();
            JSONArray productsArray = new JSONArray();
            for (ProductModel productModel : products) {
                JSONObject productJSON = new JSONObject(productModel.getProductData());
                productsArray.put(productJSON);
            }
            String coreServiceCodes="";
            for (ProductModel productModel : products) {
                if(coreServiceCodes.equals("")){
                    coreServiceCodes=productModel.getCoreServiceCode();
                }else{

                    coreServiceCodes += "," +productModel.getCoreServiceCode();
                }
            }
            ProductModel productModel = realm.where(ProductModel.class)
                    .equalTo("productType", "B")
                    .equalTo("isProductChecked", true).findFirst();
            customerCAFVO.put("telTenantCode", productModel.getProductTenantCode());
            customerCAFVO.put("telProdCode", productModel.getProductCode());
            customerCAFVO.put("telSrvcCode", productModel.getVoipServiceCode());
            customerCAFVO.put("products", productsArray);
            customerCAFVO.put("featureCodeList", getVoipJSON());
             customerCAFVO.put("coreSrvcCode", coreServiceCodes);
            packagesJSON.put("customerCafVO", customerCAFVO);
            Log.d("Packages JSON", packagesJSON.toString());

            offlineFormModel.setFormPaymentData(packagesJSON.toString());
            realm.copyToRealmOrUpdate(offlineFormModel);
            realm.commitTransaction();
            realm.close();
            //startWorkOrderScreen();
            startCustomerCPEInfoScreen();
        } catch (Exception ex) {
            ex.printStackTrace();
            realm.cancelTransaction();
            realm.close();
            Log.d("Exception -> ", "saveSelectedPackages()");
        }
    }

    private JSONArray getVoipJSON() {
        JSONArray featuresJSON = new JSONArray();
        try {
            for (Map.Entry<String, ArrayList<VOIPSavedModel>> entry : Constants.map.entrySet()) {
                JSONObject eachFeature = new JSONObject();
                eachFeature.put("featureCode", entry.getKey());
                JSONArray paramsList = new JSONArray();
                ArrayList<VOIPSavedModel> list = entry.getValue();
                JSONObject eachParam = new JSONObject();
                String paramValue = "";
                for (VOIPSavedModel model : list) {
                    eachParam.put("paramCode", model.getParamCode());
                    if (paramValue.equals("")) {
                        paramValue = model.getParamLovName().equals("") ?
                                model.getInputFieldValue() : model.getInputSpinnerPosition().toString();
                    } else {
                        if (model.getParamLovName().equals("")) {
                            paramValue += "," + model.getInputFieldValue();
                        } else {
                            paramValue += "," + model.getInputSpinnerPosition();
                        }
                    }
                }
                eachParam.put("paramValue", paramValue);
                paramsList.put(eachParam);
                eachFeature.put("paramsList", paramsList);
                featuresJSON.put(eachFeature);
            }
            Log.d("Packages JSON", featuresJSON.toString(2));
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d("Exception in -> ", "getVoipJSON()");
        }
        return featuresJSON;
    }
   /* private void submitPackages(JSONObject requestData) {
        if (Utils.isNetworkAvailable(getActivity())) {
            Utils.showProgress(getActivity(), getString(R.string.processing_request));
            new RequestHandler().submitCAFPackages(getActivity(), this, requestData, Constants.SAVE_CAF_PACKAGES);
        } else {
            Utils.showNoNetworkDialog(getActivity());
        }
    }*/

    private void startWorkOrderScreen() {
        startActivity(new Intent(getActivity(), WorkOrderActivity.class));
    }

    private void startCustomerCPEInfoScreen() {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, new CustomerCPEInfoFragment())
                .addToBackStack(CustomerCPEInfoFragment.class.getSimpleName())
                .commit();
    }


    @Override
    public void onBackPressed() {
        getActivity().getSupportFragmentManager().popBackStack();
    }

    //not using
    @Override
    public void responseHandler(Object response, int requestType) {
        switch (requestType) {
            case Constants.SAVE_CAF_PACKAGES:
                Utils.cancelProgress();
                if (response != null) {
                    startWorkOrderScreen();
                } else {
                    Utils.showToast(getActivity(), "Request Failed. Please try again.");
                }
                break;
        }
    }

}
package com.app.apsfl.httpClient;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.app.apsfl.activities.ChangeOltDetailsActivity;
import com.app.apsfl.activities.PonChangeActivity;
import com.app.apsfl.application.BaseApplication;
import com.app.apsfl.fragments.CustomerCPEInfoFragment;
import com.app.apsfl.interfaces.RequestInterface;
import com.app.apsfl.interfaces.ResponseHandler;
import com.app.apsfl.models.CAFResultModel;
import com.app.apsfl.models.CPEDataModel;
import com.app.apsfl.models.CPEStockModel;
import com.app.apsfl.models.ChargeTaxModel;
import com.app.apsfl.models.DistrictModel;
import com.app.apsfl.models.EnterpriseCustomer;
import com.app.apsfl.models.FormSpinnerModel;
import com.app.apsfl.models.InstallationVillageModel;
import com.app.apsfl.models.L1PortModel;
import com.app.apsfl.models.L2PortModel;
import com.app.apsfl.models.L3PortModel;
import com.app.apsfl.models.MandalModel;
import com.app.apsfl.models.OltPortDetails;
import com.app.apsfl.models.POPModel;
import com.app.apsfl.models.POPOLTModel;
import com.app.apsfl.models.PaymentModel;
import com.app.apsfl.models.ProductModel;
import com.app.apsfl.models.SIPOPModel;
import com.app.apsfl.models.TaxModel;
import com.app.apsfl.models.TaxRegionModel;
import com.app.apsfl.models.VOIPFeatureModel;
import com.app.apsfl.models.VillageModel;
import com.app.apsfl.models.VpnServiceModel;
import com.app.apsfl.utils.Constants;
import com.app.apsfl.utils.Utils;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import io.realm.Realm;

public class RequestHandler implements RequestInterface {

    private static final String TAG = "RequestHandler";
    private final int TIMEOUT_INITIAL = 15000;
    private final int NO_OF_RETRIES = 2;
    private final float RETRY_MULTIPLIER = 2f;

    private final int TIMEOUT_INITIAL_POST = 30000;
    private final int NO_OF_RETRIES_POST = 0;
    private final float RETRY_MULTIPLIER_POST = 0f;

    private ResponseHandler mCallBack;
    private Context mContext;
    private String mspCodes = "";
    private ArrayList<String> regionCodes;
    private int regionPosition = 0;
    private String siLmo_region, siLmo_substnUid;
    private static JSONObject responseVal = null;


    //private String silmoDistrictId="",silmoMandalId="",silmoVillageId="";
    @Override
    public void userLogin(Context mContext, final String userName, final String userPassword,
                          final int requestType) {
        mCallBack = (ResponseHandler) mContext;
        this.mContext = mContext;
        //Toast.makeText(mContext,""+URL.LOGIN,Toast.LENGTH_LONG).show();
        VolleyRequest volleyRequest = new VolleyRequest(String.format(URL.LOGIN, userName, userPassword, Constants.version),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        try {
                            JSONObject loginResponse = new JSONObject(response.toString());
                            Log.d(TAG, "Login Success" + "\t" + statusCode + "\t" + loginResponse);
                            mCallBack.responseHandler(loginResponse, requestType);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            mCallBack.responseHandler(null, requestType);
                        }

                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "Login Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }


    public void indiviualVillage(Context mContext, final String userName, final String userPassword,
                                 final int requestType) {
        mCallBack = (ResponseHandler) mContext;
        this.mContext = mContext;
        //Toast.makeText(mContext,""+URL.LOGIN,Toast.LENGTH_LONG).show();
        VolleyRequest volleyRequest = new VolleyRequest(String.format(URL.INDVILLAGE_URL, userName, userPassword),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        try {
                            JSONArray responseData = new JSONArray(response.toString());
                            Log.d(TAG, "Login Success" + "\t" + statusCode + "\t" + responseData);
                            mCallBack.responseHandler(responseData, requestType);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            mCallBack.responseHandler(null, requestType);
                        }

                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "Login Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }


    public void bulkPayment(Context mContext, JSONObject requestData, final int requestType) {
        mCallBack = (ResponseHandler) mContext;
        this.mContext = mContext;
        //Toast.makeText(mContext,""+URL.LOGIN,Toast.LENGTH_LONG).show();
        final JSONObject responseData = new JSONObject();
        VolleyRequest volleyRequest = new VolleyRequest(Request.Method.POST, URL.BULK_URL,
                requestData.toString().replace("\\/", "/"),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        try {
                            JSONObject responseObj = new JSONObject(response.toString());
                            Log.d(TAG, "CAF Submit Success" + "\t" + statusCode + "\t" + response.toString());
                            mCallBack.responseHandler(responseObj, requestType);
                        } catch (Exception ex) {
                            mCallBack.responseHandler(response, requestType);
                            ex.printStackTrace();
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        try {
                            Log.d(TAG, "CAF Submit Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                            responseData.put("submitFailed", true);
                            mCallBack.responseHandler(responseData, requestType);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL_POST, NO_OF_RETRIES_POST, RETRY_MULTIPLIER_POST));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    public void searchBulkPayment(Context mContext, JSONObject requestData, final int requestType) {
        mCallBack = (ResponseHandler) mContext;
        this.mContext = mContext;
        //Toast.makeText(mContext,""+URL.LOGIN,Toast.LENGTH_LONG).show();
        String from = null, tenantCode = null;
        try {
            from = requestData.getString("effectiveDate");
            tenantCode = requestData.getString("lmoCode");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String finalURL = String.format(URL.SEARCH_BULK_MONTLY_PAYMENT, from, tenantCode);
        final JSONObject responseData = new JSONObject();
        VolleyRequest volleyRequest = new VolleyRequest(Request.Method.POST, finalURL,
                requestData.toString().replace("\\/", "/"),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        try {
                            JSONObject responseObj = new JSONObject(response.toString());
                            Log.d(TAG, "Search CAF Submit Success" + "\t" + statusCode + "\t" + response.toString());
                            mCallBack.responseHandler(responseObj, requestType);
                            //responseVal = responseObj;.
                        } catch (Exception ex) {
                            mCallBack.responseHandler(response, requestType);
                            //responseVal = (JSONObject) response;
                            ex.printStackTrace();
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        try {
                            Log.d(TAG, "Search CAF Submit Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                            responseData.put("submitFailed", true);
                            mCallBack.responseHandler(responseData, requestType);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL_POST, NO_OF_RETRIES_POST, RETRY_MULTIPLIER_POST));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    public void bulkRevenueSharingRequest(Context mContext, JSONObject requestData, final int requestType) {
        final ResponseHandler mCallBack = (ResponseHandler) mContext;
        this.mContext = mContext;
        //Toast.makeText(mContext,""+URL.LOGIN,Toast.LENGTH_LONG).show();
        String year = null, month = null, lmocode = null;
        try {
            year = requestData.getString("year");
            month = requestData.getString("month");
            lmocode = requestData.getString("lmocode");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String finalURL = String.format(URL.BULK_REVENUE_URL, year, month, lmocode);
        final JSONObject responseData = new JSONObject();
        VolleyRequest volleyRequest = new VolleyRequest(Request.Method.GET, finalURL,
                requestData.toString().replace("\\/", "/"),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        try {
                            JSONObject responseObj = new JSONObject(response.toString());
                            Log.d(TAG, "Revenue Sharing Success" + "\t" + statusCode + "\t" + response.toString());
                           /* String customerID = new JSONObject(response.toString()).getString("statusMessage");
                            responseData.put("customerID", customerID);*/
                            mCallBack.responseHandler(responseObj, requestType);
                        } catch (Exception ex) {
                            mCallBack.responseHandler(response, requestType);
                            ex.printStackTrace();
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        try {
                            Log.d(TAG, "CAF Submit Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                            responseData.put("submitFailed", true);
                            mCallBack.responseHandler(responseData, requestType);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL_POST, NO_OF_RETRIES_POST, RETRY_MULTIPLIER_POST));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }


    public void bulkPaymentDone(Context mContext, JSONObject requestData, final int requestType) {
        mCallBack = (ResponseHandler) mContext;
        this.mContext = mContext;
        //Toast.makeText(mContext,""+URL.LOGIN,Toast.LENGTH_LONG).show();
        final JSONObject responseData = new JSONObject();
        VolleyRequest volleyRequest = new VolleyRequest(Request.Method.POST, URL.BULK_MONTHLY_PAY_URL,
                requestData.toString().replace("\\/", "/"),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        try {
                            JSONObject responseObj = new JSONObject(response.toString());
                            Log.d(TAG, "CAF Submit Success" + "\t" + statusCode + "\t" + response.toString());
                           /* String customerID = new JSONObject(response.toString()).getString("statusMessage");
                            responseData.put("customerID", customerID);*/
                            mCallBack.responseHandler(responseObj, requestType);
                        } catch (Exception ex) {
                            mCallBack.responseHandler(response, requestType);
                            ex.printStackTrace();
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        try {
                            Log.d(TAG, "CAF Submit Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                            responseData.put("submitFailed", true);
                            mCallBack.responseHandler(responseData, requestType);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(900000, NO_OF_RETRIES_POST, RETRY_MULTIPLIER_POST));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }


    @Override
    public void getMasterData(Context mContext, int requestType) {
        regionCodes = new ArrayList<>();
        SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();
        regionCodes.addAll(Arrays.asList(sharedPreferences.getString(Constants.LMO_REGIONS_LIST, "").split(",")));
        Set<String> hs = new HashSet<>();
        hs.addAll(regionCodes);
        regionCodes.clear();
        regionCodes.addAll(hs);
        if (!sharedPreferences.getString(Constants.TENANT_TYPE, "").equals("LMO")) {
            //For SILMO
            getAllDistricts(mContext, requestType);
        } else {
            getAllVillages(mContext, requestType);
        }
    }

    public void getAllVillages(final Context mContext, final int requestType) {
        mCallBack = (ResponseHandler) mContext;
        this.mContext = mContext;
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }

        final SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();
        final SharedPreferences villageModelsharedPreferences = mContext.getSharedPreferences("villageModels", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = villageModelsharedPreferences.edit();
        final Gson gson = new Gson();

        final VolleyRequest volleyRequest = new VolleyRequest(
                String.format(URL.GET_ALL_VILLAGES, sharedPreferences.getString(Constants.SUB_STATION_CODES, ""), sharedPreferences.getString(Constants.LMO_CODE, "")),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        String l = String.format(URL.GET_ALL_VILLAGES, sharedPreferences.getString(Constants.SUB_STATION_CODES, ""), sharedPreferences.getString(Constants.LMO_CODE, ""));
                        Log.d("ddd", "" + l);
                        Realm realm = Realm.getDefaultInstance();

                        try {
                            if (response != null) {
                                Log.d(TAG, "Village Success" + "\t" + statusCode);
                                JSONArray responseData = new JSONArray(response.toString());
                                List<VillageModel> villageModelslist = new ArrayList<VillageModel>();
                                realm.beginTransaction();
                                for (int i = 0; i < responseData.length(); i++) {
                                    //realm.beginTransaction();
                                    VillageModel villageModel = new VillageModel();
                                    JSONObject eachVillage = responseData.getJSONObject(i);
                                    villageModel.setVillageCompositeKey(eachVillage.getString("districtUid") + eachVillage.getString("mandalSlno") + eachVillage.getString("villageSlno"));
                                    villageModel.setVillageSerialNumber(eachVillage.getString("villageSlno"));
                                    villageModel.setVillageName(eachVillage.getString("villageName"));
                                    villageModel.setMandalSerialNumber(eachVillage.getString("mandalSlno"));
                                    villageModel.setMandalName(eachVillage.getString("mandalName"));
                                    villageModel.setDistrictSerialNumber(eachVillage.getString("districtUid"));
                                    villageModel.setDistrictName(eachVillage.getString("districtName"));
                                    villageModel.setSubStationUID(eachVillage.getString("substnUid"));
                                    villageModel.setVillageChecked(false);
                                    villageModelslist.add(villageModel);
                                    realm.copyToRealmOrUpdate(villageModel);
                                    //realm.commitTransaction();
                                }
                                String json = gson.toJson(villageModelslist);
                                editor.putString("villageModelslist", json);
                                editor.commit();
                                int listSize = villageModelslist.size();
                                Log.i(TAG, "onResponse: " + listSize);
                                realm.commitTransaction();
                                realm.close();
                                getAllIndividualProducts(mContext, requestType);
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            realm.cancelTransaction();
                            realm.close();
                            mCallBack.responseHandler(null, requestType);
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "Village Data Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }


    private void getAllIndividualProducts(final Context mContext, final int requestType) {
        mCallBack = (ResponseHandler) mContext;
        final SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();

        VolleyRequest volleyRequest = new VolleyRequest(
                String.format(URL.GET_ALL_PACKAGES, sharedPreferences.getString("lmoCode", ""), "INDIVIDUAL", regionCodes.get(regionPosition)),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        Realm realm = Realm.getDefaultInstance();
                        try {
                            JSONArray productsArray = new JSONArray(response.toString());
                            Log.d(TAG, "Individual Products" + "\t" + statusCode);
                            realm.beginTransaction();
                            for (int i = 0; i < productsArray.length(); i++) {
                                JSONObject eachProduct = productsArray.getJSONObject(i);
                                ProductModel model = new ProductModel();
                                model.setProductName(eachProduct.getString("prodname").trim());
                                model.setProductDate(eachProduct.getString("effectivefrom"));
                                model.setProductCode(eachProduct.getString("prodcode"));
                                model.setProductTenantName(eachProduct.getString("tenantname"));
                                model.setProductTenantCode(eachProduct.getString("tenantcode"));
                                model.setProductUniqueKey(model.getProductCode() + model.getProductTenantCode() +
                                        eachProduct.getString("agruniqueid"));
                                model.setProductType(eachProduct.getString("prodType"));
                                JSONArray productCharges = eachProduct.getJSONArray("chargeTypeList");
                                for (int k = 0; k < productCharges.length(); k++) {
                                    JSONObject eachCharge = productCharges.getJSONObject(k);
                                    switch (eachCharge.getString("chargeType")) {
                                        case "Recurring":
                                            model.setProductRecurringCharge(eachCharge.getString("chargeAmt"));
                                            model.setProductRecurringTax(eachCharge.getString("taxAmt"));
                                            break;

                                        case "Activation":
                                            model.setProductActivationCharge(eachCharge.getString("chargeAmt"));
                                            model.setProductActivationTax(eachCharge.getString("taxAmt"));
                                            break;

                                        case "Deposit":
                                            model.setProductSecurityCharge(eachCharge.getString("chargeAmt"));
                                            model.setProductSecurityTax(eachCharge.getString("taxAmt"));
                                            break;
                                    }
                                }
                                model.setProductLockInPeriod(
                                        String.format("%s months", eachProduct.getString("lockInPeriod")));
                                model.setProductTax(
                                        String.format(Locale.getDefault(), "%.2f", eachProduct.getDouble("taxamt")));
                                model.setProductTotalCharge(
                                        String.format(Locale.getDefault(), "%.2f", eachProduct.getDouble("totalCharge")));
                                String featureCodes = "", voipServiceCode = "", coreServiceCode = "";
                                JSONArray servicesList = eachProduct.getJSONArray("servicesList");
                                for (int j = 0; j < servicesList.length(); j++) {
                                    if (servicesList.getJSONObject(j).getString("coreServiceCode").equals("VOIP") &&
                                            !servicesList.getJSONObject(j).getString("featureCodes").equals("")) {
                                        featureCodes = servicesList.getJSONObject(j).getString("featureCodes");
                                        voipServiceCode = servicesList.getJSONObject(j).getString("serviceCode");
                                    }
                                    if (coreServiceCode.equals("")) {
                                        coreServiceCode = servicesList.getJSONObject(j).getString("coreServiceCode");
                                    } else {

                                        coreServiceCode += "," + servicesList.getJSONObject(j).getString("coreServiceCode");
                                    }

                                }
                                if (mspCodes.equals("")) {
                                    mspCodes = eachProduct.getString("mspCode");
                                } else {
                                    if (!mspCodes.contains(eachProduct.getString("mspCode"))) {
                                        mspCodes += "," + eachProduct.getString("mspCode");
                                    }
                                }
                                model.setFeatureCodes(featureCodes);
                                model.setVoipServiceCode(voipServiceCode);
                                model.setCoreServiceCode(coreServiceCode);
                                model.setProductData(eachProduct.toString());
                                model.setIndividualProduct(true);
                                model.setProductCheckBoxVisible(true);
                                model.setProductChecked(false);
                                realm.copyToRealmOrUpdate(model);
                            }
                            realm.commitTransaction();
                            realm.close();
                            if (regionPosition < regionCodes.size() - 1) {
                                regionPosition++;
                                getAllIndividualProducts(mContext, requestType);
                            } else {
                                regionPosition = 0;
                                getAllEnterpriseProducts(mContext, requestType);
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            realm.cancelTransaction();
                            realm.close();
                            mCallBack.responseHandler(null, requestType);
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "Products Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    private void getAllEnterpriseProducts(final Context mContext, final int requestType) {
        mCallBack = (ResponseHandler) mContext;
        SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();
        VolleyRequest volleyRequest = new VolleyRequest(
                String.format(URL.GET_ALL_PACKAGES, sharedPreferences.getString("lmoCode", ""), "ENTERPRISE", regionCodes.get(regionPosition)),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        Realm realm = Realm.getDefaultInstance();
                        try {
                            JSONArray productsArray = new JSONArray(response.toString());
                            Log.d(TAG, "Enterprise Products" + "\t" + statusCode);
                            realm.beginTransaction();
                            for (int i = 0; i < productsArray.length(); i++) {
                                JSONObject eachProduct = productsArray.getJSONObject(i);
                                ProductModel model = new ProductModel();
                                model.setProductName(eachProduct.getString("prodname").trim());
                                model.setProductDate(eachProduct.getString("effectivefrom"));
                                model.setProductCode(eachProduct.getString("prodcode"));
                                model.setProductTenantName(eachProduct.getString("tenantname"));
                                model.setProductTenantCode(eachProduct.getString("tenantcode"));
                                model.setProductUniqueKey(model.getProductCode() + model.getProductTenantCode() +
                                        eachProduct.getString("agruniqueid"));
                                model.setProductType(eachProduct.getString("prodType"));
                                JSONArray productCharges = eachProduct.getJSONArray("chargeTypeList");
                                for (int k = 0; k < productCharges.length(); k++) {
                                    JSONObject eachCharge = productCharges.getJSONObject(k);
                                    switch (eachCharge.getString("chargeType")) {
                                        case "Recurring":
                                            model.setProductRecurringCharge(eachCharge.getString("chargeAmt"));
                                            model.setProductRecurringTax(eachCharge.getString("taxAmt"));
                                            break;

                                        case "Activation":
                                            model.setProductActivationCharge(eachCharge.getString("chargeAmt"));
                                            model.setProductActivationTax(eachCharge.getString("taxAmt"));
                                            break;

                                        case "Deposit":
                                            model.setProductSecurityCharge(eachCharge.getString("chargeAmt"));
                                            model.setProductSecurityTax(eachCharge.getString("taxAmt"));
                                            break;
                                    }
                                }
                                model.setProductLockInPeriod(
                                        String.format("%s months", eachProduct.getString("lockInPeriod")));
                                model.setProductTax(
                                        String.format(Locale.getDefault(), "%.2f", eachProduct.getDouble("taxamt")));
                                model.setProductTotalCharge(
                                        String.format(Locale.getDefault(), "%.2f", eachProduct.getDouble("totalCharge")));

                                String featureCodes = "", voipServiceCode = "", coreServiceCode = "", serviceCode = "";
                                JSONArray servicesList = eachProduct.getJSONArray("servicesList");
                                for (int j = 0; j < servicesList.length(); j++) {
                                    if (servicesList.getJSONObject(j).getString("coreServiceCode").equals("VOIP") &&
                                            !servicesList.getJSONObject(j).getString("featureCodes").equals("")) {
                                        featureCodes = servicesList.getJSONObject(j).getString("featureCodes");
                                        voipServiceCode = servicesList.getJSONObject(j).getString("serviceCode");
                                    }
                                    if (coreServiceCode.equals("")) {
                                        coreServiceCode = servicesList.getJSONObject(j).getString("coreServiceCode");
                                    } else {

                                        coreServiceCode += "," + servicesList.getJSONObject(j).getString("coreServiceCode");
                                    }
                                    if (serviceCode.equals("")) {
                                        serviceCode = servicesList.getJSONObject(j).getString("serviceCode");
                                    } else {

                                        serviceCode += "," + servicesList.getJSONObject(j).getString("serviceCode");
                                    }
                                }
                                if (!mspCodes.contains(eachProduct.getString("mspCode"))) {
                                    mspCodes += "," + eachProduct.getString("mspCode");
                                }
                                model.setFeatureCodes(featureCodes);
                                model.setVoipServiceCode(voipServiceCode);
                                model.setCoreServiceCode(coreServiceCode);
                                model.setServiceCode(serviceCode);
                                model.setProductData(eachProduct.toString());
                                model.setIndividualProduct(false);
                                model.setProductCheckBoxVisible(true);
                                model.setProductChecked(false);

                                realm.copyToRealmOrUpdate(model);
                            }
                            realm.commitTransaction();
                            realm.close();
                            if (regionPosition < regionCodes.size() - 1) {
                                regionPosition++;
                                getAllEnterpriseProducts(mContext, requestType);
                            } else {
                                regionPosition = 0;
                                getAllEnterpriseCustomers(mContext, requestType);
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            realm.cancelTransaction();
                            realm.close();
                            mCallBack.responseHandler(null, requestType);
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "Products Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }


    private void getAllEnterpriseCustomers(final Context mContext, final int requestType) {
        mCallBack = (ResponseHandler) mContext;
        this.mContext = mContext;
        SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();
        VolleyRequest volleyRequest = new VolleyRequest(
                String.format(URL.GET_ALL_ENTERPRISE_CUSTOMERS, sharedPreferences.getString("lmoCode", "")),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        Realm realm = Realm.getDefaultInstance();
                        try {
                            if (response != null) {
                                JSONArray responseData = new JSONArray(response.toString());
                                Log.d(TAG, "EnterpriseCustomers Success" + "\t" + statusCode);
                                for (int i = 0; i < responseData.length(); i++) {
                                    JSONObject eachCustomer = responseData.getJSONObject(i);
                                    realm.beginTransaction();
                                    EnterpriseCustomer customer = new EnterpriseCustomer();
                                    customer.setCustomerID(eachCustomer.getString("custId"));
                                    customer.setCustomerName(eachCustomer.getString("custName"));
                                    customer.setCustomerMobileNumber(eachCustomer.getString("pocMob1"));
                                    customer.setEnterPriseCustomerType(eachCustomer.getString("custType"));
                                    customer.setPaymentCustomerId(eachCustomer.getString("custUid"));

                                    customer.setRegisterNo(eachCustomer.getString("regnCode"));
                                    customer.setOrganizationName(eachCustomer.getString("custName"));
                                    customer.setContactpersionName(eachCustomer.getString("pocName"));
                                    customer.setDateOfIncorporation(eachCustomer.getString("dateofinc"));
                                    customer.setBillFrequency(eachCustomer.getString("billfreqLov"));
                                    customer.setAddress1(eachCustomer.getString("address1"));
                                    customer.setAddress2(eachCustomer.getString("address2"));
                                    customer.setLocality(eachCustomer.getString("locality"));
                                    customer.setEmail(eachCustomer.getString("email1"));
                                    customer.setCustomerChecked(false);
                                    realm.copyToRealmOrUpdate(customer);
                                    realm.commitTransaction();
                                }
                                realm.close();
                                getAllLOVItems(mContext, requestType);
                            } else {
                                mCallBack.responseHandler(null, requestType);
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            realm.cancelTransaction();
                            realm.close();
                            mCallBack.responseHandler(null, requestType);
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "EnterpriseCustomers Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    private void getAllLOVItems(final Context mContext, final int requestType) {
        mCallBack = (ResponseHandler) mContext;
        this.mContext = mContext;
        VolleyRequest volleyRequest = new VolleyRequest(URL.GET_ALL_LOVS,
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        Realm realm = Realm.getDefaultInstance();
                        try {
                            if (response != null) {
                                JSONObject responseData = new JSONObject(response.toString());
                                Log.d(TAG, "LOV Data Success" + "\t" + responseData.toString());
                                JSONArray billFrequency = responseData.getJSONArray("BILL FREQUENCY");
                                JSONArray channels = responseData.getJSONArray("SALES CHANNELS");
                                JSONArray segments = responseData.getJSONArray("CUSTOMER SEGMENTS");
                                JSONArray titles = responseData.getJSONArray("TITLES");
                                JSONArray vmAddress = responseData.getJSONArray("VMADDRESS");
                                JSONArray hotLinePriority = responseData.getJSONArray("HotlinePriority");

                                String billFrequencies = "";
                                for (int i = 0; i < billFrequency.length(); i++) {
                                    if (billFrequencies.equals("")) {
                                        billFrequencies += "--Select--" + "," + billFrequency.getString(i);
                                    } else {
                                        billFrequencies += "," + billFrequency.getString(i);
                                    }
                                }

                                String customerSalesChannels = "";
                                for (int i = 0; i < channels.length(); i++) {
                                    if (customerSalesChannels.equals("")) {
                                        customerSalesChannels += "--Select--" + "," + channels.getString(i);
                                    } else {
                                        customerSalesChannels += "," + channels.getString(i);
                                    }
                                }

                                String customerSegments = "";
                                for (int i = 0; i < segments.length(); i++) {
                                    if (customerSegments.equals("")) {
                                        customerSegments += "--Select--" + "," + segments.getString(i);
                                    } else {
                                        customerSegments += "," + segments.getString(i);
                                    }
                                }
                                String customerTitles = "";
                                for (int i = 0; i < titles.length(); i++) {
                                    if (customerTitles.equals("")) {
                                        customerTitles += "--Select--" + "," + titles.getString(i);
                                    } else {
                                        customerTitles += "," + titles.getString(i);
                                    }
                                }

                                String vmAddresses = "";
                                for (int i = 0; i < vmAddress.length(); i++) {
                                    if (vmAddresses.equals("")) {
                                        vmAddresses += "--Select--" + "," + vmAddress.getString(i);
                                    } else {
                                        vmAddresses += "," + vmAddress.getString(i);
                                    }
                                }

                                String hotLinePriorities = "";
                                for (int i = 0; i < hotLinePriority.length(); i++) {
                                    if (hotLinePriorities.equals("")) {
                                        hotLinePriorities += "--Select--" + "," + hotLinePriority.getString(i);
                                    } else {
                                        hotLinePriorities += "," + hotLinePriority.getString(i);
                                    }
                                }
                                realm.beginTransaction();
                                FormSpinnerModel model = new FormSpinnerModel();
                                model.setCustomerTitles(customerTitles);
                                model.setCustomerSegments(customerSegments);
                                model.setCustomerChannels(customerSalesChannels);
                                model.setBillFrequencies(billFrequencies);
                                model.setVmAddresses(vmAddresses);
                                model.setHotLinePriorities(hotLinePriorities);
                                realm.copyToRealmOrUpdate(model);
                                realm.commitTransaction();
                                realm.close();
                                SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();
                                if (!sharedPreferences.getString(Constants.TENANT_TYPE, "").equals("LMO")) {
                                    //For SILMO
                                    getAllTaxRegions(mContext, requestType);
                                } else {
                                    getAllPOPData(mContext, requestType);
                                }

                            }
                        } catch (JSONException ex) {
                            realm.cancelTransaction();
                            realm.close();
                            mCallBack.responseHandler(null, requestType);
                            ex.printStackTrace();
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "LOV Data Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    private void getAllDistricts(final Context mContext, final int requestType) {
        mCallBack = (ResponseHandler) mContext;
        this.mContext = mContext;
        VolleyRequest volleyRequest = new VolleyRequest(URL.GET_ALL_DISTRICTS,
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        try {
                            if (response != null) {
                                JSONArray responseData = new JSONArray(response.toString());
                                Log.d(TAG, "District Success" + "\t" + statusCode);
                                Realm realm = Realm.getDefaultInstance();
                                realm.beginTransaction();
                                for (int i = 0; i < responseData.length(); i++) {
                                    DistrictModel districtModel = new DistrictModel();
                                    JSONObject eachDistrict = responseData.getJSONObject(i);
                                    districtModel.setDistrictID(eachDistrict.getString("districtUid"));
                                    districtModel.setDistrictName(eachDistrict.getString("districtName"));
                                    realm.copyToRealmOrUpdate(districtModel);
                                }
                                realm.commitTransaction();
                                realm.close();
                                // getAllEnterpriseCustomers(mContext, requestType);
                                getAllLOVItems(mContext, requestType);
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            mCallBack.responseHandler(null, requestType);
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "District Data Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    public void getAllSILMOMandals(Context mContext, final Fragment mFragment, String districtId, final int requestType) {
        if (mFragment == null) {
            mCallBack = (ResponseHandler) mContext;
        } else {
            mCallBack = (ResponseHandler) mFragment;
        }
        VolleyRequest volleyRequest = new VolleyRequest(String.format(URL.GET_ALL_SILMO_MANDALS, districtId),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        Realm realm = Realm.getDefaultInstance();
                        try {
                            if (response != null) {
                                Log.d(TAG, "Mandal Success" + "\t" + statusCode);
                                JSONArray responseData = new JSONArray(response.toString());
                                realm.beginTransaction();
                                realm.where(MandalModel.class).findAll().deleteAllFromRealm();
                                realm.commitTransaction();
                                realm.beginTransaction();
                                for (int i = 0; i < responseData.length(); i++) {
                                    MandalModel mandalModel = new MandalModel();
                                    JSONObject eachMandal = responseData.getJSONObject(i);
                                    mandalModel.setMandalID(eachMandal.getInt("mandalUid"));
                                    mandalModel.setMandalSerialNumber(eachMandal.getString("mandalSlno"));
                                    mandalModel.setMandalName(eachMandal.getString("mandalName"));
                                    mandalModel.setDistrictID(eachMandal.getString("districtUid"));
                                    mandalModel.setMandalChecked(false);
                                    //SILMOPOPMANDALDATA
                                    if (requestType == 122) {
                                        mandalModel.setPopMandal(true);
                                    } else {
                                        //installation mandal data
                                        mandalModel.setPopMandal(false);
                                    }
                                    realm.copyToRealmOrUpdate(mandalModel);
                                }
                                realm.commitTransaction();
                                realm.close();
                                Log.d("Mandal data", response.toString());
                                mCallBack.responseHandler("Success", requestType);
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            realm.cancelTransaction();
                            realm.close();
                            Log.d("Mandal data", "Error in mondal data");
                            mCallBack.responseHandler(null, requestType);
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "Mandal Data Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }


    private void getAllPOPData(final Context mContext, final int requestType) {
        mCallBack = (ResponseHandler) mContext;
        this.mContext = mContext;
        SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();
        VolleyRequest volleyRequest = new VolleyRequest(
                String.format(URL.GET_ALL_POP_NAMES, sharedPreferences.getString(Constants.SUB_STATION_CODES, "")),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        Realm realm = Realm.getDefaultInstance();
                        try {
                            if (response != null) {
                                Log.d(TAG, "POP Data Success" + "\t" + statusCode);
                                JSONArray responseData = new JSONArray(response.toString());
                                realm.beginTransaction();
                                for (int i = 0; i < responseData.length(); i++) {
                                    JSONObject eachPOPObject = responseData.getJSONObject(i);
                                    POPModel popModel = new POPModel();
                                    popModel.setPopID(eachPOPObject.getString("substnUid"));
                                    popModel.setPopName(eachPOPObject.getString("substnName").trim());
                                    popModel.setPOPChecked(false);
                                    realm.copyToRealmOrUpdate(popModel);
                                }
                                realm.commitTransaction();
                                realm.close();
                                getAllOLTData(mContext, requestType);
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            realm.cancelTransaction();
                            realm.close();
                            mCallBack.responseHandler(null, requestType);
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "POP Data Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    private void getAllOLTData(final Context mContext, final int requestType) {
        mCallBack = (ResponseHandler) mContext;
        this.mContext = mContext;
        SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();
        VolleyRequest volleyRequest = new VolleyRequest(String.format(URL.GET_ALL_OLT_DATA, sharedPreferences.getString(Constants.SUB_STATION_CODES, "")),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        Realm realm = Realm.getDefaultInstance();
                        try {
                            if (response != null) {
                                Log.d(TAG, "OLT Data Success" + "\t" + statusCode);

                                JSONArray responseData = new JSONArray(response.toString());
                                realm.beginTransaction();
                                for (int i = 0; i < responseData.length(); i++) {
                                    JSONObject eachOLTObject = responseData.getJSONObject(i);
                                    POPOLTModel oltModel = new POPOLTModel();
                                    oltModel.setPopOLTID(eachOLTObject.getString("popId"));
                                    oltModel.setPopID(eachOLTObject.getString("popSubstnuid"));
                                    oltModel.setPopName(eachOLTObject.getString("popName"));
                                    oltModel.setPopOLTSerialNumber(eachOLTObject.getString("popOltSerialno"));
                                    oltModel.setPopLabelNumber(eachOLTObject.getString("pop_oltlabelno"));
                                    realm.copyToRealmOrUpdate(oltModel);
                                }
                                realm.commitTransaction();
                                realm.close();
                                getAllCPEModels(mContext, requestType);
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            realm.cancelTransaction();
                            realm.close();
                            mCallBack.responseHandler(null, requestType);

                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "OLT Data Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    private void getAllCPEModels(final Context mContext, final int requestType) {
        mCallBack = (ResponseHandler) mContext;
        this.mContext = mContext;
        SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();

        VolleyRequest volleyRequest = new VolleyRequest(String.format(URL.GET_ALL_CPE_MODELS, regionCodes.get(regionPosition)),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        Realm realm = Realm.getDefaultInstance();
                        try {
                            if (response != null) {
                                Log.d(TAG, "CPE Models Success" + "\t" + statusCode);
                                JSONArray responseData = new JSONArray(response.toString());
                                realm.beginTransaction();
                                for (int i = 0; i < responseData.length(); i++) {
                                    CPEDataModel model = new CPEDataModel();
                                    JSONObject eachCPE = responseData.getJSONObject(i);
                                    JSONObject cpeModal = eachCPE.getJSONObject("cpeModal");
                                    model.setCpeProfileIDcpeInstallmentCount(cpeModal.getInt("profileId") + eachCPE.getString("emiCount"));
                                    model.setCpeProfileID(cpeModal.getInt("profileId"));
                                    model.setCpeModelName(cpeModal.getString("cpeModel"));
                                    model.setCpeProfileName(cpeModal.getString("cpeProfileName"));
                                    model.setInstallationTaxAmount(String.format(Locale.getDefault(), "%.2f",
                                            eachCPE.getDouble("installationTaxAmount")));
                                    Log.d("installationTaxAmount", String.format(Locale.getDefault(), "%.2f",
                                            eachCPE.getDouble("installationTaxAmount")));
                                    model.setCpeModelDetails(cpeModal.getString("cpeModelDetails"));
                                    model.setCpeLovType(cpeModal.getString("cpetypeLov"));
                                    model.setCpeInstallmentCount(eachCPE.getString("emiCount"));
                                    model.setCpeInstallmentCost(eachCPE.getString("emiAmount"));
                                    model.setCpePurchaseCost(
                                            String.format(Locale.getDefault(), "%.2f", eachCPE.getDouble("custCost")));
                                    model.setCpeRentalCost(
                                            String.format(Locale.getDefault(), "%.2f", eachCPE.getDouble("custRent")));
                                    model.setCpeInstallationCost(
                                            String.format(Locale.getDefault(), "%.2f", eachCPE.getDouble("instcharges")));
                                    model.setCpeTax(String.format(Locale.getDefault(), "%.2f", eachCPE.getDouble("onuTaxAmount")));
                                    model.setUpFrontCharges(eachCPE.getString("upFrontCharges"));
                                    realm.copyToRealmOrUpdate(model);
                                }
                                realm.commitTransaction();
                                realm.close();
                                if (regionPosition < regionCodes.size() - 1) {
                                    regionPosition++;
                                    getAllCPEModels(mContext, requestType);
                                } else {
                                    regionPosition = 0;
                                    getAllTaxRegions(mContext, requestType);
                                }

                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            realm.cancelTransaction();
                            realm.close();
                            mCallBack.responseHandler(null, requestType);
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "CPE Models Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    private void getAllTaxRegions(final Context mContext, final int requestType) {
        mCallBack = (ResponseHandler) mContext;
        this.mContext = mContext;
        VolleyRequest volleyRequest = new VolleyRequest(URL.GET_ALL_TAX_REGIONS,
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        Realm realm = Realm.getDefaultInstance();
                        try {
                            if (response != null) {
                                Log.d(TAG, "Tax Regions Success" + "\t" + statusCode);
                                JSONArray taxRegions = new JSONArray(response.toString());
                                realm.beginTransaction();
                                for (int i = 0; i < taxRegions.length(); i++) {
                                    JSONObject eachTaxRegion = taxRegions.getJSONObject(i);
                                    TaxRegionModel taxRegionModel = new TaxRegionModel();
                                    taxRegionModel.setPinCode(eachTaxRegion.getString("pinCode"));
                                    taxRegionModel.setRegionCode(eachTaxRegion.getString("regionCode"));
                                    taxRegionModel.setEffectiveFrom(eachTaxRegion.getDouble("effectiveFrom"));
                                    taxRegionModel.setEffectiveTo(eachTaxRegion.getDouble("effectiveTo"));
                                    realm.copyToRealmOrUpdate(taxRegionModel);
                                }
                                realm.commitTransaction();
                                realm.close();
                                //Skipped two service calls
                                // getAllChargeTaxes(mContext, requestType);//and getAllTaxes(mContext, requestType);
                                getAllFeatureParams(mContext, requestType);
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            realm.cancelTransaction();
                            realm.close();
                            mCallBack.responseHandler(null, requestType);
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "Tax Regions Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    //not calling
    private void getAllChargeTaxes(final Context mContext, final int requestType) {
        mCallBack = (ResponseHandler) mContext;
        this.mContext = mContext;
        VolleyRequest volleyRequest = new VolleyRequest(URL.GET_ALL_CHARGE_TAXES,
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        Realm realm = Realm.getDefaultInstance();
                        try {
                            if (response != null) {
                                Log.d(TAG, "Charge Taxes Success" + "\t" + statusCode);
                                JSONArray chargeTaxes = new JSONArray(response.toString());
                                realm.beginTransaction();
                                for (int i = 0; i < chargeTaxes.length(); i++) {
                                    JSONObject eachChargeTax = chargeTaxes.getJSONObject(i);
                                    ChargeTaxModel chargeTaxModel = new ChargeTaxModel();
                                    chargeTaxModel.setChargeCode(eachChargeTax.getString("chargeCode"));
                                    chargeTaxModel.setTaxCode(eachChargeTax.getString("taxCode"));
                                    realm.copyToRealmOrUpdate(chargeTaxModel);
                                }
                                realm.commitTransaction();
                                realm.close();
                                getAllTaxes(mContext, requestType);
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            realm.cancelTransaction();
                            realm.close();
                            mCallBack.responseHandler(null, requestType);
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "Charge Taxes Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    //not calling
    private void getAllTaxes(final Context mContext, final int requestType) {
        mCallBack = (ResponseHandler) mContext;
        this.mContext = mContext;
        VolleyRequest volleyRequest = new VolleyRequest(URL.GET_ALL_TAXES,
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        Realm realm = Realm.getDefaultInstance();
                        try {
                            if (response != null) {
                                Log.d(TAG, "All Taxes Success" + "\t" + statusCode);
                                JSONArray allTaxes = new JSONArray(response.toString());
                                realm.beginTransaction();
                                for (int i = 0; i < allTaxes.length(); i++) {
                                    JSONObject eachTax = allTaxes.getJSONObject(i);
                                    TaxModel taxModel = new TaxModel();
                                    taxModel.setUniqueKey(eachTax.getString("regionCode")
                                            + eachTax.getString("taxCode")
                                            + eachTax.getString("effectiveFrom"));
                                    taxModel.setRegionCode(eachTax.getString("regionCode"));
                                    taxModel.setTaxCode(eachTax.getString("taxCode"));
                                    taxModel.setEffectiveFrom(eachTax.getLong("effectiveFrom"));
                                    taxModel.setEffectiveTo(eachTax.getLong("effectiveTo"));
                                    taxModel.setTaxPercentage(eachTax.getDouble("taxPerc"));
                                    taxModel.setAbsolute(eachTax.getString("percAbs").equals("A"));
                                    realm.copyToRealmOrUpdate(taxModel);
                                }
                                realm.commitTransaction();
                                realm.close();
                                getAllFeatureParams(mContext, requestType);
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            realm.cancelTransaction();
                            realm.close();
                            mCallBack.responseHandler(null, requestType);
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "All Taxes Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    private void getAllFeatureParams(final Context mContext, final int requestType) {
        mCallBack = (ResponseHandler) mContext;
        this.mContext = mContext;
        VolleyRequest volleyRequest = new VolleyRequest(URL.GET_FEATURE_PARAMS,
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        Realm realm = Realm.getDefaultInstance();
                        try {
                            JSONArray responseData = new JSONArray(response.toString());
                            realm.beginTransaction();
                            for (int i = 0; i < responseData.length(); i++) {
                                JSONObject eachFeature = responseData.getJSONObject(i);
                                VOIPFeatureModel featureModel = new VOIPFeatureModel();
                                featureModel.setUniqueKey(eachFeature.getString("coresrvccode") +
                                        eachFeature.getString("effectiveFrom") +
                                        eachFeature.getString("featurecode") +
                                        eachFeature.getString("prmCode"));
                                featureModel.setCoreServiceCode(eachFeature.getString("coresrvccode"));
                                featureModel.setEffectiveFrom(eachFeature.getString("effectiveFrom"));
                                featureModel.setFeatureCode(eachFeature.getString("featurecode"));
                                featureModel.setParamCode(eachFeature.getString("prmCode"));
                                featureModel.setParamName(eachFeature.getString("prmdfltlbl"));
                                featureModel.setParamType(eachFeature.getString("prmvalType"));
                                featureModel.setParamLovName(eachFeature.getString("prmlovName"));
                                featureModel.setMaxParamValues(eachFeature.getJSONObject("srvcFeatures").getInt("maxPrmValues"));
                                realm.copyToRealmOrUpdate(featureModel);
                            }
                            realm.commitTransaction();
                            realm.close();
                            getAllCPEStockByLMOCode(mContext, requestType);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            realm.cancelTransaction();
                            realm.close();
                            mCallBack.responseHandler(null, requestType);
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "Feature Params Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    private void getAllCPEStockByLMOCode(final Context mContext, final int requestType) {
        mCallBack = (ResponseHandler) mContext;
        this.mContext = mContext;
        final SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();
        VolleyRequest volleyRequest = new VolleyRequest(
                String.format(URL.GET_CPE_STOCK_LMO, sharedPreferences.getString(Constants.LMO_CODE, "")),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        Realm realm = Realm.getDefaultInstance();
                        try {
                            JSONArray responseData = new JSONArray(response.toString());
                            realm.beginTransaction();
                            for (int i = 0; i < responseData.length(); i++) {
                                JSONObject eachCPEStock = responseData.getJSONObject(i);
                                CPEStockModel cpeStockModel = new CPEStockModel();
                                cpeStockModel.setCpeSerialNumber(eachCPEStock.getString("cpeSrlno"));
                                cpeStockModel.setCpeProfileID(eachCPEStock.getInt("profileId"));
                                cpeStockModel.setCpeMacId(eachCPEStock.getString("macAddress"));
                                realm.copyToRealmOrUpdate(cpeStockModel);
                            }
                            realm.commitTransaction();
                            realm.close();
                            // mCallBack.responseHandler("Success", requestType);

                            getOltPorts(mContext, requestType);

                        } catch (Exception ex) {
                            ex.printStackTrace();
                            realm.cancelTransaction();
                            realm.close();
                            mCallBack.responseHandler(null, requestType);
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "CPE Stock LMO Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    @Override
    public void getOltPorts(final Context mContext, final int requestType) {

        mCallBack = (ResponseHandler) mContext;
        this.mContext = mContext;
        final SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();
        VolleyRequest volleyRequest = new VolleyRequest(
                String.format(URL.GET_ALL_OLT_PORT_DETAILS, sharedPreferences.getString(Constants.LMO_CODE, "")),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        Realm realm = Realm.getDefaultInstance();
                        try {
                            if (response != null) {
                                Log.d(TAG, "Olt Ports Data  Success" + "\t" + statusCode);
                                JSONArray responseData = new JSONArray(response.toString());
                                for (int i = 0; i < responseData.length(); i++) {
                                    OltPortDetails oltPortDetails = new OltPortDetails();
                                    JSONObject portValue = responseData.optJSONObject(i);
                                    String portNumber = portValue.getString("portNo");
                                    String popId = portValue.getJSONObject("olt").getString("popId");
                                    String popIdPortNo = popId + portNumber;
                                    oltPortDetails.setPortNo(portNumber);
                                    oltPortDetails.setPopIdPortNo(popIdPortNo);
                                    oltPortDetails.setPopId(popId);
                                    String lmoType = sharedPreferences.getString(Constants.TENANT_TYPE, "");
                                    switch (lmoType) {
                                        case "LMO":
                                            String slots = portValue.getString("l1Slots");
                                            String[] allSlots;
                                            String l1Slots = "";
                                            String rSlot = slots.replaceAll("[\r\n]", "");
                                            String s = rSlot;
                                            if (rSlot.contains(",")) {
                                                allSlots = rSlot.split(",");
                                                for (String eachSlot : allSlots) {
                                                    if (eachSlot.contains("-")) {
                                                        createL2Model(popIdPortNo, eachSlot.split("-")[0], Integer.parseInt(eachSlot.split("-")[1]));
                                                        createL3Model(popIdPortNo, eachSlot.split("-")[0], Integer.parseInt(eachSlot.split("-")[2]));
                                                        if (l1Slots.equals("")) {
                                                            l1Slots = "--Select--" + "," + eachSlot.split("-")[0];
                                                        } else {
                                                            l1Slots += "," + eachSlot.split("-")[0];
                                                        }
                                                    }
                                                }
                                            } else {
                                                if (slots.contains("-")) {
                                                    allSlots = slots.split("-");
                                                    for (String eachSlot : allSlots) {
                                                        createL2Model(popIdPortNo, eachSlot.split("-")[0], Integer.parseInt(eachSlot.split("-")[1]));
                                                        createL3Model(popIdPortNo, eachSlot.split("-")[0], Integer.parseInt(eachSlot.split("-")[2]));
                                                        if (l1Slots.equals("")) {
                                                            l1Slots = "--Select--" + "," + eachSlot;
                                                        } else {
                                                            l1Slots += "," + eachSlot;
                                                        }
                                                    }
                                                }
                                            }
                                            realm.beginTransaction();
                                            L1PortModel l1PortModel = new L1PortModel();
                                            l1PortModel.setOltL1Port(popIdPortNo + portNumber);
                                            l1PortModel.setOltPortNumber(portNumber);
                                            l1PortModel.setL1PortNumbers(l1Slots);
                                            l1PortModel.setPopIdPortno(popIdPortNo);
                                            realm.copyToRealmOrUpdate(oltPortDetails);
                                            realm.copyToRealmOrUpdate(l1PortModel);
                                            realm.commitTransaction();
                                            break;
                                        case "SI":
                                            realm.beginTransaction();
                                            realm.copyToRealmOrUpdate(oltPortDetails);
                                            realm.commitTransaction();
                                            break;
                                    }


                                }
                                realm.close();

                                if (!sharedPreferences.getString(Constants.TENANT_TYPE, "").equals("LMO")) {
                                    //For SILMO
                                    mCallBack.responseHandler("Success", requestType);
                                } else {
                                    getAllCPEStockByMSPCode(mContext, requestType);
                                }

                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            realm.cancelTransaction();
                            realm.close();
                            mCallBack.responseHandler(null, requestType);
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "Olt Ports Data Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    private void getAllCPEStockByMSPCode(final Context mContext, final int requestType) {
        mCallBack = (ResponseHandler) mContext;
        this.mContext = mContext;
        VolleyRequest volleyRequest = new VolleyRequest(
                String.format(URL.GET_CPE_STOCK_MSP, mspCodes),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        Realm realm = Realm.getDefaultInstance();
                        try {
                            JSONArray responseData = new JSONArray(response.toString());
                            realm.beginTransaction();
                            for (int i = 0; i < responseData.length(); i++) {
                                JSONObject eachCPEStock = responseData.getJSONObject(i);
                                CPEStockModel cpeStockModel = new CPEStockModel();
                                cpeStockModel.setCpeSerialNumber(eachCPEStock.getString("cpeSrlno"));
                                cpeStockModel.setCpeProfileID(eachCPEStock.getInt("profileId"));
                                cpeStockModel.setCpeMacId(eachCPEStock.getString("macAddress"));
                                realm.copyToRealmOrUpdate(cpeStockModel);
                            }
                            realm.commitTransaction();
                            realm.close();
                            getVPNSrvcNamesList(mContext, requestType);

                        } catch (Exception ex) {
                            ex.printStackTrace();
                            realm.cancelTransaction();
                            realm.close();
                            mCallBack.responseHandler(null, requestType);
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "CPE Stock MSP Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    private void getVPNSrvcNamesList(final Context mContext, final int requestType) {
        mCallBack = (ResponseHandler) mContext;
        this.mContext = mContext;
        SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();
        VolleyRequest volleyRequest = new VolleyRequest(
                String.format(URL.GET_LMOVPNSERVICELIST, sharedPreferences.getString(Constants.SUB_STATION_CODES, "")),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        Realm realm = Realm.getDefaultInstance();
                        try {
                            JSONArray responseData = new JSONArray(response.toString());
                            realm.beginTransaction();
                            for (int i = 0; i < responseData.length(); i++) {
                                JSONObject vpnServiceObj = responseData.getJSONObject(i);
                                VpnServiceModel vpnServiceModel = new VpnServiceModel();
                                vpnServiceModel.setVpnCompositeKey(vpnServiceObj.getString("substnUid") + vpnServiceObj.getString("oltSerialNo")
                                        + vpnServiceObj.getString("vpnsrvcName"));
                                vpnServiceModel.setSubstnUid(vpnServiceObj.getString("substnUid"));
                                vpnServiceModel.setOltSerialNo(vpnServiceObj.getString("oltSerialNo"));
                                vpnServiceModel.setVpnsrvcName(vpnServiceObj.getString("vpnsrvcName"));
                                realm.copyToRealmOrUpdate(vpnServiceModel);
                            }
                            realm.commitTransaction();
                            realm.close();
                            mCallBack.responseHandler("Success", requestType);

                        } catch (Exception ex) {
                            ex.printStackTrace();
                            realm.cancelTransaction();
                            realm.close();
                            mCallBack.responseHandler(null, requestType);
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "VPNSrvcNamesList Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    @Override
    public void getDetailsFromAadhaar(final Context mContext, final Fragment mFragment,
                                      final String aadhaarNumber,
                                      final int requestType) {

        if (mFragment == null) {
            mCallBack = (ResponseHandler) mContext;
            this.mContext = mContext;
        } else {
            mCallBack = (ResponseHandler) mFragment;
            this.mContext = mContext;
        }
        VolleyRequest volleyRequest = new VolleyRequest(
                String.format(URL.GET_DETAILS_AADHAAR, aadhaarNumber),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        try {
                            Log.d(TAG, "\t" + "Aadhaar success" + "\t" + response.toString());
                            JSONObject responseData = new JSONObject(response.toString());
                            if (!responseData.getString("base64file").equals("101")) {
                                mCallBack.responseHandler(responseData, requestType);
                            } else {
                                mCallBack.responseHandler(null, requestType);
                            }
                        } catch (Exception ex) {
                            mCallBack.responseHandler(null, requestType);
                            ex.printStackTrace();
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "\t" + "Aadhaar fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    @Override
    public void getCAFNumber(final Context mContext, final int requestType) {
        mCallBack = (ResponseHandler) mContext;
        this.mContext = mContext;
        VolleyRequest volleyRequest = new VolleyRequest(URL.GET_CAF_NUMBER,
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        if (response != null) {
                            String cafNumber = response.toString();
                            Log.d(TAG, "CAF Number" + "\t" + cafNumber);
                            Constants.cafNumber = cafNumber;
                            mCallBack.responseHandler(cafNumber, requestType);
                        } else {
                            mCallBack.responseHandler(null, requestType);
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "CAF Number Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    @Override
    public void submitCAFForm(Context mContext, Fragment mFragment,
                              final JSONObject requestData, final int requestType) {
        if (mFragment == null) {
            mCallBack = (ResponseHandler) mContext;
            this.mContext = mContext;
        } else {
            mCallBack = (ResponseHandler) mFragment;
            this.mContext = mContext;
        }
        final JSONObject responseData = new JSONObject();
        VolleyRequest volleyRequest = new VolleyRequest(Request.Method.POST, URL.SAVE_CAF_FORM,
                requestData.toString().replace("\\/", "/"),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        try {
                            JSONObject responseObj = new JSONObject(response.toString());
                            Log.d(TAG, "CAF Submit Success" + "\t" + statusCode + "\t" + response.toString());
                           /* String customerID = new JSONObject(response.toString()).getString("statusMessage");
                            responseData.put("customerID", customerID);*/
                            mCallBack.responseHandler(responseObj, requestType);
                        } catch (Exception ex) {
                            mCallBack.responseHandler(response, requestType);
                            ex.printStackTrace();
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        try {
                            Log.d(TAG, "CAF Submit Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                            responseData.put("submitFailed", true);
                            mCallBack.responseHandler(responseData, requestType);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL_POST, NO_OF_RETRIES_POST, RETRY_MULTIPLIER_POST));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    @Override
    public void submitCAFPackages(Context context, final Fragment mFragment,
                                  JSONObject requestData, final int requestType) {
        if (mFragment != null) {
            mCallBack = (ResponseHandler) mFragment;
            this.mContext = mFragment.getActivity();
        } else {
            mCallBack = (ResponseHandler) context;
            this.mContext = context;
        }
        VolleyRequest volleyRequest = new VolleyRequest(Request.Method.POST, URL.SAVE_CAF_PACKAGES,
                requestData.toString().replace("\\/", "/"),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        Log.d(TAG, "Packages Success" + "\t" + statusCode + "\t" + response.toString());
                        if (!response.toString().equals("Failed")) {
                            mCallBack.responseHandler("Success", requestType);
                        } else {
                            mCallBack.responseHandler(null, requestType);
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "Packages Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    @Override
    public void submitCAFPayment(Context context, final Fragment mFragment,
                                 JSONObject requestData, final int requestType) {
        if (mFragment != null) {
            mCallBack = (ResponseHandler) mFragment;
            this.mContext = mFragment.getActivity();
        } else {
            mCallBack = (ResponseHandler) context;
            this.mContext = context;
        }
        this.mContext = context;
        VolleyRequest volleyRequest = new VolleyRequest(Request.Method.POST, URL.SAVE_CAF_PAYMENT,
                requestData.toString().replace("\\/", "/"),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        Log.d(TAG, "CAF Payment Success" + "\t" + statusCode + "\t" + response.toString());
                        try {
                            JSONObject responseObj = new JSONObject(response.toString());
                            String responseStatusCode = responseObj.getString("statusCode");
                            String statusMessage = responseObj.getString("statusMessage");
                            if (responseStatusCode.equals("200")) {
                                if (statusMessage.contains("Telephone") ||
                                        statusMessage.contains("Password")) {
                                    mCallBack.responseHandler(statusMessage, requestType);
                                } else if (statusMessage.contains("Feasibility")) {
                                    mCallBack.responseHandler(200, requestType);
                                } else {
                                    mCallBack.responseHandler(responseObj, requestType);
                                }
                            } else {
                                mCallBack.responseHandler(responseObj, requestType);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            mCallBack.responseHandler(null, requestType);
                        }

                    }
                },
                new VolleyRequest.onFailure()

                {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "CAF Payment Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                }

        );
        volleyRequest.setRequestHeaders(

                getHeaders()

        );
        volleyRequest.setRetryPolicy(new

                DefaultRetryPolicy(TIMEOUT_INITIAL_POST, NO_OF_RETRIES_POST, RETRY_MULTIPLIER_POST)

        );
        VolleySingleton.getInstance(mContext).

                addToRequestQueue(volleyRequest);

    }

    @Override
    public void submitMonthlyPayment(Context context, JSONObject requestData, final int requestType) {

        mCallBack = (ResponseHandler) context;
        this.mContext = context;
        this.mContext = context;
        VolleyRequest volleyRequest = new VolleyRequest(Request.Method.POST, URL.SAVE_CAF_PAYMENT,
                requestData.toString().replace("\\/", "/"),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        try {
                            JSONObject responseobj = new JSONObject(response.toString());
                            Log.d(TAG, "CAF Payment Success" + "\t" + statusCode + "\t" + response.toString());
                            mCallBack.responseHandler(responseobj, requestType);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            mCallBack.responseHandler(null, requestType);
                        }

                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "CAF Payment Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    @Override
    public void getWalletBalance(Context mContext, final Fragment mFragment, final int requestType) {
        if (mFragment == null) {
            mCallBack = (ResponseHandler) mContext;
        } else {
            mCallBack = (ResponseHandler) mFragment;
        }
        this.mContext = mContext;
        SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();
        VolleyRequest volleyRequest = new VolleyRequest(
                String.format(URL.GET_WALLET_BALANCE, sharedPreferences.getString("lmoCode", "")),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        try {
                            if (response != null) {
                                Log.d(TAG, "Wallet Success" + "\t" + statusCode + "\t" + response.toString());
                                JSONObject responseData = new JSONObject(response.toString());
                                mCallBack.responseHandler(responseData, requestType);
                            } else {
                                mCallBack.responseHandler(null, requestType);
                            }
                        } catch (Exception ex) {
                            mCallBack.responseHandler(null, requestType);
                            ex.printStackTrace();
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "Wallet Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }


    @Override
    public void getMonthlyPayments(Context mContext, final String data, final int requestType) {
        mCallBack = (ResponseHandler) mContext;
        this.mContext = mContext;
        final ArrayList<PaymentModel> paymentList = new ArrayList<>();
        SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();
        VolleyRequest volleyRequest = new VolleyRequest(
                String.format(URL.MONTHLY_PAYMENT_DETAILS, data, sharedPreferences.getString(Constants.LMO_CODE, "")),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        try {
                            Log.d(TAG, "Monthly Payments Success" + "\t" + statusCode + "\t" + response.toString());
                            JSONArray responseData = new JSONArray(response.toString());
                            if (responseData.length() > 0) {
                                for (int i = 0; i < responseData.length(); i++) {

                                    JSONObject paymentJson = responseData.getJSONObject(i);
                                    PaymentModel model = new PaymentModel();
                                    model.setPaymentCustomerName(String.format("%s %s",
                                            paymentJson.getString("fName"), paymentJson.getString("lName")));
                                    model.setPaymentAadhaarNumber(paymentJson.getString("aadharNo"));
                                    model.setPaymentCAFNumber("0");
                                    model.setPaymentTotalCharges(paymentJson.getString("dueAmount"));
                                    model.setPaymentCustomerID(paymentJson.getString("custId"));
                                    model.setPaymentCustomerType(paymentJson.getString("custTypelov"));
                                    model.setPaymentDistrictID(paymentJson.getString("instDistrict"));
                                    model.setPaymentMobileNo(paymentJson.getString("mobileNo"));

                                    /*JSONArray paymentArray = responseData.getJSONArray(i);
                                    PaymentModel model = new PaymentModel();
                                    model.setPaymentCustomerName(String.format("%s %s",
                                            paymentArray.getString(0), paymentArray.getString(6)));
                                    model.setPaymentAadhaarNumber(paymentArray.getString(1));
                                    model.setPaymentCAFNumber(paymentArray.getString(2));
                                    Double charge = !paymentArray.isNull(3) ? paymentArray.getDouble(3) : 0.00;
                                    model.setPaymentTotalCharges(String.format(Locale.getDefault(), "%.2f", charge));
                                    model.setPaymentCustomerID(paymentArray.getString(4));
                                    model.setPaymentCustomerType(paymentArray.getString(5));
                                    model.setPaymentDistrictID(paymentArray.getString(7));*/
                                    paymentList.add(model);
                                }
                                mCallBack.responseHandler(paymentList, requestType);
                            } else {
                                mCallBack.responseHandler(paymentList, requestType);
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            mCallBack.responseHandler(paymentList, requestType);
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "Monthly Payments Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    @Override
    public void getSearchCAFResults(final Context mContext, JSONObject requestData, final int requestType) {
        mCallBack = (ResponseHandler) mContext;
        this.mContext = mContext;
        VolleyRequest volleyRequest = new VolleyRequest(Request.Method.POST, URL.SEARCH_CAF, requestData,
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        try {
                            Log.d(TAG, "Search CAF Success" + "\t" + statusCode + "\t" + response.toString());
                            JSONArray responseData = new JSONArray(response.toString());
                            if (responseData.length() > 0) {
                                ArrayList<CAFResultModel> cafResults = new ArrayList<>();
                                for (int i = 0; i < responseData.length(); i++) {
                                    //Log.d(TAG,""+i);
                                    JSONObject eachResult = responseData.getJSONObject(i);
                                    CAFResultModel resultModel = new CAFResultModel();
                                    resultModel.setCustomerFirstName(eachResult.getString("fName"));
                                    resultModel.setCustomerLastName(eachResult.getString("lName"));
                                    resultModel.setCustID(eachResult.getString("custId"));
                                    resultModel.setIndividualCustomer(eachResult.getString("cafType").equals("INDIVIDUAL"));
                                    resultModel.setCustTypelov(eachResult.getString("custTypelov"));
                                    resultModel.setCafNumber(eachResult.getString("cafNo"));
                                    resultModel.setAadhaarNumber(eachResult.getString("custCode"));
                                    resultModel.setCpeName(eachResult.getString("cpeModel"));
                                    resultModel.setCpeID(eachResult.getString("cafdate"));
                                    resultModel.setPackages(eachResult.getString("prodName"));
                                    resultModel.setStatus(eachResult.getString("statusDesc"));
                                    resultModel.setPinCode(eachResult.getString("pinCode"));
                                    resultModel.setBillCycle(eachResult.getString("billFrequency"));
                                    resultModel.setOltSerialNumber(eachResult.getString("oltSrlNo"));
                                    resultModel.setOltPortNumber(eachResult.getString("oltPortNo"));
                                    resultModel.setDistrictID(eachResult.getString("district"));
                                    resultModel.setVillageID(eachResult.getString("village"));
                                    resultModel.setMandalID(eachResult.getString("mandal"));
                                    resultModel.setPopID(eachResult.getString("popId"));
                                    resultModel.setAllPackages(eachResult.getString("prodCode"));
                                    resultModel.setEditCafStatus(eachResult.getString("cafStatus"));
                                    resultModel.setPopName(eachResult.getString("popName"));
                                    resultModel.setAddress1(eachResult.getString("insrAddress1"));
                                    resultModel.setAddress2(eachResult.getString("insrAddress2"));
                                    resultModel.setContactPersonMobileNo(eachResult.getString("contactPersonMobileNo"));
                                    resultModel.setApsflTrackID(eachResult.getString("apsflTrackId"));
                                    resultModel.setCpeplace(eachResult.getString("cpeplace"));
                                    resultModel.setCoreSrvcCode(eachResult.getString("coreSrvcCode"));
                                    resultModel.setContactPersonName(eachResult.getString("contactPerson"));
                                    resultModel.setAllocatedMobileNo(eachResult.getString("allocatedMobileNo"));
                                    resultModel.setIptvPackages(eachResult.getString("iptvPackages"));
                                    cafResults.add(resultModel);
                                }
                                mCallBack.responseHandler(cafResults, requestType);
                            } else {
                                mCallBack.responseHandler(null, requestType);
                            }
                        } catch (Exception ex) {
                            mCallBack.responseHandler(null, requestType);
                            ex.printStackTrace();
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "Search CAF Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }


    @Override
    public void getCAFDetails(Context mContext, String cafNumber, String editCafStatus, final int requestType) {
        mCallBack = (ResponseHandler) mContext;
        this.mContext = mContext;
        VolleyRequest volleyRequest = new VolleyRequest(
                String.format(URL.GET_CAF_DETAILS, cafNumber, editCafStatus),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        try {
                            Log.d(TAG, "CAF Details Success" + "\t" + statusCode + "\t" + response.toString());
                            JSONObject responseData = new JSONObject(response.toString());
                            mCallBack.responseHandler(responseData, requestType);
                        } catch (Exception ex) {
                            mCallBack.responseHandler(null, requestType);
                            ex.printStackTrace();
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "CAF Details Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    @Override
    public void sendOTP(Context mContext, final Object requestBody, final int requestType) {
        mCallBack = (ResponseHandler) mContext;
        this.mContext = mContext;
        VolleyRequest volleyRequest = new VolleyRequest(Request.Method.POST,
                URL.SEND_OTP, requestBody,
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        try {
                            Log.d(TAG, "OTP Success" + "\t" + statusCode + "\t" + response.toString());
                            if (response.toString().contains("OK")) {
                                mCallBack.responseHandler(response, requestType);
                            } else {
                                mCallBack.responseHandler(null, requestType);
                            }
                        } catch (Exception ex) {
                            mCallBack.responseHandler(null, requestType);
                            ex.printStackTrace();
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "OTP Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }


    public void forgotPassword(Context mContext, String lmoUserName, final int requestType) {
        mCallBack = (ResponseHandler) mContext;
        this.mContext = mContext;

        VolleyRequest volleyRequest = new VolleyRequest(String.format(URL.FORGOT_PASSWORD, lmoUserName),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        Log.d(TAG, "ForgotPassword Success" + "\t" + statusCode + "\t" + response.toString());
                        try {
                            JSONObject responseData = new JSONObject(response.toString());
                            mCallBack.responseHandler(responseData, requestType);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new VolleyRequest.onFailure() {
            @Override
            public void onError(int statusCode, Object errorResponse) {
                Log.d(TAG, "ForgotPassword failed" + "\t" + statusCode + "\t" + errorResponse.toString());

                mCallBack.responseHandler(null, requestType);

            }
        });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);

    }


    public void changePassword(Context context, JSONObject requestData, final int requestType) {

        mCallBack = (ResponseHandler) context;
        this.mContext = context;

        VolleyRequest volleyRequest = new VolleyRequest(Request.Method.POST, URL.CHANGE_PASSWORD,
                requestData.toString().replace("\\/", "/"),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {

                        Log.d(TAG, "Change password Success" + "\t" + statusCode + "\t" + response.toString());

                        if (response.toString().equals("success")) {
                            mCallBack.responseHandler("success", requestType);
                        } else {
                            mCallBack.responseHandler(null, requestType);
                        }
                    }

                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "Change Password Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    public void getAllSILMOVillages(final Context mContext, final Fragment mFragment, String mondalId, String districtId, final int requestType) {
        if (mFragment == null) {
            mCallBack = (ResponseHandler) mContext;
        } else {
            mCallBack = (ResponseHandler) mFragment;
        }
        this.mContext = mContext;
        VolleyRequest volleyRequest = new VolleyRequest(String.format(URL.GET_ALL_SILMO_VILLAGES, mondalId, districtId),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        Realm realm = Realm.getDefaultInstance();
                        try {
                            if (response != null) {
                                Log.d(TAG, "InstallationVillageModel Success" + "\t" + statusCode);
                                JSONArray responseData = new JSONArray(response.toString());
                                realm.beginTransaction();
                                realm.where(InstallationVillageModel.class).findAll().deleteAllFromRealm();
                                realm.commitTransaction();
                                realm.beginTransaction();
                                for (int i = 0; i < responseData.length(); i++) {
                                    InstallationVillageModel villageModel = new InstallationVillageModel();
                                    JSONObject eachVillage = responseData.getJSONObject(i);
                                    villageModel.setVillageSerialNumber(eachVillage.getString("villageSlno"));
                                    villageModel.setVillageName(eachVillage.getString("villageName"));
                                    villageModel.setMandalSerialNumber(eachVillage.getString("mandalSlno"));
                                    villageModel.setDistrictSerialNumber(eachVillage.getString("districtUid"));
                                    villageModel.setVillageCompositeKey(eachVillage.getString("districtUid") + eachVillage.getString("mandalSlno") + eachVillage.getString("villageSlno"));
                                    villageModel.setStateId(eachVillage.getString("stateId"));
                                    villageModel.setPinCode(eachVillage.getString("pinCode"));
                                    villageModel.setStdCode(eachVillage.getString("stdCode"));
                                    villageModel.setRegion(eachVillage.getString("entTaxZone"));
                                    villageModel.setVillageChecked(false);
                                    realm.copyToRealmOrUpdate(villageModel);
                                }
                                realm.commitTransaction();
                                realm.close();
                                mCallBack.responseHandler("Success", requestType);
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            realm.cancelTransaction();
                            realm.close();
                            mCallBack.responseHandler(null, requestType);
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "Village Data Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }


    public void getAllSILMOPOPData(final Context mContext, final Fragment mFragment, String districtId, String mandalId, final int requestType) {
        if (mFragment == null) {
            mCallBack = (ResponseHandler) mContext;
        } else {
            mCallBack = (ResponseHandler) mFragment;
        }
        this.mContext = mContext;
        VolleyRequest volleyRequest = new VolleyRequest(String.format(URL.GET_ALL_SILMO_POP_NAMES, districtId, mandalId),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        Realm realm = Realm.getDefaultInstance();
                        try {
                            if (response != null) {
                                Log.d(TAG, "POP Data Success" + "\t" + statusCode);
                                JSONArray responseData = new JSONArray(response.toString());
                                realm.beginTransaction();
                                realm.where(POPModel.class).findAll().deleteAllFromRealm();
                                realm.commitTransaction();
                                realm.beginTransaction();
                                for (int i = 0; i < responseData.length(); i++) {
                                    JSONObject eachPOPObject = responseData.getJSONObject(i);
                                    POPModel popModel = new POPModel();
                                    popModel.setPopID(eachPOPObject.getString("substnUid"));
                                    popModel.setPopName(eachPOPObject.getString("substnName").trim());
                                    popModel.setPOPChecked(false);
                                    realm.copyToRealmOrUpdate(popModel);
                                }
                                realm.commitTransaction();
                                realm.close();
                                mCallBack.responseHandler("Success", requestType);
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            realm.cancelTransaction();
                            realm.close();
                            mCallBack.responseHandler(null, requestType);
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "POP Data Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    @Override
    public void getSILMOMasterData2(Context mContext, Fragment mFragment, String substnUid, String districtId, String mandalId, String villageId, int requestType) {
        if (mFragment == null) {
            mCallBack = (ResponseHandler) mContext;
        } else {
            mCallBack = (ResponseHandler) mFragment;
        }
        this.mContext = mContext;
        siLmo_substnUid = substnUid;
        // getAllSILMOIndividualProducts(mContext,mFragment, requestType);
        getSILMORegion(mContext, mFragment, districtId, mandalId, villageId, requestType);
    }

    @Override
    public void getSelectedPackages(final Context mContext, final Fragment mFragment, String cafNo, String billCycle, final int requestType) {

        if (mFragment == null) {
            mCallBack = (ResponseHandler) mContext;
        } else {
            mCallBack = (ResponseHandler) mFragment;
        }
        this.mContext = mContext;
        SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();
        final String lmoType = sharedPreferences.getString(Constants.TENANT_TYPE, "");
        VolleyRequest volleyRequest = new VolleyRequest(
                String.format(URL.GET_SELECTED_PACKAGES, cafNo, billCycle),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        Realm realm = Realm.getDefaultInstance();
                        realm.beginTransaction();
                        realm.where(ProductModel.class).findAll().deleteAllFromRealm();
                        realm.commitTransaction();
                        realm.beginTransaction();
                        try {
                            if (response != null) {
                                JSONObject products = new JSONObject(response.toString());
                                JSONArray productsArray = products.getJSONArray("cafAndCpeChargesList");
                                Log.d(TAG, "Selected Products" + "\t" + statusCode);
                                for (int i = 0; i < productsArray.length(); i++) {
                                    JSONObject eachProduct = productsArray.getJSONObject(i);
                                    //JSONObject eachProduct=new JSONObject(response.toString());
                                    ProductModel model = new ProductModel();
                                    model.setTotalProductsCost(products.getString("totalCharge"));
                                    model.setProductName(eachProduct.getString("prodName").trim());
                                    model.setProductDate("");
                                    model.setProductCode(eachProduct.getString("prodCode"));
                                    model.setProductTenantName("");
                                    model.setProductTenantCode(eachProduct.getString("tenantCode"));
                                    model.setProductUniqueKey(model.getProductCode() + model.getProductTenantCode() + eachProduct.getString("agrmtId"));
                                    model.setProductType(eachProduct.getString("prodtype"));
                                    model.setProductRecurringCharge(eachProduct.getString("recurringCharge"));
                                    model.setProductRecurringTax(eachProduct.getString("recurringTax"));
                                    model.setProductActivationCharge(eachProduct.getString("activationCharge"));
                                    model.setProductActivationTax(eachProduct.getString("activationTax"));
                                    model.setProductSecurityCharge(eachProduct.getString("secDepositCharge"));
                                    model.setProductSecurityTax(eachProduct.getString("secDepositTax"));
                                    model.setProductLockInPeriod("");
                                    model.setProductTax("");
                                    model.setProductTotalCharge("");
                                    String featureCodes = "", voipServiceCode = "";
                                    //removed voip and service codes
                                    //getting msp codes by using "General"
                                    model.setFeatureCodes(featureCodes);
                                    model.setVoipServiceCode(voipServiceCode);
                                    if (lmoType.equals("SI")) {
                                        model.setSrvcName(eachProduct.getString("srvcName"));
                                    }
                                    model.setProductData(eachProduct.toString());
                                    model.setIndividualProduct(true);
                                    model.setProductCheckBoxVisible(true);
                                    model.setProductChecked(true);
                                    realm.copyToRealmOrUpdate(model);
                                }
                                realm.commitTransaction();
                                realm.close();
                                mCallBack.responseHandler("sucess", requestType);
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            realm.cancelTransaction();
                            realm.close();
                            mCallBack.responseHandler(null, requestType);
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "Products Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    @Override
    public void getCoreSrvcCodeByCafNo(Context mContext, Fragment mFragment, String cafNo, final int requestType) {
        if (mFragment == null) {
            mCallBack = (ResponseHandler) mContext;
        } else {
            mCallBack = (ResponseHandler) mFragment;
        }
        this.mContext = mContext;
        VolleyRequest volleyRequest = new VolleyRequest(
                String.format(URL.GET_CORESERVICECODE, cafNo),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        try {
                            JSONObject data = new JSONObject(response.toString());
                            Log.d(TAG, "CoreService code" + "\t" + data);
                            mCallBack.responseHandler(data, requestType);
                        } catch (Exception ex) {
                            mCallBack.responseHandler(null, requestType);
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "CoreService code Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    @Override
    public void getSILMOVPNSrvcNamesList(Context mContext, Fragment mFragment, String oltSrlNo, String subStnId, final int requestType) {
        if (mFragment == null) {
            mCallBack = (ResponseHandler) mContext;
        } else {
            mCallBack = (ResponseHandler) mFragment;
        }
        this.mContext = mContext;
        VolleyRequest volleyRequest = new VolleyRequest(
                String.format(URL.GET_SILMOVPNSERVICELIST, oltSrlNo, subStnId),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        Realm realm = Realm.getDefaultInstance();
                        try {
                            JSONArray responseData = new JSONArray(response.toString());
                            realm.beginTransaction();
                            for (int i = 0; i < responseData.length(); i++) {
                                JSONObject vpnServiceObj = responseData.getJSONObject(i);
                                VpnServiceModel vpnServiceModel = new VpnServiceModel();
                                vpnServiceModel.setVpnCompositeKey(vpnServiceObj.getString("substnUid") + vpnServiceObj.getString("oltSerialNo")
                                        + vpnServiceObj.getString("vpnsrvcName"));
                                vpnServiceModel.setSubstnUid(vpnServiceObj.getString("substnUid"));
                                vpnServiceModel.setOltSerialNo(vpnServiceObj.getString("oltSerialNo"));
                                vpnServiceModel.setVpnsrvcName(vpnServiceObj.getString("vpnsrvcName"));
                                realm.copyToRealmOrUpdate(vpnServiceModel);
                            }
                            realm.commitTransaction();
                            realm.close();
                            mCallBack.responseHandler("Success", requestType);

                        } catch (Exception ex) {
                            ex.printStackTrace();
                            realm.cancelTransaction();
                            realm.close();
                            mCallBack.responseHandler(null, requestType);
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "VPNSrvcNamesList Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    @Override
    public void getPendingEditDistrict(Context mContext, final int requestType) {
        mCallBack = (ResponseHandler) mContext;
        this.mContext = mContext;
        SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();

        VolleyRequest volleyRequest = new VolleyRequest(String.format(URL.GET_EDIT_DISTRICT, sharedPreferences.getString(Constants.USER_NAME, "")),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        try {
                            JSONArray responseData = new JSONArray(response.toString());
                            Log.d(TAG, "edit district Success" + "\t" + statusCode + "\t" + responseData);
                            mCallBack.responseHandler(responseData, requestType);

                        } catch (Exception ex) {
                            ex.printStackTrace();
                            mCallBack.responseHandler(null, requestType);
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "edit district Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);

    }

    @Override
    public void getPendingEditMandal(Context mContext, String district, final int requestType) {
        mCallBack = (ResponseHandler) mContext;
        this.mContext = mContext;
        SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();

        VolleyRequest volleyRequest = new VolleyRequest(String.format(URL.GET_ALL_SILMO_MANDALS, district),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        try {
                            JSONArray responseData = new JSONArray(response.toString());
                            Log.d(TAG, "edit mandal Success" + "\t" + statusCode + "\t" + responseData);
                            mCallBack.responseHandler(responseData, requestType);

                        } catch (Exception ex) {
                            ex.printStackTrace();
                            mCallBack.responseHandler(null, requestType);
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "edit Mandal Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);


    }

    @Override
    public void getEditPopData(Context mContext, String districtId, String mandalId, final int requestType) {

        mCallBack = (ResponseHandler) mContext;

        this.mContext = mContext;
        VolleyRequest volleyRequest = new VolleyRequest(String.format(URL.GET_ALL_SILMO_POP_NAMES, districtId, mandalId),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        try {
                            if (response != null) {
                                Log.d(TAG, "Edit POP Data Success" + "\t" + statusCode);
                                JSONArray responseData = new JSONArray(response.toString());
                                /*for (int i = 0; i < responseData.length(); i++) {
                                    JSONObject eachPOPObject = responseData.getJSONObject(i);
                                    POPModel popModel = new POPModel();
                                    popModel.setPopID(eachPOPObject.getString("substnUid"));
                                    popModel.setPopName(eachPOPObject.getString("substnName").trim());
                                }*/
                                mCallBack.responseHandler(responseData, requestType);
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            mCallBack.responseHandler(null, requestType);
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "POP Data Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);

    }


    public void getSILMORegion(final Context mContext, final Fragment mFragment, String districtId, String mandalId, String villageId, final int requestType) {
        if (mFragment == null) {
            mCallBack = (ResponseHandler) mContext;
        } else {
            mCallBack = (ResponseHandler) mFragment;
        }
        this.mContext = mContext;
        VolleyRequest volleyRequest = new VolleyRequest(String.format(URL.GET_SILMREGIN, districtId, mandalId, villageId),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        try {
                            if (response != null) {
                                JSONObject RegionResponse = new JSONObject(response.toString());
                                Log.d(TAG, "RegionResponse Success" + "\t" + statusCode + "\t" + RegionResponse);

                                siLmo_region = RegionResponse.getString("regionCode");

                                getAllSILMOOLTData(mContext, mFragment, requestType);
                            } else {
                                mCallBack.responseHandler(null, requestType);
                            }

                        } catch (Exception ex) {
                            ex.printStackTrace();
                            mCallBack.responseHandler(null, requestType);
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "RegionResponse Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }


    private void getAllSILMOOLTData(final Context mContext, final Fragment mFragment, final int requestType) {
        if (mFragment == null) {
            mCallBack = (ResponseHandler) mContext;
        } else {
            mCallBack = (ResponseHandler) mFragment;
        }
        this.mContext = mContext;
        SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();
        VolleyRequest volleyRequest = new VolleyRequest(String.format(URL.GET_ALL_OLT_DATA, siLmo_substnUid),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        Realm realm = Realm.getDefaultInstance();
                        try {
                            if (response != null) {
                                Log.d(TAG, "OLT Data Success" + "\t" + statusCode);

                                JSONArray responseData = new JSONArray(response.toString());
                                realm.beginTransaction();
                                for (int i = 0; i < responseData.length(); i++) {
                                    JSONObject eachOLTObject = responseData.getJSONObject(i);
                                    POPOLTModel oltModel = new POPOLTModel();
                                    oltModel.setPopOLTID(eachOLTObject.getString("popId"));
                                    oltModel.setPopID(eachOLTObject.getString("popSubstnuid"));
                                    oltModel.setPopName(eachOLTObject.getString("popName"));
                                    oltModel.setPopOLTSerialNumber(eachOLTObject.getString("popOltSerialno"));
                                    oltModel.setPopLabelNumber(eachOLTObject.getString("pop_oltlabelno"));
                                    realm.copyToRealmOrUpdate(oltModel);
                                }
                                realm.commitTransaction();
                                realm.close();
                                getAllSILMOCPEModels(mContext, mFragment, requestType);
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            realm.cancelTransaction();
                            realm.close();
                            mCallBack.responseHandler(null, requestType);

                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "OLT Data Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    private void getAllSILMOCPEModels(final Context mContext, Fragment mFragment, final int requestType) {

        if (mFragment == null) {
            mCallBack = (ResponseHandler) mContext;
        } else {
            mCallBack = (ResponseHandler) mFragment;
        }
        this.mContext = mContext;
        SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();

        VolleyRequest volleyRequest = new VolleyRequest(String.format(URL.GET_ALL_CPE_MODELS, siLmo_region),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        Realm realm = Realm.getDefaultInstance();
                        try {
                            if (response != null) {
                                Log.d(TAG, "CPE Models Success" + "\t" + statusCode);
                                JSONArray responseData = new JSONArray(response.toString());
                                realm.beginTransaction();
                                for (int i = 0; i < responseData.length(); i++) {
                                    CPEDataModel model = new CPEDataModel();
                                    JSONObject eachCPE = responseData.getJSONObject(i);
                                    JSONObject cpeModal = eachCPE.getJSONObject("cpeModal");
                                    model.setCpeProfileID(cpeModal.getInt("profileId"));
                                    model.setCpeModelName(cpeModal.getString("cpeModel"));
                                    model.setCpeProfileName(cpeModal.getString("cpeProfileName"));
                                    model.setInstallationTaxAmount(String.format(Locale.getDefault(), "%.2f",
                                            eachCPE.getDouble("installationTaxAmount")));
                                    model.setCpeModelDetails(cpeModal.getString("cpeModelDetails"));
                                    model.setCpeLovType(cpeModal.getString("cpetypeLov"));
                                    model.setCpeInstallmentCount(eachCPE.getString("emiCount"));
                                    model.setCpeInstallmentCost(eachCPE.getString("emiAmount"));
                                    model.setCpePurchaseCost(
                                            String.format(Locale.getDefault(), "%.2f", eachCPE.getDouble("custCost")));
                                    model.setCpeRentalCost(
                                            String.format(Locale.getDefault(), "%.2f", eachCPE.getDouble("custRent")));
                                    model.setCpeInstallationCost(
                                            String.format(Locale.getDefault(), "%.2f", eachCPE.getDouble("instcharges")));
                                    model.setCpeTax(String.format(Locale.getDefault(), "%.2f", eachCPE.getDouble("onuTaxAmount")));
                                    realm.copyToRealmOrUpdate(model);
                                }
                                realm.commitTransaction();
                                realm.close();

                                mCallBack.responseHandler("Success", requestType);


                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            realm.cancelTransaction();
                            realm.close();
                            mCallBack.responseHandler(null, requestType);
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "CPE Models Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    private Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json; charset=utf-8");
        headers.put("Authorization",
                "Basic " + Base64.encodeToString(("admin" + ":" + "admin").getBytes(), Base64.NO_WRAP));
        return headers;
    }

    private void createL2Model(String popIdPortNo, String l1PortNumber, int slot) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        L2PortModel l2PortModel = new L2PortModel();
        l2PortModel.setL1PortNumber(popIdPortNo + l1PortNumber);
        l2PortModel.setL2PortNumbers(generateSlots(slot));
        realm.copyToRealmOrUpdate(l2PortModel);
        Log.d("L2PortModel", "\t" + l2PortModel.toString());
        realm.commitTransaction();
    }

    private void createL3Model(String popIdPortNo, String l1PortNumber, int slot) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        L3PortModel l3PortModel = new L3PortModel();
        l3PortModel.setL1PortNumber(popIdPortNo + l1PortNumber);
        l3PortModel.setL3PortNumbers(generateSlots(slot));
        realm.copyToRealmOrUpdate(l3PortModel);
        Log.d("L3PortModel", "\t" + l3PortModel.toString());
        realm.commitTransaction();
    }

    private String generateSlots(int slot) {
        Log.d("Slot", "\t" + slot);
        String slots = "";
        for (int i = 0; i <= slot; i++) {
            if (i == 0) {
                slots = "--Select--";
            } else {
                slots += "," + i;
            }
        }
        Log.d("Slots Generated", "\t" + slots);
        return slots;
    }

    @Override
    public void getSILMOMasterData(Context mContext, int requestType) {
        getDistVillMandal(mContext, requestType);
    }

    private void getDistVillMandal(final Context mContext, final int requestType) {
        mCallBack = (ResponseHandler) mContext;
        this.mContext = mContext;
        final SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();

        VolleyRequest volleyRequest = new VolleyRequest(String.format(URL.GET_DIST_MANDAL_VIllAGE, sharedPreferences.getString(Constants.LMO_CODE, "")),

                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        Realm realm = Realm.getDefaultInstance();
                        try {
                            if (response != null) {
                                Log.d(TAG, "GET_DIST_MANDAL_VIllAGE Success" + "\t" + statusCode);
                                JSONArray responseData = new JSONArray(response.toString());
                                realm.beginTransaction();
                                for (int i = 0; i < responseData.length(); i++) {
                                    JSONObject eachVillage = responseData.getJSONObject(i);
                                    VillageModel villageModel = new VillageModel();
                                    villageModel.setSubStationUID(eachVillage.getString("villageUid"));
                                    villageModel.setVillageSerialNumber(eachVillage.getString("villageSlno"));
                                    villageModel.setVillageName(eachVillage.getString("villageName"));
                                    villageModel.setMandalSerialNumber(eachVillage.getString("mandalSlno"));
                                    villageModel.setMandalName(eachVillage.getString("mandalName"));
                                    villageModel.setDistrictSerialNumber(eachVillage.getString("districtUid"));
                                    villageModel.setDistrictName(eachVillage.getString("districtName"));
                                    villageModel.setRegion(eachVillage.getString("enttaxZone"));
                                    villageModel.setVillageChecked(false);
                                    //save to district

                                    DistrictModel districtModel = new DistrictModel();
                                    districtModel.setDistrictName(eachVillage.getString("districtName"));
                                    districtModel.setDistrictID(eachVillage.getString("districtUid"));
                                    if (realm.where(DistrictModel.class).equalTo("districtID", eachVillage.getString("districtUid")).count() == 0) {
                                        // realm.beginTransaction();
                                        realm.copyToRealmOrUpdate(districtModel);
                                        //realm.commitTransaction();
                                        // Log.d("District","Success");
                                    }

                                    //realm.beginTransaction();
                                    realm.copyToRealmOrUpdate(villageModel);
                                }
                                realm.commitTransaction();


                                realm.close();
                                getAllSILMOPopOltVpn(mContext, requestType);
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            realm.cancelTransaction();
                            realm.close();
                            mCallBack.responseHandler(null, requestType);
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "Village Data Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    private void getAllSILMOPopOltVpn(final Context mContext, final int requestType) {
        mCallBack = (ResponseHandler) mContext;
        this.mContext = mContext;
        final SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();
        VolleyRequest volleyRequest = new VolleyRequest(String.format(URL.GET_SILMO_POP_OLT_VPN, sharedPreferences.getString(Constants.LMO_CODE, "")),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        Realm realm = Realm.getDefaultInstance();
                        try {
                            if (response != null) {
                                Log.d(TAG, "GET_SILMO_POP_OLT_VPN Success" + "\t" + statusCode);
                                JSONArray responseData = new JSONArray(response.toString());

                                for (int i = 0; i < responseData.length(); i++) {
                                    JSONObject eachData = responseData.getJSONObject(i);
                                    SIPOPModel popModel = new SIPOPModel();

                                    popModel.setPopID(eachData.getString("substnUid"));
                                    popModel.setPopName(eachData.getString("substnName"));
                                    popModel.setDistrictId(eachData.getString("districtUid"));
                                    popModel.setMandalID(eachData.getString("mandalSlno"));
                                    popModel.setPOPChecked(false);

                                    String oltSrlno = eachData.getString("oltSrlno");
                                    String[] popOltData;
                                    if (oltSrlno.contains(",")) {
                                        popOltData = oltSrlno.split(",");
                                        for (String each : popOltData) {
                                            if (each.contains("-")) {
                                                createPopOlt(each, eachData.getString("substnUid"), each.split("-")[0], each.split("-")[1]);
                                            }
                                        }
                                    } else {
                                        if (oltSrlno.contains("-")) {
                                            createPopOlt(oltSrlno, eachData.getString("substnUid"), oltSrlno.split("-")[0], oltSrlno.split("-")[1]);
                                        }

                                    }
                                    String vpnSrvcName = eachData.getString("vpnSrvcName");
                                    String[] vpnservices;
                                    if (vpnSrvcName.contains(",")) {
                                        vpnservices = vpnSrvcName.split(",");
                                        for (String eachVpn : vpnservices) {
                                            if (vpnSrvcName.contains("^")) {
                                                createVpnModel(eachVpn, eachVpn.split("\\^")[0], eachVpn.split("\\^")[1], eachVpn.split("\\^")[2]);
                                            }
                                        }

                                    } else {
                                        if (vpnSrvcName.contains("^")) {
                                            createVpnModel(vpnSrvcName, vpnSrvcName.split("\\^")[0], vpnSrvcName.split("\\^")[1], vpnSrvcName.split("\\^")[2]);
                                        }
                                    }

                                    realm.beginTransaction();
                                    realm.copyToRealmOrUpdate(popModel);
                                    realm.commitTransaction();

                                }
                                realm.close();
                                getAllSILMOOltPortDetails(mContext, requestType);
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            realm.cancelTransaction();
                            realm.close();
                            mCallBack.responseHandler(null, requestType);
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "Village Data Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    private void getAllSILMOOltPortDetails(final Context mContext, final int requestType) {
        mCallBack = (ResponseHandler) mContext;
        this.mContext = mContext;

        final SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();
        VolleyRequest volleyRequest = new VolleyRequest(
                URL.GET_SILMO_OLT_PORT_DETAILS,
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        Realm realm = Realm.getDefaultInstance();
                        try {
                            if (response != null) {
                                Log.d(TAG, "GET_SILMO_OLT_PORT_DETAILS Success" + "\t" + statusCode);
                                JSONArray responseData = new JSONArray(response.toString());
                                realm.beginTransaction();
                                for (int i = 0; i < responseData.length(); i++) {
                                    JSONObject eachData = responseData.getJSONObject(i);
                                    OltPortDetails popModel = new OltPortDetails();
                                    popModel.setPopIdPortNo(eachData.getString("popOltSerialno") + eachData.getString("portNo"));
                                    popModel.setPopId(eachData.getString("popOltSerialno"));
                                    popModel.setPortNo(eachData.getString("portNo"));
                                    realm.copyToRealmOrUpdate(popModel);
                                }
                                realm.commitTransaction();
                                realm.close();
                                getAllSILMOCpeModels(mContext, requestType);
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            realm.cancelTransaction();
                            realm.close();
                            mCallBack.responseHandler(null, requestType);
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "Village Data Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    private void getAllSILMOCpeModels(final Context mContext, final int requestType) {
        mCallBack = (ResponseHandler) mContext;
        this.mContext = mContext;

        final SharedPreferences sharedPreferences = BaseApplication.getSharedPreferences();
        VolleyRequest volleyRequest = new VolleyRequest(
                URL.GET_SI_ALL_CPE_MODELS,
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        Realm realm = Realm.getDefaultInstance();
                        try {
                            if (response != null) {
                                Log.d(TAG, "GET_SI_ALL_CPE_MODELS Success" + "\t" + statusCode);
                                JSONArray responseData = new JSONArray(response.toString());
                                realm.beginTransaction();
                                for (int i = 0; i < responseData.length(); i++) {
                                    JSONObject eachData = responseData.getJSONObject(i);
                                    CPEDataModel cpeDataModel = new CPEDataModel();
                                    cpeDataModel.setCpeProfileIDcpeInstallmentCount(eachData.getInt("profileId") + "");
                                    cpeDataModel.setCpeProfileID(eachData.getInt("profileId"));
                                    cpeDataModel.setCpeModelName(eachData.getString("cpeModel"));
                                    cpeDataModel.setCpeLovType(eachData.getString("cpetypeLov"));
                                    realm.copyToRealmOrUpdate(cpeDataModel);
                                }
                                realm.commitTransaction();
                                realm.close();
                                mCallBack.responseHandler("Success", requestType);
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            realm.cancelTransaction();
                            realm.close();
                            mCallBack.responseHandler(null, requestType);
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        Log.d(TAG, "Village Data Fail" + "\t" + statusCode + "\t" + errorResponse.toString());
                        mCallBack.responseHandler(null, requestType);
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL, NO_OF_RETRIES, RETRY_MULTIPLIER));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    private void createPopOlt(String primaryKey, String substnId, String popOltSerialNo, String popLableNo) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        POPOLTModel popoltModel = new POPOLTModel();
        popoltModel.setPopOLTID(primaryKey);
        popoltModel.setPopID(substnId);
        popoltModel.setPopLabelNumber(popLableNo);
        popoltModel.setPopOLTSerialNumber(popOltSerialNo);
        Log.d(TAG, "pop model" + popoltModel.toString());
        realm.copyToRealmOrUpdate(popoltModel);
        realm.commitTransaction();

    }

    private void createVpnModel(String primaryKey, String substnId, String oltSerialNo, String vpnServiceName) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        VpnServiceModel vpnServiceModel = new VpnServiceModel();//model
        vpnServiceModel.setSubstnUid(substnId);
        vpnServiceModel.setVpnCompositeKey(primaryKey);
        vpnServiceModel.setOltSerialNo(oltSerialNo);
        vpnServiceModel.setVpnsrvcName(vpnServiceName);
        Log.d(TAG, "vpnServiceModel model" + vpnServiceModel.toString());
        realm.copyToRealmOrUpdate(vpnServiceModel);
        realm.commitTransaction();
    }


    public void validateOltSlots(final CustomerCPEInfoFragment mContext, JSONObject requestData, final int requestType) {
        final ResponseHandler mCallBack = (ResponseHandler) mContext;
        //this.mContext = mContext;
        String lmoCode = null, oltSerialNumber = null, oltPortNumber = null, portSlotValue = null;
        //String level3SlotList = null;
        try {
            lmoCode = requestData.getString("lmoCode");
            oltSerialNumber = requestData.getString("oltSrlNo");
            oltPortNumber = requestData.getString("oltPort");
            portSlotValue = requestData.getString("l1L2slot");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String finalURL = String.format(URL.LOADL3PORTDATA, oltSerialNumber, lmoCode, oltPortNumber, portSlotValue);
        final JSONObject responseData = new JSONObject();
        VolleyRequest volleyRequest = new VolleyRequest(Request.Method.GET, finalURL,
                requestData.toString().replace("\\/", "/"),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        try {
                            Log.d(TAG, "oltSlot3 ports founds Successfully" + "\t" + statusCode + "\t" + response.toString());
                            mCallBack.responseHandler(response, requestType);
                        } catch (Exception ex) {
                            mCallBack.responseHandler(response, requestType);
                            ex.printStackTrace();
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        try {
                            Log.d(TAG, "oltSlot3 ports found Failed" + "\t" + statusCode + "\t" + errorResponse.toString());
                            responseData.put("oltSlot3 data empty", true);
                            Utils.errorDialog(mContext, "Error!", "Server Error!", null);
                            //mCallBack.responseHandler(responseData, requestType);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL_POST, NO_OF_RETRIES_POST, RETRY_MULTIPLIER_POST));
        VolleySingleton.getInstance(mContext.getActivity()).addToRequestQueue(volleyRequest);
    }

    public void searchCafNumber(final PonChangeActivity mContext, JSONObject requestData, final int requestType) {
        final ResponseHandler mCallBack = (ResponseHandler) mContext;
        String caf_num = null, lmoCode = null;

        try {
            caf_num = requestData.getString("caf_num");
            lmoCode = requestData.getString("lmocode");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String finalURL = String.format(URL.PONCHANGE_SEARCH_CAF_NUMBER, caf_num, lmoCode);
        final JSONObject responseData = new JSONObject();
        VolleyRequest volleyRequest = new VolleyRequest(Request.Method.GET, finalURL,
                requestData.toString().replace("\\/", "/"),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        try {
                            Log.d(TAG, "caf found Successfully" + "\t" + statusCode + "\t" + response.toString());
                            mCallBack.responseHandler(response, requestType);
                        } catch (Exception ex) {
                            mCallBack.responseHandler(response, requestType);
                            ex.printStackTrace();
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        try {
                            Log.d(TAG, "caf found Failed" + "\t" + statusCode + "\t" + errorResponse.toString());
                            responseData.put("caf not found", true);
                            Utils.cancelProgress();
                            Utils.showCafErrorDialog(mContext, "No data found", " Caf No might be wrong or Caf not assigned to current LMO", 0);

                            //mCallBack.responseHandler(responseData, requestType);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL_POST, NO_OF_RETRIES_POST, RETRY_MULTIPLIER_POST));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    public void getLmoOlts(final ChangeOltDetailsActivity mContext, JSONObject requestData, final int requestType) {
        final ResponseHandler mCallBack = (ResponseHandler) mContext;
        String caf_num = null, lmoCode = null;

        try {
            caf_num = requestData.getString("caf_num");
            lmoCode = requestData.getString("lmocode");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String finalURL = String.format(URL.PONCHANGE_GET_LMO_OLT, caf_num, lmoCode);
        final JSONObject responseData = new JSONObject();
        VolleyRequest volleyRequest = new VolleyRequest(Request.Method.GET, finalURL,
                requestData.toString().replace("\\/", "/"),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        try {
                            Log.d(TAG, "caf found Successfully" + "\t" + statusCode + "\t" + response.toString());
                            mCallBack.responseHandler(response, requestType);
                        } catch (Exception ex) {
                            mCallBack.responseHandler(response, requestType);
                            ex.printStackTrace();
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        try {
                            Log.d(TAG, "caf found Failed" + "\t" + statusCode + "\t" + errorResponse.toString());
                            responseData.put("caf not found", true);
                            Utils.cancelProgress();
                            Utils.showCafErrorDialog(mContext, "No data found", " Caf No might be wrong or Caf not assigned to current LMO", 0);

                            //mCallBack.responseHandler(responseData, requestType);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL_POST, NO_OF_RETRIES_POST, RETRY_MULTIPLIER_POST));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    public void getOLTPortSplitterData(final ChangeOltDetailsActivity mContext, JSONObject requestData, final int requestType) {
        final ResponseHandler mCallBack = (ResponseHandler) mContext;
        String oltSrlNo = null, lmoCode = null, oltPort = null, l1slot = null;

        try {
            oltSrlNo = requestData.getString("oltSrlNo");
            lmoCode = requestData.getString("lmoCode");
            oltPort = requestData.getString("oltPort");
            l1slot = requestData.getString("l1slot");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String finalURL = String.format(URL.OLT_PORT_SPLITTER_DATA, oltSrlNo, lmoCode, oltPort, l1slot);
        final JSONObject responseData = new JSONObject();
        VolleyRequest volleyRequest = new VolleyRequest(Request.Method.GET, finalURL,
                requestData.toString().replace("\\/", "/"),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        try {
                            Log.d(TAG, "l1slot found Successfully" + "\t" + statusCode + "\t" + response.toString());
                            mCallBack.responseHandler(response, requestType);
                        } catch (Exception ex) {
                            mCallBack.responseHandler(response, requestType);
                            ex.printStackTrace();
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        try {
                            Log.d(TAG, "l1slot found Failed" + "\t" + statusCode + "\t" + errorResponse.toString());
                            responseData.put("l1slot not found", true);
                            Utils.showCafErrorDialog(mContext, "No data found", " Caf No might be wrong or Caf not assigned to current LMO", 0);

                            //mCallBack.responseHandler(responseData, requestType);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL_POST, NO_OF_RETRIES_POST, RETRY_MULTIPLIER_POST));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    public void getOLTL3PortSplitterData(final ChangeOltDetailsActivity mContext, JSONObject requestData, final int requestType) {
        final ResponseHandler mCallBack = (ResponseHandler) mContext;
        String oltSrlNo = null, lmoCode = null, oltPort = null, l1L2slot = null;

        try {
            oltSrlNo = requestData.getString("oltSrlNo");
            lmoCode = requestData.getString("lmoCode");
            oltPort = requestData.getString("oltPort");
            l1L2slot = requestData.getString("l1L2slot");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String finalURL = String.format(URL.OLT_L3_PORT_SPLITTER_DATA, oltSrlNo, lmoCode, oltPort, l1L2slot);
        final JSONObject responseData = new JSONObject();
        VolleyRequest volleyRequest = new VolleyRequest(Request.Method.GET, finalURL,
                requestData.toString().replace("\\/", "/"),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        try {
                            Log.d(TAG, "l3slot found Successfully" + "\t" + statusCode + "\t" + response.toString());
                            mCallBack.responseHandler(response, requestType);
                        } catch (Exception ex) {
                            mCallBack.responseHandler(response, requestType);
                            ex.printStackTrace();
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        try {
                            Log.d(TAG, "l3slot found Failed" + "\t" + statusCode + "\t" + errorResponse.toString());
                            responseData.put("l3slot not found", true);
                            Utils.showCafErrorDialog(mContext, "No data found", " Caf No might be wrong or Caf not assigned to current LMO", 0);

                            //mCallBack.responseHandler(responseData, requestType);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL_POST, NO_OF_RETRIES_POST, RETRY_MULTIPLIER_POST));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    public void getAllDistricts(final ChangeOltDetailsActivity mContext, JSONObject requestData, final int requestType) {
        final ResponseHandler mCallBack = (ResponseHandler) mContext;

        String finalURL = String.format(URL.ALL_DISTRICTS);
        final JSONObject responseData = new JSONObject();
        VolleyRequest volleyRequest = new VolleyRequest(Request.Method.GET, finalURL,
                requestData.toString().replace("\\/", "/"),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        try {
                            Log.d(TAG, "Districts found Successfully" + "\t" + statusCode + "\t" + response.toString());
                            mCallBack.responseHandler(response, requestType);
                        } catch (Exception ex) {
                            mCallBack.responseHandler(response, requestType);
                            ex.printStackTrace();
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        try {
                            Log.d(TAG, "Districts found Failed" + "\t" + statusCode + "\t" + errorResponse.toString());
                            responseData.put("Districts not found", true);
                            Utils.showCafErrorDialog(mContext, "No data found", " Caf No might be wrong or Caf not assigned to current LMO", 0);

                            //mCallBack.responseHandler(responseData, requestType);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL_POST, NO_OF_RETRIES_POST, RETRY_MULTIPLIER_POST));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    public void getMandalsByDistrictId(final ChangeOltDetailsActivity mContext, JSONObject requestData, final int requestType) {
        final ResponseHandler mCallBack = (ResponseHandler) mContext;
        String districtId = null;

        try {
            districtId = requestData.getString("districtId");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String finalURL = String.format(URL.ALL_MANDALS, districtId);
        final JSONObject responseData = new JSONObject();
        VolleyRequest volleyRequest = new VolleyRequest(Request.Method.GET, finalURL,
                requestData.toString().replace("\\/", "/"),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        try {
                            Log.d(TAG, "Mandals found Successfully" + "\t" + statusCode + "\t" + response.toString());
                            mCallBack.responseHandler(response, requestType);
                        } catch (Exception ex) {
                            mCallBack.responseHandler(response, requestType);
                            ex.printStackTrace();
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        try {
                            Log.d(TAG, "Mandals found Failed" + "\t" + statusCode + "\t" + errorResponse.toString());
                            responseData.put("Mandals not found", true);
                            Utils.showCafErrorDialog(mContext, "No data found", " Caf No might be wrong or Caf not assigned to current LMO", 0);

                            //mCallBack.responseHandler(responseData, requestType);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL_POST, NO_OF_RETRIES_POST, RETRY_MULTIPLIER_POST));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    public void getVillagesByDistrictIdAndMandalId(final ChangeOltDetailsActivity mContext, JSONObject requestData, final int requestType) {
        final ResponseHandler mCallBack = (ResponseHandler) mContext;
        String districtId = null, mandalId = null;

        try {
            districtId = requestData.getString("districtId");
            mandalId = requestData.getString("mandalId");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String finalURL = String.format(URL.PONCHANGE_GET_ALL_VILLAGES, districtId, mandalId);
        final JSONObject responseData = new JSONObject();
        VolleyRequest volleyRequest = new VolleyRequest(Request.Method.GET, finalURL,
                requestData.toString().replace("\\/", "/"),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        try {
                            Log.d(TAG, "villages found Successfully" + "\t" + statusCode + "\t" + response.toString());
                            mCallBack.responseHandler(response, requestType);
                        } catch (Exception ex) {
                            mCallBack.responseHandler(response, requestType);
                            ex.printStackTrace();
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        try {
                            Log.d(TAG, "villages found Failed" + "\t" + statusCode + "\t" + errorResponse.toString());
                            responseData.put("villages not found", true);
                            Utils.showCafErrorDialog(mContext, "No data found", " Caf No might be wrong or Caf not assigned to current LMO", 0);

                            //mCallBack.responseHandler(responseData, requestType);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL_POST, NO_OF_RETRIES_POST, RETRY_MULTIPLIER_POST));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    public void updatePonChange(final ChangeOltDetailsActivity mContext, JSONObject requestData, final int requestType) {
        final ResponseHandler mCallBack = (ResponseHandler) mContext;
        String cafNo = null, newOltSerialNo = null, newOltPort = null, oltIp = null, oldOltPort = null, ponChangeUrl = null, onuId = null, splitter = null, oldOltSrlNo = null, lmoCode = null;
        try {
            ponChangeUrl = requestData.getString("ponChangeUrl");
            ponChangeUrl = ponChangeUrl.replace("\\", "/");
            cafNo = requestData.getString("cafNo");
            newOltSerialNo = requestData.getString("newOltSerialNo");
            newOltPort = requestData.getString("newOltPort");
            oltIp = requestData.getString("oltIp");
            oldOltPort = requestData.getString("oldOltPort");
            //ponChangeUrl = requestData.getString("ponChangeUrl");
            onuId = requestData.getString("onuId");
            splitter = requestData.getString("splitter");
            oldOltSrlNo = requestData.getString("oldOltSrlNo");
            lmoCode = requestData.getString("lmoCode");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String finalURL = String.format(URL.UPDATE_PONCHANGE, cafNo, newOltSerialNo, newOltPort, oltIp, oldOltPort, ponChangeUrl, onuId, splitter, oldOltSrlNo, lmoCode);
        final JSONObject responseData = new JSONObject();
        VolleyRequest volleyRequest = new VolleyRequest(Request.Method.GET, finalURL,
                requestData.toString().replace("\\/", "/"),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        try {
                            Log.d(TAG, "ponchange updated Successfully" + "\t" + statusCode + "\t" + response.toString());
                            mCallBack.responseHandler(response, requestType);
                        } catch (Exception ex) {
                            mCallBack.responseHandler(response, requestType);
                            ex.printStackTrace();
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        try {
                            Log.d(TAG, "ponchange update Failed" + "\t" + statusCode + "\t" + errorResponse.toString());
                            responseData.put("ponchange udpate failed", true);
                            Utils.showCafErrorDialog(mContext, "PonChange Info", "Ponchange updation failed", 0);

                            //mCallBack.responseHandler(responseData, requestType);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL_POST, NO_OF_RETRIES_POST, RETRY_MULTIPLIER_POST));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }

    public void updatePonChangeAddress(final ChangeOltDetailsActivity mContext, JSONObject requestData, final int requestType) {
        final ResponseHandler mCallBack = (ResponseHandler) mContext;
        String cafNo = null, addressLine1 = null, addressLine2 = null, locality = null, area = null, village = null, mandal = null, district = null;
        try {
            cafNo = requestData.getString("cafNo");
            addressLine1 = requestData.getString("addressLine1");
            addressLine2 = requestData.getString("addressLine2");
            locality = requestData.getString("locality");
            area = requestData.getString("area");
            village = requestData.getString("village");
            mandal = requestData.getString("mandal");
            district = requestData.getString("district");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String finalURL = String.format(URL.PONCHANGE_ADDRESS_UPDATE, cafNo, addressLine1, addressLine2, locality, area, village, mandal, district);
        final JSONObject responseData = new JSONObject();
        VolleyRequest volleyRequest = new VolleyRequest(Request.Method.GET, finalURL,
                requestData.toString().replace("\\/", "/"),
                new VolleyRequest.onSuccess() {
                    @Override
                    public void onResponse(int statusCode, Object response) {
                        try {
                            Log.d(TAG, "address updated Successfully" + "\t" + statusCode + "\t" + response.toString());
                            mCallBack.responseHandler(response, requestType);
                        } catch (Exception ex) {
                            mCallBack.responseHandler(response, requestType);
                            ex.printStackTrace();
                        }
                    }
                },
                new VolleyRequest.onFailure() {
                    @Override
                    public void onError(int statusCode, Object errorResponse) {
                        try {
                            Log.d(TAG, "address update Failed" + "\t" + statusCode + "\t" + errorResponse.toString());
                            responseData.put("address udpate failed", true);
                            Utils.showCafErrorDialog(mContext, "Address Update", " Address update failed", 0);

                            //mCallBack.responseHandler(responseData, requestType);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
        volleyRequest.setRequestHeaders(getHeaders());
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy(TIMEOUT_INITIAL_POST, NO_OF_RETRIES_POST, RETRY_MULTIPLIER_POST));
        VolleySingleton.getInstance(mContext).addToRequestQueue(volleyRequest);
    }
}
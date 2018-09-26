package com.app.apsfl.interfaces;

import android.content.Context;
import android.support.v4.app.Fragment;

import org.json.JSONObject;


public interface RequestInterface {

    void userLogin(final Context mContext, final String userName, final String userPassword, final int requestType);

    void forgotPassword(final Context mContext, final String lmoUserName, final int requestType);

    void changePassword(final Context context, final JSONObject requestData, final int requestType);

    void getMasterData(final Context mContext, final int requestType);

    void getDetailsFromAadhaar(final Context mContext, final Fragment mFragment, final String aadhaarNumber, final int requestType);

    void getCAFNumber(final Context mContext, final int requestType);

    void submitCAFForm(final Context mContext, final Fragment mFragment,
                       final JSONObject requestData, final int requestType);

    void submitCAFPackages(final Context context, final Fragment mFragment, final JSONObject requestData, final int requestType);

    void submitCAFPayment(final Context context, final Fragment mFragment, final JSONObject requestData, final int requestType);

    void submitMonthlyPayment(final Context context, final JSONObject requestData, final int requestType);


    void getWalletBalance(final Context mContext, final Fragment mFragment, final int requestType);

    void getMonthlyPayments(final Context mContext, final String data, final int requestType);

    void getSearchCAFResults(final Context mContext, final JSONObject requestData, final int requestType);

    //void getCAFPaymentDetails(final Context mContext, String cafNumber, String district, String mandal, String village, String billCycle, final int requestType);

    void getCAFDetails(final Context mContext, final String cafNumber, final String editCafStatus, final int requestType);

    void sendOTP(final Context mContext, final Object requestBody, final int requestType);

    void getOltPorts(final Context mContext, final int requestType);

    void getAllSILMOMandals(final Context mContext, final Fragment mFragment, String districtId, final int requestType);

    void getAllSILMOPOPData(final Context mContext, final Fragment mFragment, String mandalId, String districtId, final int requestType);

    void getAllSILMOVillages(final Context mContext, final Fragment mFragment, String mandalId, String districtId, final int requestType);

    void getSILMOMasterData2(final Context mContext, final Fragment mFragment, String substnUid, String districtId, String mandalId, String villageId,final int requestType);

    void getSelectedPackages(final Context mContext, final Fragment mFragment, String cafNo, String billCycle, final int requestType);

    void getCoreSrvcCodeByCafNo(final Context mContext, final Fragment mFragment, String cafNo, final int requestType);

    void getSILMOVPNSrvcNamesList(final Context mContext, final Fragment mFragment, String oltSrlNo, String subStnId, final int requestType);

    //void getSILMORegion(final Context mContext, final Fragment mFragment , String districtId, String mandalId, String villageId, final int requestType);

    void getPendingEditDistrict(final Context mContext, final int requestType);

    void getPendingEditMandal(final Context mContext,String district, final int requestType);
    void getEditPopData(final Context mContext, String mandalId, String districtId, final int requestType);
    void getSILMOMasterData(final Context mContext, final int requestType);
}
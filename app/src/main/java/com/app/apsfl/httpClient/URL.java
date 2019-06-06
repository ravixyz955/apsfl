package com.app.apsfl.httpClient;

import com.app.apsfl.activities.LoginActivity;

import retrofit2.http.PUT;

class URL {

    // Development URL : http://183.82.105.224:8080/

    // Production URL : http://bss.apsfl.co.in/apsfl

    //private static final String BASE_URL = "http://183.82.105.224:8380/";

/*
    private static final String BASE_URL = "http://192.168.43.215:8080/";
*/


    public static final String CHECK_SPLITTER_URL = "http://10.8.0.25:8080/coms/checkSlotsAvailability?oltSrlNo=%s&oltPort=%s&portSlotValue=%s";


    private static final String BASE_URL = "http://172.16.0.48:9090/";
//    private static final String BASE_URL = "http://bss.apsfl.co.in/";//Production

    //private static final String BASE_URL1 = "http://192.168.0.112:8080/";
    //private static final String BASE_URL = "http://"+ LoginActivity.ip_address+"/";
    public static final String INDVILLAGE_URL = "http://172.16.0.48:9090/coms/allVillages?subStnCodes=%s&tenantCode=%s";//Production

    //public static final String LOADL3PORTDATA = "http://10.8.0.18:8080/coms/getOLTL3PortSplitterData?oltSrlNo=%s&lmoCode=%s&oltPort=%s&l1L2slot=%s";
    public static final String LOADL3PORTDATA = BASE_URL + "coms/getOLTL3PortSplitterData?oltSrlNo=%s&lmoCode=%s&oltPort=%s&l1L2slot=%s";

    public static final String BULK_URL = BASE_URL + "coms/searchBulkMonthlyPaymentCafDetails1";//Production
    public static final String SEARCH_BULK_MONTLY_PAYMENT = BASE_URL + "coms/searchBulkMonthlyPaymentCafDetails";

    public static final String BULK_MONTHLY_PAY_URL = BASE_URL + "coms/createBulkPaymentDetails";//Production
    public static final String BULK_REVENUE_URL = BASE_URL + "ums/LoginLmoTenantRevenueShare?year=%s&month=%s&lmocode=%s";//

    public static final String PONCHANGE_SEARCH_CAF_NUMBER = BASE_URL + "coms/ponChangeGetCafDetails?cafNo=%s&lmoCode=%s";
    public static final String PONCHANGE_GET_LMO_OLT = BASE_URL + "coms/ponChangeGetLmoOlts?cafNo=%s&lmoCode=%s";
    public static final String OLT_PORT_SPLITTER_DATA = BASE_URL + "coms/getOLTPortSplitterData?oltSrlNo=%s&lmoCode=%s&oltPort=%s&l1slot=%s";
    public static final String OLT_L3_PORT_SPLITTER_DATA = BASE_URL + "coms/getOLTL3PortSplitterData?oltSrlNo=%s&lmoCode=%s&oltPort=%s&l1L2slot=%s";
    public static final String ALL_DISTRICTS = BASE_URL + "coms/alldistricts";
    public static final String ALL_MANDALS = BASE_URL + "coms/getMandalsByDistrictId?districtId=%S";
    public static final String PONCHANGE_GET_ALL_VILLAGES = BASE_URL + "coms/getVillagesByDistrictIdAndMandalId?districtId=%s&mandalId=%s";
    public static final String UPDATE_PONCHANGE = BASE_URL + "coms/updatePonChange?cafNo=%s&newOltSerialNo=%s&newOltPort=%s&oltIp=%s&oldOltPort=%s&ponChangeUrl=%s&onuId=%s&splitter=%s&oldOltSrlNo=%s&lmoCode=%s";
    public static final String PONCHANGE_ADDRESS_UPDATE = BASE_URL + "coms/updateCafAddress?cafNo=%s&addressLine1=%s&addressLine2=%s&locality=%s&area=%s&village=%s&mandal=%s&district=%s";

    static final String LOGIN = BASE_URL + "ums/login?loginId=%s&password=%s&version=%s";

    static final String FORGOT_PASSWORD = BASE_URL + "ums/forgotPwd?loginID=%s";

    static final String CHANGE_PASSWORD = BASE_URL + "ums/updatePassword";

    static final String GET_ALL_CPE_MODELS = BASE_URL + "coms/getAllCpeCharges?region=%S";

    static final String GET_ALL_DISTRICTS = BASE_URL + "coms/alldistricts";

    static final String GET_ALL_MANDALS = BASE_URL + "coms/allmandals?districtId=%s";

    static final String GET_ALL_SILMO_MANDALS = BASE_URL + "coms/getMandalsByDistrictId?districtId=%s";

    static final String GET_ALL_VILLAGES = BASE_URL + "coms/allVillages?subStnCodes=%s&tenantCode=%s";

    static final String GET_ALL_SILMO_VILLAGES = BASE_URL + "coms/getVillagesByDistrictIdAndMandalId?districtId=%s&mandalId=%s";

    static final String GET_ALL_POP_NAMES = BASE_URL + "coms/allsubstations?subStationCodes=%s";

    static final String GET_ALL_SILMO_POP_NAMES = BASE_URL + "coms/getSubstationsByDistrictIdAndMandalId?districtId=%s&mandalId=%s";

    static final String GET_ALL_OLT_DATA = BASE_URL + "coms/alloltdata?subStnSrlNo=%s";

    static final String GET_ALL_OLT_PORT_DETAILS = BASE_URL + "coms/allOLTPortDetails?tenantCode=%s";

    static final String GET_ALL_PACKAGES = BASE_URL + "cat/pcs/getAllProductsByLmoCode?lmoCode=%s" +
            "&custType=%s&charFlags=1,2,3&region=%s";

    static final String GET_ALL_ENTERPRISE_CUSTOMERS = BASE_URL + "coms/allenterpriseCustomers?tenantCode=%s";

    static final String GET_ALL_TAX_REGIONS = BASE_URL + "coms/getAllTaxRegions";

    static final String GET_ALL_CHARGE_TAXES = BASE_URL + "coms/getAllChargeTaxes";//need to check

    static final String GET_ALL_TAXES = BASE_URL + "coms/getAllTaxes";

    static final String GET_CAF_NUMBER = BASE_URL + "coms/getCafNumber";

    static final String GET_DETAILS_AADHAAR = BASE_URL + "coms/getAadharDetails?aadharNumber=%s";

    static final String GET_ALL_LOVS = BASE_URL + "cat/pcs/getAllLovsByLovNames?lovName=" +
            "TITLES,CUSTOMER%20SEGMENTS,SALES%20CHANNELS,BILL%20FREQUENCY,HotlinePriority,VMADDRESS";

    static final String MONTHLY_PAYMENT_DETAILS = BASE_URL + "coms/getMonthlyPaymentDetails?mobileNo=%s&tenantCode=%s";

    static final String GET_WALLET_BALANCE = BASE_URL + "coms/getTenantWalletBalence?tenantCode=%s";

    static final String GET_CAF_DETAILS = BASE_URL + "coms/getCafDetailsForEdit?cafNo=%s&status=%s";

    static final String SEARCH_CAF = BASE_URL + "coms/searchMultiActionCafDetails";

    static final String GET_CAF_PAYMENT_DETAILS = BASE_URL +
            "coms/cafPaymentDetails?cafNo=%s&district=%s&mandal=%s&village=%s&billCycle=%s";

    static final String GET_FEATURE_PARAMS = BASE_URL + "coms/getAllFeatureParams";

    static final String GET_CPE_STOCK_LMO = BASE_URL + "coms/getAllCpeStockByLmoCode?lmoCode=%s";

    static final String GET_CPE_STOCK_MSP = BASE_URL + "coms/getAllCpeStockByMspCode?mspCode=%s";

    static final String SEND_OTP = BASE_URL + "coms/sendSMS";

    static final String SAVE_CAF_FORM = BASE_URL + "coms/saveCaf";

    static final String SAVE_CAF_PACKAGES = BASE_URL + "coms/savePackages";

    static final String SAVE_CAF_PAYMENT = BASE_URL + "coms/savePayment";

    static final String GET_SELECTED_PACKAGES = BASE_URL + "coms/cafPaymentDetails?cafNo=%s&billCycle=%s";

    static final String GET_CORESERVICECODE = BASE_URL + "coms/getCoreSrvcCodeByCafNo?cafNo=%s";

    static final String GET_LMOVPNSERVICELIST = BASE_URL + "coms/getLMOVPNSrvcNamesList?subStnId=%s";

    static final String GET_SILMOVPNSERVICELIST = BASE_URL + "coms/getVPNServicesByPopIdAndOltSrlNo?oltSrlNo=%s&subStnId=%s";

    static final String GET_SILMREGIN = BASE_URL + "coms/getRegionByDistrictAndMandalAndVillage?district=%s&mandal=%S&village=%S";

    static final String GET_EDIT_DISTRICT = BASE_URL + "coms/getSILMODistricts?tenantcode=%s";

    static final String GET_EDIT_MANDAL = BASE_URL + "coms/getSILMOMandals?tenantcode=%s&district=%s";

    static final String GET_DIST_MANDAL_VIllAGE = BASE_URL + "coms/allVillagesByDistrictId?tenantCode=%s";

    static final String GET_SILMO_POP_OLT_VPN = BASE_URL + "coms/allSubstationsByDistrictId?tenantCode=%s";

    static final String GET_SILMO_OLT_PORT_DETAILS = BASE_URL + "coms/allOLTPortDetailsByTenantCode?tenantCode=APSFL";

    static final String GET_SI_ALL_CPE_MODELS = BASE_URL + "coms/allcpemodals";
}
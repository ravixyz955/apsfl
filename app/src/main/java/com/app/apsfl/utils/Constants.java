package com.app.apsfl.utils;

import com.app.apsfl.models.VOIPSavedModel;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Constants {

    public static int cafType = 1;
    public static Long formTime = null;
    public static boolean isCAFInEditMode = false;
    public static boolean isFromCAFResults = false;
    public static int billFrequencyValue = 1;
    public static JSONObject aadhaarData = null;
    public static boolean isFromBasePackage = false;
    public static boolean isCAFInEditSILMO = false;
    public static String version = "2.11";


    public static String cafNumber = "";
    public static String customerID = "";
    public static String pinCode = "";
    public static String billCycle = "";
    public static String districtID = "";
    public static String mandalID = "";
    public static String villageID = "";
    public static String oltSerialNumber = "";
    public static String oltPortNumber = "";
    public static HashMap<String, ArrayList<VOIPSavedModel>> map;
    public static String Allpackages = "";
    public static String apsflTrackId = "";

    // Shared Preferences Keys
    public static final String USER_NAME = "userName";
    public static final String USER_PASSWORD = "userPassword";
    public static final String LMO_NAME = "lmoName";
    public static final String LMO_CODE = "lmoCode";
    public static final String SUB_STATION_CODES = "subStationCodes";
    public static final String LMO_MOBILE_NUMBER = "lmoMobile";
    public static final String LMO_REGIONS_LIST = "lmoregionlist";
    public static final String TENANT_TYPE = "tenantType";

    /*
     * API request Types
     * */
    public static final int INDIVIDUALVILLAGE_REQUEST = 601;
    public static final int SEARCH_CAF_NUMBER = 801;
    public static final int GET_LMO_OLTS = 802;
    public static final int OLT_SPLITTER_DATA = 803;
    public static final int L2_SLOT_DATA = 804;
    public static final int L3_SLOT_DATA = 805;
    public static final int ALL_DISTRICTS = 806;
    public static final int ALL_MANDALS = 807;
    public static final int PONCHANGE_GET_ALL_VILLAGES = 808;
    public static final int UPDATE_PONCHANGE = 809;
    public static final int PONCHANGE_ADDRESS_UPDATE = 810;
    public static final int OLTSLOT3_SLOT_DATA = 800;

    public static final int BULKPAYMET_REQUEST = 600;
    public static final int BULKPAYMET_NEXT_REQUEST = 605;
    public static final int BULKPAYMET_REQUESTSEND = 602;
    public static final int REVENUESHARING_REQUEST = 700;
    public static final int SEARCH_BULK_PAYMENT = 701;
    public static final int LOGIN_REQUEST = 100;
    public static final int GET_DETAILS_AADHAAR = 102;
    public static final int GET_CAF_NUMBER = 103;
    public static final int SAVE_CAF_FORM = 105;
    public static final int SAVE_CAF_PACKAGES = 104;
    public static final int SAVE_CAF_PAYMENT = 106;
    public static final int GET_WALLET_BALANCE = 107;
    public static final int GET_MONTHLY_PAYMENTS = 108;
    public static final int SEARCH_CAF_RESULTS = 109;
    public static final int GET_CAF_PAYMENT_DETAILS = 110;
    public static final int GET_CAF_DETAILS = 111;
    public static final int SEND_OTP = 112;
    public static final int SEND_OTP2 = 113;
    public static final int GET_MASTER_DATA = 115;
    public static final int FORGOT_PASSWORD_REQUEST = 116;
    public static final int CHANGE_PASSWORD = 117;
    public static final int GET_MANDALDATA = 118;
    public static final int GET_SILMOVILLAGEDATA = 119;
    public static final int GET_SILMOPOPDATA = 120;
    public static final int GET_SILMOMASTERDATA = 121;
    public static final int GET_SILMOPOPMANDALDATA = 122;
    public static final int GET_PACKAGES = 123;
    public static final int CORESERVICECODE = 124;
    public static final int GET_VPNSRVCNAMES = 125;
    public static final int GET_EDIT_DISTRICT = 126;
    public static final int GET_EDIT_MANDAL = 127;
    public static final int GET_EDIT_POP = 128;
    public static final int GET_SILMOPOPDATA2 = 129;

    /*
     * Dialog dismiss Types
     * */
    public static final int DISCARD_FORM = 1002;
    public static final int PAYMENT_DISCARD = 1004;
    public static final int PAYMENT_SUCCESS = 1005;
    public static final int PAYMENT_FAILURE = 1006;
    public static final int USER_LOGOUT = 1007;
    public static final int SAVE_CAF_OFFLINE = 1008;
    public static final int PAYMENT_GREATER_70 = 1009;
    public static final int PAYMENT_GREATER_90 = 1010;
    public static final int CHANGE_PWD_SUCCESS = 1011;
    public static final int FORGOT_PASSWORD_DIALOG = 1012;
    public static final int PERMISSION_REQUEST_CODE = 1013;
    public static final int SAVE_IN_PENDING = 1014;
    public static final int SAVE_IN_OFFLINE_CAFS = 1015;
    /**
     * Product Row View Types
     */
    public static final int PRODUCT_CHECK = 2000;
    public static final int PRODUCT_SHOW_MORE = 2001;
    public static final int PENDING_CAF_SUBMIT = 2002;
    public static final int PENDING_CAF_EDIT = 2003;
    public static final int SELECT_PACKAGES = 2004;
    public static final int PENDING_CAF_SILMO_EDIT = 2005;
}

package com.app.apsfl.Ekyc;

public class APIUtils {

    private APIUtils() {
    }

    public static final String BASE_URL = "http://172.16.0.48:9090/coms/";
    //public static final String BASE_URL = "http://bss.apsfl.co.in/coms/";

    public static APIService getAPIService() {
        return APIClient.getClient(BASE_URL).create(APIService.class);
    }
}
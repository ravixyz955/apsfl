package com.app.apsfl.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Arbiva on 2/8/2017.
 */

public class SIOfflineFormModel extends RealmObject {
    @PrimaryKey
    private String apsflTrackId;
    private String formPaymentData;
    private String cafOTPNumber;//otp
    private String cafNumber;
    private Boolean isNetworkAvailble;
    private Boolean isFormUploaded;
    private String statusMessage;

    public String getApsflTrackId() {
        return apsflTrackId;
    }

    public void setApsflTrackId(String apsflTrackId) {
        this.apsflTrackId = apsflTrackId;
    }

    public String getFormPaymentData() {
        return formPaymentData;
    }

    public void setFormPaymentData(String formPaymentData) {
        this.formPaymentData = formPaymentData;
    }

    public Boolean getNetworkAvailble() {
        return isNetworkAvailble;
    }

    public void setNetworkAvailble(Boolean networkAvailble) {
        isNetworkAvailble = networkAvailble;
    }

    public Boolean isFormUploaded() {
        return isFormUploaded;
    }

    public void setFormUploaded(Boolean formUploaded) {
        isFormUploaded = formUploaded;
    }

    public String getCafOTPNumber() {
        return cafOTPNumber;
    }

    public void setCafOTPNumber(String cafOTPNumber) {
        this.cafOTPNumber = cafOTPNumber;
    }

    public String getCafNumber() {
        return cafNumber;
    }

    public void setCafNumber(String cafNumber) {
        this.cafNumber = cafNumber;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}

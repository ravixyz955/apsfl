package com.app.apsfl.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class OfflineFormModel extends RealmObject {

    @PrimaryKey
    private long formTime;
    private String enterpriseCustomerCode;
    private String cafOTPNumber;//otp
    private String formCAFData;//info,address
    private String formPaymentData;//cpescrenn+pkg+workorder
    private Boolean isPaymentDataAvailable;//to check work order data
    private Boolean isFormUploaded;//for identify pending for payment
    private String oltPortNumber;
    private String l1PortNumber;
    private String l2PortNumber;
    private String l3PortNumber;
    private String onuSerialNumber;
    private String stbSerialNumber;
    private Boolean isCpeSerialNoUsed;
    private int cafType;
    private String cafStatus;//Gettimg from Address model ..To send it in caf Json and payment Json...
    private Boolean isNetworkAvailble;
    private String statusMessage;

    public String getCafStatus() {
        return cafStatus;
    }

    public void setCafStatus(String cafStatus) {
        this.cafStatus = cafStatus;
    }

    public int getCafType() {
        return cafType;
    }

    public void setCafType(int cafType) {
        this.cafType = cafType;
    }

    public Boolean isCpeSerialNoUsed() {
        return isCpeSerialNoUsed;
    }

    public void setCpeSerialNoUsed(Boolean serialNoUsed) {
        isCpeSerialNoUsed = serialNoUsed;
    }

    public long getFormTime() {
        return formTime;
    }

    public void setFormTime(long formTime) {
        this.formTime = formTime;
    }

    public String getEnterpriseCustomerCode() {
        return enterpriseCustomerCode;
    }

    public void setEnterpriseCustomerCode(String enterpriseCustomerCode) {
        this.enterpriseCustomerCode = enterpriseCustomerCode;
    }

    public String getCafOTPNumber() {
        return cafOTPNumber;
    }

    public void setCafOTPNumber(String cafOTPNumber) {
        this.cafOTPNumber = cafOTPNumber;
    }

    public String getFormCAFData() {
        return formCAFData;
    }

    public void setFormCAFData(String formCAFData) {
        this.formCAFData = formCAFData;
    }

    public String getFormPaymentData() {
        return formPaymentData;
    }

    public void setFormPaymentData(String formPaymentData) {
        this.formPaymentData = formPaymentData;
    }

    public Boolean isPaymentDataAvailable() {
        return isPaymentDataAvailable;
    }

    public void setIsPaymentDataAvailable(Boolean isPaymentDataAvailable) {
        this.isPaymentDataAvailable = isPaymentDataAvailable;
    }

    public Boolean isFormUploaded() {
        return isFormUploaded;
    }

    public void setFormUploaded(Boolean formUploaded) {
        isFormUploaded = formUploaded;
    }

    public String getOltPortNumber() {
        return oltPortNumber;
    }

    public void setOltPortNumber(String oltPortNumber) {
        this.oltPortNumber = oltPortNumber;
    }

    public String getL1PortNumber() {
        return l1PortNumber;
    }

    public void setL1PortNumber(String l1PortNumber) {
        this.l1PortNumber = l1PortNumber;
    }

    public String getL2PortNumber() {
        return l2PortNumber;
    }

    public void setL2PortNumber(String l2PortNumber) {
        this.l2PortNumber = l2PortNumber;
    }

    public String getL3PortNumber() {
        return l3PortNumber;
    }

    public void setL3PortNumber(String l3PortNumber) {
        this.l3PortNumber = l3PortNumber;
    }

    public String getOnuSerialNumber() {
        return onuSerialNumber;
    }

    public void setOnuSerialNumber(String onuSerialNumber) {
        this.onuSerialNumber = onuSerialNumber;
    }

    public String getStbSerialNumber() {
        return stbSerialNumber;
    }

    public void setStbSerialNumber(String stbSerialNumber) {
        this.stbSerialNumber = stbSerialNumber;
    }

    public Boolean getNetworkAvailble() {
        return isNetworkAvailble;
    }

    public void setNetworkAvailble(Boolean networkAvailble) {
        isNetworkAvailble = networkAvailble;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    @Override
    public String toString() {
        return "OfflineFormModel{" +
                "formTime=" + formTime + "\n" +
                ", enterpriseCustomerCode=" + enterpriseCustomerCode + "\n" +
                ", cafOTPNumber=" + cafOTPNumber + "\n" +
                ", oltPortNumber=" + oltPortNumber + "\n" +
                ", l1PortNumber=" + l1PortNumber + "\n" +
                ", l2PortNumber=" + l2PortNumber + "\n" +
                ", l3PortNumber=" + l3PortNumber + "\n" +
                ", onuSerialNumber=" + onuSerialNumber + "\n" +
                ", stbSerialNumber=" + stbSerialNumber + "\n" +
                ", cafOTPNumber=" + cafOTPNumber + "\n" +
                ", cafOTPNumber=" + cafOTPNumber + "\n" +
                ", formCAFData='" + formCAFData + '\'' + "\n" +
                ", formPaymentData='" + formPaymentData + '\'' + "\n" +
                ", isPaymentDataAvailable='" + isPaymentDataAvailable + '\'' + "\n" +
                ", isFormUploaded=" + isFormUploaded + "\n" +
                '}';
    }
}

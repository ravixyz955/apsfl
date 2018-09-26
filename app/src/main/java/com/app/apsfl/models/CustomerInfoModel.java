package com.app.apsfl.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CustomerInfoModel extends RealmObject {

    @PrimaryKey
    private Long formTime;
    private String customerAadhaarNumber;
    private Integer customerTitle;
    private String customerFirstName;
    private String customerMiddleName;
    private String customerLastName;
    private String customerFatherName;
    private String customerDOB;
    private Integer customerGender;
    private String contactPersonName;
    private String customerEmail;
    private Integer billFrequencyPosition;
    private Integer billCyclePosition;
    private Integer segmentPosition;
    private Integer channelPosition;
    private String customerPAN;
    private String customerTAN;
    private String allPackagesSILMO;
    private String cafStatus;
    private boolean isDataFromAadhar;
    private String status;//To disable customer info fields for select packages edit


    public String getAllPackagesSILMO() {
        return allPackagesSILMO;
    }

    public void setAllPackagesSILMO(String allPackagesSILMO) {
        this.allPackagesSILMO = allPackagesSILMO;
    }

    public Long getFormTime() {
        return formTime;
    }

    public void setFormTime(Long formTime) {
        this.formTime = formTime;
    }

    public String getCustomerAadhaarNumber() {
        return customerAadhaarNumber;
    }

    public void setCustomerAadhaarNumber(String customerAadhaarNumber) {
        this.customerAadhaarNumber = customerAadhaarNumber;
    }

    public Integer getCustomerTitle() {
        return customerTitle;
    }

    public void setCustomerTitle(Integer customerTitle) {
        this.customerTitle = customerTitle;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerMiddleName() {
        return customerMiddleName;
    }

    public void setCustomerMiddleName(String customerMiddleName) {
        this.customerMiddleName = customerMiddleName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerFatherName() {
        return customerFatherName;
    }

    public void setCustomerFatherName(String customerFatherName) {
        this.customerFatherName = customerFatherName;
    }

    public String getCustomerDOB() {
        return customerDOB;
    }

    public void setCustomerDOB(String customerDOB) {
        this.customerDOB = customerDOB;
    }

    public Integer getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(Integer customerGender) {
        this.customerGender = customerGender;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Integer getBillFrequencyPosition() {
        return billFrequencyPosition;
    }

    public void setBillFrequencyPosition(Integer billFrequencyPosition) {
        this.billFrequencyPosition = billFrequencyPosition;
    }

    public Integer getBillCyclePosition() {
        return billCyclePosition;
    }

    public void setBillCyclePosition(Integer billCyclePosition) {
        this.billCyclePosition = billCyclePosition;
    }

    public Integer getSegmentPosition() {
        return segmentPosition;
    }

    public void setSegmentPosition(Integer segmentPosition) {
        this.segmentPosition = segmentPosition;
    }

    public Integer getChannelPosition() {
        return channelPosition;
    }

    public void setChannelPosition(Integer channelPosition) {
        this.channelPosition = channelPosition;
    }

    public String getCustomerPAN() {
        return customerPAN;
    }

    public void setCustomerPAN(String customerPAN) {
        this.customerPAN = customerPAN;
    }

    public String getCustomerTAN() {
        return customerTAN;
    }

    public void setCustomerTAN(String customerTAN) {
        this.customerTAN = customerTAN;
    }

    public String getCafStatus() {
        return cafStatus;
    }

    public void setCafStatus(String cafStatus) {
        this.cafStatus = cafStatus;
    }

    public boolean isDataFromAadhar() {
        return isDataFromAadhar;
    }

    public void setDataFromAadhar(boolean dataFromAadhar) {
        isDataFromAadhar = dataFromAadhar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CustomerInfoModel{" +
                "formTime=" + formTime +
                ", customerAadhaarNumber='" + customerAadhaarNumber + '\'' +
                ", customerTitle=" + customerTitle +
                ", customerFirstName='" + customerFirstName + '\'' +
                ", customerMiddleName='" + customerMiddleName + '\'' +
                ", customerLastName='" + customerLastName + '\'' +
                ", customerFatherName='" + customerFatherName + '\'' +
                ", customerDOB='" + customerDOB + '\'' +
                ", customerGender=" + customerGender +
                ", contactPersonName='" + contactPersonName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", billFrequencyPosition=" + billFrequencyPosition +
                ", billCyclePosition=" + billCyclePosition +
                ", segmentPosition=" + segmentPosition +
                ", channelPosition=" + channelPosition +
                ", customerPAN='" + customerPAN + '\'' +
                ", customerTAN='" + customerTAN + '\'' +
                ", allPackagesSILMO='" + allPackagesSILMO + '\'' +
                ", cafStatus='" + cafStatus + '\'' +
                '}';
    }
}
package com.app.apsfl.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class EnterpriseCustomer extends RealmObject {

    @PrimaryKey
    private String customerID;
    private String customerName;
    private String customerMobileNumber;
    private boolean isCustomerChecked;
    private String enterPriseCustomerType;
    private String paymentCustomerId;
    private String registerNo;
    private String organizationName;
    private String contactpersionName;
    private String dateOfIncorporation;
    private String billFrequency;
    private String address1;//Building
    private String address2;//Street
    private String locality;
    private String email;

    public String getBillFrequency() {
        return billFrequency;
    }

    public void setBillFrequency(String billFrequency) {
        this.billFrequency = billFrequency;
    }

    public String getRegisterNo() {
        return registerNo;
    }

    public void setRegisterNo(String registerNo) {
        this.registerNo = registerNo;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getContactpersionName() {
        return contactpersionName;
    }

    public void setContactpersionName(String contactpersionName) {
        this.contactpersionName = contactpersionName;
    }

    public String getDateOfIncorporation() {
        return dateOfIncorporation;
    }

    public void setDateOfIncorporation(String dateOfIncorporation) {
        this.dateOfIncorporation = dateOfIncorporation;
    }

    public String getEnterPriseCustomerType() {
        return enterPriseCustomerType;
    }

    public void setEnterPriseCustomerType(String enterPriseCustomerType) {
        this.enterPriseCustomerType = enterPriseCustomerType;
    }

    public String getPaymentCustomerId() {
        return paymentCustomerId;
    }

    public void setPaymentCustomerId(String paymentCustomerId) {
        this.paymentCustomerId = paymentCustomerId;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerMobileNumber() {
        return customerMobileNumber;
    }

    public void setCustomerMobileNumber(String customerMobileNumber) {
        this.customerMobileNumber = customerMobileNumber;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public boolean isCustomerChecked() {
        return isCustomerChecked;
    }

    public void setCustomerChecked(boolean customerChecked) {
        isCustomerChecked = customerChecked;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

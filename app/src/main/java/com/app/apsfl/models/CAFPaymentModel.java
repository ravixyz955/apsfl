package com.app.apsfl.models;

import android.os.Parcel;
import android.os.Parcelable;

public class CAFPaymentModel implements Parcelable {

    private String paymentProductCode;
    private String paymentProductName;
    private String paymentServiceName;
    private String paymentCAFNumber;
    private String paymentCPEID;
    private String paymentAadhaarNumber;
    private String paymentMACAddress;
    private String paymentLockInPeriod;
    private String paymentCustomerName;
    private String paymentTotalCharges;
    private String paymentTotalTax;
    private String paymentCustomerID;

    public CAFPaymentModel() {

    }

    protected CAFPaymentModel(Parcel in) {
        paymentProductCode = in.readString();
        paymentProductName = in.readString();
        paymentServiceName = in.readString();
        paymentCAFNumber = in.readString();
        paymentCPEID = in.readString();
        paymentAadhaarNumber = in.readString();
        paymentMACAddress = in.readString();
        paymentLockInPeriod = in.readString();
        paymentCustomerName = in.readString();
        paymentTotalCharges = in.readString();
        paymentTotalTax = in.readString();
        paymentCustomerID = in.readString();
    }

    public static final Creator<CAFPaymentModel> CREATOR = new Creator<CAFPaymentModel>() {
        @Override
        public CAFPaymentModel createFromParcel(Parcel in) {
            return new CAFPaymentModel(in);
        }

        @Override
        public CAFPaymentModel[] newArray(int size) {
            return new CAFPaymentModel[size];
        }
    };

    public String getPaymentProductCode() {
        return paymentProductCode;
    }

    public void setPaymentProductCode(String paymentProductCode) {
        this.paymentProductCode = paymentProductCode;
    }

    public String getPaymentProductName() {
        return paymentProductName;
    }

    public void setPaymentProductName(String paymentProductName) {
        this.paymentProductName = paymentProductName;
    }

    public String getPaymentServiceName() {
        return paymentServiceName;
    }

    public void setPaymentServiceName(String paymentServiceName) {
        this.paymentServiceName = paymentServiceName;
    }

    public String getPaymentCAFNumber() {
        return paymentCAFNumber;
    }

    public void setPaymentCAFNumber(String paymentCAFNumber) {
        this.paymentCAFNumber = paymentCAFNumber;
    }

    public String getPaymentCPEID() {
        return paymentCPEID;
    }

    public void setPaymentCPEID(String paymentCPEID) {
        this.paymentCPEID = paymentCPEID;
    }

    public String getPaymentAadhaarNumber() {
        return paymentAadhaarNumber;
    }

    public void setPaymentAadhaarNumber(String paymentAadhaarNumber) {
        this.paymentAadhaarNumber = paymentAadhaarNumber;
    }

    public String getPaymentMACAddress() {
        return paymentMACAddress;
    }

    public void setPaymentMACAddress(String paymentMACAddress) {
        this.paymentMACAddress = paymentMACAddress;
    }

    public String getPaymentLockInPeriod() {
        return paymentLockInPeriod;
    }

    public void setPaymentLockInPeriod(String paymentLockInPeriod) {
        this.paymentLockInPeriod = paymentLockInPeriod;
    }

    public String getPaymentCustomerName() {
        return paymentCustomerName;
    }

    public void setPaymentCustomerName(String paymentCustomerName) {
        this.paymentCustomerName = paymentCustomerName;
    }

    public String getPaymentTotalCharges() {
        return paymentTotalCharges;
    }

    public void setPaymentTotalCharges(String paymentTotalCharges) {
        this.paymentTotalCharges = paymentTotalCharges;
    }

    public String getPaymentTotalTax() {
        return paymentTotalTax;
    }

    public void setPaymentTotalTax(String paymentTotalTax) {
        this.paymentTotalTax = paymentTotalTax;
    }

    public String getPaymentCustomerID() {
        return paymentCustomerID;
    }

    public void setPaymentCustomerID(String paymentCustomerID) {
        this.paymentCustomerID = paymentCustomerID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(paymentProductCode);
        dest.writeString(paymentProductName);
        dest.writeString(paymentServiceName);
        dest.writeString(paymentCAFNumber);
        dest.writeString(paymentCPEID);
        dest.writeString(paymentAadhaarNumber);
        dest.writeString(paymentMACAddress);
        dest.writeString(paymentLockInPeriod);
        dest.writeString(paymentCustomerName);
        dest.writeString(paymentTotalCharges);
        dest.writeString(paymentTotalTax);
        dest.writeString(paymentCustomerID);
    }

    @Override
    public String toString() {
        return "CAFPaymentModel {" +
                "paymentProductCode='" + paymentProductCode + '\'' + "\n" +
                ", paymentProductName='" + paymentProductName + '\'' + "\n" +
                ", paymentServiceName='" + paymentServiceName + '\'' + "\n" +
                ", paymentCAFNumber='" + paymentCAFNumber + '\'' + "\n" +
                ", paymentCPEID='" + paymentCPEID + '\'' + "\n" +
                ", paymentAadhaarNumber='" + paymentAadhaarNumber + '\'' + "\n" +
                ", paymentMACAddress='" + paymentMACAddress + '\'' + "\n" +
                ", paymentLockInPeriod='" + paymentLockInPeriod + '\'' + "\n" +
                ", paymentCustomerName='" + paymentCustomerName + '\'' + "\n" +
                ", paymentTotalCharges='" + paymentTotalCharges + '\'' + "\n" +
                ", paymentTotalTax='" + paymentTotalTax + '\'' + "\n" +
                ", paymentCustomerID='" + paymentCustomerID + '\'' + "\n" +
                '}';
    }
}

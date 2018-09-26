package com.app.apsfl.models;

import android.os.Parcel;
import android.os.Parcelable;

public class PaymentModel implements Parcelable {

    private String paymentCustomerName;
    private String paymentCAFNumber;
    private String paymentAadhaarNumber;
    private String paymentTotalCharges;
    private String paymentCustomerType;
    private String paymentCustomerID;
    private String paymentDistrictID;
    private String paymentMobileNo;

    public PaymentModel() {

    }

    protected PaymentModel(Parcel in) {
        paymentCustomerName = in.readString();
        paymentCAFNumber = in.readString();
        paymentAadhaarNumber = in.readString();
        paymentTotalCharges = in.readString();
        paymentCustomerType = in.readString();
        paymentCustomerID = in.readString();
        paymentDistrictID = in.readString();
        paymentMobileNo = in.readString();
    }

    public static final Creator<PaymentModel> CREATOR = new Creator<PaymentModel>() {
        @Override
        public PaymentModel createFromParcel(Parcel in) {
            return new PaymentModel(in);
        }

        @Override
        public PaymentModel[] newArray(int size) {
            return new PaymentModel[size];
        }
    };

    public String getPaymentCustomerName() {
        return paymentCustomerName;
    }

    public void setPaymentCustomerName(String paymentCustomerName) {
        this.paymentCustomerName = paymentCustomerName;
    }

    public String getPaymentCAFNumber() {
        return paymentCAFNumber;
    }

    public void setPaymentCAFNumber(String paymentCAFNumber) {
        this.paymentCAFNumber = paymentCAFNumber;
    }

    public String getPaymentAadhaarNumber() {
        return paymentAadhaarNumber;
    }

    public void setPaymentAadhaarNumber(String paymentAadhaarNumber) {
        this.paymentAadhaarNumber = paymentAadhaarNumber;
    }

    public String getPaymentTotalCharges() {
        return paymentTotalCharges;
    }

    public void setPaymentTotalCharges(String paymentTotalCharges) {
        this.paymentTotalCharges = paymentTotalCharges;
    }

    public String getPaymentCustomerType() {
        return paymentCustomerType;
    }

    public void setPaymentCustomerType(String paymentCustomerType) {
        this.paymentCustomerType = paymentCustomerType;
    }

    public String getPaymentCustomerID() {
        return paymentCustomerID;
    }

    public void setPaymentCustomerID(String paymentCustomerID) {
        this.paymentCustomerID = paymentCustomerID;
    }

    public String getPaymentDistrictID() {
        return paymentDistrictID;
    }

    public void setPaymentDistrictID(String paymentDistrictID) {
        this.paymentDistrictID = paymentDistrictID;
    }

    public String getPaymentMobileNo() {
        return paymentMobileNo;
    }

    public void setPaymentMobileNo(String paymentMobileNo) {
        this.paymentMobileNo = paymentMobileNo;
    }


    @Override
    public String toString() {
        return "PaymentModel{" +
                "paymentCustomerName='" + paymentCustomerName + '\'' +
                ", paymentCAFNumber='" + paymentCAFNumber + '\'' +
                ", paymentAadhaarNumber='" + paymentAadhaarNumber + '\'' +
                ", paymentTotalCharges='" + paymentTotalCharges + '\'' +
                ", paymentCustomerType='" + paymentCustomerType + '\'' +
                ", paymentCustomerID='" + paymentCustomerID + '\'' +
                ", paymentDistrictID='" + paymentDistrictID + '\'' +
                ", paymentMobileNo='" + paymentMobileNo + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(paymentCustomerName);
        dest.writeString(paymentCAFNumber);
        dest.writeString(paymentAadhaarNumber);
        dest.writeString(paymentTotalCharges);
        dest.writeString(paymentCustomerType);
        dest.writeString(paymentCustomerID);
        dest.writeString(paymentDistrictID);
        dest.writeString(paymentMobileNo);
    }
}

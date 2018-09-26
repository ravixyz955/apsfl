package com.app.apsfl.models;

import android.os.Parcel;
import android.os.Parcelable;

public class CAFResultModel implements Parcelable{

    private String customerFirstName;
    private String customerLastName;
    private String custID;
    private String aadhaarNumber;
    private boolean isIndividualCustomer;
    private String cafNumber;
    private String cpeName;
    private String cpeID;//for date
    private String packages;
    private String pinCode;
    private String billCycle;
    private String status;
    private String oltSerialNumber;
    private String oltPortNumber;
    private String villageID;
    private String districtID;
    private String mandalID;
    private String popID;
    private String allPackages;
    private String editCafStatus;
    private String popName;
    private String custTypelov;
    private String address1;
    private String address2;
    private String contactPersonMobileNo;
    private String apsflTrackID;
    private String cpeplace;
    private String contactPersonName;
    private String coreSrvcCode;
    private String iptvPackages;
    private String allocatedMobileNo;

    public CAFResultModel() {

    }

    protected CAFResultModel(Parcel in) {
        customerFirstName = in.readString();
        customerLastName = in.readString();
        custID = in.readString();
        aadhaarNumber = in.readString();
        isIndividualCustomer = in.readByte() != 0;
        cafNumber = in.readString();
        cpeName = in.readString();
        cpeID = in.readString();
        packages = in.readString();
        pinCode = in.readString();
        billCycle = in.readString();
        status = in.readString();
        oltSerialNumber = in.readString();
        oltPortNumber = in.readString();
        villageID = in.readString();
        districtID = in.readString();
        mandalID = in.readString();
        popID = in.readString();
        allPackages = in.readString();
        editCafStatus = in.readString();
        popName = in.readString();
        custTypelov = in.readString();
        address1 = in.readString();
        address2 = in.readString();
        contactPersonMobileNo = in.readString();
        apsflTrackID = in.readString();
        cpeplace = in.readString();
        contactPersonName = in.readString();
        coreSrvcCode = in.readString();
        iptvPackages = in.readString();
        allocatedMobileNo = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(customerFirstName);
        dest.writeString(customerLastName);
        dest.writeString(custID);
        dest.writeString(aadhaarNumber);
        dest.writeByte((byte) (isIndividualCustomer ? 1 : 0));
        dest.writeString(cafNumber);
        dest.writeString(cpeName);
        dest.writeString(cpeID);
        dest.writeString(packages);
        dest.writeString(pinCode);
        dest.writeString(billCycle);
        dest.writeString(status);
        dest.writeString(oltSerialNumber);
        dest.writeString(oltPortNumber);
        dest.writeString(villageID);
        dest.writeString(districtID);
        dest.writeString(mandalID);
        dest.writeString(popID);
        dest.writeString(allPackages);
        dest.writeString(editCafStatus);
        dest.writeString(popName);
        dest.writeString(custTypelov);
        dest.writeString(address1);
        dest.writeString(address2);
        dest.writeString(contactPersonMobileNo);
        dest.writeString(apsflTrackID);
        dest.writeString(cpeplace);
        dest.writeString(contactPersonName);
        dest.writeString(coreSrvcCode);
        dest.writeString(iptvPackages);
        dest.writeString(allocatedMobileNo);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CAFResultModel> CREATOR = new Creator<CAFResultModel>() {
        @Override
        public CAFResultModel createFromParcel(Parcel in) {
            return new CAFResultModel(in);
        }

        @Override
        public CAFResultModel[] newArray(int size) {
            return new CAFResultModel[size];
        }
    };

    public String getAllPackages() {
        return allPackages;
    }

    public void setAllPackages(String allPackages) {
        this.allPackages = allPackages;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public String getAadhaarNumber() {
        return aadhaarNumber;
    }

    public void setAadhaarNumber(String aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
    }

    public boolean isIndividualCustomer() {
        return isIndividualCustomer;
    }

    public void setIndividualCustomer(boolean individualCustomer) {
        isIndividualCustomer = individualCustomer;
    }

    public String getCafNumber() {
        return cafNumber;
    }

    public void setCafNumber(String cafNumber) {
        this.cafNumber = cafNumber;
    }

    public String getCpeName() {
        return cpeName;
    }

    public void setCpeName(String cpeName) {
        this.cpeName = cpeName;
    }

    public String getCpeID() {
        return cpeID;
    }

    public void setCpeID(String cpeID) {
        this.cpeID = cpeID;
    }

    public String getPackages() {
        return packages;
    }

    public void setPackages(String packages) {
        this.packages = packages;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getBillCycle() {
        return billCycle;
    }

    public void setBillCycle(String billCycle) {
        this.billCycle = billCycle;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOltSerialNumber() {
        return oltSerialNumber;
    }

    public void setOltSerialNumber(String oltSerialNumber) {
        this.oltSerialNumber = oltSerialNumber;
    }

    public String getOltPortNumber() {
        return oltPortNumber;
    }

    public void setOltPortNumber(String oltPortNumber) {
        this.oltPortNumber = oltPortNumber;
    }

    public String getVillageID() {
        return villageID;
    }

    public void setVillageID(String villageID) {
        this.villageID = villageID;
    }

    public String getDistrictID() {
        return districtID;
    }

    public void setDistrictID(String districtID) {
        this.districtID = districtID;
    }

    public String getMandalID() {
        return mandalID;
    }

    public void setMandalID(String mandalID) {
        this.mandalID = mandalID;
    }

    public String getPopID() {
        return popID;
    }

    public void setPopID(String popID) {
        this.popID = popID;
    }

    public String getEditCafStatus() {
        return editCafStatus;
    }

    public void setEditCafStatus(String editCafStatus) {
        this.editCafStatus = editCafStatus;
    }

    public String getPopName() {
        return popName;
    }

    public void setPopName(String popName) {
        this.popName = popName;
    }

    public String getCustTypelov() {
        return custTypelov;
    }

    public void setCustTypelov(String custTypelov) {
        this.custTypelov = custTypelov;
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

    public String getContactPersonMobileNo() {
        return contactPersonMobileNo;
    }

    public void setContactPersonMobileNo(String contactPersonMobileNo) {
        this.contactPersonMobileNo = contactPersonMobileNo;
    }

    public String getApsflTrackID() {
        return apsflTrackID;
    }

    public void setApsflTrackID(String apsflTrackID) {
        this.apsflTrackID = apsflTrackID;
    }

    public String getCpeplace() {
        return cpeplace;
    }

    public void setCpeplace(String cpeplace) {
        this.cpeplace = cpeplace;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public String getCoreSrvcCode() {
        return coreSrvcCode;
    }

    public void setCoreSrvcCode(String coreSrvcCode) {
        this.coreSrvcCode = coreSrvcCode;
    }

    public String getIptvPackages() {
        return iptvPackages;
    }

    public void setIptvPackages(String iptvPackages) {
        this.iptvPackages = iptvPackages;
    }

    public String getAllocatedMobileNo() {
        return allocatedMobileNo;
    }

    public void setAllocatedMobileNo(String allocatedMobileNo) {
        this.allocatedMobileNo = allocatedMobileNo;
    }
}

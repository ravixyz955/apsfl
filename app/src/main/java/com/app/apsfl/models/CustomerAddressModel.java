package com.app.apsfl.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CustomerAddressModel extends RealmObject {

    @PrimaryKey
    private Long formTime;
    private String popID;
    private String popName;
    private String address1;
    private String address2;
    private String locality;
    private String pinCode;
    private String mobile;
    private String stdCode;
    private String landLine;
    private String villageName;
    private String villageID;
    private String mandalName;
    private String mandalID;
    private String districtName;
    private String districtID;
    private String mobile1;
    private boolean isCustomerChecked;
    private boolean isLMOChecked;
    private String longitude;
    private String latitude;
    private String location;
    private String region;
    private String popDistrict;
    private String popmandal;
    private String popDistrictId;
    private String popMandalId;
    private String apsflUniqueId;
    private String SIName;
    private String SIEmail;
    private String SIPhno;
    //For SILMO to send in json
    private String entCustType;
    private String entCustomerCode;
    //SILMO To send in otp
    private String cpeplace;
    private String status;
    private String customerAadhaarNumber;


    public Long getFormTime() {
        return formTime;
    }

    public void setFormTime(Long formTime) {
        this.formTime = formTime;
    }

    public String getPopID() {
        return popID;
    }

    public void setPopID(String popID) {
        this.popID = popID;
    }

    public String getPopName() {
        return popName;
    }

    public void setPopName(String popName) {
        this.popName = popName;
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

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getStdCode() {
        return stdCode;
    }

    public void setStdCode(String stdCode) {
        this.stdCode = stdCode;
    }

    public String getLandLine() {
        return landLine;
    }

    public void setLandLine(String landLine) {
        this.landLine = landLine;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getMandalName() {
        return mandalName;
    }

    public void setMandalName(String mandalName) {
        this.mandalName = mandalName;
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

    public String getVillageID() {
        return villageID;
    }

    public void setVillageID(String villageID) {
        this.villageID = villageID;
    }

    public String getMobile1() {
        return mobile1;
    }

    public void setMobile1(String mobile1) {
        this.mobile1 = mobile1;
    }

    public boolean isCustomerChecked() {
        return isCustomerChecked;
    }

    public void setCustomerChecked(boolean customerChecked) {
        isCustomerChecked = customerChecked;
    }

    public boolean isLMOChecked() {
        return isLMOChecked;
    }

    public void setLMOChecked(boolean LMOChecked) {
        isLMOChecked = LMOChecked;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPopDistrict() {
        return popDistrict;
    }

    public void setPopDistrict(String popDistrict) {
        this.popDistrict = popDistrict;
    }

    public String getPopmandal() {
        return popmandal;
    }

    public void setPopmandal(String popmandal) {
        this.popmandal = popmandal;
    }

    public String getPopDistrictId() {
        return popDistrictId;
    }

    public void setPopDistrictId(String popDistrictId) {
        this.popDistrictId = popDistrictId;
    }

    public String getPopMandalId() {
        return popMandalId;
    }

    public void setPopMandalId(String popMandalId) {
        this.popMandalId = popMandalId;
    }

    public String getApsflUniqueId() {
        return apsflUniqueId;
    }

    public void setApsflUniqueId(String apsflUniqueId) {
        this.apsflUniqueId = apsflUniqueId;
    }

    public String getSIName() {
        return SIName;
    }

    public void setSIName(String SIName) {
        this.SIName = SIName;
    }

    public String getSIEmail() {
        return SIEmail;
    }

    public void setSIEmail(String SIEmail) {
        this.SIEmail = SIEmail;
    }

    public String getSIPhno() {
        return SIPhno;
    }

    public void setSIPhno(String SIPhno) {
        this.SIPhno = SIPhno;
    }

    public String getEntCustType() {
        return entCustType;
    }

    public void setEntCustType(String entCustType) {
        this.entCustType = entCustType;
    }

    public String getEntCustomerCode() {
        return entCustomerCode;
    }

    public void setEntCustomerCode(String entCustomerCode) {
        this.entCustomerCode = entCustomerCode;
    }

    public String getCpeplace() {
        return cpeplace;
    }

    public void setCpeplace(String cpeplace) {
        this.cpeplace = cpeplace;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomerAadhaarNumber() {
        return customerAadhaarNumber;
    }

    public void setCustomerAadhaarNumber(String customerAadhaarNumber) {
        this.customerAadhaarNumber = customerAadhaarNumber;
    }

    @Override
    public String toString() {
        return "CustomerAddressModel{" +
                "formTime=" + formTime +
                ", popID='" + popID + '\'' +
                ", popName='" + popName + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", locality='" + locality + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", mobile='" + mobile + '\'' +
                ", stdCode='" + stdCode + '\'' +
                ", landLine='" + landLine + '\'' +
                ", villageName='" + villageName + '\'' +
                ", villageID='" + villageID + '\'' +
                ", mandalName='" + mandalName + '\'' +
                ", mandalID='" + mandalID + '\'' +
                ", districtName='" + districtName + '\'' +
                ", districtID='" + districtID + '\'' +
                ", mobile1='" + mobile1 + '\'' +
                ", isCustomerChecked=" + isCustomerChecked +
                ", isLMOChecked=" + isLMOChecked +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", location='" + location + '\'' +
                ", region='" + region + '\'' +
                ", popDistrict='" + popDistrict + '\'' +
                ", popmandal='" + popmandal + '\'' +
                ", popDistrictId='" + popDistrictId + '\'' +
                ", popMandalId='" + popMandalId + '\'' +
                ", apsflUniqueId='" + apsflUniqueId + '\'' +
                ", SIName='" + SIName + '\'' +
                ", SIEmail='" + SIEmail + '\'' +
                ", SIPhno='" + SIPhno + '\'' +
                ", entCustType='" + entCustType + '\'' +
                ", entCustomerCode='" + entCustomerCode + '\'' +
                '}';
    }
}

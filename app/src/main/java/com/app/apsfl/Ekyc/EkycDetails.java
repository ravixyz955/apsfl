package com.app.apsfl.Ekyc;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by ravik on 25/06/2018.
 */

public class EkycDetails implements Serializable {
    @SerializedName("pincode")
    private String pincode;

    @SerializedName("name")
    private String name;

    @SerializedName("house")
    private String house;

    @SerializedName("subdist")
    private String subdist;

    @SerializedName("KSA_KUA_Txn")
    private String KSA_KUA_Txn;

    @SerializedName("gender")
    private String gender;

    @SerializedName("vtc")
    private String vtc;

    @SerializedName("auth_date")
    private String auth_date;

    @SerializedName("co")
    private String co;

    @SerializedName("statecode")
    private String statecode;

    @SerializedName("auth_reason")
    private String auth_reason;

    @SerializedName("base64file")
    private String base64file;

    @SerializedName("uid")
    private String uid;

    @SerializedName("phoneNumber")
    private String phoneNumber;

    @SerializedName("dob")
    private String dob;

    @SerializedName("street")
    private String street;

    @SerializedName("district")
    private String district;

    @SerializedName("lc")
    private String lc;

    @SerializedName("auth_transaction_code")
    private String auth_transaction_code;

    @SerializedName("po")
    private String po;

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getSubdist() {
        return subdist;
    }

    public void setSubdist(String subdist) {
        this.subdist = subdist;
    }

    public String getKSA_KUA_Txn() {
        return KSA_KUA_Txn;
    }

    public void setKSA_KUA_Txn(String KSA_KUA_Txn) {
        this.KSA_KUA_Txn = KSA_KUA_Txn;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getVtc() {
        return vtc;
    }

    public void setVtc(String vtc) {
        this.vtc = vtc;
    }

    public String getAuth_date() {
        return auth_date;
    }

    public void setAuth_date(String auth_date) {
        this.auth_date = auth_date;
    }

    public String getCo() {
        return co;
    }

    public void setCo(String co) {
        this.co = co;
    }

    public String getStatecode() {
        return statecode;
    }

    public void setStatecode(String statecode) {
        this.statecode = statecode;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getAuth_reason() {
        return auth_reason;
    }

    public void setAuth_reason(String auth_reason) {
        this.auth_reason = auth_reason;
    }

    public String getBase64file() {
        return base64file;
    }

    public void setBase64file(String base64file) {
        this.base64file = base64file;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPhoneNumber() {

        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getLc() {
        return lc;
    }

    public void setLc(String lc) {
        this.lc = lc;
    }

    public String getAuth_transaction_code() {
        return auth_transaction_code;
    }

    public void setAuth_transaction_code(String auth_transaction_code) {
        this.auth_transaction_code = auth_transaction_code;
    }

    public String getPo() {
        return po;
    }

    public void setPo(String po) {
        this.po = po;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

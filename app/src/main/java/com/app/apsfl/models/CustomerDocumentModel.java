package com.app.apsfl.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CustomerDocumentModel extends RealmObject {

    @PrimaryKey
    private Long formTime;
    private Integer identityType;
    private String identityDOCNumber;
    private String identityAuth;
    private String identityPlace;
    private String identityDate;
    private Integer addressType;
    private String addressDOCNumber;
    private String addressAuth;
    private String addressPlace;
    private String addressDate;

    public Long getFormTime() {
        return formTime;
    }

    public void setFormTime(Long formTime) {
        this.formTime = formTime;
    }

    public Integer getIdentityType() {
        return identityType;
    }

    public void setIdentityType(Integer identityType) {
        this.identityType = identityType;
    }

    public String getIdentityDOCNumber() {
        return identityDOCNumber;
    }

    public void setIdentityDOCNumber(String identityDOCNumber) {
        this.identityDOCNumber = identityDOCNumber;
    }

    public String getIdentityAuth() {
        return identityAuth;
    }

    public void setIdentityAuth(String identityAuth) {
        this.identityAuth = identityAuth;
    }

    public String getIdentityPlace() {
        return identityPlace;
    }

    public void setIdentityPlace(String identityPlace) {
        this.identityPlace = identityPlace;
    }

    public String getIdentityDate() {
        return identityDate;
    }

    public void setIdentityDate(String identityDate) {
        this.identityDate = identityDate;
    }

    public Integer getAddressType() {
        return addressType;
    }

    public void setAddressType(Integer addressType) {
        this.addressType = addressType;
    }

    public String getAddressDOCNumber() {
        return addressDOCNumber;
    }

    public void setAddressDOCNumber(String addressDOCNumber) {
        this.addressDOCNumber = addressDOCNumber;
    }

    public String getAddressAuth() {
        return addressAuth;
    }

    public void setAddressAuth(String addressAuth) {
        this.addressAuth = addressAuth;
    }

    public String getAddressPlace() {
        return addressPlace;
    }

    public void setAddressPlace(String addressPlace) {
        this.addressPlace = addressPlace;
    }

    public String getAddressDate() {
        return addressDate;
    }

    public void setAddressDate(String addressDate) {
        this.addressDate = addressDate;
    }
}
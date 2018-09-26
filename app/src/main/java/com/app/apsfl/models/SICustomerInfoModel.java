package com.app.apsfl.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Arbiva on 2/6/2017.
 */

public class SICustomerInfoModel extends RealmObject {

    @PrimaryKey
    private String apsflTrackId;
    private String cafNo;
    private String organizationName;
    private String nameOfContactPersonName;
    private String numberOfContactPerson;
    private String instAddress;
    private String cpeDeviceLocation;
    private String instDistName;
    private String selectedInstDistId;
    private String instMandalName;
    private String selectedInstMandalId;
    private String instVillageId;
    private String selectedInstVillage;

    //to send Json
   private String entCustomerCode;
    private String entCustType;
    private String custId;
    private String billCycle;
    private String coreSrvcCode;



    public String getCafNo() {
        return cafNo;
    }

    public void setCafNo(String cafNo) {
        this.cafNo = cafNo;
    }

    public String getApsflTrackId() {
        return apsflTrackId;
    }

    public void setApsflTrackId(String apsflTrackId) {
        this.apsflTrackId = apsflTrackId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getNameOfContactPersonName() {
        return nameOfContactPersonName;
    }

    public void setNameOfContactPersonName(String nameOfContactPersonName) {
        this.nameOfContactPersonName = nameOfContactPersonName;
    }

    public String getNumberOfContactPerson() {
        return numberOfContactPerson;
    }

    public void setNumberOfContactPerson(String numberOfContactPerson) {
        this.numberOfContactPerson = numberOfContactPerson;
    }

    public String getInstAddress() {
        return instAddress;
    }

    public void setInstAddress(String instAddress) {
        this.instAddress = instAddress;
    }

    public String getCpeDeviceLocation() {
        return cpeDeviceLocation;
    }

    public void setCpeDeviceLocation(String cpeDeviceLocation) {
        this.cpeDeviceLocation = cpeDeviceLocation;
    }

    public String getInstDistName() {
        return instDistName;
    }

    public void setInstDistName(String instDistName) {
        this.instDistName = instDistName;
    }

    public String getSelectedInstDistId() {
        return selectedInstDistId;
    }

    public void setSelectedInstDistId(String selectedInstDistId) {
        this.selectedInstDistId = selectedInstDistId;
    }

    public String getInstMandalName() {
        return instMandalName;
    }

    public void setInstMandalName(String instMandalName) {
        this.instMandalName = instMandalName;
    }

    public String getInstVillageId() {
        return instVillageId;
    }

    public void setInstVillageId(String instVillageId) {
        this.instVillageId = instVillageId;
    }

    public String getSelectedInstVillage() {
        return selectedInstVillage;
    }

    public void setSelectedInstVillage(String selectedInstVillage) {
        this.selectedInstVillage = selectedInstVillage;
    }

    public String getSelectedInstMandalId() {
        return selectedInstMandalId;
    }

    public void setSelectedInstMandalId(String selectedInstMandalId) {
        this.selectedInstMandalId = selectedInstMandalId;
    }

    public String getEntCustomerCode() {
        return entCustomerCode;
    }

    public void setEntCustomerCode(String entCustomerCode) {
        this.entCustomerCode = entCustomerCode;
    }

    public String getEntCustType() {
        return entCustType;
    }

    public void setEntCustType(String entCustType) {
        this.entCustType = entCustType;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getBillCycle() {
        return billCycle;
    }

    public void setBillCycle(String billCycle) {
        this.billCycle = billCycle;
    }

    public String getCoreSrvcCode() {
        return coreSrvcCode;
    }

    public void setCoreSrvcCode(String coreSrvcCode) {
        this.coreSrvcCode = coreSrvcCode;
    }
}

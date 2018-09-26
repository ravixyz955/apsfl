package com.app.apsfl.models;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;

public class CPEDataModel extends RealmObject {

    @PrimaryKey
    private String cpeProfileIDcpeInstallmentCount;
    @Index
    private int cpeProfileID;
    private String cpeModelName;
    private String cpeProfileName;
    private String cpeModelDetails;
    private String cpePurchaseCost;
    private String cpeRentalCost;
    private String cpeLovType;
    private String cpeInstallmentCount;
    private String installationTaxAmount;
    private String cpeInstallationCost;
    private String cpeInstallmentCost;
    private String cpeTax;
    private String cpeTotalCost;
    private String upFrontCharges;



    public String getCpeProfileIDcpeInstallmentCount() {
        return cpeProfileIDcpeInstallmentCount;
    }

    public void setCpeProfileIDcpeInstallmentCount(String cpeProfileIDcpeInstallmentCount) {
        this.cpeProfileIDcpeInstallmentCount = cpeProfileIDcpeInstallmentCount;
    }

    public int getCpeProfileID() {
        return cpeProfileID;
    }

    public void setCpeProfileID(int cpeProfileID) {
        this.cpeProfileID = cpeProfileID;
    }

    public String getCpeModelName() {
        return cpeModelName;
    }

    public void setCpeModelName(String cpeModelName) {
        this.cpeModelName = cpeModelName;
    }

    public String getCpeProfileName() {
        return cpeProfileName;
    }

    public void setCpeProfileName(String cpeProfileName) {
        this.cpeProfileName = cpeProfileName;
    }

    public String getCpeModelDetails() {
        return cpeModelDetails;
    }

    public void setCpeModelDetails(String cpeModelDetails) {
        this.cpeModelDetails = cpeModelDetails;
    }

    public String getCpePurchaseCost() {
        return cpePurchaseCost;
    }

    public void setCpePurchaseCost(String cpePurchaseCost) {
        this.cpePurchaseCost = cpePurchaseCost;
    }

    public String getCpeRentalCost() {
        return cpeRentalCost;
    }

    public void setCpeRentalCost(String cpeRentalCost) {
        this.cpeRentalCost = cpeRentalCost;
    }

    public String getInstallationTaxAmount() {
        return installationTaxAmount;
    }

    public void setInstallationTaxAmount(String installationTaxAmount) {
        this.installationTaxAmount = installationTaxAmount;
    }

    public String getCpeInstallationCost() {
        return cpeInstallationCost;
    }

    public void setCpeInstallationCost(String cpeInstallationCost) {
        this.cpeInstallationCost = cpeInstallationCost;
    }

    public String getCpeInstallmentCount() {
        return cpeInstallmentCount;
    }

    public void setCpeInstallmentCount(String cpeInstallmentCount) {
        this.cpeInstallmentCount = cpeInstallmentCount;
    }

    public String getCpeLovType() {
        return cpeLovType;
    }

    public void setCpeLovType(String cpeLovType) {
        this.cpeLovType = cpeLovType;
    }

    public String getCpeInstallmentCost() {
        return cpeInstallmentCost;
    }

    public void setCpeInstallmentCost(String cpeInstallmentCost) {
        this.cpeInstallmentCost = cpeInstallmentCost;
    }

    public String getCpeTax() {
        return cpeTax;
    }

    public void setCpeTax(String cpeTax) {
        this.cpeTax = cpeTax;
    }

    public String getCpeTotalCost() {
        return cpeTotalCost;
    }

    public void setCpeTotalCost(String cpeTotalCost) {
        this.cpeTotalCost = cpeTotalCost;
    }

    public String getUpFrontCharges() {
        return upFrontCharges;
    }

    public void setUpFrontCharges(String upFrontCharges) {
        this.upFrontCharges = upFrontCharges;
    }

    @Override
    public String toString() {
        return  cpeModelName;
    }
}

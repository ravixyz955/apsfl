package com.app.apsfl.models;

import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Arbiva on 1/6/2017.
 */

public class IptvDataModel extends RealmObject {

    @PrimaryKey
    private String iptvpositionformTime;
    private int iptvposition;
    private Long formTime;
    private String iptvBoxModel;
    private String ipTVSerialNumber;
    private String ipTVMacAddress;
    private String noOfIptvInstallments;
    private String iptvPriceForInstallment;
    private int stbModelPosition;
   // private int stbDevicePurchasePosition;
   // private Boolean isSTBChecked;
    private String iptvPkg;
    private String iptvBoxTax;
    private String upfrontAmount;


    public String getIptvpositionformTime() {
        return iptvpositionformTime;
    }

    public void setIptvpositionformTime(String iptvpositionformTime) {
        this.iptvpositionformTime = iptvpositionformTime;
    }

    public Long getFormTime() {
        return formTime;
    }

    public void setFormTime(Long formTime) {
        this.formTime = formTime;
    }

    public int getIptvposition() {
        return iptvposition;
    }

    public void setIptvposition(int iptvposition) {
        this.iptvposition = iptvposition;
    }

    public String getIpTVSerialNumber() {
        return ipTVSerialNumber;
    }

    public void setIpTVSerialNumber(String ipTVSerialNumber) {
        this.ipTVSerialNumber = ipTVSerialNumber;
    }

    public String getIpTVMacAddress() {
        return ipTVMacAddress;
    }

    public void setIpTVMacAddress(String ipTVMacAddress) {
        this.ipTVMacAddress = ipTVMacAddress;
    }

    public String getNoOfIptvInstallments() {
        return noOfIptvInstallments;
    }

    public void setNoOfIptvInstallments(String noOfIptvInstallments) {
        this.noOfIptvInstallments = noOfIptvInstallments;
    }

    public String getIptvPriceForInstallment() {
        return iptvPriceForInstallment;
    }

    public void setIptvPriceForInstallment(String iptvPriceForInstallment) {
        this.iptvPriceForInstallment = iptvPriceForInstallment;
    }

    public int getStbModelPosition() {
        return stbModelPosition;
    }

    public void setStbModelPosition(int stbModelPosition) {
        this.stbModelPosition = stbModelPosition;
    }

    /*public int getStbDevicePurchasePosition() {
        return stbDevicePurchasePosition;
    }

    public void setStbDevicePurchasePosition(int stbDevicePurchasePosition) {
        this.stbDevicePurchasePosition = stbDevicePurchasePosition;
    }*/

    /*public Boolean getSTBChecked() {
        return isSTBChecked;
    }

    public void setSTBChecked(Boolean STBChecked) {
        isSTBChecked = STBChecked;
    }*/

    public String getIptvPkg() {
        return iptvPkg;
    }

    public void setIptvPkg(String iptvPkg) {
        this.iptvPkg = iptvPkg;
    }

    public String getIptvBoxModel() {
        return iptvBoxModel;
    }

    public void setIptvBoxModel(String iptvBoxModel) {
        this.iptvBoxModel = iptvBoxModel;
    }

    public String getIptvBoxTax() {
        return iptvBoxTax;
    }

    public void setIptvBoxTax(String iptvBoxTax) {
        this.iptvBoxTax = iptvBoxTax;
    }

    public String getUpfrontAmount() {
        return upfrontAmount;
    }

    public void setUpfrontAmount(String upfrontAmount) {
        this.upfrontAmount = upfrontAmount;
    }

    @Override
    public String toString() {//  ", isSTBChecked=" + isSTBChecked +    ", stbDevicePurchasePosition=" + stbDevicePurchasePosition +
        return "IptvDataModel{" +
                "iptvpositionformTime='" + iptvpositionformTime + '\'' +
                ", iptvposition=" + iptvposition +
                ", formTime=" + formTime +
                ", iptvBoxModel='" + iptvBoxModel + '\'' +
                ", ipTVSerialNumber='" + ipTVSerialNumber + '\'' +
                ", ipTVMacAddress='" + ipTVMacAddress + '\'' +
                ", noOfIptvInstallments='" + noOfIptvInstallments + '\'' +
                ", iptvPriceForInstallment='" + iptvPriceForInstallment + '\'' +
                ", stbModelPosition=" + stbModelPosition +
                ", iptvPkg='" + iptvPkg + '\'' +
                ", iptvBoxTax='" + iptvBoxTax + '\'' +
                ", upfrontAmount='" + upfrontAmount + '\'' +
                '}';
    }
}

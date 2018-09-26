package com.app.apsfl.models;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CPEInfoModel extends RealmObject {

    @PrimaryKey
    private Long formTime;
   // private Boolean isONUChecked;

    private String cpePOPName;
    private int cpeOLTIDPosition;
    private int cpeOLTPortIDPosition;
    private int cpeLevel1SlotPosition;
    private int cpeLevel2SlotPosition;
    private int cpeLevel3SlotPosition;
    private int onuModelPosition;
    private int onuDevicePurchasePosition;
    private int vpnSpinnerPosition;
    private String VpnServiceName;
    private String noOfOnuInstallments;
    private String onuPriceForInstallment;
    private String onuInstallationCharge;
    private String installationTax;
    private String onuSerialNumber;
    private String onuMacAddress;
    private String cpeExtraCableCharge;
    private int teleConnCountPosition;
    private int iptvConnCountPosition;
    private String onuModel;
    private String onuTax;
    private String onuUpfrontEmount;
    //private CPEDataModel selectedONUDataModel;
    private RealmList<IptvDataModel> selectedIptvList;

    public Long getFormTime() {
        return formTime;
    }

    public void setFormTime(Long formTime) {
        this.formTime = formTime;
    }

    public String getOnuSerialNumber() {
        return onuSerialNumber;
    }

    public void setOnuSerialNumber(String onuSerialNumber) {
        this.onuSerialNumber = onuSerialNumber;
    }

    /*public Boolean getONUChecked() {
        return isONUChecked;
    }

    public void setONUChecked(Boolean CPEChecked) {
        isONUChecked = CPEChecked;
    }*/

    public String getCpePOPName() {
        return cpePOPName;
    }

    public void setCpePOPName(String cpePOPName) {
        this.cpePOPName = cpePOPName;
    }

    public int getCpeOLTIDPosition() {
        return cpeOLTIDPosition;
    }

    public void setCpeOLTIDPosition(int cpeOLTIDPosition) {
        this.cpeOLTIDPosition = cpeOLTIDPosition;
    }

    public int getCpeOLTPortIDPosition() {
        return cpeOLTPortIDPosition;
    }

    public void setCpeOLTPortIDPosition(int cpeOLTPortIDPosition) {
        this.cpeOLTPortIDPosition = cpeOLTPortIDPosition;
    }

    public int getCpeLevel1SlotPosition() {
        return cpeLevel1SlotPosition;
    }

    public void setCpeLevel1SlotPosition(int cpeLevel1SlotPosition) {
        this.cpeLevel1SlotPosition = cpeLevel1SlotPosition;
    }

    public int getCpeLevel2SlotPosition() {
        return cpeLevel2SlotPosition;
    }

    public void setCpeLevel2SlotPosition(int cpeLevel2SlotPosition) {
        this.cpeLevel2SlotPosition = cpeLevel2SlotPosition;
    }

    public int getCpeLevel3SlotPosition() {
        return cpeLevel3SlotPosition;
    }

    public void setCpeLevel3SlotPosition(int cpeLevel3SlotPosition) {
        this.cpeLevel3SlotPosition = cpeLevel3SlotPosition;
    }

    public int getOnuModelPosition() {
        return onuModelPosition;
    }

    public void setOnuModelPosition(int onuModelPosition) {
        this.onuModelPosition = onuModelPosition;
    }

    public int getOnuDevicePurchasePosition() {
        return onuDevicePurchasePosition;
    }

    public void setOnuDevicePurchasePosition(int onuDevicePurchasePosition) {
        this.onuDevicePurchasePosition = onuDevicePurchasePosition;
    }

    public String getOnuMacAddress() {
        return onuMacAddress;
    }

    public void setOnuMacAddress(String onuMacAddress) {
        this.onuMacAddress = onuMacAddress;
    }

    public String getCpeExtraCableCharge() {
        return cpeExtraCableCharge;
    }

    public void setCpeExtraCableCharge(String cpeExtraCableCharge) {
        this.cpeExtraCableCharge = cpeExtraCableCharge;
    }

    public String getNoOfOnuInstallments() {
        return noOfOnuInstallments;
    }

    public void setNoOfOnuInstallments(String noOfOnuInstallments) {
        this.noOfOnuInstallments = noOfOnuInstallments;
    }

    public String getOnuPriceForInstallment() {
        return onuPriceForInstallment;
    }

    public void setOnuPriceForInstallment(String onuPriceForInstallment) {
        this.onuPriceForInstallment = onuPriceForInstallment;
    }

    public String getOnuInstallationCharge() {
        return onuInstallationCharge;
    }

    public void setOnuInstallationCharge(String onuInstallationCharge) {
        this.onuInstallationCharge = onuInstallationCharge;
    }

    public int getVpnSpinnerPosition() {
        return vpnSpinnerPosition;
    }

    public void setVpnSpinnerPosition(int vpnSpinnerPosition) {
        this.vpnSpinnerPosition = vpnSpinnerPosition;
    }

    public String getVpnServiceName() {
        return VpnServiceName;
    }

    public void setVpnServiceName(String vpnServiceName) {
        VpnServiceName = vpnServiceName;
    }

    public RealmList<IptvDataModel> getSelectedIptvList() {
        return selectedIptvList;
    }

    public void setSelectedIptvList(RealmList<IptvDataModel> selectedIptvList) {
        this.selectedIptvList = selectedIptvList;
    }

    public int getTeleConnCountPosition() {
        return teleConnCountPosition;
    }

    public void setTeleConnCountPosition(int teleConnCountPosition) {
        this.teleConnCountPosition = teleConnCountPosition;
    }

    public String getOnuModel() {
        return onuModel;
    }

    public void setOnuModel(String onuModel) {
        this.onuModel = onuModel;
    }

    public String getOnuTax() {
        return onuTax;
    }

    public void setOnuTax(String onuTax) {
        this.onuTax = onuTax;
    }

    public String getInstallationTax() {
        return installationTax;
    }

    public void setInstallationTax(String installationTax) {
        this.installationTax = installationTax;
    }

    public String getOnuUpfrontEmount() {
        return onuUpfrontEmount;
    }

    public void setOnuUpfrontEmount(String onuUpfrontEmount) {
        this.onuUpfrontEmount = onuUpfrontEmount;
    }

    public int getIptvConnCountPosition() {
        return iptvConnCountPosition;
    }

    public void setIptvConnCountPosition(int iptvConnCountPosition) {
        this.iptvConnCountPosition = iptvConnCountPosition;
    }
//", isONUChecked=" + isONUChecked +
    @Override
    public String toString() {
        return "CPEInfoModel{" +
                "formTime=" + formTime +
                ", cpePOPName='" + cpePOPName + '\'' +
                ", cpeOLTIDPosition=" + cpeOLTIDPosition +
                ", cpeOLTPortIDPosition=" + cpeOLTPortIDPosition +
                ", cpeLevel1SlotPosition=" + cpeLevel1SlotPosition +
                ", cpeLevel2SlotPosition=" + cpeLevel2SlotPosition +
                ", cpeLevel3SlotPosition=" + cpeLevel3SlotPosition +
                ", onuModelPosition=" + onuModelPosition +
                ", onuDevicePurchasePosition=" + onuDevicePurchasePosition +
                ", vpnSpinnerPosition=" + vpnSpinnerPosition +
                ", noOfOnuInstallments='" + noOfOnuInstallments + '\'' +
                ", onuPriceForInstallment='" + onuPriceForInstallment + '\'' +
                ", onuInstallationCharge='" + onuInstallationCharge + '\'' +
                ", onuSerialNumber='" + onuSerialNumber + '\'' +
                ", onuMacAddress='" + onuMacAddress + '\'' +
                ", cpeExtraCableCharge='" + cpeExtraCableCharge + '\'' +
                ", teleConnCountPosition=" + teleConnCountPosition +
                ", onuModel='" + onuModel + '\'' +
                ", onuTax='" + onuTax + '\'' +
                ", selectedIptvList=" + selectedIptvList +
                '}';
    }
}

package com.app.apsfl.models;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Arbiva on 2/6/2017.
 */

public class SICpeInfoModel extends RealmObject {

    @PrimaryKey
    private String apsflTrackId;
    private String packageDetails;
    private String popDistId;
    private String popMandalId;
    private String popId;
    private String selectedPopDistrict;
    private String selectedPopMandal;
    private String selectedPop;
    private int oltIdPosition;
    private int oltPortIdPosition;
    private int onuModelPosition;
    private String onuSerialNumber;
    private int iptvPosition;
    private String iptvSerialNumber;
    private int vpnPosition;
    private int teleConnCountPosition;
    private RealmList<IptvSIDataModel> selectedIptvList;
    private String iptvPackages;

    public String getApsflTrackId() {
        return apsflTrackId;
    }

    public void setApsflTrackId(String apsflTrackId) {
        this.apsflTrackId = apsflTrackId;
    }

    public String getPackageDetails() {
        return packageDetails;
    }

    public void setPackageDetails(String packageDetails) {
        this.packageDetails = packageDetails;
    }

    public String getPopDistId() {
        return popDistId;
    }

    public void setPopDistId(String popDistId) {
        this.popDistId = popDistId;
    }

    public String getPopMandalId() {
        return popMandalId;
    }

    public void setPopMandalId(String popMandalId) {
        this.popMandalId = popMandalId;
    }

    public String getPopId() {
        return popId;
    }

    public void setPopId(String popId) {
        this.popId = popId;
    }

    public String getSelectedPopDistrict() {
        return selectedPopDistrict;
    }

    public void setSelectedPopDistrict(String selectedPopDistrict) {
        this.selectedPopDistrict = selectedPopDistrict;
    }

    public String getSelectedPopMandal() {
        return selectedPopMandal;
    }

    public void setSelectedPopMandal(String selectedPopMandal) {
        this.selectedPopMandal = selectedPopMandal;
    }

    public String getSelectedPop() {
        return selectedPop;
    }

    public void setSelectedPop(String selectedPop) {
        this.selectedPop = selectedPop;
    }

    public int getOltIdPosition() {
        return oltIdPosition;
    }

    public void setOltIdPosition(int oltIdPosition) {
        this.oltIdPosition = oltIdPosition;
    }

    public int getOltPortIdPosition() {
        return oltPortIdPosition;
    }

    public void setOltPortIdPosition(int oltPortIdPosition) {
        this.oltPortIdPosition = oltPortIdPosition;
    }

    public int getOnuModelPosition() {
        return onuModelPosition;
    }

    public void setOnuModelPosition(int onuModelPosition) {
        this.onuModelPosition = onuModelPosition;
    }

    public String getOnuSerialNumber() {
        return onuSerialNumber;
    }

    public void setOnuSerialNumber(String onuSerialNumber) {
        this.onuSerialNumber = onuSerialNumber;
    }

    public int getIptvPosition() {
        return iptvPosition;
    }

    public void setIptvPosition(int iptvPosition) {
        this.iptvPosition = iptvPosition;
    }

    public String getIptvSerialNumber() {
        return iptvSerialNumber;
    }

    public void setIptvSerialNumber(String iptvSerialNumber) {
        this.iptvSerialNumber = iptvSerialNumber;
    }

    public int getVpnPosition() {
        return vpnPosition;
    }

    public void setVpnPosition(int vpnPosition) {
        this.vpnPosition = vpnPosition;
    }

    public RealmList<IptvSIDataModel> getSelectedIptvList() {
        return selectedIptvList;
    }

    public void setSelectedIptvList(RealmList<IptvSIDataModel> selectedIptvList) {
        this.selectedIptvList = selectedIptvList;
    }

    public int getTeleConnCountPosition() {
        return teleConnCountPosition;
    }

    public void setTeleConnCountPosition(int teleConnCountPosition) {
        this.teleConnCountPosition = teleConnCountPosition;
    }

    public String getIptvPackages() {
        return iptvPackages;
    }

    public void setIptvPackages(String iptvPackages) {
        this.iptvPackages = iptvPackages;
    }
}

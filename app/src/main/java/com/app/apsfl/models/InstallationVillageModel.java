package com.app.apsfl.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Arbiva on 12/14/2016.
 */

public class InstallationVillageModel extends RealmObject {

    @PrimaryKey
    private String villageCompositeKey;
    private String villageSerialNumber;
    private String villageName;
    private String mandalSerialNumber;
    private String districtSerialNumber;
    private String stateId;
    private String region;
    private String stdCode;
    private String pinCode;
    private boolean isVillageChecked;

    public String getVillageCompositeKey() {
        return villageCompositeKey;
    }

    public void setVillageCompositeKey(String villageCompositeKey) {
        this.villageCompositeKey = villageCompositeKey;
    }

    public String getVillageSerialNumber() {
        return villageSerialNumber;
    }

    public void setVillageSerialNumber(String villageSerialNumber) {
        this.villageSerialNumber = villageSerialNumber;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public String getMandalSerialNumber() {
        return mandalSerialNumber;
    }

    public void setMandalSerialNumber(String mandalSerialNumber) {
        this.mandalSerialNumber = mandalSerialNumber;
    }

    public String getDistrictSerialNumber() {
        return districtSerialNumber;
    }

    public void setDistrictSerialNumber(String districtSerialNumber) {
        this.districtSerialNumber = districtSerialNumber;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStdCode() {
        return stdCode;
    }

    public void setStdCode(String stdCode) {
        this.stdCode = stdCode;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public boolean isVillageChecked() {
        return isVillageChecked;
    }

    public void setVillageChecked(boolean villageChecked) {
        isVillageChecked = villageChecked;
    }

    @Override
    public String toString() {
        return "InstallationVillageModel{" +
                "villageCompositeKey='" + villageCompositeKey + '\'' +
                ", villageSerialNumber='" + villageSerialNumber + '\'' +
                ", villageName='" + villageName + '\'' +
                ", mandalSerialNumber='" + mandalSerialNumber + '\'' +
                ", districtSerialNumber='" + districtSerialNumber + '\'' +
                ", stateId='" + stateId + '\'' +
                ", region='" + region + '\'' +
                ", stdCode='" + stdCode + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", isVillageChecked=" + isVillageChecked +
                '}';
    }
}

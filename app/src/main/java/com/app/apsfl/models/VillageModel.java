package com.app.apsfl.models;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;

public class VillageModel extends RealmObject {

    @PrimaryKey
    private String subStationUID;
    private String villageCompositeKey;
    private String villageSerialNumber;
    private String villageName;
    private String mandalSerialNumber;
    @Index
    private String mandalName;
    private String districtSerialNumber;
    private String districtName;
    private boolean isVillageChecked;
    private String region;

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

    public String getDistrictSerialNumber() {
        return districtSerialNumber;
    }

    public void setDistrictSerialNumber(String districtSerialNumber) {
        this.districtSerialNumber = districtSerialNumber;
    }

    public String getMandalSerialNumber() {
        return mandalSerialNumber;
    }

    public void setMandalSerialNumber(String mandalSerialNumber) {
        this.mandalSerialNumber = mandalSerialNumber;
    }

    public String getMandalName() {
        return mandalName;
    }

    public void setMandalName(String mandalName) {
        this.mandalName = mandalName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getSubStationUID() {
        return subStationUID;
    }

    public void setSubStationUID(String subStationUID) {
        this.subStationUID = subStationUID;
    }

    public boolean isVillageChecked() {
        return isVillageChecked;
    }

    public void setVillageChecked(boolean villageChecked) {
        isVillageChecked = villageChecked;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "VillageModel{" +
                "villageSerialNumber='" + villageSerialNumber + '\'' +
                ", villageName='" + villageName + '\'' +
                ", mandalSerialNumber='" + mandalSerialNumber + '\'' +
                ", mandalName='" + mandalName + '\'' +
                ", districtSerialNumber='" + districtSerialNumber + '\'' +
                ", districtName='" + districtName + '\'' +
                ", subStationUID='" + subStationUID + '\'' +
                ", isVillageChecked=" + isVillageChecked +
                ", region='" + region + '\'' +
                '}';
    }
}
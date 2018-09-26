package com.app.apsfl.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Arbiva on 12/7/2016.
 */

public class PopMandalModel  extends RealmObject {

    @PrimaryKey
    private int mandalID;
    private String mandalName;
    private int districtID;
    private int mandalSerialNumber;
    private boolean isMandalChecked;

    public int getMandalID() {
        return mandalID;
    }

    public void setMandalID(int mandalID) {
        this.mandalID = mandalID;
    }

    public String getMandalName() {
        return mandalName;
    }

    public void setMandalName(String mandalName) {
        this.mandalName = mandalName;
    }

    public int getDistrictID() {
        return districtID;
    }

    public void setDistrictID(int districtID) {
        this.districtID = districtID;
    }

    public int getMandalSerialNumber() {
        return mandalSerialNumber;
    }

    public void setMandalSerialNumber(int mandalSerialNumber) {
        this.mandalSerialNumber = mandalSerialNumber;
    }

    public boolean isMandalChecked() {
        return isMandalChecked;
    }

    public void setMandalChecked(boolean mandalChecked) {
        isMandalChecked = mandalChecked;
    }
}

package com.app.apsfl.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Arbiva on 2/7/2017.
 */

public class SIPOPModel extends RealmObject {

    @PrimaryKey
    private String popID;
    private String popName = "";
    private boolean isPOPChecked;
    private String districtId;
    private String mandalID;

    public String getPopID() {
        return popID;
    }

    public void setPopID(String popID) {
        this.popID = popID;
    }

    public String getPopName() {
        return popName;
    }

    public void setPopName(String popName) {
        this.popName = popName;
    }

    public boolean isPOPChecked() {
        return isPOPChecked;
    }

    public void setPOPChecked(boolean POPChecked) {
        isPOPChecked = POPChecked;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getMandalID() {
        return mandalID;
    }

    public void setMandalID(String mandalID) {
        this.mandalID = mandalID;
    }
}

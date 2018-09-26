package com.app.apsfl.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
//Contains popmandals and installation mandals
public class MandalModel extends RealmObject {

    @PrimaryKey
    private int mandalID;
    private String mandalName;
    private String districtID;
    private String mandalSerialNumber;
    private boolean isMandalChecked;
    private boolean isPopMandal;//To differentiate popmandals and installation mandals for silmo

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

    public String getDistrictID() {
        return districtID;
    }

    public void setDistrictID(String districtID) {
        this.districtID = districtID;
    }

    public String getMandalSerialNumber() {
        return mandalSerialNumber;
    }

    public void setMandalSerialNumber(String mandalSerialNumber) {
        this.mandalSerialNumber = mandalSerialNumber;
    }

    public boolean isMandalChecked() {
        return isMandalChecked;
    }

    public void setMandalChecked(boolean mandalChecked) {
        isMandalChecked = mandalChecked;
    }

    public boolean isPopMandal() {
        return isPopMandal;
    }

    public void setPopMandal(boolean popMandal) {
        isPopMandal = popMandal;
    }
}

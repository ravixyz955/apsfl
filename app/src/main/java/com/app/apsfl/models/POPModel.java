package com.app.apsfl.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class POPModel extends RealmObject {

    @PrimaryKey
    private String popID;
    private String popName = "";
    private boolean isPOPChecked;

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
}

package com.app.apsfl.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CPEStockModel extends RealmObject {

    @PrimaryKey
    private String cpeSerialNumber;
    private int cpeProfileID;
    private String cpeMacId;

    public void setCpeSerialNumber(String cpeSerialNumber) {
        this.cpeSerialNumber = cpeSerialNumber;
    }
    public String getCpeMacId() {
        return cpeMacId;
    }

    public void setCpeMacId(String cpeMacId) {
        this.cpeMacId = cpeMacId;
    }

    public String getCpeSerialNumber() {
        return cpeSerialNumber;
    }



    public int getCpeProfileID() {
        return cpeProfileID;
    }

    public void setCpeProfileID(int cpeProfileID) {
        this.cpeProfileID = cpeProfileID;
    }
}

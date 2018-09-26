package com.app.apsfl.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class POPOLTModel extends RealmObject {

    @PrimaryKey
    private String popOLTID;
    private String popID;
    private String popName;
    private String popOLTSerialNumber;//send in service for perticular poplable
    private String popLabelNumber;//selected in spinner

    public String getPopOLTID() {
        return popOLTID;
    }

    public void setPopOLTID(String popOLTID) {
        this.popOLTID = popOLTID;
    }

    public String getPopName() {
        return popName;
    }

    public void setPopName(String popName) {
        this.popName = popName;
    }

    public String getPopOLTSerialNumber() {
        return popOLTSerialNumber;
    }

    public void setPopOLTSerialNumber(String popOLTSerialNumber) {
        this.popOLTSerialNumber = popOLTSerialNumber;
    }

    public String getPopLabelNumber() {
        return popLabelNumber;
    }

    public void setPopLabelNumber(String popLabelNumber) {
        this.popLabelNumber = popLabelNumber;
    }

    public String getPopID() {
        return popID;
    }

    public void setPopID(String popID) {
        this.popID = popID;
    }

    @Override
    public String toString() {
        return "POPOLTModel{" +
                "popOLTID='" + popOLTID + '\'' +
                ", popID='" + popID + '\'' +
                ", popName='" + popName + '\'' +
                ", popOLTSerialNumber='" + popOLTSerialNumber + '\'' +
                ", popLabelNumber='" + popLabelNumber + '\'' +
                '}';
    }
}

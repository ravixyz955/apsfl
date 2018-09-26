package com.app.apsfl.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class L3PortModel extends RealmObject {

    @PrimaryKey
    private String l1PortNumber;
    private String l3PortNumbers;

    public String getL1PortNumber() {
        return l1PortNumber;
    }

    public void setL1PortNumber(String l1PortNumber) {
        this.l1PortNumber = l1PortNumber;
    }

    public String getL3PortNumbers() {
        return l3PortNumbers;
    }

    public void setL3PortNumbers(String l3PortNumbers) {
        this.l3PortNumbers = l3PortNumbers;
    }

    @Override
    public String toString() {
        return "L3PortModel{" +
                "l1PortNumber='" + l1PortNumber + '\'' + "\n" +
                ", l3PortNumbers='" + l3PortNumbers + '\'' + "\n" +
                '}';
    }
}
package com.app.apsfl.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class L2PortModel extends RealmObject {

    @PrimaryKey
    private String l1PortNumber;
    private String l2PortNumbers;

    public String getL1PortNumber() {
        return l1PortNumber;
    }

    public void setL1PortNumber(String l1PortNumber) {
        this.l1PortNumber = l1PortNumber;
    }

    public String getL2PortNumbers() {
        return l2PortNumbers;
    }

    public void setL2PortNumbers(String l2PortNumbers) {
        this.l2PortNumbers = l2PortNumbers;
    }

    @Override
    public String toString() {
        return "L2PortModel{" +
                "l1PortNumber='" + l1PortNumber + '\'' + "\n" +
                ", l2PortNumbers='" + l2PortNumbers + '\'' + "\n" +
                '}';
    }
}
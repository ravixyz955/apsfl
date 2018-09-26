package com.app.apsfl.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class L1PortModel extends RealmObject {

    @PrimaryKey
    private String oltL1Port;
    private String oltPortNumber;
    private String l1PortNumbers;
    private String popIdPortno;

    public String getOltPortNumber() {
        return oltPortNumber;
    }

    public void setOltPortNumber(String oltPortNumber) {
        this.oltPortNumber = oltPortNumber;
    }

    public String getL1PortNumbers() {
        return l1PortNumbers;
    }

    public void setL1PortNumbers(String l1PortNumbers) {
        this.l1PortNumbers = l1PortNumbers;
    }

    public String getPopIdPortno() {
        return popIdPortno;
    }

    public void setPopIdPortno(String popIdPortno) {
        this.popIdPortno = popIdPortno;
    }

    public String getOltL1Port() {
        return oltL1Port;
    }

    public void setOltL1Port(String oltL1Port) {
        this.oltL1Port = oltL1Port;
    }

    @Override
    public String toString() {
        return "L1PortModel{" +
                "oltL1Port='" + oltL1Port + '\'' +
                ", oltPortNumber='" + oltPortNumber + '\'' +
                ", l1PortNumbers='" + l1PortNumbers + '\'' +
                ", popIdPortno='" + popIdPortno + '\'' +
                '}';
    }
}
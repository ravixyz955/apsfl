package com.app.apsfl.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class OltPortDetails extends RealmObject {

    @PrimaryKey
    private String popIdPortNo;
    private String portNo;
    private String popId;

    public String getPortNo() {
        return portNo;
    }

    public void setPortNo(String portNo) {
        this.portNo = portNo;
    }

    public String getPopIdPortNo() {
        return popIdPortNo;
    }

    public void setPopIdPortNo(String popIdPortNo) {
        this.popIdPortNo = popIdPortNo;
    }

    public String getPopId() {
        return popId;
    }

    public void setPopId(String popId) {
        this.popId = popId;
    }

    @Override
    public String toString() {
        return "OltPortDetails{" +
                "popIdPortNo='" + popIdPortNo + '\'' +
                ", portNo='" + portNo + '\'' +
                ", popId='" + popId + '\'' +
                '}';
    }
}

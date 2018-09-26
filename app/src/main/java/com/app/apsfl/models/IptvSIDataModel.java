package com.app.apsfl.models;

import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;



public class IptvSIDataModel extends RealmObject {

    @PrimaryKey
    private String iptvpositionApsflTrackId;
    private String apsflTrackId;
    private int iptvposition;
    private String iptvBoxModel;
    private String ipTVSerialNumber;
    private int stbModelPosition;
    private Boolean isSTBChecked;
    private String iptvPkg;

    public String getIptvpositionApsflTrackId() {
        return iptvpositionApsflTrackId;
    }

    public void setIptvpositionApsflTrackId(String iptvpositionApsflTrackId) {
        this.iptvpositionApsflTrackId = iptvpositionApsflTrackId;
    }

    public String getApsflTrackId() {
        return apsflTrackId;
    }

    public void setApsflTrackId(String apsflTrackId) {
        this.apsflTrackId = apsflTrackId;
    }

    public int getIptvposition() {
        return iptvposition;
    }

    public void setIptvposition(int iptvposition) {
        this.iptvposition = iptvposition;
    }

    public String getIptvBoxModel() {
        return iptvBoxModel;
    }

    public void setIptvBoxModel(String iptvBoxModel) {
        this.iptvBoxModel = iptvBoxModel;
    }

    public String getIpTVSerialNumber() {
        return ipTVSerialNumber;
    }

    public void setIpTVSerialNumber(String ipTVSerialNumber) {
        this.ipTVSerialNumber = ipTVSerialNumber;
    }

    public int getStbModelPosition() {
        return stbModelPosition;
    }

    public void setStbModelPosition(int stbModelPosition) {
        this.stbModelPosition = stbModelPosition;
    }

    public Boolean getSTBChecked() {
        return isSTBChecked;
    }

    public void setSTBChecked(Boolean STBChecked) {
        isSTBChecked = STBChecked;
    }

    public String getIptvPkg() {
        return iptvPkg;
    }

    public void setIptvPkg(String iptvPkg) {
        this.iptvPkg = iptvPkg;
    }
}

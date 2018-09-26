package com.app.apsfl.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Arbiva on 12/20/2016.
 */

public class VpnServiceModel extends RealmObject {

    @PrimaryKey
    private String VpnCompositeKey;
    private String substnUid;
    private String oltSerialNo;
    private String vpnsrvcName;

    public String getSubstnUid() {
        return substnUid;
    }

    public void setSubstnUid(String substnUid) {
        this.substnUid = substnUid;
    }

    public String getOltSerialNo() {
        return oltSerialNo;
    }

    public void setOltSerialNo(String oltSerialNo) {
        this.oltSerialNo = oltSerialNo;
    }

    public String getVpnsrvcName() {
        return vpnsrvcName;
    }

    public void setVpnsrvcName(String vpnsrvcName) {
        this.vpnsrvcName = vpnsrvcName;
    }

    public String getVpnCompositeKey() {
        return VpnCompositeKey;
    }

    public void setVpnCompositeKey(String vpnCompositeKey) {
        VpnCompositeKey = vpnCompositeKey;
    }
}

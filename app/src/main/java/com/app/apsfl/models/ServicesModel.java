package com.app.apsfl.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ServicesModel extends RealmObject {

    @PrimaryKey
    private String serviceCode;
    private String serviceName;
    private String serviceEffectiveFrom;
    private Boolean isServiceChecked;

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceEffectiveFrom() {
        return serviceEffectiveFrom;
    }

    public void setServiceEffectiveFrom(String serviceEffectiveFrom) {
        this.serviceEffectiveFrom = serviceEffectiveFrom;
    }

    public Boolean isServiceChecked() {
        return isServiceChecked;
    }

    public void setServiceChecked(Boolean serviceChecked) {
        isServiceChecked = serviceChecked;
    }
}

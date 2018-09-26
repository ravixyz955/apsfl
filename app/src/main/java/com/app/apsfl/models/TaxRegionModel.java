package com.app.apsfl.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
//not used presently
public class TaxRegionModel extends RealmObject {

    @PrimaryKey
    private String pinCode;
    private String regionCode;
    private Double effectiveFrom;
    private Double effectiveTo;

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public Double getEffectiveFrom() {
        return effectiveFrom;
    }

    public void setEffectiveFrom(Double effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }

    public Double getEffectiveTo() {
        return effectiveTo;
    }

    public void setEffectiveTo(Double effectiveTo) {
        this.effectiveTo = effectiveTo;
    }
}

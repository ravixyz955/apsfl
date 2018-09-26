package com.app.apsfl.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
//for voipFeature Activity
public class VOIPFeatureModel extends RealmObject {

    @PrimaryKey
    private String uniqueKey;
    private String coreServiceCode;
    private String effectiveFrom;
    private String featureCode;
    private String paramCode;
    private String paramName;
    private String paramType;
    private String paramLovName;
    private int maxParamValues;

    public String getUniqueKey() {
        return uniqueKey;
    }

    public void setUniqueKey(String uniqueKey) {
        this.uniqueKey = uniqueKey;
    }

    public String getCoreServiceCode() {
        return coreServiceCode;
    }

    public void setCoreServiceCode(String coreServiceCode) {
        this.coreServiceCode = coreServiceCode;
    }

    public String getEffectiveFrom() {
        return effectiveFrom;
    }

    public void setEffectiveFrom(String effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }

    public String getFeatureCode() {
        return featureCode;
    }

    public void setFeatureCode(String featureCode) {
        this.featureCode = featureCode;
    }

    public String getParamCode() {
        return paramCode;
    }

    public void setParamCode(String paramCode) {
        this.paramCode = paramCode;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    public String getParamLovName() {
        return paramLovName;
    }

    public void setParamLovName(String paramLovName) {
        this.paramLovName = paramLovName;
    }

    public int getMaxParamValues() {
        return maxParamValues;
    }

    public void setMaxParamValues(int maxParamValues) {
        this.maxParamValues = maxParamValues;
    }
}

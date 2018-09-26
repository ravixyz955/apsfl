package com.app.apsfl.models;
//To retrive saved data in VOIPFeature Activity
public class VOIPSavedModel {

    private String paramName;
    private String paramLovName;
    private String paramCode;
    private String inputFieldValue;
    private Integer inputSpinnerPosition;
    private boolean isRemoveVisible;
    private boolean isFilled;

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamLovName() {
        return paramLovName;
    }

    public void setParamLovName(String paramLovName) {
        this.paramLovName = paramLovName;
    }

    public String getParamCode() {
        return paramCode;
    }

    public void setParamCode(String paramCode) {
        this.paramCode = paramCode;
    }

    public String getInputFieldValue() {
        return inputFieldValue;
    }

    public void setInputFieldValue(String inputFieldValue) {
        this.inputFieldValue = inputFieldValue;
    }

    public Integer getInputSpinnerPosition() {
        return inputSpinnerPosition;
    }

    public void setInputSpinnerPosition(Integer inputSpinnerPosition) {
        this.inputSpinnerPosition = inputSpinnerPosition;
    }

    public boolean isRemoveVisible() {
        return isRemoveVisible;
    }

    public void setRemoveVisible(boolean removeVisible) {
        isRemoveVisible = removeVisible;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public void setFilled(boolean filled) {
        isFilled = filled;
    }

    @Override
    public String toString() {
        return "VOIPSavedModel{" +
                "paramLovName='" + paramLovName + '\'' + "\n" +
                ", paramCode='" + paramCode + '\'' + "\n" +
                ", paramName='" + paramName + '\'' + "\n" +
                ", inputSpinnerPosition=" + inputSpinnerPosition + "\n" +
                ", inputFieldValue='" + inputFieldValue + '\'' + "\n" +
                ", isRemoveVisible='" + isRemoveVisible + '\'' + "\n" +
                ", isFilled='" + isFilled + '\'' + "\n" +
                '}';
    }
}
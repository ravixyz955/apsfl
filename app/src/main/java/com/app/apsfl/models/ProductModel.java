package com.app.apsfl.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ProductModel extends RealmObject {

    @PrimaryKey
    private String productUniqueKey;
    private String productCode;
    private String productName;
    private String productDate;
    private String productTenantCode;
    private String voipServiceCode;
    private String productTenantName;
    private String productRecurringCharge;
    private String productActivationCharge;
    private String productSecurityCharge;
    private String productRecurringTax;
    private String productActivationTax;
    private String productSecurityTax;
    private String productTax;
    private String productTotalCharge;
    private String productLockInPeriod;
    private String productType;
    private Boolean isProductCheckBoxVisible;
    private Boolean isProductChecked;
    private boolean isIndividualProduct;
    private boolean isProductInfoShown = false;
    private String featureCodes;
    private String productData;
    private String totalProductsCost;//Used for SILMO in workorder
    private String coreServiceCode;
    private String srvcName;
    private String serviceCode;

    public String getProductUniqueKey() {
        return productUniqueKey;
    }

    public void setProductUniqueKey(String productUniqueKey) {
        this.productUniqueKey = productUniqueKey;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDate() {
        return productDate;
    }

    public void setProductDate(String productDate) {
        this.productDate = productDate;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductTenantCode() {
        return productTenantCode;
    }

    public void setProductTenantCode(String productTenantCode) {
        this.productTenantCode = productTenantCode;
    }

    public String getVoipServiceCode() {
        return voipServiceCode;
    }

    public void setVoipServiceCode(String voipServiceCode) {
        this.voipServiceCode = voipServiceCode;
    }

    public String getProductTenantName() {
        return productTenantName;
    }

    public void setProductTenantName(String productTenantName) {
        this.productTenantName = productTenantName;
    }

    public String getProductRecurringCharge() {
        return productRecurringCharge;
    }

    public void setProductRecurringCharge(String productRecurringCharge) {
        this.productRecurringCharge = productRecurringCharge;
    }

    public String getProductActivationCharge() {
        return productActivationCharge;
    }

    public void setProductActivationCharge(String productActivationCharge) {
        this.productActivationCharge = productActivationCharge;
    }

    public String getProductSecurityCharge() {
        return productSecurityCharge;
    }

    public void setProductSecurityCharge(String productSecurityCharge) {
        this.productSecurityCharge = productSecurityCharge;
    }

    public String getProductRecurringTax() {
        return productRecurringTax;
    }

    public void setProductRecurringTax(String productRecurringTax) {
        this.productRecurringTax = productRecurringTax;
    }

    public String getProductActivationTax() {
        return productActivationTax;
    }

    public void setProductActivationTax(String productActivationTax) {
        this.productActivationTax = productActivationTax;
    }

    public String getProductSecurityTax() {
        return productSecurityTax;
    }

    public void setProductSecurityTax(String productSecurityTax) {
        this.productSecurityTax = productSecurityTax;
    }

    public String getProductTax() {
        return productTax;
    }

    public void setProductTax(String productTax) {
        this.productTax = productTax;
    }

    public String getProductTotalCharge() {
        return productTotalCharge;
    }

    public void setProductTotalCharge(String productTotalCharge) {
        this.productTotalCharge = productTotalCharge;
    }

    public String getProductLockInPeriod() {
        return productLockInPeriod;
    }

    public void setProductLockInPeriod(String productLockInPeriod) {
        this.productLockInPeriod = productLockInPeriod;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Boolean isProductCheckBoxVisible() {
        return isProductCheckBoxVisible;
    }

    public void setProductCheckBoxVisible(Boolean productCheckBoxVisible) {
        isProductCheckBoxVisible = productCheckBoxVisible;
    }

    public Boolean isProductChecked() {
        return isProductChecked;
    }

    public void setProductChecked(Boolean productChecked) {
        isProductChecked = productChecked;
    }

    public boolean isIndividualProduct() {
        return isIndividualProduct;
    }

    public void setIndividualProduct(boolean individualProduct) {
        isIndividualProduct = individualProduct;
    }

    public boolean isProductInfoShown() {
        return isProductInfoShown;
    }

    public void setProductInfoShown(boolean productInfoShown) {
        isProductInfoShown = productInfoShown;
    }

    public String getFeatureCodes() {
        return featureCodes;
    }

    public void setFeatureCodes(String featureCodes) {
        this.featureCodes = featureCodes;
    }

    public String getProductData() {
        return productData;
    }

    public void setProductData(String productData) {
        this.productData = productData;
    }

    public String getTotalProductsCost() {
        return totalProductsCost;
    }

    public void setTotalProductsCost(String totalProductsCost) {
        this.totalProductsCost = totalProductsCost;
    }

    public String getCoreServiceCode() {
        return coreServiceCode;
    }

    public void setCoreServiceCode(String coreServiceCode) {
        this.coreServiceCode = coreServiceCode;
    }

    public String getSrvcName() {
        return srvcName;
    }

    public void setSrvcName(String srvcName) {
        this.srvcName = srvcName;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "productUniqueKey='" + productUniqueKey + '\'' +
                ", productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productDate='" + productDate + '\'' +
                ", productTenantCode='" + productTenantCode + '\'' +
                ", voipServiceCode='" + voipServiceCode + '\'' +
                ", productTenantName='" + productTenantName + '\'' +
                ", productRecurringCharge='" + productRecurringCharge + '\'' +
                ", productActivationCharge='" + productActivationCharge + '\'' +
                ", productSecurityCharge='" + productSecurityCharge + '\'' +
                ", productRecurringTax='" + productRecurringTax + '\'' +
                ", productActivationTax='" + productActivationTax + '\'' +
                ", productSecurityTax='" + productSecurityTax + '\'' +
                ", productTax='" + productTax + '\'' +
                ", productTotalCharge='" + productTotalCharge + '\'' +
                ", productLockInPeriod='" + productLockInPeriod + '\'' +
                ", productType='" + productType + '\'' +
                ", isProductCheckBoxVisible=" + isProductCheckBoxVisible +
                ", isProductChecked=" + isProductChecked +
                ", isIndividualProduct=" + isIndividualProduct +
                ", isProductInfoShown=" + isProductInfoShown +
                ", featureCodes='" + featureCodes + '\'' +
                ", productData='" + productData + '\'' +
                ", totalProductsCost='" + totalProductsCost + '\'' +
                ", coreServiceCode='" + coreServiceCode + '\'' +
                '}';
    }
}

package com.app.apsfl.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Arbiva on 2/6/2017.
 */

public class OfflineEditCafModel extends RealmObject {

    @PrimaryKey
    private String apsflTrackId;
    private String cafNo;
    private String contactPersonMobileNo;
    private String contactPersonName;
    private String cpeplace;
    private String instAddress1;
    private String fName;
    private String organizationName;
    private String instDistId;
    private String instMandalId;
    private String packageNames;
    private String popDistId;
    private String popMandalId;
    private String coreServiceCodes;
    private String iptvPackages;

    private String entCustomerCode;
    private String entCustType;
    private String custId;
    private String billCycle;



    public String getApsflTrackId() {
        return apsflTrackId;
    }

    public void setApsflTrackId(String apsflTrackId) {
        this.apsflTrackId = apsflTrackId;
    }

    public String getCafNo() {
        return cafNo;
    }

    public void setCafNo(String cafNo) {
        this.cafNo = cafNo;
    }

    public String getContactPersonMobileNo() {
        return contactPersonMobileNo;
    }

    public void setContactPersonMobileNo(String contactPersonMobileNo) {
        this.contactPersonMobileNo = contactPersonMobileNo;
    }

    public String getCpeplace() {
        return cpeplace;
    }

    public void setCpeplace(String cpeplace) {
        this.cpeplace = cpeplace;
    }

    public String getInstAddress1() {
        return instAddress1;
    }

    public void setInstAddress1(String instAddress1) {
        this.instAddress1 = instAddress1;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getInstDistId() {
        return instDistId;
    }

    public void setInstDistId(String instDistId) {
        this.instDistId = instDistId;
    }

    public String getInstMandalId() {
        return instMandalId;
    }

    public void setInstMandalId(String instMandalId) {
        this.instMandalId = instMandalId;
    }

    public String getPackageNames() {
        return packageNames;
    }

    public void setPackageNames(String packageNames) {
        this.packageNames = packageNames;
    }

    public String getPopDistId() {
        return popDistId;
    }

    public void setPopDistId(String popDistId) {
        this.popDistId = popDistId;
    }

    public String getPopMandalId() {
        return popMandalId;
    }

    public void setPopMandalId(String popMandalId) {
        this.popMandalId = popMandalId;
    }

    public String getCoreServiceCodes() {
        return coreServiceCodes;
    }

    public void setCoreServiceCodes(String coreServiceCodes) {
        this.coreServiceCodes = coreServiceCodes;
    }

    public String getEntCustomerCode() {
        return entCustomerCode;
    }

    public void setEntCustomerCode(String entCustomerCode) {
        this.entCustomerCode = entCustomerCode;
    }

    public String getEntCustType() {
        return entCustType;
    }

    public void setEntCustType(String entCustType) {
        this.entCustType = entCustType;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getBillCycle() {
        return billCycle;
    }

    public void setBillCycle(String billCycle) {
        this.billCycle = billCycle;
    }

    public String getIptvPackages() {
        return iptvPackages;
    }

    public void setIptvPackages(String iptvPackages) {
        this.iptvPackages = iptvPackages;
    }
}

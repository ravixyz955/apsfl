package com.app.apsfl.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class FormSpinnerModel extends RealmObject {

    @PrimaryKey
    private String customerTitles;
    private String customerSegments;
    private String customerChannels;
    private String billFrequencies;
    private String vmAddresses;
    private String hotLinePriorities;

    public String getCustomerTitles() {
        return customerTitles;
    }

    public void setCustomerTitles(String customerTitles) {
        this.customerTitles = customerTitles;
    }

    public String getCustomerSegments() {
        return customerSegments;
    }

    public void setCustomerSegments(String customerSegments) {
        this.customerSegments = customerSegments;
    }

    public String getCustomerChannels() {
        return customerChannels;
    }

    public void setCustomerChannels(String customerChannels) {
        this.customerChannels = customerChannels;
    }

    public String getBillFrequencies() {
        return billFrequencies;
    }

    public void setBillFrequencies(String billFrequencies) {
        this.billFrequencies = billFrequencies;
    }

    public String getVmAddresses() {
        return vmAddresses;
    }

    public void setVmAddresses(String vmAddresses) {
        this.vmAddresses = vmAddresses;
    }

    public String getHotLinePriorities() {
        return hotLinePriorities;
    }

    public void setHotLinePriorities(String hotLinePriorities) {
        this.hotLinePriorities = hotLinePriorities;
    }
}
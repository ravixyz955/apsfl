package com.app.apsfl.models;

/**
 * Created by Arbiva on 1/16/2017.
 */

public class SelectedIpTvPackage {

    private String packageName;
    private String packageCOde;
    private boolean selectedPackages;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getPackageCOde() {
        return packageCOde;
    }

    public void setpackagecode(String packageCOde) {
        this.packageCOde = packageCOde;
    }

    public boolean isSelectedPackages() {
        return selectedPackages;
    }

    public void setSelectedPackages(boolean selectedPackages) {
        this.selectedPackages = selectedPackages;
    }
}

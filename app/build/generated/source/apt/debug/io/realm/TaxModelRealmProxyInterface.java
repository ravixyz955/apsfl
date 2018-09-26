package io.realm;


public interface TaxModelRealmProxyInterface {
    public String realmGet$uniqueKey();
    public void realmSet$uniqueKey(String value);
    public String realmGet$regionCode();
    public void realmSet$regionCode(String value);
    public String realmGet$taxCode();
    public void realmSet$taxCode(String value);
    public Long realmGet$effectiveFrom();
    public void realmSet$effectiveFrom(Long value);
    public Long realmGet$effectiveTo();
    public void realmSet$effectiveTo(Long value);
    public Double realmGet$taxPercentage();
    public void realmSet$taxPercentage(Double value);
    public boolean realmGet$isAbsolute();
    public void realmSet$isAbsolute(boolean value);
}

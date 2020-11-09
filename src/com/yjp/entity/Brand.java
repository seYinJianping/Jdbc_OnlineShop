package com.yjp.entity;

public class Brand {
    private int brandId;
    private String brandName;
    private String brandSupplier;
    private String brandCharger;
    private String brandAddress;

    public Brand() {
    }

    public Brand(int brandId, String brandName, String brandSupplier, String brandCharger, String brandAddress) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.brandSupplier = brandSupplier;
        this.brandCharger = brandCharger;
        this.brandAddress = brandAddress;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandSupplier() {
        return brandSupplier;
    }

    public void setBrandSupplier(String brandSupplier) {
        this.brandSupplier = brandSupplier;
    }

    public String getBrandCharger() {
        return brandCharger;
    }

    public void setBrandCharger(String brandCharger) {
        this.brandCharger = brandCharger;
    }

    public String getBrandAddress() {
        return brandAddress;
    }

    public void setBrandAddress(String brandAddress) {
        this.brandAddress = brandAddress;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brandId=" + brandId +
                ", brandName='" + brandName + '\'' +
                ", brandSupplier='" + brandSupplier + '\'' +
                ", brandCharger='" + brandCharger + '\'' +
                ", brandAddress='" + brandAddress + '\'' +
                '}';
    }
}

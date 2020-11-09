package com.yjp.entity;

public class Supplier {
    //供应商编号
    private int supplierNumber;
    //供应商姓名
    private String supplierName;
    //供应商厂商
    private String supplierCompany;
    //供应商密码
    private String supplierPassword;

    public Supplier() {
    }

    public Supplier(int supplierNumber, String supplierName, String supplierCompany, String supplierPassword) {
        this.supplierNumber = supplierNumber;
        this.supplierName = supplierName;
        this.supplierCompany = supplierCompany;
        this.supplierPassword = supplierPassword;
    }

    public int getSupplierNumber() {
        return supplierNumber;
    }

    public void setSupplierNumber(int supplierNumber) {
        this.supplierNumber = supplierNumber;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierCompany() {
        return supplierCompany;
    }

    public void setSupplierCompany(String supplierCompany) {
        this.supplierCompany = supplierCompany;
    }

    public String getSupplierPassword() {
        return supplierPassword;
    }

    public void setSupplierPassword(String supplierPassword) {
        this.supplierPassword = supplierPassword;
    }
}

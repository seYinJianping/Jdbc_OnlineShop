package com.yjp.entity;

public class Order {
    private int orderNum;
    private String orderAccount;
    private String orderName;
    private String orderTel;
    private String orderAdd;
    private String orderItemBrand;
    private String orderItemName;
    private int orderCount;
    private int orderBill;

    public Order() {
    }

    public Order(int orderNum, String orderAccount, String orderName, String orderTel, String orderAdd, String orderItemBrand, String orderItemName, int orderCount, int orderBill) {
        this.orderNum = orderNum;
        this.orderAccount = orderAccount;
        this.orderName = orderName;
        this.orderTel = orderTel;
        this.orderAdd = orderAdd;
        this.orderItemBrand = orderItemBrand;
        this.orderItemName = orderItemName;
        this.orderCount = orderCount;
        this.orderBill = orderBill;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public String getOrderAccount() {
        return orderAccount;
    }

    public void setOrderAccount(String orderAccount) {
        this.orderAccount = orderAccount;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderTel() {
        return orderTel;
    }

    public void setOrderTel(String orderTel) {
        this.orderTel = orderTel;
    }

    public String getOrderAdd() {
        return orderAdd;
    }

    public void setOrderAdd(String orderAdd) {
        this.orderAdd = orderAdd;
    }

    public String getOrderItemBrand() {
        return orderItemBrand;
    }

    public void setOrderItemBrand(String orderItemBrand) {
        this.orderItemBrand = orderItemBrand;
    }

    public String getOrderItemName() {
        return orderItemName;
    }

    public void setOrderItemName(String orderItemName) {
        this.orderItemName = orderItemName;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    public int getOrderBill() {
        return orderBill;
    }

    public void setOrderBill(int orderBill) {
        this.orderBill = orderBill;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNum=" + orderNum +
                ", orderAccount='" + orderAccount + '\'' +
                ", orderName='" + orderName + '\'' +
                ", orderTel='" + orderTel + '\'' +
                ", orderAdd='" + orderAdd + '\'' +
                ", orderItemBrand='" + orderItemBrand + '\'' +
                ", orderItemName='" + orderItemName + '\'' +
                ", orderCount=" + orderCount +
                ", orderBill=" + orderBill +
                '}';
    }
}

package com.yjp.entity;


import java.io.Serializable;

public class Staff implements Serializable {
    //工号
    private int staffNumber;
    //姓名
    private String staffName;
    //部门
    private String staffDepartment;
    //密码
    private String staffPassword;

    public Staff() {
    }

    public Staff(int staffNumber, String staffName, String staffDepartment, String staffPassword) {
        this.staffNumber = staffNumber;
        this.staffName = staffName;
        this.staffDepartment = staffDepartment;
        this.staffPassword = staffPassword;
    }

    public int getStaffNumber() {
        return staffNumber;
    }

    public void setStaffNumber(int staffNumber) {
        this.staffNumber = staffNumber;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffDepartment() {
        return staffDepartment;
    }

    public void setStaffDepartment(String staffDepartment) {
        this.staffDepartment = staffDepartment;
    }

    public String getStaffPassword() {
        return staffPassword;
    }

    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword;
    }
}

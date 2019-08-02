package com.bosch.dto;

import java.util.Date;

/**
 * @program: demo
 * @description: DTO for OT
 * @author: wjy
 * @create: 2019-06-18 17:35
 */

public class OT {
    int otId;
    int userId;
    boolean termination;
    Date importTime;
    String perNumber;
    String period;
    String organizationUnit;
    double ot10;
    double ot15;
    double ot20;
    double ot30;
    double otTotal;

    public int getOtId() {
        return otId;
    }

    public void setOtId(int otId) {
        this.otId = otId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isTermination() {
        return termination;
    }

    public void setTermination(boolean termination) {
        this.termination = termination;
    }

    public Date getImportTime() {
        return importTime;
    }

    public void setImportTime(Date importTime) {
        this.importTime = importTime;
    }

    public String getPerNumber() {
        return perNumber;
    }

    public void setPerNumber(String perNumber) {
        this.perNumber = perNumber;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getOrganizationUnit() {
        return organizationUnit;
    }

    public void setOrganizationUnit(String organizationUnit) {
        this.organizationUnit = organizationUnit;
    }

    public double getOt10() {
        return ot10;
    }

    public void setOt10(double ot10) {
        this.ot10 = ot10;
    }

    public double getOt15() {
        return ot15;
    }

    public void setOt15(double ot15) {
        this.ot15 = ot15;
    }

    public double getOt20() {
        return ot20;
    }

    public void setOt20(double ot20) {
        this.ot20 = ot20;
    }

    public double getOt30() {
        return ot30;
    }

    public void setOt30(double ot30) {
        this.ot30 = ot30;
    }

    public double getOtTotal() {
        return otTotal;
    }

    public void setOtTotal(double otTotal) {
        this.otTotal = otTotal;
    }

    @Override
    public String toString() {
        return "OT{" +
                "otId=" + otId +
                ", userId=" + userId +
                ", termination=" + termination +
                ", importTime=" + importTime +
                ", perNumber='" + perNumber + '\'' +
                ", period='" + period + '\'' +
                ", organizationUnit='" + organizationUnit + '\'' +
                ", ot10=" + ot10 +
                ", ot15=" + ot15 +
                ", ot20=" + ot20 +
                ", ot30=" + ot30 +
                ", otTotal=" + otTotal +
                '}';
    }
}

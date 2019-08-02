package com.bosch.dto;

import java.util.Date;

/**
 * @program: demo
 * @description: DTO for BASEPAY_GRADE
 * @author: wjy
 * @create: 2019-06-17 14:49
 */

public class BasepayGrade {
    private int basepayId;
    private int userId;
    private boolean termination;
    private String importTime;
    private String perNumber;
    private String organizationUnit;
    private Date startDate;
    private Date endDate;
    private double payment;
    private double grade;


    public int getBasepayId() {
        return basepayId;
    }

    public void setBasepayId(int basepayId) {
        this.basepayId = basepayId;
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

    public String getImportTime() {
        return importTime;
    }

    public void setImportTime(String importTime) {
        this.importTime = importTime;
    }

    public String getPerNumber() {
        return perNumber;
    }

    public void setPerNumber(String perNumber) {
        this.perNumber = perNumber;
    }

    public String getOrganizationUnit() {
        return organizationUnit;
    }

    public void setOrganizationUnit(String organizationUnit) {
        this.organizationUnit = organizationUnit;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "BasepayGrade{" +
                "basepayId=" + basepayId +
                ", userId=" + userId +
                ", termination=" + termination +
                ", importTime='" + importTime + '\'' +
                ", perNumber='" + perNumber + '\'' +
                ", organizationUnit='" + organizationUnit + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", payment=" + payment +
                ", grade=" + grade +
                '}';
    }
}

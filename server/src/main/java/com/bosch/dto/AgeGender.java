package com.bosch.dto;

import java.util.Date;

/**
 * @program: demo
 * @description: DTO for AgeGender
 * @author: wjy
 * @create: 2019-06-18 17:33
 */

public class AgeGender {

    private int agId;
    private int userId;
    private boolean termination;
    private Date importTime;
    private String perNumber;
    private Date startDate;
    private Date endDate;
    private String genderKey;
    private int noCh;
    private int ageOfEmployee;
    private String maritalStatusKey;

    public int getAgId() {
        return agId;
    }

    public void setAgId(int agId) {
        this.agId = agId;
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

    public String getGenderKey() {
        return genderKey;
    }

    public void setGenderKey(String genderKey) {
        this.genderKey = genderKey;
    }

    public int getNoCh() {
        return noCh;
    }

    public void setNoCh(int noCh) {
        this.noCh = noCh;
    }

    public int getAgeOfEmployee() {
        return ageOfEmployee;
    }

    public void setAgeOfEmployee(int ageOfEmployee) {
        this.ageOfEmployee = ageOfEmployee;
    }

    public String getMaritalStatusKey() {
        return maritalStatusKey;
    }

    public void setMaritalStatusKey(String maritalStatusKey) {
        this.maritalStatusKey = maritalStatusKey;
    }

    @Override
    public String toString() {
        return "AgeGender{" +
                "agId=" + agId +
                ", userId=" + userId +
                ", termination=" + termination +
                ", importTime=" + importTime +
                ", perNumber='" + perNumber + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", genderKey='" + genderKey + '\'' +
                ", noCh=" + noCh +
                ", ageOfEmployee=" + ageOfEmployee +
                ", maritalStatusKey='" + maritalStatusKey + '\'' +
                '}';
    }
}

package com.bosch.dto;

import java.util.Date;

/**
 * @program: demo
 * @description: DTO for ADDRESS
 * @author: wjy
 * @create: 2019-06-18 17:24
 */

public class Address {

    private int addressId;
    private int userId;
    private boolean termination;
    private Date importTime;
    private String perNumber;
    private Date startDate;
    private Date endDate;
    private String addressRecordType;
    private String streetAndHouseNumber;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
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

    public String getAddressRecordType() {
        return addressRecordType;
    }

    public void setAddressRecordType(String addressRecordType) {
        this.addressRecordType = addressRecordType;
    }

    public String getStreetAndHouseNumber() {
        return streetAndHouseNumber;
    }

    public void setStreetAndHouseNumber(String streetAndHouseNumber) {
        this.streetAndHouseNumber = streetAndHouseNumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", userId=" + userId +
                ", termination=" + termination +
                ", importTime=" + importTime +
                ", perNumber='" + perNumber + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", addressRecordType='" + addressRecordType + '\'' +
                ", streetAndHouseNumber='" + streetAndHouseNumber + '\'' +
                '}';
    }
}

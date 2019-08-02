package com.bosch.dto;

import java.util.Date;

/**
 * @program: demo
 * @description: DTO for EDUCATION
 * @author: wjy
 * @create: 2019-06-18 17:35
 */

public class Education {

    int eduId;
    int userId;
    boolean termination;
    Date importTime;
    String perNumber;
    Date startDate;
    Date endDate;
    String institution;
    String location;
    String certificate;
    String major;

    public int getEduId() {
        return eduId;
    }

    public void setEduId(int eduId) {
        this.eduId = eduId;
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

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Education{" +
                "eduId=" + eduId +
                ", userId=" + userId +
                ", termination=" + termination +
                ", importTime=" + importTime +
                ", perNumber='" + perNumber + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", institution='" + institution + '\'' +
                ", location='" + location + '\'' +
                ", certificate='" + certificate + '\'' +
                ", major='" + major + '\'' +
                '}';
    }
}

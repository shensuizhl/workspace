package com.bosch.vo;

import java.util.Date;

/**
 * @program: demo
 * @description: VO for Employee
 * @author: wjy
 * @create: 2019-06-18 17:36
 */

public class EmployeeVO {

    String perNumber;
    boolean termination;
    Date importTime;
    Date locChangeStatus;
    String address;
    float distance;
    String institution;
    Date yearOfGraduation;
    String certificate;
    String starLevel;
    String locationOfUniversity;
    int ageOfEmployee;
    Date birthDate;
    String genderKey;
    String maritalStatusKey;
    int noCh;
    float payment;
    float grade;
    float gradeChangePer;
    float paymentChangePer;
    String organizationUnit;
    String position;
    float yearOfWork;
    Date terminationDate;
    float yearOfCurrentPosition;

    public String getPerNumber() {
        return perNumber;
    }

    public void setPerNumber(String perNumber) {
        this.perNumber = perNumber;
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

    public Date getLocChangeStatus() {
        return locChangeStatus;
    }

    public void setLocChangeStatus(Date locChangeStatus) {
        this.locChangeStatus = locChangeStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public Date getYearOfGraduation() {
        return yearOfGraduation;
    }

    public void setYearOfGraduation(Date yearOfGraduation) {
        this.yearOfGraduation = yearOfGraduation;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(String starLevel) {
        this.starLevel = starLevel;
    }

    public String getLocationOfUniversity() {
        return locationOfUniversity;
    }

    public void setLocationOfUniversity(String locationOfUniversity) {
        this.locationOfUniversity = locationOfUniversity;
    }

    public int getAgeOfEmployee() {
        return ageOfEmployee;
    }

    public void setAgeOfEmployee(int ageOfEmployee) {
        this.ageOfEmployee = ageOfEmployee;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGenderKey() {
        return genderKey;
    }

    public void setGenderKey(String genderKey) {
        this.genderKey = genderKey;
    }

    public String getMaritalStatusKey() {
        return maritalStatusKey;
    }

    public void setMaritalStatusKey(String maritalStatusKey) {
        this.maritalStatusKey = maritalStatusKey;
    }

    public int getNoCh() {
        return noCh;
    }

    public void setNoCh(int noCh) {
        this.noCh = noCh;
    }

    public float getPayment() {
        return payment;
    }

    public void setPayment(float payment) {
        this.payment = payment;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public float getGradeChangePer() {
        return gradeChangePer;
    }

    public void setGradeChangePer(float gradeChangePer) {
        this.gradeChangePer = gradeChangePer;
    }

    public float getPaymentChangePer() {
        return paymentChangePer;
    }

    public void setPaymentChangePer(float paymentChangePer) {
        this.paymentChangePer = paymentChangePer;
    }

    public String getOrganizationUnit() {
        return organizationUnit;
    }

    public void setOrganizationUnit(String organizationUnit) {
        this.organizationUnit = organizationUnit;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public float getYearOfWork() {
        return yearOfWork;
    }

    public void setYearOfWork(float yearOfWork) {
        this.yearOfWork = yearOfWork;
    }

    public Date getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(Date terminationDate) {
        this.terminationDate = terminationDate;
    }

    public float getYearOfCurrentPosition() {
        return yearOfCurrentPosition;
    }

    public void setYearOfCurrentPosition(float yearOfCurrentPosition) {
        this.yearOfCurrentPosition = yearOfCurrentPosition;
    }

    @Override
    public String toString() {
        return "EmployeeVO{" +
                "perNumber='" + perNumber + '\'' +
                ", termination=" + termination +
                ", importTime=" + importTime +
                ", locChangeStatus=" + locChangeStatus +
                ", address='" + address + '\'' +
                ", distance=" + distance +
                ", institution='" + institution + '\'' +
                ", yearOfGraduation=" + yearOfGraduation +
                ", certificate='" + certificate + '\'' +
                ", starLevel='" + starLevel + '\'' +
                ", locationOfUniversity='" + locationOfUniversity + '\'' +
                ", ageOfEmployee=" + ageOfEmployee +
                ", birthDate=" + birthDate +
                ", genderKey='" + genderKey + '\'' +
                ", maritalStatusKey='" + maritalStatusKey + '\'' +
                ", noCh=" + noCh +
                ", payment=" + payment +
                ", grade=" + grade +
                ", gradeChangePer=" + gradeChangePer +
                ", paymentChangePer=" + paymentChangePer +
                ", organizationUnit='" + organizationUnit + '\'' +
                ", position='" + position + '\'' +
                ", yearOfWork=" + yearOfWork +
                ", terminationDate=" + terminationDate +
                ", yearOfCurrentPosition=" + yearOfCurrentPosition +
                '}';
    }
}


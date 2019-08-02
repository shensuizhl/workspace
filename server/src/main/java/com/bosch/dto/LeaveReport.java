package com.bosch.dto;

import java.sql.Time;
import java.util.Date;

/**
 * @program: demo
 * @description: DTO for LEAVE_REPORT
 * @author: wjy
 * @create: 2019-06-18 17:36
 */

public class LeaveReport {

    int leaveReportId;
    int userId;
    boolean termination;
    Date importTime;
    String perNumber;
    Date startDate;
    Date endDate;
    Time startTime;
    Time endTime;
    int attendanceOfAbsenceType;
    double hours;
    double totalAbsHours;
    double totalAbsDays;

    public int getLeaveReportId() {
        return leaveReportId;
    }

    public void setLeaveReportId(int leaveReportId) {
        this.leaveReportId = leaveReportId;
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

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public int getAttendanceOfAbsenceType() {
        return attendanceOfAbsenceType;
    }

    public void setAttendanceOfAbsenceType(int attendanceOfAbsenceType) {
        this.attendanceOfAbsenceType = attendanceOfAbsenceType;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public double getTotalAbsHours() {
        return totalAbsHours;
    }

    public void setTotalAbsHours(double totalAbsHours) {
        this.totalAbsHours = totalAbsHours;
    }

    public double getTotalAbsDays() {
        return totalAbsDays;
    }

    public void setTotalAbsDays(double totalAbsDays) {
        this.totalAbsDays = totalAbsDays;
    }

    @Override
    public String toString() {
        return "LeaveReport{" +
                "leaveReportId=" + leaveReportId +
                ", userId=" + userId +
                ", termination=" + termination +
                ", importTime=" + importTime +
                ", perNumber='" + perNumber + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", attendanceOfAbsenceType=" + attendanceOfAbsenceType +
                ", hours=" + hours +
                ", totalAbsHours=" + totalAbsHours +
                ", totalAbsDays=" + totalAbsDays +
                '}';
    }
}

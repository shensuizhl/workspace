package com.bosch.dto;

import java.util.Date;

/**
 * @program: demo
 * @description: DTO for ACTION_POSITION
 * @author: wjy
 * @create: 2019-06-18 17:13
 */

public class ActionPosition {
    private int actionId;
    private int userId;
    private boolean termination;
    private String importTime;
    private String perNumber;
    private String organizationUnit;
    private Date startDate;
    private Date endDate;
    private String actionType;
    private String reasonForAction;
    private Date last;
    private Date entry;
    private Date startDate1;
    private Date endDate1;
    private String position;

    public int getActionId() {
        return actionId;
    }

    public void setActionId(int actionId) {
        this.actionId = actionId;
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

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getReasonForAction() {
        return reasonForAction;
    }

    public void setReasonForAction(String reasonForAction) {
        this.reasonForAction = reasonForAction;
    }

    public Date getLast() {
        return last;
    }

    public void setLast(Date last) {
        this.last = last;
    }

    public Date getEntry() {
        return entry;
    }

    public void setEntry(Date entry) {
        this.entry = entry;
    }

    public Date getStartDate1() {
        return startDate1;
    }

    public void setStartDate1(Date startDate1) {
        this.startDate1 = startDate1;
    }

    public Date getEndDate1() {
        return endDate1;
    }

    public void setEndDate1(Date endDate1) {
        this.endDate1 = endDate1;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "ActionPosition{" +
                "actionId=" + actionId +
                ", userId=" + userId +
                ", termination=" + termination +
                ", importTime='" + importTime + '\'' +
                ", perNumber='" + perNumber + '\'' +
                ", organizationUnit='" + organizationUnit + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", actionType='" + actionType + '\'' +
                ", reasonForAction='" + reasonForAction + '\'' +
                ", last=" + last +
                ", entry=" + entry +
                ", startDate1=" + startDate1 +
                ", endDate1=" + endDate1 +
                ", position='" + position + '\'' +
                '}';
    }

}

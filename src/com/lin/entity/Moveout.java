package com.lin.entity;

public class Moveout {
    private Integer id;
    private Integer employeeId;
    public String employeeName;
    private Integer groupId;
    public String groupName;
    private String reason;
    private String createDate;

    public Moveout(Integer id, String employeeName, String groupName, String reason, String createDate) {
        this.id = id;
        this.employeeName = employeeName;
        this.groupName = groupName;
        this.reason = reason;
        this.createDate = createDate;
    }

    public Moveout(Integer employeeId, Integer groupId, String reason) {
        this.employeeId = employeeId;
        this.groupId = groupId;
        this.reason = reason;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}

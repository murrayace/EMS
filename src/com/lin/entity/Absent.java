package com.lin.entity;

public class Absent {
    private Integer id;
    private Integer branchId;
    private String branchName;
    private Integer groupId;
    private String groupName;
    private Integer employeeId;
    private String employeeName;
    private Integer branchAdminId;
    private String branchAdminName;
    private String createDate;
    private String reason;

    public Absent(Integer id) {
        this.id = id;
    }

    public Absent(Integer id, String branchName, String groupName, String employeeName, String branchAdminName, String createDate, String reason) {
        this.id = id;
        this.branchName = branchName;
        this.groupName = groupName;
        this.employeeName = employeeName;
        this.branchAdminName = branchAdminName;
        this.createDate = createDate;
        this.reason = reason;
    }

    public Absent(Integer branchId, Integer groupId, Integer employeeId, Integer branchAdminId, String createDate, String reason) {
        this.branchId = branchId;
        this.groupId = groupId;
        this.employeeId = employeeId;
        this.branchAdminId = branchAdminId;
        this.createDate = createDate;
        this.reason = reason;
    }

    public String getBranchAdminName() {
        return branchAdminName;
    }

    public void setBranchAdminName(String branchAdminName) {
        this.branchAdminName = branchAdminName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getBranchAdminId() {
        return branchAdminId;
    }

    public void setBranchAdminId(Integer branchAdminId) {
        this.branchAdminId = branchAdminId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}

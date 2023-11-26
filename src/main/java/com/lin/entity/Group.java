package com.lin.entity;

public class Group {
    private Integer id;
    private Integer branchId;
    private String branchName;
    private String name;
    private Integer type;
    private Integer available;
    private String telephone;

    public Group(Integer id, String name, String telephone) {
        this.id = id;
        this.name = name;
        this.telephone = telephone;
    }

    public Group(Integer branchId, String name, Integer type, Integer available, String telephone) {
        this.branchId = branchId;
        this.name = name;
        this.type = type;
        this.available = available;
        this.telephone = telephone;
    }

    public Group(Integer id, String branchName, String name, Integer type, Integer available, String telephone) {
        this.id = id;
        this.branchName = branchName;
        this.name = name;
        this.type = type;
        this.available = available;
        this.telephone = telephone;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Group(Integer id) {
        this.id = id;
    }

    public Group(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}

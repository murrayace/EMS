package com.lin.entity;

public class Branch {
    private Integer id;
    private String name;
    private String introduction;
    private Integer adminId;
    private String adminName;

    public Branch(Integer id, String name, String introduction, Integer adminId) {
        this.id = id;
        this.name = name;
        this.introduction = introduction;
        this.adminId = adminId;
    }

    public Branch(String name, String introduction, Integer adminId) {
        this.name = name;
        this.introduction = introduction;
        this.adminId = adminId;
    }

    public Branch(Integer id, String name, String introduction, Integer adminId, String adminName) {
        this.id = id;
        this.name = name;
        this.introduction = introduction;
        this.adminId = adminId;
        this.adminName = adminName;
    }

    public Branch(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Branch(int id, String name, String introduction) {
        this.id=id;
        this.name=name;
        this.introduction=introduction;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
}

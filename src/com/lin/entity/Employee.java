package com.lin.entity;

public class Employee {
    private Integer id;
    private String number;
    private String name;
    private String gender;
    private Integer groupId;
    private String groupName;
    private String state;
    private String createDate;

    public Employee(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee(Integer id, String number, String name, String gender, Integer groupId) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.gender = gender;
        this.groupId = groupId;
    }

    public Employee(String number, String name, String gender, Integer groupId) {
        this.number = number;
        this.name = name;
        this.gender = gender;
        this.groupId = groupId;
    }

    public Employee(Integer id, String number, String name, String gender, Integer groupId, String groupName, String state, String createDate) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.gender = gender;
        this.groupId = groupId;
        this.groupName = groupName;
        this.state = state;
        this.createDate = createDate;
    }

    public Employee(Integer id, String number, String name, String gender, Integer groupId, String groupName, String state) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.gender = gender;
        this.groupId = groupId;
        this.groupName = groupName;
        this.state = state;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}

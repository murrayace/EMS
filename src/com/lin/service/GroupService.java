package com.lin.service;

import com.lin.entity.Group;

import java.util.List;

public interface GroupService {
    public List<Group> availableList();
    public List<Group> list();
    public List<Group> search(String key, String value);
    public void save(Group group);
    public void update(Group group);
    public void delete(Integer id);
    public List<Group> findByBranchId(Integer branchId);
}

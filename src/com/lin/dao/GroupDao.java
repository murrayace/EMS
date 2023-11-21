package com.lin.dao;

import com.lin.entity.Group;

import java.util.List;

public interface GroupDao {
    public List<Group> list();
    public List<Group> search(String key, String value);
    public List<Group> availableList();
    public Integer subAvailable(Integer id);
    public Integer addAvailable(Integer id);
    public List<Integer> findGroupIdByBranchId(Integer id);
    public Integer availableId();
    public Integer deleteById(Integer id);
    public Integer save(Group group);
    public Integer update(Group group);
    public List<Group> findByBranchId(Integer id);

}

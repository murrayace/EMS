package com.lin.dao;

import com.lin.entity.Group;

import java.util.List;

public interface GroupDao {
    public List<Group> list();
    public List<Group> search(String key, String value);
    public List<Group> availableList();//有空位的分公司名單
    public Integer subAvailable(Integer id);//減少可增加人數
    public Integer addAvailable(Integer id);//增加可增加人數
    public List<Integer> findGroupIdByBranchId(Integer id);
    public Integer availableId();//有空位的分公司ID
    public Integer deleteById(Integer id);
    public Integer save(Group group);
    public Integer update(Group group);
    public List<Group> findByBranchId(Integer id);

}

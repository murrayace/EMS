package com.lin.dao;

import com.lin.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    public List<Employee> list();
    public List<Employee> search(String key, String value);
    public Integer save(Employee employee);
    public Integer update(Employee employee);
    public Integer delete(Integer id);
    public List<Integer> findEmployeeIdByGroupId(Integer id);
    public Integer updateGroup(Integer employeeId, Integer groupId);//更新員工所在小組
    public List<Employee> moveoutlist();
    public List<Employee> searchForMoveout(String key, String value);
    public Integer updateStateById(Integer id);//變更在職狀態
    public List<Employee> findByGroupId(Integer id);
}

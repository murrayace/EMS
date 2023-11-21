package com.lin.service;
import com.lin.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> list();
    public List<Employee> search(String key, String value);
    public void save(Employee employee);
    public void update(Employee employee,Integer oldGroupId);
    public void delete(Integer id,Integer groupId);
    public List<Employee> moveoutList();
    public List<Employee> searchForMoveout(String key, String value);
    public List<Employee> findByGroupId(Integer groupId);
}

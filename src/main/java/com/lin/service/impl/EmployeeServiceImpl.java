package com.lin.service.impl;

import com.lin.dao.GroupDao;
import com.lin.dao.EmployeeDao;
import com.lin.dao.impl.GroupDaoImpl;
import com.lin.dao.impl.EmployeeDaoImpl;
import com.lin.entity.Employee;
import com.lin.service.EmployeeService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao = new EmployeeDaoImpl();
    private GroupDao groupDao = new GroupDaoImpl();

    @Override
    public List<Employee> list() {
        return this.employeeDao.list();
    }

    @Override
    public List<Employee> search(String key, String value) {
        if (value.equals(""))return this.employeeDao.list();
        return this.employeeDao.search(key,value);
    }

    @Override
    public void save(Employee employee) {
        employee.setState("在職");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        employee.setCreateDate(simpleDateFormat.format(date));
        Integer save = this.employeeDao.save(employee);
        Integer sub = this.groupDao.subAvailable(employee.getGroupId());
        if (save != 1 || sub !=1)throw new RuntimeException("添加員工信息失敗");
    }

    @Override
    public void update(Employee employee,Integer oldGroupId) {
        Integer update = this.employeeDao.update(employee);
        Integer group1 = this.groupDao.addAvailable(oldGroupId);
        Integer group2 = this.groupDao.subAvailable(employee.getGroupId());
        if (update != 1 || group1 != 1 || group2 != 1 ) throw new RuntimeException("更新員工信息失敗");
    }

    @Override
    public void delete(Integer id, Integer groupId) {
        Integer delete = this.employeeDao.delete(id);
        Integer available = this.groupDao.addAvailable(groupId);
        if (delete != 1 || available != 1) throw new RuntimeException("刪除員工信息失敗");
    }

    @Override
    public List<Employee> moveoutList() {
        return this.employeeDao.moveoutlist();
    }

    @Override
    public List<Employee> searchForMoveout(String key, String value) {
        if (value.equals(""))return this.employeeDao.moveoutlist();
        return this.employeeDao.searchForMoveout(key, value);
    }

    @Override
    public List<Employee> findByGroupId(Integer groupId) {
        return this.employeeDao.findByGroupId(groupId);
    }
}

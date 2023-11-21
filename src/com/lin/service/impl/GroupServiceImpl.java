package com.lin.service.impl;

import com.lin.dao.GroupDao;
import com.lin.dao.EmployeeDao;
import com.lin.dao.impl.GroupDaoImpl;
import com.lin.dao.impl.EmployeeDaoImpl;
import com.lin.entity.Group;
import com.lin.service.GroupService;

import java.util.List;

public class GroupServiceImpl implements GroupService {

    private GroupDao groupDao = new GroupDaoImpl();
    private EmployeeDao employeeDao = new EmployeeDaoImpl();

    @Override
    public List<Group> availableList() {
        return this.groupDao.availableList();
    }

    @Override
    public List<Group> list() {
        return this.groupDao.list();
    }

    @Override
    public List<Group> search(String key, String value) {
        if (value.equals("")) return this.groupDao.list();
        return this.groupDao.search(key, value);
    }

    @Override
    public void save(Group group) {
        Integer save = this.groupDao.save(group);
        if (save != 1)throw new RuntimeException("添加分公司資訊失敗");
    }

    @Override
    public void update(Group group) {
        Integer update = this.groupDao.update(group);
        if (update != 1)throw new RuntimeException("更新分公司資訊失敗");
    }

    @Override
    public void delete(Integer id) {
        List<Integer> employeeIdList = this.employeeDao.findEmployeeIdByGroupId(id);
        for (Integer employeeId : employeeIdList){
            Integer availableId = this.groupDao.availableId();
            Integer updateGroup = this.employeeDao.updateGroup(employeeId,availableId);
            Integer subAvailable = this.groupDao.subAvailable(availableId);
            if (updateGroup !=1 || subAvailable !=1) throw new RuntimeException("員工更換分公司失敗");
        }
        Integer delete = this.groupDao.deleteById(id);
        if (delete != 1)throw new RuntimeException("刪除分公司資訊失敗");
    }

    @Override
    public List<Group> findByBranchId(Integer branchId) {
        return this.groupDao.findByBranchId(branchId);
    }
}

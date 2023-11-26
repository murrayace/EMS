package com.lin.service.impl;

import com.lin.dao.GroupDao;
import com.lin.dao.EmployeeDao;
import com.lin.dao.BranchDao;
import com.lin.dao.impl.GroupDaoImpl;
import com.lin.dao.impl.EmployeeDaoImpl;
import com.lin.dao.impl.BranchDaoImpl;
import com.lin.entity.Branch;
import com.lin.service.BranchService;

import java.util.List;

public class BranchServiceImpl implements BranchService {

    private BranchDao branchDao = new BranchDaoImpl();
    private GroupDao groupDao = new GroupDaoImpl();
    private EmployeeDao employeeDao = new EmployeeDaoImpl();

    @Override
    public List<Branch> list() {
        return this.branchDao.list();
    }

    @Override
    public List<Branch> search(String key, String value) {
        if (value.equals(""))return this.branchDao.list();
        return this.branchDao.search(key,value);
    }

    @Override
    public void save(Branch branch) {
        Integer save = this.branchDao.save(branch);
        if (save != 1) throw new RuntimeException("添加區域信息失敗");
    }

    @Override
    public void update(Branch branch) {
        Integer update = this.branchDao.update(branch);
        if (update !=1) throw new RuntimeException("更新區域信息失敗");
    }

    @Override
    public void delete(Integer id) {
        //員工換分公司
        List<Integer> groupIdList = this.groupDao.findGroupIdByBranchId(id);
        for (Integer groupId : groupIdList){
            List<Integer> employeeIdList = this.employeeDao.findEmployeeIdByGroupId(groupId);
            for (Integer employeeId : employeeIdList){
                Integer availableId = this.groupDao.availableId();
                Integer updateGroup = this.employeeDao.updateGroup(employeeId,availableId);
                Integer subAvailable = this.groupDao.subAvailable(availableId);
                if (updateGroup !=1 || subAvailable !=1) throw new RuntimeException("員工更換分公司失敗");
            }
        }
        //刪小組
        for(Integer groupId : groupIdList){
            Integer delete = this.groupDao.deleteById(groupId);
            if (delete !=1) throw new RuntimeException("小組刪除失敗");
        }
        //刪分公司
        Integer delete = this.branchDao.delete(id);
        if (delete !=1) throw new RuntimeException("分公司刪除失敗");
    }

    //帶入管區
}

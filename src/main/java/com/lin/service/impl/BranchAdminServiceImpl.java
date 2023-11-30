package com.lin.service.impl;

import com.lin.dao.BranchAdminDao;
import com.lin.dao.BranchDao;
import com.lin.dao.impl.BranchAdminDaoImpl;
import com.lin.dao.impl.BranchDaoImpl;
import com.lin.dto.BranchAdminDto;
import com.lin.entity.BranchAdmin;
import com.lin.entity.Branch;
import com.lin.service.BranchAdminService;

import java.util.List;

public class BranchAdminServiceImpl implements BranchAdminService {

    private BranchAdminDao branchAdminDao = new BranchAdminDaoImpl();
    private BranchDao branchDao = new BranchDaoImpl();

    @Override
    public List<BranchAdmin> list() {
        return this.branchAdminDao.list();
    }

    @Override
    public List<BranchAdmin> search(String key, String value) {
        if (value.equals(""))return this.branchAdminDao.list();
        return this.branchAdminDao.search(key,value);


    }

    @Override
    public void save(BranchAdmin branchAdmin) {
        Integer save = this.branchAdminDao.save(branchAdmin);
        if (save != 1) throw new RuntimeException("管理員信息添加失敗");
    }

    @Override
    public void update(BranchAdmin branchAdmin) {
        Integer update = this.branchAdminDao.update(branchAdmin);
        if (update != 1) throw new RuntimeException("管理員信息更新失敗");
    }

    @Override
    public void delete(Integer id) {
        List<Integer> branchIdList = this.branchDao.findBranchIdByBranchAdminId(id);
        for (Integer branchId : branchIdList){
            Integer availableId = this.branchAdminDao.availableId();
            Integer updateBranchAdmin = this.branchDao.updateBranchAdmin(branchId,availableId);
            if (updateBranchAdmin !=1) throw new RuntimeException("員工更換分公司失敗");
        }

        Integer delete = this.branchAdminDao.deleteById(id);
        if (delete != 1) throw new RuntimeException("管理員信息刪除失敗");
    }

    @Override
    public BranchAdminDto login(String username, String password) {
        BranchAdmin branchAdmin = this.branchAdminDao.findByUserName(username);
        BranchAdminDto branchAdminDto = new BranchAdminDto();
        if (branchAdmin == null){
            branchAdminDto.setCode(-1);//用戶名不存在
        }else {
            if (!branchAdmin.getPassword().equals(password)){
                branchAdminDto.setCode(-2);//密碼錯誤
            }else {
                branchAdminDto.setCode(0);//登入成功
                branchAdminDto.setBranchAdmin(branchAdmin);
                //搜索管理的區域
                List<Branch> managedBranches = branchAdminDao.findBranchesByAdminId(branchAdmin.getId());
                branchAdminDto.setManagedBranches(managedBranches);
            }
        }
        return branchAdminDto;
    }
}

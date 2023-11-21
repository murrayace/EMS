package com.lin.dao;

import com.lin.entity.BranchAdmin;
import com.lin.entity.Branch;

import java.util.List;

public interface BranchAdminDao {
    public List<BranchAdmin> list();
    public List<BranchAdmin> search(String key, String value);
    public Integer save(BranchAdmin branchAdmin);
    public Integer update(BranchAdmin branchAdmin);
    public Integer deleteById(Integer id);
    public BranchAdmin findByUserName(String username);
    public Integer availableId();
    public List<Branch> findBranchesByAdminId(Integer adminId);
}

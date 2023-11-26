package com.lin.dao;

import com.lin.entity.Branch;

import java.util.List;

public interface BranchDao {
    public List<Branch> list();
    public List<Branch> search(String key, String value);
    public Integer save(Branch branch);
    public Integer update(Branch branch);
    public Integer delete(Integer id);
    public List<Integer> findBranchIdByBranchAdminId(Integer id);
    public Integer updateBranchAdmin(Integer branchId, Integer adminId);
    public List<Branch> findBranchesByAdminId(Integer adminId);//新增

}

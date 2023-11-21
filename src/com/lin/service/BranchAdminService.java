package com.lin.service;

import com.lin.dto.BranchAdminDto;
import com.lin.entity.BranchAdmin;

import java.util.List;

public interface BranchAdminService {
    public List<BranchAdmin> list();
    public List<BranchAdmin> search(String key, String value);
    public void save(BranchAdmin branchAdmin);
    public void update(BranchAdmin branchAdmin);
    public void delete(Integer id);
    public BranchAdminDto login(String username, String password);
}

package com.lin.dto;
import com.lin.entity.BranchAdmin;
import com.lin.entity.Branch;

import java.util.List;

public class BranchAdminDto {
    private Integer code;
    private BranchAdmin branchAdmin;
    private List<Branch> managedBranches;//管理的區域

    //新增getter setter
    public List<Branch> getManagedBranches() {
        return managedBranches;
    }

    public void setManagedBranches(List<Branch> managedBranches) {
        this.managedBranches = managedBranches;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public BranchAdmin getBranchAdmin() {
        return branchAdmin;
    }

    public void setBranchAdmin(BranchAdmin branchAdmin) {
        this.branchAdmin = branchAdmin;
    }
}

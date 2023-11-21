package com.lin.service;

import com.lin.entity.Branch;

import java.util.List;

public interface BranchService {
    public List<Branch> list();
    public List<Branch> search(String key, String value);
    public void save(Branch branch);
    public void update(Branch branch);
    public void delete(Integer id);

}

package com.lin.dao;

import com.lin.entity.SystemAdmin;

public interface SystemAdminDao {
    public SystemAdmin findByUsername(String username);
}

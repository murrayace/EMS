package com.lin.service;

import com.lin.dto.SystemAdminDto;

public interface SystemAdminService {
    public SystemAdminDto login(String username,String password);
}

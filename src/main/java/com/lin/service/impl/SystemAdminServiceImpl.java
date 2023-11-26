package com.lin.service.impl;

import com.lin.dao.SystemAdminDao;
import com.lin.dao.impl.SystemAdminDaoImpl;
import com.lin.dto.SystemAdminDto;
import com.lin.entity.SystemAdmin;
import com.lin.service.SystemAdminService;

public class SystemAdminServiceImpl implements SystemAdminService {

    private SystemAdminDao systemAdminDao = new SystemAdminDaoImpl();

    @Override
    public SystemAdminDto login(String username, String password) {

        SystemAdmin systemAdmin = this.systemAdminDao.findByUsername(username);
        SystemAdminDto systemAdminDto = new SystemAdminDto();
        if (systemAdmin == null){
            systemAdminDto.setCode(-1);//用戶名不存在
        }else {
            if (!systemAdmin.getPassword().equals(password)){
                systemAdminDto.setCode(-2);//密碼錯誤
            }else {
                systemAdminDto.setCode(0);//登入成功
                systemAdminDto.setSystemAdmin(systemAdmin);
            }
        }
        return systemAdminDto;
    }
}

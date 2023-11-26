package com.lin.service.impl;
import com.lin.dao.AbsentDao;
import com.lin.dao.impl.AbsentDaoImpl;
import com.lin.entity.Absent;
import com.lin.service.AbsentService;

import java.util.List;

public class AbsentServiceImpl implements AbsentService {

    private AbsentDao absentDao = new AbsentDaoImpl();

    @Override
    public void save(Absent absent) {
        Integer save = this.absentDao.save(absent);
        if (save !=1) throw new RuntimeException("添加缺勤紀錄失敗");
    }

    @Override
    public List<Absent> list() {
        return this.absentDao.list();
    }

    @Override
    public List<Absent> search(String key, String value) {
        if (value.equals(""))return this.absentDao.list();
        return this.absentDao.search(key, value);
    }

    //刪除
    @Override
    public void delete(Integer id) {
        Integer delete = this.absentDao.delete(id);
        if (delete != 1) throw new RuntimeException("刪除缺勤信息失敗");
    }
}

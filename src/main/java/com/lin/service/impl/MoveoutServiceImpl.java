package com.lin.service.impl;

import com.lin.dao.GroupDao;
import com.lin.dao.EmployeeDao;
import com.lin.dao.MoveoutDao;
import com.lin.dao.impl.GroupDaoImpl;
import com.lin.dao.impl.EmployeeDaoImpl;
import com.lin.dao.impl.MoveoutDaoImpl;
import com.lin.entity.Moveout;
import com.lin.service.MoveoutService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MoveoutServiceImpl implements MoveoutService {

    private MoveoutDao moveoutDao = new MoveoutDaoImpl();
    private EmployeeDao employeeDao = new EmployeeDaoImpl();
    private GroupDao groupDao = new GroupDaoImpl();

    @Override
    public void save(Moveout moveout) {
        Integer updateStateById = this.employeeDao.updateStateById(moveout.getEmployeeId());
        Integer addAvailable = this.groupDao.addAvailable(moveout.getGroupId());
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        moveout.setCreateDate(simpleDateFormat.format(date));
        Integer save = this.moveoutDao.save(moveout);
        if (save !=1 || updateStateById !=1 || addAvailable !=1) throw new RuntimeException("離退員工失敗");

    }

    @Override
    public List<Moveout> list() {
        return this.moveoutDao.list();
    }

    @Override
    public List<Moveout> search(String key, String value) {
        if (value.equals(""))return this.moveoutDao.list();
        return this.moveoutDao.search(key, value);
    }
}

package com.lin.dao;
import com.lin.entity.Absent;

import java.util.List;

public interface AbsentDao {
    public Integer save(Absent absent);
    public List<Absent> list();
    public List<Absent> search(String key, String value);
    public Integer delete(Integer id);//刪除紀錄
}

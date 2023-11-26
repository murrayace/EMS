package com.lin.service;

import com.lin.entity.Absent;

import java.util.List;

public interface AbsentService {
    public void save(Absent absent);
    public List<Absent> list();
    public List<Absent> search(String key, String value);
    public void delete(Integer id);//刪除
}

package com.lin.dao.impl;

import com.lin.dao.MoveoutDao;
import com.lin.entity.Moveout;
import com.lin.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MoveoutDaoImpl implements MoveoutDao {
    @Override
    public Integer save(Moveout moveout) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "insert into moveout(employee_id,group_id,reason,create_date) values (?,?,?,?)";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,moveout.getEmployeeId());
            statement.setInt(2,moveout.getGroupId());
            statement.setString(3,moveout.getReason());
            statement.setString(4,moveout.getCreateDate());
            result = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(connection, statement, null);
        }
        return result;
    }

    @Override
    public List<Moveout> list() {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select m.id,e.name,b.name,m.reason,m.create_date" +
                " from moveout m, employee e,`group` b where m.employee_id = e.id and m.group_id=b.id";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Moveout> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String employeeName = resultSet.getString(2);
                String groupName = resultSet.getString(3);
                String reason = resultSet.getString(4);
                String createDate = resultSet.getString(5);
                list.add(new Moveout(id,employeeName,groupName,reason,createDate));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public List<Moveout> search(String key, String value) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select m.id,e.name,b.name,m.reason,m.create_date" +
                " from moveout m, employee e,`group` b where m.employee_id = e.id and m.group_id=b.id";
        String keyStatement = "";
        if (key.equals("employeeName")){
            keyStatement = " and e.name";
        }
        if (key.equals("groupName")){
            keyStatement = " and b.name";
        }
        sql = sql + keyStatement + " like '%"+value+"%'";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Moveout> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String employeeName = resultSet.getString(2);
                String groupName = resultSet.getString(3);
                String reason = resultSet.getString(4);
                String createDate = resultSet.getString(5);
                list.add(new Moveout(id,employeeName,groupName,reason,createDate));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;
    }
}

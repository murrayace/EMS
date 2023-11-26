package com.lin.dao.impl;

import com.lin.dao.AbsentDao;
import com.lin.entity.Absent;
import com.lin.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AbsentDaoImpl implements AbsentDao {
    @Override
    public Integer save(Absent absent) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "insert into absent(branch_id,group_id,employee_id,branch_admin_id,create_date,reason) values (?,?,?,?,?,?)";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,absent.getBranchId());
            statement.setInt(2,absent.getGroupId());
            statement.setInt(3,absent.getEmployeeId());
            statement.setInt(4,absent.getBranchAdminId());
            statement.setString(5,absent.getCreateDate());
            statement.setString(6,absent.getReason());
            result = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(connection, statement, null);
        }
        return result;

    }

    @Override
    public List<Absent> list() {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select a.id,r.name,g.name,e.name,a.reason,ba.name,a.create_date from " +
                "`group` g,employee e,branch r,absent a,branch_admin ba where" +
                " g.id = a.group_id and e.id = a.employee_id and r.id = a.branch_id and ba.id = a.branch_admin_id";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Absent> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String branchName = resultSet.getString(2);
                String groupName = resultSet.getString(3);
                String employeeName = resultSet.getString(4);
                String reason = resultSet.getString(5);
                String branchAdminName = resultSet.getString(6);
                String createDate = resultSet.getString(7);
                list.add(new Absent(id,branchName,groupName,employeeName,branchAdminName,createDate,reason));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public List<Absent> search(String key, String value) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select a.id,r.name,g.name,e.name,a.reason,ba.name,a.create_date from" +
                " `group` g,employee e,branch r,absent a,branch_admin ba where g.id = a.group_id and" +
                " e.id = a.employee_id and r.id = a.branch_id and ba.id = a.branch_admin_id";
        String keyStatement = "";
        if (key.equals("branchName")){
            keyStatement = " and r.name";
        }
        if (key.equals("groupName")){
            keyStatement = " and g.name";
        }
        sql = sql + keyStatement + " like '%"+value+"%'";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Absent> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String branchName = resultSet.getString(2);
                String groupName = resultSet.getString(3);
                String employeeName = resultSet.getString(4);
                String reason = resultSet.getString(5);
                String branchAdminName = resultSet.getString(6);
                String createDate = resultSet.getString(7);
                list.add(new Absent(id,branchName,groupName,employeeName,branchAdminName,createDate,reason));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;
    }

    //刪除
    @Override
    public Integer delete(Integer id) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "delete from absent where id="+id;
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            result = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(connection, statement, null);
        }
        return result;
    }
}

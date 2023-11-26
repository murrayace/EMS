package com.lin.dao.impl;

import com.lin.dao.BranchAdminDao;
import com.lin.entity.Branch;
import com.lin.entity.BranchAdmin;
import com.lin.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BranchAdminDaoImpl implements BranchAdminDao {
    @Override
    public List<BranchAdmin> list() {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from branch_admin";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<BranchAdmin> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String username = resultSet.getString(2);
                String password = resultSet.getString(3);
                String name = resultSet.getString(4);
                String gender = resultSet.getString(5);
                String telephone = resultSet.getString(6);
                list.add(new BranchAdmin(id, username, password, name, gender, telephone));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public List<BranchAdmin> search(String key, String value) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from branch_admin where " + key + " like '%" + value + "%'";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<BranchAdmin> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String username = resultSet.getString(2);
                String password = resultSet.getString(3);
                String name = resultSet.getString(4);
                String gender = resultSet.getString(5);
                String telephone = resultSet.getString(6);
                list.add(new BranchAdmin(id, username, password, name, gender, telephone));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public Integer save(BranchAdmin branchAdmin) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "insert into branch_admin(username,password,name,gender,telephone) values(?,?,?,?,?)";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, branchAdmin.getUsername());
            statement.setString(2, branchAdmin.getPassword());
            statement.setString(3, branchAdmin.getName());
            statement.setString(4, branchAdmin.getGender());
            statement.setString(5, branchAdmin.getTelephone());
            result = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, null);
        }
        return result;
    }

    @Override
    public Integer update(BranchAdmin branchAdmin) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "update branch_admin set username=?,password=?,name=?,gender=?,telephone=? where id=?";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, branchAdmin.getUsername());
            statement.setString(2, branchAdmin.getPassword());
            statement.setString(3, branchAdmin.getName());
            statement.setString(4, branchAdmin.getGender());
            statement.setString(5, branchAdmin.getTelephone());
            statement.setInt(6, branchAdmin.getId());
            result = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, null);
        }
        return result;
    }

    @Override
    public Integer deleteById(Integer id) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "delete from branch_admin where id=" + id;
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            result = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, null);
        }
        return result;
    }

    @Override
    public BranchAdmin findByUserName(String username) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from branch_admin where username =?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        BranchAdmin branchAdmin = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                username = resultSet.getString(2);
                String password = resultSet.getString(3);
                String name = resultSet.getString(4);
                branchAdmin = new BranchAdmin(id, username, password, name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return branchAdmin;
    }

    @Override
    public Integer availableId() {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select id from branch_admin where branch_admin.id>0 limit 0,1";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                result = resultSet.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return result;

    }

    //新增
    @Override
    public List<Branch> findBranchesByAdminId(Integer adminId) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select id,name,introduction from branch where admin_id ="+adminId;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Branch> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String introduction = resultSet.getString(3);
                list.add(new Branch(id,name,introduction));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;
    }
}


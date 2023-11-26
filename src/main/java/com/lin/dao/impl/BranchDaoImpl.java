package com.lin.dao.impl;

import com.lin.dao.BranchDao;
import com.lin.entity.Branch;
import com.lin.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BranchDaoImpl implements BranchDao {
    @Override
    public List<Branch> list() {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select r.id,r.name,r.introduction,ba.name,ba.id" +
                " from branch_admin ba,branch r where r.admin_id = ba.id ";
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
                String adminName = resultSet.getString(4);
                Integer adminId = resultSet.getInt(5);
                list.add(new Branch(id,name,introduction,adminId,adminName));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public List<Branch> search(String key, String value) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select r.id,r.name,r.introduction,ba.name,ba.id" +
                " from branch_admin ba,branch r where r.admin_id = ba.id and r."+key+" like '%"+value+"%'";
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
                String adminName = resultSet.getString(4);
                Integer adminId = resultSet.getInt(5);
                list.add(new Branch(id,name,introduction,adminId,adminName));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public Integer save(Branch branch) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "insert into branch(name,introduction,admin_id) values (?,?,?)";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, branch.getName());
            statement.setString(2, branch.getIntroduction());
            statement.setInt(3, branch.getAdminId());
            result = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(connection, statement, null);
        }
        return result;
    }

    @Override
    public Integer update(Branch branch) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "update branch set name=?,introduction=?,admin_id=? where id=?";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, branch.getName());
            statement.setString(2, branch.getIntroduction());
            statement.setInt(3, branch.getAdminId());
            statement.setInt(4, branch.getId());
            result = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(connection, statement, null);
        }
        return result;
    }

    @Override
    public Integer delete(Integer id) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "delete from branch where id="+id;
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

    @Override
    public List<Integer> findBranchIdByBranchAdminId(Integer id) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select id from branch where admin_id="+id;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Integer> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                list.add(resultSet.getInt(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public Integer updateBranchAdmin(Integer branchId, Integer adminId) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "update branch set admin_id=? where id=?";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,adminId);
            statement.setInt(2,branchId);
            result = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(connection, statement, null);
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


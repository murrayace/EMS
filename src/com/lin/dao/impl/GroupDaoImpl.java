package com.lin.dao.impl;

import com.lin.dao.GroupDao;
import com.lin.entity.Group;
import com.lin.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupDaoImpl implements GroupDao {
    @Override
    public List<Group> list() {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select b.id,r.name,b.name,b.type,b.available,b.telephone from `group` b, branch r where b.branch_id=r.id";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Group> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                Integer id = resultSet.getInt(1);
                String branchName = resultSet.getString(2);
                String name = resultSet.getString(3);
                Integer type = resultSet.getInt(4);
                Integer available = resultSet.getInt(5);
                String telephone = resultSet.getString(6);
                list.add(new Group(id,branchName,name,type,available,telephone));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public List<Group> search(String key, String value) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select b.id,r.name,b.name,b.type,b.available,b.telephone from `group` b, branch r " +
                "where b.branch_id=r.id and b."+key+" like '%"+value+"%'";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Group> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                Integer id = resultSet.getInt(1);
                String branchName = resultSet.getString(2);
                String name = resultSet.getString(3);
                Integer type = resultSet.getInt(4);
                Integer available = resultSet.getInt(5);
                String telephone = resultSet.getString(6);
                list.add(new Group(id,branchName,name,type,available,telephone));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public List<Group> availableList() {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select id,name from `group` where available>0";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Group> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                Integer id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                list.add(new Group(id,name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public Integer subAvailable(Integer id) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "update `group` set available= available-1 where id="+id;
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
    public Integer addAvailable(Integer id) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "update `group` set available= available+1 where id="+id;
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
    public List<Integer> findGroupIdByBranchId(Integer id) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select id from `group` where branch_id="+id;
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
    public Integer availableId() {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select id from `group` where available > 0 limit 0,1";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            if (resultSet.next()){
                result = resultSet.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return result;
    }

    @Override
    public Integer deleteById(Integer id) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "delete from `group` where id="+id;
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
    public Integer save(Group group) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "insert into `group`(branch_id,name,type,available,telephone) values (?,?,?,?,?)";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, group.getBranchId());
            statement.setString(2, group.getName());
            statement.setInt(3, group.getType());
            statement.setInt(4, group.getAvailable());
            statement.setString(5, group.getTelephone());
            result = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(connection, statement, null);
        }
        return result;
    }

    @Override
    public Integer update(Group group) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "update `group` set name=?,telephone=? where id=?";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, group.getName());
            statement.setString(2, group.getTelephone());
            statement.setInt(3, group.getId());
            result = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(connection, statement, null);
        }
        return result;
    }

    @Override
    public List<Group> findByBranchId(Integer id) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select id,name from `group` where branch_id="+id;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Group> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                list.add(new Group(id,name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;
    }
}

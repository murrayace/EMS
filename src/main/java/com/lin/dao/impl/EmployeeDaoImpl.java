package com.lin.dao.impl;

import com.lin.dao.EmployeeDao;
import com.lin.entity.Employee;
import com.lin.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public List<Employee> list() {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select e.id,e.number,e.name,e.gender,e.group_id,b.name,e.state,e.create_date" +
                " from employee e,`group` b where e.group_id = b.id";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Employee> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String number = resultSet.getString(2);
                String name = resultSet.getString(3);
                String gender = resultSet.getString(4);
                Integer groupId = resultSet.getInt(5);
                String groupName = resultSet.getString(6);
                String state = resultSet.getString(7);
                String createDate = resultSet.getString(8);
                list.add(new Employee(id,number,name,gender,groupId,groupName,state,createDate));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public List<Employee> search(String key, String value) {
        Connection connection = JDBCUtil.getConnection();
        String sql;
        //搜索分公司名稱 特殊處理
        if("groupName".equals(key)){
            sql="select e.id,e.number,e.name,e.gender,e.group_id,g.name,e.state,e.create_date" +
                " from employee e join `group` g on e.group_id = g.id where g.name like '%"+value+"%'";
        }else{
            sql="select e.id,e.number,e.name,e.gender,e.group_id,g.name,e.state,e.create_date" +
                " from employee e,`group` g where e.group_id = g.id and e."+key+" like '%"+value+"%'";
        }
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Employee> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String number = resultSet.getString(2);
                String name = resultSet.getString(3);
                String gender = resultSet.getString(4);
                Integer groupId = resultSet.getInt(5);
                String groupName = resultSet.getString(6);
                String state = resultSet.getString(7);
                String createDate = resultSet.getString(8);
                list.add(new Employee(id,number,name,gender,groupId,groupName,state,createDate));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public Integer save(Employee employee) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "insert into employee(number,name,gender,group_id,state,create_date) values (?,?,?,?,?,?)";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,employee.getNumber());
            statement.setString(2,employee.getName());
            statement.setString(3,employee.getGender());
            statement.setInt(4,employee.getGroupId());
            statement.setString(5,employee.getState());
            statement.setString(6,employee.getCreateDate());
            result = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(connection, statement, null);
        }
        return result;
    }

    @Override
    public Integer update(Employee employee) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "update employee set number=?,name=?,gender=?,group_id=? where id=?";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,employee.getNumber());
            statement.setString(2,employee.getName());
            statement.setString(3,employee.getGender());
            statement.setInt(4,employee.getGroupId());
            statement.setInt(5,employee.getId());
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
        String sql = "delete from employee where id="+id;
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
    public List<Integer> findEmployeeIdByGroupId(Integer id) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select id from employee where group_id="+id;
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
    public Integer updateGroup(Integer employeeId, Integer groupId) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "update employee set group_id=? where id=?";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,groupId);
            statement.setInt(2,employeeId);
            result = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(connection, statement, null);
        }
        return result;
    }

    @Override
    public List<Employee> moveoutlist() {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select e.id,e.number,e.name,e.gender,e.group_id,b.name,e.state from" +
                " employee e,`group` b where e.group_id = b.id and e.state = '在職'";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Employee> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String number = resultSet.getString(2);
                String name = resultSet.getString(3);
                String gender = resultSet.getString(4);
                Integer groupId = resultSet.getInt(5);
                String groupName = resultSet.getString(6);
                String state = resultSet.getString(7);
                list.add(new Employee(id,number,name,gender,groupId,groupName,state));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public List<Employee> searchForMoveout(String key, String value) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select e.id,e.number,e.name,e.gender,e.group_id,b.name,e.state from" +
                " employee e,`group` b where" +
                " e.group_id = b.id and e.state = '在職' and e."+key+" like '%" +value+ "%'";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Employee> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String number = resultSet.getString(2);
                String name = resultSet.getString(3);
                String gender = resultSet.getString(4);
                Integer groupId = resultSet.getInt(5);
                String groupName = resultSet.getString(6);
                String state = resultSet.getString(7);
                list.add(new Employee(id,number,name,gender,groupId,groupName,state));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;

    }

    @Override
    public Integer updateStateById(Integer id) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "update employee set state = '離退' where id= "+id;
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
    public List<Employee> findByGroupId(Integer id) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select id,name from employee where group_id="+id;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Employee> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                list.add(new Employee(id,name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;
    }
}

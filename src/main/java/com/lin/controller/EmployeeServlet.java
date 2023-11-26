package com.lin.controller;

import com.lin.entity.Employee;
import com.lin.service.GroupService;
import com.lin.service.EmployeeService;
import com.lin.service.impl.GroupServiceImpl;
import com.lin.service.impl.EmployeeServiceImpl;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/employee.action")
public class EmployeeServlet extends HttpServlet {

    private EmployeeService employeeService = new EmployeeServiceImpl();
    private GroupService groupService = new GroupServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        switch(method){
            case "list":
                req.setAttribute("list",this.employeeService.list());
                req.setAttribute("groupList",this.groupService.availableList());
                req.getRequestDispatcher("employeemanager.jsp").forward(req,resp);
                break;
            case "list2":
                req.setAttribute("list",this.employeeService.list());
                req.setAttribute("groupList",this.groupService.availableList());
                req.getRequestDispatcher("employeemanager2.jsp").forward(req,resp);
                break;
            case "search":
                String key = req.getParameter("key");
                String value = req.getParameter("value");
                req.setAttribute("list",this.employeeService.search(key,value));
                req.getRequestDispatcher("employeemanager.jsp").forward(req,resp);
                break;
            case "search2":
                key = req.getParameter("key");
                value = req.getParameter("value");
                req.setAttribute("list",this.employeeService.search(key,value));
                req.getRequestDispatcher("employeemanager2.jsp").forward(req,resp);
                break;
            case "save":
                String groupIdStr = req.getParameter("groupId");
                Integer groupId = Integer.parseInt(groupIdStr);
                String number = req.getParameter("number");
                String name = req.getParameter("name");
                String gender = req.getParameter("gender");
                this.employeeService.save(new Employee(number,name,gender,groupId));
                resp.sendRedirect("/employee.action?method=list");
                break;
            case "update":
                String idStr = req.getParameter("id");
                Integer id = Integer.parseInt(idStr);
                groupIdStr = req.getParameter("groupId");
                groupId = Integer.parseInt(groupIdStr);
                number = req.getParameter("number");
                name = req.getParameter("name");
                gender = req.getParameter("gender");
                String oldGroupIdStr = req.getParameter("oldGroupId");
                Integer oldGroupId = Integer.parseInt(oldGroupIdStr);
                this.employeeService.update(new Employee(id,number,name,gender,groupId),oldGroupId);
                resp.sendRedirect("/employee.action?method=list");
                break;
            case "delete":
                idStr = req.getParameter("id");
                id = Integer.parseInt(idStr);
                groupIdStr = req.getParameter("groupId");
                groupId = Integer.parseInt(groupIdStr);
                this.employeeService.delete(id,groupId);
                resp.sendRedirect("/employee.action?method=list");
                break;
            case "findByGroupId":
                groupIdStr = req.getParameter("groupId");
                groupId = Integer.parseInt(groupIdStr);
                List<Employee> employeeList = this.employeeService.findByGroupId(groupId);
                JSONArray jsonArray = JSONArray.fromObject(employeeList);
                resp.setContentType("text/json;charset=UTF-8");
                resp.getWriter().write(jsonArray.toString());
                break;
        }
    }
}

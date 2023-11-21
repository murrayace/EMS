package com.lin.controller;

import com.lin.entity.Group;
import com.lin.entity.Employee;
import com.lin.service.GroupService;
import com.lin.service.EmployeeService;
import com.lin.service.BranchService;
import com.lin.service.impl.GroupServiceImpl;
import com.lin.service.impl.EmployeeServiceImpl;
import com.lin.service.impl.BranchServiceImpl;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/group.action")
public class GroupServlet extends HttpServlet {

    private GroupService groupService = new GroupServiceImpl();
    private BranchService branchService = new BranchServiceImpl();
    private EmployeeService employeeService = new EmployeeServiceImpl();

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
                req.setAttribute("list",this.groupService.list());
                req.setAttribute("branchList",this.branchService.list());
                req.getRequestDispatcher("groupmanager.jsp").forward(req,resp);
                break;
            case "list2":
                req.setAttribute("list",this.groupService.list());
                req.setAttribute("branchList",this.branchService.list());
                req.getRequestDispatcher("groupmanager2.jsp").forward(req,resp);
                break;
            case "search":
                String key = req.getParameter("key");
                String value = req.getParameter("value");
                req.setAttribute("list",this.groupService.search(key,value));
                req.setAttribute("branchList",this.branchService.list());
                req.getRequestDispatcher("groupmanager.jsp").forward(req,resp);
                break;
            case "search2":
                key = req.getParameter("key");
                value = req.getParameter("value");
                req.setAttribute("list",this.groupService.search(key,value));
                req.setAttribute("branchList",this.branchService.list());
                req.getRequestDispatcher("groupmanager2.jsp").forward(req,resp);
                break;
            case "save":
                String branchIdStr = req.getParameter("branchId");
                Integer branchId = Integer.parseInt(branchIdStr);
                String name = req.getParameter("name");
                String typeStr = req.getParameter("type");
                Integer type = Integer.parseInt(typeStr);
                String telephone = req.getParameter("telephone");
                this.groupService.save(new Group(branchId,name,type,type,telephone));
                resp.sendRedirect("/group.action?method=list");
                break;
            case "update":
                String idStr = req.getParameter("id");
                Integer id = Integer.parseInt(idStr);
                name = req.getParameter("name");
                telephone = req.getParameter("telephone");
                this.groupService.update(new Group(id,name,telephone));
                resp.sendRedirect("/group.action?method=list");
                break;
            case "delete":
                idStr = req.getParameter("id");
                id = Integer.parseInt(idStr);
                this.groupService.delete(id);
                resp.sendRedirect("/group.action?method=list");
                break;
            case "findByBranchId":
                branchIdStr = req.getParameter("branchId");
                branchId = Integer.parseInt(branchIdStr);
                List<Group> groupList = this.groupService.findByBranchId(branchId);
                List<Employee> employeeList = this.employeeService.findByGroupId(groupList.get(0).getId());
                Map<String,List> map = new HashMap<>();
                map.put("groupList", groupList);
                map.put("employeeList",employeeList);
                JSONArray jsonArray = JSONArray.fromObject(map);
                resp.setContentType("text/json;charset=UTF-8");
                resp.getWriter().write(jsonArray.toString());
                break;
        }
    }
}

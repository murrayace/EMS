package com.lin.controller;

import com.lin.entity.*;
import com.lin.service.AbsentService;
import com.lin.service.BranchService;
import com.lin.service.GroupService;
import com.lin.service.EmployeeService;
import com.lin.service.impl.AbsentServiceImpl;
import com.lin.service.impl.BranchServiceImpl;
import com.lin.service.impl.GroupServiceImpl;
import com.lin.service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/absent.action")
public class AbsentServlet extends HttpServlet {

    private BranchService branchService = new BranchServiceImpl();
    private GroupService groupService = new GroupServiceImpl();
    private EmployeeService employeeService = new EmployeeServiceImpl();
    private AbsentService absentService = new AbsentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        switch(method){
            case "init":
                List<Branch> managedBranches = (List<Branch>) session.getAttribute("managedBranches");
                List<Group> groupList = this.groupService.findByBranchId(managedBranches.get(0).getId());
                List<Employee> employeeList = this.employeeService.findByGroupId(groupList.get(0).getId());
                req.setAttribute("branchList", managedBranches);
                req.setAttribute("groupList", groupList);
                req.setAttribute("employeeList",employeeList);
                req.getRequestDispatcher("absentregister.jsp").forward(req,resp);
                break;
            case "save":
                String branchIdStr = req.getParameter("branchId");
                Integer branchId = Integer.parseInt(branchIdStr);
                String groupIdStr = req.getParameter("groupId");
                Integer groupId = Integer.parseInt(groupIdStr);
                String employeeIdStr = req.getParameter("employeeId");
                Integer employeeId = Integer.parseInt(employeeIdStr);
                String reason = req.getParameter("reason");
                String date = req.getParameter("date");
                BranchAdmin branchAdmin = (BranchAdmin) session.getAttribute("branchAdmin");
                this.absentService.save(new Absent(branchId,groupId,employeeId,branchAdmin.getId(),date,reason));
                resp.sendRedirect("/absent.action?method=init");
                break;
            case "list"://刪除後跳轉
                req.setAttribute("list",this.absentService.list());
                req.getRequestDispatcher("absentdelete.jsp").forward(req,resp);
                break;
            case "list2":
                req.setAttribute("list",this.absentService.list());
                req.getRequestDispatcher("absentrecord.jsp").forward(req,resp);
                break;
            case "search":
                String key = req.getParameter("key");
                String value = req.getParameter("value");
                req.setAttribute("list",this.absentService.search(key,value));
                req.getRequestDispatcher("absentdelete.jsp").forward(req,resp);
                break;
            case "search2":
                key = req.getParameter("key");
                value = req.getParameter("value");
                req.setAttribute("list",this.absentService.search(key,value));
                req.getRequestDispatcher("absentrecord.jsp").forward(req,resp);
                break;
            case "delete"://刪除
                String idStr = req.getParameter("id");
                Integer id = Integer.parseInt(idStr);
                this.absentService.delete(id);
                resp.sendRedirect("/absent.action?method=list");
                break;
        }
    }
}

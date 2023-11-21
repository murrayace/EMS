package com.lin.controller;

import com.lin.entity.Branch;
import com.lin.service.BranchAdminService;
import com.lin.service.GroupService;
import com.lin.service.EmployeeService;
import com.lin.service.BranchService;
import com.lin.service.impl.BranchAdminServiceImpl;
import com.lin.service.impl.GroupServiceImpl;
import com.lin.service.impl.EmployeeServiceImpl;
import com.lin.service.impl.BranchServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/branch.action")
public class BranchServlet extends HttpServlet {

    private EmployeeService employeeService = new EmployeeServiceImpl();
    private GroupService groupService = new GroupServiceImpl();
    private BranchService branchService = new BranchServiceImpl();
    private BranchAdminService branchAdminService = new BranchAdminServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        switch (method){
            case "list":
                req.setAttribute("list",this.branchService.list());
                req.setAttribute("adminList",this.branchAdminService.list());
                req.getRequestDispatcher("branchmanager.jsp").forward(req,resp);
                break;
            case "list2":
                req.setAttribute("list",this.branchService.list());
                req.setAttribute("adminList",this.branchAdminService.list());
                req.getRequestDispatcher("branchmanager2.jsp").forward(req,resp);
                break;
            case "search":
                String key = req.getParameter("key");
                String value = req.getParameter("value");
                req.setAttribute("list",this.branchService.search(key,value));
                req.setAttribute("adminList",this.branchAdminService.list());
                req.getRequestDispatcher("branchmanager.jsp").forward(req,resp);
                break;
            case "search2":
                key = req.getParameter("key");
                value = req.getParameter("value");
                req.setAttribute("list",this.branchService.search(key,value));
                req.setAttribute("adminList",this.branchAdminService.list());
                req.getRequestDispatcher("branchmanager2.jsp").forward(req,resp);
                break;
            case "save":
                String name = req.getParameter("name");
                String introduction = req.getParameter("introduction");
                String adminIdStr = req.getParameter("adminId");
                Integer adminId = Integer.parseInt(adminIdStr);
                this.branchService.save(new Branch(name,introduction,adminId));
                resp.sendRedirect("/branch.action?method=list");
                break;
            case "update":
                String idStr = req.getParameter("id");
                Integer id = Integer.parseInt(idStr);
                name = req.getParameter("name");
                introduction = req.getParameter("introduction");
                adminIdStr = req.getParameter("adminId");
                adminId = Integer.parseInt(adminIdStr);
                this.branchService.update(new Branch(id,name,introduction,adminId));
                resp.sendRedirect("/branch.action?method=list");
                break;
            case "delete":
                idStr = req.getParameter("id");
                id = Integer.parseInt(idStr);
                this.branchService.delete(id);
                resp.sendRedirect("/branch.action?method=list");
                break;
        }
    }
}

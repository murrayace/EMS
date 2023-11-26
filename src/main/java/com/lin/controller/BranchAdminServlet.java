package com.lin.controller;


import com.lin.entity.BranchAdmin;
import com.lin.service.BranchAdminService;
import com.lin.service.impl.BranchAdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/branchAdmin.action")
public class BranchAdminServlet extends HttpServlet {

    private BranchAdminService branchAdminService = new BranchAdminServiceImpl();

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
                req.setAttribute("list", this.branchAdminService.list());
                req.getRequestDispatcher("adminmanager.jsp").forward(req,resp);
                break;
            case "list2":
                req.setAttribute("list", this.branchAdminService.list());
                req.getRequestDispatcher("adminmanager2.jsp").forward(req,resp);
                break;
            case "search":
                String key = req.getParameter("key");
                String value = req.getParameter("value");
                req.setAttribute("list",this.branchAdminService.search(key,value));
                req.getRequestDispatcher("adminmanager.jsp").forward(req,resp);
                break;
            case "search2":
                key = req.getParameter("key");
                value = req.getParameter("value");
                req.setAttribute("list",this.branchAdminService.search(key,value));
                req.getRequestDispatcher("adminmanager2.jsp").forward(req,resp);
                break;
            case "save":
                String username = req.getParameter("username");
                String password = req.getParameter("password");
                String name = req.getParameter("name");
                String gender = req.getParameter("gender");
                String telephone = req.getParameter("telephone");
                this.branchAdminService.save(new BranchAdmin(username,password,name,gender,telephone));
                resp.sendRedirect("/branchAdmin.action?method=list");
                break;
            case "update":
                String idStr = req.getParameter("id");
                Integer id = Integer.parseInt(idStr);
                username = req.getParameter("username");
                password = req.getParameter("password");
                name = req.getParameter("name");
                gender = req.getParameter("gender");
                telephone = req.getParameter("telephone");
                this.branchAdminService.update(new BranchAdmin(id,username,password,name,gender,telephone));
                resp.sendRedirect("/branchAdmin.action?method=list");
                break;
            case "delete":
                idStr = req.getParameter("id");
                id = Integer.parseInt(idStr);
                this.branchAdminService.delete(id);
                resp.sendRedirect("/branchAdmin.action?method=list");
                break;
        }
    }
}

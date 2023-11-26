package com.lin.controller;
import com.lin.dto.BranchAdminDto;
import com.lin.dto.SystemAdminDto;
import com.lin.entity.Branch;
import com.lin.service.BranchAdminService;
import com.lin.service.SystemAdminService;
import com.lin.service.impl.BranchAdminServiceImpl;
import com.lin.service.impl.SystemAdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {

    private SystemAdminService systemAdminService = new SystemAdminServiceImpl();
    private BranchAdminService branchAdminService = new BranchAdminServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        switch (method){
            case "login":
                String username = req.getParameter("username");
                String password = req.getParameter("password");
                String type = req.getParameter("type");
                switch (type){
                    case "systemAdmin":
                        SystemAdminDto systemAdminDto = this.systemAdminService.login(username, password);
                        switch (systemAdminDto.getCode()){
                            case -1:
                                req.setAttribute("usernameError","用戶名不存在");
                                req.getRequestDispatcher("login.jsp").forward(req, resp);
                                break;
                            case -2:
                                req.setAttribute("passwordError","密碼錯誤");
                                req.getRequestDispatcher("login.jsp").forward(req, resp);
                                break;
                            case 0:
                                //跳轉到登入成功介面
                                HttpSession session = req.getSession();
                                session.setAttribute("systemAdmin",systemAdminDto.getSystemAdmin());
                                session.setAttribute("username",username);//保存用戶名到session
                                resp.sendRedirect("/systemadmin.jsp");
                                break;
                        }
                        break;
                    case "branchAdmin":
                        BranchAdminDto branchAdminDto = this.branchAdminService.login(username,password);
                        switch (branchAdminDto.getCode()){
                            case -1:
                                req.setAttribute("usernameError","用戶名不存在");
                                req.getRequestDispatcher("login.jsp").forward(req, resp);
                                break;
                            case -2:
                                req.setAttribute("passwordError","密碼錯誤");
                                req.getRequestDispatcher("login.jsp").forward(req, resp);
                                break;
                            case 0:
                                //跳轉到登入成功介面
                                HttpSession session = req.getSession();
                                session.setAttribute("branchAdmin",branchAdminDto.getBranchAdmin());
                                session.setAttribute("username",username);//保存用戶名到session
                                System.out.println(username);
                                List<Branch> managedBranches = branchAdminDto.getManagedBranches();//新增
                                session.setAttribute("managedBranches", managedBranches);//新增
                                resp.sendRedirect("/branchadmin.jsp");
                                break;
                        }
                }
                break;
            case "logout":
                req.getSession().invalidate();
                resp.sendRedirect("/login.jsp");
                break;
        }
    }
}

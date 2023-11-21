package com.lin.controller;

import com.lin.entity.Moveout;
import com.lin.service.EmployeeService;
import com.lin.service.MoveoutService;
import com.lin.service.impl.EmployeeServiceImpl;
import com.lin.service.impl.MoveoutServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/moveout.action")
public class MoveoutServlet extends HttpServlet {

    private EmployeeService employeeService = new EmployeeServiceImpl();
    private MoveoutService moveoutService = new MoveoutServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        switch (method) {
            case "list":
                req.setAttribute("list", this.employeeService.moveoutList());
                req.getRequestDispatcher("moveoutregister.jsp").forward(req, resp);
                break;
            case "moveout":
                String employeeIdStr = req.getParameter("employeeId");
                Integer employeeId = Integer.parseInt(employeeIdStr);
                String groupIdStr = req.getParameter("groupId");
                Integer groupId = Integer.parseInt(groupIdStr);
                String reason = req.getParameter("reason");
                this.moveoutService.save(new Moveout(employeeId, groupId, reason));
                resp.sendRedirect("/moveout.action?method=list");
                break;
            case "search":
                String key = req.getParameter("key");
                String value = req.getParameter("value");
                req.setAttribute("list", this.employeeService.searchForMoveout(key, value));
                req.getRequestDispatcher("moveoutregister.jsp").forward(req, resp);
                break;
            case "record":
                req.setAttribute("list", this.moveoutService.list());
                req.getRequestDispatcher("moveoutrecord.jsp").forward(req, resp);
                break;
            case "recordSearch":
                key = req.getParameter("key");
                value = req.getParameter("value");
                req.setAttribute("list", this.moveoutService.search(key, value));
                req.getRequestDispatcher("moveoutrecord.jsp").forward(req, resp);
                break;
        }
    }
}
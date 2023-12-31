package com.lin.util;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter({"/branchadmin.jsp", "/systemadmin.jsp"})
public class LoginFilter implements Filter {

    public LoginFilter(){
    }
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        //判斷用戶是否登入 若登入則放行 走出請求的方法
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //獲取登入後保存在session中的用戶信息
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        System.out.println(username);
        //判斷是否為登入
        if (username == null){
            //若未登入 跳回登入頁面
            response.sendRedirect("/login.jsp");
        }else {
            //登入就放行 走處理該請求的方法
            chain.doFilter(req,resp);
        }
    }
}

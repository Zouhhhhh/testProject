package com.zouhhhhh.controller;


import com.zouhhhhh.bean.Admin;
import com.zouhhhhh.bean.Reader;
import com.zouhhhhh.service.LoginService;
import com.zouhhhhh.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author zouhao
 * @date 2022/4/17
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private LoginService loginService = new LoginServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        String type = req.getParameter("type");

        switch (type) {
            case "reader":
                Reader reader = loginService.getReader(userName, password);
                if (reader != null) {
                    HttpSession session = req.getSession();
                    session.setAttribute("reader", reader);
                    resp.sendRedirect("/book?page=1");
                } else {
                    resp.sendRedirect("/login.jsp");
                }
                break;
            case "admin":
                Admin admin = loginService.getAdmin(userName, password);
                break;
            default:
                break;
        }

    }
}

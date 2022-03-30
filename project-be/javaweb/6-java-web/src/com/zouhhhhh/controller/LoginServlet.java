package com.zouhhhhh.controller;

import com.zouhhhhh.entity.Reader;
import com.zouhhhhh.service.LoginService;
import com.zouhhhhh.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private LoginService loginService = new LoginServiceImpl();

    /**
     * 处理登录的业务逻辑
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Reader reader = loginService.login(username, password);
        if (reader != null) {
            HttpSession session = req.getSession();
            session.setAttribute("reader", reader);
        } else {
            resp.sendRedirect("login.jsp");
        }

    }
}

package com.zouhhhhh.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        System.out.println(name);

        if ("admin".equals(name) && "123".equals(pwd)) {
            HttpSession session = req.getSession();
            session.setAttribute("name", name);
        }
        System.out.println("账密错误、、、");

    }
}

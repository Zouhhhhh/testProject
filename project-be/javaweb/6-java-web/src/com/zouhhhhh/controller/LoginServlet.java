package com.zouhhhhh.controller;

import com.zouhhhhh.entity.Admin;
import com.zouhhhhh.entity.Book;
import com.zouhhhhh.entity.Reader;
import com.zouhhhhh.service.BookService;
import com.zouhhhhh.service.LoginService;
import com.zouhhhhh.service.impl.BookServiceImpl;
import com.zouhhhhh.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private LoginService loginService = new LoginServiceImpl();

    private BookService bookService = new BookServiceImpl();

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
        String type = req.getParameter("type");

        Object object = loginService.login(username, password, type);
        if (object != null) {
            HttpSession session = req.getSession();
            if (object instanceof Reader) {
                session.setAttribute("reader", object);
                //跳转到读者首页
                resp.sendRedirect("book?page=1");
            } else if (object instanceof Admin) {
                session.setAttribute("admin", object);
                //跳转到管理员首页
            }
        } else {
            resp.sendRedirect("login.jsp");
        }

    }
}

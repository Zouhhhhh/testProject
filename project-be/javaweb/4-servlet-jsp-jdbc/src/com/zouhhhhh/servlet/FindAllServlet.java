package com.zouhhhhh.servlet;

import com.zouhhhhh.bean.Student;
import com.zouhhhhh.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//第一种方式创建servlet
//需要在web.xml注册
public class FindAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentService service = new StudentService();
        List<Student> students = service.findAllStudent();
        req.setAttribute("students", students);
        //请求转发
        req.getRequestDispatcher("/list.jsp").forward(req, resp);
    }
}

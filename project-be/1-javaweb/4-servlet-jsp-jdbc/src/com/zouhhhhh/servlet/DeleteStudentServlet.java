package com.zouhhhhh.servlet;

import com.zouhhhhh.service.StudentService;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//第三种创建servlet方式
//需要在web.xml注册
public class DeleteStudentServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        String id = servletRequest.getParameter("id");
        StudentService studentService = new StudentService();
        studentService.deleteStudent(Integer.parseInt(id));
        ((HttpServletResponse) servletResponse).sendRedirect("find-all-student");
    }
}

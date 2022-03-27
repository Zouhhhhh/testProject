package com.zouhhhhh.servlet;

import com.zouhhhhh.bean.Student;
import com.zouhhhhh.service.StudentService;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

//第二种方式实现servlet
//也需要在web.xml注册
public class AddStudentServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        String name = servletRequest.getParameter("name");
        String score = servletRequest.getParameter("score");

        StudentService service = new StudentService();
        service.addStudent(new Student(name, score, new Date()));
        ((HttpServletResponse) servletResponse).sendRedirect("find-all-student");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}

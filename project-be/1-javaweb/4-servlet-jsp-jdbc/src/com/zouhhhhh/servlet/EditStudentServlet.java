package com.zouhhhhh.servlet;

import com.zouhhhhh.bean.Student;
import com.zouhhhhh.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/edit-student")
public class EditStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        StudentService studentService = new StudentService();
        Student student = studentService.findStudentById(id);
        req.setAttribute("student", student);
        req.getRequestDispatcher("edit.jsp").forward(req, resp);
    }
}

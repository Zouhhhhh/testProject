package com.zouhhhhh.servlet;

import com.zouhhhhh.bean.Student;
import com.zouhhhhh.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

@WebServlet("/update-student")
public class UpdateStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String score = req.getParameter("score");
        StudentService studentService = new StudentService();
        studentService.updateStudent(new Student(Integer.parseInt(id), name, score, new Date()));
        resp.sendRedirect("find-all-student");

    }
}

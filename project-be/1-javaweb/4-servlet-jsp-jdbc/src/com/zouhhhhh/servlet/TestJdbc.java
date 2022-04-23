package com.zouhhhhh.servlet;

import com.zouhhhhh.bean.Student;
import com.zouhhhhh.utils.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@WebServlet("/test-jdbc")
public class TestJdbc extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");

        try {
            Connection connection = JDBCUtils.getConnection();
            String sql = "select * from student where name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String score = resultSet.getString(3);
                Date birthday = resultSet.getDate(4);
                Student student = new Student(id, name, score, birthday);
                resp.getWriter().write(student.toString());
                System.out.println(student);
            }
            JDBCUtils.closeResource(connection, preparedStatement, resultSet);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


    }
}

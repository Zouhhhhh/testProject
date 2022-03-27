package com.zouhhhhh.service;

import com.zouhhhhh.bean.Student;
import com.zouhhhhh.utils.JDBCUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentService {

    private Student student = new Student();

    public List<Student> findAllStudent() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = JDBCUtils.getConnection()){
            String sql = "select * from student";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String score = resultSet.getString(3);
                Date birthday = resultSet.getDate(4);
                students.add(new Student(id, name, score, birthday));
            }
        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return students;
    }

    public int addStudent(Student student) {
        try (Connection connection = JDBCUtils.getConnection()){
            String sql = "insert into student (name, score, birthday) values (?, ? ,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, student.getName());
            statement.setString(2, student.getScore());
            statement.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
            return statement.executeUpdate();
        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public int deleteStudent(int id) {
        try (Connection connection = JDBCUtils.getConnection()){
            String sql = "delete from student where id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            return statement.executeUpdate();
        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int updateStudent(Student student) {
        try (Connection connection = JDBCUtils.getConnection()){
            String sql = "update student set name = ?, score = ? where id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, student.getName());
            statement.setString(2, student.getScore());
            statement.setInt(3, student.getId());
            return statement.executeUpdate();
        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Student findStudentById(String id) {
        try (Connection connection = JDBCUtils.getConnection()){
            String sql = "select * from student where id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int studentId = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String score = resultSet.getString(3);
                Date date = resultSet.getDate(4);
                return new Student(studentId, name, score, date);
            }
        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}

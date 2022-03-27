package com.zouhhhhh.preparedstatement.test;


import com.zouhhhhh.preparedstatement.utils.JDBCUtils;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;

//使用PreparedStatement来替换Statement，实现对数据表的增删改查
public class UpdateTest {

//    public static void main(String[] args) {
//        try {
//            //获取连接
//            Connection connection = JDBCUtils.getConnection();
//            String sql = "insert into student (name, score, birthday) values (?, ?, ?)";
//            //获取PreparedStatement
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            //占位符填充
//            preparedStatement.setString(1, "张张");
//            preparedStatement.setString(2, "32");
//            preparedStatement.setDate(3, Date.valueOf(LocalDate.now()));
//            //执行sql
//            preparedStatement.execute();
//            System.out.println("插入成功");
//            //关闭连接
//            JDBCUtils.closeResource(connection, preparedStatement, null);
//        } catch (IOException | ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//    }

    //查询
    public static void main(String[] args) {
        try {
            //获取连接
            Connection connection = JDBCUtils.getConnection();
            String sql = "select * from student where name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "张张");
            // 执行SQL语句，返回ResultSet结果集
            ResultSet resultSet = preparedStatement.executeQuery();
            // 处理结果集
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String score = resultSet.getString(3);
                Date date = resultSet.getDate(4);
                System.out.println(id + "-" + name + "-" + score);
            }
            //关闭连接
            JDBCUtils.closeResource(connection, preparedStatement, null);
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


}

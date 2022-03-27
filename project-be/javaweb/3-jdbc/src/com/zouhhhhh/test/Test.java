package com.zouhhhhh.test;

import java.sql.*;
import java.time.LocalDate;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            String url = "jdbc:mysql://localhost:3306/test?userUnicode=true&characterEncoding=UTF-8";
            String user = "root";
            String password = "root";
            Connection connection = DriverManager.getConnection(url, user, password);

            //创建Statement
            Statement statement = connection.createStatement();

            //执行sql（增删改）
//            String sql = "insert into student (name, score, birthday) values ('李四', 78, '2022-03-27')";
//            int result = statement.executeUpdate(sql);

            //执行sql（查询）
//            String sql = "select * from student";
//            ResultSet resultSet = statement.executeQuery(sql);
//            while(resultSet.next()) {
//                Integer id = resultSet.getInt("id");
//                String name = resultSet.getString(2);
//                String score = resultSet.getString(3);
//                Date date = resultSet.getDate(4);
//                System.out.println(id + "-" + name + "-" + score + "-" + date);
//            }

            //PreparedStatement




        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


    }
}

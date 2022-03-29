package com.zouhhhhh.test;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceTest {

//    public static void main(String[] args) {
//        try {
//            //创建C3P0
//            ComboPooledDataSource dataSource = new ComboPooledDataSource();
//            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
//            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test?useSSL=FALSE&serverTimezone=UTC&allowPublicKeyRetrieval=true");
//            dataSource.setUser("root");
//            dataSource.setPassword("root");
//            Connection connection = dataSource.getConnection();
//            System.out.println(connection);
//            connection.close();     //这里的close不是关闭，而是放回dataSource连接池
//        } catch (PropertyVetoException | SQLException e) {
//            e.printStackTrace();
//        }
//    }


    //根据配置文件加载
    public static void main(String[] args) {
        try {
            //创建C3P0
            ComboPooledDataSource dataSource = new ComboPooledDataSource("testc3p0");

            Connection connection = dataSource.getConnection();
            System.out.println(connection);
            connection.close();     //这里的close不是关闭，而是放回dataSource连接池
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

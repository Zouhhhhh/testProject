package com.zouhhhhh.preparedstatement.utils;


import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Objects;
import java.util.Properties;

/*
操作数据库的工具类
 */
public class JDBCUtils {


    //TODO：通过配置文件拿到配置信息的方式
    //获取数据库连接
//    public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
//        // 1. 加载配置文件
//        InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
//        Properties properties = new Properties();
//        assert inputStream != null;
//        properties.load(inputStream);
//
//        // 2. 读取4个基本配置信息
//        String user = properties.getProperty("user");
//        String password = properties.getProperty("password");
//        String driverClass = properties.getProperty("driverClass");
//        String url = properties.getProperty("url");
//
//        // 3. 加载驱动
//        Class.forName(driverClass);
//
//        // 4. 获取连接
//        Connection connection = DriverManager.getConnection(url, user, password);
//        return connection;
//    }

    public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {

        String user = "root";
        String password = "root";
        String driverClass = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?useSSL=FALSE&serverTimezone=UTC&allowPublicKeyRetrieval=true";

        // 3. 加载驱动
        Class.forName(driverClass);

        // 4. 获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }


    //关闭数据库连接，PreparedStatement、ResultSet连接
    public static void closeResource(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

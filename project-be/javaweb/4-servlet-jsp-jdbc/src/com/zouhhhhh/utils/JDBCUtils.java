package com.zouhhhhh.utils;


import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Objects;
import java.util.Properties;

/*
操作数据库的工具类
 */
public class JDBCUtils {

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

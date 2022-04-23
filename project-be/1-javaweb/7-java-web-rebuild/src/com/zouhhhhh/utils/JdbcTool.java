package com.zouhhhhh.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author zouhao
 * @date 2022/4/17
 */
public class JdbcTool {

    /**
     * 从数据库连接池获取Connection
     * @return Connection
     */
    public static Connection getConnection() {
        try {
            ComboPooledDataSource dataSource = new ComboPooledDataSource("c3p0");
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void release(Connection connection, Statement statement, ResultSet resultset) {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultset != null) {
                resultset.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

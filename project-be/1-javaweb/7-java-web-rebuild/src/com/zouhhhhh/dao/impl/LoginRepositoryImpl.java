package com.zouhhhhh.dao.impl;

import com.zouhhhhh.bean.Admin;
import com.zouhhhhh.bean.Reader;
import com.zouhhhhh.dao.LoginRepository;
import com.zouhhhhh.utils.JdbcTool;

import java.sql.*;

/**
 * @author zouhao
 * @date 2022/4/17
 */
public class LoginRepositoryImpl implements LoginRepository {

    @Override
    public Reader getReader(String userName, String password) {
        Connection connection = JdbcTool.getConnection();
        String sql = "SELECT * FROM reader WHERE user_name = ? AND password = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, userName);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String id = resultSet.getString(1);
                String name = resultSet.getString(4);
                String tel = resultSet.getString(5);
                String cardId = resultSet.getString(6);
                String gender = resultSet.getString(7);
                return new Reader(id, userName, password, name, tel, cardId, gender);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcTool.release(connection, statement, resultSet);
        }

        return null;
    }

    @Override
    public Admin getAdmin(String userName, String password) {
        Connection connection = JdbcTool.getConnection();
        String sql = "SELECT * FROM admin WHERE user_name = ? AND password = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, userName);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String id = resultSet.getString(1);
                String name = resultSet.getString(4);
                return new Admin(id, userName, password, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcTool.release(connection, statement, resultSet);
        }

        return null;
    }


}

package com.zouhhhhh.repository.impl;

import com.zouhhhhh.entity.Admin;
import com.zouhhhhh.entity.Reader;
import com.zouhhhhh.repository.AdminRepository;
import com.zouhhhhh.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminRepositoryImpl implements AdminRepository {
    @Override
    public Admin login(String username, String password) {
        Connection connection = JDBCTools.getConnection();
        String sql = "select * from bookadmin where username = ? and password = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Admin admin = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {

                Integer id = resultSet.getInt(1);
                String realUsername = resultSet.getString(2);
                String realPassword = resultSet.getString(3);

                admin = new Admin(id, realUsername, realPassword);
                return admin;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection, statement, resultSet);
        }

        return null;
    }
}

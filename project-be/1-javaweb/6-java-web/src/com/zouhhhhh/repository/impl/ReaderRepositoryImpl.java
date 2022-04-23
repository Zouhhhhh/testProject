package com.zouhhhhh.repository.impl;

import com.zouhhhhh.entity.Reader;
import com.zouhhhhh.repository.ReaderRepository;
import com.zouhhhhh.utils.JDBCTools;

import java.sql.*;

public class ReaderRepositoryImpl implements ReaderRepository {

    @Override
    public Reader login(String username, String password) {
        Connection connection = JDBCTools.getConnection();
        String sql = "select * from reader where username = ? and password = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Reader reader = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {

                Integer id = resultSet.getInt(1);
                String realUsername = resultSet.getString(2);
                String realPassword = resultSet.getString(3);
                String name = resultSet.getString(4);
                String tel = resultSet.getString(5);
                String carid = resultSet.getString(6);
                String gender = resultSet.getString(7);

                reader = new Reader(id, realUsername, realPassword, name, tel, carid, gender);
                return reader;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection, statement, resultSet);
        }

        return null;
    }

}

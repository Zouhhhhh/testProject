package com.zouhhhhh.repository.impl;

import com.zouhhhhh.entity.Book;
import com.zouhhhhh.entity.Borrow;
import com.zouhhhhh.entity.Reader;
import com.zouhhhhh.repository.BorrowRepository;
import com.zouhhhhh.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BorrowRepositoryImpl implements BorrowRepository {
    @Override
    public void insert(Integer bookid, Integer readerid, String borrowtime, String returntime, Integer adminid, Integer state) {
        Connection connection = JDBCTools.getConnection();
        String sql = "insert into borrow (bookid, readerid, borrowtime, returntime, state) values(?,?,?,?,0)";
        PreparedStatement preparableStatement  = null;

        try {
            preparableStatement = connection.prepareStatement(sql);
            preparableStatement.setInt(1, bookid);
            preparableStatement.setInt(2, readerid);
            preparableStatement.setString(3, borrowtime);
            preparableStatement.setString(4, returntime);
            preparableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection, preparableStatement, null);
        }
    }


    @Override
    public List<Borrow> findAllByReaderId(Integer id) {
        Connection connection = JDBCTools.getConnection();
        String sql = "SELECT br.id, b.name, b.author, b.publish, br.borrowtime, br.returntime, r.name, r.tel" +
                ", r.cardid, br.state FROM borrow br, book b, reader r where br.bookid = b.id and br.readerid = r.id and r.id = ?";
        PreparedStatement preparableStatement  = null;
        ResultSet resultSet = null;
        try {
            preparableStatement = connection.prepareStatement(sql);
            preparableStatement.setInt(1, id);
            resultSet = preparableStatement.executeQuery();
            List<Borrow> list = new ArrayList<>();
            Book book;
            Reader reader;
            Borrow borrow;
            while (resultSet.next()) {
                int borrowId = resultSet.getInt(1);
                String bookName = resultSet.getString(2);
                String author = resultSet.getString(3);
                String publish = resultSet.getString(4);
                String borrowtime = resultSet.getString(5);
                String returntime = resultSet.getString(6);
                String readName = resultSet.getString(7);
                String tel = resultSet.getString(8);
                String cardid = resultSet.getString(9);
                Integer state = resultSet.getInt(10);
                book = new Book(bookName, author, publish);
                reader = new Reader(readName, tel, cardid);
                borrow = new Borrow(borrowId, book, reader, borrowtime, returntime, state);
                list.add(borrow);
            }

            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection, preparableStatement, null);
        }


        return null;
    }


}

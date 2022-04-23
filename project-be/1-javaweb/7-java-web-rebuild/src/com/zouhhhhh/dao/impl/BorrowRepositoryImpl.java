package com.zouhhhhh.dao.impl;

import com.zouhhhhh.bean.Book;
import com.zouhhhhh.bean.Borrow;
import com.zouhhhhh.bean.Reader;
import com.zouhhhhh.dao.BorrowRepository;
import com.zouhhhhh.utils.JdbcTool;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * @author zouhao
 * @date 2022/4/20
 */
public class BorrowRepositoryImpl implements BorrowRepository {

    @Override
    public void addBorrow(String bookId, String readerId, LocalDate borrowTime, LocalDate returnTime) {
        Connection connection = JdbcTool.getConnection();
        String sql = "insert into borrow (id, bookid, readerid, borrowtime, returntime, state) values(?,?,?,?,?,0)";
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, String.valueOf(UUID.randomUUID()));
            statement.setString(2, bookId);
            statement.setString(3, readerId);
            statement.setDate(4, Date.valueOf(borrowTime));
            statement.setDate(5, Date.valueOf(returnTime));

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcTool.release(connection, statement, resultSet);
        }
    }

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID());
    }

    @Override
    public List<Borrow> findAllBorrowByReader(String readerId, Integer index, Integer limit) {
        Connection connection = JdbcTool.getConnection();
        String sql = "SELECT br.id, b.name, b.author, b.publish, br.borrowtime, br.returntime, r.name, r.tel" +
                ", r.cardid, br.state FROM borrow br, book b, reader r where br.bookid = b.id and br.readerid = r.id and r.id = ? limit ?, ?";
        PreparedStatement preparableStatement  = null;
        ResultSet resultSet = null;
        try {
            preparableStatement = connection.prepareStatement(sql);
            preparableStatement.setString(1, readerId);
            preparableStatement.setInt(2, index);
            preparableStatement.setInt(3, limit);
            resultSet = preparableStatement.executeQuery();
            List<Borrow> borrows = new ArrayList<>();
            Book book;
            Reader reader;
            Borrow borrow;
            while (resultSet.next()) {
                String borrowId = resultSet.getString(1);
                String bookName = resultSet.getString(2);
                String author = resultSet.getString(3);
                String publish = resultSet.getString(4);
                Date borrowTime = resultSet.getDate(5);
                Date returnTime = resultSet.getDate(6);
                String readerName = resultSet.getString(7);
                String tel = resultSet.getString(8);
                String cardId = resultSet.getString(9);
                String state = resultSet.getString(10);
                book = new Book(bookName, author, publish);
                reader = new Reader(readerName, tel, cardId);
                borrow = new Borrow(borrowId, book, reader, borrowTime.toLocalDate(), returnTime.toLocalDate(), state);
                borrows.add(borrow);
            }
            return borrows;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcTool.release(connection, preparableStatement, resultSet);
        }
        return null;
    }

    @Override
    public int getCountOfBorrow() {
        Connection connection = JdbcTool.getConnection();
        String sql = "SELECT COUNT(1) FROM borrow;";
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcTool.release(connection, statement, resultSet);
        }

        return 0;
    }

    @Override
    public List<Borrow> findAllBorrowByState(String state, Integer index, Integer limit) {
        Connection connection = JdbcTool.getConnection();
        String sql = "SELECT br.id, b.name, b.author, b.publish, br.borrowtime, br.returntime, r.name, r.tel" +
                ", r.cardid, br.state FROM borrow br, book b, reader r where br.bookid = b.id and br.readerid = r.id and br.state = ? limit ?, ?";
        PreparedStatement preparableStatement  = null;
        ResultSet resultSet = null;
        try {
            preparableStatement = connection.prepareStatement(sql);
            preparableStatement.setString(1, state);
            preparableStatement.setInt(2, index);
            preparableStatement.setInt(3, limit);
            resultSet = preparableStatement.executeQuery();
            List<Borrow> borrows = new ArrayList<>();
            Book book;
            Reader reader;
            Borrow borrow;
            while (resultSet.next()) {
                String borrowId = resultSet.getString(1);
                String bookName = resultSet.getString(2);
                String author = resultSet.getString(3);
                String publish = resultSet.getString(4);
                Date borrowTime = resultSet.getDate(5);
                Date returnTime = resultSet.getDate(6);
                String readerName = resultSet.getString(7);
                String tel = resultSet.getString(8);
                String cardId = resultSet.getString(9);
                book = new Book(bookName, author, publish);
                reader = new Reader(readerName, tel, cardId);
                borrow = new Borrow(borrowId, book, reader, borrowTime.toLocalDate(), returnTime.toLocalDate(), state);
                borrows.add(borrow);
            }
            return borrows;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcTool.release(connection, preparableStatement, resultSet);
        }
        return null;
    }
}

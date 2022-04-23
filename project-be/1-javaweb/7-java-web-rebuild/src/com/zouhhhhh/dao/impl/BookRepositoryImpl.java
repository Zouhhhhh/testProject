package com.zouhhhhh.dao.impl;

import com.zouhhhhh.bean.Book;
import com.zouhhhhh.bean.BookCase;
import com.zouhhhhh.constant.Constant;
import com.zouhhhhh.dao.BookRepository;
import com.zouhhhhh.utils.JdbcTool;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zouhao
 * @date 2022/4/17
 */
public class BookRepositoryImpl implements BookRepository {
    @Override
    public List<Book> findAllBook(Integer index, Integer limit) {
        Connection connection = JdbcTool.getConnection();
        String sql = "SELECT t1.*, t2.* FROM book t1 LEFT JOIN book_case t2 ON t1.book_case = t2.id LIMIT ?, ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Book> books = new ArrayList<>();

        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, index);
            statement.setInt(2, limit);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                // BookCase
                String bookCaseId = resultSet.getString(9);
                String bookCaseName = resultSet.getString(10);
                BookCase bookCase = new BookCase(bookCaseId, bookCaseName);

                // Book
                String bookId = resultSet.getString(1);
                String bookName = resultSet.getString(2);
                String author = resultSet.getString(3);
                String publish = resultSet.getString(4);
                Integer pages = resultSet.getInt(5);
                BigDecimal price = resultSet.getBigDecimal(6);
                Boolean abled = resultSet.getBoolean(7);
                Book book = new Book(bookId, bookName, author, publish, pages, price, abled, bookCase);

                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcTool.release(connection, statement, resultSet);
        }

        return books;
    }

    @Override
    public int getCountOfBook() {
        Connection connection = JdbcTool.getConnection();
        String sql = "SELECT COUNT(1) FROM book;";
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
}

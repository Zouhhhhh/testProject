package com.zouhhhhh.repository.impl;

import com.zouhhhhh.entity.Book;
import com.zouhhhhh.entity.BookCase;
import com.zouhhhhh.repository.BookRepository;
import com.zouhhhhh.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    @Override
    public List<Book> findAll(int index, int limit) {

        Connection connection = JDBCTools.getConnection();
        String sql = "select * from book, bookcase where bookcase.id = book.bookcaseid limit ?, ?";
        List<Book> books = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, index);
            statement.setInt(2, limit);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int bookCaseId = resultSet.getInt(9);
                String bookCaseName = resultSet.getString(10);
                BookCase bookCase = new BookCase(bookCaseId, bookCaseName);

                int bookId = resultSet.getInt(1);
                String bookName = resultSet.getString(2);
                String author = resultSet.getString(3);
                String publish = resultSet.getString(4);
                int pages = resultSet.getInt(5);
                Double price = resultSet.getDouble(6);
                Book book = new Book(bookId, bookName, author, publish, pages, price, bookCase, null);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }


    @Override
    public int count() {
        Connection connection = JDBCTools.getConnection();
        String sql = "select count(1) from book, bookcase where bookcase.id = book.bookcaseid";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
               return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}

package com.kuang.service;

import com.kuang.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {

    //增加
    int addBook(Books books);

    //删除
    int deleteBookById(@Param("bookId") int id);

    //更新
    int updateBook(Books books);

    //查询
    Books queryBookById(@Param("bookId") int id);

    //查询全部
    List<Books> queryAllBook();

    Books queryBookByName(String bookName);

}

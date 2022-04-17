package com.zouhhhhh.dao;

import com.zouhhhhh.bean.Book;

import java.util.List;

/**
 * @author zouhao
 * @date 2022/4/17
 */
public interface BookRepository {

    /**
     * 获取所有书籍信息
     * @param page
     * @return
     */
    List<Book> findAllBook(Integer index, Integer limit);

    /**
     * 获取书籍的总数
     * @return
     */
    int getCountOfBook();
}

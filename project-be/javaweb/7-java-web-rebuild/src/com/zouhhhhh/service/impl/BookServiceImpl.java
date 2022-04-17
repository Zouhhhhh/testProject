package com.zouhhhhh.service.impl;

import com.zouhhhhh.bean.Book;
import com.zouhhhhh.constant.Constant;
import com.zouhhhhh.dao.BookRepository;
import com.zouhhhhh.dao.impl.BookRepositoryImpl;
import com.zouhhhhh.service.BookService;

import java.util.List;

/**
 * @author zouhao
 * @date 2022/4/17
 */
public class BookServiceImpl implements BookService {

    BookRepository bookRepository = new BookRepositoryImpl();

    @Override
    public List<Book> findAllBook(Integer page) {
        int index = (page - 1) * Constant.PAGE_LIMIT;
        return bookRepository.findAllBook(index, Constant.PAGE_LIMIT);
    }

    @Override
    public int getCountOfBook() {
        return bookRepository.getCountOfBook();
    }


}

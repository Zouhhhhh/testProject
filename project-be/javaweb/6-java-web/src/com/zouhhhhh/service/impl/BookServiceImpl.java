package com.zouhhhhh.service.impl;

import com.zouhhhhh.entity.Book;
import com.zouhhhhh.repository.BookRepository;
import com.zouhhhhh.repository.impl.BookRepositoryImpl;
import com.zouhhhhh.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookRepository bookRepository = new BookRepositoryImpl();
    private final int LIMIT = 6;

    @Override
    public List<Book> findAll(int page) {
        int index = (page-1) * LIMIT;
        return bookRepository.findAll(index, LIMIT);
    }

    @Override
    public int getPages() {
        int count = bookRepository.count();
        int page = (int) Math.ceil((double) count / LIMIT);
        return page;
    }

    public static void main(String[] args) {
        int count = 14;
        int limit = 6;
        int page = (int) Math.ceil((double) count / limit);
        System.out.println(page);
        int ii = 0;
    }


}

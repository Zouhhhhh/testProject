package com.zouhhhhh.service;

import com.zouhhhhh.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll(int page);

    int getPages();

}

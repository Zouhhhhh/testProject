package com.zouhhhhh.repository;

import com.zouhhhhh.entity.Book;

import java.util.List;

public interface BookRepository {

    List<Book> findAll(int index, int limit);

    int count();

}

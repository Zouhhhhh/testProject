package com.zouhhhhh.service;

import com.zouhhhhh.entity.Book;
import com.zouhhhhh.entity.Borrow;

import java.util.List;

public interface BookService {

    List<Book> findAll(int page);

    int getPages();

    void addBorrow(Integer bookid, Integer readerid);

    List<Borrow> findAllBorrowByReaderId(Integer id, Integer page);

    int getBorrowPages(Integer readerid);

    List<Borrow> findAllBorrow(Integer state, Integer page);

    int getBorrowPagesByState(Integer state);

    void handleBorrow(Integer borrowId, Integer state, Integer adminId);

}

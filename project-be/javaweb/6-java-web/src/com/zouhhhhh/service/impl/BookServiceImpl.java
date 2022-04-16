package com.zouhhhhh.service.impl;

import com.zouhhhhh.entity.Book;
import com.zouhhhhh.entity.Borrow;
import com.zouhhhhh.repository.BookRepository;
import com.zouhhhhh.repository.BorrowRepository;
import com.zouhhhhh.repository.impl.BookRepositoryImpl;
import com.zouhhhhh.repository.impl.BorrowRepositoryImpl;
import com.zouhhhhh.service.BookService;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

public class BookServiceImpl implements BookService {

    private BookRepository bookRepository = new BookRepositoryImpl();
    private final int LIMIT = 6;

    private BorrowRepository borrowRepository = new BorrowRepositoryImpl();

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

    @Override
    public void addBorrow(Integer bookid, Integer readerid) {
        //借书时间
        LocalDate borrowDate = LocalDate.now();
        //还书时间
        LocalDate returnDate = borrowDate.plusDays(14);

        borrowRepository.insert(bookid, readerid, borrowDate.toString(), returnDate.toString(), null, 0);

    }

    @Override
    public List<Borrow> findAllBorrowByReaderId(Integer id, Integer page) {
        //将page换算成index, limit
        int index = (page-1) * LIMIT;
        return borrowRepository.findAllByReaderId(id, index, LIMIT);
    }

    @Override
    public int getBorrowPages(Integer readerid) {
        int count = borrowRepository.count(readerid);
        int page = (int) Math.ceil((double) count / LIMIT);
        return page;
    }

    @Override
    public List<Borrow> findAllBorrow(Integer state, Integer page) {
        int index = (page - 1) * LIMIT;
        return borrowRepository.findAllBorrowByState(state, index, LIMIT);
    }

    @Override
    public int getBorrowPagesByState(Integer state) {
        int count = borrowRepository.countByState(state);
        int page = (int) Math.ceil((double) count / LIMIT);
        return page;
    }

    @Override
    public void handleBorrow(Integer borrowId, Integer state, Integer adminId) {
        borrowRepository.handle(borrowId, state, adminId);
    }
}

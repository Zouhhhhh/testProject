package com.zouhhhhh.service.impl;

import com.zouhhhhh.bean.Book;
import com.zouhhhhh.bean.Borrow;
import com.zouhhhhh.constant.Constant;
import com.zouhhhhh.dao.BookRepository;
import com.zouhhhhh.dao.BorrowRepository;
import com.zouhhhhh.dao.impl.BookRepositoryImpl;
import com.zouhhhhh.dao.impl.BorrowRepositoryImpl;
import com.zouhhhhh.service.BookService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

/**
 * @author zouhao
 * @date 2022/4/17
 */
public class BookServiceImpl implements BookService {

    BookRepository bookRepository = new BookRepositoryImpl();

    BorrowRepository borrowRepository = new BorrowRepositoryImpl();

    @Override
    public List<Book> findAllBook(Integer page) {
        int index = (page - 1) * Constant.PAGE_LIMIT;
        return bookRepository.findAllBook(index, Constant.PAGE_LIMIT);
    }

    @Override
    public int getCountOfBook() {
        return bookRepository.getCountOfBook();
    }

    @Override
    public int getBookPages() {
        return (int) Math.ceil(getCountOfBook() / Constant.PAGE_LIMIT);
    }

    @Override
    public void addBorrow(String bookId, String readerId) {
        borrowRepository.addBorrow(bookId, readerId, LocalDate.now(), LocalDate.now().plusDays(14));
    }

    @Override
    public List<Borrow> findAllBorrowByReader(String readerId, Integer page) {
        int index = (page - 1) * Constant.PAGE_LIMIT;
        return borrowRepository.findAllBorrowByReader(readerId, index, Constant.PAGE_LIMIT);
    }

    @Override
    public void setPageInfo(HttpServletRequest request, String currentPage, Integer pages) {
        request.setAttribute("dataPrePage", Constant.PAGE_LIMIT);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("pages", pages);
    }

    @Override
    public int getCountOfBorrow() {
        return borrowRepository.getCountOfBorrow();
    }

    @Override
    public int getBorrowPages() {
        return (int) Math.ceil(getCountOfBorrow() / Constant.PAGE_LIMIT);
    }

    @Override
    public List<Borrow> findAllBorrowByState(String state, Integer page) {
        int index = (page - 1) / Constant.PAGE_LIMIT;
        return borrowRepository.findAllBorrowByState(state, page, index);
    }
}

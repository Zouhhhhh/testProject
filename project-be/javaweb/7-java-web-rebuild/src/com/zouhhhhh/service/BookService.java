package com.zouhhhhh.service;

import com.zouhhhhh.bean.Book;
import com.zouhhhhh.bean.Borrow;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author zouhao
 * @date 2022/4/17
 */
public interface BookService {
    /**
     * 获取所有书籍信息
     * @param page
     * @return
     */
    List<Book> findAllBook(Integer page);

    /**
     * 获取书籍的总数
     * @return
     */
    int getCountOfBook();

    /**
     * 获取Book表总页数
     * @return
     */
    int getBookPages();

    /**
     * 借阅图书
     * @param bookId
     * @param readerId
     */
    void addBorrow(String bookId, String readerId);

    /**
     * 获取所有借阅信息
     * @param readerId
     * @param page
     * @return
     */
    List<Borrow> findAllBorrowByReader(String readerId, Integer page);

    /**
     * 设置分页信息
     * @param request
     * @param currentPage
     * @param pages
     */
    void setPageInfo(HttpServletRequest request, String currentPage, Integer pages);

    /**
     * 获取借阅的总数
     * @return
     */
    int getCountOfBorrow();

    /**
     * 获取Borrow表页数
     * @return
     */
    int getBorrowPages();

    /**
     * 通过状态获取所有借阅信息
     * @param state
     * @param page
     * @return
     */
    List<Borrow> findAllBorrowByState(String state, Integer page);

}

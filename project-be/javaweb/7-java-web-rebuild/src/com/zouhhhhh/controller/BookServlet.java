package com.zouhhhhh.controller;

import com.zouhhhhh.bean.Book;
import com.zouhhhhh.bean.Borrow;
import com.zouhhhhh.bean.Reader;
import com.zouhhhhh.service.BookService;
import com.zouhhhhh.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author zouhao
 * @date 2022/4/17
 */
@WebServlet("/book")
public class BookServlet extends HttpServlet {

    private BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Reader reader = (Reader) session.getAttribute("reader");
        String pageStr = req.getParameter("page");
        String method = req.getParameter("method");
        method = method == null ? "findAllBook" : method;

        switch (method) {
            case "findAllBook":
                List<Book> books = bookService.findAllBook(Integer.valueOf(pageStr));
                req.setAttribute("books", books);
                bookService.setPageInfo(req, pageStr, bookService.getBookPages());
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            case "addBorrow":
                String bookId = req.getParameter("bookId");
                bookService.addBorrow(bookId, reader.getId());
                resp.sendRedirect("/book?method=findAllBorrow&page=1");
                break;
            case "findAllBorrow":
                List<Borrow> borrows = bookService.findAllBorrowByReader(reader.getId(), Integer.valueOf(pageStr));
                req.setAttribute("borrows", borrows);
                bookService.setPageInfo(req, pageStr, bookService.getBorrowPages());
                req.getRequestDispatcher("/borrow.jsp").forward(req, resp);
                break;
            default:
                break;
        }

    }
}

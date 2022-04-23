package com.zouhhhhh.controller;

import com.zouhhhhh.bean.Borrow;
import com.zouhhhhh.service.BookService;
import com.zouhhhhh.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author zouhao
 * @date 2022/4/20
 */
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        method = method == null ? "findAllBorrowByState" : method;
        String page = req.getParameter("page");

        switch (method) {
            case "findAllBorrowByState":
                List<Borrow> borrows = bookService.findAllBorrowByState("0", Integer.parseInt(page));
                req.setAttribute("borrows", borrows);
                bookService.setPageInfo(req, page, bookService.getBorrowPages());

                break;
            default:
                break;
        }

        super.doGet(req, resp);
    }
}

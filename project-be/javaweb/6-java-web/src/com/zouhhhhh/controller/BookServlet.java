package com.zouhhhhh.controller;

import com.zouhhhhh.entity.Book;
import com.zouhhhhh.entity.Borrow;
import com.zouhhhhh.entity.Reader;
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

@WebServlet("/book")
public class BookServlet extends HttpServlet {

    private BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        method = method == null ? "findAll" : method;

        //流程控制
        switch (method) {
            case "findAll":
                String pageStr = req.getParameter("page");
                Integer page = Integer.parseInt(pageStr);
                List<Book> books = bookService.findAll(page);
                req.setAttribute("list", books);
                req.setAttribute("dataPrePage", 6);
                req.setAttribute("currentPage", pageStr);
                req.setAttribute("pages", bookService.getPages());
                req.getRequestDispatcher("index.jsp").forward(req, resp);
                break;
            case "addBorrow":
                String bookstr = req.getParameter("bookid");
                Integer bookid = Integer.parseInt(bookstr);
                HttpSession session = req.getSession();
                Reader reader = (Reader) session.getAttribute("reader");
                Integer readerid = reader.getId();
                bookService.addBorrow(bookid, readerid);
                //展示当前用户的所有借书记录
                List<Borrow> borrowList = bookService.findAllBorrowByReaderId(readerid);
                req.setAttribute("list", borrowList);
                req.getRequestDispatcher("borrow.jsp").forward(req, resp);
                break;
            default:
                break;
        }



    }
}

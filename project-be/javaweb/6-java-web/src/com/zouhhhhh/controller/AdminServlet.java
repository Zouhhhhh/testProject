package com.zouhhhhh.controller;

import com.zouhhhhh.entity.Admin;
import com.zouhhhhh.entity.Borrow;
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

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    private BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String method = req.getParameter("method");
        method = method == null ? "findAllBorrow" : method;

        HttpSession session = req.getSession();
        Admin admin = (Admin) session.getAttribute("admin");

        switch (method) {
            case "findAllBorrow":
                String pageStr = req.getParameter("page");
                Integer page = Integer.valueOf(pageStr);
                List<Borrow> list = bookService.findAllBorrow(0, page);
                req.setAttribute("list", list);
                req.setAttribute("dataPrePage", 6);
                req.setAttribute("currentPage", pageStr);
                req.setAttribute("pages", bookService.getBorrowPagesByState(0));
                req.getRequestDispatcher("admin.jsp").forward(req, resp);
                break;
            case "handle":
                String borrowIdStr = req.getParameter("id");
                Integer borrowId = Integer.valueOf(borrowIdStr);
                String stateStr = req.getParameter("state");
                Integer state = Integer.valueOf(stateStr);
                bookService.handleBorrow(borrowId, state, admin.getId());
                resp.sendRedirect("/admin?page=1");

                break;
            default:
                break;
        }


    }
}

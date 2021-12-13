package com.kuang.controller;


import com.kuang.pojo.Books;
import com.kuang.service.BookService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    //controller 调用 service层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        return "allBook";
    }

    @RequestMapping("/toAddBook")
    public String toAddBook(Model model) {
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addBook(Books book) {
        bookService.addBook(book);
        return "redirect:/book/allBook";       //添加完重定向
    }

    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(@RequestParam("id") int bookID, Model model) {
        Books book = bookService.queryBookById(bookID);
        model.addAttribute("book", book);
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Books book, Model model) {
        System.out.println(book);
        bookService.updateBook(book);
//        Books books = bookService.queryBookById(book.getBookId());
//        model.addAttribute("book", books);
        return "redirect:/book/allBook";       //修改完重定向
    }

    @RequestMapping("/del/{bookID}")
    public String del(@PathVariable("bookID") int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    //查询
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName, Model model) {
        if ("".equals(queryBookName)) {
            return "redirect:/book/allBook";
        }
        Books books = bookService.queryBookByName(queryBookName);
        List<Books> list = new ArrayList<>();
        list.add(books);
        model.addAttribute("list", list);
        return "allBook";
    }



}

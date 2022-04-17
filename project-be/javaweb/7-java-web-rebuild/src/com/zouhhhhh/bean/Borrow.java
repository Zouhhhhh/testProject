package com.zouhhhhh.bean;

import java.time.LocalDate;

/**
 * @author zouhao
 * @date 2022/4/17
 */
public class Borrow {

    private String id;
    private Book book;
    private Reader reader;
    private LocalDate borrowTime;
    private LocalDate returnTime;
    private Admin admin;
    private String state;


    public Borrow(String id, Book book, Reader reader, LocalDate borrowTime, LocalDate returnTime, Admin admin, String state) {
        this.id = id;
        this.book = book;
        this.reader = reader;
        this.borrowTime = borrowTime;
        this.returnTime = returnTime;
        this.admin = admin;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public LocalDate getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(LocalDate borrowTime) {
        this.borrowTime = borrowTime;
    }

    public LocalDate getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(LocalDate returnTime) {
        this.returnTime = returnTime;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

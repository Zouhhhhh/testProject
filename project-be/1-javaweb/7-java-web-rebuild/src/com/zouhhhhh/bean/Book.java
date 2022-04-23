package com.zouhhhhh.bean;

import java.math.BigDecimal;

/**
 * @author zouhao
 * @date 2022/4/17
 */
public class Book {

    private String id;
    private String name;
    private String author;
    private String publish;
    private Integer pages;
    private BigDecimal price;
    private Boolean abled;
    private BookCase bookCase;

    public Book(String name, String author, String publish) {
        this.name = name;
        this.author = author;
        this.publish = publish;
    }

    public Book(String id, String name, String author, String publish, Integer pages
            , BigDecimal price, Boolean abled, BookCase bookCase) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publish = publish;
        this.pages = pages;
        this.price = price;
        this.abled = abled;
        this.bookCase = bookCase;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getAbled() {
        return abled;
    }

    public void setAbled(Boolean abled) {
        this.abled = abled;
    }

    public BookCase getBookCase() {
        return bookCase;
    }

    public void setBookCase(BookCase bookCase) {
        this.bookCase = bookCase;
    }
}

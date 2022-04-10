package com.zouhhhhh.entity;

public class Book {

    private Integer id;
    private String name;
    private String author;
    private String publish;
    private Integer pages;
    private Double price;
    //多对一
    private BookCase bookCase;
    private Boolean abled;

    public Book(String name, String author, String publish) {
        this.name = name;
        this.author = author;
        this.publish = publish;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public BookCase getBookCase() {
        return bookCase;
    }

    public void setBookCase(BookCase bookCase) {
        this.bookCase = bookCase;
    }

    public Boolean getAbled() {
        return abled;
    }

    public void setAbled(Boolean abled) {
        this.abled = abled;
    }

    public Book(Integer id, String name, String author, String publish, Integer pages, Double price, BookCase bookCase, Boolean abled) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publish = publish;
        this.pages = pages;
        this.price = price;
        this.bookCase = bookCase;
        this.abled = abled;
    }
}


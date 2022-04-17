package com.zouhhhhh.bean;

/**
 * @author zouhao
 * @date 2022/4/17
 */
public class BookCase {

    private String id;
    private String name;

    public BookCase(String id, String name) {
        this.id = id;
        this.name = name;
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
}

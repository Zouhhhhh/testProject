package com.kuang.onlytest;


import java.util.ArrayList;
import java.util.List;

public class OnlyTest{

    //内置注解
    @Override
    public String toString() {
        return "123";
    }

    @Deprecated
    public void test() {
        System.out.println("废弃注解");
    }

    @SuppressWarnings("all")
    public void test2() {
        List list = new ArrayList();
    }

}
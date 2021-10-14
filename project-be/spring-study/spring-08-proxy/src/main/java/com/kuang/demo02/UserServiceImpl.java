package com.kuang.demo02;


//真实对象
public class UserServiceImpl implements UserService {

    @Override
    public void add() {
        System.out.println("新增对象");
    }

    @Override
    public void delete() {
        System.out.println("删除对象");

    }

    @Override
    public void update() {
        System.out.println("更新对象");

    }

    @Override
    public void query() {
        System.out.println("查询对象");

    }

//    public void log() {
//        System.out.println("打印日志");
//    }
    //1. 改动原有的业务代码，在公司中是大忌！


}

package com.kuang.dao;

public class UserDaoSqlServerImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("SqlServer获取用户数据");
    }
}

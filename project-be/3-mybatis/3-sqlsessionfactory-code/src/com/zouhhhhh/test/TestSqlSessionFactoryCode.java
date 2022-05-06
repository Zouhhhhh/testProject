package com.zouhhhhh.test;

import com.zouhhhhh.config.MyConfiguration;
import org.apache.ibatis.session.SqlSessionFactory;

public class TestSqlSessionFactoryCode {

    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory = MyConfiguration.getSqlSessionFactory();
        System.err.println(sqlSessionFactory);
    }

}

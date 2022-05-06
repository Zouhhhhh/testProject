package com.zouhhhhh.zhujie.test;

import com.zouhhhhh.zhujie.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

public class TestMapperZhujie {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        System.out.println("注解的：" + sqlSession);
    }
}

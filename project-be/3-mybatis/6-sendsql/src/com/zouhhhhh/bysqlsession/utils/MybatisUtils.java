package com.zouhhhhh.bysqlsession.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author zouhao
 * @date 2022/5/6
 */
public class MybatisUtils {

    /**
     * 获取SqlSessionFactory
     * @return
     */
    public static SqlSessionFactory getSqlSessionFactory() {

        SqlSessionFactory sqlSessionFactory = null;
        String resource = "mybatis-config.xml";
        InputStream inputStream;

        try {
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sqlSessionFactory;
    }

    /**
     * 获取SqlSession
     * @return
     */
    public static SqlSession getSqlSession() {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        return sqlSessionFactory.openSession();
    }

}

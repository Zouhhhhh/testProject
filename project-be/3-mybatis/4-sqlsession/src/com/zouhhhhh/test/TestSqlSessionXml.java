package com.zouhhhhh.test;

import com.zouhhhhh.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * @author zouhao
 * @date 2022/5/6
 */
public class TestSqlSessionXml {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        System.out.println(sqlSession);
        try {
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}

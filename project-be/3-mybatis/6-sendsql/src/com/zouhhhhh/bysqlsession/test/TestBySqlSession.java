package com.zouhhhhh.bysqlsession.test;

import com.zouhhhhh.bysqlsession.pojo.Role;
import com.zouhhhhh.bysqlsession.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

public class TestBySqlSession {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        Role role = sqlSession.selectOne("com.zouhhhhh.bysqlsession.mapper.RoleMapper.getRole", 3L);
        System.out.println("用sqlsession发SQL：" + role.getRoleName());

        if (sqlSession != null) {
            sqlSession.close();
        }
    }
}

package com.zouhhhhh.test;

import com.zouhhhhh.mapper.RoleMapper;
import com.zouhhhhh.pojo.Role;
import com.zouhhhhh.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

/**
 * @author zouhao
 * @date 2022/5/6
 */
public class Main {
    public static void main(String[] args) {
        Logger log = Logger.getLogger(Main.class);
        SqlSession sqlSession = null;

        try {
            log.info("start SqlSession");
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = roleMapper.getRole(1L);
            log.info(role.getRoleName());
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}

package com.zouhhhhh.bymapper.test;

import com.zouhhhhh.bymapper.mapper.RoleMapper;
import com.zouhhhhh.bymapper.pojo.Role;
import com.zouhhhhh.bymapper.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

public class TestByMapper {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        Role role = roleMapper.getRole(3L);
        System.out.println("用mapper接口获取role：" + role.getRoleName());
        if (sqlSession != null) {
            sqlSession.close();
        }
    }
}

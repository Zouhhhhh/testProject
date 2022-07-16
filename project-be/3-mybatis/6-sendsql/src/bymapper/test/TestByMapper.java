package bymapper.test;

import bymapper.mapper.RoleMapper;
import bymapper.utils.MybatisUtils;
import bymapper.pojo.Role;
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

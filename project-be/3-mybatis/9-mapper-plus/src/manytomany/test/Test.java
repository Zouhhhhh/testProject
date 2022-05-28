package manytomany.test;


import manytomany.mapper.RoleMapper;
import manytomany.mapper.UserMapper;
import manytomany.pojo.Role;
import manytomany.pojo.User;
import manytomany.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

public class Test {
    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            Logger logger = Logger.getLogger(cascade.test.Test.class);
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = roleMapper.getRole(1L);
            role.getUserList();

            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUser(1L);
            user.getNote();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}

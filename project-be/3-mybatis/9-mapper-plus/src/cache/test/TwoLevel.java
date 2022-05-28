package cache.test;

import cache.mapper.RoleMapper;
import cache.pojo.Role;
import cache.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

public class TwoLevel {

    public static void main(String[] args) {
        SqlSession sqlSession = null;
        SqlSession sqlSession2 = null;
        Logger logger = Logger.getLogger(OneLevel.class);
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            sqlSession2 = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = roleMapper.getRole(1L);
            // 需要提交，如果是二级缓存，Mybatis才会缓存对象到SqlSessionFactory层面
//            sqlSession.commit();


            logger.info("不同sqlSession再获取一次POJO。。。");
            RoleMapper roleMapper2 = sqlSession2.getMapper(RoleMapper.class);
            Role role2 = roleMapper2.getRole(1L);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

}

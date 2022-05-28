package cache.test;


import cache.mapper.RoleMapper;
import cache.pojo.Role;
import cache.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

public class OneLevel {
    public static void main(String[] args) {

        SqlSession sqlSession = null;
        Logger logger = Logger.getLogger(OneLevel.class);
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = roleMapper.getRole(1L);
            logger.info("在获取一次pojo。。。");
            Role role2 = roleMapper.getRole(2L);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }


    }
}

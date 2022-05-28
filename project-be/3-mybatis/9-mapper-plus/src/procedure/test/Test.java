package procedure.test;

import procedure.mapper.RoleMapper;
import procedure.pojo.Role;
import procedure.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import procedure.pojo.PdCountRoleParams;

public class Test {
    public static void main(String[] args) {

        PdCountRoleParams params = new PdCountRoleParams();
        params.setRoleName("管");
        SqlSession sqlSession = null;

        try {
            Logger logger = Logger.getLogger(Test.class);
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            roleMapper.countRole(params);
            logger.info(params.getTotal());
            logger.info(params.getExecDate());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}

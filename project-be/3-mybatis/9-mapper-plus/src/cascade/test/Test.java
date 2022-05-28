package cascade.test;

import cascade.mapper.*;
import cascade.pojo.*;
import cascade.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        try {
            Logger logger = Logger.getLogger(Test.class);
            SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee maleEmployee = mapper.getEmployeeById(1L);
            logger.info(maleEmployee.getBirthday());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}

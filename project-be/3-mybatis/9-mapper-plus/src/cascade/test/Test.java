package cascade.test;

import cascade.mapper.*;
import cascade.pojo.*;
import cascade.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Test {

    public static void main(String[] args) {

        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee femaleEmployee = mapper.getEmployeeById(2L);
        System.out.println(femaleEmployee.getSex());

    }

}

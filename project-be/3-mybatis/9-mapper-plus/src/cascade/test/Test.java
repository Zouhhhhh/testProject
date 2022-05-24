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
        Employee maleEmployee = mapper.getEmployeeById(1L);
        System.out.println(maleEmployee.getSex());


//        WorkCardMapper mapper = sqlSession.getMapper(WorkCardMapper.class);
//        WorkCard workCardByEmpId = mapper.getWorkCardByEmpId(1L);
//        System.out.println(workCardByEmpId.getRealName());

//        EmployeeTaskMapper mapper = sqlSession.getMapper(EmployeeTaskMapper.class);
//        EmployeeTask employeeTaskByEmpId = mapper.getEmployeeTaskByEmpId(1L);
//        System.out.println(employeeTaskByEmpId.getEmpId());


    }

}

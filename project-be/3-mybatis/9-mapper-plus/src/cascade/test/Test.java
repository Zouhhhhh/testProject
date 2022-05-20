package cascade.test;

import cascade.mapper.EmployeeTaskMapper;
import cascade.mapper.TaskMapper;
import cascade.mapper.WorkCardMapper;
import cascade.pojo.EmployeeTask;
import cascade.pojo.Task;
import cascade.pojo.WorkCard;
import cascade.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Test {

    public static void main(String[] args) {

        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        EmployeeTaskMapper mapper = sqlSession.getMapper(EmployeeTaskMapper.class);
        EmployeeTask employeeTaskByEmpId = mapper.getEmployeeTaskByEmpId(1L);
        System.out.println(employeeTaskByEmpId.getTaskName());
//        System.out.println(employeeTaskByEmpId.getTask().getContext());

    }

}

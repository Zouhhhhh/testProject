package cascade.mapper;

import cascade.pojo.Employee;

/**
 * @author zouhao
 * @date 2022/5/24
 */
public interface EmployeeMapper {

    Employee getEmployeeById(Long id);

}

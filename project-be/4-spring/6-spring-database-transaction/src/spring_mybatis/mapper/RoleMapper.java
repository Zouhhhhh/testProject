package spring_mybatis.mapper;

import org.springframework.stereotype.Repository;
import spring_mybatis.pojo.Role;

@Repository
public interface RoleMapper {

    public int insertRole(Role role);
}

package mapper;


import org.springframework.stereotype.Repository;
import pojo.Role;

@Repository
public interface RoleMapper extends BaseMapper {

    public Role getRole(Long id);

    public void insertRole(Role role);

}

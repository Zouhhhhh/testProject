package zhujie.mapper;

import zhujie.pojo.Role;
import org.apache.ibatis.annotations.Select;

public interface RoleMapper {
    @Select("SELECT id, role_name AS roleName, note FROM t_role WHERE id = #{id}")
    public Role getRole(Long id);
}

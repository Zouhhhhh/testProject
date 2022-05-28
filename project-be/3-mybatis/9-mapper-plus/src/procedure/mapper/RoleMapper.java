package procedure.mapper;

import procedure.pojo.Role;
import procedure.pojo.PdCountRoleParams;

public interface RoleMapper {
    Role getRole(Long id);

    Role findRoleByUserId(Long userId);

    void countRole(PdCountRoleParams params);

}

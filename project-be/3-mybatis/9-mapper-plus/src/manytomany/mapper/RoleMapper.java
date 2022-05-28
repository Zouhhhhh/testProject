package manytomany.mapper;

import manytomany.pojo.Role;

public interface RoleMapper {
    Role getRole(Long id);

    Role findRoleByUserId(Long userId);

}

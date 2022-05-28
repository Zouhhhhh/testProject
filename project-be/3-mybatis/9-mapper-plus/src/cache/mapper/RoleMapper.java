package cache.mapper;

import cache.pojo.Role;

public interface RoleMapper {
    Role getRole(Long id);

    Role findRoleByUserId(Long userId);

}

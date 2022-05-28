package cache.mapper;

import cache.pojo.User;

public interface UserMapper {
    User getUser(Long id);

    User findUserByRoleId(Long roleId);
}

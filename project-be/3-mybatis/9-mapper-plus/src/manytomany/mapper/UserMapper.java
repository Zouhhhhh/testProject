package manytomany.mapper;

import manytomany.pojo.User;

public interface UserMapper {
    User getUser(Long id);

    User findUserByRoleId(Long roleId);
}

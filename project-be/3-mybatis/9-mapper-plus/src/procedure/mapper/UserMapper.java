package procedure.mapper;

import procedure.pojo.User;

public interface UserMapper {
    User getUser(Long id);

    User findUserByRoleId(Long roleId);
}

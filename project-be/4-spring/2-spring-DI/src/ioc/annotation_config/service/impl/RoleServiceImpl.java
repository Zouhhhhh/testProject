package ioc.annotation_config.service.impl;

import ioc.annotation_config.pojo.Role;
import ioc.annotation_config.service.RoleService;
import org.springframework.stereotype.Component;

@Component
public class RoleServiceImpl implements RoleService {
    @Override
    public void printRoleInfo(Role role) {
        System.out.println("id=" + role.getId());
        System.out.println("roleName=" + role.getRoleName());
    }
}

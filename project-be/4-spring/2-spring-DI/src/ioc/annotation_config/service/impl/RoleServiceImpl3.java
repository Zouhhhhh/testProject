package ioc.annotation_config.service.impl;

import ioc.annotation_config.pojo.Role;
import ioc.annotation_config.service.RoleService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("roleService3")
@Primary
public class RoleServiceImpl3 implements RoleService {
    @Override
    public void printRoleInfo(Role role) {
        System.out.println("3:id=" + role.getId());
        System.out.println("3:roleName=" + role.getRoleName());
    }
}

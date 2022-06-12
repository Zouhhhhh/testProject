package ioc.annotation_config.controller;

import ioc.annotation_config.pojo.Role;
import ioc.annotation_config.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RoleController {
    @Autowired
    @Qualifier("roleService3")
    private RoleService roleService = null;

    public RoleService getRoleService() {
        return roleService;
    }

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    private void printRole(Role role) {
        roleService.printRoleInfo(role);
    }
}

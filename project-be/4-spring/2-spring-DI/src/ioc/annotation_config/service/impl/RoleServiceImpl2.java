package ioc.annotation_config.service.impl;

import ioc.annotation_config.pojo.Role;
import ioc.annotation_config.service.RoleService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleServiceImpl2 implements RoleService2 {

    @Autowired
    private Role role = null;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public void printRoleInfo() {
        System.out.println("id=" + role.getId());
        System.out.println("roleName=" + role.getRoleName());
    }
}

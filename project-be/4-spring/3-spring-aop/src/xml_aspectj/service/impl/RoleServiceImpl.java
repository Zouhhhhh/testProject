package xml_aspectj.service.impl;

import annocation_aspectj.pojo.Role;
import org.springframework.stereotype.Component;
import xml_aspectj.service.RoleService;

@Component
public class RoleServiceImpl implements RoleService {

    // 1. 选择切点
    @Override
    public void printRole(Role role) {
        System.out.println("roleName :" + role.getRoleName());
    }
}

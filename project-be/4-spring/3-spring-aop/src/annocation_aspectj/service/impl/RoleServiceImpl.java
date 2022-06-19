package annocation_aspectj.service.impl;

import annocation_aspectj.pojo.Role;
import annocation_aspectj.service.RoleService;
import org.springframework.stereotype.Component;

@Component
public class RoleServiceImpl implements RoleService {

    // 1. 选择切点
    @Override
    public void printRole(Role role) {
        System.out.println("roleName :" + role.getRoleName());
    }
}

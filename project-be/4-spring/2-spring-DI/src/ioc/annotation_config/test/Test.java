package ioc.annotation_config.test;

import ioc.annotation_config.pojo.ApplicationConfig;
import ioc.annotation_config.pojo.PojoConfig;
import ioc.annotation_config.pojo.Role;
import ioc.annotation_config.service.RoleService;
import ioc.annotation_config.service.impl.RoleServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Role role = (Role) ctx.getBean(Role.class);
        System.out.println(role.getRoleName());

        //
        RoleService roleService = ctx.getBean(RoleServiceImpl.class);
        roleService.printRoleInfo(role);
    }
}

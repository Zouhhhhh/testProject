package ioc.annotation_config.test;

import ioc.annotation_config.pojo.ApplicationConfig;
import ioc.annotation_config.service.RoleService2;
import ioc.annotation_config.service.impl.RoleServiceImpl2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test2 {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        RoleService2 roleService = ctx.getBean(RoleServiceImpl2.class);
        roleService.printRoleInfo();

    }
}

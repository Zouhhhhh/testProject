package annocation_aspectj.test;

import annocation_aspectj.config.AopConfig;
import annocation_aspectj.pojo.Role;
import annocation_aspectj.service.RoleService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AopConfig.class);
        RoleService roleService = ctx.getBean(RoleService.class, "roleService");
        roleService.printRole(new Role("管理员", "无"));
    }
}

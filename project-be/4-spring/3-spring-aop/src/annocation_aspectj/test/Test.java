package annocation_aspectj.test;

import annocation_aspectj.config.AopConfig;
import annocation_aspectj.pojo.Role;
import annocation_aspectj.service.RoleService;
import annocation_aspectj.service.RoleVerifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

//    public static void main(String[] args) {
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(AopConfig.class);
//        RoleService roleService = ctx.getBean(RoleService.class, "roleService");
//        roleService.printRole(new Role("管理员", "无"));
//    }

    // 增强了代理对象，追加实现RoleVerifier接口
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AopConfig.class);
        RoleService roleService = ctx.getBean(RoleService.class, "roleService");
        RoleVerifier roleVerifier = (RoleVerifier) roleService;
        Role role = new Role("管理员", "无");
        if (roleVerifier.verify(role)) {
            roleService.printRole(role);
        }
    }
}

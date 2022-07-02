package xml_aspectj.test;

import annocation_aspectj.pojo.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xml_aspectj.service.RoleService;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("xml_aspectj/applicationContext.xml");
        RoleService roleService = ctx.getBean(RoleService.class, "roleService");
        roleService.printRole(new Role("管理员", "无"));

    }
}

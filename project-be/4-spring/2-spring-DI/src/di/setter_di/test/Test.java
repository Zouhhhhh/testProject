package di.setter_di.test;

import di.setter_di.pojo.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("di/setter_di/applicationContext.xml");
        Role role = ctx.getBean(Role.class, "role");
        System.out.println(role.getRoleName());
        System.out.println(role.getNote());
    }
}

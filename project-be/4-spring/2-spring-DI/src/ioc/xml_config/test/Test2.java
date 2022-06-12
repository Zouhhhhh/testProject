package ioc.xml_config.test;

import ioc.xml_config.pojo.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ioc/xml_config/applicationContext2.xml");
        Role role1 = (Role) ctx.getBean("role1");
        System.out.println(role1.getId());
    }
}

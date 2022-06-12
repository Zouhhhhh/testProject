package ioc.xml_config.test;

import ioc.xml_config.pojo.ComplexAssembly;
import ioc.xml_config.pojo.UserRoleAssembly;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ioc.xml_config.pojo.Role;

import java.util.Map;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ioc/xml_config/applicationContext.xml");
        Role role = (Role) ctx.getBean("role2");    // 如果有两个同类型的则不能用getBean(Class, args);
        System.out.println(role.getRoleName());
        System.out.println(role.getNote());

        // 装配集合
        ComplexAssembly complexAssembly = ctx.getBean(ComplexAssembly.class, "complexAssembly");
        Map<String, String> map = complexAssembly.getMap();
        System.out.println(map.keySet());
        System.out.println(map.values());

        // 装配复杂对象
        UserRoleAssembly userRoleAssembly = ctx.getBean(UserRoleAssembly.class, "userRoleAssembly");
        System.out.println(userRoleAssembly.getId());
    }
}

package spring_mybatis.test;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_mybatis.pojo.Role;
import spring_mybatis.service.RoleListService;
import spring_mybatis.service.RoleService;

import javax.sql.DataSource;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_mybatis/applicationContext.xml");
        RoleService roleService = ctx.getBean(RoleService.class);
        int index = 2;
        int count = roleService.insertRole(new Role("role" + index, "not" + index));
        System.out.println(count);
    }
}

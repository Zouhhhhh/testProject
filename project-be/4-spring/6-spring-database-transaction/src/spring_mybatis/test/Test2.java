package spring_mybatis.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_mybatis.pojo.Role;
import spring_mybatis.service.RoleListService;
import spring_mybatis.service.RoleService;
import spring_mybatis.service.impl.RoleListServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_mybatis/applicationContext.xml");
        RoleListService roleListService = ctx.getBean(RoleListService.class);

        List<Role>  roleList = new ArrayList<>();
        for (int i=1; i<=2; i++) {
            Role role = new Role("role" + i, "note " + i);
            roleList.add(role);
        }

        int count = roleListService.insertRoleList(roleList);
        System.out.println(count);
    }
}

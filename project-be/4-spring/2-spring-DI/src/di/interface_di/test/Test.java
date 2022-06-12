package di.interface_di.test;

import di.interface_di.pojo.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("di/interface_di/applicationContext.xml");
        System.out.println(ctx.getApplicationName());
    }
}

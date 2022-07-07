package utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtils {

    public static ApplicationContext getCtx() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        return ctx;
    }

    public static Object getBean(Class clazz) {
        ApplicationContext ctx = getCtx();
        return ctx.getBean(clazz);
    }
}

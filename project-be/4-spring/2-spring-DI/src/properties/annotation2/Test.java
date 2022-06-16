package properties.annotation2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    @org.junit.Test
    public void test() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        String url = ctx.getEnvironment().getProperty("jdbc.database.url");
        System.out.println(url);

    }


}

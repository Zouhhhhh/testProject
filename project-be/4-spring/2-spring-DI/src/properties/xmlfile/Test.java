package properties.xmlfile;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class Test {

    @org.junit.Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("properties/xmlfile/applicationContext.xml");
        DataSource dataSource = ctx.getBean(DataSource.class, "dataSource");
        System.out.println(dataSource.getClass());
//        String url = ctx.getEnvironment().getProperty("jdbc.database.url");
//        System.out.println(url);
    }


}

package profile;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.Properties;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ProfileConfig.class)
@ActiveProfiles("dev")
public class ProfileTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void test() {
        System.out.println(dataSource.getClass().getName());
    }

    // 报错
    @Test
    public void test2() {
        Properties props = new Properties();
        props.setProperty("driver", "com.mysql.jdbc.Driver");
        props.setProperty("url", "jdbc:mysql://localhost:3306/test2");
        props.setProperty("username", "root");
        props.setProperty("password", "root");

        try {
            DataSource dataSource1 = BasicDataSourceFactory.createDataSource(props);
            System.out.println(dataSource1.getClass().getName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}

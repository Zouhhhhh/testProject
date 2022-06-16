package profile;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.DataSourceFactory;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Properties;

@Component
public class ProflieDataSource {

    @Bean(name = "devDataSource")
    @Profile("dev")
    public DataSource getDevDataSource() {
//        Properties props = new Properties();
//        props.setProperty("driver", "com.mysql.jdbc.Driver");
//        props.setProperty("url", "jdbc:mysql://localhost:3306/test");
//        props.setProperty("username", "root");
//        props.setProperty("password", "root");

        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "root";

        DataSource dataSource = null;

        try {
//            dataSource = BasicDataSourceFactory.createDataSource(props);
            dataSource = new DriverManagerDataSource(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    @Bean(name = "testDataSource")
    @Profile("test")
    public DataSource getTestDataSource() {
        Properties props = new Properties();
        props.setProperty("driver", "com.mysql.jdbc.Driver");
        props.setProperty("url", "jdbc:mysql://localhost:3306/test2");
        props.setProperty("username", "root");
        props.setProperty("password", "root");
        DataSource dataSource = null;

        try {
            dataSource = BasicDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }

}

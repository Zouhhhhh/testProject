package properties.annotation2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.util.Properties;

public class DataSourceBean {

    @Value("${jdbc.database.driver}")
    private String driver = null;

    @Value("${jdbc.database.url}")
    private String url = null;

    @Value("${jdbc.database.username}")
    private String username = null;

    @Value("${jdbc.database.password}")
    private String password = null;

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        Properties props = new Properties();
        props.setProperty("driver", driver);
        props.setProperty("url", url);
        props.setProperty("username", username);
        props.setProperty("password", password);

        DataSource dataSource = null;

        try {
//            dataSource = BasicDataSourceFactory.createDataSource(props);
            dataSource = new DriverManagerDataSource(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;

    }

}



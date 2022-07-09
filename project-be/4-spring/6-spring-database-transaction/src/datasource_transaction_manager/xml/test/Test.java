package datasource_transaction_manager.xml.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("datasource_transaction_manager/xml/applicationContext.xml");
        DataSource dataSource = ctx.getBean(DataSource.class);
        JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);
        DataSourceTransactionManager dataSourceTransactionManager = ctx.getBean(DataSourceTransactionManager.class);
        System.out.println(dataSourceTransactionManager.getDataSource() == dataSource);
    }
}

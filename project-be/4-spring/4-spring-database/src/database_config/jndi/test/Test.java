package database_config.jndi.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("database_config/jndi/applicationContext.xml");
        DataSource dataSource = ctx.getBean(DataSource.class, "dataSource");
        ResultSet resultSet = null;
        String sql = "SELECT * FROM user";
        try(Connection connection = dataSource.getConnection();PreparedStatement statement = connection.prepareStatement(sql)) {

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                System.out.println(id + " - " + name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

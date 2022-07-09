package transaction_type.code.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("datasource_transaction_manager/xml/applicationContext.xml");
        JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);
        // 事务管理器
        PlatformTransactionManager transactionManager = ctx.getBean(PlatformTransactionManager.class);
        // 事务定义类
        TransactionDefinition def = new DefaultTransactionDefinition();
        // 事务状态（通过管理器根据定义获取）
        TransactionStatus status = transactionManager.getTransaction(def);

        try {
            // 通过jdbcTemplate，执行SQL语句
            // jdbcTemplate本身的数据库资源已经由事务管理器管理，因此当它执行完insert语句时不会自动提交。
            jdbcTemplate.update("INSERT INTO role (role_name, note) VALUES ('role_name_transaction', 'note_transaction')");
            // 提交事务
            transactionManager.commit(status);
        } catch (Exception e) {
            e.printStackTrace();
            transactionManager.rollback(status);
        }
    }
}

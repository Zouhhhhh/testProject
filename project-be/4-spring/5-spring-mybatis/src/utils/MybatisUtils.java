package utils;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class MybatisUtils {

    public static ApplicationContext getCtx() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        return ctx;
    }
    public static DataSource getDataSource() {
        DataSource dataSource = getCtx().getBean(DataSource.class);
        return dataSource;
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        SqlSessionFactory sqlSessionFactory = getCtx().getBean(SqlSessionFactory.class);
        return sqlSessionFactory;
    }

}

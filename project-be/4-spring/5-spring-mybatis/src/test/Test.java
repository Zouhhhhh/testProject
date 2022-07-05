package test;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import utils.MybatisUtils;

import javax.sql.DataSource;

public class Test {
    public static void main(String[] args) {
        DataSource dataSource = MybatisUtils.getDataSource();
        SqlSessionFactory sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        System.out.println(sqlSessionFactory);
        int i = 0;
    }
}

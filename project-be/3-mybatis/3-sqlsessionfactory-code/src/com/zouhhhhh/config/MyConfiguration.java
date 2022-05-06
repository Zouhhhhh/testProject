package com.zouhhhhh.config;

import com.zouhhhhh.mapper.RoleMapper;
import com.zouhhhhh.pojo.Role;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;


public class MyConfiguration {

    public static SqlSessionFactory getSqlSessionFactory() {
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/ssm");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setDefaultAutoCommit(false);

        // 采用Mybatis的JDBC事务方式
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);

        // 创建Configuration对象
        Configuration configuration = new Configuration(environment);
        // 注册一个Mybatis的上下文别名
        configuration.getTypeAliasRegistry().registerAlias("role", Role.class);
        // 加入一个映射器
        configuration.addMapper(RoleMapper.class);
        // 使用SqlSessionFactoryBuild创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        return sqlSessionFactory;
    }

}

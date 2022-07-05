配置Mybatis-Spring项目需要这么几步：
1. 配置数据源，参考前面
2. 配置SqlSessionFacotry
   在applicationContext.xml配置了SqlSessionFactoryBean，然后指定了mybatis的配置文件sqlMapConfig.xml。在sqlMapConfig配置了一些mybatis的Setting和指定mapper文件的位置，然后配置一个RoleMapper.xml文件和一个接口。


3. 可以选择的配置有SqlSessionTemplate，同时配置配置SqlSessionFactory，优先采用SqlSessionTemplate
    SqlSessionTemplate并不是一个必须配置的组件，但是它也存在一定的价值。它是线程安全的类，确保每个线程使用的SqlSession唯一且不冲突。它提供了一系列增删改查的功能。



4. 配置Mapper
5. 事务管理


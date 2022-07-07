配置Mybatis-Spring项目需要这么几步：
1. 配置数据源，参考前面
2. 配置SqlSessionFacotry
   - 在applicationContext.xml配置了SqlSessionFactoryBean，然后指定了mybatis的配置文件sqlMapConfig.xml。在sqlMapConfig配置了一些mybatis的Setting和指定mapper文件的位置，然后配置一个RoleMapper.xml文件和一个接口。


3. 可以选择的配置有SqlSessionTemplate，同时配置配置SqlSessionFactory，优先采用SqlSessionTemplate
    - SqlSessionTemplate并不是一个必须配置的组件，但是它也存在一定的价值。它是线程安全的类，确保每个线程使用的SqlSession唯一且不冲突。它提供了一系列增删改查的功能。 
    - 注意：当运行一个SqlSessionTemplate时，它会重新获取一个新的SqlSession，所以灭一个方法都是独立的SqlSession。


4. 配置Mapper
   - 从SqlSessionTemplate可以看出，有点类似于SqlSession，可以用它的方法执行insert或select，实际上运行还是它会去生成一个SqlSession并调用指定的某个Mapper里的方法。但是习惯于还是给我一个Mapper接口或者对象，我去直接调用方法比较方便。
   - 既然要结合spring框架，那肯定是把Mapper注册为Bean，我能直接从Context容器里拿Bean就好了——MapperFactorBean
5. 事务管理


# Mybatis配置
    本章的任务是了解Mybatis配置项的作用，其中properties、settings、typeAliases、typeHandler、plugin、environments、mappers是常用的内容。
    
## 1、properties属性
    properties属性可以给系统配置一些运行参数，可以放在XML文件或者properties文件中，而不是放在Java编码中，方便参数修改，不会引起代码的重新编译。
    3种方式使用properties：
    - property子元素
    - properties文件
    - 程序代码传递
    优先级从下往上

## 2、settings设置
    settings是Mybatis中最复杂的配置，它能深刻影响Mybatis底层的运行，但是在大部分情况下使用默认值就可以运行，所以大部分情况下不需要大量配置，只需要修改一些常用的规则即可
    比如自动映射、驼峰命名映射、级联规则、是否启动缓存、执行器（Executor）类型

## 3、typeAliases别名
    在Mybatis中别名由类TypeAliasRegistry去定义。注意在Mybatis中别名不区分大小写
    - 系统定义别名，初始化了一些数据类型的别名如Long的别名是long
    - 自定义别名，在xml中有两种方式，一种直接通过<typeAlias>标签定义，另一种是扫描包
    
## 4、typeHandler类型转换器
    在JDBC中，需要在PreparedStatement对象中设置已编译过的SQL语句的参数，执行SQL后，会通过ReSultSet对象获取得到数据库的数据。
    而这些，Mybatis是根据数据的类型，通过typeHandler来实现的。在typeHandler中，分为jdbcType和javaType，分别对应数据库类型和java类型，那么typeHandler的作用就是承担jdbcType和javaType之间的相互转换。
    - 系统定义typeHandler
    - 自定义typeHandler（先写好MyTypeHandler实现接口，然后在xml注册这个typeHandler，最后还可以显示启用typeHandler）
    - 枚举typeHandler
        在绝大多数情况下，typeHandler因为枚举而使用，mybatis已经定义了两个类作为枚举类型的支持，分别是EnumOrdinalTypeHandler和EnumTypeHandler
        - EnumOrdinalTypeHandler: 按Mybatis根据枚举数组下标索引的方式进行匹配，也是枚举类型的默认转换类，它要求数据库返回一个整数作为其下标，它会根据下标找出对应的枚举类型。
        - EnumTypeHandler：会把使用的名称转化为对应的枚举，比如根据数据库返回的字符串“MALE”,进行Enum.valueOf(SexEnum.class, "MALE")的转换
        - 自定义枚举：
    - 文件操作
   
## 5、ObjectFactory（对象工厂）
	当创建结果集时，Mybatis会使用一个对象工厂来完成创建这个结果集实例。默认使用-DefaultObjectFactory

## 6、插件

## 7、environments（运行环境）
    主要作用是配置数据库信息，可以配置多个。它可以分为两个可配置的元素，事务管理器(TransactionManager)和数据源(dataSource)。
    - 事务管理器：
        transactionManager提供了两个实现类（JdbcTransaction和ManagedTransaction），它需要实现接口transaction。从接口代码可知，它的主要工作就是提交、回滚和关闭数据库的事务。
        于是对应着两种工厂：JdbcTransactionFactory和ManagedTransactionFactory，工厂需要实现TransactionFactory接口，通过他们会生成对应的Transaction对象
        所以可以配置以下两种事务管理器
            - <transactionManager type="JDBC"/>，以jdbc的方式提交和回滚事务
            - <transactionManager type="MANAGED"/>，它的提交和回滚不用任何操作，而是把事务交给容器管理，默认情况下会关闭连接。
    - 数据源环境：
        通过PooledDataSourceFactory、UnpooledDataSourceFactory和JndiDataSourceFactory三个工厂类来提供，最后生成一个实现了DataSource接口的数据库连接对象

## 8、databaseIdProvider数据库厂商标识


## 9、引入映射器的方法
    首先，定义接口RoleMapper
    其次、给出XML文件RoleMapper.xml
        <mapper namespace="config.typehandler.myenumtypehandler.UserMapper">
        </mapper>
    引入映射器的方法，有以下几种：
        - 用文件路径引入映射器
            <mappers>
                <mapper resource="com/lean/ssm/character3/mapper/RoleMapper.xml"></mapper>
            </mappers>
        - 用包名引入映射器
            <mappers>
                <package name="com.zouhhhhh.mapper"></package>
            </mappers>
        - 用类注册引入映射器
            <mappers>
                <mapper class="com.zouhhhhh.mapper.RoleMapper"></mapper>
            </mappers>
        - 用userMapper.xml引入映射器
            
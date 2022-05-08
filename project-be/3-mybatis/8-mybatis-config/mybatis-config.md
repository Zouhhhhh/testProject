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
   
## 5、ObjectFactory（对象工厂）
    
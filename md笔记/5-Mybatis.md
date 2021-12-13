# 四、Mybatis



环境：

- JDK1.8
- Mysql 5.7
- maven 3.6.1
- IDEA



回顾：

- jDBC
- Mysql
- Java基础
- Maven
- Junit



SSM框架：配置文件的。最好的方式：看官方文档

## 01-简介

### 1.1 什么是 MyBatis？

MyBatis 是一款优秀的**持久层框架**，它支持自定义 SQL、存储过程以及高级映射。MyBatis 免除了几乎所有的 JDBC 代码以及设置参数和获取结果集的工作。MyBatis 可以通过简单的 XML 或注解来配置和映射原始类型、接口和 Java POJO（Plain Old Java Objects，普通老式 Java 对象）为数据库中的记录。





如何获得Mybatis

- maven仓库

```xml
<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.5.2</version>
</dependency>
```



- GitHub
- 中文文档



### 1.2 持久化

数据持久化

- 持久化就是将程序的数据在持久状态和瞬时状态转化的过程
- 数据库（jdbc）、io文件持久化



### 1.3 持久层

Dao层、Service层、Controller层

- 完成持久化工作的代码块
- 层界限十分明显



### 1.4 为什么需要Mybatis

- 帮助程序员将数据存入到数据库中
- 方便
- 传统的JDBC代码太复杂。简化、框架、自动化
- 不用Mybatis也可以，更容易上手
- 优点：
    - 简单易学：本身就很小且简单。没有任何第三方依赖，最简单安装只要两个jar文件+配置几个sql映射文件易于学习，易于使用，通过文档和源代码，可以比较完全的掌握它的设计思路和实现。
    - 灵活：mybatis不会对应用程序或者数据库的现有设计强加任何影响。 sql写在xml里，便于统一管理和优化。通过sql语句可以满足操作数据库的所有需求。
    - 解除sql与程序代码的耦合：通过提供DAO层，将业务逻辑和数据访问逻辑分离，使系统的设计更清晰，更易维护，更易单元测试。sql和代码的分离，提高了可维护性。
    - 提供映射标签，支持对象与数据库的orm字段关系映射
    - 提供对象关系映射标签，支持对象关系组建维护
    - 提供xml标签，支持编写动态sql。 

最重要的一点：使用的人多！

Spring、SpringMVC、SpringBoot、SpringCloud



## 02-第一个Mybatis程序



思路：搭建环境、导入Mabtis、编写代码、测试



### 2.1 搭建环境

搭建数据库

user表、字段有id、name、pwd

新建项目

1. 新建一个maven项目
2. 删除src目录
3. 导入依赖
    - mysql驱动
    - mybatis
    - junit



### 2.2 创建一个模块



### 2.3 编写代码

- 编写mybatis的核心配置文件

    ```xml
    mybatis-config.xml
    
    <?xml version="1.0" encoding="UTF-8" ?>
    <!DOCTYPE configuration
            PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
            "http://mybatis.org/dtd/mybatis-3-config.dtd">
    
    <!-- mybatis核心配置文件 -->
    <configuration>
        <environments default="development">
            <environment id="development">
                <transactionManager type="JDBC"/>
                <dataSource type="POOLED">
                    <property name="driver" value="com.mysql.jdbc.Driver"/>
                    <property name="url" value="jdbc:mysql://localhost:3306/mybatis?useSSL=true$amp;useUnicode=true$amp;characterEncoding=UTF-8"/>
                    <property name="username" value="root"/>
                    <property name="password" value="root"/>
                </dataSource>
            </environment>
        </environments>
        <!-- 注册mapper -->
    <!--    <mappers>-->
    <!--        <mapper resource="org/mybatis/example/BlogMapper.xml"/>-->
    <!--    </mappers>-->
    </configuration>
    ```

    

- 编写mybatis工具类

```java
//sqlSessionFactory --> sqlSession
public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory;

    static{
        try {
            //使用Mybatis第一步：获取sqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 既然有了 SqlSessionFactory，顾名思义，我们可以从中获得 SqlSession 的实例。
    // SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }
    
}

```



- 编写实体类User



- 编写Mapper（就是之前的Dao接口）

    ```java
    public interface UserMapper {
    
        List<User> getUserList();
    
    }
    ```



- 接口实现类（由原来的DaoImpl，转为使用UserMapper.xml）

```java
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!--namespace=绑定一个对应的Dao/Mapper接口-->
<mapper namespace="com.kuang.mapper.UserMapper">

    <select id="getUserList" resultType="com.kuang.pojo.User">
    select * from mybatis.user where id = #{id}
    </select>

</mapper>
```





### 2.4 测试

- junit测试

```java
	@Test
    public void test() {
        //第一步:获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一:getMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }

        //关闭SqlSession
        sqlSession.close();
    }
```



错误1：没有注册mapper文件，在mybatis核心配置文件中设置

```xml
<mappers>    
    <mapper resource="com.kuang.dao/UserMapper.xml"/>
</mappers>
```



错误2：maven的配置文件默认放在resource，所以写在mapper层的那个配置文件无法被导入，maven解决：

![1635176846087](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1635176846087.png)



错误3：核心配置文件里面的连接数据库，那个&ams;，写成了$ams



## 03-CRUD



userMapper

```java
public interface UserMapper {
    List<User> getUserList();
    User getUserById(int id);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
}
```



userMapper.xml

```xml
    <select id="getUserList" resultType="com.kuang.pojo.User">
    select * from mybatis.user
    </select>

    <select id="getUserById" resultType="com.kuang.pojo.User" parameterType="int">
    select * from mybatis.user where id = #{id}
    </select>

    <select id="addUser" parameterType="com.kuang.pojo.User">
    insert into mybatis.user values (#{id}, #{name}, #{pwd})
    </select>

    <select id="updateUser" parameterType="com.kuang.pojo.User">
    update mybatis.user set name = #{name}, pwd = #{pwd} where id = #{id}
    </select>

    <select id="deleteUser" parameterType="com.kuang.pojo.User">
    delete from mybatis.user where id = #{id} and name = #{name}
    </select>
```



Test

```java
    @Test
    public void testDeleteUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(new User(2, "修改2 ", "修改2"));

        sqlSession.commit();	//增删改需要commit
        sqlSession.close();
    }
```



注：在工具类获取SqlSession时可以设置参数为true，默认提交，就不用增删改手动执行com'mit了





## 04-配置解析

4.1 核心配置文件

mybatis-config.xml

- configuration（配置）
    - [properties（属性）](https://mybatis.org/mybatis-3/zh/configuration.html#properties)
    - [settings（设置）](https://mybatis.org/mybatis-3/zh/configuration.html#settings)
    - [typeAliases（类型别名）](https://mybatis.org/mybatis-3/zh/configuration.html#typeAliases)
    - [typeHandlers（类型处理器）](https://mybatis.org/mybatis-3/zh/configuration.html#typeHandlers)
    - [objectFactory（对象工厂）](https://mybatis.org/mybatis-3/zh/configuration.html#objectFactory)
    - [plugins（插件）](https://mybatis.org/mybatis-3/zh/configuration.html#plugins)
    - environments（环境配置）
        - environment（环境变量）
            - transactionManager（事务管理器）
            - dataSource（数据源）
    - [databaseIdProvider（数据库厂商标识）](https://mybatis.org/mybatis-3/zh/configuration.html#databaseIdProvider)
    - [mappers（映射器）](https://mybatis.org/mybatis-3/zh/configuration.html#mappers)



4.2 环境配置(environments)

mybatis可以配置成适应多种环境，但每个SqlSessionFactory实例只能选择一种环境

学会使用配置多套运行环境

Mybatis默认的事务管理器就是JDBC，连接池：POOLED



4.3 属性(properties)

通过属性来引用配置文件

 这些属性可以在外部进行配置，并可以进行动态替换。你既可以在典型的 Java 属性文件中配置这些属性，也可以在 properties 元素的子元素中设置。 

```java
	<properties resource="db.properties">
        <property name="password" value="root"/>
    </properties>
```



4.4 别名

就是在UserMapper.xml文件设置com.kuang.pojo.User时很麻烦

```xml
	<select id="getUserList" resultType="com.kuang.pojo.User">
    select * from mybatis.user
    </select>
```

所以可以在核心配置文件mybatis-config.xml中设置别名，这可以自定义别名

```xml
    <typeAliases>
        <typeAlias type="com.kuang.pojo.User" alias="User"/>
    </typeAliases>
```

或者

```xml
    <typeAliases>
        <package name="com.kuang.pojo.User"/>
    </typeAliases>
```

这样在UserMapper.xml文件中就只写User即可。



4.5 设置 （Setting）

| 设置名                   | 描述                                                         | 有效值        | 默认值 |
| :----------------------- | :----------------------------------------------------------- | :------------ | :----- |
| cacheEnabled             | 全局性地开启或关闭所有映射器配置文件中已配置的任何缓存。     | true \| false | true   |
| lazyLoadingEnabled       | 延迟加载的全局开关。当开启时，所有关联对象都会延迟加载。 特定关联关系中可通过设置 `fetchType` 属性来覆盖该项的开关状态。 | true \| false | false  |
| mapUnderscoreToCamelCase | 是否开启驼峰命名自动映射，即从经典数据库列名 A_COLUMN 映射到经典 Java 属性名 aColumn。 | true \| false | False  |

4.6 其他配置



4.7 映射器（mappers）

 就是核心配置文件如何找到UserMapper.xml映射文件

方式一：

```xml
    <mappers>
        <mapper resource="com/kuang/dao/UserMapper.xml"/>
    </mappers>
```

方式二：

```xml-dtd
    <mappers>
        <mapper class="com.kuang.dao.UserMapper.xml"/>
    </mappers>
```

注意点：

- UserMapper.xml和接口必须在同一个包下
- 必须同名



方式三：

```xml
<mappers>
  <package name="com.kuang.dao.UserMapper.xml"/>
</mappers>
```

注意点：

- UserMapper.xml和接口必须在同一个包下
- 必须同名



4.8 生命周期和作用域

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1635594337336.png" alt="1635594337336" style="zoom:50%;" />

## 05-ResultMap

当POJO的User的属性password与数据库的字段pwd不一致，查出来的就是null。

有两种方式解决，一是在sql中加别名pwd as password

二是使用resultmap（这里的User在核心配置文件设置了别名）

```xml
原来的UserMapper.xml
<mapper namespace="com.kuang.dao.UserMapper">
    <select id="getUserList" resultType="User">
    select * from mybatis.user
    </select>
</mapper>
```

使用resultMap

```xml
<mapper namespace="com.kuang.dao.UserMapper">
    <resultMap id="User" type="User">
        <result column="pwd" property="password"></result>
    </resultMap>
    
    <select id="getUserList" resultMap="User">
    select * from mybatis.user
    </select>
</mapper>
```

## 06-日志

### 6.1 日志工厂

曾经：sout、debug

现在：日志工厂

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1635598053039.png" alt="1635598053039" style="zoom:50%;" />

- SLF4J 
- LOG4J 【掌握】
- LOG4J2 
- JDK_LOGGING
- COMMONS_LOGGING 
- STDOUT_LOGGING【掌握】
- NO_LOGGING 



先使用一下自带的STDOUT_LOGGING

```xml
    <settings>
        <setting name="logImpl" value="STDOUT_LOGGING"/>
    </settings>
```



### 6.2 Log4j

1. 先导包

    ```xml
    <!-- https://mvnrepository.com/artifact/log4j/log4j -->
    <dependency>
        <groupId>log4j</groupId>
        <artifactId>log4j</artifactId>
        <version>1.2.17</version>
    </dependency>
    ```

2. log4j.properties

    <img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1635599822778.png" alt="1635599822778" style="zoom:67%;" />



3. 核心配置文件中设置

    ```xml
        <settings>
            <setting name="logImpl" value="LOG4J"/>
        </settings>
    ```

    

 简单使用

1. 在要使用log4j的类中，导入包apache.log4j.Logger

2. 日志对象，参数为当前类的class

    ```java
        static Logger logger = Logger.getLogger(UserMapperTest.class);
    ```

3. 日志级别（不懂）

    ```java
    logger.info("info:进入了testLog4j方法");
    logger.debug("info:进入了debug方法");
    logger.error("info:进入了error方法");
    ```



## 07-分页



7.1 使用limit分页

select * from user limit 3



7.2 使用Mybatis实现分页



7.3 RowBounds实现分页



7.4 分页插件



## 08-注解开发



8.1 面向接口编程





8.2 在Dao上使用注解，代替UserMapper.xml

```java
public interface UserMapper {
    @Select("select * from mybatis.user")
    List<User> getUserList();
}
```

同时在核心配置中需要绑定接口

```xml
<mappers>
    <mapper class="com.kuang.dao.UserMapper"/>
</mappers>
```



本质：反射机制实现

底层：动态代理



## 09-Mybatis详细的执行流程

```java
public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory;

    static{
        try {
            //使用Mybatis第一步：获取sqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 既然有了 SqlSessionFactory，顾名思义，我们可以从中获得 SqlSession 的实例。
    // SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }

}
```

主要就是分析从SqlSessionFactory的构造到sql的执行流程。

new SqlSessionFactoryBuilder().build(inputStream)

build里面

new XMLConfigBuilder(inputStream, environment, properties);

会先构造一个全局配置Configuration出来，然后解析mybatis‘的配置文件流，拿到所有的配置信息。

然后返回一个SqlSessionFactory，可以断点看到它里面有一个configuration对象，里面存了mybatis的所有配置信息了，并且还有一个transactional事务管理器和executor执行器



## 10-注解实现CRUD

```java
public interface UserMapper {

    @Select("select * from mybatis.user")
    List<User> getUserList();

    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int id);

    @Insert("insert into user (id,name,pwd) values (#{id},#{name},#{pwd})")
    int add(User user);

    @Update("update user set name = #{name}, pwd = #{pwd} where id = #{id}")
    int update(User user);

    @Delete("delete from user where id = #{uid}")
    int delete(@Param("uid") int id);

}
```

主要就是用相应的注解，以及@Param设置参数，还有设置开启自动提交事务

关于@Param：

- 基本类型以及String参数，需要加上
- 引用类型不需要
- 只有一个基本类型可以省略



## 11-Lombok

第三方工具，可以省略写Getter和Setter等，只需要用注解完成即可



1. 在IDEA安装插件

2. 添加maven

3. 注解：

    ```java
    @NoArgsConstructor：生成无参构造器；
    @AllArgsConstructor：生成全参构造器
    @Data：生成get、set、有参构造无参构造、equals、hashcode
    ```



## 12-多对一的处理（实体里有对象属性）



搭建复杂查询测试环境

1. 导入lombok
2. 新建实体类Teacher、Student
3. 建立Mapper接口
4. 建立Mapper.xml文件
5. 在核心配置文件中绑定注册我们的Mapper接口或文件
6. 测试查询是否成功



查询学生信息并带上老师信息

```java
public class Student {
    private int id;
    private String name;
    
    private Teacher teacher;
       
}
```



按照查询嵌套处理

```xml
<select id="getStudent" resultMap="StudentTeacher">
    select * from student
</select>
<resultMap id="StudentTeacher" type="Student">
	<result property="id" column="id"/>
    <result property="name" column="name"/>
    
    <!-- 对象：association   集合：collection -->
    <association property="teacher" column="tid" javaType="Teacher" select="getTeacher"/>

</resultMap>

<select id="getTeacher" resultType="Teacher">
	select * from teacher where id=#{tid}
</select>

```



按照结果嵌套查询

```xml
<select id="getStudent2" resultMap="StudentTeacher2">
	select s.id sid, s.name sname, t.name tname
    from student s, teacher t
    where s.id = t.id;
</select>

<resultMap id="StudentTeacher2" type="Student">
	<result property="id" column="sid"/>
    <result property="name" column="sname"/>
    <association property="teacher" javaType="Teacher">
    	<result property="name" column="tname"/>
    </association>
</resultMap>

```



## 13-一对多处理（实体里有集合属性）

```java
public class Teacher {
    private int id;
    private String name;
    
    private List<Student> students;
       
}
```



```xml
<select id="getTeacher" resultMap="TeacherStudent">
	select s.id sid, s.name sname, t.name tname, t.id tid
    from student s, teacher t
    where s.id = t.id and t.id = #{tid};
</select>

<resultMap id="TeacherStudent" type="Teacher">
	<result property="id" column="tid"/>
    <result property="name" column="tname"/>
    
    <!-- 集合 -->
    <collection property="students" ofType="Student">
    	<result property="id" column="sid"/>
        <result property="name" column="sname"/>
        <result property="tid" column="tid"/>
    </collection>
    
</resultMap>
```



子查询的方式，类似上面的多对一



注意点：

- 保证SQL的可读性
- 不要写慢SQL





**面试高频！！！**

- Mysql引擎
- InnoDB底层原理
- 索引
- 索引优化





## 14-动态SQL



动态SQL：就是根据不同的查询条件生成不同的SQL



- if
- choose (when, otherwise)
- trim (where, set)
- foreach





搭建环境

数据库表：博客表blog



创建工程

1. 导包
2. 编写配置文件
3. 编写实体类
4. 编写实体类对应Mapper接口和Mapper.xml文件





14.1 IF

```xml
BlogMapper.xml

<select id="queryBlogIF" parameterType="map" resultType="blog">
	select * from mybatis.blog where 1=1
    <if test="title != null">
    	and title = #{title}
    </if>
    <if test="author != null">
    	and author = #{author}
    </if>
</select>
```



14.2 where

<where>标签只会在至少有一个子元素的条件返回SQL子句的情况下才去插入“where”语句，而且如果语句的开头为AND，会自动去掉

```xml

<select id="queryBolgChoose" parameterType="map" resultTyoe="blog">
	select * from mybatis.blog 
    <where>
        <if test="title != null ">
            title = #{title}
        </if>
        
        <if test="author != null">
        	and name = #{name}
        </if>
    </where>
</select>
```



14.3 choose，when，



```xml

<select id="queryBolgChoose" parameterType="map" resultTyoe="blog">
	select * from mybatis.blog 
    <where>
        
        <choose>
        	<when test="title ! = null">
            	title = #{title}
            </when>

            <when test="author ! = null">
            	author = #{author}
            </when>
        </choose>
        
    </where>
</select>
```





### 14.4 SQL片段：抽取复用SQL

<sql>

<include>







## 15-缓存

### 15.1 简介



### 15.2 Mybatis缓存



### 15.3 一级缓存



### 15.4 二级缓存



### 15.5 缓存原理

![1636561423292](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1636561423292.png)





### 15.6 自定义缓存ehcache
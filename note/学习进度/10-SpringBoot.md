# SpringBoot



阶段六：

- SpringBoot
    - 是什么
    - 配置如何编写 yaml
    - **自动装配原理**（难）
    - 集成Web开发：业务的核心
    - 集成数据库 Druid
    - 分布式开发：Dubbo（RPC） + zookeeper
    - swagger：接口文档
    - 任务调度
    - SpringSecurity  /  Shiro
- Linux部署
- SpringCloud
    - 微服务
    - 入门
    - Restful接口
    - Eureka服务注册
    - Nginx
    - Ribbon负载均衡
    - Feign
    - HyStrix熔断
    - Zuul路由网关
    - SpringCloud  config ：git





## 一、helloworld

1. spring init创建springboot项目
2. pom里面有依赖，以及打包工具，将项目打包成jar包，然后运行
3. 配置文件改端口
4. server.port=8081
5. banner.txt改启动时候的图形



## 二、自动装配原理（难）

2.1 pom.xml

- spring-boot-dependencies：核心依赖在父工程中
- 不需要加版本



2.2 启动器

```xml
<dependency>    
    <groupId>org.springframework.boot</groupId>    
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

**springboot-boot-starter-xxx**：就是spring-boot的场景启动器

**spring-boot-starter-web**：帮我们导入了web模块正常运行所依赖的组件；

SpringBoot将所有的功能场景都抽取出来，做成一个个的starter （启动器），只需要在项目中引入这些starter即可，所有相关的依赖都会导入进来 ， 我们要用什么功能就导入什么样的场景启动器即可 ；我们未来也可以自己自定义 starter；



2.3 主程序

 @SpringBootApplication 来标注一个主程序类 ， 说明这是一个Spring Boot应用

	@SpringBootConfiguration，springboot配置类
		@Configuration，spring配置类
			@component，是一个spring的组件
	@EnableAutoConfiguration，自动配置
		@AutoConfigurationPackage，自动配置包
		@Import({AutoConfigurationImportSelector.class})


  META-INF/spring.factories ：自动配置的核心文件



结论：springboot所有的自动配置都在启动类的时候扫描并加载“spring.factories”，但是不一定生效，要判断是否成立（@Condition），只要导入了对应的start，就有对应的启动器，自动装配就会生效。



## 三、配置文件yaml

1. 语法

Key-value

```xml
server-port: 8080
```

对象

```xml
person:
	name: zou
	age: 18
```

数组

```xml
pets:
	- dog
	- cat
```



2. 配置参数类

写好一个配置参数类Person

```java
@Component
@ConfigurationProperties(prefix = "person")
public class Person {

    private String name;
    private int age;
    
    //省略get，set
}
```

@Component表示是一个bean

@ComfigurationProperties表示是一个配置参数类，并且prefix = "person"对应yaml文件里的参数



yaml配置

```xml
person:
  name: zouhao
  age: 18
```

还能加el表达式

```xml
person:
  name: zouhao${random.uuid}
  age: ${random.int}
```



就可以在测试类中@Autowired注入person，然后拿到参数



与properties的对比

![1640408647203](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1640408647203.png)



1、@ConfigurationProperties只需要写一次即可 ， @Value则需要每个字段都添加

2、**松散绑定**：这个什么意思呢? 比如我的yml中写的last-name，这个和lastName是一样的， - 后面跟着的字母默认是大写的。这就是松散绑定。可以测试一下

3、**JSR303数据校验** ， 这个就是我们可以在字段是增加一层过滤器验证 ， 可以保证数据的合法性

4、复杂类型封装，yml中可以封装对象 ， 使用value就不支持



JSR303校验

![1640409595078](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1640409595078.png)

注意：

要导入这个依赖

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
    <version>2.3.3.RELEASE</version>
</dependency>
```

以及导包

```java
import javax.validation.constraints.Email;
```



## 四、多环境配置以及配置文件位置

 Spring Boot will automatically find and load `application.properties` and `application.yaml` files from the following locations when your application starts: 

1. From the classpath
    1. The classpath root
    2. The classpath `/config` package
2. From the current directory
    1. The current directory
    2. The `/config` subdirectory in the current directory
    3. Immediate child directories of the `/config` subdirectory



**配置文件加载顺序**

1. 根目录下，创建config文件夹，创建application.yaml
2. 根目录下，创建application.yaml
3. resources目录下，创建config文件夹，创建application.yaml
4. resources目录下，创建application.yaml

当有properties和yaml同时存在时，先加载properties的



**多环境切换**

properties文件

(1)application.properties

```xml
#多环境切换
spring.profiles.active=dev
```

(2)application-dev.properties

```xml
server.port=8082
```



yaml文件

application.yaml

```xml
server:
  port: 8081
person:
  name: zouhao${random.uuid}
  age: ${random.int}

spring:
  profiles:
    active: dev

---
server:
  port: 8082
spring:
  profiles: dev


---
server:
  port: 8083
spring:
  profiles: test
```



用---分割文件，但是里面设置profiles名的方式已经被废弃了，换成下面这种

```xml
spring:
  config:
    activate:
      on-profile: test
```













## 五、深入理解自动装配原理（难）







Spring底层注解，@ConditionalOnXXX，如

![1640421687155](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1640421687155.png)





# SpringBoot  Web 开发

jar：webapp



自动装配

springboot到底帮我们配置了什么？我们能不能进行修改？能修改哪些？能不能扩展？

- XXXAutoConfiguration，向容器中自动配置组件
- XXXProperties，自动配置类，装配配置文件中自定义的一些内容



要解决的问题：

- 导入静态资源
- 首页
- jsp，模板引擎Thymeleaf
- 装配扩展SpringMVC
- 增删改查
- 拦截器
- 国际化



## 一、静态资源

就是之前前端需要用框架（如juqery，bootstarp）时，需要导入的那些js和css包，放在java后端怎么导入进来。（可以用webjars，就是将这些静态资源用maven的形式导入jar，然后根据一定的路径结构去找出来）



在springboot，我们可以使用以下方式处理静态资源

- webjars    `localhost:8080/webjars/`
- public, static, /**, resources    `localhost:8080/`

优先级

resources > static（默认） > public



**怎么自动装配的？（难）**

1. 首先看到WebMVC的配置类WebMvcAutoConfiguration

2. 里面有一个静态内部类WebMvcAutoConfigurationAdapter

3. 内部类有一个方法addResourceHandlers()添加资源处理器

    ```java
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!this.resourceProperties.isAddMappings()) {
            logger.debug("Default resource handling disabled");
        } else {
            this.addResourceHandler(registry, "/webjars/**", "classpath:/META-INF/resources/webjars/");
            this.addResourceHandler(registry, this.mvcProperties.getStaticPathPattern(), (registration) -> {
                registration.addResourceLocations(this.resourceProperties.getStaticLocations());
                if (this.servletContext != null) {
                    ServletContextResource resource = new ServletContextResource(this.servletContext, "/");
                    registration.addResourceLocations(new Resource[]{resource});
                }
    
            });
        }
    }
    ```

    如果自定义了路径，则不走默认的；

    首先判断webjars，如果有，就可以通过/webjars/访问maven导入进来的jar包里面的静态资源；

    然后还会去找出WebProperties类里面的CLASSPATH_RESOURCE_LOCATIONS也就是new String[]{"classpath:/META-INF/resources/", "classpath:/resources/", "classpath:/static/", "classpath:/public/"};

    这几个路径下面的静态资源。

4. 全都放到ResourceHandlerRegistry  registry资源处理注册器里面去
5. 再详细的就没看了。。。



## 二、首页和图标

在WebMvcAutoConfiguration的内部类EnableWebMvcConfiguration里面，有方法

```
welcomePageHandlerMapping()
getWelcomePage()
getIndexHtml()
```

```java
private Resource getIndexHtml(Resource location) {
    try {
        Resource resource = location.createRelative("index.html");
        if (resource.exists() && (resource.getURL() != null)) {
            return resource;
        }
    }
    catch (Exception ex) {
    }
    return null;
}
```

其实就是去之前的静态资源目录里面，找index.html作为首页



## 三、Thymeleaf

### 3.1 使用

1. 导入依赖

    ```xml
    <!-- thymeleaf -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
    ```

2. controller跳转页面

3. resources下的templates包里面放html页面



### 3.2 语法

1. 导入 命名空间的 约束

    ```html
    <html lang="en" xmlns:th="http://www.thymeleaf.org">
    ```

2. 表达式

Simple expressions:

- Variable Expressions: `${...}`
- Selection Variable Expressions: `*{...}`
- Message Expressions: `#{...}`
- Link URL Expressions: `@{...}`
- Fragment Expressions: `~{...}`

简单表达式：

- 变量
- 条件变量
- 消息
- url
- 





3. 基本语法

| Order | Feature                         | Attributes                                 |
| :---- | :------------------------------ | :----------------------------------------- |
| 1     | Fragment inclusion              | `th:insert` `th:replace`                   |
| 2     | Fragment iteration              | `th:each`                                  |
| 3     | Conditional evaluation          | `th:if` `th:unless` `th:switch` `th:case`  |
| 4     | Local variable definition       | `th:object` `th:with`                      |
| 5     | General attribute modification  | `th:attr` `th:attrprepend` `th:attrappend` |
| 6     | Specific attribute modification | `th:value` `th:href` `th:src` `...`        |
| 7     | Text (tag body modification)    | `th:text` `th:utext`                       |
| 8     | Fragment specification          | `th:fragment`                              |
| 9     | Fragment removal                | `th:remove`                                |



普通变量

```
<div th:text="${msg}"></div>不转义，是什么就输出什么
<div th:utext="${msg}"></div>转义后
```

遍历

```
<div th:each="user : ${users}" th:text="${user}"></div>
```







## 四、MVC配置原理（难）

扩展MVC的配置

1. 写一个类在config包，用@Configuration注解标注
2. 实现WebMvcConfigurer接口，但是不要使用@EnablewebMvc注解





## 五、员工管理系统

5.1 准备工作

pojo，dao，静态资源文件，controller测试一下



5.2 首页配置

注意点，所有页面的静态资源都需要使用thymeleaf接管，@{}表示url，#{}表示消息



5.3 国际化

- 需要配置i18n文件
- 如果需要在项目中进行按钮自动切换，自定义一个Bean，LocaleResolver，再配置到spring容器
- #{}



后面的有点难啃。。。。



## 六、整合JDBC使用

6.1 在yaml文件配置好数据源

```xml
spring:
  datasource:
    username: root
    password: root
    url: jdbc:mysql://localhost:3306/mybatis?userUnicode=true&characterEncodeing=uft-8&serverTimezone=UTC
    driver-class-name: com.mysql.cj.jdbc.Driver
```

6.2 然后测试一下，其实就可以直接通过bean拿到数据源了

```java
    @Autowired
    private DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());
    }
```

6.3 获得数据库连接

```java
    @Test
    void contextLoads() throws SQLException {

        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        connection.close();
    }
```

6.4 XXXtemplate：springBoot已经配置好的模板bean，拿来即用

```java
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //查询数据库的所有信息
    @GetMapping("/userList")
    public List<Map<String, Object>> userList() {

        String sql = "select * from user";
        return jdbcTemplate.queryForList(sql);

    }

	@GetMapping("/addUser")
    public String addUser() {
        String sql = "insert into mybatis.user(id, name, pwd) values (7, '小米', '1234567')";
        jdbcTemplate.update(sql);
        return "ok";
    }
```



## 七、整合Druid数据源

7.1 导入maven，是阿里巴巴的，还有后面会用到log4j，一起导入

```xml
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid</artifactId>
    <version>1.2.3</version>
</dependency>

<!-- https://mvnrepository.com/artifact/log4j/log4j -->
<dependency>
    <groupId>log4j</groupId>
    <artifactId>log4j</artifactId>
    <version>1.2.17</version>
</dependency>
```



7.2 配置文件里面配置好数据源为Druid

spring.datasource.type=com.alibaba.druid.pool.DruidDataSource



7.3 测试一下确认数据源没错，开始写config，看一下后台监控功能



7.4 先写一个@Configuration里面写一个bean，返回DruidDataSource这个数据源，然后@ConfigurationProperties(prefix = "spring.datasource")指定参数类对应配置文件里的前缀

```java
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    //后台监控
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        Map<String, String> initParameTers = new HashMap<>();
        //账号密码
        initParameTers.put("loginUsername", "admin");
        initParameTers.put("loginPassword", "123456");
        //允许谁可以访问
        initParameTers.put("allow", "localhost");

        bean.setInitParameters(initParameTers);
        return bean;
    }


}
```



7.5 登录localhost:8081/druid就可以查看执行的sql啦

![1641126844267](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1641126844267.png)



7.6 过滤器



## 八、整合Mybatis

整合包：mybatis-spring-boot-start

不是springboot官方的，是mybatis自研的

```xml
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>2.1.1</version>
</dependency>
```



8.1 实体类pojo

```java
public class User {
    private int id;
    private String name;
    private String pwd;
}
```



8.2 mapper

```java
//这个注解表示这是一个mybaits的mapper类
@Mapper
//注册为bean交给spring
@Repository	
public interface UserMapper {
    List<User> queryUserList();

    User queryUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}
```

这里可以用@Mapper注解表示mapper，或者在启动类上设置mapper扫描

```
@MapperScan("com.kuang.mapper")
```



8.3 写mapper对应配置文件

UserMapper.xml，写在resources/mybatis/mapper下

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.kuang.mapper.UserMapper">

    <select id="queryUserList" resultType="User">
        select * from user
    </select>

</mapper>
```



8.4 然后写controller

```java
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/queryUserList")
    public String queryUserList() {
        List<User> users = userMapper.queryUserList();
        return users.toString();
    }

}
```

就可以测试一下



## 九、SpringSecurity环境搭建

shiro、SpringSecurity：认证、授权（vip1、vip2、vip3）



- 功能权限
- 访问权限
- 菜单权限
- ....拦截器、过滤器：大量的原生代码



![1641618882838](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1641618882838.png)





































# 后面内容

- JDBC
- Mybatis
- Druid
- Shiro
- Spring Security
- 异步任务，邮件发送，定时任务
- Swagger



# 




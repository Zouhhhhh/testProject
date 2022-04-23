# SpringSecurity



（1）导入maven

```xml
<!--thymeleaf-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>

<!-- security -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```



（2）然后是前端页面，基本上结构

![1641648863116](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1641648863116.png)



（3）然后写个controller测试一下，没有权限控制的

```java
@Controller
public class RouterController {

    @RequestMapping({"/", "/index"})
    public String index() {
        return "index";
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "views/login";
    }

    @RequestMapping("/level1/{id}")
    public String level1(@PathVariable("id") int id) {
        return "views/level1/" + id;
    }

    @RequestMapping("/level2/{id}")
    public String level2(@PathVariable("id") int id) {
        return "views/level2/" + id;
    }

    @RequestMapping("/level3/{id}")
    public String level3(@PathVariable("id") int id) {
        return "views/level3/" + id;
    }
}
```



（4）现在加上权限控制

```java
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 定制请求的授权规则
        // 首页所有人可以访问
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");
        // 开启自动配置的登录功能
        // /login 请求来到登录页
        // /login?error 重定向到这里表示登录失败
        http.formLogin();
        
        //开启自动配置的注销的功能
        // /logout 注销请求
        http.logout();
    }
}
```

 测试一下：发现，没有权限的时候，会跳转到登录的页面。



（5） 定义认证规则

重写configure(AuthenticationManagerBuilder auth)方法 ，要将前端传过来的密码进行某种方式加密，否则就无法登录，修改代码 

```java
//定义认证规则
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //在内存中定义，也可以在jdbc中去拿....
    //Spring security 5.0中新增了多种加密方式，也改变了密码的格式。
    //要想我们的项目还能够正常登陆，需要修改一下configure中的代码。我们要将前端传过来的密码进行某种方式加密
    //spring security 官方推荐的是使用bcrypt加密方式。

    auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
        .withUser("kuangshen").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2","vip3")
        .and()
        .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2","vip3")
        .and()
        .withUser("guest").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1");
}
```



（6） 开启自动配置的注销的功能 

登录成功后点击注销，发现注销完毕会跳转到登录页面， 我们想让他注销成功后，依旧可以跳转到首页 

```java
//定制请求的授权规则
@Override
protected void configure(HttpSecurity http) throws Exception {
    //....
    //开启自动配置的注销的功能
    // /logout 注销请求
    // .logoutSuccessUrl("/"); 注销成功来到首页
    http.logout().logoutSuccessUrl("/");
}
```






















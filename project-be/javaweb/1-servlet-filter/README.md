1. new一个javaEE的项目，选了WebAppcation
2. index.js写一个form
3. 写一个servlet(TestServlet)，发现@WebServlet包找不到
    原因：创建web项目没有添加服务器导致的
    解决：下载tomcat服务器（看tomcat目录讲解），idea配置服务器，然后projectStructure->Modules->Dependencies->add
    （PS：主要是因为下载的Tomcat服务器解压缩文件里，lib下有对应的Servlet的jar包）
4. 还原之前的乱码问题，TestServlet写接收一个中文参数，然后输出可以看到乱码
5. 之前的解决方案，在接收参数之前setCharacterEncoding("UTF-8")
6. 好了，现在再来一个LoginServlet，难道又要写req.setCharacterEncoding？
7. 过滤器Filter：
    功能：
        1. 用来拦截传入的请求和传出的响应
        2. 修改或以某种方式处理正在客户端和服务器之间交换的数据流
    如何使用：
        与使用Servlet类似，Filter是Java Web提供的一个接口，开发者只需要自定义一个类并且实现该接口即可
8. 写一个CharacterFilter，实现doFilter方法，并且还要将过滤器chain继续往下走
9. 还需要在web.xml里面配置这个过滤器才能生效
    <filter></filter>
    <filter-mapping></filter-mapping>

10. Filter的生命周期：
    1. 启动tomcat时就会通过反射调用Filter的无参构造方法创建对象（前提是在web.xml配置了这个过滤器）
    2. 调用init方法
    3. 访问到filter时，调用doFilter
    4. 关闭tomcat时调用destroy
    
11. 多个filter的"执行"顺序按web.xml的配置顺序

12. 注解配置Filter（无法设置执行顺序）
    @WebFilter("/login")
    
13. 过滤器的使用场景：
    - 乱码
    - 屏蔽铭感词     test.jsp、wordServlet、wordFilter
    - 控制资源的访问权限     download.jsp、DownLoadFilter过滤"/download.jsp"，如果name为空，重定向到login


补充：
@WebFilter 用于将一个类声明为过滤器，该注解将会在部署时被容器处理，容器将根据具体的属性配置将相应的类部署为过滤器。
该注解具有下表给出的一些常用属性 ( 以下所有属性均为可选属性，但是 value、urlPatterns、servletNames 三者必需至少包含一个，
且 value 和 urlPatterns 不能共存，如果同时指定，通常忽略 value 的取值 )

主要用urlPatterns = { "/*" }
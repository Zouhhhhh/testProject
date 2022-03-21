1. new一个javaEE的项目，选了WebAppcation
2. index.js写一个form
3. 写一个servlet(TestServlet)，发现@WebServlet包找不到
    原因：创建web项目没有添加服务器导致的
    解决：下载tomcat服务器（看tomcat目录讲解），idea配置服务器，然后projectStructure->Modules->Dependencies->add
    （PS：主要是因为下载的Tomcat服务器解压缩文件里，lib下有对应的Servlet的jar包）
4. 还原之前的乱码问题，TestServlet写接收一个中文参数，然后输出可以看到乱码
5. 之前的解决方案，在接收参数之前setCharacterEncoding("UTF-8")
6. 好了，现在再来一个LoginServlet，难道又要写req.setCharacterEncoding？
7. 过滤器：
    功能：
        1. 用来拦截传入的请求和传出的响应
        2. 修改或以某种方式处理正在客户端和服务器之间交换的数据流
    如何使用：
        与使用Servlet类似，Filter是Java Web提供的一个接口，开发者只需要自定义一个类并且实现该接口即可
8. 写一个CharacterFilter，实现doFilter方法，并且还要将过滤器chain继续往下走
9. 还需要在web.xml里面配置这个过滤器才能生效
    <filter></filter>
    <filter-mapping></filter-mapping>

        


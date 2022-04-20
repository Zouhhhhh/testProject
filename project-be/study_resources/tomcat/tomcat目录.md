bin：存放各个平台下启动和停止Tomcat的脚本文件（.bat和.sh）
config：存放各种tomcat服务器的配置文件
lib：存放Tomcat服务器所需要的jar
logs：存放Tomcat服务运行的日志
tmp：存放Tomcat运行时的临时文件（文件上传下载时用的）
webApps：存放运行客户端访问的资源(java程序)
work：存放Tomcat将JSP转换成之后的Servlet文件







如何部署-运行-访问自己的web项目？

1. 首先要有服务器，这里以tomcat为例

    ![1650465092477](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1650465092477.png)

    tomcat服务器可以看作一个容器，把我们自己写的web项目放到容器里面就相当于部署了（**放到哪里呢？其实就是tomcat的目录结构中的webAppxs文件夹下**），然后因为tomcat本身也是java和c写的程序，所以只需要运行tomcat，这时候访问localhost:8080就可以访问到tomcat的主页了。然后就是要访问我们自己的web项目，就在url后面加入web项目的context:root，如localhost:8080/testproj/index.html就可以访问了。

2. 再来说IDEA是怎么帮我们把web项目部署到tomcat里

    我们写好代码后，需要在IDEA配置好tomcat服务器

![1650465335984](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1650465335984.png)

​	配置好后，我们就可以直接在IDEA中运行tomcat，进而访问我们的web项目了（这里要注意的是，IDEA不是把我们的web项目部署到webAppxs文件夹下，而是修改了tomcat的配置指定去部署IDEA编译打包后输出文件目录，在IDEA的设置中可以找到编译输出目录的位置）

![1650465577472](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1650465577472.png)
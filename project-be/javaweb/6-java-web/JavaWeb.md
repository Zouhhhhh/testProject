# JavaWeb项目实战
1. 先做登录页，导入login.jsp，以及静态资源。运行一下测试jsp页面
2. 导入数据库文件Library
3. 根据MVC的思想：controller -> service -> repository -> DB
    - 在controller写servlet
    - 在service写接口和实现类
    - 在entity写对象，方便service返回对象
    - 在repository写连接数据库，一个表对应一个repository接口
    - 从controller开始，依次注入各层依赖的对象
    
4. 导入连接数据库所需要的包和配置文件（c3p0包和配置文件、jdbc驱动）
5. 写数据库连接的工具类JDBCTools
6. 回到controller获取页面传过来的参数去调用service查这个对象，如果返回不是null则放session，如是null，重定向到login.jsp




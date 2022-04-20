# 总结
为了总结一下之前学的javaWeb知识，包括servlet、tomcat、filter、jdbc之类的，
还有顺便重构一下javaWeb综合练习的那个项目，代码写的很不规范（数据库名、类变量名、重复代码等等）


# 数据库(library-rebuild)
1. 表
book
book_case
reader
admin
borrow

# 实体类
Book
BookCase
Reader
Admin
Borrow

# JDBC工具类
1. 导包
    - mysql驱动
    - c3p0两个包
    
2. 先回顾一下JDBC
JDBC就是java数据库连接
JDBC接口（API）包括两个层次：
　　1 面向应用的API：Java API，抽象接口，供应用程序开发人员使用（连接数据库，执行SQL语句，获得结果）。
　　2 面向数据库的API：Java Driver API，供开发商开发数据库驱动程序用。

- 首先需要将mysql驱动加载进来（导包，使用反射加载）
- 然后通过面向数据库的API（DriverManager）获取到连接（Connection）
- 再通过面向应用的API（就是前面获取到的Connection）去创建Statement执行SQL语句
- 获取结果ResultSet

3. 数据库连接池
- 为了减少连接次数和开销，使用数据库连接池
- JDBC的数据库连接池使用javax.sql.DataSource接口来完成的，DataSource是java官方提供的接口，用来表示数据库连接池的功能。
- C3P0是个第三方工具，他提供DateSource接口的实现类（ComboPooledDataSource）
- 这样我们只需要通过dateSource数据库连接池对象去获取连接，而不用直接通过DateManger向数据库驱动获取连接

# 读者功能
## 登录
jsp页面：login.jsp
Servlet：LoginServlet，读者和管理员的，跳转到首页
Service：LoginService
Repository：LoginRepository

## 首页
jsp页面：读者（index.jsp），管理员（admin.jsp）——这里用到了c:forEach，要导入JSTL的包
    备注：jsp（Java Server Pages）、JSTL（Java server pages standarded tag library）JSP标准标签库

Servlet：BookServlet
Service：BookService
Repository：BookRepository（包含分页）
方法：findAllBook

## 借阅
Servlet：BookServlet
Service：BookService
Repository：borrowRepository
方法：addBorrow

## 借阅页
jsp页面：borrow.jsp
Servlet：BookServlet
Service：BookService
Repository：borrowRepository
方法：findAllBorrow

## 注销
Servlet：LogoutServlet

## 过滤器
CharacterFilter
ReaderFilter

# 管理员功能
管理员主要有两个功能，一个是审核借阅记录，另一个是归还图书
## 登录
Servlet：LoginServlet





# JDBC (java database connectivity)
## 1-JDBC介绍
1 JDBC(Java Database Connectivity)是一个独立于特定数据库管理系统、通用的SQL数据库存取和操作的公共接口（一组API），定义了用来访问数据库的标准Java类库，（java.sql,javax.sql）使用这些类库可以以一种标准的方法、方便地访问数据库资源。

2 JDBC为访问不同的数据库提供了一种统一的途径，为开发者屏蔽了一些细节问题。

3 JDBC的目标是使Java程序员使用JDBC可以连接任何提供了JDBC驱动程序的数据库系统，这样就使得程序员无需对特定的数据库系统的特点有过多的了解，从而大大简化和加快了开发过程。

## 2-JDBC体系结构
JDBC接口（API）包括两个层次：
　　1 面向应用的API：Java API，抽象接口，供应用程序开发人员使用（连接数据库，执行SQL语句，获得结果）。
　　2 面向数据库的API：Java Driver API，供开发商开发数据库驱动程序用。

## JDBC API
JDBC API
提供者：java官方
内容：供开发者调用的接口
java.sql 和 javax.sql
- DriverManager类
- Connection接口
- Statement接口
- ResultSet接口

DriverManager
提供者：java官方
作用：管理不同的JDBC驱动

JDBC驱动
提供者：数据库厂商
作用：负责连接不同的数据库

## JDBC的使用
1、加载数据库驱动，java程序和数据库之间的桥梁
2、获取Connection，java程序与数据库的一次连接
3、创建Statement对象，由Connection产生，执行SQL语句
4、如果需要接收返回值，创建ResultSet对象，用来保存Statement执行之后所查询到的结果


## 代码实现
1、引入mysql驱动的jar包
2、创建测试类，通过反射将类加载到内存里来（使用Class类的静态方法forName获取类对象，方式二）
3、获取连接
    Connection connection = DriverManager.getConnection(url, user, password);
4、创建Statement
    Statement statement = connection.createStatement();
5. 执行sql
    int result = statement.executeUpdate(sql);     //增删改
    ResultSet resultSet = statement.executeQuery(sql);  //查询

6. 使用Statement操作数据表的弊端
　　　　问题一：存在拼串操作，繁琐
　　　　问题二：存在SQL注入问题
7. PreparedStatement 接口
    Statement 的子接口，它表示一条预编译过的 SQL 语句
    PreparedStatement 对象所代表的 SQL 语句中的参数用问号(?)来表示，调用 PreparedStatement 对象的 setXxx() 方法来设置这些参数. 
        setXxx() 方法有两个参数，第一个参数是要设置的 SQL 语句中的参数的索引(从 1 开始)，第二个是设置的 SQL 语句中的参数的值
8. 练习使用PreparedStatement 接口
    1 在项目的src文件创建配置文件(jdbc.properties)，用来存储据库连接需要的4个基本信息
    2 新建JDBC的工具类(JDBCUtils)，用来封装数据库的连接与资源的关闭
    3 测试增删改，还有查询








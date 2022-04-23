# JavaWeb项目实战
1. 先做登录页，导入login.jsp，以及静态资源。运行一下测试jsp页面
2. 导入数据库文件Library
3. 根据MVC的思想：controller -> service -> repository -> DB
    - 在controller写servlet
    - 在service写接口和实现类
    - 在entity写对象，方便service返回对象
    - 在repository写连接数据库，一个表对应一个repository接口（也叫dao层，data access object数据访问层）
    - 从controller开始，依次注入各层依赖的对象
    
## 登录页面
4. 导入连接数据库所需要的包和配置文件（c3p0包和配置文件、jdbc驱动）
5. 写数据库连接的工具类JDBCTools
6. 回到controller获取页面传过来的参数去调用service查这个对象，如果返回不是null则放session，如是null，重定向到login.jsp
7. 在login.jsp页面还会传过来一个用户类型type，在servlet拿到后，给service判断是Reader还是Admin，根据type去查不同的表
    （ps：传过来的username如果是中文会乱码，自己加个过滤器）
    
## 首页
8. admin登录没问题后，开始首页（包括index.jsp、top.jsp、footer.jsp）
9. 在LoginServlet登录成功后，请求转发到index.jsp，同时req里面带上图书的list数据（controller把Model带到view）
10. 写Book相关的业务（BookService, BookRepository、Book类、BookCase类），这里注意Book和BookCase的多对一关系


## 分页
通过sql语句的limit

## 解耦
登录那里成功后还调用了加载books数据的业务，需要拆开

## 借阅功能
1. 先看数据库表结构，borrow借阅表，存放记录信息
2. 借阅这个操作，关联了book表，reader表，admin表
3. 在bookServlet中写接收请求，带上method
4. 调用bookService，需要将借阅记录insert到数据
5. 调用borrowRepository，参数需要bookid,readerid,borrowtime,returntime

## 展示当前用户的所有借书记录
这回从repository开始写，而需要先写实体类来对应borrow表
1. borrow类
2. borrowRepository的findAllByReaderId
3. bookService的findAllByReaderId
4. 在bookServlet中addBorrow完后，跳转到borrow.jsp

## 过滤器实现登录拦截



## 借书记录页面做分页
1. 就是从servlet接收到一个page参数
2. 调整borrowService的find，加page参数
3. borrowRepository的sql增加limit ?, ?


## 借阅和查看借阅的业务解耦
在bookServlet里再加一个case "findAllBorrow":
查看借阅的入口变成index.jsp页面上点击人名进入，不再需要先addBorrow


## 注销
LogoutServlet
销毁Session，重定向到login.jsp


## 管理员功能
1. 登录后的servlet，跳转到管理员的首页admin.jsp
2. 先要拿到borrow记录状态等于0的数据
3. 写service、repository
4. 管理员的借阅页面做分页


## 管理借阅
1. 同意1，拒绝2，设置state，设置admin审核
2. 给admin加过滤器
2. 操作过多注意释放连接


## 还书管理
1. 进入到adminServlet的method为getBorrowed方法
2. 调用原有的findAllBorrowByState接口查出state为1的borrow记录
3. 调用原有的handle接口，处理borrow的state设置为3

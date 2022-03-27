# servlet-jsp-jdbc综合案例
1. 首先创建web工程，在WEB-INF下创建lib导包（jdbc）
2. 测试一下连接jdbc没问题
    1 首先创建一个servlet和一个jsp，提交一个name过来查student信息(把student封装成对象)
    2 再创JDBCUtils和characterFilter，方便连接和解决乱码
    3 这里注意响应数据的乱码，有两种方式
        第一种方式：
        response.setCharacterEncoding("utf-8");    //设置 HttpServletResponse使用utf-8编码
        response.setHeader("Content-Type", "text/html;charset=utf-8");    //通知浏览器使用utf-8解码
        第二种方式：
        response.setContentType("text/html;charset=utf-8");    //包含第一种方式的两个功能
    
3. 下面开始正式写个综合案例
    1 写一个servlet请求，拿到全部student数据，然后跳转到jsp页面展示list（需要导jstl包，练习一下for遍历list数据）
    2 写一个add.jsp和表单，后台写一个servlet请求新增传过来的student
    3 在list.jsp页面每条数据后加一个删除按钮，后台servlet接收id后删除student
    4 在list.jsp页面每条数据后加一个编辑按钮，点击后跳转到update.jsp
    5 点击修改后请求后台servlet修改数据
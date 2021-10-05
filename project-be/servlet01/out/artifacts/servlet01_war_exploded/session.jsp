<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/10/4
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取域对象</title>
</head>
<body>
    <%

        //获取Session域对象
        String uname = (String) request.getSession().getAttribute("uname");
        String upwd = (String) request.getSession().getAttribute("upwd");

        //获取request对象
        String name = (String) request.getAttribute("name");


        out.print(" uname:" + uname);
        out.print(" upwd:" + upwd);
        out.print(" name:" + name);

    %>
</body>
</html>

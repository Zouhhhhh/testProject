<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/10/4
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>重定向与请求转发</title>
</head>
<body>

<%

    String name = request.getParameter("name");
    String pwd = request.getParameter("pwd");

    String pwd2 = (String) request.getAttribute("pwd");


    out.print(name);
    out.print("--------------");
    out.print(pwd);
    out.print("--------------");
    out.print(pwd2);

%>

</body>
</html>

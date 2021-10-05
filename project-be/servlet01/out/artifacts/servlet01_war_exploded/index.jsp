<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>index</title>
  </head>
  <body>
    <%--  在JSP中写JAVA代码，需要写在脚本段中--%>
<%
  //获取域对象内容
  String name = (String) request.getAttribute("name");
  System.out.println(name);

  Integer age = (Integer) request.getAttribute("age");
  System.out.println(age);

  List<String> list = (List<String>) request.getAttribute("list");
  System.out.println(list);


%>


  </body>
</html>

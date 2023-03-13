<%--
  Created by IntelliJ IDEA.
  User: 86159
  Date: 2022/12/13
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <form action=<%= request.getContextPath() %> "/logn" method="post">
      <input type="text" name="user"><br/>
      <input type="password" name="pwd">
      <input type="submit" value="提交">
      <a href=<%= request.getContextPath() %>  "/relogin.jsp">注册页面</a>
    </form>
  </body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: 86159
  Date: 2022/12/13
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
  <%= request.getCookies()[0].getValue() %>
  <%= request.getCookies()[1].getValue() %>
</body>
</html>

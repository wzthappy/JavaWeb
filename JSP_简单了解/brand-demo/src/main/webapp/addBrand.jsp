<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h3>添加品牌</h3>
<form action="/brand_demo_war_exploded/AddServlet" method="post">
  姓名: <input type="text" name="username"><br/>
  密码: <input type="password" name="password"><br/>
  性别: <input type="text" name="gender"><br/>
  介绍: <input type="text" name="addr"><br/>
  <input type="submit" value="提交">
  <input type="reset">
</form>
</body>
</html>

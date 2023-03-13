<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h3>修改品牌</h3>
<form action="/brand_demo_war_exploded/updateServlet" method="post">
  <!-- 隐藏域，提交id -->
  <input type="hidden" name="id" value="${user.id}">
  姓名: <input type="text" name="username" value="${user.username}"><br/>
  密码: <input type="password" name="password" value="${user.password}"><br/>
  性别: <input type="text" name="gender" value="${user.gender}"><br/>
  介绍: <textarea rows="5" cols="20" name="addr">${user.addr}</textarea>
  <input type="submit" value="提交">
  <input type="reset">
</form>
</body>
</html>
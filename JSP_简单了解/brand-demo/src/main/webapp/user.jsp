<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<table border="1" cellpadding="0" width="800">
  <c:forEach items="${users}" var="user" varStatus="status">
    <tr align="center">
      <td>${status.count}</td>
      <td>${user.username}</td>
      <td>${user.password}</td>
      <td>${user.gender}</td>
      <td>${user.addr}</td>

      <td>
        <a href="/brand_demo_war_exploded/deleteByIdServlet?id=${user.id}">删除</a>
        <a href="/brand_demo_war_exploded/selectByIdServlet?id=${user.id}">修改</a>
      </td>
    </tr>
  </c:forEach>
</table>
<input type="button" value="新增" id="add">

<script>
  let elementById = document.getElementById("add")
  elementById.addEventListener('click', () => {
    location.href = "/brand_demo_war_exploded/addBrand.jsp";
  });
</script>
</body>
</html>

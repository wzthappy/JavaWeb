<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<form action="/a_war_exploded/registerServlet" method="post">
  <table>
    <tr>
      <td>${zc}</td>
      <td>验证码</td>
      <td>
        <input name="checkCode" type="text">
        <img id="checkCodeImg" src="http://localhost/a_war_exploded/checkCodeServlet">  <!-- 验证码图片 -->
        <a href="#" id="changeImg">看不清?</a>
      </td>
    </tr>
    <td>
      <input type="submit" value="确定">
    </td>
  </table>

  <script>
    let elementById = document.getElementById("changeImg");
    let elementById1 = document.getElementById("checkCodeImg")
    elementById.addEventListener("click", () => {
      // servlet的路径   ?时间戳      因为服务器有缓存   所以每次路径参数不能相同
      let a = +new Date();
      elementById1.src = 'http://localhost/a_war_exploded/checkCodeServlet?' + a;
    })
  </script>
</form>
</body>
</html>

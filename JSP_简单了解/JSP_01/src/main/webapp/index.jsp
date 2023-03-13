<%--
  Created by IntelliJ IDEA.
  User: 86159
  Date: 2022/7/11
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h1>hello jsp</h1>
<c:forEach begin="1" end="10" step="1" var="i">
  <a href="#">${i}</a>
</c:forEach>
<%
  System.out.println("hello jsp~");
  int i = 3;
  for (int y = 1; y <= 4; y++) {
%>
<h6>llllllllllll o  <%= y %>
  <%
    if (y == 1) {
  %>
  <h1>
    11111111111111111111 l  <%= y %>
  </h1>
  <%
    }
  %>
</h6>
<%
  }
%>

<%= "hello" %>
<%= i %>

<%!
  void show() {
    String name = "zhangsan";
  }
%>
</body>
</html>

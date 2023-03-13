package com.bjpowernode.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class OneServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String result = "Hello World";  // 执行结果

    String name = req.getParameter("name");
    int age = Integer.parseInt(req.getParameter("age"));

    User user = new User(name, age);

    // ------- 响应对象将结果写入到响应体 ---------start
    // 1. 通过响应对象，向Tomcat索要输出流
    PrintWriter out = resp.getWriter();

    // 2. 通过输出流，将执行结果以二进制形式写入到响应体
    out.print(user);

    // ------- 响应对象将结果写入到响应体 ---------start

  } // doGet执行完毕
  // Tomcat将响应包推送给浏览器
}

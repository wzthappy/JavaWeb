package com.bjpowernode.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OneServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 1. 将数据添加到请求作用域对象，作为共享数据
    req.setAttribute("key1", "hello World");

    // 2. 代替浏览器，向Tomcat索要TwoServlet来完成剩余任务
    req.getRequestDispatcher("/two").forward(req, resp);
  }
}

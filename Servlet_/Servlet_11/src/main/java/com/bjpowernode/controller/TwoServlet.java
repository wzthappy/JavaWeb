package com.bjpowernode.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TwoServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 从同一个请求作用域对象得到OneServlet携入到共享数据
    String value = (String) req.getAttribute("key1");
    System.out.println("TwoServlet得到共享数据 " + value);
  }
}

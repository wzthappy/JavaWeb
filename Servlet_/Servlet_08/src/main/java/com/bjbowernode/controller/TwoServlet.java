package com.bjbowernode.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class TwoServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 1. 通过请求对象向Tomcat索要当前网站全局作用域对象
    ServletContext application = request.getServletContext();

    // 2. 从全局作用域对象得到指定关键字对应的值
    Integer money = (Integer) application.getAttribute("key1");
    System.out.println(money);
  }
}

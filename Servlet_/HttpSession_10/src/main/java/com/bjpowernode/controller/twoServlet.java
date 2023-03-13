package com.bjpowernode.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

public class twoServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 1. 调用请求对象，向Tomcat索要当前用户在服务端私人储物柜
    HttpSession session = req.getSession();
//    req.getSession(false);
    // 2. 将session中所有的key读取出来
    Enumeration<String> attributeNames = session.getAttributeNames();
    while (attributeNames.hasMoreElements()) {
      String s = attributeNames.nextElement();
      int attribute = (int) session.getAttribute(s);
      System.out.println("商品名称 " + s + " 商品数量 " + attribute);
    }
  }
}

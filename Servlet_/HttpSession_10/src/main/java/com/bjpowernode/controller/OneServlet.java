package com.bjpowernode.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OneServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String goodsName;
    // 1. 调用请求对象，读取请求头参数，得到用户选择商品名
    goodsName = req.getParameter("goodsName");
    // 2. 调用请求对象，向tomcat索要当前用户在服务端的私人储物柜
    HttpSession session = req.getSession();
    // 3. 将用户选购商品添加到当前用户私人储物柜中
    Integer goodsNum = (Integer) session.getAttribute(goodsName);
    if (goodsNum == null) {
      session.setAttribute(goodsName, 1);
    } else {
      session.setAttribute(goodsName, goodsNum + 1);
    }
  }
}

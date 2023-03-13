package com.bjpowernode.controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class oneServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String userName, money;
    // 1. 调用请求对象读取【请求头】参数信息
    userName = req.getParameter("userName");
    money = req.getParameter("money");

    // 2. 开卡
    Cookie card1 = new Cookie("userName", userName);
    Cookie card2 = new Cookie("money", money);

    // 3. 指点card2在客户端硬盘上存活1分钟
    card2.setMaxAge(60);

    // 4. 发卡，将Cookie写入到响应头交给浏览器
    resp.addCookie(card1);
    resp.addCookie(card2);

    // 5. 通知Tomcat浏览器将【点餐页面】内容写入到响应体交给浏览器(请求转发)
    req.getRequestDispatcher("/index_2.html").forward(req, resp);
  }
}

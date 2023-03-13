package com.bjpowernode.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FourServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String result = "https://www.baidu.com?userName=mike";

    // 通过响应对象，将地址赋值给响应体中location属性
    resp.sendRedirect(result);  // 【响应体 location="https://www.baidu.com"】
  }
  /**
   * 浏览器在接收到响应包之后，如果发现响应头存在location属性
   * 自动通过地址栏向location指定网站发送请求
   *
   * sendRedirect方法远程控制浏览器请求行为【请求地址，请求方式，请求参数】
   */
}

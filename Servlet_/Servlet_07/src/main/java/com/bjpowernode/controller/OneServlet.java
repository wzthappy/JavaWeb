package com.bjpowernode.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OneServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("OneServlet 求婚~~~");
    // 请求转发方案:
    // 1. 通过当前请求对象生成资源文件申请报告对象
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/two");
    /// 2. 将报告对象发送给Tomcat
    requestDispatcher.forward(req, resp);

  }
}

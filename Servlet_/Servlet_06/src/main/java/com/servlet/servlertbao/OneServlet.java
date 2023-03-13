package com.servlet.servlertbao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OneServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("OneServlet 负责 洗韭菜");

    // 重定向解决方案:
    resp.sendRedirect("/Servlet_06_war_exploded/two"); // 【地址格式: /网络名/资源文件名】
  }
}

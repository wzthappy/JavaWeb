package com.itheim.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class TwoServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 直接从请求体中读取请求参数
    String userName = request.getParameter("userName");

    System.out.println("TwoServlet 从请求体得到参数 " + userName);
  }
}

package com.itheim.controller;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OneServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 直接从请求体中读取请求参数
    String userName = req.getParameter("userName");

    System.out.println("OneServlet 从请求体得到参数 " + userName);
  }
}

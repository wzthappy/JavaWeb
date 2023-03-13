package com.itheim.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OneServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    ServletContext servletContext = req.getServletContext();

    servletContext.setAttribute("key1", 100); // 新增共享数据
    servletContext.setAttribute("key1", 200); // 更新共享数据
    servletContext.removeAttribute("key1");      // 删除共享数据
  }
}

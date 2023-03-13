package com.itheima.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OneServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 1. 准备数据
    Map<String, String> map = new HashMap<>();
    map.put("1", "卡卡");
    map.put("2", "香香");

    // 2. 存储到req域中
    req.setAttribute("name", map);
    req.setAttribute("status", 1);

    // 3. 转发到 el-demo.jsp
//    req.getRequestDispatcher("/el-demo.jsp").forward(req, resp);
    req.getRequestDispatcher("/jstl-if.jsp").forward(req, resp);
  }
}

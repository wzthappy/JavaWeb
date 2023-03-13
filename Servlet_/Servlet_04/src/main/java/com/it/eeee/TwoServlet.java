package com.it.eeee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class TwoServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 1. 通过请求对象获得【请求头】中【所有请求参数名】
    Enumeration<String> parameterNames = req.getParameterNames(); // 将所有请求参数名称保存到一个枚举对象进行返回

    while (parameterNames.hasMoreElements()) {
      // 请求参数名称
      String nextElement = parameterNames.nextElement();

      // 2. 通过请求对象读取指定的请求参数的值
      String parameter = req.getParameter(nextElement);

      System.out.println("请求参数名: " + nextElement + "请求参数的值: " + parameter);
    }
  }
}

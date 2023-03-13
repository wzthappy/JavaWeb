package com.itheim.controller.userServlet;

import com.itheim.doa.UserService;
import com.itheim.doa.impl.UserDao;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

@WebServlet("/user/delete")

public class UserDeleteServlet extends HttpServlet {
  UserService dao = new UserDao();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 1. 【调用请求对象】读取【请求头】参数(用户编号)
    String userId = null;
    int result = 0;
    PrintWriter out = null;
    Enumeration<String> parameterNames = request.getParameterNames();
    while (parameterNames.hasMoreElements()) {
      String s = parameterNames.nextElement();
      userId = request.getParameter(s);
    }

    // 2. 【调用DAO】将用户编号填充到delete命令并发送到数据库服务器
    Date oewDate = new Date();
    result = dao.delete(userId);
    Date twoDate = new Date();
    System.out.println("删除消耗的时间 " + (twoDate.getTime() - oewDate.getTime()) + " 毫秒， 没实现数据库连接池");

    // 3. 【调用响应对象】将处理结果以二进制写入到响应体，交给浏览器
    response.setContentType("text/html;charset=utf-8");
    out = response.getWriter();
    if (result == 1) {
      out.print("<font style='color:red;font-size:40'>用户信息删除成功</font>");
    } else {
      out.print("<font style='color:red;font-size:40'>用户信息删除失败</font>");
    }
  }
}

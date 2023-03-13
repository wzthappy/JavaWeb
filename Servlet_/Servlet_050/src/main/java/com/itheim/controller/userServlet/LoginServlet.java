package com.itheim.controller.userServlet;

import com.itheim.doa.UserService;
import com.itheim.doa.impl.UserDao;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
  UserService dao = new UserDao();

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String userName, password;

    // 1. 调用请求对象对请求体使用utf-8字符集进行重新编辑
    request.setCharacterEncoding("utf-8");

    // 2. 调用请求对象读取请求体参数信息
    userName = request.getParameter("userName");
    password = request.getParameter("password");

    // 3. 调用Dap将查询验证信息推送到服务器上
    int login = dao.login(userName, password);

    // 4. 调用响应对象，根据验证结果将不同资源文件地址写入到响应头，交给浏览器
    if (login == 1) { // 用户存在
      // 在判断来访用户身份合法后，通过请求对象向Tomcat申请为当前用户申请一个HttpSession
      HttpSession session = request.getSession();
      response.sendRedirect("http://localhost/Servlet_050_war_exploded/index.html");
    } else if (login >= 2) {
      response.setContentType("text/html;charset=utf-8");
      PrintWriter writer = response.getWriter();
      writer.print("你的账号是正确的，可有多个与你账号、密码相同。可能是服务器溶于(其实是我添加数据时没有进行判断!)，" +
          "这个情况可以和管理员反馈!");
    } else {
      response.sendRedirect("http://localhost/Servlet_050_war_exploded/login_error.html");
    }
    System.out.println(login);
  }
}

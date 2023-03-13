package com.itheima.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 用户点击了注册按钮
 * 判断注册页面是否成功
 */
public class RegisterServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // ..... 注册页面用户名密码等代码处理

    // 我只处理验证码是否正确
    // 1. 获取用户输入的验证码
    String checkCode = request.getParameter("checkCode");

    // 2. 获取验证码数据
    HttpSession session = request.getSession();
    String checkCodeGen = (String) session.getAttribute("checkCodeGen");
    String zc = null;
    //              忽略大小写比对
    if(checkCodeGen.equalsIgnoreCase(checkCode)) {   // 判断用户输入的和生成的验证码是否相同
      // 相同     允许注册
      zc = "注册成功!";
    } else {
      // 不相同   不允许注册
      zc = "注册失败!";
    }
    request.setAttribute("zc", zc);
    request.getRequestDispatcher("/index.jsp").forward(request, response);  // 转发   数据包也发到了资源文件中
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doGet(request, response);  // 这里调用了doGet();  把自己的请求包数据给了过去
  }
}

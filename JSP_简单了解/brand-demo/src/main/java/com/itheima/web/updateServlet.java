package com.itheima.web;

import com.itheima.pojo.User;
import com.itheima.servlce.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class updateServlet extends HttpServlet {
  UserService userService = new UserService();

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    User user = null;
    // 1. 接送表单提交的数据，封装为一个User对象
    Integer id = Integer.valueOf(request.getParameter("id"));
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String gender = request.getParameter("gender");
    String addr = request.getParameter("addr");

    // 封装一个User对象
    user = new User(id, username, password, gender, addr);

    // 2. 调用 service 完成修改
    userService.update(user);

    // 3. 转发到查询所有servlet
    request.getRequestDispatcher("/selectAllServlet").forward(request, response);
  }
}

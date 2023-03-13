package com.itheima.web;

import com.itheima.pojo.User;
import com.itheima.servlce.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends HttpServlet {
  private UserService userService = new UserService();
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    User user = null;
    // 1. 接送表单提交的数据，封装为一个User对象
    String username = req.getParameter("username");
    String password = req.getParameter("password");
    String gender = req.getParameter("gender");
    String addr = req.getParameter("addr");

    // 封装一个User对象
    user = new User(null, username, password, gender, addr);

    // 2. 调用 service 完成添加
    userService.add(user);

    // 3. 转发到查询所有servlet
    req.getRequestDispatcher("/selectAllServlet").forward(req, resp);
  }
}

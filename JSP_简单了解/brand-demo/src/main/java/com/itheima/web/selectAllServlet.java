package com.itheima.web;

import com.itheima.pojo.User;
import com.itheima.servlce.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class selectAllServlet extends HttpServlet {
  private UserService userService = new UserService();
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 1. 调用UserService完成查询
    List<User> users = userService.selectAll();

    // 2. 存入req域中
    req.setAttribute("users", users);

    // 3. 转发到user.jsp
    req.getRequestDispatcher("/user.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    this.doGet(req, resp);
  }
}

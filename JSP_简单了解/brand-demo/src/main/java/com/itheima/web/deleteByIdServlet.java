package com.itheima.web;

import com.itheima.servlce.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class deleteByIdServlet extends HttpServlet {
  UserService userService = new UserService();
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String id = request.getParameter("id");

    // 调用 userService 中的删除数据方法
    userService.delete(Integer.parseInt(id));

    // 删除完毕后，转载到查询所有页面
    request.getRequestDispatcher("/selectAllServlet").forward(request, response);
  }
}

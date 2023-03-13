package com.itheima.web;

import com.itheima.pojo.User;
import com.itheima.servlce.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class selectByIdServlet extends HttpServlet {
  UserService service = new UserService();
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 1. 接收id
    String id = request.getParameter("id");
    // 2. 调用servlet查询
    User user = service.selectById(Integer.parseInt(id));
    // 3. 存储到req中
    request.setAttribute("user", user);

    // 4. 转发到update.jsp
    request.getRequestDispatcher("/update.jsp").forward(request, response);
  }
}

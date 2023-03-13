package com.itheima.web;

import com.alibaba.fastjson.JSON;
import com.itheima.JSON.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 1. 创建一个假数据
    User user1 = new User(31, "zzzz", "adsa");
    User user2 = new User(232, "cccc", "adsa12312");
    User user3 = new User(333, "ddddd", "ad2312");
    List<User> users = new ArrayList<>();
    users.add(user1);
    users.add(user2);
    users.add(user3);

    // 2. 将集合转换为JSON数据  序列化
    String s = JSON.toJSONString(users);

    // 3. 响应数据
    resp.setContentType("text/json;charset=utf-8");
    resp.getWriter().print(s);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    this.doGet(req, resp);
  }
}

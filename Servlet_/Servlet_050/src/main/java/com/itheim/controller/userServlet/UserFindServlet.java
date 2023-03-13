package com.itheim.controller.userServlet;

import com.itheim.doa.UserService;
import com.itheim.doa.impl.UserDao;
import com.itheim.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet("/user/find")
public class UserFindServlet extends HttpServlet {
  UserService dao = new UserDao();
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    PrintWriter out;

    // 1. 【调用DAO】将查询命令推送到数据库服务器上，得到所有用户信息【list】
    List<User> all = dao.findAll();

    // 2. 【调用响应对象】将用户信息结合<table>标签命令以二进制形式写入到响应体
    response.setContentType("text/html;charset=utf-8");
    out = response.getWriter();
    out.print("<table border='2' align='center'>");
    out.print("<tr>");
    out.print("<th>用户编号</th>");
    out.print("<th>用户姓名</th>");
    out.print("<th>用户密码</th>");
    out.print("<th>用户性别</th>");
    out.print("<th>用户邮箱</th>");
    out.print("<th>操作</th>");
    out.print("</tr>");
    all.forEach(rs -> {
      out.print("<tr>");
      out.print("<td>" + rs.getUserId() + "</td>");
      out.print("<td>" + rs.getUserName() + "</td>");
      out.print("<td>******</td>");
      out.print("<td>" + rs.getSex() + "</td>");
      out.print("<td>" + rs.getEmail() + "</td>");
      out.print("<td><a href='http://localhost/Servlet_050_war_exploded/user/delete?userId=" + rs.getUserId() + "'>删除用户</a></td>");
      out.print("</tr>");
    });
    out.print("</table>");
  }
}

package kaoshi.controller;

import kaoshi.utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class lognUserServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws IOException {
    PrintWriter writer = resp.getWriter();
    String user = request.getParameter("user");
    String pwd = request.getParameter("pwd");

    try {
      Connection connection = DBUtil.getConnection();
      String sql = "select count() from tb_user where username = ? and password = ?";
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, user);
      preparedStatement.setString(2, pwd);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet != null) {
        Cookie cookie1 = new Cookie("user", user);
        cookie1.setMaxAge(60 * 100);
        Cookie cookie2 = new Cookie("pwd", pwd);
        cookie2.setMaxAge(60 * 100);
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
        writer.print("成功登录");
        resp.sendRedirect("/lll.jsp");  // 首页
      }
      resp.sendRedirect("/relogin.jsp"); // 注册页面

      DBUtil.close(connection, preparedStatement, resultSet);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }


    writer.print("m");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    this.doGet(req, resp);
  }
}

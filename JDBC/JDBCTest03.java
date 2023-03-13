package JavaWeb.JDBC;

import java.sql.*;
import java.util.*;

/*
    实际开发中不建议把数据库的信息写死到java程序中
 */
// TODO 将连接数据库的所有消息配置到配置文件中
public class JDBCTest03 {
  public static void main(String[] args) {

    // 使用资源绑定器绑定属性配置文件                          路径
    ResourceBundle bundle = ResourceBundle.getBundle("JDBC.JDBCTest03");
    String driver = bundle.getString("driver");
    String url = bundle.getString("url");
    String user = bundle.getString("user");
    String password = bundle.getString("password");

    Connection conn = null;
    Statement stmt = null;
    try {
      // 1. 注册驱动
      Class.forName(driver);

      // 2. 获取连接
      conn = DriverManager.getConnection(url, user, password);

      // 3. 获取数据库操作对象 (Statement专门执行sql语句的)
      stmt = conn.createStatement();

      // 4. 执行sql
      String sql = "delete from category where cCategoryld = '002'";
      int count = stmt.executeUpdate(sql);
      System.out.println(count == 1 ? "删除成功" : "删除失败");

      // 5. 处理查询结果集

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      // 6. 释放资源
      if (stmt != null) {
        try {
          stmt.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      if (stmt != null) {
        try {
          conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
  }
}

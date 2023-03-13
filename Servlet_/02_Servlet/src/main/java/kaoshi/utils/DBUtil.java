package kaoshi.utils;

import java.sql.*;

public class DBUtil {
  // 工具类中的构造方法都是私有的
  private DBUtil() {};

  //  静态代码块在类加载时执行，并且只执行一次
  static {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  // 获取数据库连接对象     返回连接对象
  public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(
        "jdbc:mysql://127.0.0.1:3306/wanzhi?useSSL=false&serverTimezone=GMT",
        "root", "18729231365wzt");
  }

  // 关闭资源                   连接对象        数据库操作对象    结果集
  public static void close(Connection conn, Statement ps, ResultSet rs) {
    if (rs != null) {
      try {
        rs.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    if (ps != null) {
      try {
        ps.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    if (conn != null) {
      try {
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}

package JavaWeb.回顾JDBC部分内容和增加内容;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;

public class JDBCDemo01 {

  // 获取JDBCTest中的信息
  public static HashMap<String, String> init() {
    HashMap<String, String> xx = new HashMap<String,String>();
    ResourceBundle bundle = ResourceBundle.getBundle("JavaWeb/回顾JDBC部分内容和增加内容/JDBCTest");
    String driver = bundle.getString("driver");
    String url = bundle.getString("url");
    String user = bundle.getString("user");
    String password = bundle.getString("password");
    xx.put("driver", driver);
    xx.put("url", url);
    xx.put("user", user);
    xx.put("password", password);
    return xx;
  }

  public static void main(String[] args) {
    HashMap<String, String> init = init();
    Connection conn = null;
    PreparedStatement ps = null;

    try {
      // 1. 注册驱动
      Class.forName(init.get("driver"));

      // 2. 获取连接对象
      conn = DriverManager.getConnection(init.get("url"), init.get("user"), init.get("password"));

      // 3. 对应sql语句
      String sql = "update course set 学分 = ? where 课程号 = ?";
      ps = conn.prepareStatement(sql);

      ps.setInt(1, 0);
      ps.setString(2, "31001");

      // 4. 执行sql语句
      int i = ps.executeUpdate();
      System.out.println(i);

      ps.setInt(1, 0);
      ps.setString(2, "31002");
      int i1 = ps.executeUpdate();
      System.out.println(i1);

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      // 5. 释放资源
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

  @Test
  public void i() {
    boolean asadadda = "wwww3232".matches("\\w{6,12}");
    System.out.println(asadadda);
  }
}

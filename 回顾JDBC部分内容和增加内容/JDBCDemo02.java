package JavaWeb.回顾JDBC部分内容和增加内容;

import JavaWeb.回顾JDBC部分内容和增加内容.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCDemo02 {

  public static void main(String[] args) {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
      // 1. 连接mysql
      conn = DBUtil.getConnection();

      // 2. 定义sql语句
      String sql = "select * from course";
      ps = conn.prepareStatement(sql);

      // 3. 执行sql语句
      rs = ps.executeQuery();
      while (rs.next()) {  // 迭代几个主要的数据
        String id = rs.getString("课程号");
        String getName = rs.getString("课程名");
        int xueFe = rs.getInt("学分");

        System.out.println(id + "，" + getName + "，" + xueFe);
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      // 释放资源
      DBUtil.close(conn, ps, rs);
    }
  }
}

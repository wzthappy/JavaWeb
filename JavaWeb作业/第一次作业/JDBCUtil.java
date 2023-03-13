package 第一次作业;

import java.sql.*;
import java.util.UUID;

public class JDBCUtil {
  private static Connection conn = null;

  static {
    try {
      // 注册驱动  mysql 8 以后就不需要了
//      Class.forName("com.mysql.cj.jdbc.Driver");
      // 建立连接
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaweb", "root", "18729231365wzt");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // 返回连接对象
  public Connection getConnection() {
    return conn;
  }

  // 关闭资源
  public void close(Connection conn, Statement ps, ResultSet rs) {
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

class Test {
  public static void main(String[] args) {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    JDBCUtil jdbcUtil = new JDBCUtil();
    conn = jdbcUtil.getConnection();

    try {
      int i;
      conn.setAutoCommit(true); // 开启事务，防止错误执行

      // 对应的sql语句
      String sql1 = "insert into user value (?, ?, ?)"; // 插入
      String sql2 = "update user set login_act = ?, login_pwd = ? where id = ?"; // 修改
      String sql3 = "delete from user where id = ?"; // 删除
      String sql4 = "select * from user"; // 查询 所有

      // 1. 获取 数据库操作对象    插入语句
      System.out.println("---------- 插入 ---------");
      ps = conn.prepareStatement(sql1);
      // 设置插入的数据
      String s = UUID.randomUUID().toString().replaceAll("-", "");
      ps.setString(1, s);
      ps.setString(2, "中国" + s.substring(2, 4));
      ps.setString(3, "123456");
      // 执行
      i = ps.executeUpdate();
      if (i != 1) System.out.println("添加失败");
      else System.out.println("添加成功");

      // 2. 查询
      System.out.println("----------- 查询 ------------");
      ps = conn.prepareStatement(sql4);
      rs = ps.executeQuery();
      int index = 0;
      String id1 = null;
      String id2 = null;
      while (rs.next()) {
        System.out.println(rs.getString(1) + ", " +
            rs.getString(2) + ", " + rs.getString(3));
        index++;
        if (index == 5) {  // 修改第五个用户
          // 随机获取id值
          id1 = rs.getString(1);
        }
        if (index == 2) {  // 删除第二个用户
          // 随机获取id值
          id2 = rs.getString(1);
        }
      }

      // 3. 修改
      System.out.println("--------- 修改 获取id1的用户 ----------");
      ps = conn.prepareStatement(sql2);
      ps.setString(3, id1);
      ps.setString(1, "修改成功");
      ps.setString(2, "修改成功");
      i = ps.executeUpdate();
      if (i != 1) System.out.println("修改失败");
      else System.out.println("修改成功");

      // 4. 删除
      System.out.println("--------- 删除 获取id的用户 ---------");
      ps = conn.prepareStatement(sql3);
      ps.setString(1, id2);
      i = ps.executeUpdate();
      if (i != 1) System.out.println("删除失败");
      else System.out.println("删除成功");

    } catch (Exception e) {
      e.printStackTrace();
      try {
        conn.rollback();  // 如果执行时报错就 回滚
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    } finally {
      // 释放资源
      jdbcUtil.close(conn, ps, rs);
    }
  }
}


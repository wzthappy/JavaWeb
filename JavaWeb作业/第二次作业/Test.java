package 第二次作业;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class Test {
  public static void main(String[] args) {
    // ------ TODO: 以下代码 主要是 回顾反射 内容 、 并不是故意写的不好  ^_^
    Scanner sc = new Scanner(System.in);
    Connection connection = null;
    PreparedStatement st = null;
    ResultSet rs = null;
    Class<?> clazz = null;
    Object obj = null;
    int i1 = -1;
    try {
      // 通过反射 获取连接对象
      clazz = Class.forName("第二次作业.JDBCUtil");
      Constructor<?> constructor = clazz.getDeclaredConstructor(); // 返回这个内的无参构造对象
      obj = constructor.newInstance(); // 根据构造方法 创建指定的对象
      Method getConnection = clazz.getMethod("getConnection"); // 获取getConnection方法
      // 获取connection对象   数据库连接对象
      connection = (Connection) getConnection.invoke(obj); // 执行getConnection方法
      // 开启事务
      connection.setAutoCommit(true);

      // 通过反射获取 sql语句 、 私有 的属性
      Class<?> dataClass = Class.forName("第二次作业.Data");
      Constructor<?> declaredConstructor = dataClass.getDeclaredConstructor();
      Object dataObj = declaredConstructor.newInstance(); // 根据构造方法 创建指定的对象
      Method getZX = dataClass.getDeclaredMethod("getZX", PreparedStatement.class, String.class);
      getZX.setAccessible(true);
      Method south = dataClass.getDeclaredMethod("south", ResultSet.class);
      south.setAccessible(true);
      // 获取sql语句    根据id查询       新增      根据id删除   修改指定账号的元素    查询所有id
      String[] sql = {"querySql", "insertSql", "deleteSql", "updateSql", "queryAllIdSql"};
      Map<String, String> map = new HashMap<>();
      Field[] fields = dataClass.getDeclaredFields();
      for (int i = 0; i < sql.length; i++) {
        fields[i].setAccessible(true);
        map.put(sql[i], (String) fields[i].get(dataObj));
      }

      // 通过反射获取 PreparedStatement 对象
      Method getStatement = clazz.getMethod("getStatement", Connection.class, String.class);

      GUI gui = new GUI();
      gui.guiShow();
      boolean file = true;
      while (file) {
        String s = sc.nextLine();
        switch (s) {
          case "1" -> { // 根据id查询
            String querySql = map.get("querySql");
            st = (PreparedStatement) getStatement.invoke(obj, connection, querySql);
            System.out.println("---- 请输入要查询的id号 ----");
            String s1 = sc.nextLine();
            st.setString(1, s1);
            rs = (ResultSet) getZX.invoke(dataObj, st, querySql);
            south.invoke(dataObj, rs);
          }
          case "2" -> { // 根据id修改
            String updateSql = map.get("updateSql"); // "update user set login_pwd = ? where login_act = ?"
            st = (PreparedStatement) getStatement.invoke(obj, connection, updateSql);
            // 传递对应的参数
            System.out.println("---- 请输入您的账号: ----");
            String s2 = sc.nextLine();
            System.out.println("---- 请输入您要修改的密码: ----");
            String s1 = sc.nextLine();
            st.setString(1, s1);
            st.setString(2, s2);
            i1 = (int) getZX.invoke(dataObj, st, updateSql);
            if (i1 <= 0) System.out.println("失败");
            else System.out.println("成功");
          }
          case "3" -> { // 根据id删除
            String deleteSql = map.get("deleteSql"); // delete from user where id = ?
            st = (PreparedStatement) getStatement.invoke(obj, connection, deleteSql);
            System.out.println("------- 请输入您要删除的用户id --------");
            String s1 = sc.nextLine();
            st.setString(1, s1);
            i1 = (int) getZX.invoke(dataObj, st, deleteSql);
            if (i1 <= 0) System.out.println("失败");
            else System.out.println("成功");
          }
          case "4" -> { // 新增一个用户
            String insertSql = map.get("insertSql"); // insert into user value (?, ?, ?)
            st = (PreparedStatement) getStatement.invoke(obj, connection, insertSql);
            String id = UUID.randomUUID().toString().replaceAll("-", "");
            System.out.println("------- 用户名 -------");
            String s1 = sc.nextLine();
            System.out.println("------ 密码 ------");
            String s2 = sc.nextLine();
            st.setString(1, id);
            st.setString(2, s1);
            st.setString(3, s2);
            i1 = (int) getZX.invoke(dataObj, st, insertSql);
            if (i1 <= 0) System.out.println("失败");
            else System.out.println("成功");
          }
          case "5" -> { // 查询所有id
            String queryAllIdSql = map.get("queryAllIdSql"); // "select * from user"
            st = (PreparedStatement) getStatement.invoke(obj, connection, queryAllIdSql);
            rs = (ResultSet) getZX.invoke(dataObj, st, queryAllIdSql);
            south.invoke(dataObj, rs);
          }
          default -> file = false; // 退出
        }
        gui.guiShow();
      }

    } catch (Exception e) {
      // 失败 回滚事务
      try {
        if (connection != null) connection.rollback();
      } catch (SQLException ex) {
        System.out.println("--- 回滚失败! ---");
      }
      e.printStackTrace();
    } finally {
      try {
        // 释放资源
        if (clazz != null && obj != null) {
          Method close = clazz.getMethod("close", Connection.class, Statement.class, ResultSet.class);
          close.invoke(obj, connection, st, rs);
        } else System.out.println("您的内存正在泄漏，请联系管理员进行修改!!!");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}


// sql 语句和运行的 代码、数据    --- 这里面的成员变量和成员方法都设置成私有的
class Data {
  private final String query = "select * from user where id = ?";  // 查询指定的用户
  private final String insert = "insert into user value (?, ?, ?)"; // 新增一个用户
  private final String delete = "delete from user where id = ?"; // 删除指定的用户
  private final String update = "update user set login_pwd = ? where login_act = ?"; // 修改指定账号的元素
  private final String queryAllId = "select * from user"; // 查询所有id


  // 返回执行sql的对象
  private Object getZX(PreparedStatement st, String sql) {
    try {
      int select = sql.indexOf("select"); // 判断要执行的sql语句是否为查询语句
      if (select < 0) { // 不是查询语句
        return st.executeUpdate();
      } else {  // 是查询语句
        ResultSet rs = st.executeQuery();
        return rs;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  // 打印 ResultSet 中的内容
  private void south(ResultSet rs) {
    try {
      int i = 0;
      System.out.println("id \t 账号 \t 密码");
      System.out.println("-------------------");
      while (rs.next()) { // 输入
        System.out.println(rs.getString(1) + " \t " + rs.getString(2) + " \t " +
            rs.getString(3));
        i++;
      }
      if (i <= 0) System.out.println("请输入正确且存在的id号!");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}


// JDBC 简单工具类
class JDBCUtil {
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

  // 返回数据库操作对象
  public PreparedStatement getStatement(Connection conn, String sql) {
    try {
      return conn.prepareStatement(sql);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  // 关闭资源
  public void close(Connection conn, Statement ps, ResultSet rs) {
    try {
      if (rs != null) {
        rs.close();
      }
      if (ps != null) {
        ps.close();
      }
      if (conn != null) {
        conn.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

class GUI {
  public void guiShow() {
    System.out.println("\n+++++++++++++++++++++++");
    System.out.println("---- 1. 根据id查询 ----");
    System.out.println("---- 2. 根据id修改 ----");
    System.out.println("---- 3. 根据id删除 ----");
    System.out.println("---- 4. 根据id新增 ----");
    System.out.println("---- 5. 查询所有数据 ----");
    System.out.println("---- e.   退出    ----");
    System.out.println("+++++++++++++++++++++++");
  }
}
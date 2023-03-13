package JavaWeb.JDBC;
/*
	JDBC编程六步
*/

import java.sql.*;

/*
		// TODO 报错    看看就可以了
 */
public class JDBCTest01 {

  public static void main(String[] args) {
    Connection conn = null;
    Statement stmt = null;
    try {
      // 1. 注册驱动
      Driver driver = new com.mysql.cj.jdbc.Driver(); // 多态，父类型应用指向子类型对象
      DriverManager.registerDriver(driver);
      // 2. 获取连接
      String url = "jdbc:mysql://192.168.1.185:3306/wanzhi";
			/*
				jdbc:mysql://  	协议
				127.0.0.1  ||  192.168.1.185	 本机IP地址
				3306 		mysql端口号
				wanzhi 		自己有的数据库名
			 */
      String user = "root";
      String password = "18729231365wzt";
      conn = DriverManager.getConnection(url, user, password);
      System.out.println("数据库连接对象 = " + conn);

      // 3. 获取数据库操作对象 (Statement专门执行sql语句的)
      stmt = conn.createStatement();

      // 4. 执行sql
      String sql = "insert into 表名(字段...) values(值...)";   // 我只添加了一条记录
      // 执行DML语句的 (insert delete update)
      // 返回值是 " 影响数据库中的记录条数 "		影响了一条
      int count = stmt.executeUpdate(sql);  // 返回1
      System.out.println(count == 1 ? "保存成功" : "保存失败");

      // 5. 处理查询结果集

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      // 6. 释放资源
      // 为了保证资源一定释放，在finally语句块中关闭资源
      // 并且要遵循从小到大依次关闭
      // 分别对其try .. catch
      if (stmt != null) {
        try {
          stmt.close();
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
}

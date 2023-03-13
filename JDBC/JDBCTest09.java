package JavaWeb.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
    TODO    PreparedStatement   完成 insert  delete  update
 */
public class JDBCTest09 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 1. 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wzt", "root", "18729231365wzt");
            // 3. 获取预编译的数据库操作对象   -----------
            String sql = "insert into t_user values(?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,23);
            ps.setString(2,"布局");
            ps.setString(3,"及的三大");
            ps.setString(4,"we2ee");
            // 4. 执行SQL
            int count = ps.executeUpdate();
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6. 释放资源
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
}

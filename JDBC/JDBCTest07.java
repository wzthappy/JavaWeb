package JavaWeb.JDBC;

import java.sql.*;
import java.util.Scanner;

public class JDBCTest07 {
    public static void main(String[] args) {
        // 用户在控制输入desc就是降速，输入asc就是升序
        Scanner s = new Scanner(System.in);
        System.out.println("请输入desc或asc，desc表示降序，asc表示升序");
        System.out.println("请输入: ");
        String keyWords = s.nextLine();

        // 执行SQL
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wzt","root","18729231365wzt");
            // 获取数据库操作对象
            stmt = conn.createStatement();
            // 执行SQL
            String sql = "select id,loginName as l from t_user order by id " + keyWords;
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "," + rs.getString("l") );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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

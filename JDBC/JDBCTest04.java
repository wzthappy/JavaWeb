package JavaWeb.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

/*
    处理查询结果集
 */
public class JDBCTest04 {
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("JDBC.JDBCTest03");
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String password = bundle.getString("password");

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // 1. 注册驱动
            Class.forName(driver);
            // 2. 获取连接
            conn = DriverManager.getConnection(url,user,password);
            // 3. 获取数据库操作对象
            stmt = conn.createStatement();
            // 4. 执行sql
            String sql = "select * from preferredcategory";
            rs = stmt.executeQuery(sql);  // 专门执行DQL语句的方法
            // 5. 处理查询结果集
//            boolean flag1 = rs.next();
//            System.out.println(flag1); // true
//            if(flag1) {
//                // 光标指向的行有数据
//                // 取数据
//                // getString() 方法的特点是: 不管数据库中的数据类型是什么，都以String的形式取出
//                String string1 = rs.getString(1);// JDBC中所有下标从1开始。不是从0开始
//                String string2 = rs.getString(2);// JDBC中所有下标从1开始。不是从0开始
//                String string3 = rs.getString(3);// JDBC中所有下标从1开始。不是从0开始
//                System.out.println(string1 + "," + string2 + "," + string3);
//            }
            while (rs.next()) {
                // 除了可以以String类型除外，还可以特定的类型取出
                int string1 = rs.getInt(1);
                String string2 = rs.getString(2);
//                String string3 = rs.getString(3);
                //                                  列名称不是表中的列名称，是查询集的列名称    as 别名
                String string3 =  rs.getString("cDescription"); // 列名 以字符串的方法
                System.out.println(string1 + 7 + "," + string2 + "," + string3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6. 释放资源
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

package JavaWeb.JDBC;

/*
    注册驱动的另一种方法 (这种方法常用)
 */
import java.sql.*;

public class JDBCTest02 {
    public static void main(String[] args) {
        try {
            // 1. 注册驱动
            // 这是注册驱动的第一种方法
//            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            // 注册驱动的第二种方式
            // 这种方式常用 因为参数是一个字符串，字符串可以写到  xxx.properties文件中
            // 不需要接收  因为我们只想用他的类加载动作
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. 获取连接
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wanzhi","root","18729231365wzt");
             System.out.println("数据库连接对象 = " + conn);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

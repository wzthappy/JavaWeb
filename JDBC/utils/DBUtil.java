package JavaWeb.JDBC.utils;

import java.sql.*;

/*
TODO -
    JDBC工具类，简化JDBC编程
 */
public class DBUtil {
    /*
        TODO   工具类中的构造方法都是私有的
                因为工具类当中的方法都是静态的，不需要new对象，直接采用类名调用
     */
    private DBUtil() {};

    // TODO   静态代码块在类加载时执行，并且只执行一次
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 获取数据库连接对象     返回连接对象
    public static Connection getConnection() throws SQLException {
                                            //                              可改
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/wzt", "root", "18729231365wzt");
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

package JavaWeb.JDBC;

import JavaWeb.JDBC.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
TODO
    这个程序有两个任务:
        第一: 测试DBUTil是否好用
        第二: 模糊查询怎么写
 */
public class JDBCTest12 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 获取连接
            conn = DBUtil.getConnection();
            // 获取预编译的数据库操作对象
            String sql = "select id,loginName as lm from t_user where loginPwd like ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"_2%");
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ", " + rs.getString("lm"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            DBUtil.close(conn, ps, rs);
        }
    }
}

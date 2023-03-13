package JavaWeb.JDBC.悲观锁_行级锁;

import JavaWeb.JDBC.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/*
    TODO
      这个程序开启一个事务，这个事务专门进行查询，并且使用行级锁/悲观锁，锁住相关的记录
 */
public class JDBCTest14 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            // 开启事务
            conn.setAutoCommit(false);

            String sql = "select id,loginName as ln,loginPwd as lp from t_user where id = ? for update";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,2);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ", "
                        + rs.getString("ln") + ", "
                        + rs.getString("lp"));
            }

            // 需要卡住
            new Scanner(System.in).nextLine();

            // 提交事务 (事务结束)
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    // 回滚事务 (事务结束)
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, rs);
        }
    }
}

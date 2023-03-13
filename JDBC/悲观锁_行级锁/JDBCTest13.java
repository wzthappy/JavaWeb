package JavaWeb.JDBC.悲观锁_行级锁;

import JavaWeb.JDBC.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
    TODO
        这个程序负责修改锁定的记录
 */
public class JDBCTest13 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);

            String sql = "update t_user set loginName = ? where id = ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"哈哈");
            ps.setInt(2,2);
            int count = ps.executeUpdate();
            System.out.println(count);

            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, null);
        }
    }
}

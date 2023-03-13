package JavaWeb.JDBC;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
    TODO 1. 解决SQL注入问题
            只要用户提供的消息不参与SQL语句的编译过程，问题就解决了。
            即使用户提供的消息中含有SQL语句的关键字，但是没有参与编译，不起作用。
            要想用户消息不参与SQL语句的编译，那么必须使用java.sql.PreparedStatement
            PreparedStatement接口继承了 java.sql,Statement
            PreparedStatement是属于预编译的数据操作对象
            PreparedStatement的原理是: 预先对SQL语句的框架进行编译，然后再给SQL语句传“值”;
        2. 测试结果:
            用户名: fdas
            密码: fdas' or '1' = '1
            登录失败
        3. 解决SQL注入的关键是:
            用户提供的消息中即使含有sql语句的关键字，但是这些关键字并没有参与编译. 不起作用.
        4. 对比一下Statement和PreparedStatement:
            - Statement存在sql注入问题，PreparedStatement解决了SQL注入问题
            - Statement是编译一次执行一次。 PreparedStatement是编译一次，可执行N次，效率高一些
            - PreparedStatement会在编译阶段做类型的安全检查
                                     -
            综上所述: PreparedStatement使用较多。 只有极少情况下需要使用Statement
       5. 什么情况下必须使用Statement了:
            业务方面要求必须支持SQL注入的时
            Statement支持SQL注入
 */
public class JDBCTest06_解决SQL注入 {
    public static void main(String[] args) {
        // 初始化一个界面
        Map<String, String> userLoginInfo = initUI();
        // 验证用户名和密码
        boolean loginSuccess = login(userLoginInfo);
        // 最后输出结果
        System.out.println(loginSuccess ? "登录成功" : "登录失败");
    }

    /*
        用户登录
        TODO false表示失败，
     */
    private static boolean login(Map<String, String> userLoginInfo) {
        // 打标记的意识
        boolean loginSuccess = false;
        // 单独定义变量
        String loginName = userLoginInfo.get("loginName");
        String loginPwd = userLoginInfo.get("loginPwd");
        // JDBC代码
        Connection conn = null;
//        Statement stmt = null;
        PreparedStatement ps = null;   // 这里使用PreparedStatement
        ResultSet rs = null;

        try {
            // 1. 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 执行连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wzt", "root", "18729231365wzt");
            // 3. 获取预编译的数据库操作对象
            // SQL语句的框子。其中一个?，表示一个占位符，一个？将来接收一个"值".   注意: 占位符不能用单引号括起来。
            String sql = "select * from t_user where loginName = ? and loginPwd = ?";  // ? 值  占位符
            // 程序执行到此处。会发送sql语句框子给DBMS，然后DBMS进行DBMS进行sql语句的预先编译
            ps = conn.prepareStatement(sql);
            // 给占位符？传值 (第一个问号下标是1，第二个问号下标是2，JDBC中所有下标从1开始)
            ps.setString(1,loginName);
            ps.setString(2,loginPwd);
            // 4. 执行sql
            rs = ps.executeQuery();

            // 5. 处理结果集
            if (rs.next()) {
                // 登录成功
                loginSuccess = true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6. 释放资源
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
        return loginSuccess;
    }

    /*
        初始化界面
        TODO 用户输入的用户名和密码等登录信息
     */
    private static Map<String, String> initUI() {
        Scanner s = new Scanner(System.in);

        System.out.println("用户名: ");
        String loginName = s.nextLine();

        System.out.println("密码: ");
        String loginPwd = s.nextLine();

        Map<String, String> userLoginInfo = new HashMap<>();
        userLoginInfo.put("loginName", loginName);
        userLoginInfo.put("loginPwd", loginPwd);

        return userLoginInfo;
    }
}

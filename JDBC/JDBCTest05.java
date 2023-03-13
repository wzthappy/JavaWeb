package JavaWeb.JDBC;


import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
    实现功能:
        1. 需求: 模拟用户登录功能的实现
        2. 业务描述:
            程序运行时，提出一个输入的入口，可以让用户输入用户名和密码
            用户输入用户名和密码之后，提交消息，java程序收集到用户消息
            java程序连接数据库验证用户名和密码是否合法
            合法: 显示登录成功
            不合法:  显示登录失败
        3. 数据的准备:
        4. 当前程序存在的问题:
            用户名: fdsa
            密码: fdsa' or '1'='1
            登录成功
            这种现象被称为SQL注入(安全隐患)。 (黑客经常使用)
        5. 导致SQL注入的根本原因是什么？
            用输入的消息中含有sql语句的关键字，并且这些关键字参与sql语句的编译过程，
            导致sql语句的愿意被扭曲，进而到达sql注入
 */
public class JDBCTest05 {
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
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 1. 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 执行连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wzt", "root", "18729231365wzt");
            // 3. 获取数据库操作对象
            stmt = conn.createStatement();
            // 4. 执行sql
            String sql = "select * from t_user where loginName = '" + loginName + "' and loginPwd = '" + loginPwd + "' ";
            // 以上正好完成了sql语句的拼接，以下代码的含义是，发送sql语句个DBMS，DBMS进行sql编译.
            // 在好将用户提供的"非法消息"编译进去。导致了源sql语句含义被扭曲了.
            rs = stmt.executeQuery(sql);
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

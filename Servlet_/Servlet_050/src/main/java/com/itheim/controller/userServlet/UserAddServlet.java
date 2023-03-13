//package com.itheim.controller.userServlet;
//
//import com.itheim.doa.UserService;
//import com.itheim.doa.impl.UserDao;
//import com.itheim.pojo.User;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.Date;
/**
 * 这里的代码用反射的方式写了
 */
//@WebServlet("/user/add")
//public class UserAddServlet extends HttpServlet {
//  UserService dao = new UserDao();
//  @Override
//  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    int result = 0;
//    User user = null;
//    String userName, password, sex, email;
//    PrintWriter writer = null;
//    // 1. 【调用请求对象】读取【请求头】参数消息，得到用户的注册消息
//    userName = req.getParameter("userName");
//    password = req.getParameter("password");
//    sex = req.getParameter("sex");
//    email = req.getParameter("email");
//    user = new User(null, userName, password, sex, email);
//    Date startDate = new Date();  // 开始时间
//    dao.userMapper(req);  // 把全局作用域交给UserDao类
//    result = dao.add(user);
//    Date endDate = new Date();  // 结束时间
//    System.out.println("添加消耗时间 = " + (endDate.getTime() - startDate.getTime())
//        + "毫秒， 实现了数据库连接池");  // 40 - 50  ->  12
//
//    // 3. 【调用响应对象】将【处理结果】以二进制的形式写入到响应体中
//    resp.setContentType("text/html;charset=utf-8");
//    writer = resp.getWriter();
//    if (result == 1) {
//      writer.print("<font style='color:red;font-size:40'>用户信息注册成功</font>");
//    } else {
//      writer.print("<font style='color:red;font-size:40'>用户信息注册失败</font>");
//    }
//  }
//  // Tomcat负责销毁【请求对象】和【响应对象】
//  // Tomcat负责将Http响应协议包推送到发起请求到浏览器上
//  // 浏览器根据响应头content-type指定编译器对响应体二进制内容编辑
//  // 浏览器将编辑后的结果在窗口中展示给用户【结束】
//}

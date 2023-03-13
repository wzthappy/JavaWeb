package com.bjpowernode.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 问题描述:  浏览器接收到的数据是2，不是50
 * <p>
 * 问题的原因:
 * writer.write 方法可以将 【字符】，【字符串】，【ASCII】写入到响应体
 * 【ASCII】: a ---------------- 97
 * 2 ---------------- 50
 * 问题解决方案: 实际开发过程中，都是通过 writer.print() 将真实数据写入到响应体
 */
public class TwoServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int money = 50; // 执行结果

    PrintWriter writer = resp.getWriter();

//    writer.write(money);   // 2
    writer.print(money);

  }
}

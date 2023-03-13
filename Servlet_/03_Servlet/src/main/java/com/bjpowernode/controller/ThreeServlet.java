package com.bjpowernode.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ThreeServlet extends HttpServlet {
  /**
   * 问题描述: Java<br/>MySQL<br/>HTML<br/>
   * 浏览器在接收到响应结果时，将<br/>作为
   * 文字内容在窗口展示出来了，没有将<br/>
   * 当做HTML标签命令来执行
   * 问题原因:
   * 浏览器在接收到响应包之后，根据【响应头中content-type】
   * 属性的值，来采用对应【编译器】 对 【响应体中二进制内容】 进行编译处理
   * <p>
   * 在默认情况下，content-type属性的值"text"  content-type="text"
   * 此时浏览器会采用【文本编译器】对响应体二进制数据进行解析
   * <p>
   * 解决方案:
   * 一定要在得到输出流之前，通过响应对象对响应头中content-type属性进行
   * 一次重新赋值用于指定浏览器采用正确编译器
   */

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String result = "<h1>Java<br/>MySQL<br/>HTML<br/></h1>";  // 既有文字又有HTML标签命令
    String result2 = "红烧排骨<br/>梅菜肘子<br/>糖醋里脊";

    // 设置响应头content-type
    resp.setContentType("text/html;charset=utf-8");
    // 向Tomcat索要输出流
    PrintWriter writer = resp.getWriter();
    // 通过输出流将结果写入到响应体
    writer.print(result);
    writer.print(result2);
  }
}

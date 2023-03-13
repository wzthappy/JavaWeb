package com.it.eeee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class ThreeServlet extends HttpServlet {
  /**
   * 问题:
   * 以GET方式发送中文参数内容时等到的结果不会乱码
   * 但以POST请求方式发送中文参数内容时会乱码
   * <p>
   * 原因:
   * 浏览器以GET方式发送请求，请求参数保存在【请求头】，在Http请求协议包到达Http服务器之后，第一件事就是进行解码
   * 请求头中的二进制内容由Tomcat负责解码，Tomcat9.0默认使用【utf-8】字符集，可以解析一切国家文字
   * <p>
   * 浏览器以POST方式发送请求，请求参数保存在【请求体】，在Http请求协议包到达Http服务器之后，第一件事就是进行解码
   * 请求体二进制内容由当前的请求对象(req)负责解码。req默认使用【ISO-8859-1】字符集，一个东欧语系字符集
   * 此时如果请求体参数内容时中文，将无法解码只能得到乱码
   * <p>
   * 解决方案:
   * 在Post请求方式下，在读取请求体内容之前，应该通知请求对象使用utf-8字符集对请求体内容进行一次重新解码
   */
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    // 通过请求对象，读取【请求头】参数消息
    Enumeration<String> parameterNames = req.getParameterNames();
    while (parameterNames.hasMoreElements()) {
      String name = parameterNames.nextElement();
      String parameter = req.getParameter(name);
      System.out.println("从请求头得到参数是值: " + parameter);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 通知请求对象，使用utf-8字符集对请求体二进制内容进行一次重新解码
    req.setCharacterEncoding("utf-8");

    // 通过请求对象，读取【请求体】参数消息
    Enumeration<String> parameterNames = req.getParameterNames();
    while (parameterNames.hasMoreElements()) {
      String name = parameterNames.nextElement();
      String parameter = req.getParameter(name);
      System.out.println("请求体得到参数值: " + parameter);
    }
  }
}

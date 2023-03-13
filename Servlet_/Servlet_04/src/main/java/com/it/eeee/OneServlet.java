package com.it.eeee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OneServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 1. 通过请求对象，读取【请求行】中【url】消息
    String url = req.getRequestURL().toString();

    // 2. 通过请求对象，读取【请求行】中【method】消息
    String method = req.getMethod();

    // 3. 通过请求对象，读取【请求行】中uri消息
    /**
     * URI: 资源文件精准定位地址，在请求行并没有URI这个属性。
     *      实际上URL中截取一个字符串，这个字符串的格式是 “/网络名/资源文件名”
     *      URI用于让HTTP服务器对被访问的资源进行定位
     */
    String uri = req.getRequestURI();


    System.out.println("URL: " + url);  //    URL: http://localhost/Servlet_04_war_exploded/one
    System.out.println("method: " + method);  //    method: GET
    System.out.println("URI: " + uri);   // /Servlet_04_war_exploded/one
  }
}

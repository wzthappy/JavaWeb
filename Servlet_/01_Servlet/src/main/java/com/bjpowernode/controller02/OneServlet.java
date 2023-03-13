package com.bjpowernode.controller02;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 子类 ----> 父类 ----> A接口
 * 此时 子类也是A接口实现类
 * <p>
 * 继承了 HttpServlet 这个类就是servlet的实现类
 * <p>
 * Tomcat根据Servlet规范调用Servlet接口实现规则:
 * 1. Tomcat有权限创建Servlet接口实现类实例对象
 * Servlet oneServlet = new OneServlet();
 * 2. Tomcat根据实例对象调用servlet方法处理当前请求
 * oneServlet.service(); 此时service方法中this ----> OneServlet
 * <p>
 * extends                     extends                     implements
 * OneServlet ----> (abstract)HttpServlet ----> (abstract)GenericServlet  ----> servlet接口
 * 用的方法这了重写了           这里实现了servlet里命的使用没有用的方法
 * service                把有用的方法接着交给下一个类来实现,这个方法是抽象的
 * <p>
 * 通过父类决定在何种情况下调用子类中方法 ---- [设计模式] --- 模板设计模式
 * <p>
 * HttpServlet:  service () {
 * if (请求方式 == GET) {
 * this.doGet
 * } else if (请求方式 == POST) {
 * this.doPost
 * }
 * }
 * <p>
 * OneServlet:   doGet   doPost
 * <p>
 * Servlet oneServlet = new OneServlet();
 * oneServlet.service()
 */
public class OneServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("OneServlet类针对浏览器发送GEt请求范式处理");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("OneServlet类针对浏览器发送POST请求范式处理");
  }
}

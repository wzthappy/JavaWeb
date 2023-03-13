package com.itheim.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OneFilter implements Filter {
  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) servletRequest;   // 向下转型
    HttpSession session = null;

    // 1. 调用请求对象读取请求包中请求行中URI，了解用户访问资源文件是谁
    String uri = req.getRequestURI();  // [/网站名/资源文件名   /Servlet_050_war_exploded/.....]

    // 2. 如果本次请求资源与登录相关【 login.html 或者 loginServlet 】 此时应该无条件放行
          // 只要资源路径有login    或    默认路径    就通过
    if (uri.indexOf("login") != -1 || "/Servlet_050_war_exploded/".equals(uri)) {
      filterChain.doFilter(servletRequest, servletResponse);  // 放行
      return;
    }

    // 3. 如果本次请求访问的是其他资源文件，需要得到用户在服务端HttpSession
    session = req.getSession(false);
    if (session != null) {
      filterChain.doFilter(servletRequest, servletResponse);   // 放行
      return;
    }
    // 4. 做拒绝请求
    req.getRequestDispatcher("/login_error.html").forward(servletRequest, servletResponse);
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {}

  @Override
  public void destroy() {}
}

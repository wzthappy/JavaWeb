package com.bjpowernode.controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TwoServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int jiaozi_money = 30;
    int miantiao_money = 20;
    int gaifan_money = 15;
    int money = 0, xiaofei = 0;
    String food, userName = null;
    Cookie[] cookies = null;
    resp.setContentType("text/html;charset=utf-8");
    PrintWriter out = resp.getWriter();
    Cookie newCookie = null;
    // 1. 读取请求头参数信息，得到用户点餐食物的类型
    food = req.getParameter("food");
    // 2. 读取请求头中的Cookie
    cookies = req.getCookies();
    // 3. 刷卡消费
    for (Cookie cookie : cookies) {
      String name = cookie.getName();
      String value = cookie.getValue();
      if ("userName".equals(name)) {
        userName = value;
      } else if ("money".equals(name)) {
        money = Integer.parseInt(value);
        switch (food) {
          case "饺子":
            if (money < jiaozi_money) {
              out.print("用户" + userName + " 余额不足，请充值");
            } else {
              newCookie = new Cookie("money", (money - jiaozi_money) + "");
              xiaofei = jiaozi_money;
            }
            break;
          case "面条":
            if (money < miantiao_money) {
              out.print("用户" + userName + " 余额不足，请充值");
            } else {
              newCookie = new Cookie("money", (money - miantiao_money) + "");
              xiaofei = miantiao_money;
            }
            break;
          case "盖饭":
            if (money < gaifan_money) {
              out.print("用户" + userName + " 余额不足，请充值");
            } else {
              newCookie = new Cookie("money", (money - gaifan_money) + "");
              xiaofei = gaifan_money;
            }
            break;
        }
      }
    }
    // 4. 将用户会员卡返还给用户
    resp.addCookie(newCookie);
    // 5. 将消费记录写入到响应
    out.print("用户" + userName + "本次消费 " + xiaofei + "，余额还剩: " + newCookie.getValue());
  }
}

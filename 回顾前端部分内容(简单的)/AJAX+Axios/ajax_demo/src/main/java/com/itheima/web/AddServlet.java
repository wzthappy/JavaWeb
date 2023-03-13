package com.itheima.web;

import com.alibaba.fastjson.JSON;
import com.itheima.JSON.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 1. 接收数据  不能接收JSON数据
//    String username = req.getParameter("username");
//    String password = req.getParameter("password");
    // 2. 获取请求体数据
    req.setCharacterEncoding("utf-8");
    BufferedReader reader = req.getReader();
    String s = reader.readLine();

    // 将JSON字符串装换为java对象
    User user = JSON.parseObject(s, User.class);

    System.out.println(user);
  }
}

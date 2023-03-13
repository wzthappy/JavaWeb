package com.happy.kaoshi.controller;

import com.happy.kaoshi.service.UserService;
import com.happy.kaoshi.service.impl.UserServiceImpl;
import com.happy.kaoshi.utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user")
public class userServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {
    PrintWriter writer = resp.getWriter();
    writer.print("m");
    new UserServiceImpl().user();
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    this.doGet(req, resp);
  }
}

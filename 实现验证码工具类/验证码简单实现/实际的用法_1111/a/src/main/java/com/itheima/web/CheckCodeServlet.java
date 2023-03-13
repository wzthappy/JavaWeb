package com.itheima.web;

import com.itheima.util.CheckCodeUtil;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 生成验证图片
 */
public class CheckCodeServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 验证码作用: 防止机器自动注册，攻击服务器
    // 每执行一次就会生成新的验证码
    // 通过响应对象获取一个输出流
    ServletOutputStream os = resp.getOutputStream();
    // TODO: 当调用这个servlet时，就会把图片加载到浏览器中，  img中src="http://..../网页名/checkCodeServlet"
    // 重新请求，对应的图片也会发生改变

    // 生成验证码图片， 返回图片验证码上的内容                  图片大小     输出流    内容长度
    String checkCode = CheckCodeUtil.outputVerifyImage(100, 50, os, 4); // 验证码内容

    // 存入Session
    HttpSession session = req.getSession();
    session.setAttribute("checkCodeGen", checkCode);  // 多次会覆盖
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    this.doGet(req, resp);
  }
}

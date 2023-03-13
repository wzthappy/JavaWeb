package com.itheim.doa;

import com.itheim.pojo.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {
  // 用户注册
  int add(User user);

  // 查询所有用户信息
  List<User> findAll();

  // 根据用户编号删除用户信息
  int delete(String userId);

  // 登录验证
  int login(String userName, String password);

  void userMapper(HttpServletRequest req);
}

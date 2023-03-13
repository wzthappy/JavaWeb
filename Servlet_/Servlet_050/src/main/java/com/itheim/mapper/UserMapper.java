package com.itheim.mapper;

import com.itheim.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
  // 用户注册
  int add(User user);

  // 查询所有用户信息
  List<User> findAll();

  // 根据用户编号删除用户信息
  int delete(@Param("userId") String userId);

  // 登录验证
  int login(@Param("userName") String userName, @Param("password") String password);
}

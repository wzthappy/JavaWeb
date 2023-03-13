package com.itheima.mapper;

import com.itheima.pojo.User;

import java.util.List;

public interface UserMapper {
  // 查询所有
  List<User> selectAll();

  // 添加
  void add(User user);

  // 根据id查询
  User selectBy(int id);

  // 修改
  void update(User user);

  // 删除
  void delete(int id);
}

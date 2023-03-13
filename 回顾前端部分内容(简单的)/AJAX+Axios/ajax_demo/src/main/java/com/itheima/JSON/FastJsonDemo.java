package com.itheima.JSON;

import com.alibaba.fastjson.JSON;

public class FastJsonDemo {
  public static void main(String[] args) {
    // 1. 将Java对转为JSON字符串
    User user = new User();
    user.setId(1);
    user.setUsername("zhangsan");
    user.setPassword("123");

    String s = JSON.toJSONString(user);
    System.out.println(s);
    // 2. 将JSON字符串转换为Java对象
    User user1 = JSON.parseObject(s, User.class);
    System.out.println(user1);
  }
}

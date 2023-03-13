package com.itheim.doa.impl;

import com.itheim.doa.UserService;
import com.itheim.mapper.UserMapper;
import com.itheim.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class UserDao implements UserService {
  SqlSession sqlSession = null;
  static UserMapper mapper = null;  // 其他地方如果要使用就要在对应的实现类中调用在使用
  static Map map = null;
  SqlSession next = null;  // 使用的SqlSession

  // 用户注册
  public int add(User user) {
    int add = mapper.add(user);

    //4. 释放资源
//    sqlSession.close();

    map.put(next, true);  // 使用完毕修改SqlSession的状态，给下一个用户使用
    return add;
  }

  // 查询所有用户信息
  public List<User> findAll() {
    List<User> all = userMapper().findAll();

    sqlSession.close();
    return all;
  }

  // 根据用户编号删除用户信息
  public int delete(String userId) {
    int delete = userMapper().delete(userId);
    sqlSession.close();
    return delete;
  }

  // 登录验证
  public int login(String userName, String password) {
    int login = userMapper().login(userName, password);
    sqlSession.close();
    return login;
  }

  // 返回 UserMapper 对象
  public void userMapper(HttpServletRequest req) {

    // 通过全局作用域对象得到SqlSession
    ServletContext servletContext = req.getServletContext();
    // 2. 从全局作用域对象得到map
    map = (Map) servletContext.getAttribute("key1");
    // 3. 从map中得到处于空闲状态的SqlSession
    Iterator iterator = map.keySet().iterator();
    while (iterator.hasNext()) {
      next = (SqlSession) iterator.next();
      Boolean flag = (Boolean) map.get(next);
      if (flag) {
        map.put(next, false);
        break;  // 如果找到一个空闲的SqlSession就不在找了
      }
    }
    //3. 执行sql
    // 3.1 获取UserMapper接口的代理对象
    mapper = next.getMapper(UserMapper.class);
  }

  public UserMapper userMapper() {
    //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
    String resource = "mybatis-config.xml";
    InputStream inputStream = null;
    try {
      inputStream = Resources.getResourceAsStream(resource);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    //2. 获取SqlSession对象，用它来执行sql
    sqlSession = sqlSessionFactory.openSession(true);

    //3. 执行sql
    // 3.1 获取UserMapper接口的代理对象
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    return userMapper;
  }
}

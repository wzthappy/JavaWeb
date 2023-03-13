package com.itheim.listener;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class OneListener implements ServletContextListener {
  static SqlSessionFactory sqlSessionFactory = null;  // 他是数据库连接只需要连接一次就可以了
  static {
    InputStream inputStream = null;
    //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
    String resource = "mybatis-config.xml";
    try {
      inputStream = Resources.getResourceAsStream(resource);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
  }

  // TODO: Connection是JDBC中需要使用的类，我这里使用的是MyBatis来做的
  // 在Tomcat启动时，预先创建20个Connection，在userDao.add方式执行时
  // 要实现创建好的Connection交给add方法使用
  @Override
  public void contextInitialized(ServletContextEvent sce) {  /// 相当于数据库连接池
    SqlSession sqlSession = null;
    Map<SqlSession, Boolean> map = new HashMap<SqlSession, Boolean>();

    for (int i = 1; i <= 20; i++) {  // 定义20个 SqlSession 对象
      //2. 获取SqlSession对象，用它来执行sql
      sqlSession = sqlSessionFactory.openSession(true);

      System.out.println("在Http服务器启动时，创建Connection " + sqlSession);

      map.put(sqlSession, true);  // true表示这个通道处于空闲状态，false通道正在被使用
    }

    // 为了在Http服务器运行期间，一直都可以使用20个connection，将connection保存到全局作用域对象中
    ServletContext servletContext = sce.getServletContext();
    servletContext.setAttribute("key1", map);
  }  // map被销毁
  // 在Http服务器关闭时刻，将全局作用域对象20个Connection销毁

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    ServletContext servletContext = sce.getServletContext();
    Map map = (Map) servletContext.getAttribute("key1");
    Iterator iterator = map.keySet().iterator();
    while (iterator.hasNext()) {    // 拿到创建的每一个SqlSession对象
      SqlSession next = (SqlSession) iterator.next();
      if (next != null) {   // 保证不会参数空指针异常
        System.out.println("兄弟们，我" + next + " 先行一步！");
        next.close();   // 关闭资源
      }
    }
  }
}

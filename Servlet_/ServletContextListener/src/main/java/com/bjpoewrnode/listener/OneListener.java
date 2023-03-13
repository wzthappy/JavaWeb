package com.bjpoewrnode.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class OneListener implements ServletContextListener {
  @Override
  public void contextInitialized(ServletContextEvent sce) {  // ServletContext【全局作用域对象】 被创建时触发
    System.out.println("恭喜恭喜，来世走一朝");
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {  // ServletContext【全局作用域对象】 被销毁时触发
    System.out.println("兄弟不要怕~~~");
  }
}

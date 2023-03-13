package com.itheim.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class OneListener implements ServletContextAttributeListener {
  @Override
  public void attributeAdded(ServletContextAttributeEvent event) {
    System.out.println("新增了共享数据");
  }

  @Override
  public void attributeRemoved(ServletContextAttributeEvent event) {
    System.out.println("删除了共享数据");
  }

  @Override
  public void attributeReplaced(ServletContextAttributeEvent event) {
    System.out.println("更新了更新数据");
  }
}

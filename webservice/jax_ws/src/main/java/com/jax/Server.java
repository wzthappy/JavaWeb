package com.jax;

import com.jax.impl.HelloServiceImp;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

/**
 * 测试
 */
public class Server {
  public static void main(String[] args) {
    // 发布服务的工厂
    JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();

    // 设置服务地址
    factory.setAddress("http://127.0.0.1:8000/ws/hello");

    // 设置服务类
    factory.setServiceBean(new HelloServiceImp());


    // 输出拦截器，观察soap请求，soap响应内容 (查看客户端请求响应消息，可不要)
    factory.getInInterceptors().add(new LoggingInInterceptor());
    factory.getOutInterceptors().add(new LoggingOutInterceptor());

    // 发布服务
    factory.create();

    System.out.println("发布服务成功，端口8000....");
  }
}

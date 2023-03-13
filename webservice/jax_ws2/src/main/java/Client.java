import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import com.jax.service.HelloService;

public class Client {
  public static void main(String[] args) {
    // 服务接口访问地址: http://127.0.0.1:8000/ws/hello

    // 创建cxf代理工厂
    JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

    // 设置远程访问服务端地址
    factory.setAddress("http://127.0.0.1:8000/ws/hello");

    // 设置接口类型
    factory.setServiceClass(HelloService.class);

    // 对接口生成代理对象
    HelloService helloService = factory.create(HelloService.class);

    // 代理对象类型
    System.out.println(helloService.getClass());

    // 远程访问服务端方法
    String content = helloService.sayHello("sayHellowwwwwwwwwwwwww");

    System.out.println(content);
  }
}

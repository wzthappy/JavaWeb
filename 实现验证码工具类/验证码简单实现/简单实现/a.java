package JavaWeb.实现验证码工具类.验证码简单实现.简单实现;

import JavaWeb.实现验证码工具类.util.CheckCodeUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class a {
  public static void main(String[] args) throws IOException {
    // 验证码作用: 防止机器自动注册，攻击服务器
    // 每执行一次就会生成新的验证码
    // 生成验证码图片的存放位置                         如果多次执行生成的图片会替换以前的图片
    OutputStream fos = new FileOutputStream("src/JavaWeb/实现验证码工具类/验证码简单实现/简单实现/img");
    // 生成验证码图片， 返回图片验证码上的内容                 图片大小      输出流    内容长度
    String s = CheckCodeUtil.outputVerifyImage(100, 50, fos, 4);
    System.out.println(s);
  }
}

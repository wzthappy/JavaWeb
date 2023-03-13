package JavaWeb.JDBC.benZhi;

import java.util.ResourceBundle;

/*
    Java程序员角色
    不需要关心具体是哪个品牌的数据库，只需要面向JDBC接口写代码
    面向接口编程，面向抽象编程，不要面向具体编程
 */
public class JavaProgrammer {
    public static void main(String[] args) throws Exception {
//        JDBC jdbc = new MySQL();
//        JDBC jdbc = new Oracle();

        // 创建对象可以通过反射机制
        ResourceBundle bundle = ResourceBundle.getBundle("JDBC.benzhi.jdbc");  // 指向 jdbc.properties 文件
        String className = bundle.getString("className");  // jdbc.properties文件中的className对应的值

        Class<?> c = Class.forName(className);   // 反射  对应的值 的java文件
        JDBC jdbc = (JDBC)c.newInstance();   // JDBC是这些的父级可以强转     根据指定的构造方法 创建对象

        // 以下代码都是面向接口调用方法，不需要修改
        jdbc.getConnection();
    }
}

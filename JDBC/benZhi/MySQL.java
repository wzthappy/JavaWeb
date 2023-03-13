package JavaWeb.JDBC.benZhi;
/*
    MySQL的数据库厂家负责编写JDBC接口的实现类
 */
public class MySQL implements JDBC {
    // 具体这里的代码怎么写，对于我们Java程序员来说没关系
    // 这段代码涉及到mySQL底层数据库的实现原理
    @Override
    public void getConnection() {
        System.out.println("连接mySQL数据库成功！");
    }
}
// 实现类被称为驱动。 (mySQl驱动)
// xxx.jar      .jar包    当中有很多.class，都是对JDBC接口进行的实现
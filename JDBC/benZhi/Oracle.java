package JavaWeb.JDBC.benZhi;
/*
    Oracle的数据库厂家负责编写JDBC接口的实现类
 */
public class Oracle implements JDBC {
    @Override
    public void getConnection() {
        System.out.println("连接Oracle数据库成功！");
    }
}

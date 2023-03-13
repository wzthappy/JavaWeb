package JavaWeb.JDBC.benZhi;
/*
    SqlServer的数据库厂家负责编写JDBC接口的实现类
 */
public class SqlServer implements JDBC {
    @Override
    public void getConnection() {
        System.out.println("连接SQLServer数据库成功！");
    }
}

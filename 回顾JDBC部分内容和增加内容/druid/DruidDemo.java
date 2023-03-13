package JavaWeb.回顾JDBC部分内容和增加内容.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;

/**
 *  Druid 数据库连接池演示
 */
public class DruidDemo {

  public static void main(String[] args) throws Exception{
    // 1. 导入jar包

    // 2. 定义配置文件

    // 3. 加载配置文件
    Properties prop = new Properties();
    prop.load(new FileInputStream("src\\JavaWeb\\回顾JDBC部分内容和增加内容\\druid\\druid.properties"));

    // 4. 获取连接池对象
    DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

    // 5. 获取数据库连接 Connection
    Connection conn = dataSource.getConnection();

    System.out.println(conn);

    // 这里就可以操作数据库了  conn
  }
}

package JavaWeb.回顾JDBC部分内容和增加内容.简单案例.练习;

import JavaWeb.回顾JDBC部分内容和增加内容.简单案例.Brand;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 品牌数据的增删该查操作
 */
public class BrandTest {
  /**
   * 查询所有
   * 1. SQL: select * from tb_brand;
   * 2. 参数: 不需要
   * 3. 结果: List<Brand>
   */
  @Test
  public void testSelectAll() throws Exception {
    // 1. 获取 Connection
    // 3. 加载配置文件
    Properties prop = new Properties();
    prop.load(new FileInputStream("src/JavaWeb/回顾JDBC部分内容和增加内容/简单案例/druid.properties"));

    // 4. 获取连接池对象
    DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

    // 5. 获取数据库连接 Connection
    Connection conn = dataSource.getConnection();

    // 2. 定义SQL语句
    String sql = "select * from tb_brand";

    // 3. 获取pstmt对象
    PreparedStatement ps = conn.prepareStatement(sql);
    // 4. 设置参数
    // 5. 执行sql
    ResultSet rs = ps.executeQuery();

    // 6. 处理结果 List<Brand> 封装Brand对象，装载List集合
    Brand brand = null;
    List<Brand> brands = new ArrayList<Brand>();
    while (rs.next()) {
      // 获取数据
      int id = rs.getInt("id");
      String brandName = rs.getString("brand_name");
      String companyName = rs.getString("company_name");
      int ordered = rs.getInt("ordered");
      String description = rs.getString("description");
      int status = rs.getInt("status");
      // 封装Brand对象
      brand = new Brand();
      brand.setId(id);
      brand.setBrandName(brandName);
      brand.setCompanyName(companyName);
      brand.setOrdered(ordered);
      brand.setDescription(description);
      brand.setStatus(status);
      // 装载集合
      brands.add(brand);
    }

    System.out.println(brands);
    // 7. 释放资源
    rs.close();
    ps.close();
    conn.close();
  }

  /**
   * 添加
   * 1. SQL: insert into tb_brand(brand_name, company_name, ordered, description, status) value();
   * 2. 参数: 需要，除了id的所有参数消息
   * 3. 结果: boolean
   */
  @Test
  public void testAdd() throws Exception {
    // 接收页面提交的参数
    String brandName = "香飘飘";
    String companyName = "香飘飘";
    int ordered = 1;
    String description = "绕地球一圈";
    int status = 1;

    // 1. 获取 Connection
    // 3. 加载配置文件
    Properties prop = new Properties();
    prop.load(new FileInputStream("src/JavaWeb/回顾JDBC部分内容和增加内容/简单案例/druid.properties"));

    // 4. 获取连接池对象
    DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

    // 5. 获取数据库连接 Connection
    Connection conn = dataSource.getConnection();

    // 2. 定义SQL语句
    String sql = "insert into tb_brand(brand_name, company_name, ordered, description, status)" +
            " value(?, ?, ?, ?, ?)";

    // 3. 获取pstmt对象
    PreparedStatement ps = conn.prepareStatement(sql);
    // 4. 设置参数
    ps.setString(1, brandName);
    ps.setString(2, companyName);
    ps.setInt(3, ordered);
    ps.setString(4, description);
    ps.setInt(5, status);

    // 5. 执行sql
    int count = ps.executeUpdate(); // 影响的行数

    // 6. 处理结果
    System.out.println(count > 0);

    // 7. 释放资源
    ps.close();
    conn.close();
  }

  /**
   * 修改
   * 1. SQL:
     update tb_brand
     set brand_name = ?,
     company_name = ?,
     ordered = ?,
     description = ?,
     status = ?
     where id = ?
   * 2. 参数: 需要，所有数据
   * 3. 结果: boolean
   */
  @Test
  public void testUpdate() throws Exception {
    // 接收页面提交的参数
    String brandName = "香飘飘";
    String companyName = "香飘飘";
    int ordered = 1000;
    String description = "绕地球三圈";
    int status = 1;
    int id = 4;

    // 1. 获取 Connection
    // 3. 加载配置文件
    Properties prop = new Properties();
    prop.load(new FileInputStream("src/JavaWeb/回顾JDBC部分内容和增加内容/简单案例/druid.properties"));

    // 4. 获取连接池对象
    DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

    // 5. 获取数据库连接 Connection
    Connection conn = dataSource.getConnection();

    // 2. 定义SQL语句
    String sql = "update tb_brand\n" +
            "   set brand_name = ?,\n" +
            "   company_name = ?,\n" +
            "   ordered = ?,\n" +
            "   description = ?,\n" +
            "   status = ?\n" +
            "   where id = ?";
    // 3. 获取ps对象
    PreparedStatement ps = conn.prepareStatement(sql);
    // 4. 设置参数
    ps.setString(1, brandName);
    ps.setString(2, companyName);
    ps.setInt(3, ordered);
    ps.setString(4, description);
    ps.setInt(5, status);
    ps.setInt(6, id);

    // 5. 执行sql
    int count = ps.executeUpdate(); // 影响的行数

    // 6. 处理结果
    System.out.println(count > 0);

    // 7. 释放资源
    ps.close();
    conn.close();
  }

  /**
   * 删除
   * 1. SQL:
        delete from tb_brand where id = ?
   * 2. 参数: 需要，id
   * 3. 结果: boolean
   */
  @Test
  public void testDeleteById() throws Exception {
    // 接收页面提交的参数
    int id = 5;

    // 1. 获取 Connection
    // 3. 加载配置文件
    Properties prop = new Properties();
    prop.load(new FileInputStream("src/JavaWeb/回顾JDBC部分内容和增加内容/简单案例/druid.properties"));

    // 4. 获取连接池对象
    DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

    // 5. 获取数据库连接 Connection
    Connection conn = dataSource.getConnection();

    // 2. 定义SQL语句
    String sql = "delete from tb_brand where id = ?";
    // 3. 获取ps对象
    PreparedStatement ps = conn.prepareStatement(sql);
    // 4. 设置参数
    ps.setInt(1, id);

    // 5. 执行sql
    int count = ps.executeUpdate(); // 影响的行数

    // 6. 处理结果
    System.out.println(count > 0);

    // 7. 释放资源
    ps.close();
    conn.close();
  }

}

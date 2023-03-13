package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Collection;
import java.util.List;

public interface UserMapper {
  // 这里要和 UserMapper.xml 文件中 id名字 和 返回值类型 要一致
  List<User> selectAll();

  User selectById(int id);

  /**
   * MyBatis 参数封装:
   *    * 单个参数:
   *          1. POJO类型: 直接使用，属性名 和 参数占位符名称 一致
   *          2. Map集合: 直接使用，键名 和 参数占位符名称 一致
   *          3. Collection: 封装为 Map 集合
   *                map.put("arg0", collection集合);
   *                map.put("collection", collection集合);
   *          4. List:
   *                map.put("arg0", List集合);
   *                map.put("collection", List集合);
   *                map.put("List", List集合);
   *          5. Array: 封装为 Map 集合
   *                map.put("arg0", 数组);
   *                map.put("array", 数组);
   *
   *          6. 其他类型: 直接使用
   *
   *    * 多个参数: 封装为Map集合，可以使用@param注解，替换Map集合中默认的键名
     *     ---------- 无@Param注解的
     *          map.put("arg0", 参数值1);
     *          map.put("pram1", 参数值1);
     *
     *          map.put("pram2", 参数值2);
     *          map.put("arg1", 参数值2);
     *     ---------- 有@Param注解的
     *         map.put("username", 参数值1);
     *         map.put("pram1", 参数值1);
     *
     *         map.put("pram2", 参数值2);
     *         map.put("password", 参数值2);
   */
  User select(@Param("username") String username, @Param("password") String password);
//  User select(Collection collection);



  // 简单的sql可以这样用
  @Select("select * from tb_user where id = #{id}")
  User selectById2(@Param("id") int id);
}

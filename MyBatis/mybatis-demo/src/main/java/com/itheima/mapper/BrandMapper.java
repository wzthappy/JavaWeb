package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
  /**
   * 查询所有
   */
  public List<Brand> selectAll();

  /**
   * 查看详情: 根据Id查询
   */
  Brand selectById(int id);
//  Brand selectById(@Param("id") int id);

  /**
   * 条件查询
   *  * 参数接收
   *      1. 散装参数: 如果方法中有多个参数，需要使用@Param("SQL参数占位符名称")
   *      2. 对象参数
   *      3. map集合参数
   */
  // 方法一
//  List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName, @Param("brandName") String brandName);
  // 方法二
//  List<Brand> selectByCondition(Brand brand);
  // 方法三
  List<Brand> selectByCondition(Map map);

  /**
   * 单条件动态查询
   */
  List<Brand> selectByConditonString(Brand brand);

  /**
   * 添加  如果写上返回值，返回的数影响的行数(Integer)
   */
  void add(Brand brand);

  /**
   *  动态修改字段
   */
  int update(Brand brand);

  /**
   * 根据id删除
   */
  void deleteById(@Param("id") int id);

  /**
   * 批量删除
   */
  void deleteByIds(@Param("ids") int[] ids);
}

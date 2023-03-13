package com.itheima.servlce;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserService {
  /**
   * 从工具类拿到SqlSessionFactory对象
   */
  private SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
  private SqlSession sqlSession;

  /**
   * 获得接口的代理对象
   */
  public UserMapper getBrandMapper() {
    // 2. 获取sqlSession对象
    sqlSession = sqlSessionFactory.openSession();

    // 3. 获取Mapper接口的代理对象
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    return mapper;
  }


  /**
   * 查询所有
   *
   * @return
   */
  public List<User> selectAll() {
    // 调用UserMapper.selectAll()
    UserMapper brandMapper = getBrandMapper();
    // 4. 执行方法
    List<User> users = brandMapper.selectAll();

    // 5. 释放资源
    sqlSession.close();
    return users;
  }

  /**
   * 添加
   * @param user
   */
  public void add(User user) {
    // 调用UserMapper.selectAll()
    UserMapper brandMapper = getBrandMapper();
    // 4. 执行方法
    brandMapper.add(user);

    // 提交事务
    sqlSession.commit();

    // 5. 释放资源
    sqlSession.close();
  }

  /**
   * 根据id查询
   *
   * @return
   */
  public User selectById(int id) {
    // 调用UserMapper.selectAll()
    UserMapper brandMapper = getBrandMapper();
    // 4. 执行方法
    User user = brandMapper.selectBy(id);

    // 5. 释放资源
    sqlSession.close();
    return user;
  }

  /**
   * 修改
   */
  public void update(User user) {
    // 调用UserMapper.selectAll()
    UserMapper brandMapper = getBrandMapper();
    // 4. 执行方法
    brandMapper.update(user);

    // 提交事务
    sqlSession.commit();

    // 5. 释放资源
    sqlSession.close();
  }

  /**
   * 删除
   */
  public void delete(int id) {
    // 调用UserMapper.selectAll()
    UserMapper brandMapper = getBrandMapper();
    // 4. 执行方法
    brandMapper.delete(id);

    // 提交事务
    sqlSession.commit();
    // 5. 释放资源
    sqlSession.close();
  }
}

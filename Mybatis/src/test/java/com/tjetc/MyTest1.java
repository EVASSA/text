package com.tjetc;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tjetc.common.SqlSessionUtils;
import com.tjetc.entity.User;
import com.tjetc.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest1 {
    @Test
    public void testSelect() throws IOException {
        //创建SqlSession对象
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //获取UserMapper接口的代理类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用UserMapper的selectAll方法查询所有的用户信息，返回用户集合
        List<User> users = userMapper.selectAll();
        //打印user集合
        System.out.println(users);
        //关闭SqlSession对象
        sqlSession.close();
    }

    @Test
    public void testSelectById() throws IOException {
        //创建SqlSession对象
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //调用SqlSession对象的getMapper方法 获取UserMapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用UserMapper代理对象的selectById方法查询User
        User user = userMapper.selectById(3L);
        //打印User
        System.out.println(user);
        //关闭SqlSession对象
        sqlSession.close();
    }

    @Test
    public void testInsert() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //创建User对象 并给user对象的属性赋值（自增主键不用赋值）
        User user = new User();
        user.setUsername("laozhang222");
        user.setPassword("000000");
        user.setUpdateTime(LocalDateTime.now());
        user.setCreateTime(LocalDateTime.now());
        //调用insert方法
        userMapper.insert(user);
        //打印user
        System.out.println(user);
        //手动提交
        sqlSession.commit();
        //关闭资源换
        sqlSession.close();
    }

    @Test
    public void testUpdate() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //查询
        User user = userMapper.selectById(4L);
        System.out.println(user);
        user.setUsername("lucy111");
        user.setPassword("8888888");
        user.setUpdateTime(LocalDateTime.now());
        //update返回值是影响的行数
        int affectedRows = userMapper.update(user);
        System.out.println("affectedRows=" + affectedRows);
        //提交
        sqlSession.commit();
        //关闭
        sqlSession.close();
    }

    @Test
    public void testDeleteById() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        int affectedRows = userMapper.deleteById(2L);
        System.out.println("affectedRows=" + affectedRows);
        //提交
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectByUsernameAndPassword() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        //user.setUsername("laozhang");
        //user.setPassword("999999");
        List<User> users = userMapper.selectByUsernameAndPassword(user);
        System.out.println(users);
        sqlSession.close();
    }

    @Test
    public void testSelectByUsernameAndPassword2() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        //user.setUsername("laozhang");
        //user.setPassword("999999");
        List<User> users = userMapper.selectByUsernameAndPassword2(user);
        System.out.println(users);
        sqlSession.close();
    }

    @Test
    public void testSelectByUsernameAndPassword3() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        //user.setUsername("laozhang");
        //user.setPassword("999999");
        List<User> users = userMapper.selectByUsernameAndPassword3(user);
        System.out.println(users);
        sqlSession.close();
    }

    @Test
    public void testSelectByUsernameAndPassword4() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("laozhang");
        user.setPassword("999999");
        List<User> users = userMapper.selectByUsernameAndPassword4(user);
        System.out.println(users);
        sqlSession.close();
    }

    @Test
    public void testUpdate1() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //查询
        User user = userMapper.selectById(4L);
        System.out.println(user);
        user.setUsername("lucy000");
        //user.setUsername("");
        user.setPassword(null);
        //user.setUpdateTime(LocalDateTime.now());user = {User@2446} "User{id=4, username='lucy000', password='null', updateTime=2024-08-01T09:27:53, createTime=2024-07-31T13:39:32}"
        user.setUpdateTime(null);
        //update返回值是影响的行数
        int affectedRows = userMapper.update1(user);
        System.out.println("affectedRows=" + affectedRows);
        //提交
        sqlSession.commit();
        //关闭
        sqlSession.close();
    }

    @Test
    public void testSelectByIds() throws IOException {
        //创建SqlSession对象
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //调用SqlSession对象的getMapper方法 获取UserMapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //定义变量ids
        List<Long> ids = Arrays.asList(3L, 6L, 7L, 8l);
        //调用UserMapper代理对象的selectById方法查询User
        List<User> users = userMapper.selectByIds(ids);
        //打印User
        System.out.println(users);
        //关闭SqlSession对象
        sqlSession.close();
    }

    @Test
    public void testSelectByIds2() throws IOException {
        //创建SqlSession对象
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //调用SqlSession对象的getMapper方法 获取UserMapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //定义变量ids
        Long[] ids = {3L, 6L, 7L, 8l};
        //调用UserMapper代理对象的selectById方法查询User
        List<User> users = userMapper.selectByIds2(ids);
        //打印User
        System.out.println(users);
        //关闭SqlSession对象
        sqlSession.close();
    }

    @Test
    public void selectByIdsAndLikeUsername() throws IOException {
        //创建SqlSession对象
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //调用SqlSession对象的getMapper方法 获取UserMapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //定义变量ids
        List<Long> ids = Arrays.asList(3L, 6L, 7L, 8l);
        //调用UserMapper代理对象的selectById方法查询User
        List<User> users = userMapper.selectByIdsAndLikeUsername(ids, "a");
        //打印User
        System.out.println(users);
        //关闭SqlSession对象
        sqlSession.close();
    }

    @Test
    public void testSelectByUsernameAndPassword5() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = userMapper.selectByUsernameAndPassword5("laowang", null);
        System.out.println(users);
        sqlSession.close();
    }

    @Test
    public void testSelectByUsernameAndPassword6() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        //map添加的key值要与mybatis映射文件的 sql的参数名称保持一致
        map.put("username", "laozhang");
        map.put("password", null);
        List<User> users = userMapper.selectByUsernameAndPassword6(map);
        System.out.println(users);
        sqlSession.close();
    }

    @Test
    public void testSelectPage() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Integer pageNo = 3;
        Integer pageSize = 2;
        //设置页码和每页数量
        PageHelper.startPage(pageNo, pageSize);
        //分页查询
        List<User> users = userMapper.selectAll();
        //对分页结果进行包装
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        //打印
        System.out.println(userPageInfo);
        sqlSession.close();
    }
}

package com.tjetc.mapper;

import com.tjetc.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //查询所有数据
    List<User> selectAll();

    User selectById(Long id);

    void insert(User user);

    int update(User user);

    int deleteById(Long id);

    //根据用户名或者密码来查询数据,
    //要求：用户名信息存在就用用户查询 密码信息存在用密码查询  两者都存在 两个信息都用，并and关系
    List<User> selectByUsernameAndPassword(User user);

    List<User> selectByUsernameAndPassword2(User user);

    List<User> selectByUsernameAndPassword3(User user);

    List<User> selectByUsernameAndPassword4(User user);

    int update1(User user);

    List<User> selectByIds(List<Long> ids);

    List<User> selectByIds2(Long[] ids);

    //mybatis的方法 参数是2个和2以上时候，使用@Param("参数名称")注解，注解的值就是 映射文件 sql的参数家名称 #{参数名称}
    List<User> selectByIdsAndLikeUsername(@Param("ids") List<Long> aaa,
                                          @Param("username") String bbb);

    List<User> selectByUsernameAndPassword5(@Param("username") String un,
                                            @Param("password") String pd);
    //不推荐
    List<User> selectByUsernameAndPassword6(Map<String,Object> map);
}

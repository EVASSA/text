package com.tjetc;

import com.tjetc.common.SqlSessionUtils;
import com.tjetc.entity.Admin;
import com.tjetc.enums.EnumSex;
import com.tjetc.mapper.AdminMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class AdminTest {
    @Test
    public void testInsert() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
        //创建Admin对象
        Admin admin = new Admin("jkkk", "00000", EnumSex.FEMALE);
        adminMapper.insert(admin);

        admin=adminMapper.selectById(Long.valueOf(24));
        System.out.println(admin);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test1(){
        EnumSex male = EnumSex.MALE;
        System.out.println(male);
        EnumSex female = EnumSex.FEMALE;
        System.out.println(female);
    }

    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
        Admin admin = adminMapper.selectById(1L);
        System.out.println(admin);
        sqlSession.close();
    }
}

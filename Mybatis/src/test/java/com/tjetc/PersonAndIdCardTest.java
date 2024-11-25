package com.tjetc;

import com.tjetc.common.SqlSessionUtils;
import com.tjetc.entity.IdCard;
import com.tjetc.entity.Person;
import com.tjetc.mapper.IdCardMapper;
import com.tjetc.mapper.PersonMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class PersonAndIdCardTest {
    @Test
    public void testInsert() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //新增Person
        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
        Person person = new Person();
        person.setName("李四");
        personMapper.insert(person);
        //新增IdCard
        IdCardMapper idCardMapper = sqlSession.getMapper(IdCardMapper.class);
        IdCard idCard = new IdCard();
        idCard.setCode("546665565656565");
        idCard.setPerson(person);
        idCardMapper.insert(idCard);
        //提交
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectById() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
        Person person = personMapper.selectById(1);
        System.out.println(person);
    }

    @Test
    public void testSelectById2() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
        Person person = personMapper.selectById2(1);
        System.out.println(person);
    }
}

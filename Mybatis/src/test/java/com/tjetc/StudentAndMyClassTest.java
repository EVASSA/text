package com.tjetc;

import com.tjetc.common.SqlSessionUtils;
import com.tjetc.entity.MyClass;
import com.tjetc.entity.Student;
import com.tjetc.mapper.MyClassMapper;
import com.tjetc.mapper.StudentMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class StudentAndMyClassTest {
    @Test
    public void testInsert() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //新增MyClass
        MyClassMapper myClassMapper = sqlSession.getMapper(MyClassMapper.class);
        MyClass myClass = new MyClass();
        myClass.setName("一年级");
        myClassMapper.insert(myClass);
        //新增Student
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student s1 = new Student();
        s1.setName("张三");
        s1.setMyClass(myClass);
        studentMapper.insert(s1);

        Student s2 = new Student();
        s2.setName("李四");
        s2.setMyClass(myClass);
        studentMapper.insert(s2);

        Student s3 = new Student();
        s3.setName("王五");
        s3.setMyClass(myClass);
        studentMapper.insert(s3);

        //提交
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        MyClassMapper myClassMapper = sqlSession.getMapper(MyClassMapper.class);
        MyClass myClass = myClassMapper.selectById(2);
        System.out.println(myClass);
        sqlSession.close();
    }

    @Test
    public void testSelectById2(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        MyClassMapper myClassMapper = sqlSession.getMapper(MyClassMapper.class);
        MyClass myClass = myClassMapper.selectById2(2);
        System.out.println(myClass);
        sqlSession.close();
    }
}

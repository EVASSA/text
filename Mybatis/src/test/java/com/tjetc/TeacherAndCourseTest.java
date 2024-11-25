package com.tjetc;

import com.tjetc.common.SqlSessionUtils;
import com.tjetc.entity.Course;
import com.tjetc.entity.Teacher;
import com.tjetc.entity.vo.TeacherCourseCount;
import com.tjetc.mapper.CourseMapper;
import com.tjetc.mapper.TeacherMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TeacherAndCourseTest {
    @Test
    public void testInsert() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //添加Teacher
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher t1 = new Teacher();
        t1.setName("zs");
        Teacher t2 = new Teacher();
        t2.setName("ls");
        Teacher t3 = new Teacher();
        t3.setName("wu");
        teacherMapper.insert(t1);
        teacherMapper.insert(t2);
        teacherMapper.insert(t3);
        //添加Course
        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
        Course c1 = new Course();
        c1.setName("JSP");
        Course c2 = new Course();
        c2.setName("SSM");
        Course c3 = new Course();
        c3.setName("servlet");
        courseMapper.insert(c1);
        courseMapper.insert(c2);
        courseMapper.insert(c3);
        //添加sc
        //zs
        teacherMapper.insertSc(t1.getId(),c1.getId());
        teacherMapper.insertSc(t1.getId(),c2.getId());
        teacherMapper.insertSc(t1.getId(),c3.getId());
        //ls
        teacherMapper.insertSc(t2.getId(),c1.getId());
        teacherMapper.insertSc(t2.getId(),c2.getId());
        //wu
        teacherMapper.insertSc(t3.getId(),c2.getId());
        teacherMapper.insertSc(t3.getId(),c3.getId());
        //提交
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = teacherMapper.selectById(1);
        System.out.println(teacher);
        sqlSession.close();
    }

    @Test
    public void testSelectById2(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = teacherMapper.selectById2(1);
        System.out.println(teacher);
        sqlSession.close();
    }

    @Test
    public void testSelectCourseCountByTid(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        TeacherCourseCount teacherCourseCount = teacherMapper.selectCourseCountByTid(4);
        System.out.println(teacherCourseCount);
        sqlSession.close();
    }
}

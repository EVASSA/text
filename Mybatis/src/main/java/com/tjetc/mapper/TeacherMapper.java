package com.tjetc.mapper;

import com.tjetc.entity.Teacher;
import com.tjetc.entity.vo.TeacherCourseCount;
import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {
    void insert(Teacher teacher);

    void insertSc(@Param("tid") Integer tid, @Param("cid") Integer cid);

    Teacher selectById(Integer id);

    Teacher selectById2(Integer id);

    /**
     * 根据老师id查询老师授课数量
     *
     * @param tid 教师id
     * @return    教师授课数量（对象）
     */
    TeacherCourseCount selectCourseCountByTid(Integer tid);
}

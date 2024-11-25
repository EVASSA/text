package com.tjetc.entity.vo;

public class TeacherCourseCount {
    /**
     * teacherId
     */
    private Integer teacherId;
    /**
     * 教师名称
     */
    private String teacherName;
    /**
     * 教师授课数量
     */
    private Integer courseCount;

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getCourseCount() {
        return courseCount;
    }

    public void setCourseCount(Integer courseCount) {
        this.courseCount = courseCount;
    }

    @Override
    public String toString() {
        return "TeacherCourseCount{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", courseCount=" + courseCount +
                '}';
    }
}

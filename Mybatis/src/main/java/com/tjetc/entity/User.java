package com.tjetc.entity;

import java.time.LocalDateTime;

public class User {
    //主键
    private Long id;
    private String username;
    private String password;
    //新增2个成员变量，命名规则：驼峰
    //类型推荐使用 java8的LocalDateTime
    private LocalDateTime updateTime;
    private LocalDateTime createTime;
    //private LocalDate

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                '}';
    }
}

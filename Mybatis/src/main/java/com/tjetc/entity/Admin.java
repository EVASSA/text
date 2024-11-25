package com.tjetc.entity;

import com.tjetc.enums.EnumSex;

public class Admin {
    private Long id;
    private String username;
    private String password;
    //使用自定义的枚举类型
    private EnumSex sex;

    //注意：如果自定义了有参的构造方法，一定定义个无参构造方法
    public Admin() {
    }

    //定义有参构造方法（目的：方便使用）
    public Admin(String username, String password, EnumSex sex) {
        this.username = username;
        this.password = password;
        this.sex = sex;
    }

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

    public EnumSex getSex() {
        return sex;
    }

    public void setSex(EnumSex sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Admin{" + "id=" + id + ", username='" + username + '\'' + ", password='" + password + '\'' + ", sex=" + sex + '}';
    }
}

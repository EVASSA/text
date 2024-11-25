package com.tjetc.entity;

public class Student {
    private Integer id;
    private String name;
    private MyClass myClass;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyClass getMyClass() {
        return myClass;
    }

    public void setMyClass(MyClass myClass) {
        this.myClass = myClass;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", myClass=" + myClass +
                '}';
    }
}

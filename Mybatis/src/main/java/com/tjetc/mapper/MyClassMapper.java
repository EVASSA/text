package com.tjetc.mapper;

import com.tjetc.entity.MyClass;

public interface MyClassMapper {
    void insert(MyClass myClass);

    MyClass selectById(int id);

    MyClass selectById2(int id);
}

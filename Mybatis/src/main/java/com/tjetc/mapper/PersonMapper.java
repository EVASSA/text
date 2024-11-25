package com.tjetc.mapper;

import com.tjetc.entity.Person;

public interface PersonMapper {
    void insert(Person person);

    Person selectById(Integer id);

    Person selectById2(Integer id);
}

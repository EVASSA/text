package com.tjetc.mapper;

import com.tjetc.entity.Admin;

public interface AdminMapper {
    void insert(Admin admin);

    Admin selectById(Long id);
}

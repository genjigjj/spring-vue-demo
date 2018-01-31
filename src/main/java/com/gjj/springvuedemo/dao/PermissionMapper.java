package com.gjj.springvuedemo.dao;

import com.gjj.springvuedemo.model.Permission;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}
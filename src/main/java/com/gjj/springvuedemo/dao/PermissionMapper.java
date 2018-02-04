package com.gjj.springvuedemo.dao;

import com.gjj.springvuedemo.model.Permission;

import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    /**
     * 通过用户Id查询权限
     * @param uid 用户Id
     * @return 权限列表
     * @Author gjj
     * @date 2018/2/3
     */
    List<Permission> findByUserid(int uid);
}
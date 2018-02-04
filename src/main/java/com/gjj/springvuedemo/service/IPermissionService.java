package com.gjj.springvuedemo.service;

import com.gjj.springvuedemo.model.Permission;

import java.util.List;

/**
 * 权限Service接口
 *
 * @author gjj
 * @program spring-vue-demo
 * @date 2018-02-03 14:52
 */
public interface IPermissionService {

    /**
     * 通过用户id查询权限
     * @param uid 用户Id
     * @return 权限集合
     * @Author gjj
     * @date 2018/2/3
     */
    List<Permission> findByUserid(int uid);
}

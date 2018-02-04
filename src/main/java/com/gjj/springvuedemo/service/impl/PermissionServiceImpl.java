package com.gjj.springvuedemo.service.impl;

import com.gjj.springvuedemo.dao.PermissionMapper;
import com.gjj.springvuedemo.model.Permission;
import com.gjj.springvuedemo.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 权限Service实现
 *
 * @author gjj
 * @program spring-vue-demo
 * @date 2018-02-03 14:54
 */
@Service
public class PermissionServiceImpl implements IPermissionService {

    /** 权限mapper */
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> findByUserid(int uid) {
        return permissionMapper.findByUserid(uid);
    }

}

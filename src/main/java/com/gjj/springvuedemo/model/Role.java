package com.gjj.springvuedemo.model;

import java.util.List;

/**
 * 角色实体
 *
 * @author gjj
 *
 * @date 2018/3/3
 */
public class Role {

    /** 角色主键 */
    private Integer rid;

    /** 角色名 */
    private String rname;

    private List<Permission> permissionList;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname == null ? null : rname.trim();
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }
}
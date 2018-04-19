package com.gjj.springvuedemo.model;

import java.io.Serializable;

/**
 * 权限实体
 *
 * @author gjj
 *
 * @date 2018/3/3
 */
public class Permission implements Serializable {

    /** 权限id */
    private Integer pid;

    /** 权限名 */
    private String pname;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }
}
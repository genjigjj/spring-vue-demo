package com.gjj.springvuedemo.model;

import java.util.List;

/**
 * 用户实体
 *
 * @author gjj
 *
 * @date 2018/3/3
 */
public class User {
    
    /** 用户主键 */
    private Integer uid;

    /** 用户名 */
    private String userName;

    /** 用户密码 */
    private String userPassword;
    
    /** 角色集合 */
    private List<Role> roleList;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
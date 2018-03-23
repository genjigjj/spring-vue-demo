package com.gjj.springvuedemo.vo;

/**
 * 用户视图对象
 *
 * @author gjj
 * @project spring-vue-demo
 * @date 2018-03-15 11:54
 **/
public class UserVo {

    private String username;

    private String password;

    private Integer[] queryIds;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer[] getQueryIds() {
        return queryIds;
    }

    public void setQueryIds(Integer[] queryIds) {
        this.queryIds = queryIds;
    }
}

package com.gjj.springvuedemo.dao;

import com.gjj.springvuedemo.model.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> getAllUser();

    /**
     * 通过用户名获取用户信息
     * @param username 用户名
     * @return 用户
     * @Author gjj
     * @date 2018/2/3
     */
    User findByUsername(String username);
}
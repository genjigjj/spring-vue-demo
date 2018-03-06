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

    List<User> findByIds(Integer[] queryIds);

    /**
     * 通过用户id查询用户
     * @param uid 用户id
     * @return 用户信息
     * @author gjj
     * @date 2018/3/4
     */
    User findUserById(Integer uid);

}
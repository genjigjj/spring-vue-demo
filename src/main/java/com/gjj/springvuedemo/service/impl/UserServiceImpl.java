package com.gjj.springvuedemo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.gjj.springvuedemo.dao.UserMapper;
import com.gjj.springvuedemo.model.User;
import com.gjj.springvuedemo.service.IUserService;
import com.gjj.springvuedemo.util.JsonUtil;
import com.gjj.springvuedemo.util.ResultEnum;
import com.gjj.springvuedemo.vo.UserVo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户service实现
 *
 * @author gjj
 * @date 2018-03-23
 */ 
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public JSONObject getAllUser() {
        List<User> userList = userMapper.getAllUser();
        if (CollectionUtils.isNotEmpty(userList)) {
            return JsonUtil.returnJson(ResultEnum.DATA_SUCCESS, userList);
        }
        return JsonUtil.returnJson(ResultEnum.DATA_FAIL, null);
    }

    @Override
    public User findByUserName(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public JSONObject findByIds(UserVo userVo) {
        if (userVo != null && userVo.getQueryIds() != null) {
            List<User> userList = userMapper.findByIds(userVo.getQueryIds());
            if (CollectionUtils.isNotEmpty(userList)) {
                return JsonUtil.returnJson(ResultEnum.DATA_SUCCESS, userList);
            }
        }
        return JsonUtil.returnJson(ResultEnum.DATA_FAIL, null);
    }

    @Override
    public User findUserById(Integer uid) {
        return userMapper.findUserById(uid);
    }

    @Override
    public JSONObject login(UserVo userVo) {
        Subject subject = SecurityUtils.getSubject();
        try {
            if (userVo != null) {
                UsernamePasswordToken token = new UsernamePasswordToken(userVo.getUsername(), userVo.getPassword());
                subject.login(token);
                User user = (User) subject.getPrincipal();
                subject.getSession().setAttribute("user", user);
                return JsonUtil.returnJson(ResultEnum.LOGIN_SUCCESS, null);
            }
        } catch (AuthenticationException e) {
            logger.info("认证失败");
        }
        return JsonUtil.returnJson(ResultEnum.LOGIN_FAIL, null);
    }

    @Override
    public JSONObject logOut() {
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
            return JsonUtil.returnJson(ResultEnum.LOGOUT_FAIL, null);
        }
        return JsonUtil.returnJson(ResultEnum.LOGOUT_SUCCESS, null);
    }

}
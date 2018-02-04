/**
 * 文件名: UserServiceImpl.java
 * 版权：  深圳市中诺思资讯

 * 描述:  
 * 修改人: gjj
 * 修改时间： 2018年1月30日上午11:47:28
 * 修改内容:
 */
package com.gjj.springvuedemo.service.impl;

import java.util.List;

import com.gjj.springvuedemo.dao.UserMapper;
import com.gjj.springvuedemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gjj.springvuedemo.service.IUserService;

/**
 * 功能简述：〈功能简述〉
 * @author     gjj
 * @version   [版本号, YYYY-MM-DD]2018年1月30日上午11:47:28;
 * @see       [相关类/方法]
 * @since     [产品/模块版本]
 * 
 */
@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> getAllUser() {
		return userMapper.getAllUser();
	}

	@Override
	public User findByUserName(String username) {
		return userMapper.findByUsername(username);
	}

}

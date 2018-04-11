package com.gjj.springvuedemo.service;

import com.alibaba.fastjson.JSONObject;
import com.gjj.springvuedemo.model.User;
import com.gjj.springvuedemo.vo.UserVo;

/**
 * 用户Service接口
 *
 * @author gjj
 *
 * @date 2018/2/2
 */
public interface IUserService {

	/**
	 * 获取所有用户
	 * @param 
	 * @return 用户列表
	 * @Author gjj
	 * @date 2018/2/2
	 */ 
	JSONObject  getAllUser();
	
	/**
	 * 通过用户名获取用户信息
	 * @param username 用户名
	 * @return 该用户信息
	 * @Author gjj
	 * @date 2018/2/3
	 */ 
	User findByUserName(String username);

	/**
	 * 通过用户id数组查询用户
	 * @param userVo 用户视图
	 * @return 用户列表
	 * @Author gjj
	 * @date 2018/3/4
	 */
	JSONObject findByIds(UserVo userVo);

	/**
	 * 通过用户id查询用户
	 * @param uid 用户id
	 * @return 用户信息
	 * @author gjj
	 * @date 2018/3/4
	 */ 
	User findUserById(Integer uid);

	/**
	 * 用户登录
	 * @param userVo 登录参数，包括用户名和密码
	 * @return 登录是否成功的json数据
	 * @author gjj
	 * @date 2018-03-13
	 */ 
	JSONObject login(UserVo userVo);

	/**
	 * 登出
	 * @return 是否登出成功json数据
	 * @author gjj
	 * @date 2018-03-13
	 */
	JSONObject logOut();

	/**
	 * 获取用户信息
	 * @return 用户信息Vo
	 * @author gjj
	 * @date 2018-04-11
	 */ 
	JSONObject findUserInfo();

}

/**
 * 文件名: IUserService.java
 * 版权：  深圳市中诺思资讯

 * 描述:  
 * 修改人: gjj
 * 修改时间： 2018年1月30日上午11:42:29
 * 修改内容:
 */
package com.gjj.springvuedemo.service;

import com.gjj.springvuedemo.model.User;

import java.util.List;

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
	List<User>  getAllUser();
	
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
	 * @param ids 用户id数组
	 * @return 用户列表
	 * @Author gjj
	 * @date 2018/3/4
	 */
	List<User> findByIds(Integer[] ids);

	/**
	 * 通过用户id查询用户
	 * @param uid 用户id
	 * @return 用户信息
	 * @author gjj
	 * @date 2018/3/4
	 */ 
	User findUserById(Integer uid);

}

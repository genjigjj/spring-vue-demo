/**
 * 文件名: UserMapper.java
 * 版权：  深圳市中诺思资讯

 * 描述:  
 * 修改人: gjj
 * 修改时间： 2018年1月30日上午10:52:18
 * 修改内容:
 */
package com.gjj.springvuedemo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gjj.springvuedemo.model.User;


/**
 * 功能简述：〈功能简述〉
 * @author     gjj
 * @version   [版本号, YYYY-MM-DD]2018年1月30日上午10:52:18;
 * @see       [相关类/方法]
 * @since     [产品/模块版本]
 * 
 */
@Mapper
public interface UserMapper {
	
	List<User> getAllUsers();
	
	void deleteByPrimaryKey(Integer id);

	void insert(User user);

	void insertSelective(User user);

	User selectByPrimaryKey(String id);

	void updateByPrimaryKeySelective(User user);

	void updateByPrimaryKey(User record);

	User findUserByUserName(String username);
	
}

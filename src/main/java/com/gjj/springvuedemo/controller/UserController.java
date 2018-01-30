/**
 * 文件名: UserController.java
 * 版权：  深圳市中诺思资讯

 * 描述:  
 * 修改人: gjj
 * 修改时间： 2018年1月30日上午11:41:18
 * 修改内容:
 */
package com.gjj.springvuedemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gjj.springvuedemo.model.User;
import com.gjj.springvuedemo.service.IUserService;

/**
 * 功能简述：〈功能简述〉
 * @author     gjj
 * @version   [版本号, YYYY-MM-DD]2018年1月30日上午11:41:18;
 * @see       [相关类/方法]
 * @since     [产品/模块版本]
 * 
 */

@RestController
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = "/users",method = RequestMethod.GET)
	public ResponseEntity<?> getAllUsers() {
		List<User> userList = userService.getAllUser();
		return new ResponseEntity<>(userList, HttpStatus.OK);
	}

}

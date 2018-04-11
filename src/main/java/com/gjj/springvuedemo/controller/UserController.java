package com.gjj.springvuedemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.gjj.springvuedemo.service.IUserService;
import com.gjj.springvuedemo.vo.UserVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户控制器
 *
 * @author gjj
 *
 * @date 2018/3/3
 */
@CrossOrigin
@RestController
public class UserController {
	
	@Autowired
	private IUserService userService;

	/**
	 * 登录
	 * @param userVo 用户信息
	 * @return json数据
	 * @author gjj
	 * @date 2018-03-23
	 */ 
	@PostMapping(value = "/login")
	public JSONObject login(@RequestBody UserVo userVo){
        return userService.login(userVo);
	}

	/**
	 * 登出
	 * @return 登出是否成功json消息
	 * @author gjj
	 * @date 2018/2/3
	 */
    @PostMapping(value = "/logout")
	public JSONObject logOut(){
        return userService.logOut();
    }

    /**
     * 获取所有用户
     * @return json数据
     * @author gjj
     * @date 2018-03-13
     */
    @RequiresPermissions("Create")
    @GetMapping(value = "/allusers")
    public JSONObject getAllUsers() {
        return userService.getAllUser();
    }

    /**
     * 通过多个id获取用户
     * @param userVo 包括查询id数组
     * @return json数据
     * @author gjj
     * @date 2018/3/4
     */ 
    @PostMapping(value = "/users")
    public JSONObject findUserByIds(@RequestBody UserVo userVo){
       return userService.findByIds(userVo);
	}

	/**
	 * 获取用户信息
	 * @return 用户信息
	 * @author gjj
	 * @date 2018-04-11
	 */
    @GetMapping(value = "/info")
	public JSONObject findUserInfo(){
        return userService.findUserInfo();
    }

}

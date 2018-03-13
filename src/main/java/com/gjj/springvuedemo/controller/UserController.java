/**
 * 文件名: UserController.java
 * 版权：  深圳市中诺思资讯

 * 描述:  
 * 修改人: gjj
 * 修改时间： 2018年1月30日上午11:41:18
 * 修改内容:
 */
package com.gjj.springvuedemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.gjj.springvuedemo.service.IUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制器
 *
 * @author gjj
 *
 * @date 2018/3/3
 */
@RestController
public class UserController {
	
	@Autowired
	private IUserService userService;


	@PostMapping(value = "/login")
	public JSONObject login(@RequestBody JSONObject requestJson){
        return userService.login(requestJson);
	}

	/**
	 * 登出
	 * @param
	 * @return
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
     * @param 
     * @return 
     * @author gjj
     * @date 2018/3/4
     */ 
    @PostMapping(value = "/users")
    public JSONObject findUserByIds(@RequestBody JSONObject requestJson){
       return userService.findByIds(requestJson);
	}

}

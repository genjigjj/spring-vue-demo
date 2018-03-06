/**
 * 文件名: UserController.java
 * 版权：  深圳市中诺思资讯

 * 描述:  
 * 修改人: gjj
 * 修改时间： 2018年1月30日上午11:41:18
 * 修改内容:
 */
package com.gjj.springvuedemo.controller;

import com.gjj.springvuedemo.model.User;
import com.gjj.springvuedemo.service.IUserService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequiresPermissions("Create")
	@RequestMapping(value = "/allusers",method = RequestMethod.GET)
	public ResponseEntity<?> getAllUsers() {
		List<User> userList = userService.getAllUser();
		return new ResponseEntity<>(userList, HttpStatus.OK);
	}

	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public ResponseEntity<?> login(String username,String password){
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			User user = (User) subject.getPrincipal();
			subject.getSession().setAttribute("user",user);
			return new ResponseEntity<>("登录成功",HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity<>("登录失败",HttpStatus.UNAUTHORIZED);
		}
	}

	/**
	 * 登出
	 * @param
	 * @return
	 * @author gjj
	 * @date 2018/2/3
	 */
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
	public ResponseEntity<?> logOut(){
	    Subject subject = SecurityUtils.getSubject();
	    try{
            subject.logout();
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
	        e.printStackTrace();
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    /**
     * 通过多个id获取用户
     * @param 
     * @return 
     * @author gjj
     * @date 2018/3/4
     */ 
    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public ResponseEntity<?> findUserByIds(){
        Integer[] ids = new Integer[]{1,2};
		List<User> userList = userService.findByIds(ids);
        Map<String,Object> resultMap = new HashMap<>(16);
		if (CollectionUtils.isNotEmpty(userList)){
		    resultMap.put("users",userList);
		    return new ResponseEntity<>(resultMap,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}

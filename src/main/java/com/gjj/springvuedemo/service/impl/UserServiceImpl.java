/**
 * 文件名: UserServiceImpl.java
 * 版权：  深圳市中诺思资讯

 * 描述:  
 * 修改人: gjj
 * 修改时间： 2018年1月30日上午11:47:28
 * 修改内容:
 */
package com.gjj.springvuedemo.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gjj.springvuedemo.dao.UserMapper;
import com.gjj.springvuedemo.model.User;
import com.gjj.springvuedemo.service.IUserService;
import com.gjj.springvuedemo.util.ErrorEnum;
import com.gjj.springvuedemo.util.JsonUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
	public JSONObject getAllUser() {
	    List<User> userList = userMapper.getAllUser();
	    if(CollectionUtils.isNotEmpty(userList)){
	        return JsonUtil.successJson(userList);
        }
		return JsonUtil.errorJson(ErrorEnum.E_200);
	}

	@Override
	public User findByUserName(String username) {
		return userMapper.findByUsername(username);
	}

	@Override
	public JSONObject findByIds(JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("ids");
        List<Integer> ids = new ArrayList<>();
        for (Object object : jsonArray){
            ids.add((Integer) object);
        }
		List<User> userList = userMapper.findByIds((Integer[]) ids.toArray(new Integer[ids.size()]));
        if (CollectionUtils.isNotEmpty(userList)){
            return JsonUtil.successJson(userList);
        }
        return JsonUtil.errorJson(ErrorEnum.E_200);
	}

	@Override
	public User findUserById(Integer uid) {
		return userMapper.findUserById(uid);
	}

    @Override
    public JSONObject login(JSONObject jsonObject) {
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
            User user = (User) subject.getPrincipal();
            subject.getSession().setAttribute("user",user);
            return JsonUtil.successJson("登录成功");
        }catch (Exception e){
            return JsonUtil.errorJson(ErrorEnum.E_100);
        }
    }

    @Override
    public JSONObject logOut() {
	    try{
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
        }catch (Exception e){
	        e.printStackTrace();
        }
        return JsonUtil.successJson("退出成功");
    }

}

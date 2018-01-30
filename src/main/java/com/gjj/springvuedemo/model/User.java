/**
 * 文件名: User.java
 * 版权：  深圳市中诺思资讯

 * 描述:  
 * 修改人: gjj
 * 修改时间： 2018年1月30日上午10:05:39
 * 修改内容:
 */
package com.gjj.springvuedemo.model;

import java.io.Serializable;


/**
 * 功能简述：〈用户〉
 * @author     gjj
 * @version   [版本号, YYYY-MM-DD]2018年1月30日上午10:05:39;
 * @see       [相关类/方法]
 * @since     [产品/模块版本]
 * 
 */

@SuppressWarnings("serial")
public class User implements Serializable{
	
	private Integer uid;

	private String username;
	
	private String password;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

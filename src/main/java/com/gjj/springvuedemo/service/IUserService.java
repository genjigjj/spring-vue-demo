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
 * 功能简述：〈功能简述〉
 * @author     gjj
 * @version   [版本号, YYYY-MM-DD]2018年1月30日上午11:42:29;
 * @see       [相关类/方法]
 * @since     [产品/模块版本]
 * 
 */

public interface IUserService {

	public List<User>  getAllUser();
}

/**
 * 文件名: DruidConfiguration.java
 * 版权：  深圳市中诺思资讯

 * 描述:  
 * 修改人: gjj
 * 修改时间： 2018年1月30日下午2:37:15
 * 修改内容:
 *//*
package com.gjj.springvuedemo.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

*//**
 * 功能简述：〈Druid监控servelet和filter配置〉
 * @author     gjj
 * @version   [版本号, YYYY-MM-DD]2018年1月30日下午2:37:15;
 * @see       [相关类/方法]
 * @since     [产品/模块版本]
 * 
 *//*

@Configuration
public class DruidConfiguration {

	@Bean
	public ServletRegistrationBean druidServlet() {

		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
		servletRegistrationBean.setServlet(new StatViewServlet());
		servletRegistrationBean.addUrlMappings("/druid/*");
		Map<String, String> initParameters = new HashMap<String, String>();
		initParameters.put("loginUsername", "admin");// 用户名
		initParameters.put("loginPassword", "admin");// 密码
		initParameters.put("resetEnable", "false");// 禁用HTML页面上的“Reset All”功能
		initParameters.put("allow", ""); // IP白名单 (没有配置或者为空，则允许所有访问)
		// initParameters.put("deny", "192.168.20.38");// IP黑名单
		// (存在共同时，deny优先于allow)
		servletRegistrationBean.setInitParameters(initParameters);
		return servletRegistrationBean;

	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean() {

		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new WebStatFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		// @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")//
		// 忽略资源
		filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
		return filterRegistrationBean;

	}

}
*/
package com.gjj.springvuedemo.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * 全局异常处理
 *
 * @author gjj
 * @project spring-vue-demo
 * @date 2018-04-20 11:20
 **/
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 认证异常处理
     * @return 认证失败json
     * @author gjja
     * @date 2018-04-20
     */
    @ExceptionHandler(AuthenticationException.class)
    public JSONObject authenticationExceptionHandler(AuthenticationException e){
        JSONObject jsonObject = JsonUtil.returnJson(ResultEnum.LOGIN_FAIL,null);
        logger.info("认证失败",e);
        return jsonObject;
    }

    /**
     * 授权异常处理
     * @return 权限不足json
     * @author gjj
     * @date 2018-04-20
     */ 
    @ExceptionHandler(AuthorizationException.class)
    public JSONObject authorizationExceptionHandler(AuthorizationException e){
        JSONObject jsonObject = JsonUtil.returnJson(ResultEnum.UNAUTHORIZED,null);
        logger.info("权限不足",e);
        return jsonObject;
    }

    /**
     * 未认证异常处理
     * @return 请求失败json
     * @author gjj
     * @date 2018-04-20
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public JSONObject requestExceptionHandler(HttpRequestMethodNotSupportedException e){
        JSONObject jsonObject = JsonUtil.returnJson(ResultEnum.BAD_REQUEST,null);
        logger.info("请求失败",e);
        return jsonObject;
    }

}

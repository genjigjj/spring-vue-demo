package com.gjj.springvuedemo.shiro;

import com.alibaba.fastjson.JSONObject;
import com.gjj.springvuedemo.util.JsonUtil;
import com.gjj.springvuedemo.util.ResultEnum;
import org.apache.shiro.web.filter.authc.UserFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
/**
 * ajax认证拦截器
 *
 * @author gjj
 * @project spring-vue-demo
 * @date 2018-03-14 10:13
 **/
public class AjaxFilter extends UserFilter {

    private static final Logger logger = LoggerFactory.getLogger(AjaxFilter.class);

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        JSONObject jsonObject = JsonUtil.returnJson(ResultEnum.UNAUTHORIZED,null);
        PrintWriter out = null;
        HttpServletResponse res = (HttpServletResponse) response;
        try {
            res.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            res.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN,((HttpServletRequest) request).getHeader(HttpHeaders.ORIGIN));
            res.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS,"true");
            out = response.getWriter();
            out.println(jsonObject);
        } catch (Exception e) {
            logger.info(e.getMessage(),e);
        } finally {
            if (out != null) {
                out.flush();
                out.close();
            }
        }
        return false;
    }

}

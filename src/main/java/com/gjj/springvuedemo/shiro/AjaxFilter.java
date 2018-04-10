package com.gjj.springvuedemo.shiro;

import com.alibaba.fastjson.JSONObject;
import com.gjj.springvuedemo.util.ResultEnum;
import org.apache.shiro.web.filter.authc.UserFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
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
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("returnCode", ResultEnum.UNAUTHORIZED.getCode());
        jsonObject.put("returnMsg", ResultEnum.UNAUTHORIZED.getMessage());
        PrintWriter out = null;
        HttpServletResponse res = (HttpServletResponse) response;
        try {
            res.setCharacterEncoding("UTF-8");
            res.setContentType("application/json");
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

package com.gjj.springvuedemo.util;

import com.alibaba.fastjson.JSONObject;

/**
 * json工具类
 *
 * @author gjj
 * @project spring-vue-demo
 * @date 2018-03-13 11:32
 **/
public class JsonUtil {

    /**
     * 返回成功json数据
     * @param returnData 返回数据
     * @return json数据
     * @author gjj
     * @date 2018-03-13
     */ 
    public static <T>JSONObject returnJson(ResultEnum resultEnum,T returnData){
        JSONObject resultJson = new JSONObject();
        resultJson.put("returnCode", resultEnum.getCode());
        resultJson.put("returnMsg", resultEnum.getMessage());
        if(returnData != null){
            resultJson.put("returnData", returnData);
        }
        return resultJson;
    }

}

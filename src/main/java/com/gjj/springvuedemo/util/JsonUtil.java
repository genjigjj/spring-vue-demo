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
    public static <T>JSONObject successJson(T returnData){
        JSONObject resultJson = new JSONObject();
        resultJson.put("returnCode", Constants.SUCCESS_CODE);
        resultJson.put("returnMsg", Constants.SUCCESS_MSG);
        resultJson.put("returnData", returnData);
        return resultJson;
    }

    /**
     * 返回错误json数据
     * @param errorEnum 错误枚举类
     * @return json数据
     * @author gjj
     * @date 2018-03-13
     */
    public static JSONObject errorJson(ErrorEnum errorEnum) {
        JSONObject resultJson = new JSONObject();
        resultJson.put("returnCode", errorEnum.getErrorCode());
        resultJson.put("returnMsg", errorEnum.getErrorMsg());
        return resultJson;
    }

}

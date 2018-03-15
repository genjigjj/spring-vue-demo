package com.gjj.springvuedemo.util;

/**
 * 结果枚举类
 *
 * @author gjj
 * @date 2018-03-13
 */
public enum ResultEnum {

    LOGIN_FAIL("100","登录失败"),
    DATA_FAIL("200","数据获取失败"),
    BAD_REQUEST("400", "请求处理异常，请稍后再试"),
    UNAUTHORIZED("401", "权限不足"),
    NOT_FOUND("404", "请求路径不存在"),
    REQUEST_METHODS_ERROR("500", "请求方式有误,请检查 GET/POST"),
    LOGIN_TIMEOUT("501", "登录超时,请重新登录");
    /** 错误代码 */
    private final String code;

    /** 错误信息 */
    private String message;

    ResultEnum(String errorCode, String errorMsg) {
        this.code = errorCode;
        this.message = errorMsg;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}

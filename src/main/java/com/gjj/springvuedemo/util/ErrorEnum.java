package com.gjj.springvuedemo.util;

/**
 * 错误枚举类
 *
 * @author gjj
 * @date 2018-03-13
 */
public enum ErrorEnum {

    /*
     * 错误信息
     * */
    E_100("100","登录失败"),
    E_200("200","数据获取失败"),
    E_400("400", "请求处理异常，请稍后再试"),
    E_500("500", "请求方式有误,请检查 GET/POST"),
    E_501("501", "请求路径不存在"),
    E_502("502", "权限不足");

    /** 错误代码 */
    private String errorCode;

    /** 错误信息 */
    private String errorMsg;

    ErrorEnum(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}

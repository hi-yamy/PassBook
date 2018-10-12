package com.imooc.passbook.passbook.vo;

/**
 *<h1>统一的错误信息</h1>
 * Created  by  hanbian
 */
public class ErrorInfo<T> {
    /** 错误码*/
    public static  final  Integer  ERROR = -1;

    /** 特定错误码*/
    private Integer code;
    /** 错误信息*/
    private  String message;
    /** 请求url*/
    private  String url ;
    /** 请求返回的数据*/
    private T data;

    public static Integer getERROR() {
        return ERROR;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

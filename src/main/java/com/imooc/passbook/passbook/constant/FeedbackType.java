package com.imooc.passbook.passbook.constant;

/**
 * <h1>评论类型枚举</h1>
 */
public enum FeedbackType {

    PASS(1,"针对优惠券的评论"),
    APP(2,"针对卡包 App 的评论");

    private Integer code;

    private String desc;

    FeedbackType(Integer code,String desc){
        this.code=code;
        this.desc =desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

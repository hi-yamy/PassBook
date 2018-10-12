package com.imooc.passbook.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>用户领取优惠券的请求对象</h1>
 * Created by hanbian
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GainPassTemplateRequest  {

    /** 用户id */
    private Long userId;

    /** PassTemplate  对象*/
    private  PassTemplate passTemplate;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public PassTemplate getPassTemplate() {
        return passTemplate;
    }

    public void setPassTemplate(PassTemplate passTemplate) {
        this.passTemplate = passTemplate;
    }
}

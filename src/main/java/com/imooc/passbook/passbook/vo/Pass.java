package com.imooc.passbook.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 *<h1>用户领取的优惠券</h1>
 * Create by hanbian
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pass {

    /** 用户id */
    private Long userId;
    /** pass 在HBase 中的RowKey */
    private String rowKey;
    /**PassTemplate 在HBase 中的RowKey*/
    private String templateId;

    /** 优惠券 token ,有可能是null,则填充-1*/
    private String token;
    /** 领取日期*/
    private Date assignedDate;
    /** 消费日期  ,不为空代表已经被消费了 没有消费时我们默认给他设置为-1 */
    private Date  conDate;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRowKey() {
        return rowKey;
    }

    public void setRowKey(String rowKey) {
        this.rowKey = rowKey;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(Date assignedDate) {
        this.assignedDate = assignedDate;
    }

    public Date getConDate() {
        return conDate;
    }

    public void setConDate(Date conDate) {
        this.conDate = conDate;
    }
}

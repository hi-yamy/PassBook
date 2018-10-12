package com.imooc.passbook.passbook.vo;

import com.google.common.base.Enums;
import com.imooc.passbook.passbook.constant.FeedbackType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>用户评论</h1>
 * Create by hanbian
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {

    /** 用户id */
    private Long  userId;
    /** 评论类型*/
    private String type;
    /** PassTemplate  RowKey,如果是app类型的评论，则没有*/
    private String templateId;
    /** 评论内容*/
    private String comment;

    public boolean validate(){
        FeedbackType   feedbackType = Enums.getIfPresent(
                FeedbackType.class,this.type.toUpperCase()
        ).orNull();
        return !(null == feedbackType ||null == comment);
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

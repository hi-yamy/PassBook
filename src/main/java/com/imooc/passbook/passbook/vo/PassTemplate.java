package com.imooc.passbook.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * <h1>投放的优惠券对象定义</h1>
 * Created  by hanbian
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassTemplate {

    /** 所属商户id*/
    private  Integer id;
    /** 优惠券标题*/
    private String title;
    /**优惠券摘要 */
    private String summary;
    /**优惠券详细信息*/
    private String desc;
    /** 最大个数限制*/
    private Long limit;
    /** 优惠券是否有 Token,用于商户核销*/
    private Boolean hasToken;
    /** 优惠券背景色*/
    private Integer background;
    /** 优惠券开始时间*/
    private Date start;
    /** 优惠券结束时间*/
    private Date  end;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    public Boolean getHasToken() {
        return hasToken;
    }

    public void setHasToken(Boolean hasToken) {
        this.hasToken = hasToken;
    }

    public Integer getBackground() {
        return background;
    }

    public void setBackground(Integer background) {
        this.background = background;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}

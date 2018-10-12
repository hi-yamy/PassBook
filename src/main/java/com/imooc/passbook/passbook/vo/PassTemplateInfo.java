package com.imooc.passbook.passbook.vo;

import com.imooc.passbook.passbook.entity.Merchants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * <h1>优惠券模板信息</h1>
 * Created by hanbian
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassTemplateInfo extends PassTemplate{

    /** 优惠券模板*/
    private  PassTemplate  passTemplate;

    /** 优惠券对应的商户*/
    private Merchants merchants;
}

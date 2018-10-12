package com.imooc.passbook.passbook.utils;

import com.imooc.passbook.passbook.log.LogGenerator;
import com.imooc.passbook.passbook.vo.Feedback;
import com.imooc.passbook.passbook.vo.GainPassTemplateRequest;
import com.imooc.passbook.passbook.vo.PassTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <h1>RowKey 生成器工具类</h1>
 * Created by hanbian
 */
@Slf4j
public class RowKeyGenUtil {

    private static Logger log = LoggerFactory.getLogger(LogGenerator.class);

    public static String genPassTemplateRowKey(PassTemplate  passTemplate){

        String passInfo = String.valueOf(passTemplate.getId()+"_"+passTemplate.getTitle());
        String rowKey = DigestUtils.md5Hex(passInfo);
        log.info("genPassTemplateRowKey：{}，{}",passInfo,rowKey);
        return rowKey;
    }

    /**
     * <h2>根据提供的领取优惠券请求生成 RowKey,只可以在领取优惠券的时候使用</h2>
     * Pass RowKey = reveresd(userId)
     * @param request   {@link GainPassTemplateRequest}
     * @return String RowKey
     */
    public  static String genPassRowKey(GainPassTemplateRequest  request){

        return new StringBuilder(String.valueOf(request.getUserId())).reverse().toString()
                +(Long.MAX_VALUE-System.currentTimeMillis())
                +genPassTemplateRowKey(request.getPassTemplate());
    }

    /**
     *<h2>根据 Feedback 构造RowKey</h2>
     *
     */
    public static String genFeedbackRowKey(Feedback feedback){

        return  new StringBuilder(String.valueOf(feedback.getUserId())).reverse().toString()+
                (Long.MAX_VALUE - System.currentTimeMillis());
    }
}

package com.imooc.passbook.passbook.service;

import com.alibaba.fastjson.JSON;
import com.imooc.passbook.passbook.constant.Constants;
import com.imooc.passbook.passbook.log.LogGenerator;
import com.imooc.passbook.passbook.vo.PassTemplate;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

/**
 * <h1>消费Kafka 中的PassTemplate</h1>
 * Created by hanbian
 */
@Slf4j
public class ConsumePassTemplate {
    private static Logger log = LoggerFactory.getLogger(LogGenerator.class);
    /** pass 相关的HBase 服务*/
    private  final IHBasePassService passService;
    @Autowired
    public  ConsumePassTemplate(IHBasePassService  passService){
        this.passService = passService;
    }

    @KafkaListener(topics = {Constants.TEMPLATE_TOPIC})
    public  void receive(@Payload String passTemplate,
                         @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                         @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
                         @Header(KafkaHeaders.RECEIVED_TOPIC) String topic){

        log.info("Consumer Receive PassTemplate:{}",passTemplate);
        PassTemplate pt;

        try{
            pt = JSON.parseObject(passTemplate,PassTemplate.class);
        }catch(Exception e){
            log.error("Parse PassTemplate Error:{}",e.getMessage());
            return;
        }
        log.info("DropPassTemplateToHBase:{}",passService.dropPassTemplateToHBase(pt));
    }

}

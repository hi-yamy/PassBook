package com.imooc.passbook.passbook.service.impl;

import com.alibaba.fastjson.JSON;
import com.imooc.passbook.passbook.constant.Constants;
import com.imooc.passbook.passbook.log.LogGenerator;
import com.imooc.passbook.passbook.mapper.FeedbackRowMapper;
import com.imooc.passbook.passbook.service.IFeedbackService;
import com.imooc.passbook.passbook.utils.RowKeyGenUtil;
import com.imooc.passbook.passbook.vo.Feedback;
import com.imooc.passbook.passbook.vo.Response;
import com.spring4all.spring.boot.starter.hbase.api.HbaseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.PrefixFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <h1>评论功能实现</h1>
 * Created by hanbian
 */
@Slf4j
public class FeedbackServiceImpl implements IFeedbackService {

    private static Logger log = LoggerFactory.getLogger(LogGenerator.class);

    @Autowired
    private HbaseTemplate hbaseTemplate;

    /**
     * <h2>创建评论</h2>
     *
     * @param feedback {@link Feedback}
     * @return {@link Response}
     */
    @Override
    public Response createFeedback(Feedback feedback) {
        if(!feedback.validate()){
            log.error("Feedback Error: {}", JSON.toJSONString(feedback));
            return Response.failure("Feedback Error");
        }
       Put put = new Put(Bytes.toBytes(RowKeyGenUtil.genFeedbackRowKey(feedback)));
             put.addColumn(
                     Bytes.toBytes(Constants.Feedback.FAMILY_I),
                     Bytes.toBytes(Constants.Feedback.USER_ID),
                     Bytes.toBytes(feedback.getUserId())
             );
             put.addColumn(
                     Bytes.toBytes(Constants.Feedback.FAMILY_I),
                     Bytes.toBytes(Constants.Feedback.TYPE),
                     Bytes.toBytes(feedback.getType())
             );
             put.addColumn(
                     Bytes.toBytes(Constants.Feedback.FAMILY_I),
                     Bytes.toBytes(Constants.Feedback.TEMPLATE_ID),
                     Bytes.toBytes(feedback.getTemplateId())
             );
             put.addColumn(
                     Bytes.toBytes(Constants.Feedback.FAMILY_I),
                     Bytes.toBytes(Constants.Feedback.COMMENT),
                     Bytes.toBytes(feedback.getComment())
             );
             hbaseTemplate.saveOrUpdate(Constants.Feedback.TABLE_NAME,put);
             return Response.success();
    }

    /**
     * <h2>获取用户评论</h2>
     *
     * @param userId 用户id
     * @return {@link Response}
     */
    @Override
    public Response getFeedback(Long userId) {
       byte[] reverseUserId = new StringBuilder(String.valueOf(userId)).reverse().toString().getBytes();
       Scan scan =new Scan();
       scan.setFilter(new PrefixFilter(reverseUserId));
      List<Feedback> feedbacks  = hbaseTemplate.find(Constants.Feedback.TABLE_NAME,scan,new FeedbackRowMapper());
        return new Response(feedbacks);
    }
}

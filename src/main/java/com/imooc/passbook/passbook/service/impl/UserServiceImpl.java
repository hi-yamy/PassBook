package com.imooc.passbook.passbook.service.impl;

import com.imooc.passbook.passbook.constant.Constants;
import com.imooc.passbook.passbook.vo.Response;
import com.imooc.passbook.passbook.vo.User;
import com.spring4all.spring.boot.starter.hbase.api.HbaseTemplate;
import groovy.util.logging.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.hadoop.hbase.client.Mutation;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>创建用户服务实现</h1>
 * Created by hanbian
 */
@Slf4j
@Service
public class UserServiceImpl {

    private final HbaseTemplate  hbaseTemplate;

    private final StringRedisTemplate redisTemplate;

    @Autowired
    public UserServiceImpl(HbaseTemplate hbaseTemplate, StringRedisTemplate redisTemplate) {
        this.hbaseTemplate = hbaseTemplate;
        this.redisTemplate = redisTemplate;
    }

    public Response createUser(User user) throws  Exception{

       byte[] FAMLIY_B = Constants.UserTable.FAMLIY_B.getBytes();
       byte[] NAME =  Constants.UserTable.NAME.getBytes();
       byte[] AGE =  Constants.UserTable.AGE.getBytes();
       byte[] SEX =  Constants.UserTable.SEX.getBytes();

       byte[] FAMLIY_O =  Constants.UserTable.FAMLIY_O.getBytes();
       byte[] PHONE =  Constants.UserTable.PHONE.getBytes();
       byte[] ADDRESS =  Constants.UserTable.ADDRESS.getBytes();

        Long curCount = redisTemplate.opsForValue().increment(Constants.USE_COUNT_REDIS_KEY,1);
        Integer userId = genUserId(curCount);

      List<Mutation> datas = new ArrayList<Mutation>();
       Put put = new Put(Bytes.toBytes(userId));
       put.addColumn(FAMLIY_B,NAME,Bytes.toBytes(user.getBaseInfo().getName()));
       put.addColumn(FAMLIY_B,AGE,Bytes.toBytes(user.getBaseInfo().getAge()));
       put.addColumn(FAMLIY_B,SEX,Bytes.toBytes(user.getBaseInfo().getSex()));
       put.addColumn(FAMLIY_O,PHONE,Bytes.toBytes(user.getOtherInfo().getPhone()));
       put.addColumn(FAMLIY_O,PHONE,Bytes.toBytes(user.getOtherInfo().getAddress()));

       datas.add(put);
       hbaseTemplate.saveOrUpdate(Constants.UserTable.TABLE_NAME, (Mutation) datas);
       user.setId(userId);
       return new Response(user);
    }

    /**
     * <h2>生成userId</h2>
     * @param prefix  当前用户数
     * @return 用户 id
     */
    private Integer genUserId(Long prefix){
       String suffix = RandomStringUtils.randomNumeric(5);
       return Integer.valueOf(prefix + suffix);
    }

}

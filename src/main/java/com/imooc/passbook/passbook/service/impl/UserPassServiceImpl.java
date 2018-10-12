package com.imooc.passbook.passbook.service.impl;

import com.imooc.passbook.passbook.constant.Constants;
import com.imooc.passbook.passbook.service.IUserPassService;
import com.imooc.passbook.passbook.vo.Pass;
import com.imooc.passbook.passbook.vo.PassTemplate;
import com.imooc.passbook.passbook.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <h1>用户优惠券相关功能实现</h1>
 *
 */
@Slf4j
@Service
public class UserPassServiceImpl implements IUserPassService {
    /**
     * <h2>获取用户个人优惠券信息，即我的优惠券功能实现</h2>
     *
     * @param userId
     * @return {@link Response}
     * @throws Exception
     */
    @Override
    public Response getUserPassInfo(Long userId) throws Exception {
        return null;
    }

    /**
     * <h2>获取用户已经消费了的优惠券，即已使用优惠券功能实现</h2>
     *
     * @param userId
     * @return {@link Response}
     * @throws Exception
     */
    @Override
    public Response getUserUsedPassInfo(Long userId) throws Exception {
        return null;
    }

    /**
     * <h2>获取用户所有的优惠券</h2>
     *
     * @param userId
     * @return {@link Response}
     * @throws Exception
     */
    @Override
    public Response getUserAllPassInfo(Long userId) throws Exception {
        return null;
    }

    /**
     * <h2>用户使用优惠券</h2>
     *
     * @param pass
     * @return {@link Response}
     * @throws Exception
     */
    @Override
    public Response userUsePass(Pass pass) throws Exception {
        return null;
    }

    /**
     * <h2>通过获取的Passes 对象构造 Map</h2>
     * @param passes
     * @return   {@link PassTemplate}
     * @throws Exception
     */
    Map<String, PassTemplate>  buildPassTemplateMap(List<Pass> passes) throws   Exception{
       String[] patterns = new String[]{"yyyy-MM-dd"};
       byte[] FAMILY_B = Bytes.toBytes(Constants.PassTemplateTable.FAMILY_B);
       byte[] ID = Bytes.toBytes(Constants.PassTemplateTable.ID);
       byte[] TITLE = Bytes.toBytes(Constants.PassTemplateTable.TITLE);
       byte[] DESC = Bytes.toBytes(Constants.PassTemplateTable.DESC);
       byte[] SUMMARY = Bytes.toBytes(Constants.PassTemplateTable.SUMMARY);
       byte[] BACKGROUND = Bytes.toBytes(Constants.PassTemplateTable.BACKGROUND);
       byte[] HAS_TOKEN = Bytes.toBytes(Constants.PassTemplateTable.HAS_TOKEN);

       byte[] FAMLIY_C = Bytes.toBytes(Constants.PassTemplateTable.FAMLIY_C);
       byte[] LIMIT = Bytes.toBytes(Constants.PassTemplateTable.LIMIT);
       byte[] START = Bytes.toBytes(Constants.PassTemplateTable.START);
       byte[] END = Bytes.toBytes(Constants.PassTemplateTable.END);

       List<String>  templateIds = passes.stream().map(Pass::getTemplateId).collect(Collectors.toList());
        List<Get> templateGets = new ArrayList<Get>(templateIds.size());
        templateIds.forEach(t ->templateGets.add(new Get(Bytes.toBytes(t))));
    }

}

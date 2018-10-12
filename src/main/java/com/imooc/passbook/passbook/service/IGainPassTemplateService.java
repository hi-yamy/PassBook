package com.imooc.passbook.passbook.service;

import com.imooc.passbook.passbook.vo.GainPassTemplateRequest;
import com.imooc.passbook.passbook.vo.Response;

/**
 * <h1>用户领取优惠券功能实现</h1>
 * Created by hanbian
 */
public interface IGainPassTemplateService {

    /**
     * <h2>用户领取优惠券</h2>
     * @param request {@link GainPassTemplateRequest}
     * @return {@link Response}
     * @throws Exception
     */
    Response gainPassTemplate(GainPassTemplateRequest  request) throws Exception;
}

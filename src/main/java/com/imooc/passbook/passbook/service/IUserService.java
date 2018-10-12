package com.imooc.passbook.passbook.service;

import com.imooc.passbook.passbook.vo.Response;
import com.imooc.passbook.passbook.vo.User;

/**
 * <h1>用户服务：创建User 服务</h1>
 * Created by hanbian
 */
public interface IUserService {

    /**
     * <h2>创建用户</h2>
     * @param user
     * @param  user {@link User}
     * @return {@link Response}
     * @throws Exception
     */
    Response  createUser(User user) throws  Exception;
}

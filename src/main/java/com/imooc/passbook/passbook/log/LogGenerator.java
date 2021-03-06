package com.imooc.passbook.passbook.log;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * <h1>日志生成器</h1>
 * Created by hanbian
 */
@Slf4j
public class LogGenerator {
     private static Logger log = LoggerFactory.getLogger(LogGenerator.class);
    /**
     * <h2>生成 log</h2>
     * @param  request {@link HttpServletRequest}
     * @param  userId 用户id
     * @param  action 日志类型
     * @parm  info 日志信息 ，可以是null
     */
    public static void genLog(HttpServletRequest request,Long userId,String action,Object info){
        log.info(
                JSON.toJSONString(new LogObject(action,userId,System.currentTimeMillis(),request.getRemoteAddr(),info)));

    };
}

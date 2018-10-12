package com.imooc.passbook.passbook.advice;

import com.imooc.passbook.passbook.vo.ErrorInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    public ErrorInfo<String> errorHandler(HttpServletRequest request,Exception e){
        ErrorInfo<String> info = new ErrorInfo<String>();
        info.setCode(ErrorInfo.ERROR);
        info.setMessage(e.getMessage());
        info.setUrl(request.getRequestURL().toString());
        info.setData("DO  Not HAVE  Return Data");
        return info;
    }
}

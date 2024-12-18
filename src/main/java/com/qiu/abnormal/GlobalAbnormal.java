package com.qiu.abnormal;

import com.qiu.entity.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@ResponseBody
public class GlobalAbnormal {

    @ExceptionHandler(value = Exception.class)
    public Result abnormalHandler(HttpServletRequest request, Exception e){

        return Result.error("服务器异常请联系管理员-->@3480705950@qq.com" + e.getMessage());
    }
}

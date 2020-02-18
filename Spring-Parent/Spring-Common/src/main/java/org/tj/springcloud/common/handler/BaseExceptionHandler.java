package org.tj.springcloud.common.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tj.springcloud.common.exception.CloudException;
import org.tj.springcloud.common.util.HttpResult;

@ControllerAdvice
public class BaseExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    HttpResult<String> error(Exception e) {
        e.printStackTrace();
        return HttpResult.ERROR(e.getMessage());

    }

}

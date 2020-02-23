package org.tj.springcloud.common.handler;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tj.springcloud.common.exception.CloudException;
import org.tj.springcloud.common.util.HttpResult;

import java.util.List;

@ControllerAdvice
public class BaseExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    HttpResult<String> error(Exception e) {
        e.printStackTrace();
        if (e instanceof MethodArgumentNotValidException) {
            BindingResult exceptions = ((MethodArgumentNotValidException) e).getBindingResult();
            if (exceptions.hasErrors()) {
                List<ObjectError> errors = exceptions.getAllErrors();
                if (!errors.isEmpty()) {
                    // 这里列出了全部错误参数，按正常逻辑，只需要第一条错误即可
                    FieldError fieldError = (FieldError) errors.get(0);
                    return HttpResult.ERROR(fieldError.getDefaultMessage());
                }
            }

        }
        return HttpResult.ERROR(e.getMessage());

    }

}

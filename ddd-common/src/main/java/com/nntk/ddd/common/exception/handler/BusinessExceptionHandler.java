package com.nntk.ddd.common.exception.handler;

import com.nntk.ddd.common.exception.BusinessException;
import com.nntk.ddd.common.result.RespBodyBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class BusinessExceptionHandler {

    @ExceptionHandler(value = BusinessException.class)
    public Object handlerException(BusinessException exception) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(RespBodyBuilder.create(exception));
    }
}

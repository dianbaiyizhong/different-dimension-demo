package com.nntk.ddd.common.exception.handler;

import com.alibaba.fastjson2.JSON;
import com.nntk.ddd.common.constant.CommonRestCode;
import com.nntk.ddd.common.result.RespBodyBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
@ResponseBody
public class ValidExceptionHandler {
    @ExceptionHandler(value = BindException.class)
    public Object handlerException(BindException exception) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(RespBodyBuilder.build(CommonRestCode.PARAM_ERROR, exception.getBindingResult().getFieldErrors()));
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Object handlerException(MethodArgumentNotValidException exception) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(RespBodyBuilder.build(CommonRestCode.PARAM_ERROR, exception.getBindingResult().getFieldErrors()));
    }


}

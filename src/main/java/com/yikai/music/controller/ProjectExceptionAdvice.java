package com.yikai.music.controller;

import com.yikai.music.exception.BusinessException;
import com.yikai.music.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler(SystemException.class)
    public Result deSystemException(Exception ex) {
        return new Result(1030, null, ex.getMessage());
    }


    @ExceptionHandler(BusinessException.class)
    public Result deBusinessException(Exception ex) {
        return new Result(1040, null, ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result deException(Exception ex) {
        return new Result(Code.UN_KNOW, null, ex.getMessage());
    }
}

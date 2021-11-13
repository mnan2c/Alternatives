package com.example.mybatisplus.common;

import lombok.Getter;

/**
 * @author mnzhang
 * @description
 * @date 2021/06/29
 */
@Getter
public class ServiceException extends RuntimeException {

    private final Integer code;
    private final String message;
    private Object data = null;

    public ServiceException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ServiceException(ConstError constError, Object data) {
        this(constError.code(), constError.message());
        this.data = data;
    }

    public ServiceException(ConstError constError) {
        this.code = constError.code();
        this.message = constError.message();
    }
}

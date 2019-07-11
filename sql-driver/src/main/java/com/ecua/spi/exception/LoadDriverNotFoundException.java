package com.ecua.spi.exception;

/**
 * Created by zxin on 2019-06-28.
 */
public class LoadDriverNotFoundException extends RuntimeException{
    private String code;

    private String message;

    public LoadDriverNotFoundException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package com.bc.wb.gym.base.utils;

public class ExceptionUtil extends RuntimeException{
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public ExceptionUtil(int code, String msg){
        super(msg);
        this.code = code;
    }
}

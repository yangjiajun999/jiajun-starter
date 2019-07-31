package com.jiajun.starter.common.web;

public enum RestCode {
    /**
     * 请求成功
     */
    OK(200, "请求成功");

    public final int code;
    public final String msg;

    RestCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

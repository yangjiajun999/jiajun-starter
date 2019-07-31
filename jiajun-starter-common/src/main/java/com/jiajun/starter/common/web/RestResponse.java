package com.jiajun.starter.common.web;

import lombok.Data;

@Data
public class RestResponse<T> {
    private int code;
    private String msg;
    private T data;

    public static <T> RestResponse<T> success() {
        return new RestResponse<>();
    }

    public static <T> RestResponse<T> success(T data) {
        RestResponse response = new RestResponse<T>();
        response.setData(data);
        return response;
    }

    public static <T> RestResponse<T> error(RestCode code) {
        return new RestResponse<T>(code.code, code.msg);
    }

    public static <T> RestResponse<T> error(RestCode code, T data) {
        return new RestResponse<T>(code.code, code.msg, data);
    }

    private RestResponse() {
        this(RestCode.OK.code, RestCode.OK.msg);
    }

    private RestResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private RestResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}

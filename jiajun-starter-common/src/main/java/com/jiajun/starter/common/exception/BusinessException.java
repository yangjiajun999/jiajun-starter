package com.jiajun.starter.common.exception;

import com.jiajun.starter.common.web.RestCode;

/**
 * @Author: 影风
 * @Date: 2019-07-31 13:55
 * @Description: 自定义业务逻辑夜场
 */
public class BusinessException extends RuntimeException
{
    private int code;

    public BusinessException(RestCode error)
    {
        super(error.msg);
        code = error.code;
    }
}

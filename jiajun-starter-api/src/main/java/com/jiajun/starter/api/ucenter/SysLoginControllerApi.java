package com.jiajun.starter.api.ucenter;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.io.IOException;

/**
 * @Author: 影风
 * @Date: 2019-07-31 13:19
 * @Description:
 */
@Api(value = "用户注册登录接口", tags = "注册登录")
public interface SysLoginControllerApi {
    @ApiOperation("生成验证码")
    void captcha(String uuid) throws IOException;
}

package com.jiajun.starter.api.ucenter;

import com.jiajun.starter.common.web.RestResponse;
import com.jiajun.starter.model.ucenter.dto.SysLoginDTO;
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

    @ApiOperation("用户登录验证")
    RestResponse<Boolean> login(SysLoginDTO sysLoginDto);

    @ApiOperation("语言切换")
    RestResponse<String> changeSessionLanauage(String lang);
}

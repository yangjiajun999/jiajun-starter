package com.jiajun.starter.model.ucenter.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

/**
 * @Author: 影风
 * @Date: 2019-08-06 19:00
 * @Description:
 */
@Data
public class SysLoginDto {
    @ApiModelProperty(value = "username", name = "用户名", example = "admin")
    private String username;
    @ApiModelProperty(value = "password", name = "密码", example = "123456")
    private String password;
    @ApiModelProperty(value = "captcha", name = "验证码", example = "bbsbb")
    @NotBlank(message = "{captcha.uuid.blank}")
    private String captcha;
    @ApiModelProperty(value = "uuid", name = "uuid", example = "abcdefgabcdefg")
    private String uuid;
}

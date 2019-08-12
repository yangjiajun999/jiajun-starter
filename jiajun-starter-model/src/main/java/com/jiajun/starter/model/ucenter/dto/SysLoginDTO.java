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
public class SysLoginDTO {
    @ApiModelProperty(value = "用户名", name = "username", example = "admin", required = true)
    private String username;

    @ApiModelProperty(value = "密码", name = "password", example = "123456", required = true)
    private String password;

    @ApiModelProperty(value = "captcha", name = "验证码", example = "bbsbb", required = true)
    @NotBlank(message = "{captcha.uuid.blank}")
    private String captcha;

    @ApiModelProperty(value = "uuid", name = "uuid", example = "abcdefgabcdefg", required = true)
    private String uuid;
}

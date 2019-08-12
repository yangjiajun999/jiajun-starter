package com.jiajun.starter.model.ucenter.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author: 影风
 * @Date: 2019-08-12 13:02
 * @Description:
 */
@Data
public class SysRegDTO {
    @ApiModelProperty(value = "邮箱", name = "email", example = "admin", required = true)
    @NotBlank(message = "{captcha.email.blank}")
    private String email;

    @ApiModelProperty(value = "uuid", name = "uuid", example = "abcdefgabcdefg", required = true)
    @NotBlank(message = "{captcha.uuid.blank}")
    private String uuid;
}

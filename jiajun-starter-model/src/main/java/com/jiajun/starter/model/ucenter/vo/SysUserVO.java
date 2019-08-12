package com.jiajun.starter.model.ucenter.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 影风
 * @Date: 2019-08-08 20:39
 * @Description:
 */
@Data
public class SysUserVO implements Serializable {
    @ApiModelProperty(value = "主键id", name = "id", example = "1")
    private Integer id;

    @ApiModelProperty(value = "用户名", name = "username", example = "admin")
    private String username;

    @ApiModelProperty(value = "密码", name = "password", example = "123456")
    private String password;
}

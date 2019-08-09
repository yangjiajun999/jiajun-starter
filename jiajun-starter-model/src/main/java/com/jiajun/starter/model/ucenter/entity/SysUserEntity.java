package com.jiajun.starter.model.ucenter.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author: 影风
 * @Date: 2019-07-23 13:06
 * @Description:
 */
@Data
@Table(name = "sys_user")
public class SysUserEntity implements Serializable {
    @ApiModelProperty(value = "主键id", name = "id", example = "1")
    private long id;

    @ApiModelProperty(value = "用户名", name = "username", example = "admin")
    private String username;

    @ApiModelProperty(value = "密码", name = "password", example = "123456")
    private String password;

    @ApiModelProperty(value = "加密盐", name = "salt", example = "asdfmewpce")
    private String salt;

    @ApiModelProperty(value = "账户状态", name = "status", example = "true")
    @Column(name = "status")
    private boolean status;
}

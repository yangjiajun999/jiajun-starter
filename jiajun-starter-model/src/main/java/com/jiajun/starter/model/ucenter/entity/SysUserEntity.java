package com.jiajun.starter.model.ucenter.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author: 影风
 * @Date: 2019-07-23 13:06
 * @Description:
 */
@Data
@ToString
@Table(name = "sys_user")
public class SysUserEntity implements Serializable {
    @ApiModelProperty(value = "主键id", name = "id", example = "1")
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ApiModelProperty(value = "用户名", name = "username", example = "admin")
    @Column(name = "username")
    private String username;

    @ApiModelProperty(value = "密码", name = "password", example = "123456")
    @Column(name = "password")
    private String password;

    @ApiModelProperty(value = "加密盐", name = "salt", example = "asdfmewpce")
    @Column(name = "salt")
    private String salt;

    @ApiModelProperty(value = "账户状态", name = "status", example = "true")
    @Column(name = "status")
    private boolean status;
}

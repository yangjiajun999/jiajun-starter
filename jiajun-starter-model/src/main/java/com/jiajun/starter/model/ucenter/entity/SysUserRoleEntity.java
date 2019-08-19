package com.jiajun.starter.model.ucenter.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * @Author: 影风
 * @Date: 2019-08-13 14:37
 * @Description:
 */
@Data
@ToString
@Table(name = "sys_user_role")
public class SysUserRoleEntity {
    @ApiModelProperty(value = "主键id", name = "id", example = "1")
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value = "用户id", name = "userId", example = "1")
    @Column(name = "user_id")
    private Long userId;

    @ApiModelProperty(value = "角色id", name = "roleId", example = "1")
    @Column(name = "role_id")
    private Long roleId;
}

package com.jiajun.starter.model.ucenter.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

/**
 * @Author: 影风
 * @Date: 2019-08-13 09:57
 * @Description:
 */
@Data
@Table(name = "sys_role")
public class SysRoleEntity {
    @ApiModelProperty(value = "主键id", name = "id", example = "1")
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}

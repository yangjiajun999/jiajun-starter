package com.jiajun.starter.model.ucenter.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @Author: 影风
 * @Date: 2019-08-13 09:57
 * @Description:
 */
@Data
@Table(name = "sys_role")
public class SysRoleEntity {
    @ApiModelProperty(value = "主键id", name = "id", example = "1")
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value = "角色名", name = "role_name", example = "1")
    @Column(name = "role_name")
    private String roleName;

    @ApiModelProperty(value = "状态", name = "status", example = "1")
    @Column(name = "status")
    private Boolean status;

    @ApiModelProperty(value = "备注", name = "remark", example = "1")
    @Column(name = "remark")
    private String remark;

    @ApiModelProperty(value = "创建者ID", name = "create_user_id", example = "1")
    @Column(name = "create_user_id")
    private Long userId;

    @ApiModelProperty(value = "创建时间", name = "create_time", example = "1")
    @Column(name = "create_time")
    private LocalDateTime createTime;
}

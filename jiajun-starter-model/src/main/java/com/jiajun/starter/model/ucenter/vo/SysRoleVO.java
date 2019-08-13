package com.jiajun.starter.model.ucenter.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: 影风
 * @Date: 2019-08-13 08:56
 * @Description:
 */
@Data
public class SysRoleVO implements Serializable {
    @ApiModelProperty(value = "角色名称", name = "name", example = "学员")
    private String roleName;

    @ApiModelProperty(value = "角色人数", name = "count", example = "20")
    private Long count;

    @ApiModelProperty(value = "状态", name = "status", example = "1")
    private boolean status;

    @ApiModelProperty(value = "创建人员", name = "username", example = "admin")
    private String username;

    @ApiModelProperty(value = "创建时间", name = "createTime", example = "2019-07-01 12:00:00")
    private LocalDateTime createTime;
}

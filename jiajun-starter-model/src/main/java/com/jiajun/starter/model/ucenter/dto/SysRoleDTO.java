package com.jiajun.starter.model.ucenter.dto;

import com.jiajun.starter.model.AbstractRequestDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: 影风
 * @Date: 2019-08-13 09:44
 * @Description:
 */
@Data
public class SysRoleDTO extends AbstractRequestDTO {
    @ApiModelProperty(value = "角色名称", name = "name", example = "学员")
    private String roleName;

    @ApiModelProperty(value = "状态", name = "status", example = "1")
    private boolean status = true;

    @ApiModelProperty(value = "创建人", name = "username", example = "admin")
    private String username;
}

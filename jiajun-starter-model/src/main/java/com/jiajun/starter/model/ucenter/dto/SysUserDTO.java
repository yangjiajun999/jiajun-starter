package com.jiajun.starter.model.ucenter.dto;

import com.jiajun.starter.model.AbstractRequestDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: 影风
 * @Date: 2019-08-06 15:32
 * @Description:
 */
@Data
public class SysUserDTO extends AbstractRequestDTO {
    @ApiModelProperty(value = "用户名", name = "username", example = "username")
    private String username;

    @ApiModelProperty(value = "状态", name = "status", example = "1")
    private boolean status = true;
}

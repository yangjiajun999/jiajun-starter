package com.jiajun.starter.model.ucenter.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: 影风
 * @Date: 2019-08-20 15:47
 * @Description:
 */
@Data
public class SysDeptDTO {
    @ApiModelProperty(value = "部门名称", name = "name", example = "研发部")
    private String name;
}

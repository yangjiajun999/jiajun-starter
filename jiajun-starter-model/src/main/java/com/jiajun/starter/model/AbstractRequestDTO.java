package com.jiajun.starter.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: 影风
 * @Date: 2019-08-08 20:28
 * @Description:
 */
@Data
public class AbstractRequestDTO {
    /**
     * 页码
     */
    @ApiModelProperty(value = "分页页码", name = "pageNum", example = "1")
    public int pageNum = 1;

    /**
     * 每页条数
     */
    @ApiModelProperty(value = "每页数量", name = "pageSize", example = "10")
    public int pageSize = 10;
}

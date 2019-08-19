package com.jiajun.starter.api.ucenter;

import com.jiajun.starter.common.web.RestResponse;
import com.jiajun.starter.model.ucenter.entity.SysDeptEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * @Author: 影风
 * @Date: 2019-08-19 10:34
 * @Description:
 */
@Api(value = "部门管理接口", tags = "部门管理")
public interface SysDeptControllerApi {
    @ApiOperation("获取子部门信息")
    RestResponse<List<SysDeptEntity>> getSubById(long id);

    @ApiOperation("获取部门列表")
    RestResponse<List<SysDeptEntity>> list();
}

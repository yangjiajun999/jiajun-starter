package com.jiajun.starter.api.ucenter;

import com.jiajun.starter.common.web.RestResponse;
import com.jiajun.starter.model.ucenter.entity.SysMenuEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * @Author: 影风
 * @Date: 2019-08-02 14:56
 * @Description:
 */
@Api(value = "菜单操作相关接口", tags = "菜单操作")
public interface SysMenuControllerApi {
    @ApiOperation("获取菜单列表")
    RestResponse<List<SysMenuEntity>> list();
}

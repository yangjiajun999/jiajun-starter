package com.jiajun.starter.api.ucenter;

import com.github.pagehelper.PageInfo;
import com.jiajun.starter.common.web.RestResponse;
import com.jiajun.starter.model.ucenter.dto.SysRoleDTO;
import com.jiajun.starter.model.ucenter.vo.SysRoleVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @Author: 影风
 * @Date: 2019-08-13 08:52
 * @Description:
 */
@Api(value = "角色管理相关接口", tags = "角色管理相关接口")
public interface SysRoleControllerApi {
    @ApiOperation("获取角色列表信息")
    RestResponse<PageInfo<SysRoleVO>> getAll(SysRoleDTO sysRoleDTO);
}

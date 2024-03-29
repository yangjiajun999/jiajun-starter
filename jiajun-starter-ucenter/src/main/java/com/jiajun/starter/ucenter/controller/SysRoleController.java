package com.jiajun.starter.ucenter.controller;

import com.github.pagehelper.PageInfo;
import com.jiajun.starter.api.ucenter.SysRoleControllerApi;
import com.jiajun.starter.common.web.RestResponse;
import com.jiajun.starter.model.ucenter.dto.SysRoleDTO;
import com.jiajun.starter.model.ucenter.vo.SysRoleVO;
import com.jiajun.starter.service.ucenter.SysRoleService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.jiajun.starter.common.web.RestResponse.success;

/**
 * @Author: 影风
 * @Date: 2019-08-13 08:52
 * @Description:
 */
@RestController
@RequestMapping("role")
@Log
public class SysRoleController implements SysRoleControllerApi {
    @Autowired
    private SysRoleService sysRoleService;

    @Override
    @PostMapping("getAll")
    public RestResponse<PageInfo<SysRoleVO>> getAll(@Validated @RequestBody SysRoleDTO sysRoleDTO) {
        return success(new PageInfo<>(sysRoleService.getAll(sysRoleDTO)));
    }

    @Override
    @GetMapping("/deleteById/{id}")
    public RestResponse<Boolean> deleteById(@PathVariable int id) {
        return success(sysRoleService.deleteById(id));
    }

    @Override
    @GetMapping("/freezeById/{id}")
    public RestResponse<Boolean> freezeById(@PathVariable int id) {
        return success(sysRoleService.freezeById(id));
    }
}

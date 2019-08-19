package com.jiajun.starter.ucenter.controller;

import com.github.pagehelper.PageInfo;
import com.jiajun.starter.api.ucenter.UcenterControllerApi;
import com.jiajun.starter.common.web.AbstractController;
import com.jiajun.starter.common.web.RestResponse;
import com.jiajun.starter.model.ucenter.SysUser;
import com.jiajun.starter.model.ucenter.dto.SysUserDTO;
import com.jiajun.starter.model.ucenter.entity.SysUserEntity;
import com.jiajun.starter.model.ucenter.vo.SysUserVO;
import com.jiajun.starter.service.ucenter.UcenterService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.jiajun.starter.common.web.RestResponse.success;

/**
 * @Author: 影风
 * @Date: 2019-07-23 09:56
 * @Description:
 */
@RestController
@RequestMapping("ucenter")
@Log
public class UcenterController extends AbstractController implements UcenterControllerApi {
    @Autowired
    private UcenterService ucenterService;

    @PostMapping("/getAll")
    public RestResponse<PageInfo<SysUserVO>> getAll(@RequestBody SysUserDTO sysUserDTO) {
        log.info(getUser().toString());
        log.info(getUserId() + "");
        return success(new PageInfo<>(ucenterService.getAll(sysUserDTO)));
    }

    @GetMapping("/getById")
    public RestResponse<SysUserEntity> getById(@RequestParam(value = "id") Long id) {
        return success(ucenterService.getById(id));
    }
}

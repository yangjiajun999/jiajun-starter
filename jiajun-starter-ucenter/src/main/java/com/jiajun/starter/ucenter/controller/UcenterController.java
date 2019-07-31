package com.jiajun.starter.ucenter.controller;

import com.jiajun.starter.api.ucenter.UcenterControllerApi;
import com.jiajun.starter.common.web.RestResponse;
import com.jiajun.starter.model.ucenter.SysUser;
import com.jiajun.starter.service.ucenter.UcenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.jiajun.starter.common.web.RestResponse.success;

/**
 * @Author: 影风
 * @Date: 2019-07-23 09:56
 * @Description:
 */
@RestController
@RequestMapping("ucenter")
public class UcenterController implements UcenterControllerApi {
    @Autowired
    private UcenterService ucenterService;

    @GetMapping("/getAll")
    public RestResponse<List<SysUser>> getAll(){
        return success(ucenterService.getAll());
    }

    @GetMapping("/getById")
    public RestResponse<SysUser> getById(@RequestParam(value = "id") int id){
        return success(ucenterService.getById(id));
    }
}

package com.jiajun.starter.ucenter.controller;

import com.jiajun.starter.api.ucenter.SysDeptControllerApi;
import com.jiajun.starter.common.web.RestResponse;
import com.jiajun.starter.model.ucenter.dto.SysDeptDTO;
import com.jiajun.starter.model.ucenter.entity.SysDeptEntity;
import com.jiajun.starter.service.ucenter.SysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.jiajun.starter.common.web.RestResponse.success;

/**
 * @Author: 影风
 * @Date: 2019-08-19 11:58
 * @Description:
 */
@RestController
@RequestMapping("/ucenter/dept")
public class SysDeptController implements SysDeptControllerApi {
    @Autowired
    private SysDeptService sysDeptService;

    @Override
    @GetMapping("getSubById")
    public RestResponse<List<SysDeptEntity>> getSubById(long id) {
        return success(sysDeptService.getSubById(id));
    }

    @Override
    @PostMapping("/getAll")
    public RestResponse<List<SysDeptEntity>> list(SysDeptDTO sysDeptDTO) {
        return success(sysDeptService.list(sysDeptDTO));
    }
}

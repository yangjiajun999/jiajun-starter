package com.jiajun.starter.ucenter.controller;

import com.jiajun.starter.api.ucenter.SysMenuControllerApi;
import com.jiajun.starter.common.web.RestResponse;
import com.jiajun.starter.model.ucenter.entity.SysMenuEntity;
import com.jiajun.starter.service.ucenter.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.jiajun.starter.common.web.RestResponse.success;

/**
 * @Author: 影风
 * @Date: 2019-08-02 14:53
 * @Description:
 */
@RestController
@RequestMapping("/ucenter/menu")
public class SysMenuController implements SysMenuControllerApi {
    @Autowired
    private SysMenuService sysMenuService;

    @Override
    @GetMapping("/list")
    public RestResponse<List<SysMenuEntity>> list(){
        List<SysMenuEntity> menuList = sysMenuService.list();

        for(SysMenuEntity sysMenuEntity : menuList){
            SysMenuEntity parentMenu = sysMenuService.getById(sysMenuEntity.getParentId());
            if(parentMenu != null){
                sysMenuEntity.setParentName(parentMenu.getName());
            }
        }

        return success(menuList);
    }
}

package com.jiajun.starter.service.ucenter;

import com.jiajun.starter.model.ucenter.entity.SysMenuEntity;

import java.util.List;

/**
 * @Author: 影风
 * @Date: 2019-08-02 15:03
 * @Description: 菜单操作业务逻辑处理
 */
public interface SysMenuService {
    /**
     * 获取菜单列表
     * @return
     */
    List<SysMenuEntity> list();

    SysMenuEntity getById(Long parentId);
}

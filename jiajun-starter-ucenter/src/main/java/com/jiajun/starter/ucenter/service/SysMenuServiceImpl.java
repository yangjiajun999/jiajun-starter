package com.jiajun.starter.ucenter.service;

import com.jiajun.starter.model.ucenter.entity.SysMenu;
import com.jiajun.starter.service.ucenter.SysMenuService;
import com.jiajun.starter.ucenter.mapper.SysMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 影风
 * @Date: 2019-08-02 15:07
 * @Description:
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {
    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<SysMenu> list() {
        return sysMenuMapper.selectAll();
    }

    @Override
    public SysMenu getById(Long parentId) {
        return sysMenuMapper.selectByPrimaryKey(parentId);
    }
}

package com.jiajun.starter.ucenter.service;

import com.github.pagehelper.PageHelper;
import com.jiajun.starter.model.ucenter.dto.SysRoleDTO;
import com.jiajun.starter.model.ucenter.vo.SysRoleVO;
import com.jiajun.starter.service.ucenter.SysRoleService;
import com.jiajun.starter.ucenter.mapper.SysRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 影风
 * @Date: 2019-08-13 09:56
 * @Description:
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public List<SysRoleVO> getAll(SysRoleDTO sysRoleDTO) {
        PageHelper.startPage(sysRoleDTO.getPageNum(), sysRoleDTO.getPageSize());
        return sysRoleMapper.getAll(sysRoleDTO);
    }
}

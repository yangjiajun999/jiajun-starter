package com.jiajun.starter.ucenter.service;

import com.github.pagehelper.PageHelper;
import com.jiajun.starter.model.ucenter.dto.SysRoleDTO;
import com.jiajun.starter.model.ucenter.entity.SysRoleEntity;
import com.jiajun.starter.model.ucenter.entity.SysUserRoleEntity;
import com.jiajun.starter.model.ucenter.vo.SysRoleVO;
import com.jiajun.starter.service.ucenter.SysRoleService;
import com.jiajun.starter.ucenter.mapper.SysRoleMapper;
import com.jiajun.starter.ucenter.mapper.SysUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

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
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public List<SysRoleVO> getAll(SysRoleDTO sysRoleDTO) {
        PageHelper.startPage(sysRoleDTO.getPageNum(), sysRoleDTO.getPageSize());
        return sysRoleMapper.getAll(sysRoleDTO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteById(int id) {
        Example example = new Example(SysUserRoleEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("role_id", id);
        sysUserRoleMapper.deleteByExample(criteria);
        return sysRoleMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean freezeById(int id) {
        SysRoleEntity sysRoleEntity = sysRoleMapper.selectByPrimaryKey(id);
        sysRoleEntity.setStatus(!sysRoleEntity.isStatus());
        return sysRoleMapper.updateByPrimaryKey(sysRoleEntity) > 0;
    }
}

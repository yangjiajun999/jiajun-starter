package com.jiajun.starter.ucenter.service;

import com.github.pagehelper.PageHelper;
import com.jiajun.starter.model.ucenter.SysUser;
import com.jiajun.starter.model.ucenter.dto.SysUserDTO;
import com.jiajun.starter.model.ucenter.vo.SysUserVO;
import com.jiajun.starter.service.ucenter.UcenterService;
import com.jiajun.starter.ucenter.mapper.UcenterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 影风
 * @Date: 2019-07-23 13:02
 * @Description:
 */
@Service
public class UcenterServiceImpl implements UcenterService {
    @Autowired
    private UcenterMapper ucenterMapper;

    @Override
    public List<SysUserVO> getAll(SysUserDTO sysUserDTO) {
        PageHelper.startPage(sysUserDTO.getPageNum(), sysUserDTO.getPageSize());

        return ucenterMapper.getAll(sysUserDTO);
    }

    @Override
    public SysUser getById(int id) {
        return ucenterMapper.getById(id);
    }
}

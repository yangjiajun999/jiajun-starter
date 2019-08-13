package com.jiajun.starter.ucenter.mapper;

import com.jiajun.starter.model.ucenter.dto.SysRoleDTO;
import com.jiajun.starter.model.ucenter.entity.SysRoleEntity;
import com.jiajun.starter.model.ucenter.vo.SysRoleVO;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

/**
 * @Author: 影风
 * @Date: 2019-08-13 09:57
 * @Description:
 */
public interface SysRoleMapper extends Mapper<SysRoleEntity>, MySqlMapper<SysRoleEntity> {
    /**
     * 获取角色列表信息
     * @param sysRoleDTO
     * @return
     */
    List<SysRoleVO> getAll(SysRoleDTO sysRoleDTO);
}

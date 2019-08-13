package com.jiajun.starter.service.ucenter;

import com.jiajun.starter.model.ucenter.dto.SysRoleDTO;
import com.jiajun.starter.model.ucenter.vo.SysRoleVO;

import java.util.List;

/**
 * @Author: 影风
 * @Date: 2019-08-13 09:48
 * @Description:
 */
public interface SysRoleService {
    /**
     * 获取管理员列表
     * @param sysRoleDTO
     * @return
     */
    List<SysRoleVO> getAll(SysRoleDTO sysRoleDTO);

    /**
     * 根据id删除角色信息
     * @param id
     * @return
     */
    boolean deleteById(int id);

    /**
     * 冻结解冻角色
     * @param id
     * @return
     */
    boolean freezeById(int id);
}

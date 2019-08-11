package com.jiajun.starter.ucenter.mapper;

import com.jiajun.starter.model.ucenter.SysUser;
import com.jiajun.starter.model.ucenter.dto.SysUserDTO;
import com.jiajun.starter.model.ucenter.entity.SysUserEntity;
import com.jiajun.starter.model.ucenter.vo.SysUserVO;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

/**
 * @Author: 影风
 * @Date: 2019-07-23 13:39
 * @Description:
 */
public interface UcenterMapper extends Mapper<SysUserEntity>, MySqlMapper<SysUserEntity> {
    /**
     * 根据条件查下所有用户数据
     * @param sysUserDTO
     * @return
     */
    List<SysUserVO> getAll(SysUserDTO sysUserDTO);

    /**
     * 查询用户的所有权限
     * @param userId  用户ID
     */
    List<String> getPermsByUserId(Long userId);
}

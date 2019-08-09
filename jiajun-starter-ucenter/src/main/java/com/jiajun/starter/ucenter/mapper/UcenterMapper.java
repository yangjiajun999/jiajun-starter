package com.jiajun.starter.ucenter.mapper;

import com.jiajun.starter.model.ucenter.SysUser;
import com.jiajun.starter.model.ucenter.dto.SysUserDTO;
import com.jiajun.starter.model.ucenter.vo.SysUserVO;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

/**
 * @Author: 影风
 * @Date: 2019-07-23 13:39
 * @Description:
 */
public interface UcenterMapper extends Mapper<SysUser>, MySqlMapper<SysUser> {
    List<SysUserVO> getAll(SysUserDTO sysUserDTO);

    SysUser getById(int id);
}

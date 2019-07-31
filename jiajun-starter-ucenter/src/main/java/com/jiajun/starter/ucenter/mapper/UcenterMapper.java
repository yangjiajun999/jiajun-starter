package com.jiajun.starter.ucenter.mapper;

import com.jiajun.starter.model.ucenter.SysUser;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Author: 影风
 * @Date: 2019-07-23 13:39
 * @Description:
 */
public interface UcenterMapper extends Mapper<SysUser>, MySqlMapper<SysUser> {
    SysUser getById(int id);
}

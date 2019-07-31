package com.jiajun.starter.service.ucenter;

import com.jiajun.starter.model.ucenter.SysUser;

import java.util.List;

/**
 * @Auther: 影风
 * @Date: 2019-07-23 13:00
 * @Description:
 */
public interface UcenterService {
    List<SysUser> getAll();

    SysUser getById(int id);
}

package com.jiajun.starter.service.ucenter;

import com.jiajun.starter.model.ucenter.entity.SysUserEntity;

import java.util.Set;

/**
 * @Author: 影风
 * @Date: 2019-08-09 11:18
 * @Description:
 */
public interface ShiroService {
    Set<String> getUserPermissions(Long userId);

    SysUserEntity findByToken(String accessToken);
}

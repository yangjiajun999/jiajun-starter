package com.jiajun.starter.ucenter.service;

import com.jiajun.starter.common.utils.RedisUtil;
import com.jiajun.starter.model.ucenter.entity.SysUserEntity;
import com.jiajun.starter.service.ucenter.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Author: 影风
 * @Date: 2019-08-09 14:18
 * @Description:
 */
@Service
public class ShiroServiceImpl implements ShiroService {
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public Set<String> getUserPermissions(Long userId) {
        return null;
    }

    @Override
    public SysUserEntity findByToken(String accessToken) {
        return (SysUserEntity) redisUtil.get(accessToken);
    }
}

package com.jiajun.starter.ucenter.service;

import com.jiajun.starter.common.utils.Constant;
import com.jiajun.starter.common.utils.RedisUtil;
import com.jiajun.starter.model.ucenter.entity.SysMenuEntity;
import com.jiajun.starter.model.ucenter.entity.SysUserEntity;
import com.jiajun.starter.service.ucenter.ShiroService;
import com.jiajun.starter.service.ucenter.SysMenuService;
import com.jiajun.starter.service.ucenter.UcenterService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author: 影风
 * @Date: 2019-08-09 14:18
 * @Description:
 */
@Service
public class ShiroServiceImpl implements ShiroService {
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private UcenterService ucenterService;
    @Autowired
    private SysMenuService sysMenuService;

    @Override
    public Set<String> getUserPermissions(Long userId) {
        List<String> permsList;

        //系统管理员，拥有最高权限
        if(userId == Constant.SUPER_ADMIN){
            List<SysMenuEntity> menuList = sysMenuService.list();
            permsList = new ArrayList<>(menuList.size());
            for(SysMenuEntity menu : menuList){
                permsList.add(menu.getPerms());
            }
        }else{
            permsList = ucenterService.getPermsByUserId(userId);
        }

        //用户权限列表
        Set<String> permsSet = new HashSet<>();
        for(String perms : permsList){
            if(StringUtils.isBlank(perms)){
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }
        return permsSet;
    }

    @Override
    public SysUserEntity findByToken(String token) {
        int id = (int) redisUtil.zScore(Constant.REDISKEY, token);
        return ucenterService.getById(id);
    }
}

package com.jiajun.starter.common.oauth2;

import com.jiajun.starter.common.exception.BusinessException;
import com.jiajun.starter.common.web.RestCode;
import com.jiajun.starter.model.ucenter.entity.SysUserEntity;
import com.jiajun.starter.service.ucenter.ShiroService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @Author: 影风
 * @Date: 2019-08-09 10:56
 * @Description:
 */
@Component
public class OAuth2Realm extends AuthorizingRealm {
    @Autowired
    private ShiroService shiroService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof OAuth2Token;
    }

    /**
     * 授权(验证权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SysUserEntity user = (SysUserEntity)principals.getPrimaryPrincipal();
        Long userId = user.getId();

        //用户权限列表
        Set<String> permsSet = shiroService.getUserPermissions(userId);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permsSet);
        return info;
    }

    /**
     * 认证(登录时调用)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String accessToken = (String) token.getPrincipal();

        //根据accessToken，查询用户信息
        SysUserEntity sysUserEntity = shiroService.findByToken(accessToken);
        //token失效
        if(sysUserEntity == null){
            throw new BusinessException(RestCode.USERNAME_NOT_EXSIT);
        }

        //账号锁定
        if(!sysUserEntity.isStatus()){
            throw new BusinessException(RestCode.ACCOUNT_LOCKED);
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(sysUserEntity, accessToken, getName());
        return info;
    }
}

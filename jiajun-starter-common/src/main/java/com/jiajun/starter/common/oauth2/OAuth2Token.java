package com.jiajun.starter.common.oauth2;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @Author: 影风
 * @Date: 2019-08-09 11:21
 * @Description:
 */
public class OAuth2Token implements AuthenticationToken {
    private String token;

    public OAuth2Token(String token){
        this.token = token;
    }

    @Override
    public String getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}

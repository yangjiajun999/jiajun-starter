package com.jiajun.starter.model.ucenter.entity;

import java.util.Date;

import lombok.Data;

@Data
public class CaptchaEntity {
    private String uuid;
    /**
     * 验证码
     */
    private String code;
    /**
     * 过期时间
     */
    private Date expireTime;
}

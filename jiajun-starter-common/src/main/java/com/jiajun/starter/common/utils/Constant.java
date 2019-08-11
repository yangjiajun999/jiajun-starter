package com.jiajun.starter.common.utils;

/**
 * @Author: 影风
 * @Date: 2019-08-18 10:27
 * @Description:
 */
public class Constant {
    /** 超级管理员ID */
    public static final int SUPER_ADMIN = 1;

    /** 在线人数key */
    public static final String REDISKEY = "online_users";

    /** 验证码过期时间 */
    public static final Long CAPTCHAEXPIRETIME = 600L;

    /** Token过期时间 */
    public final static Long TOKENEXPIRETIME = 3600L * 12;
}

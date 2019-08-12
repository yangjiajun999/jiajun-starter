package com.jiajun.starter.service.ucenter;

import java.awt.image.BufferedImage;

/**
 * @Author: 影风
 * @Date: 2019-07-31 13:29
 * @Description: 验证码业务逻辑
 */
public interface SysCaptchaService {
    /**
     * 生成验证码
     * @param uuid
     * @return
     */
    BufferedImage getCaptcha(String uuid);

    /**
     * 验证码校验
     * @param uuid
     * @param code
     * @return
     */
    boolean validate(String uuid, String code);

    /**
     * 生成5位验证码
     * @param uuid
     * @return
     */
    String getRegCaptcha(String uuid);
}

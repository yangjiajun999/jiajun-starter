package com.jiajun.starter.ucenter.service;

import com.google.code.kaptcha.Producer;
import com.jiajun.starter.common.exception.BusinessException;
import com.jiajun.starter.common.utils.Constant;
import com.jiajun.starter.common.utils.RedisUtil;
import com.jiajun.starter.common.web.RestCode;
import com.jiajun.starter.service.ucenter.SysCaptchaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

/**
 * @Author: 影风
 * @Date: 2019-07-31 13:32
 * @Description:
 */
@Service
public class SysCaptchaServiceImpl implements SysCaptchaService {
    @Autowired
    private Producer producer;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public BufferedImage getCaptcha(String uuid) {
        if(StringUtils.isBlank(uuid)){
            throw new BusinessException(RestCode.UUID_NOT_EXSIT);
        }

        //生成文字验证码
        String code = producer.createText();

        redisUtil.set(uuid, code, Constant.CAPTCHAEXPIRETIME);

        return producer.createImage(code);
    }

    @Override
    public boolean validate(String uuid, String code) {
        String redisCode = (String) redisUtil.get(uuid);
        if(redisCode == null) {
            return false;
        }

        if(!redisCode.equalsIgnoreCase(code)) {
            throw new BusinessException(RestCode.CAPTCHA_NOT_CORRECT);
        }

        return true;
    }
}

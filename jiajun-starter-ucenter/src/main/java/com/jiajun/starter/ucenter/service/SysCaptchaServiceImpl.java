package com.jiajun.starter.ucenter.service;

import com.google.code.kaptcha.Producer;
import com.jiajun.starter.common.exception.BusinessException;
import com.jiajun.starter.common.web.RestCode;
import com.jiajun.starter.model.ucenter.entity.CaptchaEntity;
import com.jiajun.starter.service.ucenter.SysCaptchaService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.util.Date;

/**
 * @Author: 影风
 * @Date: 2019-07-31 13:32
 * @Description:
 */
@Service
public class SysCaptchaServiceImpl implements SysCaptchaService {
    @Autowired
    private Producer producer;

    @Override
    public BufferedImage getCaptcha(String uuid) {
        if(StringUtils.isBlank(uuid)){
            throw new BusinessException(RestCode.OK);
        }

        //生成文字验证码
        String code = producer.createText();

        CaptchaEntity captchaEntity = new CaptchaEntity();
        captchaEntity.setUuid(uuid);
        captchaEntity.setCode(code);
        //5分钟后过期
        captchaEntity.setExpireTime(DateUtils.addMinutes(new Date(), 1));

        return producer.createImage(code);
    }

    @Override
    public boolean validate(String uuid, String code) {
        return false;
    }
}

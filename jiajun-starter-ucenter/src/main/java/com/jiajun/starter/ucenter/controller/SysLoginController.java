package com.jiajun.starter.ucenter.controller;

import com.jiajun.starter.api.ucenter.SysLoginControllerApi;
import com.jiajun.starter.common.exception.BusinessException;
import com.jiajun.starter.common.web.RestCode;
import com.jiajun.starter.common.web.RestResponse;
import com.jiajun.starter.model.ucenter.dto.SysLoginDTO;
import com.jiajun.starter.model.ucenter.entity.SysUserEntity;
import com.jiajun.starter.service.ucenter.SysCaptchaService;
import com.jiajun.starter.service.ucenter.UcenterService;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Locale;

import static com.jiajun.starter.common.web.RestResponse.success;

/**
 * @Author: 影风
 * @Date: 2019-07-31 13:25
 * @Description:
 */
@RestController
public class SysLoginController implements SysLoginControllerApi {
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private SysCaptchaService sysCaptchaService;
    @Autowired
    private UcenterService ucenterService;
    @Autowired
    private HttpServletRequest request;

    @Override
    @GetMapping("captcha.jpg")
    public void captcha(String uuid) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //获取图片验证码
        BufferedImage image = sysCaptchaService.getCaptcha(uuid);

        try (ServletOutputStream out = response.getOutputStream()) {
            ImageIO.write(image, "jpg", out);
        }
    }

    @Override
    @GetMapping("/i18n")
    public RestResponse<String> changeSessionLanauage(String lang) {
        switch (lang) {
            case "en_US":
                request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, new Locale("en", "US"));
                break;
            default:
                request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, new Locale("zh", "CN"));
        }

        return success(lang);
    }

    @Override
    @PostMapping("login")
    public RestResponse<String> login(@Validated @RequestBody SysLoginDTO sysLoginDto) {
        boolean captcha = sysCaptchaService.validate(sysLoginDto.getUuid(), sysLoginDto.getCaptcha());
        if (!captcha) {
            throw new BusinessException(RestCode.CAPTCHA_NOT_CORRECT);
        }

        //用户信息
        SysUserEntity user = ucenterService.findByUsername(sysLoginDto.getUsername());

        //用户名不存在
        if (user == null) {
            throw new BusinessException(RestCode.USERNAME_NOT_EXSIT);
        }

        //密码错误
        if (!user.getPassword().equals(new Sha256Hash(sysLoginDto.getPassword(), user.getSalt()).toHex())) {
            throw new BusinessException(RestCode.PASSWORD_NOT_CORRECT);
        }

        //账号锁定
        if (!user.isStatus()) {
            throw new BusinessException(RestCode.ACCOUNT_LOCKED);
        }

        return success(ucenterService.createToken(user));
    }
}

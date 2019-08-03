package com.jiajun.starter.ucenter.controller;

import com.jiajun.starter.api.ucenter.SysLoginControllerApi;
import com.jiajun.starter.service.ucenter.SysCaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

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
}

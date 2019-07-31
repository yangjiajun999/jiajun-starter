package com.jiajun.starter.admin.controller;

import com.jiajun.starter.common.web.RestResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

/**
 * @Author: 影风
 * @Date: 2019-07-24 10:49
 * @Description: 后台管理登录
 */
@RestController
@RequestMapping("admin")
public class AdminLoginController {
    @PostMapping("/login")
    public RestResponse login() {
        return null;
    }
}

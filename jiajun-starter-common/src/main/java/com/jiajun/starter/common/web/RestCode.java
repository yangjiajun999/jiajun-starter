package com.jiajun.starter.common.web;

public enum RestCode {
    /**
     * 请求成功
     */
    OK(200, "请求成功"),
    ACCESSDENIED(400, "拒绝访问"),
    LOGINFAILURE(401, "登录失败"),
    UUID_NOT_EXSIT(1000001, "UUID不存在"),
    TOKEN_CREATE_FAIL(1000002, "Token生成失败"),
    CAPTCHA_NOT_CORRECT(1000002, "验证码不正确"),
    USERNAME_NOT_EXSIT(1000003, "用户名不存在"),
    PASSWORD_NOT_CORRECT(1000004, "密码错误"),
    TOKEN_INVALID(1000005, "凭证失效"),
    ACCOUNT_LOCKED(1000006, "账户被锁定"),
    ROLE_DELETE_FAIL(1000007, "删除角色失败，请先冻结角色"),
    CANCEL(999999, "拒绝访问");

    public final int code;
    public final String msg;

    RestCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

package com.jiajun.starter.model.ucenter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: 影风
 * @Date: 2019-08-12 09:37
 * @Description:
 */
@Data
@AllArgsConstructor
public class SysUserTokenEntity {
    private Long id;
    private String username;
    private String token;
}

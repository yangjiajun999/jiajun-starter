package com.jiajun.starter.common.web;

import com.jiajun.starter.model.ucenter.entity.SysUserEntity;
import org.apache.shiro.SecurityUtils;

/**
 * Controller公共组件
 */
public abstract class AbstractController {
	protected SysUserEntity getUser() {
		return (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
	}

	protected Long getUserId() {
		return getUser().getId();
	}
}

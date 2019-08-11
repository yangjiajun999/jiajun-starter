package com.jiajun.starter.service.ucenter;

import com.jiajun.starter.model.ucenter.SysUser;
import com.jiajun.starter.model.ucenter.dto.SysUserDTO;
import com.jiajun.starter.model.ucenter.entity.SysUserEntity;
import com.jiajun.starter.model.ucenter.vo.SysUserVO;

import java.util.List;

/**
 * @Auther: 影风
 * @Date: 2019-07-23 13:00
 * @Description:
 */
public interface UcenterService {
    List<SysUserVO> getAll(SysUserDTO sysUserDTO);

    SysUserEntity getById(int id);

    SysUserEntity findByUsername(String username);

    String createToken(SysUserEntity user);

    List<String> getPermsByUserId(Long userId);
}

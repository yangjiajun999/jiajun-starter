package com.jiajun.starter.ucenter.service;

import com.github.pagehelper.PageHelper;
import com.jiajun.starter.common.utils.RedisUtil;
import com.jiajun.starter.common.utils.TokenUtil;
import com.jiajun.starter.model.ucenter.SysUser;
import com.jiajun.starter.model.ucenter.dto.SysUserDTO;
import com.jiajun.starter.model.ucenter.entity.SysUserEntity;
import com.jiajun.starter.model.ucenter.vo.SysUserVO;
import com.jiajun.starter.service.ucenter.UcenterService;
import com.jiajun.starter.ucenter.mapper.UcenterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author: 影风
 * @Date: 2019-07-23 13:02
 * @Description:
 */
@Service
public class UcenterServiceImpl implements UcenterService {
    @Autowired
    private UcenterMapper ucenterMapper;
    @Autowired
    private RedisUtil redisUtil;

    private final static Long EXPIRETIME = 3600L;

    @Override
    public List<SysUserVO> getAll(SysUserDTO sysUserDTO) {
        PageHelper.startPage(sysUserDTO.getPageNum(), sysUserDTO.getPageSize());

        return ucenterMapper.getAll(sysUserDTO);
    }

    @Override
    public SysUser getById(int id) {
        return ucenterMapper.getById(id);
    }

    @Override
    public SysUserEntity findByUsername(String username) {
        Example example = new Example(SysUserEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", username);
        return ucenterMapper.selectOneByExample(example);
    }

    @Override
    public String createToken(SysUserEntity user) {
        String token = (String) redisUtil.get(user.getUsername());

        if (token != null) {
            redisUtil.expire(user.getUsername(), EXPIRETIME);
            redisUtil.set(token, user, EXPIRETIME);
            return token;
        }

        token = TokenUtil.createToken();
        redisUtil.set(user.getUsername(), token, EXPIRETIME);
        redisUtil.set(token, user, EXPIRETIME);
        return token;
    }
}

package com.jiajun.starter.ucenter.service;

import com.github.pagehelper.PageHelper;
import com.jiajun.starter.common.utils.Constant;
import com.jiajun.starter.common.utils.RedisUtil;
import com.jiajun.starter.common.utils.TokenUtil;
import com.jiajun.starter.model.ucenter.dto.SysUserDTO;
import com.jiajun.starter.model.ucenter.entity.SysUserEntity;
import com.jiajun.starter.model.ucenter.entity.SysUserTokenEntity;
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

    @Override
    public List<SysUserVO> getAll(SysUserDTO sysUserDTO) {
        PageHelper.startPage(sysUserDTO.getPageNum(), sysUserDTO.getPageSize());

        return ucenterMapper.getAll(sysUserDTO);
    }

    @Override
    public SysUserEntity getById(int id) {
        return ucenterMapper.selectByPrimaryKey(id);
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

        //用户已登录过，过期时间自动重新计算
        if (token != null) {
            redisUtil.expire(user.getUsername(), Constant.TOKENEXPIRETIME);
            return token;
        }

        token = TokenUtil.createToken();
        redisUtil.set(user.getUsername(), token, Constant.TOKENEXPIRETIME);
        redisUtil.set(token, new SysUserTokenEntity(user.getId(), user.getUsername(), token));
        redisUtil.zadd(Constant.REDISKEY, user.getId(), token);
        return token;
    }

    @Override
    public List<String> getPermsByUserId(Long userId) {
        return ucenterMapper.getPermsByUserId(userId);
    }


}

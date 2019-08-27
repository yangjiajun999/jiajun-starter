package com.jiajun.starter.ucenter.mapper;

import com.jiajun.starter.model.ucenter.dto.SysDeptDTO;
import com.jiajun.starter.model.ucenter.entity.SysDeptEntity;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

/**
 * @Author: 影风
 * @Date: 2019-08-19 13:30
 * @Description:
 */
public interface SysDeptMapper extends Mapper<SysDeptEntity>, MySqlMapper<SysDeptEntity> {
    List<SysDeptEntity> list(SysDeptDTO sysDeptDTO);
}

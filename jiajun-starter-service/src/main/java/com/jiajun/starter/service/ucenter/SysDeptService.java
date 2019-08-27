package com.jiajun.starter.service.ucenter;

import com.jiajun.starter.model.ucenter.dto.SysDeptDTO;
import com.jiajun.starter.model.ucenter.entity.SysDeptEntity;

import java.util.List;

/**
 * @Author: 影风
 * @Date: 2019-08-19 12:00
 * @Description:
 */
public interface SysDeptService {
    /**
     * 根据parent_id查询子部门信息
     */
    List<SysDeptEntity> getSubById(Long id);

    /**
     * 部门管理列表
     * @param sysDeptDTO
     */
    List<SysDeptEntity> list(SysDeptDTO sysDeptDTO);
}

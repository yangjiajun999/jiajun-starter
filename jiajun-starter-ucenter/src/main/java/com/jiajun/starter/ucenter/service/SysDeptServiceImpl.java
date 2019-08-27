package com.jiajun.starter.ucenter.service;

import com.jiajun.starter.model.ucenter.dto.SysDeptDTO;
import com.jiajun.starter.model.ucenter.entity.SysDeptEntity;
import com.jiajun.starter.service.ucenter.SysDeptService;
import com.jiajun.starter.ucenter.mapper.SysDeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

/**
 * @Author: 影风
 * @Date: 2019-08-19 13:28
 * @Description:
 */
@Service
public class SysDeptServiceImpl implements SysDeptService {
    @Autowired
    private SysDeptMapper sysDeptMapper;

    @Override
    public List<SysDeptEntity> getSubById(Long id) {
        Example example = new Example(SysDeptEntity.class);
        example.setOrderByClause("order_num asc");
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("parentId", id);
        criteria.andEqualTo("deleted", 0);
        List<SysDeptEntity> entities = sysDeptMapper.selectByExample(example);

        for(SysDeptEntity entity : entities) {
            Example example2 = new Example(SysDeptEntity.class);
            Example.Criteria criteria2 = example2.createCriteria();
            criteria2.andEqualTo("deleted", 0);
            criteria2.andEqualTo("parentId", entity.getId());
            entity.setChildCount(sysDeptMapper.selectCountByExample(example2));

            if(entity.getChildCount() > 0) {
                entity.setIsLeaf(false);
            } else {
                entity.setIsLeaf(true);
            }
        }

        return entities;
    }

    @Override
    public List<SysDeptEntity> list(SysDeptDTO sysDeptDTO) {
        // 增加个字段Path Map<Path, List> 实现
        List<SysDeptEntity> container = new ArrayList<>();

        List<SysDeptEntity> entities = sysDeptMapper.list(sysDeptDTO);
        for(SysDeptEntity entity : entities) {
            getQueryDepts(container, entity);
        }

        return container;
    }

    private void getQueryDepts(List<SysDeptEntity> container, SysDeptEntity entity) {
        if (entity.getParentId() != null) {
            SysDeptEntity dept = getDeptById(entity.getParentId());
            dept.getList().add(entity);
            getQueryDepts(container, dept);
        } else {
            container.add(entity);
        }
    }

    /**
     * 根据id获取部门信息
     * @param id
     * @return
     */
    private SysDeptEntity getDeptById(long id) {
        Example example = new Example(SysDeptEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", id);
        return sysDeptMapper.selectOneByExample(example);
    }
}

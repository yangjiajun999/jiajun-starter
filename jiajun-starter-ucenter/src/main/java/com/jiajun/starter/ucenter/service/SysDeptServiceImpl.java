package com.jiajun.starter.ucenter.service;

import com.jiajun.starter.model.ucenter.entity.SysDeptEntity;
import com.jiajun.starter.service.ucenter.SysDeptService;
import com.jiajun.starter.ucenter.mapper.SysDeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

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
        return sysDeptMapper.selectByExample(example);
    }

    @Override
    public List<SysDeptEntity> list() {

        return null;
    }
}

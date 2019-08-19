package com.jiajun.starter.model.ucenter.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @Author: 影风
 * @Date: 2019-08-19 11:05
 * @Description:
 */
@Data
@Table(name = "sys_dept")
public class SysDeptEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "部门ID", name = "id", example = "1")
    private Long id;

    @ApiModelProperty(value = "上级部门ID", name = "id", example = "1")
    @Column(name = "parent_id")
    private Long parentId;

    @ApiModelProperty(value = "部门名称", name = "name", example = "研发部")
    @Column(name = "name")
    private String name;

    @ApiModelProperty(value = "排序", name = "order_num", example = "2")
    @Column(name = "order_num")
    private Integer orderNum;

    @ApiModelProperty(value = "是否删除", name = "deleted", example = "1：已删除 0：正常")
    @Column(name = "deleted")
    private Boolean deleted;

    @Transient
    @ApiModelProperty(value = "上级部门名称", name = "parentName", example = "研发部")
    private String parentName;

    @Transient
    @ApiModelProperty(value = "树是否打开", name = "open", example = "1：打开 0：关闭")
    private Boolean open;

    @Transient
    @ApiModelProperty(value = "子节点数据", name = "list", example = "前端组")
    private List<?> list;
}

package com.jiajun.starter.model.ucenter.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Table(name = "sys_menu")
public class SysMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "菜单ID", name = "menuId", example = "1")
    private Long menuId;

    @ApiModelProperty(value = "父菜单ID", name = "parentId", example = "0")
    private Long parentId;

    @Transient
    @ApiModelProperty(value = "父菜单名称", name = "parentName", example = "系统管理")
    private String parentName;

    @ApiModelProperty(value = "菜单名称", name = "name", example = "系统管理")
    private String name;

    @ApiModelProperty(value = "菜单URL", name = "url", example = "菜单URL")
    private String url;

    @ApiModelProperty(value = "授权", name = "perms", example = "user:list,user:create")
    private String perms;

    @ApiModelProperty(value = "类型", name = "type", example = "菜单")
    private Integer type;

    @ApiModelProperty(value = "菜单图标", name = "icon", example = "system")
    private String icon;

    @ApiModelProperty(value = "排序", name = "orderNum", example = "1")
    private Integer orderNum;

    @Transient
    @ApiModelProperty(value = "tree属性", name = "open", example = "false")
    private Boolean open;

    @Transient
    private List<?> list;
}

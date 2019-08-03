DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user`
(
    `id`              int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `username`        varchar(200)     NOT NULL COMMENT '用户名',
    `password`        varchar(200)     NOT NULL COMMENT '密码',
    `orgin`           int(1) unsigned  NOT NULL COMMENT '用户来源 1:新增 2:导入',
    `realname`        varchar(200)     NOT NULL COMMENT '姓名',
    `gender`          int(1) unsigned  NOT NULL COMMENT '性别 1：男  2：女  3: 其他',
    `avatar`          varchar(200)     NOT NULL DEFAULT '' COMMENT '头像',
    `is_freezed`      tinyint(1)       NOT NULL DEFAULT '0' COMMENT '是否冻结 0：否 1：是',
    `dep_id`          int(11) unsigned NOT NULL COMMENT '织组机构id',
    `position_id`     int(11) unsigned NOT NULL COMMENT '岗位id',
    `phone`           varchar(11)      NOT NULL DEFAULT '' COMMENT '手机',
    `leader_id`       int(11) unsigned NOT NULL DEFAULT '0' COMMENT '直属领导',
    `email`           varchar(200)     NOT NULL COMMENT '邮箱',
    `card_no`         varchar(18)      NOT NULL DEFAULT '' COMMENT '身份证号',
    `hiredate`        timestamp        NULL     DEFAULT NULL COMMENT '入职时间',
    `wrong_time`      int(2) unsigned  NOT NULL DEFAULT '0' COMMENT '登陆密码录入错误次数',
    `company_id`      int(11) unsigned NOT NULL DEFAULT '0' COMMENT '公司id',
    `level`           int(1) unsigned  NOT NULL DEFAULT '2' COMMENT '用户等级：1、系统管理员 2、普通用户',
    `pwd_modify_time` timestamp        NULL     DEFAULT NULL COMMENT '最后一次修改密码时间',
    `created_user`    int(11) unsigned          DEFAULT NULL COMMENT '创建人',
    `created_time`    timestamp        NULL     DEFAULT NULL COMMENT '创建时间',
    `updated_user`    int(11) unsigned          DEFAULT NULL COMMENT '修改人',
    `updated_time`    timestamp        NULL     DEFAULT NULL COMMENT '修改时间',
    `is_deleted`      tinyint(1)       NOT NULL DEFAULT '0' COMMENT '是否删除 0：否 1：是',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_all` (`dep_id`, `is_deleted`, `level`, `id`, `username`, `realname`, `phone`, `hiredate`, `email`,
                         `avatar`, `is_freezed`) USING BTREE,
    KEY `idx_by_phone` (`is_deleted`, `phone`) USING BTREE,
    KEY `idx_by_email` (`is_deleted`, `email`) USING BTREE,
    KEY `idx_by_username` (`is_deleted`, `username`) USING BTREE,
    KEY `idx_by_hiredate` (`hiredate`) USING BTREE,
    KEY `idx_by_isFreezed` (`is_freezed`) USING BTREE,
    KEY `idx_by_position_id` (`is_deleted`, `position_id`) USING BTREE,
    KEY `idx_by_dep` (`id`, `dep_id`, `is_deleted`, `level`) USING BTREE,
    KEY `idx_by_company` (`is_deleted`, `company_id`, `level`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='用户表';

-- 菜单
CREATE TABLE `sys_menu`
(
    `menu_id`   bigint NOT NULL AUTO_INCREMENT,
    `parent_id` bigint COMMENT '父菜单ID，一级菜单为0',
    `name`      varchar(50) COMMENT '菜单名称',
    `url`       varchar(200) COMMENT '菜单URL',
    `perms`     varchar(500) COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
    `type`      int COMMENT '类型   0：目录   1：菜单   2：按钮',
    `icon`      varchar(50) COMMENT '菜单图标',
    `order_num` int COMMENT '排序',
    PRIMARY KEY (`menu_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='菜单管理';

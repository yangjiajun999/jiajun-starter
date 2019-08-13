CREATE TABLE `sys_user`
(
    `id`             bigint(20)   NOT NULL AUTO_INCREMENT,
    `username`       varchar(50)  NOT NULL COMMENT '用户名',
    `password`       varchar(100)          DEFAULT NULL COMMENT '密码',
    `salt`           varchar(20)           DEFAULT NULL COMMENT '盐',
    `email`          varchar(100) NOT NULL DEFAULT '' COMMENT '邮箱',
    `realname`       varchar(50)           DEFAULT NULL COMMENT '真实姓名',
    `mobile`         varchar(100)          DEFAULT NULL COMMENT '手机号',
    `sex`            char(2)               DEFAULT NULL COMMENT '性别',
    `address`        varchar(50)           DEFAULT NULL COMMENT '地址',
    `source`         varchar(10)           DEFAULT NULL COMMENT '来源',
    `status`         tinyint(1)            DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
    `create_user_id` bigint(20)            DEFAULT NULL COMMENT '创建者ID',
    `create_time`    datetime              DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `username` (`username`),
    UNIQUE KEY `email` (`email`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8 COMMENT ='系统用户';

CREATE TABLE `sys_company`
(
    `id`             bigint(20)  NOT NULL AUTO_INCREMENT,
    `contact_name`   varchar(50) NOT NULL COMMENT '联系人姓名',
    `name`           varchar(50) NOT NULL COMMENT '企业名称',
    `address`        varchar(50) DEFAULT NULL COMMENT '企业地址',
    `category`       varchar(50) DEFAULT NULL COMMENT '单位性质',
    `industry`       varchar(10) DEFAULT NULL COMMENT '所属行业',
    `scale`          varchar(10) DEFAULT NULL COMMENT '单位规模',
    `capital`        varchar(10) DEFAULT NULL COMMENT '注册资金',
    `status`         tinyint(4)  DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
    `create_user_id` bigint(20)  DEFAULT NULL COMMENT '创建者ID',
    `create_time`    datetime    DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8 COMMENT ='企业';

CREATE TABLE `sys_menu`
(
    `id`        bigint(20) NOT NULL AUTO_INCREMENT,
    `parent_id` bigint(20)   DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
    `name`      varchar(50)  DEFAULT NULL COMMENT '菜单名称',
    `url`       varchar(200) DEFAULT NULL COMMENT '菜单URL',
    `perms`     varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
    `type`      int(11)      DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
    `icon`      varchar(50)  DEFAULT NULL COMMENT '菜单图标',
    `order_num` int(11)      DEFAULT NULL COMMENT '排序',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8 COMMENT ='菜单管理';

CREATE TABLE `sys_role`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT,
    `role_name`      varchar(100) DEFAULT NULL COMMENT '角色名称',
    `status`         tinyint(1)   DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
    `remark`         varchar(100) DEFAULT NULL COMMENT '备注',
    `create_user_id` bigint(20)   DEFAULT NULL COMMENT '创建者ID',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`),
    KEY `idx_role_name` (`role_name`),
    KEY `idx_name_status` (`status`, `role_name`),
    KEY `idx_create_user_id` (`create_user_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8 COMMENT ='角色';

CREATE TABLE `sys_user_role`
(
    `id`      bigint(20) NOT NULL AUTO_INCREMENT,
    `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
    `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
    PRIMARY KEY (`id`),
    KEY `idx_user_id` (`user_id`),
    KEY `idx_role_id` (`role_id`),
    KEY `idx_user_role` (`role_id`, `user_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARSET = utf8 COMMENT ='用户与角色对应关系';

CREATE TABLE `sys_role_menu`
(
    `id`      bigint NOT NULL AUTO_INCREMENT,
    `role_id` bigint COMMENT '角色ID',
    `menu_id` bigint COMMENT '菜单ID',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='角色与菜单对应关系';

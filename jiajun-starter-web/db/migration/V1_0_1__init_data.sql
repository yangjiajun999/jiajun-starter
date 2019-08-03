INSERT INTO `sys_user` (`id`, `username`, `password`, `orgin`, `realname`, `gender`, `avatar`, `is_freezed`,`dep_id`, `position_id`, `phone`, `leader_id`, `email`, `card_no`, `hiredate`,
 `wrong_time`, `company_id`, `level`, `pwd_modify_time`, `created_user`, `created_time`, `updated_user`, `updated_time`, `is_deleted`)
VALUES (1, 'admin', '$2a$10$tuv5raVR4jrTMRiVIpPpgOZVw9BJ2vg5/I8ZMPZx3gU3zdmchq1XW', 1, '管理员', 1,
        '', 0, 0, 0, '13683218469', 1,
        'yangjj@163.com', '362528198011051051', '2019-01-31 10:30:21', 5, 1, 1, '2019-01-31 10:30:21', 1, '2019-01-25 01:01:01', 1,
        '2019-01-25 01:01:01', 0);

-- 菜单（sys_menu）
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (1, 0, '系统管理', NULL, NULL, 0, 'system', 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (2, 1, '用户管理', NULL, NULL, 0, 'user', 0);

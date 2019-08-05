-- 系统用户（sys_user）
INSERT INTO `sys_user` (`id`, `username`, `password`, `salt`, `email`, `mobile`, `status`, `create_user_id`, `create_time`) VALUES ('1', 'admin', '9ec9750e709431dad22365cabc5c625482e574c74adaebba7dd02f1129e4ce1d', 'YzcmCZNvbXocrsz9dm8e', 'yangjj@retechcorp.com', '18112345678', '1', '1', '2011-11-11 11:11:11');

-- 菜单（sys_menu）
INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (1, 0, '系统管理', NULL, NULL, 0, 'system', 0);
INSERT INTO `sys_menu`(`id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (2, 1, '用户管理', NULL, NULL, 0, 'user', 0);

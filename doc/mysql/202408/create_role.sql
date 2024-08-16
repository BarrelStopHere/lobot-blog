CREATE TABLE `role`
(
    `uid`                varchar(32)  NOT NULL COMMENT '角色id',
    `role_name`          varchar(255) NOT NULL COMMENT '角色名',
    `create_time`        datetime     NOT NULL COMMENT '创建时间',
    `update_time`        datetime     NOT NULL COMMENT '更新时间',
    `status`             tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '状态',
    `summary`            varchar(255) DEFAULT NULL COMMENT '角色介绍 ',
    `category_menu_uids` text COMMENT '角色管辖的菜单的UID',
    PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
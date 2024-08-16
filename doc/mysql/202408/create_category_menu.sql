CREATE TABLE `category_menu` (
                                   `uid` varchar(32) NOT NULL COMMENT '唯一uid',
                                   `name` varchar(255) NOT NULL COMMENT '菜单名称',
                                   `menu_level` tinyint(1) DEFAULT NULL COMMENT '菜单级别',
                                   `summary` varchar(200) DEFAULT NULL COMMENT '简介',
                                   `parent_uid` varchar(32) DEFAULT NULL COMMENT '父uid',
                                   `url` varchar(255) DEFAULT NULL COMMENT 'url地址',
                                   `icon` varchar(50) DEFAULT NULL COMMENT '图标',
                                   `sort` int(11) DEFAULT '0' COMMENT '排序字段，越大越靠前',
                                   `status` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '状态',
                                   `create_time` datetime NOT NULL COMMENT '创建时间',
                                   `update_time` datetime NOT NULL COMMENT '更新时间',
                                   `is_show` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否显示 1:是 0:否',
                                   `menu_type` tinyint(1) NOT NULL DEFAULT '0' COMMENT '菜单类型 0: 菜单   1: 按钮',
                                   `is_jump_external_url` tinyint(1) DEFAULT '0' COMMENT '是否跳转外部链接 0：否，1：是',
                                   PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';

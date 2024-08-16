CREATE TABLE `link` (
                          `uid` varchar(32) NOT NULL COMMENT '唯一uid',
                          `title` varchar(255) DEFAULT NULL COMMENT '友情链接标题',
                          `summary` varchar(255) DEFAULT NULL COMMENT '友情链接介绍',
                          `url` varchar(255) DEFAULT NULL COMMENT '友情链接URL',
                          `click_count` int(11) DEFAULT '0' COMMENT '点击数',
                          `create_time` datetime NOT NULL COMMENT '创建时间',
                          `update_time` datetime NOT NULL COMMENT '更新时间',
                          `status` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '状态',
                          `sort` int(11) DEFAULT '0' COMMENT '排序字段，越大越靠前',
                          `link_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '友链状态： 0 申请中， 1：已上线，  2：已下架',
                          `user_uid` varchar(32) DEFAULT NULL COMMENT '申请用户UID',
                          `admin_uid` varchar(32) DEFAULT NULL COMMENT '操作管理员UID',
                          `email` varchar(255) DEFAULT NULL COMMENT '站长邮箱',
                          `file_uid` varchar(255) DEFAULT NULL COMMENT '网站图标',
                          PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='友情链接表';
CREATE TABLE `tag` (
                         `uid` varchar(32) NOT NULL COMMENT '唯一uid',
                         `content` varchar(1000) DEFAULT NULL COMMENT '标签内容',
                         `status` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '状态',
                         `click_count` int(11) DEFAULT '0' COMMENT '标签简介',
                         `create_time` timestamp NOT NULL COMMENT '创建时间',
                         `update_time` timestamp NOT NULL COMMENT '更新时间',
                         `sort` int(11) DEFAULT '0' COMMENT '排序字段，越大越靠前',
                         PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='标签表';
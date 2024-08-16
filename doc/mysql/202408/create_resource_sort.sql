CREATE TABLE `resource_sort` (
                                   `uid` varchar(32) NOT NULL COMMENT '唯一uid',
                                   `file_uid` varchar(32) DEFAULT NULL COMMENT '分类图片uid',
                                   `sort_name` varchar(255) DEFAULT NULL COMMENT '分类名',
                                   `content` varchar(255) DEFAULT NULL COMMENT '分类介绍',
                                   `click_count` varchar(255) DEFAULT NULL COMMENT '点击数',
                                   `status` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '状态',
                                   `create_time` datetime NOT NULL COMMENT '创建时间',
                                   `update_time` datetime NOT NULL COMMENT '更新时间',
                                   `parent_uid` varchar(32) DEFAULT NULL COMMENT '父UID',
                                   `sort` int(11) DEFAULT '0' COMMENT '排序字段',
                                   PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源分类表';
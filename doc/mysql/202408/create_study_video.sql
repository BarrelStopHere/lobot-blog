CREATE TABLE `study_video` (
                                 `uid` varchar(32) NOT NULL COMMENT '唯一uid',
                                 `file_uid` varchar(32) DEFAULT NULL COMMENT '视频封面图片uid',
                                 `resource_sort_uid` varchar(255) DEFAULT NULL COMMENT '资源分类UID',
                                 `name` varchar(255) DEFAULT NULL COMMENT '视频名称',
                                 `summary` varchar(255) DEFAULT NULL COMMENT '视频简介',
                                 `content` varchar(255) DEFAULT NULL COMMENT '分类介绍',
                                 `baidu_path` varchar(255) DEFAULT NULL COMMENT '百度云完整路径',
                                 `click_count` varchar(255) DEFAULT NULL COMMENT '点击数',
                                 `status` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '状态',
                                 `create_time` datetime NOT NULL COMMENT '创建时间',
                                 `update_time` datetime NOT NULL COMMENT '更新时间',
                                 `parent_uid` varchar(32) DEFAULT NULL,
                                 PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学习视频表';
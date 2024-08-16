CREATE TABLE `subject` (
                             `uid` varchar(32) NOT NULL COMMENT '主键',
                             `subject_name` varchar(255) DEFAULT NULL COMMENT '专题名称',
                             `summary` varchar(255) DEFAULT NULL COMMENT '简介',
                             `file_uid` varchar(32) DEFAULT NULL COMMENT '封面图片UID',
                             `click_count` int(11) NOT NULL DEFAULT '0' COMMENT '专题点击数',
                             `collect_count` int(11) NOT NULL DEFAULT '0' COMMENT '专题收藏数',
                             `status` tinyint(1) DEFAULT '1' COMMENT '状态',
                             `sort` int(11) NOT NULL DEFAULT '0' COMMENT '排序字段',
                             `create_time` datetime NOT NULL COMMENT '创建时间',
                             `update_time` datetime NOT NULL COMMENT '更新时间',
                             PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专题表';
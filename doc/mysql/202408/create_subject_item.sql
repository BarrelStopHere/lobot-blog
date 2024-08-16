CREATE TABLE `subject_item` (
                                  `uid` varchar(32) NOT NULL COMMENT '主键',
                                  `subject_uid` varchar(32) NOT NULL COMMENT '专题uid',
                                  `blog_uid` varchar(32) NOT NULL COMMENT '博客uid',
                                  `status` tinyint(1) DEFAULT '1' COMMENT '状态',
                                  `sort` int(11) NOT NULL DEFAULT '0' COMMENT '排序字段',
                                  `create_time` datetime NOT NULL COMMENT '创建时间',
                                  `update_time` datetime NOT NULL COMMENT '更新时间',
                                  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专题Item表';
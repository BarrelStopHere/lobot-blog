CREATE TABLE `picture_sort` (
                                  `uid` varchar(32) NOT NULL COMMENT '唯一uid',
                                  `file_uid` varchar(32) DEFAULT NULL COMMENT '分类图片uid',
                                  `name` varchar(255) DEFAULT NULL COMMENT '分类名',
                                  `status` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '状态',
                                  `create_time` datetime NOT NULL COMMENT '创建时间',
                                  `update_time` datetime NOT NULL COMMENT '更新时间',
                                  `parent_uid` varchar(32) DEFAULT NULL,
                                  `sort` int(11) DEFAULT '0' COMMENT '排序字段，越大越靠前',
                                  `is_show` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否显示，1：是，0，否',
                                  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图片分类表';
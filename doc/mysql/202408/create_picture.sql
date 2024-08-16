CREATE TABLE `picture` (
                             `uid` varchar(32) NOT NULL COMMENT '唯一uid',
                             `file_uid` varchar(32) DEFAULT NULL COMMENT '图片uid',
                             `pic_name` varchar(255) DEFAULT NULL COMMENT '图片名',
                             `picture_sort_uid` varchar(32) DEFAULT NULL COMMENT '分类uid',
                             `status` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '状态',
                             `create_time` datetime NOT NULL COMMENT '创建时间',
                             `update_time` datetime NOT NULL COMMENT '更新时间',
                             PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图片表';
CREATE TABLE `collect` (
                             `uid` varchar(32) NOT NULL COMMENT '唯一uid',
                             `user_uid` varchar(32) NOT NULL COMMENT '用户的uid',
                             `blog_uid` varchar(32) NOT NULL COMMENT '博客的uid',
                             `status` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '状态',
                             `create_time` datetime NOT NULL COMMENT '创建时间',
                             `update_time` datetime NOT NULL COMMENT '更新时间',
                             PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收藏表';
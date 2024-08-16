CREATE TABLE `comment` (
                           `uid` varchar(32) NOT NULL COMMENT '唯一uid',
                           `user_uid` varchar(32) DEFAULT NULL COMMENT '用户uid',
                           `to_uid` varchar(32) DEFAULT NULL COMMENT '回复某条评论的uid',
                           `to_user_uid` varchar(32) DEFAULT NULL COMMENT '回复某个人的uid',
                           `content` varchar(2048) DEFAULT NULL COMMENT '评论内容',
                           `blog_uid` varchar(32) DEFAULT NULL COMMENT '博客uid',
                           `status` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '状态',
                           `create_time` datetime NOT NULL COMMENT '创建时间',
                           `update_time` datetime NOT NULL COMMENT '更新时间',
                           `source` varchar(255) NOT NULL COMMENT '评论来源： MESSAGE_BOARD，ABOUT，BLOG_INFO 等',
                           `TYPE` tinyint(1) NOT NULL DEFAULT '0' COMMENT '评论类型 1:点赞 0:评论',
                           `first_comment_uid` varchar(32) DEFAULT NULL COMMENT '一级评论UID',
                           PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论表';
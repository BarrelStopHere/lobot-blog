CREATE TABLE `comment_report` (
                                    `uid` varchar(32) NOT NULL COMMENT '唯一uid',
                                    `user_uid` varchar(32) DEFAULT NULL COMMENT '举报人uid',
                                    `report_comment_uid` varchar(32) DEFAULT NULL COMMENT '被举报的评论Uid',
                                    `report_user_uid` varchar(32) DEFAULT NULL COMMENT '被举报的用户uid',
                                    `content` varchar(1000) DEFAULT NULL COMMENT '举报的原因',
                                    `progress` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '进展状态: 0 未查看   1: 已查看  2：已处理',
                                    `status` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '状态',
                                    `create_time` datetime NOT NULL COMMENT '创建时间',
                                    `update_time` datetime NOT NULL COMMENT '更新时间',
                                    PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论举报表';
CREATE TABLE `feedback` (
                              `uid` varchar(32) NOT NULL COMMENT '唯一uid',
                              `user_uid` varchar(32) NOT NULL COMMENT '用户uid',
                              `content` varchar(1000) DEFAULT NULL COMMENT '反馈的内容',
                              `status` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '状态',
                              `create_time` datetime NOT NULL COMMENT '创建时间',
                              `update_time` datetime NOT NULL COMMENT '更新时间',
                              `title` varchar(255) DEFAULT NULL COMMENT '标题',
                              `feedback_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '反馈状态： 0：已开启  1：进行中  2：已完成  3：已拒绝',
                              `reply` varchar(255) DEFAULT NULL COMMENT '回复',
                              `admin_uid` varchar(32) DEFAULT NULL COMMENT '管理员uid',
                              PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='反馈表';
CREATE TABLE `todo` (
                          `uid` varchar(32) NOT NULL COMMENT '唯一uid',
                          `admin_uid` varchar(32) DEFAULT NULL COMMENT '管理员uid',
                          `text` varchar(255) DEFAULT NULL COMMENT '内容',
                          `done` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '表示事项是否完成（0：未完成 1：已完成）',
                          `status` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '状态',
                          `create_time` datetime NOT NULL COMMENT '创建时间',
                          `update_time` datetime NOT NULL COMMENT '更新时间',
                          PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='代办事项表';
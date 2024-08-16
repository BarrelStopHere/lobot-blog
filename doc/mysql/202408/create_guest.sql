CREATE TABLE `guest` (
                             `uid` varchar(32) NOT NULL COMMENT '唯一uid',
                             `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',
                             `email` varchar(255) NOT NULL COMMENT '邮箱',
                             `login_count` int(11) unsigned DEFAULT '0' COMMENT '登录次数',
                             `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
                             `last_login_ip` varchar(50) DEFAULT '127.0.0.1' COMMENT '最后登录IP',
                             `status` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '状态',
                             `create_time` datetime NOT NULL COMMENT '创建时间',
                             `update_time` datetime NOT NULL COMMENT '更新时间',
                             PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='游客表';
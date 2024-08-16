CREATE TABLE `sys_log` (
                             `uid` varchar(32) NOT NULL COMMENT '唯一uid',
                             `user_name` varchar(255) NOT NULL COMMENT '用户名',
                             `admin_uid` varchar(32) DEFAULT NULL COMMENT '管理员uid',
                             `ip` varchar(50) DEFAULT NULL COMMENT '请求ip地址',
                             `url` varchar(255) DEFAULT NULL COMMENT '请求url',
                             `type` varchar(32) DEFAULT NULL COMMENT '请求方式',
                             `class_path` varchar(255) DEFAULT NULL COMMENT '请求类路径',
                             `method` varchar(32) DEFAULT NULL COMMENT '请求方法名',
                             `params` longtext COMMENT '请求参数',
                             `operation` varchar(32) DEFAULT NULL COMMENT '描述',
                             `status` tinyint(1) DEFAULT '1' COMMENT '状态',
                             `create_time` datetime NULL COMMENT '创建时间',
                             `update_time` datetime NULL COMMENT '更新时间',
                             `ip_source` varchar(255) DEFAULT NULL COMMENT 'ip来源',
                             `spend_time` int(11) DEFAULT '0' COMMENT '方法请求花费的时间',
                             PRIMARY KEY (`uid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `exception_log` (
                                   `uid` varchar(32) NOT NULL COMMENT '唯一uid',
                                   `exception_json` mediumtext COMMENT '异常对象json格式',
                                   `exception_message` mediumtext COMMENT '异常信息',
                                   `status` tinyint(1) DEFAULT '1' COMMENT '状态',
                                   `create_time` datetime NOT NULL  COMMENT '创建时间',
                                   `update_time` datetime NOT NULL COMMENT '更新时间',
                                   `ip` varchar(20) DEFAULT NULL COMMENT 'ip地址',
                                   `ip_source` varchar(100) DEFAULT NULL COMMENT 'ip来源',
                                   `method` varchar(255) DEFAULT NULL COMMENT '请求方法',
                                   `operation` varchar(100) DEFAULT NULL COMMENT '方法描述',
                                   `params` longtext COMMENT '请求参数',
                                   PRIMARY KEY (`uid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
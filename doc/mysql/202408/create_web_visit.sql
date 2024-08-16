CREATE TABLE `web_visit` (
                               `uid` varchar(32) NOT NULL COMMENT '主键',
                               `user_uid` varchar(255) DEFAULT NULL COMMENT '用户uid',
                               `ip` varchar(255) DEFAULT NULL COMMENT '访问ip地址',
                               `behavior` varchar(255) DEFAULT NULL COMMENT '用户行为',
                               `module_uid` varchar(255) DEFAULT NULL COMMENT '模块uid（文章uid，标签uid，分类uid）',
                               `other_data` varchar(255) DEFAULT NULL COMMENT '附加数据(比如搜索内容)',
                               `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态',
                               `create_time` datetime NOT NULL COMMENT '创建时间',
                               `update_time` datetime NOT NULL COMMENT '更新时间',
                               `os` varchar(255) DEFAULT NULL COMMENT '操作系统',
                               `browser` varchar(255) DEFAULT NULL COMMENT '浏览器',
                               `ip_source` varchar(255) DEFAULT NULL COMMENT 'ip来源',
                               PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Web访问记录表';
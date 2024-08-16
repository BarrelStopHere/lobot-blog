CREATE TABLE `sys_params` (
                                `uid` varchar(32) NOT NULL COMMENT '主键',
                                `params_type` varchar(1) NOT NULL DEFAULT '1' COMMENT '配置类型 是否系统内置(1:，是 0:否)',
                                `params_name` varchar(255) DEFAULT NULL COMMENT '参数名称',
                                `params_key` varchar(255) DEFAULT NULL COMMENT '参数键名',
                                `remark` varchar(255) DEFAULT NULL COMMENT '备注',
                                `params_value` varchar(255) DEFAULT NULL COMMENT '参数键值',
                                `status` tinyint(1) DEFAULT '1' COMMENT '状态',
                                `create_time` datetime NOT NULL COMMENT '创建时间',
                                `update_time` datetime NOT NULL COMMENT '更新时间',
                                `sort` int(11) NOT NULL DEFAULT '0' COMMENT '排序字段',
                                PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='参数配置表';
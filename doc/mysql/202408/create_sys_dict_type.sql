CREATE TABLE `sys_dict_type` (
                                   `uid` varchar(32) NOT NULL COMMENT '主键',
                                   `oid` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增键oid',
                                   `dict_name` varchar(255) DEFAULT NULL COMMENT '字典名称',
                                   `dict_type` varchar(255) DEFAULT NULL COMMENT '字典类型',
                                   `create_by_uid` varchar(32) NOT NULL COMMENT '创建人UID',
                                   `update_by_uid` varchar(32) NOT NULL COMMENT '最后更新人UID',
                                   `remark` varchar(255) DEFAULT NULL COMMENT '备注',
                                   `status` tinyint(1) DEFAULT '1' COMMENT '状态',
                                   `create_time` datetime NOT NULL COMMENT '创建时间',
                                   `update_time` datetime NOT NULL COMMENT '更新时间',
                                   `is_publish` varchar(1) NOT NULL DEFAULT '1' COMMENT '是否发布(1:是，0:否)',
                                   `sort` int(11) NOT NULL DEFAULT '0' COMMENT '排序字段',
                                   PRIMARY KEY (`uid`),
                                   KEY `oid` (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='字典类型表';
CREATE TABLE `file_sort` (
                             `uid` varchar(36) NOT NULL COMMENT '唯一uid',
                             `project_name` varchar(255) DEFAULT NULL COMMENT '项目名',
                             `sort_name` varchar(255) DEFAULT NULL COMMENT '分类名',
                             `url` varchar(255) DEFAULT NULL COMMENT '分类路径',
                             `status` tinyint unsigned NOT NULL DEFAULT '1' COMMENT '状态',
                             `create_time` timestamp NOT NULL DEFAULT '2025-02-21 00:00:00' COMMENT '创建时间',
                             `update_time` timestamp NOT NULL DEFAULT '2025-02-21 00:00:00' COMMENT '更新时间',
                             PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文件分类表';
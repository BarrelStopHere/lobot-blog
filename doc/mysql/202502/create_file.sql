CREATE TABLE `file` (
                          `uid` varchar(36) NOT NULL COMMENT '唯一uid',
                          `file_old_name` varchar(255) DEFAULT NULL COMMENT '旧文件名',
                          `pic_name` varchar(255) DEFAULT NULL COMMENT '文件名',
                          `pic_url` varchar(255) DEFAULT NULL COMMENT '文件地址',
                          `pic_expanded_name` varchar(255) DEFAULT NULL COMMENT '文件扩展名',
                          `file_size` int DEFAULT '0' COMMENT '文件大小',
                          `file_sort_uid` varchar(36) DEFAULT NULL COMMENT '文件分类uid',
                          `admin_uid` varchar(36) DEFAULT NULL COMMENT '管理员uid',
                          `user_uid` varchar(36) DEFAULT NULL COMMENT '用户uid',
                          `status` tinyint unsigned NOT NULL DEFAULT '1' COMMENT '状态',
                          `create_time` timestamp NOT NULL DEFAULT '2025-02-21 00:00:00' COMMENT '创建时间',
                          `update_time` timestamp NOT NULL DEFAULT '2025-02-21 00:00:00' COMMENT '更新时间',
                          `qi_niu_url` varchar(255) DEFAULT NULL COMMENT '七牛云地址',
                          `minio_url` varchar(255) DEFAULT NULL COMMENT 'Minio文件URL',
                          PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文件表';
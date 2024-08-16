CREATE TABLE `blog_sort` (
                               `uid` varchar(32) NOT NULL COMMENT '唯一uid',
                               `sort_name` varchar(255) DEFAULT NULL COMMENT '分类内容',
                               `content` varchar(255) DEFAULT NULL COMMENT '分类简介',
                               `create_time` datetime NOT NULL COMMENT '创建时间',
                               `update_time` datetime NOT NULL COMMENT '更新时间',
                               `status` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '状态',
                               `sort` int(11) DEFAULT '0' COMMENT '排序字段，越大越靠前',
                               `click_count` int(11) DEFAULT '0' COMMENT '点击数',
                               PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='博客分类表';
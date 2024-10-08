CREATE TABLE `blog_spider` (
                                 `uid` varchar(32) NOT NULL COMMENT '唯一uid',
                                 `title` varchar(200) DEFAULT NULL COMMENT '博客标题',
                                 `summary` varchar(200) DEFAULT NULL COMMENT '博客简介',
                                 `content` longtext COMMENT '博客内容',
                                 `tag_uid` varchar(255) DEFAULT NULL COMMENT '标签uid',
                                 `click_count` int(11) DEFAULT '0' COMMENT '博客点击数',
                                 `collect_count` int(11) DEFAULT '0' COMMENT '博客收藏数',
                                 `file_uid` varchar(255) DEFAULT NULL COMMENT '标题图片uid',
                                 `status` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '状态',
                                 `create_time` datetime NOT NULL COMMENT '创建时间',
                                 `update_time` datetime NOT NULL COMMENT '更新时间',
                                 `admin_uid` varchar(32) DEFAULT NULL COMMENT '管理员uid',
                                 `is_original` varchar(1) DEFAULT '1' COMMENT '是否原创（0:不是 1：是）',
                                 `author` varchar(255) DEFAULT NULL COMMENT '作者',
                                 `articles_part` varchar(255) DEFAULT NULL COMMENT '文章出处',
                                 `blog_sort_uid` varchar(32) DEFAULT NULL COMMENT '博客分类UID',
                                 `level` tinyint(1) DEFAULT '0' COMMENT '推荐等级(0:正常)',
                                 `is_publish` varchar(1) DEFAULT '1' COMMENT '是否发布：0：否，1：是',
                                 `sort` int(11) NOT NULL DEFAULT '0' COMMENT '排序字段',
                                 PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='博客爬取表';
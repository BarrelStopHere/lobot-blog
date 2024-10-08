CREATE TABLE `web_navbar` (
                                `uid` varchar(96) DEFAULT NULL,
                                `name` varchar(765) DEFAULT NULL,
                                `navbar_level` tinyint(1) DEFAULT NULL,
                                `summary` varchar(600) DEFAULT NULL,
                                `parent_uid` varchar(96) DEFAULT NULL,
                                `url` varchar(765) DEFAULT NULL,
                                `icon` varchar(150) DEFAULT NULL,
                                `is_show` tinyint(1) DEFAULT NULL,
                                `is_jump_external_url` tinyint(1) DEFAULT NULL,
                                `sort` int(11) DEFAULT NULL,
                                `status` tinyint(1) DEFAULT NULL,
                                `create_time` datetime NOT NULL,
                                `update_time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
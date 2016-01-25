CREATE TABLE IF NOT EXISTS `webpage`(
	`id` BIGINT AUTO_INCREMENT,
	`crc` BIGINT COMMENT '网址的CRC32',
	`url` LONGTEXT COMMENT '网址',
	`vice_url` LONGTEXT COMMENT 'AJAX请求网址',
	`title` LONGTEXT COMMENT '标题',
	`content` LONGTEXT COMMENT '网页文字内容',
	`html` LONGTEXT COMMENT '网页HTML',
	`status_code` INT COMMENT '主机返回状态',
	`content_type` VARCHAR(256) COMMENT '类型',
	`headers` TEXT COMMENT '头信息',
	`md5` VARCHAR(512) COMMENT '整个网页的md5',

	article_title LONGTEXT COMMENT '文章标题',
	article_body LONGTEXT COMMENT '文章正文',
	category LONGTEXT COMMENT '文章分类',
	tag LONGTEXT COMMENT '文章标签',
	release_time TIMESTAMP COMMENT '文章发布时间',
	author VARCHAR(64) COMMENT '作者',

	crawle_time TIMESTAMP COMMENT '爬取时间',
	CONSTRAINT pk_webpage_id PRIMARY KEY(`id`),
	INDEX index_url_crc(`crc`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT '网页数据表';

CREATE TABLE IF NOT EXISTS `user`(
	`id` BIGINT AUTO_INCREMENT,
	`name` VARCHAR(32) NOT NULL COMMENT '用户名',
	`password` VARCHAR(512) NOT NULL COMMENT '密码',
	`enable` BOOLEAN DEFAULT TRUE COMMENT '是否可用',
	CONSTRAINT `pk_user_id` PRIMARY KEY(`id`),
	UNIQUE KEY `uc_user_name` (`name`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT '用户表';

CREATE TABLE IF NOT EXISTS `role`(
	`id` BIGINT AUTO_INCREMENT,
	`name` VARCHAR(32) NOT NULL COMMENT '角色名',
	CONSTRAINT `pk_role_id` PRIMARY KEY(`id`),
	UNIQUE KEY `uc_role_name`(`name`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT '角色表';

CREATE TABLE IF NOT EXISTS `user_role`(
	`user_id` BIGINT,
	`role_id` BIGINT,
	CONSTRAINT `fk_user_role_user_id` FOREIGN KEY (`user_id`) REFERENCES `user`(`id`),
	CONSTRAINT `fk_user_role_role_id` FOREIGN KEY (`role_id`) REFERENCES `role`(`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT '用户-角色关联表';


CREATE TABLE IF NOT EXISTS `resource`(
	`id` BIGINT AUTO_INCREMENT,
	`url` VARCHAR(1024) NOT NULL COMMENT '资源URL',
	CONSTRAINT `pk_resource_id` PRIMARY KEY(`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT '资源表';


CREATE TABLE IF NOT EXISTS `role_resource`(
	`role_id` BIGINT,
	`resource_id` BIGINT,
	CONSTRAINT `fk_role_resource_role_id` FOREIGN KEY (`role_id`) REFERENCES `role`(`id`),
	CONSTRAINT `fk_role_resource_resource_id` FOREIGN KEY (`resource_id`) REFERENCES `resource`(`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT '角色-资源关联表';

CREATE TABLE IF NOT EXISTS `menu`(
	`id` BIGINT AUTO_INCREMENT,
	`name` VARCHAR(256) NOT NULL COMMENT '菜单名',
	`resource_id` BIGINT COMMENT '资源ID',
	CONSTRAINT `pk_menu_id` PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT '菜单表';


INSERT INTO `resource`(`url`) VALUES('/admin/index.do');
INSERT INTO `resource`(`url`) VALUE ('/admin/resource/list.do');
INSERT INTO `resource`(`url`) VALUE ('/admin/resource/addInit.do');
INSERT INTO `resource`(`url`) VALUE ('/admin/resource/add.do');
INSERT INTO `resource`(`url`) VALUE ('/admin/resource/editInit.do');
INSERT INTO `resource`(`url`) VALUE ('/admin/resource/edit.do');
INSERT INTO `resource`(`url`) VALUE ('/admin/resource/delete.do');

INSERT INTO `resource`(`url`) VALUE ('/admin/menu/list.do');
INSERT INTO `resource`(`url`) VALUE ('/admin/menu/addInit.do');
INSERT INTO `resource`(`url`) VALUE ('/admin/menu/add.do');
INSERT INTO `resource`(`url`) VALUE ('/admin/menu/editInit.do');
INSERT INTO `resource`(`url`) VALUE ('/admin/menu/edit.do');
INSERT INTO `resource`(`url`) VALUE ('/admin/menu/delete.do');

INSERT INTO `resource`(`url`) VALUE ('/admin/role/list.do');
INSERT INTO `resource`(`url`) VALUE ('/admin/role/addInit.do');
INSERT INTO `resource`(`url`) VALUE ('/admin/role/add.do');
INSERT INTO `resource`(`url`) VALUE ('/admin/role/editInit.do');
INSERT INTO `resource`(`url`) VALUE ('/admin/role/edit.do');
INSERT INTO `resource`(`url`) VALUE ('/admin/role/delete.do');

INSERT INTO `resource`(`url`) VALUE ('/admin/user/list.do');
INSERT INTO `resource`(`url`) VALUE ('/admin/user/addInit.do');
INSERT INTO `resource`(`url`) VALUE ('/admin/user/add.do');
INSERT INTO `resource`(`url`) VALUE ('/admin/user/editInit.do');
INSERT INTO `resource`(`url`) VALUE ('/admin/user/edit.do');
INSERT INTO `resource`(`url`) VALUE ('/admin/user/delete.do');

INSERT INTO `resource`(`url`) VALUE ('/admin/crawler/list.do');
INSERT INTO `resource`(`url`) VALUE ('/admin/crawler/addInit.do');
INSERT INTO `resource`(`url`) VALUE ('/admin/crawler/add.do');
INSERT INTO `resource`(`url`) VALUE ('/admin/crawler/delete.do');

INSERT INTO `role`(`name`) VALUES('admin');
INSERT INTO `user`(`name`,`password`) VALUES('admin','123456');
INSERT INTO `user_role` VALUES((SELECT `id` FROM `user` WHERE `name`='admin'),(SELECT `id` FROM `role` WHERE `name`='admin'));

INSERT INTO `menu`(`name`,`resource_id`) VALUES('资源列表',(SELECT `id` from `resource` where `url`='/admin/resource/list.do'));
INSERT INTO `menu`(`name`,`resource_id`) VALUES('菜单列表',(SELECT `id` from `resource` where `url`='/admin/menu/list.do'));
INSERT INTO `menu`(`name`,`resource_id`) VALUES('角色列表',(SELECT `id` from `resource` where `url`='/admin/role/list.do'));
INSERT INTO `menu`(`name`,`resource_id`) VALUES('用户列表',(SELECT `id` from `resource` where `url`='/admin/user/list.do'));
INSERT INTO `menu`(`name`,`resource_id`) VALUES('爬虫列表',(SELECT `id` from `resource` where `url`='/admin/crawler/list.do'));
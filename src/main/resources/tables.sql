CREATE TABLE IF NOT EXISTS `WebPage`(
	`id` BIGINT AUTO_INCREMENT,
	`crc` BIGINT COMMENT '网址和副网址的CRC32',
	`url` LONGTEXT COMMENT '网址',
	`vice_url` LONGTEXT COMMENT 'AJAX请求网址',
	`title` LONGTEXT COMMENT '标题',
	`content` LONGTEXT COMMENT '网页文字内容',
	`html` LONGTEXT COMMENT '网页HTML',
	`status_code` INT COMMENT '主机返回状态',
	`content_type` VARCHAR(256) COMMENT '类型',
	`headers` TEXT COMMENT '头信息',

	article_title LONGTEXT COMMENT '文章标题',
	article_body LONGTEXT COMMENT '文章正文',
	category LONGTEXT COMMENT '文章分类',
	tag LONGTEXT COMMENT '文章标签',
	release_time TIMESTAMP COMMENT '文章发布时间',
	author VARCHAR(64) COMMENT '作者',

	crawler_time TIMESTAMP COMMENT '爬取时间',
	CONSTRAINT pk_webpage_id PRIMARY KEY(`id`),
	INDEX index_url_crc(`crc`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE IF NOT EXISTS `CrawlerInfo`(
	`id` INT(16) AUTO_INCREMENT,
	`desc` VARCHAR(512),
	`topN` INT,
	`autoParse` BOOLEAN,
	`resumable` BOOLEAN,
	`seeds` TEXT,
	`regex` TEXT,
	`matching` TEXT,
	`maxRetry` INT(1),
	`retry` INT(1),
	`depth` INT(2),
	CONSTRAINT pk_crawlerTask_id PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
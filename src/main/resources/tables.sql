CREATE TABLE IF NOT EXISTS `WebPage`(
	`id` INT(16) AUTO_INCREMENT,
	`title` TEXT,
	`content` TEXT,
	`url` TEXT,
	CONSTRAINT pk_webpage_id PRIMARY KEY(id)
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=10000000;
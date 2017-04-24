/** 创建数据库 */
CREATE DATABASE `wenhua` /*!40100 COLLATE 'utf8_general_ci' */;
use wenhua;

/** 设置自增起始值与步长 auto_increment_offset <= auto_increment_increment */
SET global auto_increment_increment=1;
SET global auto_increment_offset=1;

CREATE TABLE `t_net_bar` (
	`id` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '工商注册号',
	`net_bar_name` VARCHAR(100) NULL DEFAULT NULL,
	`bar_id` VARCHAR(10) NOT NULL,
	`address_code` VARCHAR(500) NULL DEFAULT NULL,
	`address_name` VARCHAR(100) NULL DEFAULT NULL,
	`contact_name` VARCHAR(50) NULL DEFAULT NULL,
	`contact_tel` VARCHAR(20) NULL DEFAULT NULL,
	`client_total` INT(10) NULL DEFAULT NULL,
	`outside_network` VARCHAR(50) NULL DEFAULT NULL,
	`inside_network` VARCHAR(50) NULL DEFAULT NULL,
	`server_mac` VARCHAR(50) NULL DEFAULT NULL,
	`creator` VARCHAR(20) NULL DEFAULT NULL,
	`create_time` TIMESTAMP NULL DEFAULT NULL,
	`status` INT(1) NOT NULL DEFAULT '1' COMMENT '1：有效；0：无效',
	PRIMARY KEY (`id`),
	UNIQUE INDEX `bar_id` (`bar_id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

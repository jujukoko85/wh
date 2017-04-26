/** 创建数据库 */
CREATE DATABASE `qcms` /*!40100 COLLATE 'utf8_general_ci' */;
use qcms;

/** 设置自增起始值与步长 auto_increment_offset <= auto_increment_increment */
SET global auto_increment_increment=1;
SET global auto_increment_offset=1;

CREATE TABLE `t_server_info` (
	`id` VARCHAR(50) NOT NULL COMMENT '服务器MAC地址',
	`bar_id` VARCHAR(50) NOT NULL COMMENT '网吧ID',
	`ip` VARCHAR(50) NOT NULL COMMENT '服务器IP地址',
	`pc_name` VARCHAR(50) NOT NULL COMMENT '服务器名称',
	`os_type` INT(11) NOT NULL COMMENT '服务器操作系统类型',
	`os_version` VARCHAR(50) NOT NULL COMMENT '服务器操作系统版本',
	`creator` VARCHAR(50) NOT NULL COMMENT '创建者',
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
	PRIMARY KEY (`id`)
)
COMMENT='服务器信息表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

CREATE TABLE `t_pc_info` (
	`id` VARCHAR(50) NOT NULL COMMENT '客户机MAC地址',
	`bar_id` VARCHAR(50) NOT NULL COMMENT '网吧ID',
	`ip` VARCHAR(50) NOT NULL COMMENT '客户机IP地址',
	`pc_name` VARCHAR(50) NOT NULL COMMENT '客户机主机名',
	`os_type` INT(11) NOT NULL COMMENT '客户机操作系统类型',
	`os_version` VARCHAR(50) NOT NULL COMMENT '客户机操作系统版本',
	`creator` VARCHAR(50) NOT NULL COMMENT '创建者',
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
	PRIMARY KEY (`id`)
)
COMMENT='网吧客户机基本信息'
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

CREATE TABLE `t_stat_net_bar` (
	`bar_id` VARCHAR(10) NOT NULL COMMENT '网吧注册号',
	`stat_date` DATE NOT NULL COMMENT ' 统计日期',
	`online` INT(11) NOT NULL COMMENT '最大在线终端数',
	`offline` INT(11) NOT NULL COMMENT '最小离线终端数',
	`valid` INT(11) NOT NULL COMMENT '最大有效终端数',
	`login` INT(11) NOT NULL COMMENT '最大登录用户数',
	`area_code` VARCHAR(6) NOT NULL COMMENT '县代码',
	`city_code` VARCHAR(6) NOT NULL COMMENT '市代码',
	PRIMARY KEY (`bar_id`, `stat_date`)
)
COMMENT='网吧日统计信息'
COLLATE='utf8_general_ci'
ENGINE=InnoDB

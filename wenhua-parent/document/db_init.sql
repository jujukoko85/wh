/** 创建数据库 */
CREATE DATABASE `wenhua` /*!40100 COLLATE 'utf8_general_ci' */;
use wenhua;

/** 设置自增起始值与步长 auto_increment_offset <= auto_increment_increment */
SET global auto_increment_increment=1;
SET global auto_increment_offset=1;

/** 创建数据库表  */
drop table if exists HD_ACCOUNT;

/*==============================================================*/
/* Table: HD_ACCOUNT                                            */
/*==============================================================*/
create table HD_ACCOUNT
(
   ID                   bigint not null auto_increment comment 'ID',
   ACCOUNT_NAME         varchar(50) not null comment '账户名',
   PWD		            varchar(100) not null comment '密码',
   LAST_LOGIN_IP        varchar(15) comment '上一次登录IP',
   LAST_LOGIN_TIME      datetime comment '上一次登录时间',
   IS_DELETED           bit(1) not null default 0 comment '是否禁用',
   CREATED_TIME         datetime not null default now() comment '创建时间',
   LAST_MODIFIED_TIME   datetime not null default now() comment '最后修改时间',
   primary key (ID)
)
ENGINE = InnoDB
auto_increment = 10001; /** 起始ID */
alter table HD_ACCOUNT comment '账号';

CREATE database if NOT EXISTS `scx`;
USE `scx`;
DROP TABLE IF EXISTS `task`;

CREATE TABLE `task`(
  `id` VARCHAR (32) NOT NULL PRIMARY KEY COMMENT '主键',
  `code` INT (11) NOT NULL COMMENT '序号',
  `name` VARCHAR (100) NOT NULL COMMENT '任务名称',
  `time` BIGINT (20)  NOT NULL COMMENT '提醒时间',
  `is_finish` BIGINT (20)  NOT NULL COMMENT '是否完成 0：未完成  1：已完成',
  `last_ver` INT (11) NOT NULL COMMENT '版本号'
)ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4 COMMENT='任务表';

CREATE database if NOT EXISTS `scx`;
USE `scx`;
DROP TABLE IF EXISTS `task`;

CREATE TABLE `task` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `number` int(11) NOT NULL COMMENT '序号',
  `name` varchar(100) NOT NULL COMMENT '任务名称',
  `time` bigint(20) NOT NULL COMMENT '提醒时间',
  `is_finish` tinyint(20) NOT NULL COMMENT '是否完成 0：未完成  1：已完成',
  `last_ver` int(11) NOT NULL COMMENT '版本号',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='任务表';
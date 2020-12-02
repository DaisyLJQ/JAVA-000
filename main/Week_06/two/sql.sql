DROP TABLE
IF
	EXISTS `user_info`;
CREATE TABLE `user_info` (
	`id` INT ( 11 ) NOT NULL AUTO_INCREMENT,
	`email` VARCHAR ( 128 ) NOT NULL COMMENT '邮箱',
	`user_name` VARCHAR ( 50 ) DEFAULT NULL COMMENT '用户名',
	`pass_word` VARCHAR ( 200 ) DEFAULT NULL COMMENT '密码',
	`phone_num` VARCHAR ( 50 ) DEFAULT NULL COMMENT '手机号',
	`salt` VARCHAR ( 200 ) DEFAULT NULL COMMENT '用户的密码用的盐，密码修改后盐需要变更',
	`valid_status` INT ( 1 ) DEFAULT NULL COMMENT '数据可用状态 1:可用 0:删除状态',
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY ( `id` )
) ENGINE = INNODB AUTO_INCREMENT = 87 DEFAULT CHARSET = utf8;
DROP TABLE
IF
	EXISTS `address_info`;
CREATE TABLE `address_info` (
	`id` INT ( 11 ) NOT NULL AUTO_INCREMENT,
	`province` VARCHAR ( 128 ) NOT NULL COMMENT '省',
	`city` VARCHAR ( 50 ) DEFAULT NULL COMMENT '市',
	`detailed_address` VARCHAR ( 200 ) DEFAULT NULL COMMENT '详细地址',
	`name` VARCHAR ( 50 ) DEFAULT NULL COMMENT '收件人',
	`phone` VARCHAR ( 200 ) DEFAULT NULL COMMENT '手机号码',
	`valid_status` INT ( 1 ) DEFAULT NULL COMMENT '数据可用状态 1:可用 0:删除状态',
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY ( `id` )
) ENGINE = INNODB AUTO_INCREMENT = 87 DEFAULT CHARSET = utf8;
DROP TABLE
IF
	EXISTS `goods_info`;
CREATE TABLE `goods_info` (
	`id` INT ( 11 ) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR ( 128 ) NOT NULL COMMENT '商品名称',
	`price` DOUBLE NOT NULL COMMENT '价格',
	`url` VARCHAR ( 200 ) DEFAULT NULL COMMENT '图片连接',
	`valid_status` INT ( 1 ) DEFAULT NULL COMMENT '数据可用状态 1:可用 0:删除状态',
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY ( `id` )
) ENGINE = INNODB AUTO_INCREMENT = 87 DEFAULT CHARSET = utf8;
DROP TABLE
IF
	EXISTS `order_goods_mapping`;
CREATE TABLE `order_goods_mapping` (
	`id` INT ( 11 ) NOT NULL AUTO_INCREMENT,
	`goods_id` INT ( 128 ) NOT NULL COMMENT '商品id',
	`num` INT ( 12 ) NOT NULL COMMENT '数量',
	`order_id` INT ( 12 ) DEFAULT NULL COMMENT '订单id',
	`status` TINYINT ( 2 ) DEFAULT NULL COMMENT '订单状态',
	`valid_status` INT ( 1 ) DEFAULT NULL COMMENT '数据可用状态 1:可用 0:删除状态',
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY ( `id` )
) ENGINE = INNODB AUTO_INCREMENT = 87 DEFAULT CHARSET = utf8;
DROP TABLE
IF
	EXISTS `order_info`;
CREATE TABLE `order_info` (
	`id` INT ( 11 ) NOT NULL AUTO_INCREMENT,
	`price` DOUBLE NOT NULL COMMENT '价格',
	`address_id` INT ( 11 ) NOT NULL COMMENT '地址id',
	`valid_status` INT ( 1 ) DEFAULT NULL COMMENT '数据可用状态 1:可用 0:删除状态',
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY ( `id` )
) ENGINE = INNODB AUTO_INCREMENT = 87 DEFAULT CHARSET = utf8;
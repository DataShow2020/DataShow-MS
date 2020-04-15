/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : logistics_management

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2019-04-20 20:50:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for courier
-- ----------------------------
DROP TABLE IF EXISTS `courier`;
CREATE TABLE `courier` (
  `courier_id` varchar(50) NOT NULL,
  `courier_name` varchar(50) DEFAULT NULL,
  `status` tinyint(3) DEFAULT NULL,
  `courier_phone` char(11) DEFAULT NULL,
  `courier_address` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` tinyint(3) DEFAULT NULL,
  `work_distribution_id` varchar(50) DEFAULT NULL,
  `is_deleted` tinyint(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`courier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for distribution
-- ----------------------------
DROP TABLE IF EXISTS `distribution`;
CREATE TABLE `distribution` (
  `distribution_id` varchar(50) NOT NULL,
  `distribution_name` varchar(50) DEFAULT NULL,
  `distribution_number` varchar(50) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `created_unit` varchar(50) DEFAULT NULL,
  `is_deleted` tinyint(3) NOT NULL DEFAULT '0',
  `created_time`  timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_time`  timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `remark` varchar(255) DEFAULT NULL,
  `status` tinyint(3) NOT NULL DEFAULT '0',
  `user_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`distribution_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `employee_id` varchar(50) NOT NULL,
  `employee_name` varchar(20) DEFAULT NULL,
  `work_start_time` datetime DEFAULT NULL,
  `station_id` varchar(50) DEFAULT NULL,
  `distribution_id` varchar(50) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `is_delete` tinyint(3) DEFAULT '0',
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for order_message
-- ----------------------------
DROP TABLE IF EXISTS `order_message`;
CREATE TABLE `order_message` (
  `order_id` varchar(50) NOT NULL,
  `status` tinyint(2) NOT NULL DEFAULT '1' COMMENT '1：已下单:2：运输中:3：已签收:4：已评论',
  `price` decimal(10,0) DEFAULT NULL,
  `count` int(11) DEFAULT '1',
  `item_name` varchar(50) DEFAULT NULL,
  `kg` float(20,0) DEFAULT NULL,
  `sender` varchar(50) DEFAULT NULL,
  `send_phone` char(11) DEFAULT NULL,
  `send_city` varchar(255) DEFAULT NULL,
  `send_address` varchar(255) DEFAULT NULL,
  `receiver` varchar(50) DEFAULT NULL,
  `reveive_phone` char(11) DEFAULT NULL,
  `receive_city` varchar(255) DEFAULT NULL,
  `receive_address` varchar(255) DEFAULT NULL,
  `ship_time` datetime DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `is_deleted` tinyint(3) DEFAULT '0',
  `evaluation` tinyint(3) DEFAULT '5' COMMENT '1:一颗星……5：五颗星',
  `remark` varchar(255) DEFAULT NULL,
  `evaluation_time` datetime DEFAULT NULL,
  `order_station_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for order_staion_relation
-- ----------------------------
DROP TABLE IF EXISTS `order_staion_relation`;
CREATE TABLE `order_staion_relation` (
  `order_station_id` varchar(50) NOT NULL,
  `order_id` varchar(50) DEFAULT NULL,
  `arrive_time` datetime DEFAULT NULL,
  `station_name` varchar(255) DEFAULT NULL,
  `next_station_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`order_station_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for station
-- ----------------------------
DROP TABLE IF EXISTS `station`;
CREATE TABLE `station` (
  `station_id` varchar(50) NOT NULL,
  `station_name` varchar(50) not null,
  `station_number` varchar(50) not null,
  `user_id` int(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `created_unit` varchar(50) DEFAULT NULL,
  `end_time` varchar(50) DEFAULT NULL,
  `created_time` varchar(50) DEFAULT NULL,
  `status` tinyint(3) DEFAULT NULL,
  `is_deleted` tinyint(3) DEFAULT '0',
  PRIMARY KEY (`station_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `permission_id` varchar(50) NOT NULL COMMENT '资源id',
  `permission_name` varchar(50) NOT NULL COMMENT '资源名称',
  `permission_up_id` varchar(50) NOT NULL COMMENT '资源父节点id',
  `permission_level` int(11) unsigned NOT NULL COMMENT '层级',
  `permission_path` varchar(255) NOT NULL COMMENT '路径',
  `is_delete` tinyint(3) unsigned NOT NULL COMMENT '是否删除',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源表';

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` varchar(50) NOT NULL COMMENT '角色id',
  `role_name` varchar(50) NOT NULL COMMENT '角色名称',
  `is_delete` tinyint(3) unsigned NOT NULL COMMENT '是否删除',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Table structure for sys_role_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission_relation`;
CREATE TABLE `sys_role_permission_relation` (
  `role_permission_id` varchar(50) NOT NULL COMMENT '角色权限关系表id',
  `role_id` varchar(50) NOT NULL COMMENT '角色id',
  `permission_id` varchar(50) NOT NULL COMMENT '资源id',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_permission_id`),
  KEY `role_id` (`role_id`),
  KEY `permission_id` (`permission_id`),
  CONSTRAINT `sys_role_permission_relation_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`),
  CONSTRAINT `sys_role_permission_relation_ibfk_2` FOREIGN KEY (`permission_id`) REFERENCES `sys_permission` (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限关系表';

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` varchar(50) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `account` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_role_relation_id` varchar(50) NOT NULL COMMENT '用户角色关系ID.',
  `user_id` varchar(50) NOT NULL COMMENT '用户ID',
  `role_id` varchar(50) NOT NULL COMMENT '角色ID',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_role_relation_id`),
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `sys_user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`user_id`),
  CONSTRAINT `sys_user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户角色关系表';

-- ----------------------------
-- Table structure for vehicle
-- ----------------------------
DROP TABLE IF EXISTS `vehicle`;
CREATE TABLE `vehicle` (
  `vehicle_id` varchar(50) NOT NULL,
  `vehicle_type` varchar(10) DEFAULT NULL,
  `vehicle_name` varchar(50) DEFAULT NULL,
  `is_deleted` tinyint(3) DEFAULT '0',
  `status` tinyint(3) DEFAULT NULL,
  `station_id` varchar(50) DEFAULT NULL,
  `vehicle_number` varchar(20) DEFAULT NULL,
  `purchase_time` datetime DEFAULT NULL,
  PRIMARY KEY (`vehicle_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for vehicle_order---
-- ----------------------------
DROP TABLE IF EXISTS `vehicle_order`;
CREATE TABLE `vehicle_order` (
  `vehicle_id` varchar(50) DEFAULT NULL,
  `order_id` varchar(50) NOT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : shop_order

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2019-06-03 14:14:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `id` varchar(255) NOT NULL,
  `time` datetime NOT NULL,
  `userid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_order
-- ----------------------------

-- ----------------------------
-- Table structure for tb_shop_items
-- ----------------------------
DROP TABLE IF EXISTS `tb_shop_items`;
CREATE TABLE `tb_shop_items` (
  `id` varchar(255) NOT NULL,
  `orderid` varchar(255) NOT NULL,
  `goodid` varchar(255) DEFAULT NULL,
  `goodtitle` varchar(255) DEFAULT NULL,
  `gooddesc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_shop_items
-- ----------------------------

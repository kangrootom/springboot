/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.230.128_3306
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : 192.168.230.128:3306
 Source Schema         : springboot

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 19/11/2017 17:48:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for u_user
-- ----------------------------
DROP TABLE IF EXISTS `u_user`;
CREATE TABLE `u_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nick` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `address` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of u_user
-- ----------------------------
INSERT INTO `u_user` VALUES (1, 'yanglijun', '13800000001', 'beijing', 'branky@163.com');
INSERT INTO `u_user` VALUES (2, 'nick', '13900000000', '北京大兴亦庄', 'fastly@163.com');
INSERT INTO `u_user` VALUES (3, 'nick3', '13900000000', '北京大兴亦庄', 'jimmly@163.com');
INSERT INTO `u_user` VALUES (4, '小丸子111', '17000018701', '北京市海淀区', '11222aaa@qq.com');
INSERT INTO `u_user` VALUES (5, '张三丰2', '100000001', '北京市朝阳区', '2876434346@qq.com');
INSERT INTO `u_user` VALUES (6, 'nick3222', '13800000001', '北京市海淀区', 'hnds@163.com');
INSERT INTO `u_user` VALUES (7, 'nick3', '13900000000', '北京海淀中关村', 'quetyj@163.com');
INSERT INTO `u_user` VALUES (8, 'zhangsanfeng001', '1370000000', '13e124', '127490808@qq.com');
INSERT INTO `u_user` VALUES (9, 'zhangsanfeng001', '1370000000', '13e124', '127490808@qq.com');
INSERT INTO `u_user` VALUES (10, 'zhangsanfeng001', '1370000000', '13e124', '127490808@qq.com');
INSERT INTO `u_user` VALUES (11, 'zhangsanfeng001', '1370000000', '13e124', '127490808@qq.com');
INSERT INTO `u_user` VALUES (12, '111', '111', '111', '111');

SET FOREIGN_KEY_CHECKS = 1;

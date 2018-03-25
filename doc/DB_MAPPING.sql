/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : DB_MAPPING

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 25/03/2018 22:39:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for T_CRAD
-- ----------------------------
DROP TABLE IF EXISTS `T_CRAD`;
CREATE TABLE `T_CRAD`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL COMMENT '所持人的id',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '卡的名字',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of T_CRAD
-- ----------------------------
BEGIN;
INSERT INTO `T_CRAD` VALUES (1, 1, '小明的身份证'), (2, 2, '小红的身份证'), (3, 3, '小绿的身份证'), (4, NULL, 'qwq'), (5, NULL, 'qwq'), (6, NULL, 'qwq'), (7, NULL, 'qwq'), (8, NULL, 'qwq'), (9, NULL, 'qwq');
COMMIT;

-- ----------------------------
-- Table structure for T_DEPT
-- ----------------------------
DROP TABLE IF EXISTS `T_DEPT`;
CREATE TABLE `T_DEPT`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_dept_id` int(11) NULL DEFAULT NULL COMMENT '父部门id',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名字',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of T_DEPT
-- ----------------------------
BEGIN;
INSERT INTO `T_DEPT` VALUES (1, 0, '总部'), (2, 1, '小分部'), (3, 1, '小分布2'), (4, 2, '小小分部');
COMMIT;

-- ----------------------------
-- Table structure for T_DEPT_USER
-- ----------------------------
DROP TABLE IF EXISTS `T_DEPT_USER`;
CREATE TABLE `T_DEPT_USER`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `dept_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of T_DEPT_USER
-- ----------------------------
BEGIN;
INSERT INTO `T_DEPT_USER` VALUES (1, 1, 1), (2, 1, 2), (3, 1, 3), (4, 2, 4), (5, 3, 4), (6, 2, 3);
COMMIT;

-- ----------------------------
-- Table structure for T_USER
-- ----------------------------
DROP TABLE IF EXISTS `T_USER`;
CREATE TABLE `T_USER`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of T_USER
-- ----------------------------
BEGIN;
INSERT INTO `T_USER` VALUES (1, '小明'), (2, '小红'), (3, '小绿'), (4, 'zqw'), (5, 'zqw1'), (6, NULL), (7, NULL), (8, NULL), (9, 'zqwww'), (10, 'zqwww'), (11, 'zqwww'), (12, 'zqwww'), (14, 'zqwww'), (15, 'zqwww'), (16, 'zqwww');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

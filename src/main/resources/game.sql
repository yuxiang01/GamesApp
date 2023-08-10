/*
 Navicat Premium Data Transfer

 Source Server         : mysql57
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : localhost:3306
 Source Schema         : game

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 09/08/2023 19:15:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
create database game;
-- ----------------------------
-- Table structure for games
-- ----------------------------
DROP TABLE IF EXISTS `games`;
CREATE TABLE `games`  (
  `gameId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '游戏编号',
  `gameName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '游戏名称',
  `gameType` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '游戏类型',
  `gameCompany` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发行公司',
  `gameYear` int(11) NULL DEFAULT NULL COMMENT '发行年份',
  PRIMARY KEY (`gameId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of games
-- ----------------------------
INSERT INTO `games` VALUES (1, '魔兽争霸', '及时战略', '暴雪', 1995);
INSERT INTO `games` VALUES (2, '三国志', 'RPG', '光荣', 1995);
INSERT INTO `games` VALUES (3, '穿越火线', '射击竞技', 'Smile Gate', 2007);

SET FOREIGN_KEY_CHECKS = 1;

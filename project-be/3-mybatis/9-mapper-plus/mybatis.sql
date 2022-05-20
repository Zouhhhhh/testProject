/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : mybatis

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 19/05/2022 22:27:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_employee
-- ----------------------------
DROP TABLE IF EXISTS `t_employee`;
CREATE TABLE `t_employee`  (
  `id` int(0) NOT NULL,
  `real_name` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` int(0) NOT NULL COMMENT '1-男，0-女',
  `birthday` date NOT NULL,
  `mobile` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `POSITION` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_employee_task
-- ----------------------------
DROP TABLE IF EXISTS `t_employee_task`;
CREATE TABLE `t_employee_task`  (
  `id` int(0) NOT NULL,
  `emp_id` int(0) NOT NULL,
  `task_id` int(0) NOT NULL,
  `task_name` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_Reference_4`(`emp_id`) USING BTREE,
  INDEX `FK_Reference_8`(`task_id`) USING BTREE,
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`emp_id`) REFERENCES `t_employee` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`task_id`) REFERENCES `t_task` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_femal_health_form
-- ----------------------------
DROP TABLE IF EXISTS `t_femal_health_form`;
CREATE TABLE `t_femal_health_form`  (
  `id` int(0) NOT NULL,
  `emp_id` int(0) NOT NULL,
  `heart` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `liver` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `spleen` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `lung` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `kidney` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `uterus` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `note` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_Reference_5`(`emp_id`) USING BTREE,
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`emp_id`) REFERENCES `t_employee` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_male_health_form
-- ----------------------------
DROP TABLE IF EXISTS `t_male_health_form`;
CREATE TABLE `t_male_health_form`  (
  `id` int(0) NOT NULL,
  `emp_id` int(0) NOT NULL,
  `heart` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `liver` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `spleen` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `lung` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `kidney` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `prostate` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_Reference_6`(`emp_id`) USING BTREE,
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`emp_id`) REFERENCES `t_employee` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_task
-- ----------------------------
DROP TABLE IF EXISTS `t_task`;
CREATE TABLE `t_task`  (
  `id` int(0) NOT NULL,
  `title` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `context` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_work_card
-- ----------------------------
DROP TABLE IF EXISTS `t_work_card`;
CREATE TABLE `t_work_card`  (
  `id` int(0) NOT NULL,
  `emp_id` int(0) NOT NULL,
  `real_name` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `department` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `mobile` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `POSITION` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_Reference_7`(`emp_id`) USING BTREE,
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`emp_id`) REFERENCES `t_employee` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

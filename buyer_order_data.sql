/*
 Navicat Premium Data Transfer

 Source Server         : index-10.6.4.20-dev
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : 10.6.4.20:63306
 Source Schema         : promotion

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 18/08/2020 18:54:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for buyer_order_data
-- ----------------------------
DROP TABLE IF EXISTS `buyer_order_data`;
CREATE TABLE `buyer_order_data`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `order_no` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '订单编号',
  `buyer_id` varchar(256) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '买家id',
  `encrypted_order_no` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '加密订单编号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `creator` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `modifier` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `is_deleted` tinyint(4) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否逻辑删除 1 是 0 否',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 474 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '买家订单号数据表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

/*
 Navicat Premium Data Transfer

 Source Server         : mysql 8
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : xianyu

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 13/11/2022 18:11:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for chat
-- ----------------------------
DROP TABLE IF EXISTS `chat`;
CREATE TABLE `chat`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'id',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户id',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '聊天内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of chat
-- ----------------------------

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'id',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `goods_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品id',
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect` VALUES ('1591649712119398401', 1, '2022-11-13 12:30:37', '2022-11-13 12:30:37', '2', '1590605625752715265');
INSERT INTO `collect` VALUES ('1591654421177708546', 1, '2022-11-13 12:49:20', '2022-11-13 12:49:20', '2', '1590605625752715265');
INSERT INTO `collect` VALUES ('1591660188303790082', 1, '2022-11-13 13:12:15', '2022-11-13 13:12:15', '1', '1590605625752715265');
INSERT INTO `collect` VALUES ('1591673889379463170', 0, '2022-11-13 14:06:42', '2022-11-13 14:06:42', '1591672437617610754', '1590605625752715265');
INSERT INTO `collect` VALUES ('1591674813246222337', 1, '2022-11-13 14:10:22', '2022-11-13 14:10:22', '1591674606932602882', '1590605625752715265');
INSERT INTO `collect` VALUES ('1591710095429541889', 1, '2022-11-13 16:30:34', '2022-11-13 16:30:34', '1591705093008982017', '1590605625752715265');

-- ----------------------------
-- Table structure for collect_dynamic
-- ----------------------------
DROP TABLE IF EXISTS `collect_dynamic`;
CREATE TABLE `collect_dynamic`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'id',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `dynamic_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '帖子id',
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of collect_dynamic
-- ----------------------------
INSERT INTO `collect_dynamic` VALUES ('1591710487164911617', 1, '2022-11-13 16:32:07', '2022-11-13 16:32:07', '1591705093008982017', '1590605625752715265');
INSERT INTO `collect_dynamic` VALUES ('1591710504286060545', 1, '2022-11-13 16:32:11', '2022-11-13 16:32:11', '1591705093008982017', '1590605625752715265');
INSERT INTO `collect_dynamic` VALUES ('1591713667315601409', 0, '2022-11-13 16:44:46', '2022-11-13 16:44:46', '1591705093008982017', '1590605625752715265');
INSERT INTO `collect_dynamic` VALUES ('1591718984912863233', 0, '2022-11-13 17:05:53', '2022-11-13 17:05:53', '1591713779735531522', '1590605625752715265');
INSERT INTO `collect_dynamic` VALUES ('1591718988415107073', 0, '2022-11-13 17:05:54', '2022-11-13 17:05:54', '1591714176453775362', '1590605625752715265');
INSERT INTO `collect_dynamic` VALUES ('1591718991703441410', 0, '2022-11-13 17:05:55', '2022-11-13 17:05:55', '1591714025228144642', '1590605625752715265');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'id',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `other_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '业务id',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '评论类型(商品，帖子)',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '评论内容',
  `pid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '父id',
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1591651117886521346', 0, '2022-11-13 12:36:13', '2022-11-13 12:36:13', '2', 'GOODS', '测试', NULL, '1590605625752715265');
INSERT INTO `comment` VALUES ('1591652473665937409', 0, '2022-11-13 12:41:36', '2022-11-13 12:41:36', '2', 'GOODS', '再次测试', NULL, '1590605625752715265');
INSERT INTO `comment` VALUES ('1591652530175795202', 0, '2022-11-13 12:41:49', '2022-11-13 12:41:49', '2', 'GOODS', 'zaicici测试', NULL, '1590605625752715265');
INSERT INTO `comment` VALUES ('1591654080814133250', 0, '2022-11-13 12:47:59', '2022-11-13 12:47:59', '2', 'GOODS', '一致测试', NULL, '1590605625752715265');
INSERT INTO `comment` VALUES ('1591654401644834817', 0, '2022-11-13 12:49:16', '2022-11-13 12:49:16', '2', 'GOODS', '一致测试', NULL, '1590605625752715265');
INSERT INTO `comment` VALUES ('1591660141084315650', 0, '2022-11-13 13:12:04', '2022-11-13 13:12:04', '1', 'GOODS', '测试', NULL, '1590605625752715265');
INSERT INTO `comment` VALUES ('1591696882570825729', 0, '2022-11-13 15:38:04', '2022-11-13 15:38:04', '1591672437617610754', 'GOODS', '测试一下啊', NULL, '1590605625752715265');

-- ----------------------------
-- Table structure for dynamic
-- ----------------------------
DROP TABLE IF EXISTS `dynamic`;
CREATE TABLE `dynamic`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'id',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '帖子内容',
  `images` json NULL COMMENT '图片数组',
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of dynamic
-- ----------------------------
INSERT INTO `dynamic` VALUES ('1591705093008982017', 0, '2022-11-13 16:10:41', '2022-11-13 16:10:41', '测试测试', '[\"/images/1668327040077.png\"]', '1590605625752715265');
INSERT INTO `dynamic` VALUES ('1591713779735531522', 0, '2022-11-13 16:45:12', '2022-11-13 16:45:12', 'khkjhkj', '[\"/images/1668329111436.png\"]', '1590605625752715265');
INSERT INTO `dynamic` VALUES ('1591714025228144642', 0, '2022-11-13 16:46:11', '2022-11-13 16:46:11', 'yjghjghj', '[\"/images/1668329170244.png\"]', '1590605625752715265');
INSERT INTO `dynamic` VALUES ('1591714176453775362', 0, '2022-11-13 16:46:47', '2022-11-13 16:46:47', 'kjhkj', '[\"/images/1668329206295.png\"]', '1590605625752715265');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'id',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品名称',
  `images` json NULL COMMENT '商品图片',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品描述',
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户id',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1591672437617610754', 0, '2022-11-13 14:00:56', '2022-11-13 14:00:56', '苹果手机', '[\"/images/1668319251495.png\"]', 'sadsa', '1590605625752715265', 12.00, 'NORMAL');
INSERT INTO `goods` VALUES ('1591674606932602882', 0, '2022-11-13 14:09:33', '2022-11-13 14:09:33', 'shouji', '[\"/images/1668319769121.png\"]', '', '1590605625752715265', 12.00, 'NORMAL');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'id',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `goods_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品id',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '状态',
  `amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '成交交易金额',
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '购买人',
  `goods_user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '卖出人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', 0, '2022-12-10 13:23:11', '2022-11-12 13:34:38', '1', 'FINISHED', 20.00, '1590605625752715265', '1590605625752715265');

-- ----------------------------
-- Table structure for praise
-- ----------------------------
DROP TABLE IF EXISTS `praise`;
CREATE TABLE `praise`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'id',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户id',
  `other_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '业务id',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '点赞类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of praise
-- ----------------------------

-- ----------------------------
-- Table structure for publish_price
-- ----------------------------
DROP TABLE IF EXISTS `publish_price`;
CREATE TABLE `publish_price`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'id',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `goods_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品id',
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户id',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '出价',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of publish_price
-- ----------------------------
INSERT INTO `publish_price` VALUES ('1591655371472777217', 0, '2022-11-13 12:53:07', '2022-11-13 12:53:07', '1', '1590605625752715265', 12.00);
INSERT INTO `publish_price` VALUES ('1591659967926665218', 0, '2022-11-13 13:11:23', '2022-11-13 13:11:23', '1', '1590605625752715265', 80.00);
INSERT INTO `publish_price` VALUES ('1591660168015941634', 0, '2022-11-13 13:12:10', '2022-11-13 13:12:10', '1', '1590605625752715265', 900.00);
INSERT INTO `publish_price` VALUES ('1591696923121356801', 0, '2022-11-13 15:38:13', '2022-11-13 15:38:13', '1591672437617610754', '1590605625752715265', 18921.00);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'id',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  `sex` tinyint(1) NULL DEFAULT NULL COMMENT '性别gere -1 保密 0男',
  `mark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '个人简介',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1590605625752715265', 0, '2022-11-10 15:21:48', '2022-11-10 15:21:48', '/images/1668325065222.png', 'AS', '17835904250', '123456', 0, '丰大厦的');

-- ----------------------------
-- Table structure for want
-- ----------------------------
DROP TABLE IF EXISTS `want`;
CREATE TABLE `want`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'id',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `goods_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '想要的商品id',
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of want
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;

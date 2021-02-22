/*
 Source Server         : wfy
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : localhost:3306
 Source Schema         : managedata

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 22/02/2021 21:41:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- 顾客表
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `cName` varchar(20)NOT NULL COMMENT '顾客名',
  `cPassword` varchar(20) NOT NULL COMMENT '顾客密码',
  `age` int(5) NOT NULL COMMENT '顾客年龄',
  `address` varchar(100) NOT NULL COMMENT '顾客地址',
  `tel` varchar(50) NOT NULL COMMENT '顾客电话',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (1, '张三', '123456', 22, '郑州', '15738958256');
INSERT INTO `customer` VALUES (2, '李四', '234432', 24, '北京', '15738958256');
INSERT INTO `customer` VALUES (3, '王二', '343422', 21, '上海', '15738958256');
INSERT INTO `customer` VALUES (22, 'fdgd', '343232', 33, '郑州', '15738958256');
INSERT INTO `customer` VALUES (23, 'fdgd', '343232', 33, '郑州', '15738958256');
INSERT INTO `customer` VALUES (24, 'fdgd', '343232', 33, '郑州', '15738958256');
INSERT INTO `customer` VALUES (25, 'fdgd', '343232', 33, '郑州', '15738958256');
INSERT INTO `customer` VALUES (26, 'fdgd', '343232', 33, '郑州', '15738958256');
INSERT INTO `customer` VALUES (27, 'fdgd', '343232', 33, '郑州', '15738958256');
INSERT INTO `customer` VALUES (36, 'fdgd', '343232', 33, '郑州', '15738958256');
INSERT INTO `customer` VALUES (37, 'fdgd', '343232', 33, '郑州', '15738958256');
INSERT INTO `customer` VALUES (38, 'fdgd', '343232', 33, '郑州', '15738958256');
INSERT INTO `customer` VALUES (39, '65547', '3453453', 43, '北京', '15738958256');
INSERT INTO `customer` VALUES (40, '王飞耀', '1234567', 23, '驻马店', '15238508017');

-- ----------------------------
-- 登录日志表
-- ----------------------------
DROP TABLE IF EXISTS `login_log`;
CREATE TABLE `login_log`  (
  `logId` int(10) NOT NULL AUTO_INCREMENT COMMENT '日志id',
  `username` varchar(30) NOT NULL COMMENT '用户名',
  `roleId` int(5) NOT NULL COMMENT '角色编码',
  `roleName` varchar(20) NOT NULL COMMENT '角色名',
  `deviceInfo` varchar(200) NOT NULL COMMENT '登录设备信息',
  `ip` varchar(20) NOT NULL COMMENT '登录ip',
  `loginDate` varchar(30) NOT NULL COMMENT '登录日期',
  `loginTime` varchar(30) NOT NULL COMMENT '登录时间',
  PRIMARY KEY (`logId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of login_log
-- ----------------------------
INSERT INTO `login_log` VALUES (3, 'bbb', 102, '顾客管理员', 'Windows NT 10.0; WOW64', '127.0.0.1', '2021-02-06', '22:17:53');
INSERT INTO `login_log` VALUES (4, '123', 101, '主管理员', 'Windows NT 10.0; WOW64', '127.0.0.1', '2021-02-06', '22:19:34');
INSERT INTO `login_log` VALUES (5, '123', 101, '主管理员', 'Windows NT 10.0; WOW64', '127.0.0.1', '2021-02-06', '22:20:10');
INSERT INTO `login_log` VALUES (6, '123', 101, '主管理员', 'Windows NT 10.0; WOW64', '127.0.0.1', '2021-02-07', '21:46:55');
INSERT INTO `login_log` VALUES (7, 'ccc', 103, '商品管理员', 'Windows NT 10.0; WOW64', '127.0.0.1', '2021-02-08', '15:05:52');
INSERT INTO `login_log` VALUES (8, 'bbb', 102, '顾客管理员', 'Windows NT 10.0; WOW64', '127.0.0.1', '2021-02-08', '15:12:06');
INSERT INTO `login_log` VALUES (9, '123', 101, '主管理员', 'Windows NT 10.0; WOW64', '127.0.0.1', '2021-02-08', '15:12:23');
INSERT INTO `login_log` VALUES (10, 'bbb', 102, '顾客管理员', 'Windows NT 10.0; WOW64', '127.0.0.1', '2021-02-08', '15:15:33');
INSERT INTO `login_log` VALUES (11, 'ccc', 103, '商品管理员', 'Windows NT 10.0; WOW64', '127.0.0.1', '2021-02-08', '15:16:07');
INSERT INTO `login_log` VALUES (12, 'aaa', 101, '主管理员', 'Windows NT 10.0; WOW64', '127.0.0.1', '2021-02-08', '15:16:23');
INSERT INTO `login_log` VALUES (13, '123', 101, '主管理员', 'Windows NT 10.0; WOW64', '127.0.0.1', '2021-02-08', '15:16:35');
INSERT INTO `login_log` VALUES (14, '123', 101, '主管理员', 'Windows NT 10.0; WOW64', '127.0.0.1', '2021-02-08', '15:34:28');
INSERT INTO `login_log` VALUES (15, '123', 101, '主管理员', 'Windows NT 10.0; WOW64', '127.0.0.1', '2021-02-09', '17:07:18');
INSERT INTO `login_log` VALUES (16, 'wfy', 101, '主管理员', 'Windows NT 10.0; WOW64', '127.0.0.1', '2021-02-09', '17:08:45');
INSERT INTO `login_log` VALUES (17, 'bbb', 102, '顾客管理员', 'Windows NT 10.0; WOW64', '127.0.0.1', '2021-02-09', '17:09:36');
INSERT INTO `login_log` VALUES (18, '123', 101, '主管理员', 'Windows NT 10.0; WOW64', '127.0.0.1', '2021-02-09', '17:12:33');
INSERT INTO `login_log` VALUES (19, 'bbb', 102, '顾客管理员', 'Windows NT 10.0; WOW64', '127.0.0.1', '2021-02-09', '17:12:56');
INSERT INTO `login_log` VALUES (20, 'ccc', 103, '商品管理员', 'Windows NT 10.0; WOW64', '127.0.0.1', '2021-02-09', '17:13:11');
INSERT INTO `login_log` VALUES (21, 'wfy', 101, '主管理员', 'Windows NT 10.0; WOW64', '127.0.0.1', '2021-02-09', '17:13:43');
INSERT INTO `login_log` VALUES (22, '123', 101, '主管理员', 'Windows NT 10.0; WOW64', '127.0.0.1', '2021-02-09', '21:34:29');
INSERT INTO `login_log` VALUES (23, '123', 101, '主管理员', 'Windows NT 10.0; WOW64', '127.0.0.1', '2021-02-09', '21:48:32');
INSERT INTO `login_log` VALUES (24, '123', 101, '主管理员', 'Windows NT 10.0; WOW64', '127.0.0.1', '2021-02-09', '21:58:40');
INSERT INTO `login_log` VALUES (25, '123', 101, '主管理员', 'Windows NT 10.0; WOW64', '127.0.0.1', '2021-02-09', '22:00:42');
INSERT INTO `login_log` VALUES (26, '123', 101, '主管理员', 'Windows NT 10.0; WOW64', '127.0.0.1', '2021-02-09', '22:07:40');
INSERT INTO `login_log` VALUES (27, '123', 101, '主管理员', 'Windows NT 10.0; WOW64', '127.0.0.1', '2021-02-09', '22:13:17');

-- ----------------------------
-- 订单表
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info`  (
  `orderId` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `orderNumber` varchar(50) NOT NULL COMMENT '订单编号',
  `cName` varchar(30) NOT NULL COMMENT '买家姓名',
  `cAddress` varchar(255) NOT NULL COMMENT '买家地址',
  `cTel` varchar(30) NOT NULL COMMENT '买家电话',
  `productName` varchar(50) NOT NULL COMMENT '商品名',
  `price` varchar(30) NOT NULL COMMENT '价格',
  `orderState` int(2) NOT NULL COMMENT '订单状态：1进行中，0完成',
  `createTime` varchar(30) NOT NULL COMMENT '订单创建时间',
  `endTime` varchar(30) NULL DEFAULT NULL COMMENT '订单完成时间',
  PRIMARY KEY (`orderId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES (1, '676664', '张三', '河南省郑州市惠济区', '15738958256', '内存条', '300', 0, '2021/02/13 15:57:36', '2021/02/14 21:39:56');
INSERT INTO `order_info` VALUES (2, '676656', '李四', '河南省郑州市中原区', '15738958256', '显示器', '300', 1, '2021/02/15 16:20:03', NULL);
INSERT INTO `order_info` VALUES (3, '667664', '王二', '河南省郑州市二七区', '15738958256', '显卡', '3000', 1, '2021/02/15 15:35:10', NULL);
INSERT INTO `order_info` VALUES (4, '676655', '张三', '河南省郑州市二七区', '15738958256', '内存条', '300', 0, '2021/02/13 15:57:36', '2021/02/14 22:01:40');
INSERT INTO `order_info` VALUES (29, '676234', '张三', '河南省郑州市高新区', '15738958256', '硬盘', '1000', 1, '2021/02/15 15:38:44', NULL);
INSERT INTO `order_info` VALUES (30, '674654', '张三', '河南省郑州市二七区', '15738958256', '内存条', '200', 1, '2021/02/15 15:32:11', NULL);
INSERT INTO `order_info` VALUES (33, '574532', '王二', '河南省郑州市金水区', '15738958256', '内存条', '300', 0, '2021/02/13 15:57:36', '2021/02/14 22:18:55');
INSERT INTO `order_info` VALUES (34, '235646', '王二', '河南省驻马店市驿城区', '15738958256', '路由器', '230', 1, '2021/02/15 15:40:45', NULL);
INSERT INTO `order_info` VALUES (35, '547547', '张三', '河南省郑州市二七区', '15738958256', '内存条', '300', 0, '2021-02-13 15:57:36', '2021/02/14 22:18:49');
INSERT INTO `order_info` VALUES (36, '547568', '李四', '河南省郑州市金水区', '15738958256', '内存条', '300', 0, '2021-02-13 15:57:36', '2021/02/14 22:03:05');
INSERT INTO `order_info` VALUES (37, '907767', '李四', '河南省郑州市二七区', '15738958256', '内存条', '300', 1, '2021/02/13 15:57:36', NULL);
INSERT INTO `order_info` VALUES (38, '567367', '张三', '河南省郑州市中原区', '15738958256', '内存条', '300', 1, '2021/02/13 15:57:36', NULL);
INSERT INTO `order_info` VALUES (39, '955643', '张三', '河南省商丘市梁园区', '15738958256', '内存条', '300', 0, '2021/02/19 19:12:41', '2021/02/19 19:13:20');
INSERT INTO `order_info` VALUES (40, '356543', '张三', '河南省郑州市二七区', '15738958256', '内存条', '300', 0, '2021-02-13 15:57:36', '2021/02/15 16:02:28');
INSERT INTO `order_info` VALUES (41, '847633', '张三', '河南省郑州市管城回族区', '15738958256', '内存条', '300', 0, '2021-02-13 15:57:36', '2021/02/14 22:02:40');
INSERT INTO `order_info` VALUES (42, '753566', '张三', '河南省郑州市二七区', '15738958256', '内存条', '300', 0, '2021-02-13 15:57:36', '2021/02/15 15:41:28');
INSERT INTO `order_info` VALUES (44, '234325', '李四', '河南省郑州市二七区', '15738958256', '内存条', '300', 0, '2021-02-13 15:57:36', '2021/02/14 22:02:49');
INSERT INTO `order_info` VALUES (45, '674536', '李四', '河南省驻马店市驿城区', '15738767989', '硬盘', '800', 0, '2021/02/13 15:57:36', '2021/02/19 21:34:12');
INSERT INTO `order_info` VALUES (46, '674345', '李四', '河南省郑州市二七区', '15738958256', '内存条', '300', 1, '2021/02/13 15:57:36', NULL);
INSERT INTO `order_info` VALUES (47, '875465', '张三', '河南省郑州市中原区', '15738958256', '内存条', '300', 1, '2021/02/13 15:57:36', NULL);
INSERT INTO `order_info` VALUES (48, '243243', '张三', '河南省郑州市二七区', '15738958256', '内存条', '300', 1, '2021/02/13 15:57:36', NULL);
INSERT INTO `order_info` VALUES (49, '523432', '张三', '河南省郑州市金水区', '15738958256', '内存条', '300', 0, '2021-02-13 15:57:36', '2021/02/16 23:32:09');
INSERT INTO `order_info` VALUES (50, '464564', '李四', '河南省郑州市中原区', '15738958256', '内存条', '300', 1, '2021-02/13 15:57:36', NULL);
INSERT INTO `order_info` VALUES (51, '435355', '张三', '河南省郑州市高新区', '15738958256', '内存条', '300', 1, '2021/02/13 15:57:36', NULL);
INSERT INTO `order_info` VALUES (52, '344555', '张三', '河南省郑州市二七区', '15738958256', '内存条', '300', 1, '2021/02/13 15:57:36', NULL);

-- ----------------------------
-- 商品表
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` int(5) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `commodity` varchar(20) NOT NULL COMMENT '产品名',
  `brand` varchar(20) NOT NULL COMMENT '品牌',
  `price` int(10) NOT NULL COMMENT '价格',
  `amount` int(10) NOT NULL COMMENT '库存',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, '内存条', '三星', 300, 30);
INSERT INTO `product` VALUES (2, '显卡', '英伟达', 5000, 44);
INSERT INTO `product` VALUES (3, 'CPU', '因特尔', 4000, 55);
INSERT INTO `product` VALUES (4, '显示器', 'LG', 2400, 34);
INSERT INTO `product` VALUES (5, '路由器', '普联', 1200, 59);
INSERT INTO `product` VALUES (6, '硬盘', '三星', 1000, 44);
INSERT INTO `product` VALUES (7, '显卡', ' AMD', 5000, 20);
INSERT INTO `product` VALUES (8, '内存条', '金士顿', 430, 32);
INSERT INTO `product` VALUES (9, '主板', '华硕', 2766, 78);
INSERT INTO `product` VALUES (10, '显示器', '冠捷', 1599, 29);
INSERT INTO `product` VALUES (12, '显示器', 'LG', 2400, 34);
INSERT INTO `product` VALUES (13, '路由器', '普联', 1200, 59);
INSERT INTO `product` VALUES (14, '硬盘', '三星', 1000, 44);
INSERT INTO `product` VALUES (15, '显卡', ' AMD', 5000, 20);
INSERT INTO `product` VALUES (16, '内存条', '金士顿', 430, 32);
INSERT INTO `product` VALUES (17, '主板', '华硕', 2766, 78);
INSERT INTO `product` VALUES (18, '显示器', '冠捷', 1599, 29);
INSERT INTO `product` VALUES (19, '显示器', 'LG', 2400, 34);
INSERT INTO `product` VALUES (20, '路由器', '普联', 1200, 59);

-- ----------------------------
-- 角色字典表
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`  (
  `id` int(5) NOT NULL COMMENT '角色编码',
  `roleName` varchar(20) NOT NULL COMMENT '角色名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES (101, '主管理员');
INSERT INTO `roles` VALUES (102, '用户管理员');
INSERT INTO `roles` VALUES (103, '商品管理员');

-- ----------------------------
-- 用户表
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `roleId` int(5) NOT NULL COMMENT '角色编码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'aaa', '111111', 101);
INSERT INTO `user` VALUES (2, 'bbb', '222222', 102);
INSERT INTO `user` VALUES (3, 'ccc', '333333', 103);
INSERT INTO `user` VALUES (4, '123', '123', 101);
INSERT INTO `user` VALUES (5, 'curry', '303030', 101);
INSERT INTO `user` VALUES (6, 'james', '232323', 103);
INSERT INTO `user` VALUES (7, 'tompson', '111111', 102);
INSERT INTO `user` VALUES (8, 'igoudala', '999999', 101);
INSERT INTO `user` VALUES (18, 'bob', '303030', 101);
INSERT INTO `user` VALUES (19, 'joken', '232323', 103);
INSERT INTO `user` VALUES (20, 'feng', '111111', 102);
INSERT INTO `user` VALUES (21, 'bob', '303030', 101);
INSERT INTO `user` VALUES (29, 'igoudala', '3r5325', 103);
INSERT INTO `user` VALUES (31, 'wfy', '111111', 101);
INSERT INTO `user` VALUES (32, 'wfy02', '123456', 102);
INSERT INTO `user` VALUES (33, '张欣蓓大美女', 'zxbmv', 101);

SET FOREIGN_KEY_CHECKS = 1;

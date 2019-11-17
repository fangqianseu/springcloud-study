-- ----------------------------
-- Table structure for dept
-- ----------------------------
create database db01;
use db01;

DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `dept_no` bigint(20) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(60) DEFAULT NULL,
  `db_source` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`dept_no`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', '开发部', 'db01');
INSERT INTO `dept` VALUES ('2', 'womende', 'db01');
INSERT INTO `dept` VALUES ('4', '销售部', 'db01');
INSERT INTO `dept` VALUES ('5', '网络部', 'db01');

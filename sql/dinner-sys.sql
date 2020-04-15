/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.20-log : Database - dinner_sys
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`dinner_sys` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `dinner_sys`;

/*Table structure for table `admin_user` */

CREATE TABLE `admin_user` (
  `id` bigint(100) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `password` varchar(200) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='后台管理员用户';

/*Data for the table `admin_user` */

insert  into `admin_user`(`id`,`username`,`password`,`create_time`) values (1,'root','EJVpHadNlN/pTxcykASm+Q==','2020-04-08 12:33:30');

/*Table structure for table `goods` */

CREATE TABLE `goods` (
  `id` bigint(100) NOT NULL AUTO_INCREMENT,
  `goods_title` varchar(100) NOT NULL COMMENT 'goods''s title',
  `goods_head_img` varchar(200) NOT NULL COMMENT 'goods''s head img',
  `goods_price` decimal(10,0) NOT NULL,
  `goods_market_price` decimal(10,0) NOT NULL COMMENT 'market price',
  `goods_content` text NOT NULL,
  `goods_type_id` bigint(100) NOT NULL COMMENT 'goods''s type id',
  `goods_shop_id` bigint(200) NOT NULL COMMENT '菜品对应店铺id',
  `goods_sell_sum` int(11) DEFAULT '0' COMMENT 'sell sum ',
  `is_deleted` tinyint(1) DEFAULT '0' COMMENT '0 no deleted;1 is deleted.',
  `is_on_sale` tinyint(1) DEFAULT '0' COMMENT '0 not on sale;1 is on sale;',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `NewIndex1` (`goods_title`,`goods_type_id`,`goods_shop_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='菜品表';

/*Data for the table `goods` */

insert  into `goods`(`id`,`goods_title`,`goods_head_img`,`goods_price`,`goods_market_price`,`goods_content`,`goods_type_id`,`goods_shop_id`,`goods_sell_sum`,`is_deleted`,`is_on_sale`,`update_time`,`create_time`) values (3,'空腔护理','https://shop-im.oss-cn-beijing.aliyuncs.com/order-shop/2020/02/10/a8ce6b5706804645b83b1afe2922c323.jpg','56','126','<p>牛肉面</p><p><img src=\"http://localhost:8080/order-shop-admin/layui/images/face/0.gif\" alt=\"[微笑]\"><br></p><p><img src=\"E:/usr/local/order-shop/upload/goods_content_img/2020/02/10/a9912fdf46ff4b29b1b953331d0f0806.png\" alt=\"图片\"><br></p>',1,1,12,0,1,'2020-04-05 13:58:38','2020-04-05 13:58:38'),(4,'记号笔费价格','打广告豆腐干豆腐','78','78','电饭煲丰富的发多少发',1,1,0,0,0,'2020-04-06 15:42:38','2020-04-06 15:42:38'),(5,'测试','为欧珀退热贴与【','1','1','GV',1000,1000,1,1,1,'2020-04-06 18:10:18','2020-04-06 16:22:56');

/*Table structure for table `goods_order` */

CREATE TABLE `goods_order` (
  `id` bigint(100) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(100) NOT NULL COMMENT '用户id',
  `table_num` varchar(32) DEFAULT NULL COMMENT '餐桌号',
  `order_num` varchar(100) NOT NULL COMMENT '订单编号',
  `order_price` decimal(10,0) DEFAULT NULL COMMENT '订单总价格',
  `is_deleted` tinyint(1) DEFAULT '0' COMMENT '0 is not deleted;1 is deleted;',
  `is_payed` tinyint(1) DEFAULT '0' COMMENT '支付状态：0 is not pay;1 is payed;',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `pay_time` timestamp NULL DEFAULT NULL COMMENT '支付时间',
  `pay_type` tinyint(1) DEFAULT '1' COMMENT '支付方式：1微信支付，2支付宝',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='用户订单';

/*Data for the table `goods_order` */

insert  into `goods_order`(`id`,`user_id`,`table_num`,`order_num`,`order_price`,`is_deleted`,`is_payed`,`create_time`,`pay_time`,`pay_type`) values (12,1,'20','451254354345376656','124',0,0,'2020-04-05 15:24:02','2020-04-05 15:24:02',1),(13,4,'45','854555555744465457','45',0,0,'2020-04-05 16:35:32','2020-04-05 15:24:02',1),(14,45,'457','3e3442343424245676','321',0,0,'2020-04-07 22:18:24',NULL,1);

/*Table structure for table `goods_type` */

CREATE TABLE `goods_type` (
  `id` bigint(100) NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(200) NOT NULL,
  `title` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='菜品分类';

/*Data for the table `goods_type` */

/*Table structure for table `message` */

CREATE TABLE `message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(200) NOT NULL,
  `title` varbinary(100) NOT NULL,
  `content` text NOT NULL,
  `is_deleted` tinyint(1) DEFAULT '0',
  `is_readed` tinyint(1) DEFAULT '0' COMMENT '0 未读，1已读',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `message` */

insert  into `message`(`id`,`shop_id`,`title`,`content`,`is_deleted`,`is_readed`,`create_time`) values (1,1,'测试','测试',NULL,0,'2020-04-07 11:01:39');

/*Table structure for table `order_detail` */

CREATE TABLE `order_detail` (
  `id` bigint(100) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(100) NOT NULL,
  `goods_id` bigint(100) NOT NULL,
  `goods_count` int(4) NOT NULL,
  `goods_sum_price` decimal(10,0) NOT NULL COMMENT '总价格  商品价格*商品数量',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_order_detail` (`order_id`),
  CONSTRAINT `FK_order_detail` FOREIGN KEY (`order_id`) REFERENCES `goods_order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='订单详情';

/*Data for the table `order_detail` */

/*Table structure for table `shop` */

CREATE TABLE `shop` (
  `id` bigint(200) NOT NULL AUTO_INCREMENT,
  `shop_name` varchar(32) NOT NULL,
  `head_img_url` varchar(300) DEFAULT NULL COMMENT '店铺头像',
  `shop_email` varchar(32) NOT NULL,
  `shop_tel` varchar(32) NOT NULL COMMENT '店铺电话',
  `shop_user_name` varchar(32) NOT NULL COMMENT '联系人姓名',
  `shop_user_code` varchar(32) NOT NULL COMMENT '联系人身份证',
  `shop_password` varchar(300) NOT NULL,
  `app_id` varchar(200) DEFAULT NULL COMMENT '公众号APPID',
  `app_secret` varchar(200) DEFAULT NULL COMMENT '公众号AppSecret',
  `mch_id` varchar(200) DEFAULT NULL COMMENT '商户号',
  `pay_key` varchar(200) DEFAULT NULL COMMENT '商户支付密码',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_login_ip` varchar(32) DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT '0',
  `is_confirm` tinyint(1) DEFAULT '0' COMMENT '0没有通过认证，1已通过认证 2已拒绝',
  `is_on` tinyint(1) DEFAULT '0' COMMENT '是否在缴费使用期是否正常使用；0不能使用，1能使用',
  `use_start_time` datetime DEFAULT NULL COMMENT '最后一次使用期限开始日期',
  `use_end_time` datetime DEFAULT NULL COMMENT '最后一次使用期限结束日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `shop` */

insert  into `shop`(`id`,`shop_name`,`head_img_url`,`shop_email`,`shop_tel`,`shop_user_name`,`shop_user_code`,`shop_password`,`app_id`,`app_secret`,`mch_id`,`pay_key`,`create_time`,`update_time`,`last_login_ip`,`is_deleted`,`is_confirm`,`is_on`,`use_start_time`,`use_end_time`) values (1,'四季美嘉','https://shop-im.oss-cn-beijing.aliyuncs.com/order-shop/2020/02/10/a8ce6b5706804645b83b1afe2922c323.jpg','987788122@qq.com','15025641254','黄娟娟','622424196512011245','EJVpHadNlN/pTxcykASm+Q==','7bbN6e39/+r1lz8V3I1FunstE/HnpapgNH32I19PH3k=','iZRfB29bDSHkJGs5J4S+lJd/fIH+vv78x4Xdmd1oCKfZonv2Og3ZFpLwve/abi+A','7HnCA9L9lGEk6K8GaYfsgh37JKgSt6EX','7PAYn8d9vePEFFqve3yzfL0pS4Bs2NSqP9yHM8f7VfER19Kb56HUR9mnMLKg/mEH','2020-04-07 17:19:24','2020-04-07 17:19:24','192.168.0.100',0,0,0,NULL,NULL),(2,'测试','测试','测试','测试','string','string','6WXQSiajMz1u55wI5JHJ0g==','uWvvFaEuiX2ofb0Yh7G6PQ==','j46XjBpC/mC82G+G9gA0Bw==','R9S9NzpouHFAc8DbWM6z2g==','FKuGg44zMlwq/1VCTN4y9w==','2020-04-09 11:56:18','2020-04-09 11:56:18','测试',0,0,0,'2020-04-05 11:17:12','2020-04-05 11:17:12');

/*Table structure for table `shop_coupon` */

CREATE TABLE `shop_coupon` (
  `id` bigint(200) NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(200) NOT NULL,
  `price` decimal(10,0) NOT NULL COMMENT '优惠券价格',
  `is_deleted` tinyint(1) DEFAULT '0',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `sum` int(4) NOT NULL COMMENT '优惠券个数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `shop_coupon` */

insert  into `shop_coupon`(`id`,`shop_id`,`price`,`is_deleted`,`create_time`,`update_time`,`sum`) values (1,1000,'1',1,'2020-04-07 10:19:15','2020-04-07 10:19:15',1);

/*Table structure for table `shop_detail` */

CREATE TABLE `shop_detail` (
  `id` bigint(200) NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(200) NOT NULL,
  `code_face` varchar(500) DEFAULT NULL COMMENT '身份证正面照片',
  `code_back` varchar(500) DEFAULT NULL COMMENT '身份证反面照片',
  `deal_img` varchar(500) DEFAULT NULL COMMENT '营业执照照片',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_shop_detail` (`shop_id`),
  CONSTRAINT `FK_shop_detail` FOREIGN KEY (`shop_id`) REFERENCES `shop` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `shop_detail` */

insert  into `shop_detail`(`id`,`shop_id`,`code_face`,`code_back`,`deal_img`,`create_time`,`update_time`) values (1,1,'https://shop-im.oss-cn-beijing.aliyuncs.com/order-shop/2020/02/10/a8ce6b5706804645b83b1afe2922c323.jpg','https://shop-im.oss-cn-beijing.aliyuncs.com/order-shop/2020/02/10/a8ce6b5706804645b83b1afe2922c323.jpg','https://shop-im.oss-cn-beijing.aliyuncs.com/order-shop/2020/02/10/a8ce6b5706804645b83b1afe2922c323.jpg','2020-04-08 21:18:34','2020-04-08 21:18:34');

/*Table structure for table `shop_meal` */

CREATE TABLE `shop_meal` (
  `id` bigint(200) NOT NULL AUTO_INCREMENT,
  `meal_title` varchar(100) NOT NULL COMMENT '套餐名称',
  `meal_desc` varchar(500) NOT NULL COMMENT '套餐描述',
  `meal_img` varchar(500) DEFAULT NULL COMMENT '套餐照片',
  `meal_price` decimal(10,0) NOT NULL COMMENT '套餐价格',
  `is_deleted` tinyint(1) DEFAULT '0',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='店铺使用套餐';

/*Data for the table `shop_meal` */

insert  into `shop_meal`(`id`,`meal_title`,`meal_desc`,`meal_img`,`meal_price`,`is_deleted`,`create_time`,`update_time`) values (1,'年套餐','一年的时间','测试','10000',0,'2020-04-09 10:03:40','2020-04-09 10:03:40');

/*Table structure for table `shop_use_log` */

CREATE TABLE `shop_use_log` (
  `id` bigint(200) NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(200) DEFAULT NULL,
  `shop_meal_id` bigint(200) NOT NULL COMMENT '使用套餐id',
  `is_using` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否使用中1是，0否',
  `use_start_time` datetime NOT NULL COMMENT '使用开始日期',
  `use_end_time` datetime NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `shop_use_log` */

insert  into `shop_use_log`(`id`,`shop_id`,`shop_meal_id`,`is_using`,`use_start_time`,`use_end_time`,`create_time`) values (1,1,1,1,'2021-04-05 11:17:12','2020-04-05 11:17:12','2020-04-09 10:06:38');

/*Table structure for table `user` */

CREATE TABLE `user` (
  `id` bigint(100) NOT NULL AUTO_INCREMENT,
  `nick_name` varchar(32) DEFAULT NULL COMMENT '昵称',
  `head_img_url` varchar(500) DEFAULT NULL COMMENT '头像',
  `open_id` varchar(100) NOT NULL,
  `access_token` varchar(500) NOT NULL,
  `profile` varchar(500) DEFAULT NULL COMMENT '用户信息系列化',
  `number` varchar(32) DEFAULT NULL COMMENT '电话号码',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='微信登录授权用户表';

/*Data for the table `user` */

insert  into `user`(`id`,`nick_name`,`head_img_url`,`open_id`,`access_token`,`profile`,`number`,`create_time`) values (1,'Jack','3454344','kjbgkdfgndlglf','jbkdbgkjb','kjjb','15624521125','2020-04-11 13:49:12');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

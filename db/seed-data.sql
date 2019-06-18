CREATE DATABASE  IF NOT EXISTS `plugga`;
USE `plugga`;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `date_created` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `last_login` timestamp NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

--
-- Data for table `user`
--

INSERT INTO `user` VALUES
	(1,'Leslie','leslie@plugga.com','{bcrypt}$2a$04$WG3OFFCMts4XFhveEzh5lu/UrlaYFt25TsK4Yw.sRoBrzPMk.swQ.', NULL, NULL),
	(2,'Knope','knope@plugga.com','{bcrypt}$2a$04$56l2q4SSgogthTelarpnve43lqOx5zGgBFriE4gyvjxyDWPAqqrWO', NULL, NULL),
	(3,'Neo','neo@plugga.com','{bcrypt}$2a$04$HmERLmZb.yg5WX3VUM0c0u7eF.ASN7SaTFf.2/XJo28FA1pQYGI6i', NULL, NULL),
	(4,'Matina','matina@plugga.com','{bcrypt}$2a$04$2LGkBB0JDWFbAmI13sjPau8zthlgstgx6oZcKHc6rWPHekfqesd9y', NULL, NULL),
	(5,'Bulbasaur','bulbasaur@plugga.com','{bcrypt}$2a$04$IeW.VCpSY7OwSCZxZYeN/Oy1b5ze3MIxCsIqKohQbaur/5btTmgki', NULL, NULL);


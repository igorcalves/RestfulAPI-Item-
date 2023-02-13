CREATE TABLE IF NOT EXISTS `itens` (
  `id` bigint AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `since` datetime(6) NOT NULL,
  `price` decimal(65,2) NOT NULL,
  PRIMARY KEY (`id`)
);
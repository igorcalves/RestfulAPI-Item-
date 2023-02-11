CREATE TABLE `users` (
  `id` bigint AUTO_INCREMENT PRIMARY KEY,
  `user_name` varchar(255) DEFAULT NULL UNIQUE ,
  `full_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `account_non_expired` bit DEFAULT NULL,
  `account_non_locked` bit DEFAULT NULL,
  `credentials_non_expired` bit DEFAULT NULL,
  `enabled` bit DEFAULT NULL
);

--rajesh
--these are i have generated from sql server

CREATE DATABASE `txn_db`;

-- txn_db.app_user definition
CREATE TABLE `app_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `user_role` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_3k4cplvh82srueuttfkwnylq0` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



-- txn_db.txn_details definition
CREATE TABLE `txn_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `amount_transaction` decimal(19,2) DEFAULT NULL,
  `bank_code` varchar(255) DEFAULT NULL,
  `card_acceptor_city` varchar(255) DEFAULT NULL,
  `card_acceptor_country_code` varchar(255) DEFAULT NULL,
  `card_acceptor_id` varchar(255) DEFAULT NULL,
  `card_acceptor_name` varchar(255) DEFAULT NULL,
  `card_acceptor_pin_code` varchar(255) DEFAULT NULL,
  `card_acceptor_state_code` varchar(255) DEFAULT NULL,
  `card_acceptor_street_address` varchar(255) DEFAULT NULL,
  `card_acceptor_tid` varchar(255) DEFAULT NULL,
  `card_number` varchar(255) DEFAULT NULL,
  `created_date_time` datetime(6) DEFAULT NULL,
  `expiry_date` datetime(6) DEFAULT NULL,
  `local_txn_date` datetime(6) DEFAULT NULL,
  `local_txn_time` time DEFAULT NULL,
  `mcc` varchar(255) DEFAULT NULL,
  `mti` varchar(255) DEFAULT NULL,
  `network` varchar(255) DEFAULT NULL,
  `ret_ref_number` varchar(255) DEFAULT NULL,
  `service_restriction_code` varchar(255) DEFAULT NULL,
  `stan` varchar(255) DEFAULT NULL,
  `token_identifier` varchar(255) DEFAULT NULL,
  `txn_currency_code` varchar(255) DEFAULT NULL,
  `txn_date_time` datetime(6) DEFAULT NULL,
  `txn_source` varchar(255) DEFAULT NULL,
  `txn_status` varchar(255) DEFAULT NULL,
  `unique_id` varchar(255) DEFAULT NULL,
  `updated_date_time` datetime(6) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5t07k5adq2jo2esing10ted0f` (`user_id`),
  CONSTRAINT `FK5t07k5adq2jo2esing10ted0f` FOREIGN KEY (`user_id`) REFERENCES `app_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
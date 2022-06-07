CREATE DATABASE IF NOT EXISTS ims;

USE ims;

DROP SCHEMA ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `customer_id` INT(11) UNIQUE NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `last_name` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`customer_id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`items` (
    `items_id` INT(11) NOT NULL AUTO_INCREMENT,
    `items_name` VARCHAR(40) DEFAULT NULL,
    `value` INT(40) NOT NULL,
    PRIMARY KEY (`items_id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orders` (
    fk_customer_id INT NOT NULL,
    order_id INT NOT NULL,
    PRIMARY KEY (order_id, fk_customer_id),
    FOREIGN KEY (fk_customer_id) REFERENCES customers(customer_id)
);

CREATE TABLE IF NOT EXISTS `ims`. `order_items` (
fk_order_id INT NOT NULL,
fk_items_id INT NOT NULL,
order_itemsID INT NOT NULL,

PRIMARY KEY (fk_order_id, fk_items_id, order_itemsID),
FOREIGN KEY (fk_order_id) REFERENCES orders(order_id),
FOREIGN KEY (fk_items_id) REFERENCES items(items_id)
);
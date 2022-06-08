DROP SCHEMA IF EXISTS ims;

CREATE SCHEMA IF NOT EXISTS ims;

USE ims ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
`id` INT(11) NOT NULL AUTO_INCREMENT,
`first_name` VARCHAR(40) DEFAULT NULL,
`surname` VARCHAR(40) DEFAULT NULL,
PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`items` (
    `itemsId` INT(11) NOT NULL AUTO_INCREMENT,
    `itemsname` VARCHAR(40) DEFAULT NULL,
    `value` INT(40) NOT NULL,
    PRIMARY KEY (`itemsId`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orders` (
    `fkId` INT(11) NOT NULL,
    `orderId` INT(11) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (orderId, fkId),
    FOREIGN KEY (fkId) REFERENCES customers(id)
);

CREATE TABLE IF NOT EXISTS `ims`. `order_items` (
`fkid` INT(11) NOT NULL AUTO_INCREMENT,
`fk_first_name` VARCHAR(40) DEFAULT NULL,
`fk_surname` VARCHAR(40) DEFAULT NULL,
`fk_orderId` INT(11) NOT NULL AUTO_INCREMENT,
`fk_itemsId` INT(11) NOT NULL AUTO_INCREMENT,
`order_items_id` INT UNIQUE NOT NULL,
`item_quantity` INT DEFAULT 1,
`total_cost` DECIMAL(12,2),

PRIMARY KEY (order_items_Id),
FOREIGN KEY (fkid) REFERENCES customers(id),
FOREIGN KEY (fk_first_name) REFERENCES customers(first_name),
FOREIGN KEY (fk_surname) REFERENCES customers(surname),
FOREIGN KEY (fk_orderId) REFERENCES orders(orderId),
FOREIGN KEY (fk_itemsId) REFERENCES items(itemsId)
);